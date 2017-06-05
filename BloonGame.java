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
  
  Display myDisplay = new Display();
  Map myMap;
  RookieBalloon ene;
  
  /*ArrayList balloons = new ArrayList();
    int numofCLoons = 0;
    int numofRLoons = 10;
    int numofILoons = 0;
    int numofALoons = 0;
    int numOfLoons = numofRLoons + numofILoons + numofALoons + numofCLoons;
  public BloonGame(){
   
    for (int i = 0; i < numofRLoons; i++){
      balloons.add(new RookieBalloon(easy, 'e')); 
    }
  }
  
  public void nextRound(){ //should ONLY run when the round progresses:
    numofRLoons += 5;
    numofILoons += 5;
    int round = 0;
    
    if (round > 3) {
      numofALoons += 5;
    }
    
    if (round > 5) {
      numofCLoons += 5;
    }
    
    balloons.clear();
    
    for (int i = 0; i < numofRLoons; i++){
      balloons.add(new RookieBalloon(easy, 'e'));
    
    for (int n = 0; n < numofILoons; n++){
      balloons.add(new IceBalloon(easy, 'e')); 
    }
    
    for (int s = 0; s < numofALoons; s++){
      balloons.add(new AthleticBalloon(easy, 'e')); 
    }
    
    for (int t = 0; t < numofCLoons; t++){
      balloons.add(new CommanderBalloon(easy, 'e')); 
    }
    
    Collections.shuffle(balloons);
    }
  }
  */
  public BloonGame() {
    
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }
      @Override
      public void keyReleased(KeyEvent e) {
       //receives map selection from user, gameOn checked so once a map is chosen it can't be changed
        if (e.getKeyCode() == KeyEvent.VK_E && !myDisplay.getGameOn()){
          myMap = new Map (easy);
          ene = new RookieBalloon(easy, 'e');
      }
        if (e.getKeyCode() == KeyEvent.VK_M && !myDisplay.getGameOn()){
          myMap = new Map (medium);
          ene = new RookieBalloon(medium, 'm');
      }
        if (e.getKeyCode() == KeyEvent.VK_H && !myDisplay.getGameOn()){
          myMap = new Map (hard);
        ene = new RookieBalloon(hard, 'h');
      }
        
        myDisplay.keyReleased(e);
      }
      @Override
      public void keyPressed(KeyEvent e) {
      }
    });
    setFocusable(true);
  } 
  
  public void move() 
  {
    if (myDisplay.getGameOn()){
      ene.move();
    }
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
      ene.paint(g2d);
      //game menu., enemies, and towers and painted here
    }
  }
  
  
  public static void main(String[] args) throws InterruptedException 
  {
    JFrame frame = new JFrame("BloonGame");
    //Add our JPanel to the frame
    BloonGame p = new BloonGame();
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
