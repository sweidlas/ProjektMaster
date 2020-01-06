package start.exeptions;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Exception extends Frame implements ActionListener {

	Button okay;
	
	public Exception() {
		super ("Fehlermeldung"); // set title
		GridBagLayout myGBL = new GridBagLayout ();
		setLayout(myGBL);
		
		GridBagConstraints myGBC = new GridBagConstraints();
		setVisible (true);
		
		// generally
		myGBC.fill = GridBagConstraints.HORIZONTAL;
		myGBC.insets = new Insets(5,5,5,5) ; // distance to line: 5 above, 5 left, 5 below, 5 right 
		
		// button okay
		myGBC.gridx = 1;
		myGBC.gridy = 3;
		myGBC.gridwidth = 1; // width of the element
		myGBC.gridheight = 1; // height of the element
		okay = new Button ("Okay");
		okay.setBackground(Color.green);
		okay.addActionListener(this);
		myGBL.setConstraints(okay, myGBC);
		add(okay);
	
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okay )
		{
			this.dispose();
		}
		
	}
}
