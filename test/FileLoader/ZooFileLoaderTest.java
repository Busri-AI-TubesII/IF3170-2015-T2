/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileLoader;

import java.io.FileNotFoundException;
import java.text.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nim_13512501
 */
public class ZooFileLoaderTest {
    
    public ZooFileLoaderTest() {
    }

    @Test
    public void testTolol() throws FileNotFoundException, ParseException {
        FileLoader f = new ZooFileLoader("dataset/zoo.data");
        
        String [][] attributes = f.getAttributes();
        String [] labels = f.getLabels();
        String [][] attrLegVal = f.getAttributesLegalValues();
        String [] labelLegVal = f.getLabelsLegalValues();
        
        System.out.println("attrLegVal");
        for (int i=0;i<attrLegVal.length;i++){
            System.out.println("");
            for (String s: attrLegVal[i])
                System.out.print(" " + s);
        }
        
        System.out.println("labelLegVals");
        for (String s: labelLegVal)
            System.out.print(" " + s);
        System.out.println("");
        
        System.out.println("attributes");
        for (int i=0;i<attributes.length;i++){
            for (int j=0;j<attributes[i].length;j++)
                System.out.print(" " + attributes[i][j]);
            System.out.println("");
        }
        
        System.out.println("labels");
        for (String s: labels)
            System.out.print(" " + s);
        System.out.println("");
                
    }
    
}
