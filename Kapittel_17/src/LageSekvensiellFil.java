import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class LageSekvensiellFil 
{
	private Formatter output;
	
	public void aapneFil()
	{
		try
		{
			output = new Formatter(
					new FileOutputStream ("kunder.txt"));
		}
		catch (SecurityException se)
		{
			JOptionPane.showMessageDialog (
					null, 
					"",
					"Du har ikke skriverettigheter i fila",
					JOptionPane.PLAIN_MESSAGE);
		}
		catch (FileNotFoundException fnfe)
		{
			JOptionPane.showMessageDialog(
					null,
					"Feil ved åpning av fil",
					"",
					JOptionPane.PLAIN_MESSAGE);
		}
	}//slutt metode aapneFil
	
	public void leggTil()
	{
		KontoPost bank;
		int kontonr = 0;
		String forNavn;
		String etterNavn;
		double balanse;
		
		Scanner input = new Scanner (System.in);
		
		System.out.printf("%s\n%s\n%s\n%s\n\n", 
				"For å finne input, skriv end-of-file indikator", 
				"når du er bett om imput.", 
				"På UNIX/Lunux/Mac OS X skrif <ctrl> d og trykk Enter", 
				"På Windows skriv <ctrl> z og trykk Enter");
		System.out.printf("%s\n%s", 
				"Skriv kontonr (>0), fornavn, etternavn og balanse",
				"?");
		while (input.hasNext())
		{
			try
			{
				kontonr = input.nextInt();
				forNavn = input.next();
				etterNavn = input.next();
				balanse = input.nextDouble();
				
				if (kontonr > 0)
				{
					bank = new KontoPost (kontonr, forNavn, etterNavn, balanse);
					output.format("%d %s %s %.2f\n",
							bank.getkontonr(),
							forNavn(),
							etterNavn(),
							balanse());
				}
				else
				{
					System.out.println("Kontonr må være større enn 0.");
				}
			}
			catch (FormatterClosedException fce)
			{
				JOptionPane.showMessageDialog(null, "Feil ved skriving til fil.");
				return;
			}
			catch ( NoSuchElementException nsee )
			 {
			 JOptionPane.showMessageDialog(null, "Feil input. Prøv igjen.");
			 input.nextLine(); // discard input so user can try again
			 } // end catch
			
			 System.out.printf( "%s %s\n%s", "Skriv konto nr (>0),",
			 "fornavn, etternavn of balanse.", "? " );			 
		}
	}
	
	public void lukkFil()
	{
		try
		{
			if (output != null)
				output.close();
		}
		catch(FormatterClosedException fce)
		{
			System.err.println("Feil ved lukking av fil.");
			System.exit(1);
		}
	}
}
