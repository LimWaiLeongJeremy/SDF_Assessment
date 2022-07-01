package assessment.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class App {
    
    public static void main(String[] args) throws Exception {
       
        // Declare CSV & txt file path as a String
        String csvFilePath = "/Users/jeremy/Desktop/asseesment/task.1/thankyou.csv";
        String templateFilePath = "/Users/jeremy/Desktop/asseesment/task.1/thankyou.txt";

        // reading csv files
        BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
        String csvLine = "";

        String[] tempArr;
        List<String> values;
                
        while ((csvLine = csvReader.readLine()) != null) {
            tempArr = csvLine.split(",");
            values = new ArrayList<>(Arrays.asList(tempArr));
        
        
        // System.out.println(values.get(1));
        }
        csvReader.close();

        // readind txt files
        File ogFile = new File(templateFilePath);
        String oldContent = "";
        BufferedReader txtReader = new BufferedReader(new FileReader(ogFile));
        String line = txtReader.readLine();

        while (line != null)
        {
                oldContent = oldContent + line + System.lineSeparator();
                line = txtReader.readLine();
        }
        System.out.println(line);

        txtReader.close();



    
    }
}  
       