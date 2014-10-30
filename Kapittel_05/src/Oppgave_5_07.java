import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_5_07 
{
	public static void main (String [] args)
	{
		JTextArea utskrift = new JTextArea(); //lager tekstområde
		utskrift.setText ("Tall mellom 10 og 50 \n\n"); // Dette blir den første linja
		
		String innlestTall = JOptionPane.showInputDialog(null, "Skriv et tall."); //leser inn tall
		int tall = Integer.parseInt(innlestTall); //parser det til int verdi
		int antall = 0;		//setterverdi til antall
		
		while (tall > 0) //starter while-løkka
		{
		if (tall > 10 && tall < 50) //hvis tallet er mellom 10 og 50 så øker antall med 1
		antall++;
		
		innlestTall = JOptionPane.showInputDialog(null, "Skriv et tall til:"); //Brukeren får en sjans til å lese inn nytt tall
		tall = Integer.parseInt(innlestTall); //parser verdien av det innlestetallet til int verdi
		}
		
		utskrift.append(antall + ""); //leger til i tekstområdet
		JOptionPane.showMessageDialog(null, utskrift);//skriver en utskrift av det nye tekstområdet når brukeren skriver inn en negativ verdi
			
	}
}
