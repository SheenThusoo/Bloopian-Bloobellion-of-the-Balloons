public class Map
{
  private int[][] m; 
  
  private Color path = new Color(229, 207, 139);
  private Color grass = new Color(94, 229, 73);
  
  public Map (int[][] m) //receives map array from main
  {
    this.m = m;
  }
  
    public void paint(Graphics g)
    {
      for (int i = 0; i < 11; i++){
        for (int j = 0; j < 22; j++){
          if (m[i][j] == 1)
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
