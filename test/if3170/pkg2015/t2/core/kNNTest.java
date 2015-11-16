/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2.core;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nim_13512501
 */
public class kNNTest {
    
    public kNNTest() {
    }


    @Test
    public void testPredict1() throws Exception {
        OfflineLearningNominalDataClassifier classifier = new kNN(1);
        int[] numInputCategory = {2,3};
        int[][] inputCategory = { {0,0}, {1,1}, {1,2} };
        int numOutputClass = 3;
        int[] outputClass = {0,1,2};
        classifier.train(numInputCategory, inputCategory, numOutputClass, outputClass);
        for (int i=0;i<3;i++){
            assertEquals(outputClass[i],classifier.predict(inputCategory[i]));
        }
    }
    
    
    /**
     * test ini diambil dari soal UAS IF3170 Sem I 2015/2016 untuk kNN.
     * abstraksi:
     * yellow: 0, purple: 1
     * small: 0, large: 1
     * stretch: 0, dip: 1
     * adult: 0, child: 1
     * T: 1, F: 0
     * output yang diharapkan berdasarkan kunci jawaban
     * @throws Exception 
     */
    @Test
    public void testPredictDariSoalUAS() throws Exception{
        OfflineLearningNominalDataClassifier classifier = new kNN(5);
        int[] numInputCategory = {2,2,2,2};
        int[][] inputCategory = {
            {0,0,0,0},
            {0,0,0,1},
            {0,0,1,0},
            {0,0,1,1},
            {0,1,0,1},
            {0,1,1,0},
            {0,1,1,1},
            {1,0,0,0},
            {1,0,0,1},
            {1,0,1,1},
            {1,1,0,0},
            {1,1,0,1},
            {1,1,1,0},
            {1,1,1,1}            
        };
        int numOutputClass = 2;
        int[] outputClass = {1,0,0,0,0,0,0,1,0,0,1,0,0,0};
        classifier.train(numInputCategory, inputCategory, numOutputClass, outputClass);
        
        int [][] testin = {{0,1,0,0},{1,0,1,0}};
        int [] testout={0,0};
        
        for (int i=0; i< testin.length;i++){
            assertEquals(testout[i],classifier.predict(testin[i]));
        }
        
    }
    
}
