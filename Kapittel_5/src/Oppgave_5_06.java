import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_5_06 
{
	public static void main (String [] args)
	{		
		JTextArea tekstområde = new JTextArea(); //lager tekstområdet
		
		tekstområde.setText("Slumptall \n");// dette blir da overskriften
		
		for (int i = 0; i < 100; i++) //Bestemmer hvor mange ganger for-løkka skal kjøre igjennom
		{
			if (i%10 == 0)
			{
			tekstområde.append("\n"); //lager linjeskift når det er plukket ut 10 tilfeldige tall
			}
			int tall = (int) (Math.random()*100); //denne genererer de tilfeldige tallene
			
			tekstområde.append (tall + "\t"); //denne legger til tall på tekstområdet.
		}
		JOptionPane.showMessageDialog(null, tekstområde); //utskrift av tekstområdet
	}
}
