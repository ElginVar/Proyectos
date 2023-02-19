/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class Cliente implements Runnable{
    control m;
    Barbero barbero;
    DefaultListModel waitingList;
    JLabel estadobarbero;
    int posInList;
    
    public Cliente(control m, Barbero b, DefaultListModel waitingList, JLabel estadobarbero, int numCliente){
        this.waitingList = waitingList;
        Log("Bienvenido, nuevo cliente");
        barbero = b;
        this.m = m;
        this.estadobarbero = estadobarbero;
        posInList = numCliente;
        
        m.clientesEspera++;
        waitingList.addElement("Cliente Numero "+numCliente);
        Log("Hay "+ m.getCuantosClientes() + " clientes esperando");
    }
    
    @Override
    public void run() {
        
        if(barbero.duerme){
            despertar();
        }
        
        while(true){
            if(Thread.currentThread().isAlive()){
                if(!m.masterChair){
                    m.cortarPelo(this.posInList);
                    break;
                }
            }
        }
        
    }
    
    public void despertar(){
        
        Log("Despertando al barbero");
        estadobarbero.setText("Despertando al barbero");
        synchronized(barbero){
            barbero.notify();
        }
    }
    
    public void Log(String mensaje){
        System.out.println(mensaje);
    }
    
}
