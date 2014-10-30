import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_5_05b
{
	// Beregner og returnerer potensen med grunntall x og eksponent y
	public static int power (int grunntall, int eksponent)
	{
		//<beregner og retunerer potens>
		int produkt = 1;
		for (int i = 1; i <= eksponent; i++)
			produkt *= grunntall;
		return produkt;
	}
	public static void main (String [] args)
	{
		int startverdi = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn en startverdi: "));
		int makseksponent = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn en hvor mange potenstabeller du vil se: ")); 
		int antall = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn hvor mange linjer du vil se nedover : "));
		
		JTextArea tekstområde = new JTextArea(); // oppretter et tekstområde
		
		for (int n = 1; n <= makseksponent; n++)
		{
			tekstområde.append(n + ". potens\t");
		}
			tekstområde.append("\n");
		for (int i = startverdi; i < startverdi + antall; i++)
		{
			for (int j = 1; j <= makseksponent; j++)
			{
				tekstområde.append(power(i,j)+"\t");
			}
			tekstområde.append("\n");
		}
		JOptionPane.showMessageDialog (null, tekstområde);
	}
}
