/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 *
 * @author David Kwan
 */
public class FileLoader {
    // attributes[i][j] artinya mendapatkan attribut ke j dari instance i
    private String[][] attributes;
    private String[] labels;
    
    public FileLoader(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArffLoader.ArffReader arff = new ArffLoader.ArffReader(reader);
        Instances data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
        
        attributes = new String[data.numInstances()][data.numAttributes()-1];
        labels = new String[data.numInstances()];
        
        for(int i=0; i<data.numInstances(); i++){
            Instance instance = data.instance(i);
            for(int j=0; j<instance.numAttributes()-1; j++){
               attributes[i][j] = instance.stringValue(j);
            }
            labels[i] = instance.stringValue(instance.numAttributes()-1);
        }
    }
    
    public String[][] getAttributes(){
        return attributes;
    }
    
    public String[] getLabels(){
        return labels;
    }
}
