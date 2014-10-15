import javax.swing.JOptionPane;

public class Oppgave_5_12
{
	public static void main (String [] args)
	{
		String innlestTall = JOptionPane.showInputDialog(null, "Skriv inn et årstall for å se om det er skuddår.");
		int årstall = Integer.parseInt(innlestTall);
		
		if (årstall%4 == 0 && årstall%100 != 0)
		JOptionPane.showMessageDialog(null, innlestTall + " er et skuddår" );
		
		else if (årstall%400 == 0)
			JOptionPane.showMessageDialog(null, innlestTall + " er et skuddår");
		else
			JOptionPane.showMessageDialog(null, innlestTall + " er ikke et skuddår");
	}
}
