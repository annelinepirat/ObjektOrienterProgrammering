import javax.swing.JOptionPane;

public class Kursboktest4 
{
	public static void main ( String [] args)
	{
		Kursbok4 bok1 = null, bok2 = null;
		String navn = JOptionPane.showInputDialog (null, "Skriv kursnavn: "); //leser inn kursnavn
		bok1 = new Kursbok4 (navn); //oppretter objekt med innlest kursnavn
		int svar = JOptionPane.showOptionDialog (null,
				"Vil du opprette en kursbok til?", 
				"Opprette flere kursbøker?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null );
		if (svar == JOptionPane.YES_OPTION)
		{
			navn = JOptionPane.showInputDialog ("Skriv kursnavn: ");
			bok2 = new Kursbok4 (navn);
		}
		String info = "Har opprettet kursbøker for følgende fag:\n";
		info = info + "1. " + bok1.getKursnavn();
		if (bok2 != null)
			info = info + "\n" + "2. " + bok2.getKursnavn();
		JOptionPane.showMessageDialog(null, info, "Registrert Kursnavn",
				JOptionPane.PLAIN_MESSAGE);
	}
}
