import java.awt.*;
public class Building {
  private CityScape ba;
  public Building(CityScape ba) {
    this.ba= ba;
  }
  
  private int x;
  private int y;
  private int a;
  private int b;
  private int width;
  private int height;
  
  
  // 2D array of integers representing if lights are on or off
  int[][] window; 
  
  //construtor that demenstrates if the lights are on or off
  
  public Building(int x, int y, int a, int b)
  {
    this.x = x;
    this.y = y;
    this.a = a;
    this.b = b;
    window = new int[a][b];
    
    this.width = ((a + 1) * 10) + (a * 20);
    this.height = ((b + 1) * 10) + (b * 20) + 30;
    
    if (this.height < 800 - y ) 
    {
      this.height = 800 - y;
    }
    
    for(int i = 0; i < a; i++)
    {
      for(int j = 0; j < b; j++)
      {
        if(Math.random() > 0.5)
        {
          window[i][j] = 0;
        }
        else
        {
          window[i][j] = 1;
        }
      }
    }
  }
  
  public void paint(Graphics2D g2d)
  {
    Color customColor = new Color(214, 173, 92);
    g2d.setColor(customColor);
    g2d.fillRect(x, y, width, height);
    
    for (int i = 0; i < a; i++)
    {
      for(int j = 0; j < b; j++)
      {
        if(window[i][j] == 1)
        {
          g2d.setColor(Color.yellow);
          g2d.fillRect(x+10+(i*30), y+10+(j*30), 20, 20);
        }
        else
        {
          g2d.setColor(Color.black);
          g2d.fillRect(x+10+(i*30), y+10+(j*30), 20, 20);
        }
      } 
    } 
  }
}
