import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JobCountByPartition {

    public static void main(String[] args) {
        // specify the file path
        String fileName = "extractedlog.txt";
        File file = new File(fileName);

        try {
            // create a new scanner object to read the file
            Scanner scanner = new Scanner(file);

            // initialize counters for each partition
            int epycCount = 0;
            int opteronCount = 0;
            int gpuk10Count = 0;
            int gpuv100sCount = 0;

            // read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Partition=cpu-epyc")) {
                    epycCount++;
                } else if (line.contains("Partition=cpu-opteron")) {
                    opteronCount++;
                } else if (line.contains("Partition=gpu-k10")) {
                    gpuk10Count++;
                }
                  else if (line.contains("Partition=gpu-v100s")) {
                    gpuv100sCount++;
                }
                
            }

            // print the count of jobs submitted to each partition
            System.out.println("Number of jobs submitted to epyc partition: " + epycCount);
            System.out.println("Number of jobs submitted to opteron partition: " + opteronCount);
            System.out.println("Number of jobs submitted to gpu k-10 partition: " + gpuk10Count);
            System.out.println("Number of jobs submitted to gpu v-100s partition: " + gpuv100sCount);
            

            // close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}

