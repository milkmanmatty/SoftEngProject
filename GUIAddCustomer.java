import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GUIAddCustomer extends MainFrame implements ActionListener {
	
	private JButton btnSave = new JButton("Save");
	private JButton btnCancel = new JButton("Cancel");
	
	private JLabel lbName = new JLabel("Name:  ", JLabel.CENTER);
	private JLabel lbPhone = new JLabel("Phone:  ", JLabel.CENTER);
	private JLabel lbAddress = new JLabel("Address:", JLabel.CENTER);
	private JLabel lbCredit = new JLabel("Credit Card Details:", JLabel.CENTER);
	
	private JTextField txtName = new JTextField(20);
	private NumberTextField txtPhone = new NumberTextField(20);
	private JTextField txtAddress = new JTextField(100);
	private JTextField txtCreditCard = new JTextField(100);
	
	public GUIAddCustomer(){
		//Use superclass constructor to create JFrame.
		super("Add New Customer");
		
		//Set width and height for this JFrame. Make it set in stone.
		getCurrentFrame().setSize(450, 200);
		getCurrentFrame().setResizable(false);
		//Set xy location on screen.
		getCurrentFrame().setLocation(100, 100);
		
		//Maximum text box sizes
		Dimension maxShortBar = new Dimension(125, 20);
		txtName.setMaximumSize(maxShortBar);
		txtPhone.setMaximumSize(maxShortBar);
		
		Dimension maxLongBar = new Dimension(300, 20);
		txtAddress.setMaximumSize(maxLongBar);
		txtCreditCard.setMaximumSize(maxLongBar);
		
		
		/* Create 4 X_AXIS boxes and add them to a Y_AXIS box at the end.
		 * Create Y_AXIS Box first
		 */
		Box endBox = new Box(BoxLayout.Y_AXIS);
		
		/* Create Box 1
		 * This box will hold the Name and Phone Number of the new customer.
		 */
		Box box1 = new Box(BoxLayout.X_AXIS);
		box1.add(lbName);	box1.add(txtName);
		box1.add(Box.createHorizontalStrut(75));
		box1.add(lbPhone);	box1.add(txtPhone);
		
		endBox.add(box1);	//Add the main GUI
		
		/* Create Box 2
		 * This box will hold the address of the new Customer
		 */
		Box box2 = new Box(BoxLayout.X_AXIS);
		box2.add(lbAddress);	box2.add(Box.createHorizontalStrut(60));	box2.add(txtAddress);
		
		endBox.add(box2);	//Add the main GUI
		
		/* Create Box 3
		 * This box will hold the Credit Card Details of the new Customer
		 */
		Box box3 = new Box(BoxLayout.X_AXIS);
		box3.add(lbCredit);	box3.add(Box.createHorizontalStrut(10));	box3.add(txtCreditCard);
		
		endBox.add(box3);	//Add the main GUI
		
		/* Create Box 4
		 * This box will hold the buttons to end the current process: Save or Cancel
		 */
		Box box4 = new Box(BoxLayout.X_AXIS);
		box4.add(btnSave);
		box4.add(Box.createHorizontalStrut(100));
		box4.add(btnCancel);
		
		endBox.add(box4);	//Add the main GUI
		
		//Add the GUI data to the Frame
		getCurrentFrame().add(endBox, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == btnSave){
			DatabaseSystem.addCustomer(txtName.getText(), txtPhone.getSelectedText(), txtAddress.getText(), txtCreditCard.getText());
			this.getCurrentFrame().dispose();
		} else if(a.getSource() == btnCancel){
			getCurrentFrame().dispose();
		}
	}
}
