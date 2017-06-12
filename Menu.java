import java.awt.image.BufferedImage ;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Menu
{
 
  private boolean moneyError = false;
  private int c; 
  
  public void moneyError (){ //not working yet. text not appearing
    c = 0;
    while (c < 1000){
      moneyError = true;
      c++;
    }
    moneyError = false;
  }
  
  public void paint(Graphics g, int lives, int round, int money, boolean pause)
 {
    //paints tower price  
    g.setColor(Color.BLACK);
    g.drawString("75", 65, 700);
    g.drawString("125", 165, 700);
    g.drawString("150", 265, 700);
    g.drawString("500", 365, 700);
    g.drawString("125", 465, 700);
    g.drawString("1000", 560, 700);
    
    //possible error message
    if (moneyError)
      g.drawString("Insufficient Funds!!", 750, 590);
    
    //paints menu text
    Font currentFont = g.getFont();
    Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
    g.setFont(newFont);
    g.drawString("Lives: " + lives, 930, 590);
    g.drawString("Bloonies: " + money, 930, 640);
    g.drawString("Round: " + round + "/25", 930, 690);
    
    //pause/continue button
    g.setColor(Color.GREEN);
    g.fillRect(680, 620, 150, 50);
    g.setColor(Color.BLACK);
    if (pause)
      g.drawString("Continue", 715, 650);
    else
      g.drawString("Pause", 730, 650);

  }
  
}
