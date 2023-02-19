/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

import static java.awt.SystemColor.control;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Barbero implements Runnable {
    boolean duerme;
    Random r;
    control m;
    JLabel estadobarbero;
    JLabel estadosilla;
    JProgressBar progress;
            
    public Barbero(control m, JLabel estadobarbero, JLabel estadosilla, JProgressBar progress){
        duerme = false;
        r = new Random();
        this.m = m;
        this.estadobarbero = estadobarbero;
        this.estadosilla = estadosilla;
        this.progress = progress;
    }
    
    public void dormir(){
        try{                
            Log("Barbero va a dormir");
            estadobarbero.setText("barbero esta volviendo a su siesta");
            duerme = true;
            m.masterChair = true;
            progress.setValue(0);
            estadosilla.setText("Barbero durmiendo en la silla");
            synchronized(this){
                wait();
            }
            Log("Despierta el barbero");
            estadobarbero.setText("Despierta el barbero");
            estadosilla.setText("desocupado");
            duerme = false;
            m.masterChair = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(true){
            if(!m.masterChair && m.getCuantosClientes()==0 && !duerme){
                dormir();
            }
            Log("Barbero Dormido?: "+duerme);
        }
    }
    
    public void Log(String mensaje){
        System.out.println(mensaje);
    }
    
}
