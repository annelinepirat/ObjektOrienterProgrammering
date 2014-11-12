import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Oppgave_03 
{
	private int kast;
	
	private int [] frekvenser;
	private Random generator;
	
	public Oppgave_03()
	{
		kast = 6000;
		frekvenser = new int [6];
		generator = new Random();// kaller på klassen random
	}
	
	public void trekk()
	{
		for (int i = 0; i < 6000; i++)
		{
			int trukket = 1 + generator.nextInt(6);// variabelen trukket settes lik et tall mellom 1 og 6 (terningens øyne), dette er random
			frekvenser [trukket - 1]++;
		}
	}// slutt på metoden trekk
	
	public void skrivUt()
	{
		JTextArea tekstområde = new JTextArea();// oppretter tekstområde
		tekstområde.setText("Terningen viste antall øyne med "
							+ kast 
							+ " kast.\n");// setter start-tekst i tekstområde
		for (int i = 0; i < frekvenser.length; i++)//start for-løkke
		{
			tekstområde.append ((i+1)+" ble kastet: "+frekvenser[i]+" ganger\t");// legger til terningens øyne (i+1), " ble kastet: ", hvor mange ganer dette terningkastet ble kastet (frekvenser[i]), og " ganger" og tabulator
		}// slutt for-løkke
		JOptionPane.showMessageDialog(null,  tekstområde, "Kast med terning", JOptionPane.PLAIN_MESSAGE);// melding til brukeren
	}// slutt på metoden skrivUt
}//slutt på klassen