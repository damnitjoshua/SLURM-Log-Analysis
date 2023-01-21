package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class NumberOfJobs {
  private String fileDirectory;
  private int month;

  public NumberOfJobs(){
    this.fileDirectory = null;
    this.month = 0;
  }

  public NumberOfJobs(String fileDirectory){
    this.fileDirectory = fileDirectory;
    this.month = 0;
  }

  //   ArrayList<String> june_logs = new ArrayList<String>();

  //   readFile(june_logs, 06);
  //   System.out.println("Created jobs in june: " + countCreatedJobs(june_logs));
  //   System.out.println("Completed jobs in june: " + countEndedJobs(june_logs));

  public int countCreatedJobs(ArrayList<String> logs) {
    Pattern pattern = Pattern.compile("sched");
    int count = 0;

    for (String log : logs) {
      if (pattern.matcher(log).find()) {
        count++;
      }
    }
    return count;
  }

  public int countEndedJobs(ArrayList<String> logs) {
    Pattern pattern = Pattern.compile("_job_complete");
    int count = 0;

    for (String log : logs) {
      if (pattern.matcher(log).find()) {
        count++;
      }
    }
    return count;
  }

  public void readFile(ArrayList<String> logs, int month) {
    try {
      File logFile = new File(this.fileDirectory);
      BufferedReader reader = new BufferedReader(new FileReader(logFile));

      // year - month - day
      Pattern datePattern = Pattern.compile("\\d{4}-0" + month + "-\\d{2}");

      for (String line = ""; line != null; line = reader.readLine()) {
        if (datePattern.matcher(line).find()) {
          logs.add(line);
        }
      }

      reader.close();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public void display(){
    ArrayList<String> logs = new ArrayList<>();
    readFile(logs, month);
    System.out.println("Created jobs: " + countCreatedJobs(logs));
    System.out.println("Completed jobs: " + countEndedJobs(logs));
  }

  public void setMonth(int month){
    this.month = month;
  }
}
