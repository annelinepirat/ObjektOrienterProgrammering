import javax.swing.JOptionPane;

public class TidskonvertererTest 
{
	public static void main (String [] args)
	{
		Tidskonverterer omgjøring = new Tidskonverterer ();// lager en konstruktør og kaller opp metoden
		int sekundInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn antall sekunder :"));// input vindu som setter verdien på sekundInput
		boolean mer = true;// setter mer lik true
		mer = sekundInput >= 0;// setter hva true er for mer
		while (mer)// kjører while løkka så lenge mer er true
		{
			omgjøring.setAntSekunder(sekundInput);// setter verdien sekundInput til tidskonverterer
			
			String utskrift = omgjøring.konvertertTid();// lager en string utskrift som henter verdier fra konvertertTid metoden
				
			JOptionPane.showMessageDialog(null, sekundInput + " sekunder = " + utskrift, "Fra sekunder til minutter, timer og sekunder", JOptionPane.PLAIN_MESSAGE);// utskrift vindu
			sekundInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn antall sekunder :"));// starter nytt inputvindu
			mer = sekundInput >= 0;// sjekker om mer fortsatt er true
		}// slutt på while-løkke
	}// slutt på main metoden
}// slutt på klassen