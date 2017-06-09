import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

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
  private MoneyCreator  moneyCreator = new MoneyCreator(this);
  private Cannon cannon = new Cannon(this);
  private MissileLauncher missileLauncher = new MissileLauncher(this);
  private SpikeTower spikeTower = new SpikeTower(this);
  private SuperFighter superFighter = new SuperFighter(this);
  private SimpleTower simpleTower = new SimpleTower(this);
  private int[][] path;
  
  private int x;
  private int y;
  private int arrayX;
  private int arrayY;
  private Tower towerChosen;
  private boolean choseTower = false;
  private boolean towerChoiceMade = false;
  
  ArrayList <Enemy> balloons = new ArrayList <Enemy>();
  ArrayList <Enemy> balloonsFinal = new ArrayList  <Enemy>();
  int numofCLoons = 0;
  int numofRLoons = 10;
  int numofILoons = 0;
  int numofALoons = 0;
  int numOfLoons = numofRLoons + numofILoons + numofALoons + numofCLoons;
  
  int[][] map;
  char diff;
  boolean diffChosen; 
  
  int time = 0; //time for spacing balloons, should reset every round
  int round = 0; 
  boolean changeRound = false;
  boolean pause = true; //when pause is false balloons and towers are paused
  
  int lives; //lives and money change by level
  int money;
  
  public BloonGame(){
    
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }
      @Override
      public void keyReleased(KeyEvent e) {
        //receives map selection from user, gameOn checked so once a map is chosen it can't be changed
        if (e.getKeyCode() == KeyEvent.VK_E && !myDisplay.getGameOn()){
          map = easy;
          diff = 'e';
          money = 200;
          lives = 100;
          myMap = new Map (map);
          for (int i = 0; i < numofRLoons; i++){
            balloons.add(new RookieBalloon(map, diff));
          }
          path = easy;
        }
        if (e.getKeyCode() == KeyEvent.VK_M && !myDisplay.getGameOn()){
          map = medium;
          diff = 'm';
          money = 150;
          lives = 50;
          myMap = new Map (map);
          for (int i = 0; i < numofRLoons; i++){
            balloons.add(new RookieBalloon(map, diff));
          }
          path = medium;
        }
        if (e.getKeyCode() == KeyEvent.VK_H && !myDisplay.getGameOn()){
          map = hard;
          diff = 'h';
          money = 100;
          lives = 25;
          myMap = new Map (map);  
          for (int i = 0; i < numofRLoons; i++){
            balloons.add(new RookieBalloon(map, diff)); 
          }
          path = hard;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && myDisplay.getGameOn()){
          if (pause)
            pause = false;
          else 
            pause = true;
        }
        
        myDisplay.keyReleased(e);
      }
      @Override
      public void keyPressed(KeyEvent e) {
      }
    });
    setFocusable(true);
    
    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        
        System.out.println(x + "," + y);
        
        if(!towerChoiceMade)
        {
          if((x >= 50 && x <= 100) && (y >= 625 && y <= 675))
          {
            towerChosen = simpleTower;
            System.out.println("Simple Tower");
            choseTower = true;
          }
          
          if((x >= 150 && x <= 200) && (y >= 625 && y <= 675))
          {
            towerChosen = cannon;
            System.out.println("Cannon");
            choseTower = true;
          }
          if((x >= 250 && x <= 300) && (y >= 625 && y <= 675))
          {
            towerChosen = missileLauncher;
            System.out.println("Missile Launcher");
            choseTower = true;
          }
          if((x >= 350 && x <= 400) && (y >= 625 && y <= 675))
          {
            towerChosen = moneyCreator;
            System.out.println("Money Creator");
            choseTower = true;
          }
          if((x >= 450 && x <= 500) && (y >= 625 && y <= 675))
          {
            towerChosen = spikeTower;
            System.out.println("Spike Tower");
            choseTower = true;
          }
          if((x >= 550 && x <= 600) && (y >= 625 && y <= 675))
          {
            towerChosen = superFighter;
            System.out.println("Super Fighter");
            choseTower = true;
          }
          towerChoiceMade = true;
        }
        if (x <1100 && y <550) 
          //else 
        {
          
          arrayX = x/50;
          arrayY = y/50;
          
          System.out.println(arrayX + "," + arrayY);
          
          towerChosen.placeTower(path, arrayX, arrayY);
          towerChoiceMade = false;
        }
      }
      public void mousePressed(MouseEvent e){
      }
      public void mouseReleased(MouseEvent e){
      }
      public void mouseEntered(MouseEvent e){
      }
      public void mouseExited(MouseEvent e){
      }
    });
    
    setFocusable(true);   

  }
  
  public void nextRound(){ //should ONLY run when the round progresses:
    System.out.println("Next Round!");
    numofRLoons += 5;
    numofILoons += 5;
    
    if (round > 3) {
      numofALoons += 5;
    }
    
    if (round > 5) {
      numofCLoons += 5;
    }
    
    for (int i = 0; i < numofRLoons; i++){
      balloons.add(new RookieBalloon(map, diff));
    }
    for (int n = 0; n < numofILoons; n++){
      balloons.add(new IceBalloon(map, diff)); 
    }
    
    for (int s = 0; s < numofALoons; s++){
      balloons.add(new AthleticBalloon(map, diff)); 
    }
    
    for (int t = 0; t < numofCLoons; t++){
      balloons.add(new CommanderBalloon(map, diff)); 
    }
    
    Collections.shuffle(balloons);
    changeRound = false;
    
  } 
  
  public void checkBalloons(){
    if (round!=0 && round < 20){
      pause = true;
      round ++;
      System.out.println("Round:" + round);
      changeRound = true;
      if (pause && changeRound){
        nextRound();
      }
    } else {
      pause = true;
      System.out.println("YOU WIN!!!");
    }
  }
  
  public void move() 
  {
    if (myDisplay.getGameOn() && !pause){
      for (int i = 0; i < balloonsFinal.size(); i++)
        balloonsFinal.get(i).move();
    }
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    
    //Background
    g2d.setColor(Color.GRAY);
    g2d.fillRect(0, 0, 1100, 550);
    
    if (!myDisplay.getGameOn()){
      g2d.setColor(Color.WHITE);
      g2d.fillRect(0,0, 1100, 750);
      myDisplay.paint(g2d);
    }
    else 
    {
      if (time % 100 == 0 && balloons.size() > 0 && !pause)
      {
        balloonsFinal.add(balloons.get(0));
        balloons.remove(0);
        
        if (balloonsFinal.size() == 1 && round == 0)
          round++;
      }
      
      // removes balloons from list if they pass the finish of the map
      for (int i = 0; i < balloonsFinal.size(); i++){
        if (balloonsFinal.get(i).getX() > 1100){ //new
          balloonsFinal.remove(i);
          lives--;
          
          if (lives == 0){
          }
            
          
          if (balloonsFinal.size() == 0)
            checkBalloons();
        }
      }
      
      myMap.paint(g2d);
      for (int a = 0; a < balloonsFinal.size(); a++){
        balloonsFinal.get(a).paint(g2d);
      }
      if (!pause)
        time++;
      
      //paint lives and money
      Font currentFont = g2d.getFont();
      Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
      g.setFont(newFont);
      g2d.setColor(Color.BLACK);
      g2d.drawString("Lives: " + lives, 930, 600);
      g2d.drawString("Bloonies: " + money, 930, 650);
      
      // towers painted here
      moneyCreator.paint(g2d);
      cannon.paint(g2d);
      simpleTower.paint(g2d);
      missileLauncher.paint(g2d);
      spikeTower.paint(g2d);
      superFighter.paint(g2d);
      
      if(choseTower == true)
      {
        if (towerChosen == simpleTower)
        {
          g2d.setColor(Color.RED);
          g2d.drawRect(45, 620 , 55, 55);
        }
        else if (towerChosen == cannon)
        {
          g2d.setColor(Color.RED);
          g2d.drawRect(145, 620 , 55, 55);
        }
        else if (towerChosen == missileLauncher)
        {
          g2d.setColor(Color.RED);
          g2d.drawRect(245, 620 , 55, 55);
        }
        else if (towerChosen == moneyCreator)
        {
          g2d.setColor(Color.RED);
          g2d.drawRect(345, 620 , 55, 55);
        }
        else if (towerChosen == spikeTower)
        {
          g2d.setColor(Color.RED);
          g2d.drawRect(445, 620 , 55, 55);
        }
        else if (towerChosen == superFighter)
        {
          g2d.setColor(Color.RED);
          g2d.drawRect(545, 620 , 55, 55);
        }
      }
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
