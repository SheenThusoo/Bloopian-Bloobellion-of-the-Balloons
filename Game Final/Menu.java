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
  
  public void paint(Graphics g, int lives, int round, int money, int points, boolean pause)
 {
    //paints tower price  
    g.setColor(Color.BLACK);
    g.drawString("$75", 60, 700);
    g.drawString("$100", 160, 700);
    g.drawString("$125", 260, 700);
    g.drawString("$500", 360, 700);
    g.drawString("$150", 460, 700);
    g.drawString("$1000", 550, 700);
    
    //tower points
    g.drawString("1 point", 55, 600);
    g.drawString("2 points", 155, 600);
    g.drawString("3 points", 255, 600);
    g.drawString("0 points", 355, 600);
    g.drawString("4 points", 455, 600);
    g.drawString("5 points", 560, 600);
    
    //paints menu text
    Font currentFont = g.getFont();
    Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
    g.setFont(newFont);
    g.drawString("Lives: " + lives, 930, 590);
    g.drawString("Bloonies: " + money, 930, 620);
    g.drawString("Round: " + round + "/20", 930, 650);
    g.drawString("Points: " + points, 930, 680);
    
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