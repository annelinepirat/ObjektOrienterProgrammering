import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.*;

public class EndreKlasseliste 
{
	private Scanner input;
	
	public void aapneFil()
	{
		try
		{
			input = new Scanner (new File ("klasseliste.txt"));
		}
		catch (FileNotFoundException fileNotFoundException)// om try ikke slår til
		{
			JOptionPane.showMessageDialog(null, 
					"Feil ved åpning av fila", 
					null, 
					JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
	}
	
	public void lesFil()
	{
		Karakterprotokoll elev = new Karakterprotokoll ();
		
		JTextArea tekstområde = new JTextArea();
		tekstområde.setText("Fornavn\t Etternavn\t Fag\t Karakter\n");
		
		try
		{
			while (input.hasNext())
			{
				elev.setElevForNavn(input.next());
				elev.setElevEtterNavn(input.next());
				
				tekstområde.append(
						elev.getElevForNavn()
						+ "\t"
						+ elev.getElevEtterNavn()
						+ "\n");
			}
			JOptionPane.showMessageDialog(
					null,
					tekstområde,
					null,
					JOptionPane.PLAIN_MESSAGE);
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
	}
	
	public void lukkFil()
	{
		if (input != null)
			input.close();
	}
}
