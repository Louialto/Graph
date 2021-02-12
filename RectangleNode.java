
import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author Loui
 */
public class RectangleNode extends GraphElement {
    private double x;
    private double y;
    Rectangle2D.Double rect;
   
    
    public RectangleNode(){
      super();
    }
    
  
   //SwingUtilities.isRightMouseButton(event)
    
    @Override
   void draw(Graphics2D g2) {
    g2.setColor(super.color);
    x = super.getXPos();
    y = super.getYPos();
    rect = new Rectangle2D.Double(x,y,80,50);
    g2.draw(rect);
    g2.drawString(super.label, (float) x+12 , (float) y +25);
   
        
    }

    @Override
    boolean isClicked(double x, double y) {
     if((Double)x == null){
        return false;
    }else{
            return rect.contains(x,y);
     }
    }

    @Override
    boolean applyLabel() {
      return true;
    }
    
    
    
}
