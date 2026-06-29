package core_java_practice.gcr_codebase.BufferReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SchoolResultPortal {

    private static final String INPUT_FILE = "student_marks.txt";
    private static final String OUTPUT_FILE = "report_card.txt";

    public static void main(String[] args) {
        try {
            generateReport(INPUT_FILE, OUTPUT_FILE);
            System.out.println("Report appended to " + OUTPUT_FILE);
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + INPUT_FILE);
        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
        }
    }

    private static void generateReport(String inputPath, String outputPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath, true))) {

            writer.println("Student Result Report");
            writer.printf("%-20s %-10s %-10s %-10s %-10s%n", "Name", "Math", "Science", "English", "Average");
            writer.println("---------------------------------------------------------------");

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.err.println("Skipping invalid record: " + line);
                    continue;
                }

                try {
                    String name = parts[0].trim();
                    int math = Integer.parseInt(parts[1].trim());
                    int science = Integer.parseInt(parts[2].trim());
                    int english = Integer.parseInt(parts[3].trim());
                    double average = (math + science + english) / 3.0;

                    writer.printf("%-20s %-10d %-10d %-10d %-10.2f%n", name, math, science, english, average);
                    found = true;
                } catch (NumberFormatException e) {
                    System.err.println("Skipping record with invalid marks: " + line);
                }
            }

            if (!found) {
                writer.println("No valid student records found.");
            }
            writer.println();
        }
    }
}

