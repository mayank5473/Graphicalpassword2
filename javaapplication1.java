package javaapplication1;//package for java application

import javax.swing.JFrame;
/**Adds support for the swing component architecture.
  *declaration--public class JFrame
                        extends Frame
                          implements WindowConstants,Accessible, RootPaneContainer
 */
import javax.swing.JPanel;
/*JPanel is a generic lightweight container(java servelet).
   *declaration--public class JPanel
                        extends Panel
                          implements Accessible
    
*/


public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //JPanel menu = new login();
        JPanel menu = new MainMenu(); //Adding a MainMenu.java component to the panel (which will be made by other group member).
        JFrame frame = new JFrame();//we are creating a window frame just like other java objects.
        frame.setBounds(0, 0, 400, 400);
        /*setBounds is used to define the bounding rectangle of a JFrame Form. This includes it's position and size.
         *setBounds(x, y, width, height) is use to specify the position and size of a GUI component.
        */
        frame.add(menu);
         /*
          We can use the method add(component) to add a component to the frame's content pane.
        eg-frame.add(child);
        And the child will be added to the contentPane. The content pane will always be non-null.
        */
        frame.setVisible(true);
        /*
        * if frame.setVisible is set false then the confirm will confirm it but it wont move to MainMenu page.
        *if frame.setVisible is set to true it will move to MainMenu page.
        */

    }
    
}
