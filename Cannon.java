import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public  class Cannon extends Tower
{
  public Cannon(BloonGame bg)
  {
    this.bg = bg;
  }
   public void paint(Graphics g)
  {
    g.drawImage(cannon, x +100, y-5, null);
  }
   public void placeTower(int[][] path, int arrayX, int arrayY)
   {
     path[arrayY][arrayX] = 6;
   }
}
