import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class Oppgave_5_05 
{
	public static void main (String [] args)
	{	
		JTextArea tekstområde = new JTextArea(); // oppretter et tekstområde
		
		tekstområde.setText( "Tall\t Andrepotens\t Tredjepotens" ); //vi erstatter teksten i JTextArea-objektet med dette tekstområdet
		tekstområde.append("\n");
		for (int tall = 1; tall <= 10; tall++)
		{
			tekstområde.append(tall + "\t" + tall*tall + "\t" + tall*tall*tall);//legger til tekst i JTexrArea-objektet
			tekstområde.append("\n");
		}
		
		JOptionPane.showMessageDialog(null, tekstområde, "Rentesrente", JOptionPane.INFORMATION_MESSAGE);
	}
}