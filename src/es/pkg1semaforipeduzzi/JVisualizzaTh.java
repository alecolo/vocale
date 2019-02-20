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


public class JVisualizzaTh extends Thread{
    
    JDatiCondivisi dC;
    private Semaforo s;

    public JVisualizzaTh(JDatiCondivisi dC, Semaforo s, boolean usaMutex) {
        this.dC = dC;
        this.s = s;
    }
    
    public synchronized void run()
    {
        while(!isInterrupted())
        {   
            System.out.println(dC.getVariabileCondivisa());
        }
            
    }
    
    
}
