import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class LagKlasseliste // oppretter klassen LagKlassseliste
{
	private Formatter output;// oppretter en konstruktør som bruker formatter output
	
	public void aapneFil()// starter metoden aapneFil
	{
		try// starter en try-/catch-metode 
		{
			output = new Formatter("Klasseliste.txt");// oppretter en 
		}
		catch (SecurityException se)// hvis ikke try slår igjennom sjekk om den er låst eller ei
		{
			JOptionPane.showMessageDialog(
					null, 
					"", 
					"Du har ikke skriverettigheter til denne fila", 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog 
		}
		catch (FileNotFoundException fnfe)// hvis ikke try slår igjennom sjekk om fila eksisterer
		{
			JOptionPane.showMessageDialog(
					null, 
					"", 
					"Feil ved åpning av fila", 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog
		}// slutt try/catch
	}// slutt på metode "aapneFil"
	
	public void leggTilElev()
	{
		Karakterprotokoll elev = new Karakterprotokoll();// oppretter konstruktør elev
		int svar = JOptionPane.showOptionDialog(
				null,
				"Vil du lese inn elever?",
				"Klasseliste",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				null,
				null);// mulighet til å starte while løkka
		while(svar == JOptionPane.YES_OPTION)
		{
			// få inn elev fornavn og etternavn fra brukeren
			String elevForNavn = JOptionPane.showInputDialog("Skriv inn fornavnet på eleven");
			String elevEtterNavn = JOptionPane.showInputDialog("Skriv inn etternavn på eleven");
			
			try
			{
				// sett elev fornavn og elev etternavn
				elev.setElevForNavn(elevForNavn);
				elev.setElevEtterNavn(elevEtterNavn);
				
				if (elev.getElevForNavn() != null)
				{
					output.format("%s %s\n", 
							elev.getElevForNavn(),
							elev.getElevEtterNavn());
				}//hvis elev fornavn har fått verdi skriv inn i output på denne måten
				else
				{
					JOptionPane.showMessageDialog(null,
					"",
					"Må ha et elevnavn.",
					JOptionPane.PLAIN_MESSAGE);
				}// hvis ikke melding til brukeren
			}
			catch (FormatterClosedException fce)// hvis try ikke slår til - feilmelding
			{
				JOptionPane.showMessageDialog(
						null, 
						"", 
						"Feil ved skriving til fil", 
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			catch (NoSuchElementException ee)// hvis try ikke slår til - feilmelding
			{
				JOptionPane.showMessageDialog(
						null, 
						"", 
						"Feil input, prøv igjen", 
						JOptionPane.PLAIN_MESSAGE);// feilmelding
			}// slutt try/catch blokk
			svar = JOptionPane.showOptionDialog(null, 
					"Vil du lese inn flere elever?", 
					"Klasseliste", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, 
					null);// ny mulighet til å starte på nytt
		}// while så lenge det svares YES
	}//slutt på metoden leggTilElev
	
	public void lukkFil()
	{
		if (output != null)//hvis det har blitt skrevet noe i output
		output.close();//lukk
	}// slutt på metoden lukkFil
}// slutt på klassen