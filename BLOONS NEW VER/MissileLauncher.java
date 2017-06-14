import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public  class MissileLauncher extends Tower
{
  public MissileLauncher() 
  {

  }
  public int move(){
    return 0;
  }
  public void paint(Graphics g)
  {
    g.drawImage(missileLauncher, x+200, y, null);
  }
  public void placeTower(int[][] path, int arrayX, int arrayY)
  {
    if (path[arrayY][arrayX] == 0)
      path[arrayY][arrayX] = 7;
  }
}
