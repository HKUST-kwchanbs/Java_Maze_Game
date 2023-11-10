import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class KeyboardListener extends KeyAdapter{
 	
 		public void keyPressed(KeyEvent e){
 		    switch(e.getKeyCode()){
		    	case 39:	// -> Right
		    				JerryLocation.direction = 1;
		    			  	break;
		    	case 38:	// -> Top
							JerryLocation.direction = 3;
		    				break;
		    				
		    	case 37: 	// -> Left
							JerryLocation.direction = 2;
		    				break;
		    				
		    	case 40:	// -> Bottom
							JerryLocation.direction = 4;
		    				break;
		    	
		    	default: 	break;
 		    }
 		}
 	
 }
