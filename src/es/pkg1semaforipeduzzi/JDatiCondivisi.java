/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pkg1semaforipeduzzi;

/**
 *
 * @author peduzzi_samuele
 */
public class JDatiCondivisi {

    private int variabileCondivisa;
    
    public JDatiCondivisi() {
        
        variabileCondivisa = 0;
    }

    public int getVariabileCondivisa() {
        return variabileCondivisa;
    }

    public void setVariabileCondivisa(int variabileCondivisa) {
        this.variabileCondivisa = variabileCondivisa;
    }
    
    public synchronized void incVariabileCond()
    {
        variabileCondivisa++;
    }
    
}
