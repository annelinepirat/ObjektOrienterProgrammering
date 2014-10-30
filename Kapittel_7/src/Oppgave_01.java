import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_01 
{
	public static void main (String[] args)
	{
		JTextArea tekstområde = new JTextArea();
		tekstområde.setText("Tallene var: \n");
		
		int [] tall = new int [10];
		for (int i = 0; i < 10; i++)
		{
		tall[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Skriv et heltall:"));
		tekstområde.append (tall[i] + "\n");
		}
		JOptionPane.showMessageDialog(null, tekstområde);
	}
}
