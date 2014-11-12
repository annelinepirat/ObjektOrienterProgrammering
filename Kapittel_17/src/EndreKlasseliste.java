import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.*;

public class EndreKlasseliste 
{
	private Scanner input;
	private Formatter output;
	
	public void aapneFil()
	{
		try
		{
			input = new Scanner (new File ("klasseliste.txt"));
			output = new Formatter("Karakterprotokoll.txt");
		}
		catch (SecurityException se)
		{
			JOptionPane.showMessageDialog(
					null, 
					"", 
					"Du har ikke skriverettigheter til denne fila", 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog
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
				elev.setFag(JOptionPane.showInputDialog("Fag for: " + elev.getElevForNavn() + " " + elev.getElevEtterNavn() +"\nSkriv inn fag du skal sette karakter på"));
				elev.setKar1(Integer.parseInt(JOptionPane.showInputDialog(elev.getElevForNavn() + " " + elev.getElevEtterNavn() + "\nSkriv inn karakter for oppgave 1")));
				elev.setKar2(Integer.parseInt(JOptionPane.showInputDialog(elev.getElevForNavn() + " " + elev.getElevEtterNavn() + "\nSkriv inn karakter for oppgave 2")));
				elev.setKar3(Integer.parseInt(JOptionPane.showInputDialog(elev.getElevForNavn() + " " + elev.getElevEtterNavn() + "\nSkriv inn karakter for oppgave 3")));
				elev.setKar4(Integer.parseInt(JOptionPane.showInputDialog(elev.getElevForNavn() + " " + elev.getElevEtterNavn() + "\nSkriv inn karakter for oppgave 4")));
				elev.setKar5(Integer.parseInt(JOptionPane.showInputDialog(elev.getElevForNavn() + " " + elev.getElevEtterNavn() + "\nSkriv inn karakter for oppgave 5")));
				elev.setSKar(elev.getKar1() + elev.getKar2() + elev.getKar3() + elev.getKar4() + elev.getKar5());
				
				if (elev.getFag() != null)
				{
					output.format("%s %s %s %d %d %d %d %d %s %2.2f\n",
							elev.getElevForNavn(),
							elev.getElevEtterNavn(),
							elev.getFag(),
							elev.getKar1(),
							elev.getKar2(),
							elev.getKar3(),
							elev.getKar4(),
							elev.getKar5(),
							"Gjennomsnittskarakter:",
							elev.getSKar());
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"",
							"Må ha en karakter.",
							JOptionPane.PLAIN_MESSAGE);
				}
	
				tekstområde.append(
						elev.getElevForNavn()
						+ "\t"
						+ elev.getElevEtterNavn()
						+ "\t"
						+ elev.getFag()
						+ "\t"
						+ elev.getKar1()
						+ "\t"
						+ elev.getKar2()
						+ "\t"
						+ elev.getKar3()
						+ "\t"
						+ elev.getKar4()
						+ "\t"
						+ elev.getKar5()
						+ "\t"
						+ "Gjennomsnittskarakter: "
						+ elev.getSKar()
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
		if (output != null)//
			output.close();// lukke output
	}// slutt på metoden lukkFil
}
