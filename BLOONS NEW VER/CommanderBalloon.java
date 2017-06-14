import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class CommanderBalloon extends Enemy 
{ 
  private int [][]path;
  private int diff;
  
  public CommanderBalloon(int [][] path, char diff) 
  { 
    super(path, diff, 'c', 2);
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
