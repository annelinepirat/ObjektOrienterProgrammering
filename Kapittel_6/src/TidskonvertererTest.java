import javax.swing.JOptionPane;

public class TidskonvertererTest 
{
	public static void main (String [] args)
	{
		Tidskonverterer omgjøring = new Tidskonverterer ();
		int sekundInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn antall sekunder :"));
		boolean mer = true;
		mer = sekundInput >= 0;
		while (mer)
		{
			omgjøring.setAntSekunder(sekundInput);
			
			String utskrift = omgjøring.konvertertTid();
				
			JOptionPane.showMessageDialog(null, sekundInput + " sekunder = " + utskrift, "Fra sekunder til minutter, timer og sekunder", JOptionPane.PLAIN_MESSAGE);
			sekundInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn antall sekunder :"));
			mer = sekundInput >= 0;
		}
	}
}