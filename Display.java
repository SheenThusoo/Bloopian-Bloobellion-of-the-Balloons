import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Display {
  private boolean gameOn;
  private boolean startScreen;
  
  private BufferedImage start = null;
  private BufferedImage level = null;
  private BufferedImage instructions = null;
  private BufferedImage story = null;
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
    } try {
      story = ImageIO.read(new File("storycopy.png"));
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
        toDisplay = story;
        startScreen = false;
      } else if (toDisplay == story){
        toDisplay = instructions;
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
  
  public void mouseClicked(MouseEvent e)
  {
    //allows player to click through menus
    if (e.getX() < 1100 && e.getY() < 750 && (startScreen || toDisplay == story || toDisplay == instructions)) {
      if (startScreen){
        toDisplay = story;
        startScreen = false;
      } else if (toDisplay == story) {
        toDisplay = instructions;
      } else if (toDisplay == instructions){
        toDisplay = level;
      }
    } else if (toDisplay == level){
      if (e.getX() > 46 && e.getX() < 348 && e.getY() > 344 && e.getY() < 492){
        gameOn = true;
      } else if (e.getX() > 402 && e.getX() < 705 && e.getY() > 344 && e.getY() < 492){
        gameOn = true;
      } else if (e.getX() > 749 && e.getX() < 1052 && e.getY() > 344 && e.getY() < 492){
        gameOn = true;
      }
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
