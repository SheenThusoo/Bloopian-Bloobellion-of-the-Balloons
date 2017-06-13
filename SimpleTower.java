import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public  class SimpleTower extends Tower
{
  private int x = 0;
  private int y = 0;
  private ArrayList <Enemy> balloonsFinal;
  private boolean shoot = false;
  
  public SimpleTower(BloonGame bg, ArrayList <Enemy> balloonsFinal)
  {
    this.bg = bg;
    this.balloonsFinal = balloonsFinal;
  }
  public void paint(Graphics g)
  {
    g.drawImage(simpleTower, x, y, null);
  } 
  public void placeTower(int[][] path, int arrayX, int arrayY )
  {
    if (path[arrayY][arrayX] == 0)
      path[arrayY][arrayX] = 5;
    
  }
  public void shootCheck(int[][] path)
  {
    for (int k = 0; k < 11; k++)
    {
      for (int j = 0; j < 22; j++)
      {
        if (path[k][j] == 5)
        {
          x = j * 50;
          y = k * 50;
          for (int i = 0; i < balloonsFinal.size(); i++){
            if ( (balloonsFinal.get(i).returnX() > (x - 100)) && (balloonsFinal.get(i).returnX() < (x + 100) &&
                                                                  (balloonsFinal.get(i).returnY() > (y - 100)) 
                                                                    && (balloonsFinal.get(i).returnY() > (y + 100))))
              shoot = true;
          }
        }
      }
    }
  }
}

