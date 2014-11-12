import javax.swing.JOptionPane;

public class Oppgave_5_10 
{
	public static void main (String [] args)
	{
		String ukedag;// oppretter variabel ukedqag
		int dag;// oppretter variabel dag
		do// starter do-while løkke
		{
			ukedag = JOptionPane.showInputDialog(null, "Skriv inn et tall for å sjekke hvilken dag i uka det er");//leser inn tall fra brukeren
			dag = Integer.parseInt(ukedag);// parser ukedag til dag
		switch (dag)// starter switch og sender inn dag
		{
		case 1:
			ukedag = "mandag";// hvis brukeren har skrevet inn 1 så gjør om ukedag til mandag
			break;// bryter ut av switch
		case 2:
			ukedag = "tirsdag";// hvis brukeren har skrevet inn 2 så gjør om ukedag til tirsdag
			break;// bryter ut av switch
		case 3:
			ukedag = "onsdag";// hvis brukeren har skrevet inn 3 så gjør om ukedag til onsdag
			break;// bryter ut av switch
		case 4:
			ukedag = "torsdag";// hvis brukeren har skrevet inn 4 så gjør om ukedag til torsdag
			break;// bryter ut av switch
		case 5:
			ukedag = "fredag";// hvis brukeren har skrevet inn 5 så gjør om ukedag til fredag
			break;// bryter ut av switch
		case 6:
			ukedag = "lørdag";// hvis brukeren har skrevet inn g så gjør om ukedag til lørdag
			break;// bryter ut av switch
		case 7:
			ukedag = "søndag";// hvis brukeren har skrevet inn 7 så gjør om ukedag til søndag
			break;// bryter ut av switch
		}
		if (dag > 0 && dag < 8)// sjekker om dag er innenfor grensene
		{
		JOptionPane.showMessageDialog(null, "Din dag var: " + ukedag);// meldning til brukeren
		}
		if (dag > 7)// sjekker om dag er større enn 7
		{
			JOptionPane.showMessageDialog(null, "Ukjent ukedag");//melding til brukeren
		}
		if (dag <= 0)// sjekker om dag er mindre eller lik 0
		{
			JOptionPane.showMessageDialog(null, "Ugyldig verdi");// melding til brukeren
		}
		} while (dag > 0 && dag < 8);// kjør så lenge dag er større enn null og mindre enn 8
	}// slutt på main metoden
}// slutt på klassen
