/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2.core;

/**
 * @param T
 * @author nim_13512501
 */
public class kFold implements OfflineLearningNominalDataClassifier {
    
    private int k;
    OfflineLearningNominalDataClassifier classifier;
    
    public kFold(int k, OfflineLearningNominalDataClassifier classifier){
        this.k = k;
        this.classifier=classifier.copy();
    }
    
    public kFold(kFold X){
        this.k=X.k;
        this.classifier=X.classifier.copy();
    }
    
    @Override
    public void train(int[] numInputCategory, int[][] inputCategory, int numOutputClass, int[] outputClass) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int predict(int[] inputCategory) throws Exception {
        return classifier.predict(inputCategory);
    }

    @Override
    public OfflineLearningNominalDataClassifier copy() {
        return new kFold(this);
    }

  
}
