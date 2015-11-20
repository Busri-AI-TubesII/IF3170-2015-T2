/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;

/**
 *
 * @author nim_13512501
 */
public class IF31702015T2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader reader = new BufferedReader(new FileReader("dataset/weather.nominal.arff"));
        ArffReader arff = new ArffReader(reader);
        Instances data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
        
        for(int i=0; i<data.numInstances(); i++){
            Instance instance = data.instance(i);
            for(int j=0; j<instance.numAttributes(); j++){
                System.out.print(instance.stringValue(j) + ",");
            }
            System.out.println();
        }
    }
    
}
