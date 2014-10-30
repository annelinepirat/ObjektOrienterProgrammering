import javax.swing.JOptionPane;

public class Oppgave_1 
{
	public static void main (String [] args)
	{
		String sifferstreng = JOptionPane.showInputDialog (null, "Skriv inn heltall for å se om det er delelig med 3: ",
				"Heltall delelig med 3?", JOptionPane.QUESTION_MESSAGE);
		String resultat = "";
		
		int tallvariabel = Integer.parseInt(sifferstreng);
		
		if (tallvariabel % 3 == 0)
			resultat = tallvariabel + " er delelig med 3.";
		else
			resultat = tallvariabel + " er ikke delelig med 3.";
		
		JOptionPane.showMessageDialog (null, resultat, "Delelig med 3?", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
