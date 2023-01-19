package Code;

import java.util.*;

public class Main {
    public static void main(String[] args){ // e.g. "D://FOP//SLURM-Log-Analysis//extracted_log"
        System.out.print("Enter directory of log file: ");
        Scanner in = new Scanner(System.in);
        String fileDirectory = in.nextLine();
        in.close();
        ErrorJobScan log = new ErrorJobScan(fileDirectory);
        log.display();
    }
}

// To use this program, make sure Main.java and Scan.java are in the same package
// Then, simply run the program and input the directory of the log file (e.g. D://FOP//SLURM-Log-Analysis//extracted_log)
// The program will output the total number of errors in the log, total number of users causing errors and the frequency of errors of each user