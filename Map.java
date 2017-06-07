import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;

public class Map
{
  private int[][] m; 
  
  private Color path = new Color(229, 207, 139);
  private Color grass = new Color(94, 229, 73);
  
  public BufferedImage moneyCreator; 
  public BufferedImage cannon;
  public BufferedImage missileLauncher; 
  public BufferedImage simpleTower; 
  public BufferedImage spikeTower;
  public BufferedImage superFighter;
  
  public Map (int[][] m) //receives map array from main
  {
    this.m = m;
    
    try {
      moneyCreator = ImageIO.read(new File("MoneyCreator.png"));
      
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    } 
    
    try {
      cannon = ImageIO.read(new File("Cannon.png"));
      
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    } 
    
    try {
      missileLauncher = ImageIO.read(new File("MissileLauncher.png"));
      
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    } 
    try {
      simpleTower = ImageIO.read(new File("SimpleTower.png"));
      
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    } 
    
    try {
      spikeTower = ImageIO.read(new File("SpikeTower.png"));
      
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    } 
    try {
      superFighter = ImageIO.read(new File("SuperFighter.png"));
      
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    } 
  }
  
  public void paint(Graphics g)
  {
    //5 = simple tower, 6 = cannon, 7 = missile, 8 = money creator, 9 = spike tower, 10 = super tower
    for (int i = 0; i < 11; i++){
      for (int j = 0; j < 22; j++){
        if (m[i][j] == 0)
        {
          g.setColor(grass);
          g.fillRect(j * 50, i * 50, 50, 50);
        } else if (m[i][j] == 1 || m[i][j] == 2 || m[i][j] == 3 || m[i][j] == 4) {
          g.setColor(path);
          g.fillRect(j * 50, i * 50, 50, 50);
        }
        else if(m[i][j] == 5)
        {
          g.drawImage(simpleTower, j * 50, i * 50, null);
        }
        else if(m[i][j] == 6)
        {
          g.drawImage(cannon, j * 50, i * 50, null);
        }
        else if(m[i][j] == 7)
        {
          g.drawImage(missileLauncher, j * 50, i * 50, null);
        }
        else if(m[i][j] == 8)
        {
          g.drawImage(moneyCreator, j * 50, i * 50, null);
        }
        else if(m[i][j] == 9)
        {
          g.drawImage(spikeTower, j * 50, i * 50, null);
        }
        else if(m[i][j] == 10)
        {
          g.drawImage(superFighter, j * 50, i * 50, null);
        }
          else {}
      }
    }
    
  }
  
}
