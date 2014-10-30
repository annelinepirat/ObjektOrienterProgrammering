import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.*;

public class Oppgave_04_KredittVurdering// start klassen 
{
	private Oppgave_04_MenyValg kontoType;
	private Scanner input;
	private final static Oppgave_04_MenyValg[] valg = {Oppgave_04_MenyValg.NULL_BALANSE, 
		Oppgave_04_MenyValg.KREDITT_BALANSE, Oppgave_04_MenyValg.DEBIT_BALANSE, 
		Oppgave_04_MenyValg.SLUTT};
	
	private void lesPoster()// oppretter metode lesPoster
	{
		KontoPost post = new KontoPost();// konstruktør
		JTextArea tekstområde = new JTextArea();// tekstområde
		tekstområde.setText ("");// "overskrivt" = tom
	
		try
		{
			input = new Scanner (new File("kunder.txt"));
			while(input.hasNext())
			{
				post.setKonto(input.nextInt());
				post.setForNavn(input.next());
				post.setEtterNavn(input.next());
				post.setBalanse(input.nextDouble());
			
				if (skalVises(post.getBalanse()))
					tekstområde.append(post.getKonto() 
							+ "\t"
							+ post.getForNavn()
							+ "\t"
							+ post.getEtterNavn()
							+ "\t"
							+ post.getBalanse()
							+ "\n");
			}
			JOptionPane.showMessageDialog(null, tekstområde, null, JOptionPane.PLAIN_MESSAGE);
		}// slutt try
	
		catch (NoSuchElementException elementException)
		{
			JOptionPane.showMessageDialog(null, "Upassende format i fila.", null, JOptionPane.PLAIN_MESSAGE);
			input.close();
			System.exit(1);
		}// slutt catch
		catch (IllegalStateException stateException)
		{
			JOptionPane.showMessageDialog(null, "Feil i lesing fra fil.", null, JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}// slutt catch
		catch (FileNotFoundException fileNotFoundException)
		{
			JOptionPane.showMessageDialog(null, "Feil ved åpning av fila.", null, JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}// slutt catch
		finally
		{
			if (input != null)
				input.close();
		}
	}// end lesPoster
	
	private boolean skalVises (double balanse)
	{
		if ((kontoType == Oppgave_04_MenyValg.KREDITT_BALANSE) && (balanse < 0))
			return true;
		else if ((kontoType == Oppgave_04_MenyValg.DEBIT_BALANSE) && (balanse > 0))
			return true;
		else if ((kontoType == Oppgave_04_MenyValg.NULL_BALANSE) && (balanse == 0))
			return true;
		return false;
	}// slutt skalVises
	
	private Oppgave_04_MenyValg getValgMulighet()
	{
		int valgMulighet = 0;
		
		try
		{
			do
			{
				JOptionPane.showMessageDialog(null, 
						"Velg et tall fra menyen\n "
						+ "1 - skriv poster med null-balanse\n "
						+ "2 - skriv poster med kreditt-balanse\n"
						+ "3 - skriv poster med debit balanse\n"
						+ "4 - slutt");
				valgMulighet = Integer.parseInt(JOptionPane.showInputDialog("?: "));
			}
			while ((valgMulighet < 1) || (valgMulighet > 4));
		}
		
		catch (NoSuchElementException elementException)
		{
			JOptionPane.showMessageDialog(null,  "Upassende input", null, JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
		
		return valg [valgMulighet - 1];
	}
	
	public void prosessValg()
	{
		kontoType = getValgMulighet();
		while (kontoType != Oppgave_04_MenyValg.SLUTT)
		{
			switch (kontoType)
			{
			case NULL_BALANSE:
				JOptionPane.showMessageDialog(null, null, "\nAccounts with zero balances:\n", JOptionPane.PLAIN_MESSAGE);
			break;
			case KREDITT_BALANSE:
				JOptionPane.showMessageDialog(null, null, "\nAccounts with credit balances:\n", JOptionPane.PLAIN_MESSAGE);
			break;
			case DEBIT_BALANSE:
				JOptionPane.showMessageDialog(null, null, "\nAccounts with debir balances:\n", JOptionPane.PLAIN_MESSAGE);
			break;
			}
			lesPoster();
			kontoType = getValgMulighet();
		}
	}
}// slutt på klassen
