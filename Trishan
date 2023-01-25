package code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;  
import static javafx.application.Application.launch;
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.chart.CategoryAxis;  
import javafx.scene.chart.NumberAxis;  
import javafx.scene.chart.StackedBarChart;  
import javafx.scene.chart.XYChart;  
import javafx.stage.Stage;

public class Partition extends Application{     

    private static String fileDirectory;

    public Partition(){}

    public Partition(String a){
        fileDirectory = a;
    }

    public void display(){
        launch();
    }
   
@Override  
public void start(Stage stage) throws Exception {  
      
    CategoryAxis xaxis = new CategoryAxis();  
    NumberAxis yaxis = new NumberAxis(0,2500,100);  // Set the value for y-axis
    xaxis.setLabel("Months");                       // Label x-axis
    yaxis.setLabel("Total number of jobs");         //Label y-axis
      
    //Configuring StackedBarChart   
    StackedBarChart sb = new StackedBarChart(xaxis,yaxis);  
    sb.setTitle("Number of jobs by partitions");  
        
       ArrayList<String> EPYC = new ArrayList<String>();            //Setting the array list according to the partitons
        ArrayList<String> OPT = new ArrayList<String>();
         ArrayList<String> GK10 = new ArrayList<String>();
          ArrayList<String> GV100 = new ArrayList<String>();
           ArrayList<String> GTIT = new ArrayList<String>();
           ArrayList<String> GK40 = new ArrayList<String>();
        
           try {
            Scanner scanner = new Scanner(new FileInputStream(fileDirectory));
            // read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Partition=cpu-epyc" )) {
                    EPYC.add(line);                                         
                } else if (line.contains("Partition=cpu-opteron")) {
                   OPT.add(line);
                } else if (line.contains("Partition=gpu-k10")) {
                    GK10.add(line);
                }
                  else if (line.contains("Partition=gpu-v100s")) {
                     GV100.add(line);
                }
                  else if (line.contains("Partition=gpu-titan")) {
                     GTIT.add(line);
                }
                  else if (line.contains("Partition=gpu-k40c")) {
                     GK40.add(line); 
                }              
            }
            scanner.close();

        // The sorted array list using the partition will be send to their method to count according the months.
        ArrayList<Integer> CountEpyc  =Epyc(EPYC);
        ArrayList<Integer> CountOpt=Opt(OPT);
        ArrayList<Integer> CountGk10  =Gk10(GK10);
        ArrayList<Integer> CountGv100=Gv100(GV100);
        ArrayList<Integer> CountGtit  =Gtit(GTIT);
        ArrayList<Integer> CountGk40=Gk40(GK40);
        
          //Display all value
        display_value(CountEpyc,0);
        display_value(CountOpt,1);
        display_value(CountGk10,2);
        display_value(CountGv100,3);
        display_value(CountGtit,4);
        display_value(CountGk40,5);

    //Adding the value in the chart.    
    XYChart.Series epyc = new XYChart.Series<>();  
    epyc.setName("CPU-EPYC");  
    epyc.getData().add(new XYChart.Data<>("June",CountEpyc.get(0)));  
    epyc.getData().add(new XYChart.Data<>("July",CountEpyc.get(1)));  
    epyc.getData().add(new XYChart.Data<>("August",CountEpyc.get(2)));  
    epyc.getData().add(new XYChart.Data<>("September",CountEpyc.get(3)));  
    epyc.getData().add(new XYChart.Data<>("October",CountEpyc.get(4)));  
    epyc.getData().add(new XYChart.Data<>("November",CountEpyc.get(5)));  
    epyc.getData().add(new XYChart.Data<>("December",CountEpyc.get(6)));  
    sb.getData().add(epyc);  //Create the bar chart in the interface
      
      
    XYChart.Series opteron = new XYChart.Series<>();  
    opteron.setName("CPU-OPTERON");  
    opteron.getData().add(new XYChart.Data<>("June",CountOpt.get(0)));  
    opteron.getData().add(new XYChart.Data<>("July",CountOpt.get(1)));  
    opteron.getData().add(new XYChart.Data<>("August",CountOpt.get(2)));  
    opteron.getData().add(new XYChart.Data<>("September",CountOpt.get(3)));  
    opteron.getData().add(new XYChart.Data<>("October",CountOpt.get(4)));  
    opteron.getData().add(new XYChart.Data<>("November",CountOpt.get(5)));  
    opteron.getData().add(new XYChart.Data<>("December",CountOpt.get(6))); 
    sb.getData().add(opteron);  
     
