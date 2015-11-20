/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2.core;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nim_13512501
 */
public class FileLoaderTest {
    
    public FileLoaderTest() {
    }

    @Test
    public void testWahaha() throws IOException{
        
         FileLoader FL = new FileLoader("dataset/weather.nominal.arff");
         String [][] inputCategory = FL.getAttributes();
         String [] outputClass = FL.getLabels();
         String [][] inputLegalValues = FL.getAttributesLegalValues();
         String [] outputLegalValues = FL.getLabelsLegalValues();
         
         for (int i=0;i<inputLegalValues.length;i++){
             System.out.print("attr " + i + ", vals:");
             for (int j=0;j<inputLegalValues[i].length;j++){
                 System.out.print(" "+inputLegalValues[i][j]);
             }
             System.out.println("\n");
         }
         
         System.out.print("labels vals: ");
         for (int i=0;i<outputLegalValues.length;i++){
             System.out.print(" " + outputLegalValues[i]);
         }
         
         for (int i=0;i<inputCategory.length;i++){
             System.out.print("instance "+i+", attrs:");
             for (int j=0;j<inputCategory[i].length;j++){
                 System.out.print(" "+inputCategory[i][j]);
             }
             System.out.println(", label: " + outputClass[i]);
         }
    }
}
