
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pi
 */
public class Juego extends JPanel{
    
    //sonido del juego 
    
    URL direccionSonidoSalto,direccionSonidoChoque;
    AudioClip sonidoChoque, sonidoSalto;
    
   //objetos de las clases auto obstaculo y fondo
    
    Auto auto=new Auto(this);
    Obstaculo obstaculo =new Obstaculo(this);
    Fondo fondo = new Fondo(this);
    
    //variables para el juego 
    
    static boolean juegoFinalizado = false;
    public static boolean pierdeVida = false;
    public static int vidas = 3 ;
    public static int puntos = 0 ;
    public static int nivel = 3 ; 
    
    public  Juego(){
        direccionSonidoChoque = getClass().getResource("/Multimedia/choque.wav");
        sonidoChoque = Applet.newAudioClip(direccionSonidoChoque);
        
        direccionSonidoSalto = getClass().getResource("/Multimedia/salto.wav");
        sonidoSalto = Applet.newAudioClip(direccionSonidoSalto);
        
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //salta al precionar espacio
                if(ke.getKeyCode()==KeyEvent.VK_SPACE){
                sonidoSalto.play();
                auto.keyPressed(ke);
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        
            
        });
        setFocusable(true);
        
    }
    
    public void mover(){
        obstaculo.mover();
        auto.mover();
        fondo.mover();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        dibujar(g2);
        dibujarPuntaje(g2);
    }
    
    
    public void dibujar(Graphics2D g){
        fondo.paint(g);
        auto.paint(g);
        obstaculo.paint(g);
        mover();
    
    }
    
    public void dibujarPuntaje(Graphics2D g){
    Graphics2D g1=g,g2=g;
        Font score= new Font("Arial",Font.BOLD,30);
        g.setFont(score);
        g.setColor(Color.blue);
        g1.drawString("Puntaje: "+puntos,1100,30);
        g1.drawString("Vidas: "+vidas,20,30);
        g1.drawString("Nivel: "+nivel,570,30);
        
        if(juegoFinalizado){
        g2.setColor(Color.red);
        g2.drawString("¡¡¡ Haz Perdido !!!",((float)getBounds().getCenterX()/2)+170,70);
        
        
        }
    }
    
    public void finJuego(){
        juegoFinalizado=true;
        sonidoChoque.play();
    }
    
    public void pierdeVida(){
        sonidoChoque.play();
        pierdeVida= true;
    }
}
