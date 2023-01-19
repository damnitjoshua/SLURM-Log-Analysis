package Code;

import java.util.*;
import java.io.*;

public class Scan {
    private String fileDirectory;

    public Scan(){
        this.fileDirectory = null;
    }

    public Scan(String fileDirectory){
        this.fileDirectory = fileDirectory;
    }

    public String getFileDir(){
        return this.fileDirectory;
    }

    public void display(){
        System.out.printf("The file in directory %s\n", getFileDir());
    }
}

class ErrorJobScan extends Scan{ // scans file for question 3 metric
    private ArrayList<String> lines = new ArrayList<>(); 
    private ArrayList<String> culprits = new ArrayList<>();
    private ArrayList<String> culpritsInfo = new ArrayList<>();

    public ErrorJobScan(){
        super();
    }

    public ErrorJobScan(String fileDirectory){
        super(fileDirectory);
    }

    public void readFile(){ // reads log and stores relevant rows of text/lines into an arraylist
        try{
            Scanner lineScanner = new Scanner(new FileInputStream(getFileDir()));
            for (String line = ""; line != null; line = lineScanner.nextLine()) {
                if (line.contains("error: This association")) {
                  lines.add(line);
                }
                if (!lineScanner.hasNextLine()){
                    break;
                }
              }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void processLine(){ // processes each line obtained from above method and returns how many errors new/existing users have caused
        // ** Getting usernames **
        String temp, result;
        temp = null;
        result = null;
        int amount = lines.get(0).split(" ").length;     
        String[][] temporary = new String[lines.size()][amount];
        for(int i = 0; i < lines.size(); i++){ // Extract user info from each line and store into a temporary arraylist   
            temporary[i] = lines.get(i).split(" ");
            for(int j = 0; j < amount; j++){
                if(temporary[i][j].contains("user=")){
                    temp = temporary[i][j];
                    StringBuffer target = new StringBuffer(temp);
                    result = target.substring(6,temp.length()-2);
                    culprits.add(result);
                }
            }
        }

        // ** Processing culprits info **
        int errorFrequency = 0;
        String target = null;
        Collections.sort(culprits);
        for(int i = 0; i < culprits.size(); i++){
            if(i==0){
                target = culprits.get(i);
                errorFrequency++;
            }
            else if(target.equalsIgnoreCase(culprits.get(i))){
                errorFrequency++;
            }
            else if(!target.equalsIgnoreCase(culprits.get(i))){
                culpritsInfo.add(target);
                culpritsInfo.add(Integer.toString(errorFrequency));
                target = culprits.get(i);
                errorFrequency = 1;
                if(i==culprits.size()-1){
                    culpritsInfo.add(target);
                    culpritsInfo.add(Integer.toString(errorFrequency));
                }
            }
        }
    }

    @Override
    public void display(){
        int count = 1;
        readFile();
        processLine();
        for(int i = 0; i < 40; i++){
            System.out.print("-");
            if(i==39){System.out.println();}
        }
        System.out.printf("The log contains %d jobs with errors caused by %d users\n", lines.size(), culpritsInfo.size()/2);
        for(int i = 0; i < 40; i++){
            System.out.print("-");
            if(i==39){System.out.println();}
        }
        System.out.printf("%-25s%-20s\n", "No   User", "Frequency of errors");
        for(int i = 0; i < 40; i++){
            System.out.print("-");
            if(i==39){System.out.println();}
        }
        for(int a = 0; a < culpritsInfo.size() - 1; a+=2){ // prints user info
            System.out.printf("%-5d%-20s%-20s\n", count++, culpritsInfo.get(a), culpritsInfo.get(a+1));
        }
        for(int i = 0; i < 40; i++){
            System.out.print("-");
            if(i==39){System.out.println();}
        }
    }
}

