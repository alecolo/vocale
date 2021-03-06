/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pkg1semaforipeduzzi;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peduzzi_samuele
 */
public class JIncrementatoreTh extends Thread {

    //Attributi
    private int nCicli = 1000;
    private JDatiCondivisi dC;
    private Semaforo s;

    //Metodi
    public JIncrementatoreTh(JDatiCondivisi dC, Semaforo s, boolean usaMutex, int nCicli) {

        this.dC = dC;
        this.s = s;
        this.nCicli = nCicli;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < nCicli; i++) {
            dC.incVariabileCond();
        }
    }
}
