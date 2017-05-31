import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public abstract class MissileLauncher extends Tower
{
  public MissileLauncher(BloonGame bg) 
  {
    this.bg = bg;
  }
   public void paint(Graphics g)
  {
    g.drawImage(missileLauncher, 250, 625, null);
  }
}
