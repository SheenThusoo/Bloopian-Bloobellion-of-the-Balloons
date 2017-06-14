import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.*;
import java.io.*;

public abstract class Enemy {
  
  private BufferedImage img = null;
  private ImageObserver observer = null;
  private int x = 0;
  private int y; //y's depend on map chosen
  private int arrayX = 0;
  private int arrayY; //y's depend on map chosen
  private int xa;
  private int ya;
  private int count = 50;
  private int speed; //dependant on subclass
  private int[][] path; 
  private char diff;
  private char type; //type of balloon to indicate img, given by subclass
  
  public Enemy (int [][] path, char diff, char type, int speed) {
    this.path = path;
    this.diff = diff; 
    this.type = type;
    this.speed = speed;
    
    if (diff == 'e'){
      y = 350;
      arrayY = 7;
    } else if (diff == 'm') {
      y = 450;
      arrayY = 9;
    } else if (diff == 'h'){
      y = 100; 
      arrayY = 2;
    }
    
    //paints balloon based on type
    if (type == 'r'){ 
      try {
        img = ImageIO.read(new File("rookieballoon.png"));
      } catch (IOException e) {
        
      }
    } else if (type == 'i'){
       try {
        img = ImageIO.read(new File("iceballoon.png"));
      } catch (IOException e) {
        System.out.println(e);
      }
    } else if (type == 'a'){
       try {
        img = ImageIO.read(new File("athleticballoon.png"));
      } catch (IOException e) {
        System.out.println(e);
      }
    } else if (type == 'c') {
       try {
        img = ImageIO.read(new File("commanderballoon.png"));
      } catch (IOException e) {
        System.out.println(e);
      }
    }
    
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public char getType() {
    return type;
  }
  
  public void move () {
    
    if(count == 50)
    {
      count = 0;
      if (path[arrayY][arrayX] == 1) //left
      {
        xa = -speed;
        ya = 0;
        arrayX -= 1;
      } else if (path[arrayY][arrayX] == 2){ //right
        xa = speed;
        ya = 0;
        arrayX += 1;
      } else if (path[arrayY][arrayX] == 3){ //up
        ya = -speed;
        xa = 0;
        arrayY -= 1;
      } else if (path[arrayY][arrayX] == 4){ //down
        ya = speed;
        xa = 0;
        arrayY += 1;
      } else {
      }
    }
      x = x + xa; 
      y = y + ya;
      count += speed;
    
  }
  
  public void paint (Graphics2D g){
    g.drawImage(img, x, y, observer);
  }
  
}
