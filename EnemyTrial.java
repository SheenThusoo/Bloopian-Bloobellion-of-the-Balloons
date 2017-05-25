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
  private int ax = 7;
  private int ay = 0;
  private int xa;
  private int ya;
  private int count = 50;
  
  
  private int[][] path; 
  
  public EnemyTrial(int [][] path /*, char diff*/) {
    this.path = path;
    
    //if (diff == e)
    
    
    try {
      img = ImageIO.read(new File("balloonred.png"));
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  
  public void move(){
    
    if(count % 50 ==0)
    {
      if (path[ax][ay] == 1)
      {
        xa = -1;
        ax -= 1;
      } else if (path[ax][ay] == 2){
        xa = 1;
        ax += 1;
      } else if (path[ax][ay] ==3){
        ya = -1;
        ay += 1;
      } else if (path[ax][ay] == 4){
        ya = 1;
        ay -= 1;
      } else {
      }
    }
    else
    {}
    
    count ++;
    
    //for (int i = 0; i < 50; i++){
    x = x + xa; 
    y = y + ya;
    //}
    
  }
  
  public void paint(Graphics2D g) {
    g.drawImage(img, x, y, observer);
    
    
  }
  
}