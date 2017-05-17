import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;


public class IceBalloon extends Enemy { 
  public IceBalloon(BloonGame bg) { 
  this.bg = bg;
  }
} 
public  void move()
  {
    if (x + xa < 0)
      xa = 1;
    if (x + xa > 800 - 50)
      xa = -1;
    if (y + ya < 0)
      ya = 1;
    if (y + ya > 175 - 50)
      ya = -1;
    x = x + xa;
    y = y + ya;
}
  public  void paint (Graphics g)
  {
  g.drawImage(img, x, 100, null);
  }

} 
