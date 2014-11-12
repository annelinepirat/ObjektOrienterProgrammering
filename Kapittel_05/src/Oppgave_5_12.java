import javax.swing.JOptionPane;

public class Oppgave_5_12
{
	public static void main (String [] args)
	{
		String innlestTall = JOptionPane.showInputDialog(null, "Skriv inn et årstall for å se om det er skuddår.");// leser inn årstall fra brukeren
		int årstall = Integer.parseInt(innlestTall);// parser det innleste tallet
		
		if (årstall%4 == 0 && årstall%100 != 0)// sjekker om årstallet er delelig på 4 og at det i tillegg ikke er delelig på 100
		JOptionPane.showMessageDialog(null, innlestTall + " er et skuddår" );// hvis melding til brukeren
		
		else if (årstall%400 == 0)// sjekker om årstall er delelig på 400
			JOptionPane.showMessageDialog(null, innlestTall + " er et skuddår");// melding til brukeren
		else
			JOptionPane.showMessageDialog(null, innlestTall + " er ikke et skuddår");// melding til brukeren
	}// slutt på main metden
}// slutt på klassen
