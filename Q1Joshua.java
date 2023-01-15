import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Q1Joshua {
  public static void main(String[] args) {
    ArrayList<String> june_logs = new ArrayList<String>();
    // ArrayList<String> july_logs = new ArrayList<String>();
    // ArrayList<String> august_logs = new ArrayList<String>();
    // ArrayList<String> september_logs = new ArrayList<String>();
    // ArrayList<String> october_logs = new ArrayList<String>();
    // ArrayList<String> november_logs = new ArrayList<String>();
    // ArrayList<String> december_logs = new ArrayList<String>();

    readFile(june_logs, 06);
    System.out.println("Created jobs in june: " + countCreatedJobs(june_logs));
    System.out.println("Completed jobs in june: " + countEndedJobs(june_logs));
  }

  public static int countCreatedJobs(ArrayList<String> logs) {
    Pattern pattern = Pattern.compile("sched");
    int count = 0;

    for (String log : logs) {
      if (pattern.matcher(log).find()) {
        count++;
      }
    }
    return count;
  }

  public static int countEndedJobs(ArrayList<String> logs) {
    Pattern pattern = Pattern.compile("_job_complete");
    int count = 0;

    for (String log : logs) {
      if (pattern.matcher(log).find()) {
        count++;
      }
    }
    return count;
  }

  public static void readFile(ArrayList<String> logs, int month) {
    try {
      File logFile = new File("extracted_log");
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

}
