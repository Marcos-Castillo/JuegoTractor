
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pi
 */
public class Auto {
    //objeto de la clase juego
    Juego jueguito;
    //variables q nos ayudan a saber si el auto salta
    static boolean saltando = false;
    boolean sube = false;
    boolean baja = false;
    //variables que delimitan el area del objeto
    Area llantaDelantera, llantaTrasera,carroceria,tractor;
    //variables de tamaño de personaje 
    int anchoPersonaje=112;
    int altoPersonaje=78;
    //coordenadas iniciales de personaje
    static int x_inicial = 50;
    static int y_inicial = 270;
    //coordenadas par manipular el personaje
    static int x_auxiliar = 0;
    static int y_auxiliar = 0;
    
    public Auto(Juego jueguito){
    this.jueguito = jueguito;
    }
    
    public void mover(){
        if(x_inicial<0 && x_inicial+x_auxiliar<jueguito.getWidth()-anchoPersonaje){
            x_inicial+=x_auxiliar;
        }
        if(saltando){
            if(y_inicial==270){//si el auto esta en el suelo
                sube=true;
                y_auxiliar=-2;
                baja=false;
            }
            if(y_inicial==150){//si el auto llego al limite de salto
                baja=true;
                y_auxiliar=2;
                sube=false;
            }
            if(sube){
                y_inicial+=y_auxiliar;
            }
            if(baja){
                y_inicial+=y_auxiliar;
                if(y_inicial==270){//si el auto llego al suelo
                    saltando=false;
                }
            }
        }
    }
    
    public void paint (Graphics2D g){
        ImageIcon auto= new ImageIcon(getClass().getResource("/Multimedia/tractor.png"));
        g.drawImage(auto.getImage(),x_inicial,y_inicial,anchoPersonaje,altoPersonaje,null);
        
    }
    
    public void keyPressed(KeyEvent ke){
        if(ke.getKeyCode()==KeyEvent.VK_SPACE){
            saltando = true;
        }
    }
    public Area getBounds(){
        Rectangle forma1=new Rectangle(x_inicial,y_inicial,95,62);
        carroceria = new Area(forma1);
        
        Ellipse2D forma2=new Ellipse2D.Double(x_inicial,y_inicial+28,48,48);
        llantaTrasera = new Area(forma2);
        
        Ellipse2D forma3=new Ellipse2D.Double(x_inicial+73,y_inicial+39,38,38);
        llantaDelantera = new Area(forma3);
        
        tractor=carroceria;
        tractor.add(carroceria);
        tractor.add(llantaTrasera);
        tractor.add(llantaDelantera);
        return tractor;
    }
}
