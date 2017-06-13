/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepcomputer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



/**
 *
 * @author vanle_000
 */
public class SleepComputer extends JFrame implements ActionListener {
    private JTextField tfTime;
    private JButton btStart, btStop;
    
    private long begintime;// bien thoi gian hien tai
    private TimerThread thread;
    
    
    public SleepComputer(){
        super("CHƯƠNG TRÌNH SLEEP MÁY TÍNH");
        setSize(300, 200);// xet kich thuoc
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InitGUI();
    }
// taoj giao dien GUi
    private void InitGUI(){
        // xet bo cuc
        setLayout(new FlowLayout());
        
        
        
        tfTime = new JTextField(20);
        add(tfTime);
        
        btStart =new JButton("Start");// nut start
        btStart .addActionListener(this);
        add(btStart);
        
        btStop = new JButton("Stop");// tao nut stop
        btStop.addActionListener(this);
        add(btStop);
        
    }
    public static void main(String[] args) {
       SleepComputer f = new SleepComputer();
       f.setVisible(true);
    }

    @Override// phuong thuc tao su kien cho nut
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()== btStart){
            startthread();
           
        }
        if(e.getSource()== btStop){
            stopthread();
        }
    }
     private void startthread(){
         if (thread!=null) stopthread();
          thread = new TimerThread();
            thread.start();
     }
     
     private void stopthread(){
         
         if (thread!=null){
             
             thread.stop();
             thread = null;
             
         }
     }
     
     
    private class TimerThread extends Thread{
        
        public void run(){
            
            begintime = System.currentTimeMillis();//lay time hien tai cua he  thong
                    
            while (true){
                
                long deltaTime = System.currentTimeMillis() - begintime;
                tfTime.setText(String.valueOf(deltaTime));
                if(deltaTime==5000){
                    try {
                        Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
                        stopthread();
                    } catch (IOException ex) {
                        Logger.getLogger(SleepComputer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
}

