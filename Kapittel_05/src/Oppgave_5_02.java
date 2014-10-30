import javax.swing.JOptionPane;
/* Lag et program som leser inn 10 heltallsverdier
 * fra brukeren og skrifer ut (i en dialogboks)
 * den største verdien som ble lest inn*/
public class Oppgave_5_02
{
	public static void main (String [] args)
	{
		int storst = 0;//Setter verdien av det største tallet lik 0
		for (int i = 1; i <= 10; i++)// starter en for-løkke som skal kjøres igjennom 10 ganger (så lenge i er mindre eller lik 10) i økes med to for hver runde
		{
			String tall = JOptionPane.showInputDialog(null, "Skriv inn heltall");// input-dialogboks der brukeren skriver inn et tall
			int t = Integer.parseInt(tall);// Parser verdien av tall til integer verdien t
			if (t>storst) // hvis t er større enn størst så skal størst bli til t
			{
				storst = t;
			}
		}
		if (storst > 0) // hvis størst er større enn 0 så skriv ut dialogboks med hvilket tall som var størst
		JOptionPane.showMessageDialog (null, "Det største tallet ditt var: " + storst);
		else JOptionPane.showMessageDialog(null, "Heidå"); // hvis størst er mindre nn 0, si heidå
	}
}
