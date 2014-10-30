import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class Oppgave_02_LagTekstFil // oppretter klassen "Oppgave_02_LagTekstFil" som blir kalt opp i testen
{
	private Formatter output; // lager en Formatter "output"
	
	public void aapneFil()// oppretter metoden "aapneFil"
	{
		try// starter try/catch blokk
		{
			output = new Formatter("kunder.txt");// åpner/oppretter fila og lagrer data i output
		}
		catch (SecurityException securityException)// hvis ikke try slår igjennom sjekk om den er låst eller ei
		{
			JOptionPane.showMessageDialog(
					null, 
					"", 
					"Du har ikke skriverettigheter til denne fila", 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog 
			System.exit(1);// avslutt 
		}
		catch (FileNotFoundException fileNotFoundException)// hvis ikke try slår igjennom sjekk om fila eksisterer
		{
			JOptionPane.showMessageDialog(
					null, 
					"", 
					"Feil ved åpning av fila", 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog
			System.exit(1);// avslutt
		}// slutt try/catch
	}// slutt på metode "aapneFil"
	
	public void leggTilPost()// oppretter metoden "leggTilPost"
	{
		KontoPost post = new KontoPost();// oppretter konstruktør "post" som kaller på klassen "Oppgave_02_KontoPost"
		int svar = JOptionPane.showOptionDialog(
				null, 
				"Vil du lese inn flere poster?", 
				"Kontonummer", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				null, 
				null);// start en OptionDialog med yes, no alternativer som legger seg i variabelen svar
		while (svar == JOptionPane.YES_OPTION)// starter while løkke så lenge det er trykket yes i svar
		{
			int knt = Integer.parseInt(JOptionPane.showInputDialog("Skriv kontonr:"));//InputDialog(int) der man skriver inn kontonr. som legger seg i variabelen knt
			String fNavn = JOptionPane.showInputDialog("Skriv fornavn");// InputDialog(String) der man skriver inn fornavn der variabelen fNavn får verdi
			String eNavn = JOptionPane.showInputDialog("Skriv etternavn");// InputDialog(String) der man skriver inn etternavn der variabelen eNavn får verdi
			double bal = Double.parseDouble(JOptionPane.showInputDialog("Skriv balanse"));// InputDialog(double) der man skriver inn balansen der variabelen bal får verdi
			
			try// start try/catch-blokk
			{
				post.setKonto(knt);//konstruktøren post brukes for å sette verdi på setKonto ved hjelp av variabelen knt
				post.setForNavn(fNavn);//konstruktøren post brukes for å sette verdi på setForNavn ved hjelp av variabelen fNavn
				post.setEtterNavn(eNavn);//konstruktøren post brukes for å sette verdi på setEtterNavn ved hjelp av variabelen eNavn
				post.setBalanse(bal);//konstruktøren post brukes for å sette verdi på setBalanse ved hjelp av variabelen bal
				
				if (post.getKonto () > 0)//if-test som slår til så lenge getKonto er større enn 0
				{
					output.format("%d %s %s %.2f\n", 
							post.getKonto(), 
							post.getForNavn(), 
							post.getEtterNavn(), 
							post.getBalanse());// bestemmer hvordan output skal se ut (int, string, string, double) deretter setter verdi til de ulike bestemmelsene
				}
				else// hvis if-test ikke stemmer
				{
					JOptionPane.showMessageDialog(
							null, 
							"", 
							"Kontonr må være > 0", 
							JOptionPane.PLAIN_MESSAGE);// feilmelding om at kontonr må være større enn 0
				}// slutt if-test
			}
			catch (FormatterClosedException formatterClosedException)// hvis try ikke slår til - feilmelding
			{
				JOptionPane.showMessageDialog(
						null, 
						"", 
						"Feil ved skriving til fil", 
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			catch (NoSuchElementException elementException)// hvis try ikke slår til - feilmelding
			{
				JOptionPane.showMessageDialog(
						null, 
						"", 
						"Feil input, prøv igjen", 
						JOptionPane.PLAIN_MESSAGE);// feilmelding
			}// slutt try/catch blokk
			svar = JOptionPane.showOptionDialog(
					null, 
					"Vil du lese inn flere poster?", 
					"Kontonummer", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, 
					null);// samme som over for å gi brukeren en sjanse til å avslutte løkka
		}//slutt while-løkke
	}// slutt på metode "leggTilPost"
	
	public void lukkFil () // oppretter metoden "lukkFil"
	{
		if (output != null)// if-test som sjekker om output er forskjellig fra null
			output.close();// lukker output
	}// slutt på metoden "lukkFil"
}// slutt på klassen "Oppgave_02_LagTekstFil"
