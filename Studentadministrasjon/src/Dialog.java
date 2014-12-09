/***********************************************************
 * Dialog.class
 * 
 * Basisklassen for alle vindusklassene (GUI) i programmet.
 * Inneholder det som er felles for alle. * 
 * 
 * 
 * SKREVET AV ÿYSTEIN MRKESDAL
 **********************************************************/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Dialog extends JDialog implements ActionListener{

	/*Nesten alle vinduer vil ha en lukk knapp, så jeg legger denne 
	til i Dialog-klassen de andre vindusklassene vil arve fra.*/
	protected JButton btnLukk = new JButton("Lukk");
	
	protected void setup(){ //Setter standardverider for vinduene jeg vil bruke
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout( new BorderLayout());
		
		btnLukk.addActionListener(this);
	}

	
	protected void centerScreen() {//Sentrerer vinduet midt på skjermen.
		  Dimension dim = getToolkit().getScreenSize();
		  Rectangle abounds = getBounds();
		  setLocation((dim.width - abounds.width) / 2,
		      (dim.height - abounds.height) / 2);
	}


	public void actionPerformed(ActionEvent ae) {//Lytter etter tastetrykk
		if (ae.getSource() == btnLukk){
			setVisible(false);
		}
	}			
		
}