    XYChart.Series gpu_k10 = new XYChart.Series<>(); 
    gpu_k10.setName("GPU-K10");  
    gpu_k10.getData().add(new XYChart.Data<>("June",CountGk10.get(0)));  
    gpu_k10.getData().add(new XYChart.Data<>("July",CountGk10.get(1)));  
    gpu_k10.getData().add(new XYChart.Data<>("August",CountGk10.get(2)));  
    gpu_k10.getData().add(new XYChart.Data<>("September",CountGk10.get(3)));  
    gpu_k10.getData().add(new XYChart.Data<>("October",CountGk10.get(4)));  
    gpu_k10.getData().add(new XYChart.Data<>("November",CountGk10.get(5)));  
    gpu_k10.getData().add(new XYChart.Data<>("December",CountGk10.get(6))); 
    sb.getData().add(gpu_k10); 
    
    XYChart.Series gpu_v100s = new XYChart.Series<>(); 
    gpu_v100s.setName("GPU-V100S  ");  
    gpu_v100s.getData().add(new XYChart.Data<>("June",CountGv100.get(0)));  
    gpu_v100s.getData().add(new XYChart.Data<>("July",CountGv100.get(1)));  
    gpu_v100s.getData().add(new XYChart.Data<>("August",CountGv100.get(2)));  
    gpu_v100s.getData().add(new XYChart.Data<>("September",CountGv100.get(3)));  
    gpu_v100s.getData().add(new XYChart.Data<>("October",CountGv100.get(4)));  
    gpu_v100s.getData().add(new XYChart.Data<>("November",CountGv100.get(5)));  
    gpu_v100s.getData().add(new XYChart.Data<>("December",CountGv100.get(6))); 
    sb.getData().add(gpu_v100s);
    
    XYChart.Series gpu_titan = new XYChart.Series<>(); 
    gpu_titan.setName("GPU-TITAN");  
    gpu_titan.getData().add(new XYChart.Data<>("June",CountGtit.get(0)));  
    gpu_titan.getData().add(new XYChart.Data<>("July",CountGtit.get(1)));  
    gpu_titan.getData().add(new XYChart.Data<>("August",CountGtit.get(2)));  
    gpu_titan.getData().add(new XYChart.Data<>("September",CountGtit.get(3)));  
    gpu_titan.getData().add(new XYChart.Data<>("October",CountGtit.get(4)));  
    gpu_titan.getData().add(new XYChart.Data<>("November",CountGtit.get(5)));  
    gpu_titan.getData().add(new XYChart.Data<>("December",CountGtit.get(6))); 
    sb.getData().add(gpu_titan); 
    
    XYChart.Series gpu_k40c = new XYChart.Series<>(); 
    gpu_k40c.setName("GPU-K40");  
    gpu_k40c.getData().add(new XYChart.Data<>("June",CountGk40.get(0)));  
    gpu_k40c.getData().add(new XYChart.Data<>("July",CountGk40.get(1)));  
    gpu_k40c.getData().add(new XYChart.Data<>("August",CountGk40.get(2)));  
    gpu_k40c.getData().add(new XYChart.Data<>("September",CountGk40.get(3)));  
    gpu_k40c.getData().add(new XYChart.Data<>("October",CountGk40.get(4)));  
    gpu_k40c.getData().add(new XYChart.Data<>("November",CountGk40.get(5)));  
    gpu_k40c.getData().add(new XYChart.Data<>("December",CountGk40.get(6))); 
    sb.getData().add(gpu_k40c);
    
    Scene scene = new Scene(sb,750,700);    //Setting the window size of the graph
    stage.setScene(scene);  
    stage.setTitle("Number of jobs by partition in Stacked Bar Chart");  
    stage.show();           //Display the graph
      
}  
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
}

