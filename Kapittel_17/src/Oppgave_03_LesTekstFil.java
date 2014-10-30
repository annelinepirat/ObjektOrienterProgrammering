import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;

public class Oppgave_03_LesTekstFil // oppretter klassen
{
	private Scanner input;
	
	public void aapneFil()// oppretter metode "aapneFil"
	{
		try// try/catch-blokk
		{
			input = new Scanner (new File ("kunder.txt"));// åpner kunder.txt og lagrer i input
		}
		catch (FileNotFoundException fileNotFoundException)// om try ikke slår til
		{
			JOptionPane.showMessageDialog(null, 
					"Feil ved åpning av fila", 
					null, 
					JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
	}//slutt metode "aapneFil"
	
	public void lesPoster()// oppretter metode "lesPoster"
	{
		KontoPost post = new KontoPost ();// oppretter konstruktør
		
		JTextArea tekstområde = new JTextArea();// oppretter tekstområde
		tekstområde.setText ("Kontonr\t Fornavn\t Etternavn\t Balanse\n\n");// setter "overskrift"
		
		try// try/catch-blokk
		{
			while (input.hasNext())// while-løkke
			{
				post.setKonto(input.nextInt());// starter å lese i dokumentet og sender teksten til KontoPost
				post.setForNavn(input.next());// starter å lese i dokumentet og sender teksten til KontoPost
				post.setEtterNavn(input.next());// starter å lese i dokumentet og sender teksten til KontoPost
				post.setBalanse(input.nextDouble());// starter å lese i dokumentet og sender teksten til KontoPost
				
				tekstområde.append(
						post.getKonto() 
						+ "\t" 
						+ post.getForNavn() 
						+ "\t" 
						+ post.getEtterNavn()
						+ "\t"
						+ post.getBalanse()
						+ "\n");// legg til tekst i tekstområde fra get-metodene fra KontoPost
			}//slutt while-løkke (når det ikke er mer tekst)
			JOptionPane.showMessageDialog(
					null, 
					tekstområde, 
					null, 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog med utskrift tekstområde
		}
		
		catch (NoSuchElementException elementException)// sjekker om det er noe feil
		{
			JOptionPane.showMessageDialog(
					null, 
					"Upassende format i fila", 
					null, 
					JOptionPane.PLAIN_MESSAGE);
			input.close();
			System.exit(1);
		}
		catch (IllegalStateException stateException)// sjekker om det er noe feil
		{
			JOptionPane.showMessageDialog(
					null, 
					"Feil i lesing fra fil", 
					null, 
					JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
	}// slutt metode "lesPoster"
	
	public void lukkFil()// oppretter metode "lukkFil"
	{
		if (input != null)
			input.close();// om input er forskjellig fra null lukk
	}// slutt metode "lukkFil"
}// slutt på klassen