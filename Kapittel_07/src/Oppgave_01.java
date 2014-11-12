import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_01 
{
	public static void main (String[] args)
	{
		JTextArea tekstområde = new JTextArea();// oppretter tekstområde
		tekstområde.setText("Tallene var: \n");// setter starttekst i tekstområde
		
		int [] tall = new int [10];
		for (int i = 0; i < tall.length; i++)// starter for løkke som skal skrive inn verdier til arrayen
		{
		tall[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Skriv et heltall:"));// leser inn fra brukeren
		}
		
		for (int i=tall.length-1; i>-1; i--)// starter for løkke som skal skrive ut tallene baklengs
		{
		tekstområde.append (tall[i] + "\n");// legg til tall[i] og linjeskift i tekstområde
		}
		JOptionPane.showMessageDialog(null, tekstområde);// melding til brukeren
	}// slutt på main metoden
}// slutt på klassen