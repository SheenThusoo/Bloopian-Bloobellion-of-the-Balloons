import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public abstract class Cannon extends Tower
{
  public Cannon(BloonGame bg)
  {
    this.bg = bg;
  }
   public void paint(Graphics g)
  {
    g.drawImage(cannon, 150, 625, null);
  }
}
