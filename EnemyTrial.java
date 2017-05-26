import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.*;
import java.io.*;

public class EnemyTrial {
  
  private BufferedImage img = null;
  private ImageObserver observer = null;
  private int x = 0;
  private int y = 350;
  private int arrayX = 0;
  private int arrayY = 7;
  private int xa;
  private int ya;
  private int count = 50;
  private int speed = 10;
  
  
  private int[][] path; 
  
  public EnemyTrial(int [][] path /*, char diff*/) {
    this.path = path;
    
    //if (diff == e)
    
    
    try {
      img = ImageIO.read(new File("athleticballoon.png"));
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  
  public void move(){
    
    if(count == 50)
    {
      count = 0;
      if (path[arrayY][arrayX] == 1) //left
      {
        xa = -speed;
        ya = 0;
        arrayX -= 1;
        System.out.println(arrayY);
        System.out.println(arrayX);
      } else if (path[arrayY][arrayX] == 2){ //right
        xa = speed;
        ya = 0;
        arrayX += 1;
        System.out.println(arrayY);
        System.out.println(arrayX);
      } else if (path[arrayY][arrayX] == 3){ //up
        ya = -speed;
        xa = 0;
        arrayY -= 1;
        System.out.println(arrayY);
        System.out.println(arrayX);
      } else if (path[arrayY][arrayX] == 4){ //down
        ya = speed;
        xa = 0;
        arrayY += 1;
        System.out.println(arrayY);
        System.out.println(arrayX);
      } else {
      }
    }
    else
    {
      x = x + xa; 
      y = y + ya;
      count += speed;
    }
    
  }
  
  public void paint(Graphics2D g) {
    g.drawImage(img, x, y, observer);
    
    
  }
  
}
