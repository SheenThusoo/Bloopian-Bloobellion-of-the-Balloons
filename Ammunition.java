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
}
