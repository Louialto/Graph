
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
/**
 *
 * @author Loui
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        JLabel lbl = new JLabel();
        frame.setLayout(new BorderLayout());
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(750, 750);
    	frame.setTitle("Shape Drawer");
    	ArrayList<GraphElement> shapes = new ArrayList<GraphElement>();
       
         
        JButton rectangle = new JButton("Rectangle");
        
        JButton ellipse = new JButton("Ellipse");
        JButton edge = new JButton("Edge");
        JButton label = new JButton("Label");

        JTextField txtfield = new JTextField("",15);
        panel.add(rectangle);
        panel.add(ellipse);
        panel.add(edge);
       panel.add(label);
        panel.add(txtfield);
       frame.add(panel,BorderLayout.NORTH);
       
    
        
        class AddInterestListenerlbl implements ActionListener{
        
        public void actionPerformed(ActionEvent event) {
          for(int i = 0;i<shapes.size();i++){
              if(shapes.get(i).selected){
                  String input = txtfield.getText();
                 
                  shapes.get(i).setLabel(input);
              }
          }
        }
        
        }
        ActionListener lab = new AddInterestListenerlbl();
        label.addActionListener(lab);
    class AddInterestListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            RectangleNode r = new RectangleNode();
            shapes.add(r);
          
        }
        
    }
    class AddInterestListener2 implements ActionListener {
           public void actionPerformed(ActionEvent event) {
            
           EllipseNode e = new EllipseNode();
           shapes.add(e);
        }
    }
    
// label.addActionListener(new ActionListener(){
  
      public void actionPerformed(ActionEvent event){ 
             String input = txtfield.getText();
          lbl.setText(input);
            
        }
     panel.add(lbl);
}
  
ActionListener rectnode = new AddInterestListener();
rectangle.addActionListener(rectnode);
ActionListener ellipnode = new AddInterestListener2();
ellipse.addActionListener(ellipnode);


JComponent component = new GraphComponent(shapes);
       frame.add(component);


    frame.setVisible(true);
       
    }
    
}
    

