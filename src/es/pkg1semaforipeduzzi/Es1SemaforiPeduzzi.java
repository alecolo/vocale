/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pkg1semaforipeduzzi;

import java.util.concurrent.Semaphore;

/**
 *
 * @author 
 */
public class Es1SemaforiPeduzzi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        JDatiCondivisi dC = new JDatiCondivisi();
        Semaforo s = new Semaforo(1);
        
        boolean usaMutex = true;
        int numCicli = 1000;
        
        JIncrementatoreTh inc0 = new JIncrementatoreTh(dC, s, usaMutex, numCicli);
        JIncrementatoreTh inc1 = new JIncrementatoreTh(dC, s, usaMutex, numCicli);
        JVisualizzaTh vis = new JVisualizzaTh(dC, s, usaMutex);
        
        
        vis.start();
        inc0.start();
        inc1.start();
        
        inc0.join();
        inc1.join();
        
        vis.interrupt();
        vis.join();
        
        // x : 100.0 = nErrori : nCicli
        // nErrori = nCicli - varCondivisa
        // x = (nCicli - varCondivisa) * 100.0 / nCicli
        
        System.out.println(dC.getVariabileCondivisa());
        System.out.println("Percentuale di successo --> " + -(((numCicli - dC.getVariabileCondivisa()) * 100)/numCicli) + "%");
    }
    
}
