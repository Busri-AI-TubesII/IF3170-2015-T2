/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if3170.pkg2015.t2.core;

/**
 * sebuah OfflineLearningNominalDataClassifier.
 * Training dilakukan sekali (Offline).
 * tiap kali training, hipotesis/mesin ter-overwrite.
 * Abstraksi harus dilakukan di luar objek sedemikian hingga objek ini hanya
 * menerima dan mengeluarkan data nominal yang diwakili oleh bilangan 0,1,2, ...
 * @author nim_13512501
 */
public interface OfflineLearningNominalDataClassifier {
    /**
     * 
     * @param numInputCategory
     * @param inputCategory
     * @param numOutputClass
     * @param outputClass 
     * men-training. 
     * prekondisi (dicek di implementasi):
     * apabila numInputCategories berukuran N,
     * maka inputCategory harus berukuran MxN,
     * dan outputClass harus berukuran M.
     * 0<=inputCategory[i][j]<numInputCategories[j]
     * 0<=outputClass<numOutputClass
     */
    public void train(int[] numInputCategory, int[][] inputCategory, int numOutputClass, int[] outputClass) throws Exception;
    public int predict(int [] inputCategory) throws Exception;
}
