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
public class kNNStringTest {
    
    public kNNStringTest() {
    }


    
    
    /**
     * test ini diambil dari soal UTS IF3170 Sem I 2015/2016 untuk kNN.
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
    public void testPredictDariSoalUTS() throws Exception{
        
        ClassifierwithStringData classifier = new ClassifierwithStringData(new kNN(5));
        String[][] inputString = {
            {"yellow", "purple"},
            {"small", "large"},
            {"stretch", "dip"},
            {"adult", "child"}
        };
        String[] outputString = {"F", "T"};
        String[][] inputCategory = {
            {"yellow","small","stretch","adult"},
            {"yellow","small","stretch","child"},
            {"yellow","small","dip","adult"},
            {"yellow","small","dip","child"},
            {"yellow","large","stretch","child"},
            {"yellow","large","dip","adult"},
            {"yellow","large","dip","child"},
            {"purple","small","stretch","adult"},
            {"purple","small","stretch","child"},
            {"purple","small","dip","child"},
            {"purple","large","stretch","adult"},
            {"purple","large","stretch","child"},
            {"purple","large","dip","adult"},
            {"purple","large","dip","child"}            
        };
        String[] outputClass = {"T","F","F","F","F","F","F","T","F","F","T","F","F","F"};
        classifier.setInputString(inputString);
        classifier.setOutputString(outputString);
        classifier.train(inputCategory,outputClass);
        
        String [][] testin = {{"yellow","large","stretch","adult"},{"purple","large","dip","adult"}};
        String [] testout={"F","F"};
        
        for (int i=0; i< testin.length;i++){
            assertEquals(testout[i],classifier.predict(testin[i]));
        }
        
        System.out.println("accuracy: " + classifier.accuracy(inputCategory, outputClass));
        
    }
    
}
