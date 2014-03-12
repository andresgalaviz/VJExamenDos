package vjexamendos;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto
 */
public class GameOver {
    private final Boton[] botones;
    private final int[] startPosY, finalPosY;
    
    /**
     * Metodo constructor
     * @param background imagen de fondo
     */
    public GameOver() {
        botones = new Boton[3];
        startPosY = new int[3];
        finalPosY = new int[3];
        botones[0] = new Boton(Base.getW()/3, 0, "Images/Buttons/restart.png");
        botones[0].setPosX(botones[0].getPosX() - botones[0].getAncho()/2);
        startPosY[0] = Base.getH();
        finalPosY[0] = 4*Base.getH()/5 - botones[0].getAlto()/2;
        botones[1] = new Boton(2*Base.getW()/3, 0, "Images/Buttons/quit.png");
        botones[1].setPosX(botones[1].getPosX() - botones[1].getAncho()/2);
        startPosY[1] = Base.getH();
        finalPosY[1] = 4*Base.getH()/5 - botones[1].getAlto()/2;
        botones[2] = new Boton(Base.getW()/2, 0, "Images/Buttons/gameover.png");
        botones[2].setPosX(botones[2].getPosX() - botones[2].getAncho()/2);
        startPosY[2] = -botones[2].getAlto()/2;
        finalPosY[2] = Base.getH()/4 - botones[2].getAlto()/2;
        
        reset();
    }
    
    public void actualiza () {
        for (int i = 0; i < 2; i++) {
            if (botones[i].getPosY() > finalPosY[i]) {
                botones[i].setPosY(botones[i].getPosY() - 4);
            }
        }
        if (botones[2].getPosY() < finalPosY[2]) {
            botones[2].setPosY(botones[2].getPosY() + 4);
        }
    }
    
    public void reset () {
        for (int i = 0; i < 3; i++) {
            botones[i].setPosY(startPosY[i]);
        }
    }
    
    /**
     * Dibuja la pantalla de seleccion de personajes
     * @param g
     * @param juego
     */
    public void render(Graphics g, Juego juego) {
        
        for (int i = 0; i < 3; i++) {
            g.drawImage(botones[i].getImagenI(), botones[i].getPosX(), botones[i].getPosY(), juego);
        }
    }

    /**
     * Revisa clicks en los botones
     * @param e 
     */
    public void keyPressed (KeyEvent e) {
        if (Juego.State == Juego.STATE.GAMEOVER) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                Juego.State = Juego.STATE.CHARSEL;
                reset();
            }
                    
        }
        
    }
}
