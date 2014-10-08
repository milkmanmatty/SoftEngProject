
//import only what is needed.
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * The main class for the GUI, all GUI classes extend this one.
 * @author Matt
 * @version	1.0
 */
public class MainFrame {
	private JFrame currentFrame;
	
	/**
	 * This Constructor is the main Constructor, and should only be invoked to create a new instance of the program. This creates a new JFrame and gives
	 * it a <code>WindowsLookAndFeel</code>, sets the class-defined title and sets the size. Lastly, it gives the newly created JFrame the <code>DefaultCloseOperation</code>
	 * of <code>EXIT_ON_CLOSE</code>. This means that when the newly created JFrame is closed, all other currently executing JFrames associated with it (which will be all
	 * of them) will also be closed.
	 * 
	 * @param title	sets the title for the newly created JFrame.
	 */
	public MainFrame(String title){
		try {
			//Make the look and feel Windows.
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        
	        //Hope there's not an exception. If there ever an exception is it's an undocumented feature :)
	    } catch (Exception evt) {}
			    
	    //Create a new JFrame with user-defined title. Make it referenceable so that other classes can refer to it.
		setCurrentFrame(new JFrame(title));
		this.getCurrentFrame().setResizable(false);
		
		//Exit not dispose. When this JFrame is closed, the entire program is closed.
		getCurrentFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Sets the provided JFrame to visible.
	 * @param Jf	the JFrame to become visible.
	 * 
	 * @see ChangeDirectory#show()
	 */
	public static void conclude(JFrame Jf){
		//Makes the JFrame visible to the user.
		Jf.setVisible(true);
	}
	
	/**
	 * Gets the current currentFrame. This method (when coupled with <code>setCurrentFrame()</code>) provides a way for other methods to reference 
	 * the current JFrame (whether that be an instance of MainFrame, GUI or GUIAddCustomer). When dealing with non-static references 
	 * spanning over multiple classes this method is essential. Accessor method.
	 * 
	 * @return	the current currentFrame.
	 */
	public JFrame getCurrentFrame() {
		return currentFrame;
	}
	
	/**
	 * Sets the current <code>JFrame</code> (currentFrame) instance to the JFrame provided.
	 * This method (when coupled with <code>getCurrentFrame()</code>) provides a way for other methods to reference 
	 * the current JFrame (whether that be an instance of MainFrame, GUI or GUIAddCustomer). When dealing with non-static references 
	 * spanning over multiple classes this method is essential. Mutator method.
	 * @param sFrame	the JFrame to be set to the current JFrame. 
	 */
	public void setCurrentFrame(JFrame sFrame) {
		currentFrame = sFrame;
	}	
}

