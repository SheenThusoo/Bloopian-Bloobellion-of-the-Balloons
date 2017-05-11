import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;


public abstract class Tower
{
 

  public abstract int x;
  public abstract int y;
  public abstract int range;
  public abstract int level;
  public abstract int price;
  public abstract int reducedPrice;
  public BufferedImage img = null; 
 
  public abstract void move ()
  public void paint(Graphics g)
 {
 
 }
}
