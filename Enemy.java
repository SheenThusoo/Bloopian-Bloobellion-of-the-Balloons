import javax.swing.*;
import java.awt.*;

public abstract class Enemy { 
  public abstract int speed; 
  public abstract int x; 
  public abstract int y; 
  public abstract BufferedImage img; 
  
  public Enemy() { 
  }
  
  public abstract void move() {

}
  public abstract void paint (Graphics g) {
 // super.paint(g);
  Graphics2D g2d = (Graphics2D) g;
  g2d.setColor(Color.lightGray);
  g2d.fillRect(0, 0, 1020, 640);
  parcel = new Parcel(); 
  parcel.paint(g2d);
  }
}