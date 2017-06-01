import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
  
  Map myMap = new Map(easy);
  
  RookieBalloon ene = new RookieBalloon(easy, 'e');
  ArrayList balloons = new ArrayList();
    int numofCLoons = 0;
    int numofRLoons = 10;
    int numofILoons = 0;
    int numofALoons = 0;
    int numOfLoons = numofRLoons + numofILoons + numofALoons + numofCLoons;
    public BloonGame(int numofCLoons, int numofRLoons, int numofILoons, int numofALoons, int numofLoons){
   this.numofCLoons = numofCLoons; 
   this.numofRLoons = numofRLoons;
   this.numofILoons = numofILoons;
   this.numofALoons = numofALoons;
   this.numOfLoons = numOfLoons;
   
    for (int i = 0; i < numofRLoons; i++){
      balloons.add(new RookieBalloon(int [][] path, char diff)); 
    }
  }
  
  public void nextRound(){ //should ONLY run when the round progresses:
    numofRLoons += 5;
    numofILoons += 5;
    int round;
    
    if (round > 3) {
      numofALoons += 5;
    }
    
    if (round > 5) {
      numofCLoons += 5;
    }
    
    balloons.clear();
    
    for (int i = 0; i < numofRLoons; i++){
      balloons.add(new RookieBalloon()); 
    }
    
    for (int i = 0; i < numofILoons; i++){
      balloons.add(new IceBalloon()); 
    }
    
    for (int i = 0; i < numofAthLoons; i++){
      balloons.add(new AthleticBalloon()); 
    }
    
    for (int i = 0; i < numofCLoons; i++){
      balloons.add(new CommanderBalloon(null)); 
    }
    
    Collections.shuffle(balloons);
  }
  
 
  /*
  public CityScape() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }
      @Override
      public void keyReleased(KeyEvent e) {
        ufo.keyReleased(e);
      }
      @Override
      public void keyPressed(KeyEvent e) {
        ufo.keyPressed(e);
      }
    });
    setFocusable(true);
  } 
  */
  
  public void move() 
  {
    ene.move();
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    
    //Background
    Color customColor = new Color(0, 0, 51);
    g2d.setColor(customColor);
    g2d.fillRect(0, 0, 1100, 750);

    myMap.paint(g2d);
    ene.paint(g2d);
    
  }
  
  public static void main(String[] args) throws InterruptedException 
  {
    JFrame frame = new JFrame("BloonGame");
    //Add our JPanel to the frame
    frame.add(new BloonGame());
    frame.setSize(1100, 750);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    BloonGame p = new BloonGame();
    frame.add(p);
    
    while (true)
    {
      p.move();
      p.repaint();
      Thread.sleep(10);
    } 
  }
}
