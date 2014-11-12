import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_02 
{
	private int [] liste;// oppretter arrayen liste
		
	public Oppgave_02()
	{
		liste = new int [10];// setter grenser i arrayen liste til 10
	}
		
	public void opprett()
	{
		for (int i = 0; i < liste.length; i++)// starter for løkke
		{
			int tall = Integer.parseInt(JOptionPane.showInputDialog(null,"Skriv et heltall:"));//leser inn tall fra brukeren og parser
			if (tall > 0 && tall < 51)// sjekker om tall er innenfor grensne
			{
				liste [i] = tall;// hvis tallet er innenfor grensen sett liste[i] lik tall
			}
			else
			{
				liste [i] = 0;// hvis tallet ikke er innenfor grensen sett liste[i] lik 0
			}
		}//slutt for-løkke
	}// slutt metoden opprett
	
	public void skrivUt()
	{
		JTextArea tekstområde = new JTextArea();// oppretter tekstområde
		tekstområde.setText("Overskrift\n");// setter starttekst i tekstområde
		
		for (int i = 0; i < 10; i++)// starter for-løkke
		{
			if (liste [i] != 0)// if test så lenge liste av i er forskjellig fra 0
			{
				for (int j = 1; j<liste[i]+1; j++)// starter indre for-løkke
				{
					tekstområde.append ("*");// legg til stjerner
				}
				tekstområde.append("\n");// legger til linjeskift etter stjernene
			}
			else
				tekstområde.append("\n");// legger til linjeskift hvis det ikke skal skrives stjerner
		}
		JOptionPane.showMessageDialog(null, tekstområde);// melding til brukeren
	}// slutt metoden skrivUt
}