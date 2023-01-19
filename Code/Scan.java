package Code;

import java.util.*;
import java.io.*;

public class Scan {
    private String fileDirectory;
    private int jobCount;

    public Scan(){
        this.fileDirectory = null;
        this.jobCount = 0;
    }

    public Scan(String fileDirectory){
        this.fileDirectory = fileDirectory;
        this.jobCount = 0;
    }

    public String getFileDir(){
        return this.fileDirectory;
    }

    public int getJobCount(){
        return this.jobCount;
    }

    public void display(){
        System.out.printf("The file in directory %s has %d jobs", getFileDir(), getJobCount());
    }
}

class ErrorJobScan extends Scan{ // scans file for question 3 metric
    
    
    public ErrorJobScan(){
        super();
    }

    public ErrorJobScan(String fileDirectory){
        super(fileDirectory);
    }

    public void compute
}

