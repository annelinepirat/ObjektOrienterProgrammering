import javax.swing.JOptionPane;

public class Oppgave_5_11
{
	public static void main (String [] args)
	{
		String mnd= JOptionPane.showInputDialog(null, "Skriv inn navnet på en mnd og få vite hvor mange dager den innehar");;
		int  antDager;
		mnd = mnd.toLowerCase();
		
		switch (mnd)
		{
			case "april":
			case "juni":
			case "september":
			case "november": antDager = 30;
				break;
			case "februar": antDager = 28;
				break;
			default: antDager = 31;
				break;
		}
		JOptionPane.showMessageDialog(null, "Måneden " + mnd + " inneholder " + antDager + " antall dager.");
	}
}
