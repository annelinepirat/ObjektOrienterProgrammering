//importerer klasser som skal brukes
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_04 //starter klassen Oppgave_04
{
	private int [] aray;// oppretter en privat array "aray"
	
	public Oppgave_04()
	{
		aray = new int [20];// setter grenser for arrayen
	}
	
	public boolean finnes (int tall)// starter en boolean som sjekker om tall er blitt skrevet inn av brukeren fra før
	{
		boolean returverdi = false;// setter returverdien til false
		for (int i = 0; i < aray.length-1; i++)// starter en for-løkke for å gå igjennom hele arrayen for å sjekke om boolean skal settes til true
		{
			if (aray[i] == tall)// sjekker igjennom aray[i] for å se om den er lik tall
				returverdi = true;// setter returverdien til true
		}
		return returverdi;//returnerer returverdien false hvis tall ikke finnes, true om tallet finnes
	}// slutt på boolean
	
	public void innlesning()
	{
		for (int i = 0; i < aray.length; i++)// starter en for-løkke
		{
			int tall = Integer.parseInt(JOptionPane.showInputDialog(null,"Skriv et heltall mellom 20 og 100:"));// leser inn og parser et heltall fra brukeren
			if (tall > 20 && tall < 100)	// sjekker om tallet er innenfor de valgte grensene
			{
				if (!finnes(tall))// hvis tall ikke finnes gå inn(altså om finnes(tall) = false)
				{
					aray [i] = tall;// setter aray [i] = tall
				}
				else
					i--;// hvis tallet finnes gå tilbake og les inn tall [i] på nytt
			}
			else
			{
				i--;
				JOptionPane.showMessageDialog(null, "Du skrev ikke et tall innenfor grensen");// hvis tallet er utenfor grensen gi feilmelding til brukeren og gå en tilbake (i--) og les inn på nytt.
			}
		}// slutt på for-løkka
		
	}// slutt på metoden innlesning
	
	public void skrivUt()
	{
		JTextArea tekstområde = new JTextArea();// kaller på klassen JTextArea og oppretter tekstområde
		tekstområde.setText ("Overskrift\n");//setter overskriften i tekstområde
		
		for (int i = 0; i < aray.length; i++)// starter for-løkke
		{
			if (i%5 == 0)// sjekker om det er lest inn fem tall og deretter går inn
			{
				tekstområde.append ("\n");// legg til et linjeskift
			}
			tekstområde.append(aray[i] + "\t");// legger til aray[i] og et mellomrom i tekstområde
		}// slutt for-løkke
		JOptionPane.showMessageDialog(null, tekstområde);// viser tekstområde
	}// slutt på metoden skrivUt
}
