import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public abstract class MoneyCreator extends Tower
{
  public MoneyCreator(BloonGame bg)
  {
    this.bg = bg;
  }
   public void paint(Graphics g)
  {
     g.drawImage(moneyCreator, 350, 625, null);
  }
}
