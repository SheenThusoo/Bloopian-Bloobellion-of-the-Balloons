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
 
  }
}
