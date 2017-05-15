import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public abstract class Enemy { 
  public abstract int speed; 
  public abstract int x; 
  public abstract int y; 
  public int xa=1;
  public int ya=1;
  public BufferedImage img; 
  public BloonGame bg;
  
 public Enemy(BloonGame bg, int speed, int x, int y){
    this.bg = bg;
    this.speed = speed;
    this.x= x;
    this.y= y;
    this.xa = xa;
    this.ya= ya;
  }
  public Enemy (BloonGame bg){
   this.bg=bg; 
  }
  
  public Enemy() 
  {
try {
 img = ImageIO.read(new File("balloon_red.png"));

} 
catch (IOException e) 
{
  System.out.println(e);
} 
  }
  public abstract void move() {

}
  public abstract void paint (Graphics g) {
 
  }
}
