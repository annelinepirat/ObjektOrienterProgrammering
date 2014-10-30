// importerte klasser
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_01_FilDemo// starter klassen "Oppgave_01_FilDemo"
{
	public static void main (String [] args)// start "main" metode
	{
		String sti = JOptionPane.showInputDialog(null, "Oppgi filnavn eller sti: ");// InputDialog der man skriver inn filnavn
		
		sjekkSti (sti);// Kaller opp metoden "sjekkSti" med verdi sti
	}// slutt main metode
	public static void sjekkSti (String sti)// starter "sjekkSti" metode
	{
		File filNavn = new File (sti);// oppretter en konstruktør med navn "filNavn" der vi kaller opp File
		
		JTextArea tekstområde = new JTextArea();// oppretter en kontruktør "tekstområde" der vi kaller opp JTextArea
		tekstområde.setText(sti);// setter inn input-navn fra brukeren i tekstområde (sti)
		
		if (filNavn.exists())//start if-test (om filNavn eksisterer)
		{
			tekstområde.append(" finnes");// hvis filen eksisterer legg til...
			if (filNavn.isFile())// start ny if-test som sjekker om det er en fil
				tekstområde.append(", er en fil");// hvis ja, legg til...
			else
				tekstområde.append(", er ikke en fil");// hvis ikke, legg til...
			if (filNavn.isDirectory())// ny if-test som sjekker om det er en filbane
				tekstområde.append(", er en filbane");// hvis ja, legg til...
			else
				tekstområde.append(", er ikke en filbane");// hvis ikke, legg til...
			
			JOptionPane.showMessageDialog(null, tekstområde, "Info om fil", JOptionPane.PLAIN_MESSAGE);// MessageDialog med tekstområde og info om fil
		}// slutt if-test
		else
			JOptionPane.showMessageDialog(null, "Denne filen eksisterer ikke", "Feilmelding", JOptionPane.PLAIN_MESSAGE);// MessageDialog med feilmelding
	}// slutt "sjekkSti" metode
}// slutt på klassen
