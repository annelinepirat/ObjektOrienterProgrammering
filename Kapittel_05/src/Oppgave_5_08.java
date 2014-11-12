import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_5_08
{
	public static void main (String [] args)
	{
		JTextArea utskrift = new JTextArea(); //lager et tekstområde
		utskrift.setText ("Tall mellom 10 og 50 \n\n"); //Den første linja i tekstområdet
		
		String innlestTall = JOptionPane.showInputDialog(null, "Skriv et tall."); //får et tall fra brukeren
		int tall = Integer.parseInt(innlestTall); //parser det innleste tallet til int verdi
		double antall = 0.0, gjennomsnitt = 0.0, sumGjennomsnitt = 0.0; //bestemmer verdiene på ulike variabler som endres etterhvert
		
		while (tall > 0) //starter en while-løkke
		{
		if (tall > 10 && tall < 50) // går inn og gir antall og gjennomsnitt nye verdier hvis if-testen oppfylles
		{
			antall++;
			gjennomsnitt += tall;
		}
		
		innlestTall = JOptionPane.showInputDialog(null, "Skriv et tall til:"); //starter på en ny runde
		tall = Integer.parseInt(innlestTall);// parser innlestTall til tall
		}
		if (antall > 0 && gjennomsnitt > 0) // sjekker om vi skal regne ut gjennomsnittet
			sumGjennomsnitt = gjennomsnitt/antall;
		
		utskrift.append("Antall tall mellom 10 og 50 var: " + antall + "\n"); //legger til linje i tekstområdet der det vises hvor mange ganger antall ble skrevet
		utskrift.append("Gjennomsnittet for de utvalgte tallene var" + sumGjennomsnitt); //legger til enda en linje med gjennomsnittet
		
		if (antall == 0) //hvis det ikke har blitt lest inn noen tall innenfor utvalgt grense blir dette skrevet ut
			JOptionPane.showMessageDialog(null, "Ingen av de innleste tallene du skrev inn var mellom de utvalgte grensene");
		else
		JOptionPane.showMessageDialog(null, utskrift); // hvis ikke blir dette skrevet ut
		
	}
}
