import javax.swing.JOptionPane;

public class Oppgave_5_10 
{
	public static void main (String [] args)
	{
		String ukedag;
		int dag;
		do
		{
			ukedag = JOptionPane.showInputDialog(null, "Skriv inn et tall for ukedagene");
			dag = Integer.parseInt(ukedag);
		switch (dag)
		{
		case 1:
			ukedag = "mandag";
			break;
		case 2:
			ukedag = "tirsdag";
			break;
		case 3:
			ukedag = "onsdag";
			break;
		case 4:
			ukedag = "torsdag";
			break;
		case 5:
			ukedag = "fredag";
			break;
		case 6:
			ukedag = "lørdag";
			break;
		case 7:
			ukedag = "søndag";
			break;
		}
		if (dag > 0 && dag < 8)
		{
		JOptionPane.showMessageDialog(null, "Din dag var: " + ukedag);
		}
		if (dag > 7)
		{
			JOptionPane.showMessageDialog(null, "Ukjent ukedag");
		}
		if (dag <= 0)
		{
			JOptionPane.showMessageDialog(null, "Ugyldig verdi");
		}
		} while (dag > 0 && dag < 8);
	}
}
