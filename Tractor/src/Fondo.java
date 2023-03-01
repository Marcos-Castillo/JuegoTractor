
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pi
 */
public class Fondo {
    //objeto de la clase juego
    Juego jueguito;
    //variables del tamaño de fondo
    int anchoFondo=1300;
    int altoFondo=400;
    //coordenadas iniciales para mover el Fondo
    int x1 = 1300;
    int y1 = 0 ;
    //coordenadas auxiliares que mueven el fondo
    int x2 = 0;
    int y2 = 0 ;
    
    
    public Fondo(Juego jueguito){
    this.jueguito = jueguito;
    }
    
    public void mover(){
        x1-=2;
        x2-=2;
        if(x1==0 && x2==-1300){
            x1=1300;
            x2=0;
        }
                
    }
    
    public void paint(Graphics2D g){
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Multimedia/fondo.jpg"));
        g.drawImage(imagenFondo.getImage(),x1,y1,anchoFondo,altoFondo,null);
        g.drawImage(imagenFondo.getImage(),x2,y2,anchoFondo,altoFondo,null);
        
    }
}
