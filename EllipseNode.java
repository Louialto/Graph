
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Loui
 */
public class EllipseNode extends GraphElement{
  private double x;
    private double y;
   Ellipse2D.Double ellip;
    
    public EllipseNode(){
        super();
    }
    
    @Override
    void draw(Graphics2D g2) {
         g2.setColor(super.color);
    x = super.getXPos();
    y = super.getYPos();
    ellip = new Ellipse2D.Double(x,y,80,50);
    g2.draw(ellip);
    g2.drawString(super.label, (float) x+12 , (float) y +25);
    }

    @Override
    boolean isClicked(double x, double y) {
         if((Double)x == null){
        return false;
    }else{
            return ellip.contains(x,y);
     }
    }

    @Override
    boolean applyLabel() {
        return true;
    }
    
}
