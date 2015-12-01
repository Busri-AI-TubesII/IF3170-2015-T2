/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2;

import test20November.ArffFileLoader;
import java.io.IOException;

/**
 *
 * @author nim_13512501
 */
public class IF31702015T2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ArffFileLoader fileloader = new ArffFileLoader("dataset/weather.nominal.arff");
        String[][] attributes = fileloader.getAttributes();
        String[] labels = fileloader.getLabels();
        
        // Output for testing
        System.out.println("Array of attributes:");
        for(int i=0; i<attributes.length; i++){
            for(int j=0; j<attributes[i].length; j++){
                System.out.print(attributes[i][j] + ",");
            }
            System.out.println();
        }
  
        System.out.println("Array of labels:");
        for(int i=0; i<labels.length; i++){
            System.out.println(labels[i]);
        }
    }
    
}