public void display_value(ArrayList<Integer> display_all,int num){
    
    String[] month = {"June", "July", "August", "September","October","November","December"};
    String[] partition = {"CPU-EPYC", "CPU-OPTERON", "GPU-K10", "GPU-V100S","GPU-TITAN","GPU-K40"};
    int total=0;
    System.out.println("Number of "+partition[num]);
    System.out.println("**************************");
    for(int a=0;a<7;a++){
         System.out.println(month[a]+": "+display_all.get(a));
         total+=display_all.get(a);
    }
     System.out.println("\nTotal: "+total);
    System.out.println();

}
//To filter EPYC by month
public static ArrayList<Integer> Epyc(ArrayList<String> Num){ 
     
    ArrayList<Integer> final_epyc = new ArrayList<Integer>();
    
    int june_epyc = 0;
     int july_epyc = 0;
     int aug_epyc = 0;
     int sep_epyc = 0;
     int oct_epyc = 0;
     int nov_epyc = 0;
     int dec_epyc = 0;
 
     for (String time : Num){
         if (time.contains("[2022-06")){
                    june_epyc++;     
         } 
         else if (time.contains("[2022-07")){
                    july_epyc++;     
         }
         else if (time.contains("[2022-08")){
                    aug_epyc++;     
         } 
         else if (time.contains("[2022-09")){
                    sep_epyc++;     
         }
         else if (time.contains("[2022-10")){
                    oct_epyc++;     
         } 
         else if (time.contains("[2022-11")){
                    nov_epyc++;     
         }
         else if (time.contains("[2022-12")){
                    dec_epyc++;     
         } 
         
      }
            final_epyc.add(june_epyc); 
            final_epyc.add(july_epyc);
            final_epyc.add(aug_epyc);
            final_epyc.add(sep_epyc);
            final_epyc.add(oct_epyc);
            final_epyc.add(nov_epyc);
            final_epyc.add(dec_epyc);
           
        return final_epyc;}

//To filter Opt by month
public static ArrayList<Integer> Opt(ArrayList<String> Num){ 
     
    ArrayList<Integer> final_opt = new ArrayList<Integer>();
    
    int june_opt = 0;
     int july_opt = 0;
     int aug_opt = 0;
     int sep_opt = 0;
     int oct_opt = 0;
     int nov_opt = 0;
     int dec_opt = 0;
 
     for (String time : Num){
         if (time.contains("[2022-06")){
                    june_opt++;     
         } 
         else if (time.contains("[2022-07")){
                    july_opt++;     
         }
         else if (time.contains("[2022-08")){
                    aug_opt++;     
         } 
         else if (time.contains("[2022-09")){
                    sep_opt++;     
         }
         else if (time.contains("[2022-10")){
                    oct_opt++;     
         } 
         else if (time.contains("[2022-11")){
                    nov_opt++;     
         }
         else if (time.contains("[2022-12")){
                    dec_opt++;     
         } 
         
      }
            final_opt.add(june_opt); 
            final_opt.add(july_opt);
            final_opt.add(aug_opt);
            final_opt.add(sep_opt);
            final_opt.add(oct_opt);
            final_opt.add(nov_opt);
            final_opt.add(dec_opt);
            
        return final_opt;}

//To filter Gk10 by month
public static ArrayList<Integer> Gk10(ArrayList<String> Num){ 
     
    ArrayList<Integer> final_gk10 = new ArrayList<Integer>();
    
    int june_gk10 = 0;
     int july_gk10  = 0;
     int aug_gk10  = 0;
     int sep_gk10  = 0;
     int oct_gk10  = 0;
     int nov_gk10  = 0;
     int dec_gk10  = 0;
 
     for (String time : Num){
         if (time.contains("[2022-06")){
                    june_gk10 ++;     
         } 
         else if (time.contains("[2022-07")){
                    july_gk10 ++;     
         }
         else if (time.contains("[2022-08")){
                    aug_gk10++;     
         } 
         else if (time.contains("[2022-09")){
                    sep_gk10 ++;     
         }
         else if (time.contains("[2022-10")){
                    oct_gk10 ++;     
         } 
         else if (time.contains("[2022-11")){
                    nov_gk10 ++;     
         }
         else if (time.contains("[2022-12")){
                    dec_gk10 ++;     
         }       
      }
            final_gk10.add(june_gk10); 
            final_gk10.add(july_gk10);
            final_gk10.add(aug_gk10);
            final_gk10.add(sep_gk10);
            final_gk10.add(oct_gk10);
            final_gk10.add(nov_gk10);
            final_gk10.add(dec_gk10);
           
        return final_gk10;}

