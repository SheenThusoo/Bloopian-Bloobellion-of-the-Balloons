import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Display {
  private boolean gameOn;
  private boolean startScreen;
  
  private BufferedImage start = null;
  private BufferedImage level = null;
  private BufferedImage instructions = null;
  private BufferedImage win = null;
  private BufferedImage lose = null;
  private BufferedImage toDisplay = null;
  
  public Display(){ 
    startScreen = true;
    gameOn = false;
    
    try {
      start = ImageIO.read(new File("introScreenResized.jpg"));
    } catch (IOException e) {
    }
    try {
      instructions = ImageIO.read(new File("instructions.png"));
    } catch (IOException e) { 
    }
    try {
      level = ImageIO.read(new File("mapScreen.png"));
    } catch (IOException e) { 
    } try{
      win = ImageIO.read(new File("winner.jpg"));
    } catch (IOException e){
    } try{
      lose = ImageIO.read(new File("loseScreen.png"));
    } catch (IOException e){
    }
    
    toDisplay = start;
  }
  
  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) //anything that spacebar does
    {
      if (startScreen){
        toDisplay = instructions;
        startScreen = false;
      } else if (toDisplay == instructions){
        toDisplay = level;
      }
    }
    if ((e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_M || e.getKeyCode() == KeyEvent.VK_H) 
          && toDisplay == level)
    {
      gameOn = true;
    }
  }
  
  public boolean getGameOn()
  {
    return gameOn;
  }
  
  public void endScreen(int lives){
    gameOn = false;
    
    if (lives == 0)
      toDisplay = lose;
    else 
      toDisplay = win;
  }
  
  public void paint(Graphics g2d) {
    if (!gameOn)  
      g2d.drawImage(toDisplay, 0, 0, null);
  }
  
  
}
