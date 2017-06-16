import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public  class SpikeTower extends Tower
{
  
  private int c = 0;
  
  public SpikeTower() 
  {

  }
  public int move () 
  {
    c++;
    if (c % 1000 == 0)
      return 4;
    else 
      return 0;
  }
  public void paint(Graphics g)
  {
    g.drawImage(spikeTower, x+400, y, null);
  }
  public void placeTower(int[][] path, int arrayX, int arrayY)
  {
    if (path[arrayY][arrayX] == 0)
      path[arrayY][arrayX] = 9;
  }
}
