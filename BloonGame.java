import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BloonGame extends JPanel 
{
  public int lives; 
  public int money; 
  public int roundNumber;
  
  /*
  public CityScape() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }
      @Override
      public void keyReleased(KeyEvent e) {
        ufo.keyReleased(e);
      }
      @Override
      public void keyPressed(KeyEvent e) {
        ufo.keyPressed(e);
      }
    });
    setFocusable(true);
  } 
  */
  
  public void move() 
  {
    
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    
    //Background
    Color customColor = new Color(0, 0, 51);
    g2d.setColor(customColor);
    g2d.fillRect(0, 0, 1100, 750);
    
    g2d.setColor(Color.white);
    g2d.fillRect(30, 30, 50, 50);
    g2d.fillRect(0, 550, 1100, 200);
    
  }
  
  public static void main(String[] args) throws InterruptedException 
  {
    JFrame frame = new JFrame("BloonGame");
    //Add our JPanel to the frame
    frame.add(new BloonGame());
    frame.setSize(1100, 750);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    BloonGame p = new BloonGame();
    frame.add(p);
    
    while (true)
    {
      p.move();
      p.repaint();
      Thread.sleep(10);
    } 
  }
}
