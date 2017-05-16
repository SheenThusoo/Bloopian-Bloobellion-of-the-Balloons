import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Maps
{
  //11 rows, 22 columns. [11][22] 22 is y, 11 is x
  private int[][] easy = { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0}, {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0}, 
    {0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0}, {0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, {0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
    {1,1,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0}, {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
    {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} };
 
  private int[][] medium = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0}, {0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0}, 
    {0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0},
    {0,0,1,0,0,0,1,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1}, {0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0}, {1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
  
  private int[][] hard = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
    {0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1}, {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
  
  private Color path = new Color(229, 207, 139);
  private Color grass = new Color(94, 229, 73);
  
    public void paint(Graphics g)
    {
      for (int i = 0; i < 11; i++){
        for (int j = 0; j < 22; j++){
          if (hard[i][j] == 1)
          {
            g.setColor(path);
          }else {
            g.setColor(grass);
        }
          g.fillRect(j * 50, i * 50, 50, 50);
        }
      }
        
    }

}
