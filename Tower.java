import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;


public abstract class Tower
{
  public  int x;
  public  int y;
  public  int range;
  public  int level;
  public  int price;
  public  int reducedPrice;
  public BufferedImage moneyCreator; 
  public BufferedImage cannon;
  public BufferedImage missileLauncher; 
  public BufferedImage simpleTower; 
  public BufferedImage spikeTower;
  public BufferedImage superFighter;
  public BloonGame bg;
  
   public Tower(BloonGame bg, int range, int x, int y, int level, int price, int reducedPrice)
  {
    this.bg = bg;
    this.range = range;
    this.x= x;
    this.y= y;
    this.level = level;
    this.price= price;
    this.reducedPrice= reducedPrice;
  }
  public Tower (BloonGame bg)
  {
   this.bg=bg; 
  }
 
  
  public Tower() 
  {
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
  //public abstract void move ();
  public abstract void paint(Graphics g);
}
