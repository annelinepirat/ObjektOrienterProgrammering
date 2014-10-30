import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class LagKlasseliste 
{
	private Formatter output;
	
	public void aapneFil()
	{
		try
		{
			output = new Formatter("Klasseliste.txt");
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
		Karakterprotokoll elev = new Karakterprotokoll();
		int enElev = JOptionPane.showOptionDialog(
				null,
				"Vil du lese inn en elev?",
				"Klasseliste",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				null,
				null);
		while(enElev == JOptionPane.YES_OPTION)
		{
			String elevForNavn = JOptionPane.showInputDialog("Skriv inn fornavnet på eleven");
			String elevEtterNavn = JOptionPane.showInputDialog("Skriv inn etternavn på eleven");
			
			try
			{
				elev.setElevForNavn(elevForNavn);
				elev.setElevEtterNavn(elevEtterNavn);
				
				if (elev.getElevForNavn() != null)
				{
					output.format("%s %s\n", 
							elev.getElevForNavn(),
							elev.getElevEtterNavn());
				}
				else
				{
					JOptionPane.showMessageDialog(null,
					"",
					"Må ha et elevnavn.",
					JOptionPane.PLAIN_MESSAGE);
				}
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
			enElev = JOptionPane.showOptionDialog(null, 
					"Vil du lese inn flere elever?", 
					"Klasseliste", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, 
					null);
		}
	}
	
	public void lukkFil()
	{
		if (output != null)
		output.close();
	}
}
