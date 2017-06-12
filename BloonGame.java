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
  
  private Display myDisplay = new Display();
  private Map myMap;
  private Menu myMenu = new Menu();
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
  private int towerCost;
  
  private ArrayList <Enemy> balloons = new ArrayList <Enemy>();
  private ArrayList <Enemy> balloonsFinal = new ArrayList  <Enemy>();
  private int numofCLoons = 0;
  private int numofRLoons = 10;
  private int numofILoons = 0;
  private int numofALoons = 0;
  private int numOfLoons = numofRLoons + numofILoons + numofALoons + numofCLoons;
  
  private int[][] map;
  private char diff;
  private boolean diffChosen;
  
  private int time = 0; //time for spacing balloons, should reset every round
  private int round = 0; 
  private boolean changeRound = false;
  private boolean pause = true; //when pause is false balloons and towers are paused
  private boolean pauseClicked = false;
  
  private int lives; //lives and money change by level
  private int money;
  
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
        
        //pause functions but screws with tower controls somehow. the problem might actually be with something else...
        if((x >= 680 && x <= 830) && (y >= 620 && y <= 670) && !pauseClicked){
          pauseClicked = true;
          if (pause){
            pause = false;
            pauseClicked = false;
          }
          else {
            pause = true;
            pauseClicked = false;
          }
        }
        pauseClicked = false;
        
        if(!towerChoiceMade && x <610 && y >625)
        {
          if((x >= 50 && x <= 100) && (y >= 625 && y <= 675))
          {
            towerChosen = simpleTower;
            System.out.println("Simple Tower");
            choseTower = true;
            towerCost = 75;
          }
          
          if((x >= 150 && x <= 200) && (y >= 625 && y <= 675))
          {
            towerChosen = cannon;
            System.out.println("Cannon");
            choseTower = true;
            towerCost = 125;
          }
          if((x >= 250 && x <= 300) && (y >= 625 && y <= 675))
          {
            towerChosen = missileLauncher;
            System.out.println("Missile Launcher");
            choseTower = true;
            towerCost = 150;
          }
          if((x >= 350 && x <= 400) && (y >= 625 && y <= 675))
          {
            towerChosen = moneyCreator;
            System.out.println("Money Creator");
            choseTower = true;
            towerCost = 500;
          }
          if((x >= 450 && x <= 500) && (y >= 625 && y <= 675))
          {
            towerChosen = spikeTower;
            System.out.println("Spike Tower");
            choseTower = true;
            towerCost = 125;
          }
          if((x >= 550 && x <= 600) && (y >= 625 && y <= 675))
          {
            towerChosen = superFighter;
            System.out.println("Super Fighter");
            choseTower = true;
            towerCost = 1000;
          }
          towerChoiceMade = true;
        }
        
        if (towerChoiceMade && towerCost <= money) 
        {
          
          arrayX = x/50;
          arrayY = y/50;
          
          System.out.println(arrayX + "," + arrayY);
          
          towerChosen.placeTower(path, arrayX, arrayY);
          towerChoiceMade = false;
          money = money - towerCost;
        } else if (towerCost > money && towerChoiceMade)
        {
          towerChoiceMade = false;
          myMenu.moneyError();
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
    if (round!=0 && round < 25){
      pause = true;
      round ++;
      System.out.println("Round:" + round);
      changeRound = true;
      money += 100;
      if (pause && changeRound){
        nextRound();
      }
    } else {
      pause = true;
      myDisplay.endScreen(lives);
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
    g2d.setColor(grass);
    g2d.fillRect(0, 0, 1100, 750);
     g2d.setColor(Color.white);
    g2d.fillRect(0, 550, 1100, 250);
    
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
            pause = true;
            myDisplay.endScreen(lives);
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
      
      //paints menu text
      myMenu.paint(g2d, lives, round, money, pause);
      
      // towers painted here
      moneyCreator.paint(g2d);
      cannon.paint(g2d);
      simpleTower.paint(g2d);
      missileLauncher.paint(g2d);
      spikeTower.paint(g2d);
      superFighter.paint(g2d);
      
      if(choseTower == true)
      {
        g2d.setColor(Color.RED);
        if (towerChosen == simpleTower)
        {
          g2d.drawRect(45, 620 , 55, 55);
        }
        else if (towerChosen == cannon)
        {
          g2d.drawRect(145, 620 , 55, 55);
        }
        else if (towerChosen == missileLauncher)
        {
          g2d.drawRect(245, 620 , 55, 55);
        }
        else if (towerChosen == moneyCreator)
        {
          g2d.drawRect(345, 620 , 55, 55);
        }
        else if (towerChosen == spikeTower)
        {
          g2d.drawRect(445, 620 , 55, 55);
        }
        else if (towerChosen == superFighter)
        {
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
