import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class RookieBalloon extends Enemy 
{ 
  private int [][]path;
  private int diff;
  
  public RookieBalloon(int [][] path, char diff) 
  { 
    super(path, diff, 'r', 1);
  }

  public void move()
  {
    super.move();
  }

  public void paint (Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g2d);
  }

} 
