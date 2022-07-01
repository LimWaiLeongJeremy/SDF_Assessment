package assessment.task1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {
    
    public static void main(String[] args) {

       try{
            // Declare CSV & txt file path as a String
            String csvFilePath = args[0];
            String templateFilePath = args[1];

                    
            // readind txt files
            File ogFile = new File(templateFilePath);
            BufferedReader txtReader = new BufferedReader(new FileReader(ogFile));
            String txtLine = null;
            String oldContent1 = "__index1__";
            String oldContent2 = "__index2__";
            String oldContent3 = "__index3__";
            String oldContent4 = "__index4__";

            // reading csv files
            BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
            String csvLine = "";

            String[] tempArr;
            List<String> content;
                    
            while ((csvLine = csvReader.readLine()) != null) {
                tempArr = csvLine.split(",");
                content = new ArrayList<>(Arrays.asList(tempArr));   
            
                System.out.println();
                while ((txtLine = txtReader.readLine()) != null) {       
                    
                    for (int i = 1; i < content.size(); i++)
                    txtLine.replace(oldContent1, content.get(1));
                    txtLine.replace(oldContent2, content.get(2));
                    txtLine.replace(oldContent3, content.get(3));
                    txtLine.replace(oldContent4, content.get(4));

                    System.out.println(txtLine);
                    txtLine = txtReader.readLine();

                }    
            }
        csvReader.close();
        txtReader.close();

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (EOFException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}  
       