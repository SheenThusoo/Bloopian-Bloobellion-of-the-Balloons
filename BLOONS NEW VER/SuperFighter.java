import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public  class SuperFighter extends Tower
{
  public SuperFighter()
  {
   
  }
  public int move(){
    return 0;
  }
  public void paint(Graphics g)
  {
    g.drawImage(superFighter, x+500, y, null);
  }
  public void placeTower(int[][] path, int arrayX, int arrayY)
  {
    if (path[arrayY][arrayX] == 0)
      path[arrayY][arrayX] = 10;
  }
}
