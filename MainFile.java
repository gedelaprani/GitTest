// Ishaan and Praneeth 12/3
import java.io.*;

public class MainFile {

    static class CapitalizeFileTask implements Runnable {
        private String inputFileName;
        private String outputFileName;

        public CapitalizeFileTask(String inputFileName, String outputFileName) {
            this.inputFileName = inputFileName;
            this.outputFileName = outputFileName;
        }

        public void run() {
            File inputFile = new File(inputFileName);
            File outputFile = new File(outputFileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line.toUpperCase());
                    writer.newLine();
                }

                System.out.println("Created file: " + outputFile.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(new CapitalizeFileTask("Bible.txt", "capitalized_output1.txt"));
        Thread thread2 = new Thread(new CapitalizeFileTask("WP.txt", "capitalized_output2.txt"));


        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Both files have been processed.");
        System.out.println("Time taken: " + duration + " milliseconds");
    }
}
