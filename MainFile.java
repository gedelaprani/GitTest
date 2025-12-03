//Ishaan and Praneeth 12/3
import java.io.*;

public class MainFile {
    public static void main(String[] args) {
        File inputFile = new File("Bible.txt");
        File outputFile = new File("capitalized_output1.txt"); // created behind the scenes

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());  // capitalize all letters
                writer.newLine();
            }

            System.out.println("Created file: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File inputFile2 = new File("WP.txt");
        File outputFile2 = new File("capitalized_output2.txt"); // created behind the scenes

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile2))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());  // capitalize all letters
                writer.newLine();
            }

            System.out.println("Created file: " + outputFile2.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
