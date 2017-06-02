import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections.shuffle;


public class BloonGame extends JPanel 
{
  //path/map arrays by difficulty
  //1 = left , 2 = right , 3 = up , 4 = down
  private int[][] easy = { 
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,0,0,0,0},
    {0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0}, 
    {0,0,3,0,0,4,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
    {0,0,3,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,3,0,0,4,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
    {0,0,3,0,0,4,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {2,2,3,0,0,4,0,3,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
    {0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0},
    {0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,3,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
  
  private int[][] medium = {
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,2,2,2,2,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,3,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,3,0,0,0,4,0,0,0,0,2,2,2,4,0,0,0,0,0,0,0,0}, 
    {0,0,3,0,0,0,4,0,0,0,0,3,0,0,4,0,0,0,0,0,0,0,0}, 
    {0,0,3,0,0,0,4,0,0,0,0,3,0,0,4,0,0,0,0,0,0,0,0}, 
    {0,0,3,0,0,0,2,2,4,0,0,3,0,0,2,2,2,2,2,2,2,2,0}, 
    {0,0,3,0,0,0,0,0,4,0,0,3,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,3,0,0,0,0,0,4,0,0,3,0,0,0,0,0,0,0,0,0,0,0}, 
    {2,2,3,0,0,0,0,0,2,2,2,3,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
  
  private int[][] hard = {
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {2,2,2,2,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,4,0,0,0,0,0,2,2,2,2,4,0,0,0,0,0,0,0,0},
    {0,0,0,0,4,0,0,0,0,0,3,0,0,0,2,2,2,2,2,2,2,2,0}, 
    {0,0,0,0,2,2,2,2,2,2,3,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
  
  Display myDisplay = new Display();
  Map myMap;
  
  private int[][] path;
  private char diff;
  
   ArrayList balloons = new ArrayList();
   static int cLoonNum = 0;
   static int rLoonNum = 10;
   static int iLoonNum = 0;
   static int aLoonNum = 0;
   static int loonNum = rLoonNum + iLoonNum + aLoonNum + cLoonNum;
  
  public BloonGame(int cLoonNum, int rLoonNum, int iLoonNum, int aLoonNum, int loonNum) {
    
    this.cLoonNum = cLoonNum; 
    this.rLoonNum = rLoonNum;
    this.iLoonNum = iLoonNum;
    this.aLoonNum = aLoonNum;
    this.loonNum = loonNum;
    
    if (myDisplay.getGameOn())
    {
      for (int i = 0; i < rLoonNum; i++){
        balloons.add(new RookieBalloon(path, diff)); 
      }
    }
    
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }
      @Override
      public void keyReleased(KeyEvent e) {
       //receives map selection from user, gameOn checked so once a map is chosen it can't be changed
        if (e.getKeyCode() == KeyEvent.VK_E && !myDisplay.getGameOn()){
          myMap = new Map (easy);
          path = easy;
          diff = 'e';
        }
        if (e.getKeyCode() == KeyEvent.VK_M && !myDisplay.getGameOn()){
          myMap = new Map (medium);
          path = medium;
          diff = 'm';
        }
        if (e.getKeyCode() == KeyEvent.VK_H && !myDisplay.getGameOn()){
          myMap = new Map (hard);
          path = hard;
          diff = 'h';
        }
        myDisplay.keyReleased(e);
      }
      @Override
      public void keyPressed(KeyEvent e) {
      }
    });
    setFocusable(true);
  } 
  
   public void nextRound(){ //should ONLY run when the round progresses:
      int cLoonNum = 0;
      int rLoonNum = 10;
      int iloonNum = 0;
      int aLoonNum = 0;
      rLoonNum += 5;
      iLoonNum += 5;
      int round;
     
     if (round > 3) {
       aLoonNum += 5;
     }
     
     if (round > 5) {
       cLoonNum += 5;
     }
     
     balloons.clear();
     
     for (int i = 0; i < rLoonNum; i++){
       balloons.add(new RookieBalloon(path, diff)); 
     }
     
     for (int i = 0; i < iloonNum; i++){
       balloons.add(new IceBalloon(path, diff)); 
     }
     
     for (int i = 0; i < aLoonNum; i++){
       balloons.add(new AthleticBalloon(path, diff)); 
     }
     
     for (int i = 0; i < cLoonNum; i++){
       balloons.add(new CommanderBalloon(path,diff)); 
     }
      
      Collections.shuffle(balloons);
    }
  
  public void move() 
  {
    
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    
    //Background
    g2d.setColor(Color.white);
    g2d.fillRect(0, 0, 1100, 750);
    //perhaps do the menu bar in brown down here?
    
    if (!myDisplay.getGameOn())
       myDisplay.paint(g2d);
    else
    {
      myMap.paint(g2d);
      //game menu., enemies, and towers and painted here
    }
  }
  
  
  public static void main(String[] args) throws InterruptedException 
  {
    JFrame frame = new JFrame("BloonGame");
    //Add our JPanel to the frame
    BloonGame p = new BloonGame(cLoonNum, rLoonNum, iLoonNum, aLoonNum, loonNum);
    frame.add(p);
    frame.setSize(1100, 750);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    while (true)
    {
      p.move();
      p.repaint();
      Thread.sleep(10);
    } 
  }
}
