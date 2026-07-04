package com.crimeapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
public class CrimeDashboardGUI extends JFrame {
    private FileHandler fileHandler;
    private List<CrimeRecord> records;
    private JTextArea displayArea;
    public CrimeDashboardGUI() {
        setTitle("Crime Record Dashboard");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        fileHandler = new FileHandler();
        records = fileHandler.loadRecords();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1, 10, 10));  
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton addBtn = new JButton("➕ Add Record");
        JButton viewBtn = new JButton("📋 View All");
        JButton deleteBtn = new JButton("🗑️ Delete");
        JButton markBtn = new JButton("✅ Mark Resolved");
        JButton activeBtn = new JButton("🔥 View Active");
        JButton predictBtn = new JButton("🔮 Predict Crime Area");
        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);
        for (JButton btn : new JButton[]{addBtn, viewBtn, deleteBtn, markBtn, activeBtn, predictBtn}) {
            btn.setFont(btnFont);
            btn.setBackground(new Color(52, 152, 219));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }
        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(markBtn);
        buttonPanel.add(activeBtn);
        buttonPanel.add(predictBtn);
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(buttonPanel, BorderLayout.WEST);   
        add(scrollPane, BorderLayout.CENTER);  
        addBtn.addActionListener(e -> addRecord());
        viewBtn.addActionListener(e -> viewAll());
        deleteBtn.addActionListener(e -> deleteRecord());
        markBtn.addActionListener(e -> markResolved());
        activeBtn.addActionListener(e -> viewActive());
        predictBtn.addActionListener(e -> predictCrimeArea());
    }

    private void addRecord() {
        String name = JOptionPane.showInputDialog(this, "Enter Criminal Name:");
        if (name == null || name.isBlank()) return;
        String type = JOptionPane.showInputDialog(this, "Enter Crime Type:");
        String location = JOptionPane.showInputDialog(this, "Enter Location:");
        String date = JOptionPane.showInputDialog(this, "Enter Date (DD-MM-YYYY):");
        String status = JOptionPane.showInputDialog(this, "Enter Status (Active/Resolved):");
        CrimeRecord record = new CrimeRecord(name, type, location, date, status);
        records.add(record);
        fileHandler.saveRecord(record);
        JOptionPane.showMessageDialog(this, "✅ Record added successfully!");
    }
    private void viewAll() {
        displayArea.setText("");
        if (records.isEmpty()) {
            displayArea.append("No records found.\n");
            return;
        }
        for (CrimeRecord r : records) {
            displayArea.append(r.getCriminalName() + " | " + r.getCrimeType() + " | " +
                    r.getLocation() + " | " + r.getDate() + " | " + r.getStatus() + "\n");
        }
    }

    private void deleteRecord() {
        String name = JOptionPane.showInputDialog(this, "Enter name to delete:");
        if (name == null || name.isBlank()) return;

        boolean found = records.removeIf(r -> r.getCriminalName().equalsIgnoreCase(name));
        if (found) {
            fileHandler.saveAll(records);
            JOptionPane.showMessageDialog(this, "✅ Record deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "❌ No record found!");
        }
    }

    private void markResolved() {
        String name = JOptionPane.showInputDialog(this, "Enter name to mark resolved:");
        if (name == null || name.isBlank()) return;

        boolean found = false;
        for (CrimeRecord r : records) {
            if (r.getCriminalName().equalsIgnoreCase(name)) {
                r.setStatus("Resolved");
                found = true;
                break;
            }
        }

        if (found) {
            fileHandler.saveAll(records);
            JOptionPane.showMessageDialog(this, "✅ Case marked as resolved!");
        } else {
            JOptionPane.showMessageDialog(this, "❌ Record not found!");
        }
    }
    private void viewActive() {
        displayArea.setText("");
        boolean anyActive = false;
        for (CrimeRecord r : records) {
            if (r.getStatus().equalsIgnoreCase("Active")) {
                displayArea.append(r.getCriminalName() + " | " + r.getCrimeType() + " | " +
                        r.getLocation() + " | " + r.getDate() + " | " + r.getStatus() + "\n");
                anyActive = true;
            }
        }
        if (!anyActive) displayArea.append("No active cases found.\n");
    }
    private void predictCrimeArea() {
        String result = CrimeAnalyzer.getMostCrimeProneArea(records);
        JOptionPane.showMessageDialog(this, "📊 Most Crime-Prone Area:\n" + result);
    }
}
