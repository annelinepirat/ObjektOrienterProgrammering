import javax.swing.JOptionPane;

public class Oppgave15 
{
	public static void main(String[] args)
	{
	
		String førsteSifferstring = JOptionPane.showInputDialog(null, "Skriv inn heltall");
		String andreSifferstring = JOptionPane.showInputDialog(null, "Skriv inn heltall");
		String tredjeSifferstring = JOptionPane.showInputDialog(null, "Skriv inn heltall");
		String resultat = "";
		
		int førsteTall = Integer.parseInt(førsteSifferstring);
		int andreTall = Integer.parseInt(andreSifferstring);
		int tredjeTall = Integer.parseInt(tredjeSifferstring);
		
		if (førsteTall <= andreTall)
			resultat = resultat + (andreTall = førsteTall);
		if (andreTall <= tredjeTall)
			resultat = resultat + (tredjeTall = andreTall);

		 JOptionPane.showMessageDialog( null, tredjeTall + " er minst!", 
	              "Minst",
	         JOptionPane.INFORMATION_MESSAGE );
	}

}
