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
		// leser inn verdier fra brukeren og parser
		int startverdi = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn en startverdi: "));
		int makseksponent = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn en hvor mange potenstabeller du vil se: ")); 
		int antall = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv inn hvor mange linjer du vil se nedover : "));
		
		JTextArea tekstområde = new JTextArea(); // oppretter et tekstområde
		
		for (int n = 1; n <= makseksponent; n++)// starter for-løkke
		{
			tekstområde.append(n + ". potens\t");// legger til n og ". potens" og mellomrom i tekstområde
		}
			tekstområde.append("\n");// legger til linjeskift i tekstområde
		for (int i = startverdi; i < startverdi + antall; i++)// starter for-løkke
		{
			for (int j = 1; j <= makseksponent; j++)// starter indre for-løkke
			{
				tekstområde.append(power(i,j)+"\t");// starter metoden power og sender inn verdier i og j til grunntall og eksponent, legger til produkt fra metoden power deretter en tabulator 
			}
			tekstområde.append("\n");// legger til linjeskift
		}
		JOptionPane.showMessageDialog (null, tekstområde);// melding til brukeren som inneholder tekstområde
	}// slutt på main metode
}// slutt på klassen
