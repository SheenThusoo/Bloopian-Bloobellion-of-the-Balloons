import java.awt.*;
import javax.swing.*;

public  class Cannon extends Tower
{
  
  private int c = 0;
  
  public Cannon()
  {
    
  }
  
  public int move(){
    c++;
    if (c % 1000 == 0)
      return 2;
    else 
      return 0;
  }
  
  public void paint(Graphics g)
  {
    g.drawImage(cannon, x +100, y-5, null);
  }
  public void placeTower(int[][] path, int arrayX, int arrayY)
  {
    if (path[arrayY][arrayX] == 0)
      path[arrayY][arrayX] = 6;
  }
}
