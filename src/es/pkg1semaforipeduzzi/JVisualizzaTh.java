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
    private boolean usaMutex;

    public JVisualizzaTh(JDatiCondivisi dC, Semaforo s, boolean usaMutex) {
        this.dC = dC;
        this.s = s;
        this.usaMutex = usaMutex;
    }
    
    public void run()
    {
        while(!isInterrupted())
        {   
            if(usaMutex)
                s.Wait();
            System.out.println(dC.getVariabileCondivisa());
            if(usaMutex)
                s.Signal();
        }
            
    }
    
    
}
