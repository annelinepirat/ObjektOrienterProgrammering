import javax.swing.JOptionPane;

public class Oppgave_5_11
{
	public static void main (String [] args)
	{
		String mnd= JOptionPane.showInputDialog(null, "Skriv inn navnet på en mnd og få vite hvor mange dager den innehar");//leser inn fra brukeren
		int  antDager;// oppretter variabel antDager
		mnd = mnd.toLowerCase();// det som er skrevet inn av brukeren gjøres om til små bokstaver
		
		switch (mnd)// starter switch/break, sender inn mnd
		{
			case "april"://sjekker om det er april
			case "juni":// sjekker om det er juni
			case "september":// sjekker om det er september
			case "november": antDager = 30;// sjekker om det er november deretter setter antDager til 30
				break;// bryt ut av switch
			case "februar": antDager = 28;// sjekk om det er februar og sett antDager = 28
				break;// bryt ut av switch
			default: antDager = 31;// hvis det ikke er noen over sett antDager til 31
				break;// bryt ut av switch
		}// slutt på switch/break
		JOptionPane.showMessageDialog(null, "Måneden " + mnd + " inneholder " + antDager + " antall dager.");// melding til brukeren
	}// slutt på main metoden
}// slutt på klassen