//To filter Gv100 by month
public static ArrayList<Integer> Gv100(ArrayList<String> Num){ 
     
    ArrayList<Integer> final_gv100 = new ArrayList<Integer>();
    
    int june_gv100 = 0;
     int july_gv100 = 0;
     int aug_gv100 = 0;
     int sep_gv100 = 0;
     int oct_gv100 = 0;
     int nov_gv100 = 0;
     int dec_gv100 = 0;
 
     for (String time : Num){
         if (time.contains("[2022-06")){
                    june_gv100++;     
         } 
         else if (time.contains("[2022-07")){
                    july_gv100++;     
         }
         else if (time.contains("[2022-08")){
                    aug_gv100++;     
         } 
         else if (time.contains("[2022-09")){
                    sep_gv100++;     
         }
         else if (time.contains("[2022-10")){
                    oct_gv100++;     
         } 
         else if (time.contains("[2022-11")){
                    nov_gv100++;     
         }
         else if (time.contains("[2022-12")){
                    dec_gv100++;     
         } 
         
      }
            final_gv100.add(june_gv100); 
            final_gv100.add(july_gv100);
            final_gv100.add(aug_gv100);
            final_gv100.add(sep_gv100);
            final_gv100.add(oct_gv100);
            final_gv100.add(nov_gv100);
            final_gv100.add(dec_gv100);
            
        return final_gv100;}

//To filter GTitan by month
public static ArrayList<Integer> Gtit(ArrayList<String> Num){ 
     
    ArrayList<Integer> final_gtit = new ArrayList<Integer>();
    
    int june_gtit = 0;
     int july_gtit  = 0;
     int aug_gtit  = 0;
     int sep_gtit  = 0;
     int oct_gtit  = 0;
     int nov_gtit  = 0;
     int dec_gtit  = 0;
 
     for (String time : Num){
         if (time.contains("[2022-06")){
                    june_gtit ++;     
         } 
         else if (time.contains("[2022-07")){
                    july_gtit ++;     
         }
         else if (time.contains("[2022-08")){
                    aug_gtit++;     
         } 
         else if (time.contains("[2022-09")){
                    sep_gtit ++;     
         }
         else if (time.contains("[2022-10")){
                    oct_gtit ++;     
         } 
         else if (time.contains("[2022-11")){
                    nov_gtit ++;     
         }
         else if (time.contains("[2022-12")){
                    dec_gtit ++;     
         }       
      }
            final_gtit.add(june_gtit); 
            final_gtit.add(july_gtit);
            final_gtit.add(aug_gtit);
            final_gtit.add(sep_gtit);
            final_gtit.add(oct_gtit);
            final_gtit.add(nov_gtit);
            final_gtit.add(dec_gtit);
           
        return final_gtit;}

//To filter Gk40c by month
public static ArrayList<Integer> Gk40(ArrayList<String> Num){ 
     
    ArrayList<Integer> final_gk40 = new ArrayList<Integer>();
    
    int june_gk40 = 0;
     int july_gk40 = 0;
     int aug_gk40 = 0;
     int sep_gk40 = 0;
     int oct_gk40 = 0;
     int nov_gk40 = 0;
     int dec_gk40 = 0;
 
     for (String time : Num){
         if (time.contains("[2022-06")){
                    june_gk40++;     
         } 
         else if (time.contains("[2022-07")){
                    july_gk40++;     
         }
         else if (time.contains("[2022-08")){
                    aug_gk40++;     
         } 
         else if (time.contains("[2022-09")){
                    sep_gk40++;     
         }
         else if (time.contains("[2022-10")){
                    oct_gk40++;     
         } 
         else if (time.contains("[2022-11")){
                    nov_gk40++;     
         }
         else if (time.contains("[2022-12")){
                    dec_gk40++;     
         } 
         
      }
            final_gk40.add(june_gk40); 
            final_gk40.add(july_gk40);
            final_gk40.add(aug_gk40);
            final_gk40.add(sep_gk40);
            final_gk40.add(oct_gk40);
            final_gk40.add(nov_gk40);
            final_gk40.add(dec_gk40);
            
        return final_gk40;}
} 

