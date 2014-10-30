import javax.swing.JTextArea; //importerer 
import javax.swing.JOptionPane; //importerer

public class Oppgave_3_test 
{
	public static void main (String [] args)
	{
		JTextArea tekstområde = new JTextArea(); //lager et tekstområde
		tekstområde.setText("Slag med terning \n\n");// lager overskrift i tekstområdet
		
		Terning terningen = new Terning ();//kaller opp en konstruktør ved navn terningen
		int antKast = 100;//setter antall kast lik 100
		
		for (int i = 1; i <= antKast; i ++)//bestemmer hvor mange ganger vi skal kjøre igjennom
		{
			terningen.kast();//klassen terning kjører igjennom et kast
			int verdi = terningen.getVerdi();//henter verdi fra klassen terning
			tekstområde.append(verdi + " ");// legger til en mellomrom etter hvert tall
			
			if (i%10 == 0)//sjekker om i har blitt gjennomført 10 ganger og lager så et linjeskift
			{
				tekstområde.append("\n");
			}
		}// slutt for-løkka
		JOptionPane.showMessageDialog(null, tekstområde); //utskriftområde
	}//slutt på main metoden
}// slutt på klassen
