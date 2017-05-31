import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public abstract class SimpleTower extends Tower
{
  public SimpleTower(BloonGame bg)
  {
    this.bg = bg;
  }
   public void paint(Graphics g)
  {
    g.drawImage(simpleTower, 50,625, null);
  }
}
  
