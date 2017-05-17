import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;


public abstract class Tower
{
  public  int x;
  public  int y;
  public  int range;
  public  int level;
  public  int price;
  public  int reducedPrice;
  public BufferedImage img = null; 
  public BloonGame bg;
  
   public Tower(BloonGame bg, int range, int x, int y, int level, int price, int reducedPrice)
  {
    this.bg = bg;
    this.range = range;
    this.x= x;
    this.y= y;
    this.level = level;
    this.price= price;
    this.reducedPrice= reducedPrice;
  }
  public Tower (BloonGame bg)
  {
   this.bg=bg; 
  }
 
  
  public Tower() 
  {
try {
 img = ImageIO.read(new File("balloonred.png"));

} 
catch (IOException e) 
{
  System.out.println(e);
} 
  }
  public abstract void move ();
  public abstract void paint(Graphics g);
}
