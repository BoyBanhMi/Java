/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
/**
 *
 * @author vanle_000
 */
public class V {
    public JPanel a,b,c,d;
    public V(JFrame g){
        g.setLayout(new GridLayout(1,4));//??
        
        a = new JPanel();
        a.setBackground(Color.BLUE);
        a.setCursor(new Cursor(Cursor.HAND_CURSOR));//trõ chuột dạng hand
        g.add(a);
        
        b = new JPanel();
        b.setBackground(Color.GREEN);
        b.setCursor(new Cursor(Cursor.TEXT_CURSOR));//trõ chuột dạng text
        g.add(b);
        
        c = new JPanel();
        c.setBackground(Color.RED);
        c.setCursor(new Cursor(Cursor.MOVE_CURSOR));//trõ chuột dạng move
        g.add(c);
        
        d = new JPanel();
        d.setBackground(Color.BLUE);
        d.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        g.add(d);
    }
    public static void main(String args[]){
    
        JFrame g = new JFrame();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//?
        g.setVisible(true);
        g.setSize(500,300);
        g.setLocation(400,200);
        g.setTitle("DHCN1A");
        V m = new V(g);
    }
}
