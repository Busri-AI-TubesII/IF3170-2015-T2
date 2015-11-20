/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2.core;

import java.util.Arrays;

/**
 *
 * @author nim_13512501
 */
public class ClassifierwithStringData {
    private OfflineLearningNominalDataClassifier classifier;
    private String [][] inputString;
    private String [] outputString;
    
    ClassifierwithStringData (OfflineLearningNominalDataClassifier classifier){
        this.classifier = classifier;
    }
    
    public void setInputString(String[][] inputString){
        this.inputString = new String[inputString.length][];
        for (int i=0;i<inputString.length;i++){
            this.inputString[i]=inputString[i].clone();
        }
    }
    public void setOutputString(String[] outputString){
        this.outputString=outputString.clone();
    }
    public void setClassifier(OfflineLearningNominalDataClassifier classifier){
        this.classifier = classifier;
    }
    public void train(String[][] inputCategory, String[] outputClass) throws Exception{
        //create array of dataset for training
        int [][] inputCategoryInt = new int[inputCategory.length][];
        for (int i=0;i<inputCategory.length;i++){
            inputCategoryInt[i] = new int [inputCategory[i].length];
            for (int j=0;j<inputCategory[i].length;j++){
                inputCategoryInt[i][j]=Arrays.binarySearch(inputString[i], inputCategory[i][j]);
            }
        }
        int [] outputClassInt = new int[outputClass.length];
        for (int i=0; i<outputClass.length;i++){
            outputClassInt[i]=Arrays.binarySearch(outputString, outputClass[i]);
        }
        int [] numInputCategory = new int[inputString.length];
        for (int i=0;i<inputString.length;i++){
            numInputCategory[i] = inputString[i].length;
        }
        
        //train classifier
        classifier.train(numInputCategory,inputCategoryInt,outputString.length,outputClassInt);
    }
    
    public String predict(String [] inputString) throws Exception{
        int [] inputInt = new int[inputString.length];
        for (int i=0;i<inputString.length;i++){
            inputInt[i] = Arrays.binarySearch(this.inputString[i], inputString[i]);
        }
        int classInt= classifier.predict(inputInt);
        return outputString[classInt];
    }
    
}
