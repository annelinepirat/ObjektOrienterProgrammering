import javax.swing.JOptionPane;
/* Utvid programmet fra oppgave 2 slik at det også skriver
 * ut det nest største av tallene som ble lest inn*/
public class Oppgave_5_03
{
	public static void main (String [] args)
	{
		int storst = 0, nestStorst = 0; // setter verdiene til størst og nest størst
		for (int i = 1; i <= 10; i++) // starter en for-løkke der som skal kjøre 10 ganger 
		{
			String tall = JOptionPane.showInputDialog(null, "Skriv inn heltall"); // får tall fra brukeren
			int t = Integer.parseInt(tall); // parser tallet fra brukeren til verdien t
			if (t > storst || i == 1) // så lenge t er større enn størst eller det er første runden så skal vi inn i if blokken
				{
				if (i>1) // hvis i er større enn 1 så går vi inn og endrer verdiene altså hvis vi er på andre runde eller oppover
					nestStorst = storst;
					storst = t;
				}
			else if (t > nestStorst) // hvis ikke i er større enn 1 og t er større enn nest størst endrer vi verdien til nest størst lik t
				{
				 nestStorst = t;
				}
		} // slutt på for løkka
		
		JOptionPane.showMessageDialog(null, "Det største tallet ditt var " + storst + 
				" og det nest største tallet var " + nestStorst + "!");
	} // slutt på main metoden
}