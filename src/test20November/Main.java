/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test20November;

import if3170.pkg2015.t2.core.ClassifierwithStringData;
import if3170.pkg2015.t2.core.NaiveBayes;
import if3170.pkg2015.t2.core.kFold;
import if3170.pkg2015.t2.core.kNN;
import java.io.IOException;

/**
 *
 * @author nim_13512501
 */
public class Main {
    public static void printConfusionMatrix(String [] labels, int [][] confusionMatrix){
        System.out.print("\t");
        for (int i=0;i<labels.length;i++){
            System.out.print(labels[i]+"\t");
        }
        System.out.println("<-- classified as");
        for (int i=0;i<labels.length;i++){
            for (int j=0;j<labels.length;j++){
                System.out.print("\t"+confusionMatrix[i][j]);
            }
            System.out.println("\t"+"| "+ labels[i]);
        }
        System.out.println("");
    }
     public static void main(String[] args) throws IOException, Exception {
         ArffFileLoader FL = new ArffFileLoader("dataset/weather.nominal.arff");
         System.out.println("test 5-NN full training");
         ClassifierwithStringData cl5NN = new ClassifierwithStringData(new kNN(5));
         cl5NN.setInputString(FL.getAttributesLegalValues());
         cl5NN.setOutputString(FL.getLabelsLegalValues());
         cl5NN.train(FL.getAttributes(), FL.getLabels());
         System.out.println("     accuracy: "+ cl5NN.accuracy(FL.getAttributes(), FL.getLabels()));
         System.out.println("\tconfusion matrix:");
         printConfusionMatrix(cl5NN.getOutputString(),cl5NN.calculateConfusionMatrix(FL.getAttributes(), FL.getLabels()));
         
         
         System.out.println("test Naive Bayes full training");
         ClassifierwithStringData NaiveBayesfull = new ClassifierwithStringData(new NaiveBayes());
         NaiveBayesfull.setInputString(FL.getAttributesLegalValues());
         NaiveBayesfull.setOutputString(FL.getLabelsLegalValues());
         NaiveBayesfull.train(FL.getAttributes(), FL.getLabels());
         System.out.println("     accuracy: "+ NaiveBayesfull.accuracy(FL.getAttributes(), FL.getLabels()));
         System.out.println("\tconfusion matrix:");
         printConfusionMatrix(NaiveBayesfull.getOutputString(),NaiveBayesfull.calculateConfusionMatrix(FL.getAttributes(), FL.getLabels()));
         
         
         System.out.println("test 5-NN 10-fold");
         ClassifierwithStringData cl5NN10fold = new ClassifierwithStringData(new kFold(10,new kNN(5)));
         cl5NN10fold.setInputString(FL.getAttributesLegalValues());
         cl5NN10fold.setOutputString(FL.getLabelsLegalValues());
         cl5NN10fold.train(FL.getAttributes(), FL.getLabels());
         System.out.println("     accuracy: "+ cl5NN10fold.accuracy(FL.getAttributes(), FL.getLabels()));
         System.out.println("\tconfusion matrix:");
         printConfusionMatrix(cl5NN10fold.getOutputString(),cl5NN10fold.calculateConfusionMatrix(FL.getAttributes(), FL.getLabels()));
         
         
         System.out.println("test Naive Bayes 10-fold");
         ClassifierwithStringData NaiveBayes10fold = new ClassifierwithStringData(new kFold(10,new NaiveBayes()));
         NaiveBayes10fold.setInputString(FL.getAttributesLegalValues());
         NaiveBayes10fold.setOutputString(FL.getLabelsLegalValues());
         NaiveBayes10fold.train(FL.getAttributes(), FL.getLabels());
         System.out.println("     accuracy: "+ NaiveBayes10fold.accuracy(FL.getAttributes(), FL.getLabels()));
         printConfusionMatrix(NaiveBayes10fold.getOutputString(),NaiveBayes10fold.calculateConfusionMatrix(FL.getAttributes(), FL.getLabels()));
     }
}
