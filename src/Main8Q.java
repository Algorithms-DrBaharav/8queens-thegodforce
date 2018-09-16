
/**
 *
 * @author Dr. Baharav
 * 
 * 
 * 
 * 
 * Homework: Print ALL viable boards. How many are there?
 * 
 */

import javax.swing.JFrame;

public class Main8Q {

    
    public static void main(String[] args) {
        
        
        Solver8x8 s1 = new Solver8x8();
        int[][] b2 = s1.solve();
        
        
        final int DISPLAY_WIDTH = 240 ;
	final int DISPLAY_HEIGHT = 240 ;
		
	JFrame frame = new JFrame();
		
	frame.setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
	frame.setTitle("8-Queens");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//frame.setLayout(null); // we are using absolute location
		
	Display display = new Display(DISPLAY_WIDTH, DISPLAY_HEIGHT);

        display.drawBoard(b2);
	frame.add(display);				
	frame.setVisible(true);
        
    }
    
}
