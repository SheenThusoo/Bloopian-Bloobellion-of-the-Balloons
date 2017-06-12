import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public abstract class Ammunition
{
  public BloonGame bg;
  public BufferedImage img = null;
  
  public abstract void move();
  //public abstract int paint();
  public abstract void collision();
    
       try { 
         img = ImageIO.read(new File("Bullet.png")); 
       } catch (IOException e) { 
          
       } 
    }  
        try { 
         img = ImageIO.read(new File("Missile.png")); 
       } catch (IOException e) { 
         System.out.println(e); 
       } 
     } 
        try { 
         img = ImageIO.read(new File("Spike.png")); 
       } catch (IOException e) { 
         System.out.println(e); 
       } 
     } 
        try { 
         img = ImageIO.read(new File("SuperTack.png")); 
       } catch (IOException e) { 
         System.out.println(e); 
       } 
     }  
        try { 
         img = ImageIO.read(new File("Tack.png")); 
       } catch (IOException e) { 
         System.out.println(e); 
     } 
      
   } 

}

