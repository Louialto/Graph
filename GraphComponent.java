
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import javax.swing.JComponent;

import javax.swing.JPanel;

/**
 *
 * @author Loui
 */
public class GraphComponent extends JComponent {

    private ArrayList<GraphElement> shapes;
    
 
    public GraphComponent(ArrayList<GraphElement> shape) {
    
    
        shapes = shape;
    



    class MyListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
         
            {
                for (int i = 0; i < shapes.size(); i++) {
                    if(shapes.get(i).getXPos() == 0){
                        shapes.get(i).moveTo(event.getX(),event.getY());
                    repaint();
                    }
                    else if (shapes.get(i).isClicked(event.getX(), event.getY())) {
                        
                         shapes.get(i).selected = true;
                        shapes.get(i).setColor(Color.BLUE);
                       
                        repaint();
                    }
                    else if (!shapes.get(i).isClicked(event.getX(),event.getY())) {
                           shapes.get(i).setColor(Color.BLACK);
                           shapes.get(i).selected = false;
                           repaint();
                        }
                    
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent event) {
            /*  for (int i =0; i< shapes.size();i++)
             {
             if(shapes.get(i).getShape().contains(event.getX(),event.getY()))
             {
                         
             selected = shapes.get(i);
                            
                           
             }
             }*/
        }

        @Override
        public void mouseEntered(MouseEvent me) {

        }

        @Override
        public void mouseExited(MouseEvent me) {

        }

        @Override
        public void mouseReleased(MouseEvent me) {
         
        }
        
    }
    MouseListener listener = new MyListener();
    addMouseListener(listener);
    

    class MyMotionListener implements MouseMotionListener {

        @Override
        public void mouseMoved(MouseEvent me) {

        }

        @Override
        public void mouseDragged(MouseEvent event) {
          
                for (int i = 0; i<shapes.size();i++) {
                   
                    if (shapes.get(i).selected) {
                     
                        shapes.get(i).moveTo(event.getX(),event.getY());
                        repaint();
                    }
                }

        }

    }
    MouseMotionListener Motionlistener = new MyMotionListener();
    addMouseMotionListener(Motionlistener);
    }

    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
    

        for (int i = 0; i < shapes.size(); i++) {
            // g2.draw(shapes.get(i).getShape());
            shapes.get(i).draw(g2);
        }

    }
    
}
