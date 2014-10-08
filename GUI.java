import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends MainFrame implements ActionListener {
	
	private final String taInitalText = "No Customer Selected\n\n";
	
	Customer activeCustomer = null;

	private JLabel lbTitle = new JLabel("Search:", JLabel.CENTER);
	private JTextField txtSearchBar = new JTextField(10);
	private JTextArea taCustDetails = new JTextArea(taInitalText);
	private JButton btnButton = new JButton("Button");
	private JButton btnAddCustomer = new JButton("Add Customer");
	private JButton btnAddItem = new JButton("Add Menu Item");
	private JButton btnEditItem = new JButton("Edit Menu Item");
	private JButton btnSearchForCustomer = new JButton(" Customer Search");
	private JButton btnSearchForItem = new JButton("Menu Item Search");
	
	//Customers / Menu
	private JList lstMenu = new JList();
	
	//The customer's order
	private JList lstOrder = new JList();
	
	/**
	 * This Constructor for SubClassObject creates an instance of this Class by utilising the MainFrame Class constructor 
	 * as the super constructor.
	 */
	//Set up SubClassObject Constructor.
	public GUI(){
		//Use superclass constructor to create JFrame.
		super("Shop");
		
		
		//Set width and height for this JFrame. Make it set in stone.
		getCurrentFrame().setSize(600, 400);
		getCurrentFrame().setResizable(false);
		//Set xy location on screen.
		getCurrentFrame().setLocation(100, 100);
		
		//Create a new JLable with the title, make it centred.
		JLabel lbProgramTitle = new JLabel(" Take Away and Home Delivery", JLabel.CENTER);
		
		//Set the JLable font for the title label
		lbProgramTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		
		//Set txt's and make them unable to edited by CCC
		//txtPriority.setText(""+Sup.generateNextPriority());
		//txtPriority.setEditable(false);
		
		Dimension maxSearchBar = new Dimension(500, 20);
		txtSearchBar.setSize(500, 20);
		txtSearchBar.setMaximumSize(maxSearchBar);
		
		Dimension maxCustomerDetails = new Dimension(375, 300);
		taCustDetails.setMaximumSize(maxCustomerDetails);
		taCustDetails.setEditable(false);
		
		//Create the Menu into String
		ArrayList<MenuItem> menu = DatabaseSystem.getMenuItems();
		String[] menuArray = new String[menu.size()];
		
		for(int x = 0; x < menu.size(); x++){
			menuArray[x] = menu.get(x).toString();
		}
		//Load the menu into the JList
		lstMenu = new JList(menuArray);
		
		JScrollPane scrMenu = new JScrollPane(lstMenu);
		JScrollPane scrOrder = new JScrollPane(lstOrder);
		
		//Set maximum sizes
		Dimension maxMenuSize = new Dimension(200, 300);
		scrMenu.setMaximumSize(maxMenuSize);
		
		Dimension maxOrderSize = new Dimension(375, 200);
		scrOrder.setMaximumSize(maxOrderSize);
		
		//Add ActionListeners to the JButtons.
		btnButton.addActionListener(this);
		btnSearchForCustomer.addActionListener(this);
		btnSearchForItem.addActionListener(this);
		
		btnAddCustomer.addActionListener(this);
		btnAddCustomer.addActionListener(this);
		btnAddItem.addActionListener(this);
		btnEditItem.addActionListener(this);
		
		//Setup Boxes
		//Create a Box for the NORTH layout section which will contain lbCompanyName, Glue, btRefresh and btNewJob. This box will be in X_AXIS layout.
		Box topBox = new Box(BoxLayout.X_AXIS);
		topBox.add(lbProgramTitle);	topBox.add(Box.createGlue());
		
		//Create a Box for the CENTER layout section which will contain a verticalStrut, a Box, a Box, a verticalStrut, a horizontalStrut and another Box. This box will be in Y_AXIS layout.
		Box midBox = new Box(BoxLayout.Y_AXIS);
		midBox.add(Box.createVerticalStrut(10));
		midBox.add(Box.createGlue());
		
		//Create a variable for consistency in aligning vertical struts
		int vs = 30;
		
		//Create a Boxes to be contained within midBox which will contain the meat of the program interface. 
		/* Box 0A - Add to Box 0
		 * Create the Search for buttons
		 */
		Box midBoxPlugin0A = new Box(BoxLayout.Y_AXIS);
		midBoxPlugin0A.add(btnSearchForCustomer);
		midBoxPlugin0A.add(btnSearchForItem);
		
		/* Box 0B - Add to Box 0
		 * Create the Search bar and size it correctly
		 */
		Box midBoxPlugin0B = new Box(BoxLayout.Y_AXIS);
		midBoxPlugin0B.add(txtSearchBar);
		
		/* Box 0
		 * Add the two previous boxes together and ensure that they all look neat.
		 */
		Dimension maxBox0 = new Dimension(600, 75);
		
		Box midBoxPlugin0 = new Box(BoxLayout.X_AXIS);
		//midBoxPlugin0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		midBoxPlugin0.setMaximumSize(maxBox0);
		
		midBoxPlugin0.add(Box.createHorizontalStrut(vs));	midBoxPlugin0.add(lbTitle);	midBoxPlugin0.add(Box.createHorizontalStrut(10)); 
		midBoxPlugin0.add(midBoxPlugin0B); midBoxPlugin0.add(Box.createHorizontalStrut(5));
		midBoxPlugin0.add(midBoxPlugin0A);

		midBox.add(midBoxPlugin0);	//Add to the main GUI

		/* Box 1
		 * Create the main utility options via buttons:
		 * Add Customer, Add Item, Edit Item.
		 */
		Box midBoxPlugin1 = new Box(BoxLayout.X_AXIS);
		midBoxPlugin1.add(btnAddCustomer);	midBoxPlugin1.add(Box.createHorizontalStrut(10));
		midBoxPlugin1.add(btnAddItem);		midBoxPlugin1.add(Box.createHorizontalStrut(10));
		midBoxPlugin1.add(btnEditItem);
		
		midBox.add(midBoxPlugin1);	//Add to the main GUI
		midBox.add(Box.createVerticalStrut(10));	//Add to the main GUI

		/* Box 2A - Add to Box 2
		 * Create the space where the Customer's details will go.
		 * Create the customer's current order list location.
		 */
		Box midBoxPlugin2A = new Box(BoxLayout.Y_AXIS);
		midBoxPlugin2A.add(taCustDetails);	
		midBoxPlugin2A.add(scrOrder);
		
		/* Box 2
		 * Add the previous Box 2A and add the Internal Data List.
		 */
		Box midBoxPlugin2 = new Box(BoxLayout.X_AXIS);
		midBoxPlugin2.add(midBoxPlugin2A);	midBoxPlugin2.add(scrMenu);
		
		midBox.add(midBoxPlugin2);	//Add to the main GUI

		//Box 3
		Box midBoxPlugin3 = new Box(BoxLayout.X_AXIS);
		midBoxPlugin3.add(Box.createHorizontalStrut(50));
		
		midBox.add(midBoxPlugin3);
		midBox.add(Box.createVerticalStrut(20));
		
		//Create a Box that contains the job logging buttons
		Box botBox = new Box(BoxLayout.Y_AXIS);
				
		Box botBoxPlugin = new Box(BoxLayout.X_AXIS);
		botBoxPlugin.add(Box.createHorizontalStrut(5));	
		botBoxPlugin.add(btnButton);	botBoxPlugin.add(Box.createGlue());
		botBoxPlugin.add(Box.createHorizontalStrut(10));
		
		botBox.add(botBoxPlugin);
		botBox.add(Box.createVerticalStrut(10));
		
		//Add appropriate components to the JFrame.
		getCurrentFrame().add(topBox, BorderLayout.NORTH);
		getCurrentFrame().add(midBox, BorderLayout.CENTER);
		getCurrentFrame().add(botBox, BorderLayout.SOUTH);
	}
	

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == btnAddCustomer){
			GUIAddCustomer addNewCustomer = new GUIAddCustomer();
			MainFrame.conclude(addNewCustomer.getCurrentFrame());
			Main.log("out");
		} else if(a.getSource() == btnSearchForCustomer){

			Main.log(this.txtSearchBar.getText());
			Customer searched = DatabaseSystem.getCustomerWithID(DatabaseSystem.findCustomer(this.txtSearchBar.getText()));

			if(searched != null){

				Object[] options = {"Yes", "No"};
				int choice = JOptionPane.showOptionDialog(null, "Did you want Customer "+searched.getName()+" currently at "+searched.getAddress()+" to be the current Customer?",  "Set active customer?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(choice == JOptionPane.YES_OPTION){
					String temp = searched.getName() + "\t\t" + searched.getPhone() + "\n" + searched.getAddress() + "\n" + searched.getCCard();
					this.taCustDetails.setText(temp);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No contact found", "Warning!", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
