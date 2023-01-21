package code;

import java.util.*;

public class Main {
    public static void main(String[] args){ // e.g. D://FOP//SLURM-Log-Analysis//extracted_log
        // Declaring variables
        int input;
        String fileDirectory;
        Scanner in = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter directory of log file: "); // prompt for file location
        fileDirectory = in.nextLine();

        // Accessing statistics
        while(true){
            divider();
            System.out.print("1: Number of jobs created/ended within a specific time range\n2: Number of jobs by partition\n3: Number of jobs causing errors and the corresponding users\nSelect metric to view from file (type -1 to exit):");
            input = in.nextInt();
            if(input < 0){
                divider();
                in.close();
                System.out.println("\t** PROGRAM TERMINATED **");
                break;
            }
            switch(input){
                case 1: // To access metric 1: Number of jobs created/ended within a specific time range
                    divider();
                    NumberOfJobs metric1 = new NumberOfJobs(fileDirectory);
                    System.out.print("Select month to display statistic: ");
                    metric1.setMonth(in.nextInt());
                    divider();
                    metric1.display();
                    break;
                case 2: // To access metric 2: Number of jobs by partition
                    Partition metric2 = new Partition(fileDirectory);
                    metric2.display();
                    break;
                case 3: // To access metric 3: Number of jobs causing errors and the corresponding users
                    ErrorJobScan metric3 = new ErrorJobScan(fileDirectory);
                    metric3.display();
                    break;
                case 4:
                    break;
                default:
                    divider();
                    System.out.println("Please enter a valid command");
            }
        }
    }

    public static void divider(){ // prints a divider line between instructions
        for(int i = 0; i < 40; i++){
            System.out.print("-");
            if(i==39){System.out.println();}
        }
    }
}