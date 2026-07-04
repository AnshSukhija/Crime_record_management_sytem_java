package com.crimeapp;
import java.io.*;
import java.util.*;
public class FileHandler {
    private static final String FILE_NAME = "crimerecords.txt";
    public void saveRecord(CrimeRecord record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(record.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error saving record: " + e.getMessage());
        }
    }
    public List<CrimeRecord> loadRecords() {
        List<CrimeRecord> records = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return records; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    String type = parts[1];
                    String location = parts[2];
                    String date = parts[3];
                    String status = parts[4];
                    CrimeRecord record = new CrimeRecord(name, type, location, date, status);
                    records.add(record);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading records: " + e.getMessage());
        }

        return records;
    }
    public void saveAll(List<CrimeRecord> records) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (CrimeRecord r : records) {
                bw.write(r.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving all records: " + e.getMessage());
        }
    }
}
