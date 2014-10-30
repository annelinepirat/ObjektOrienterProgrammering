import javax.swing.JOptionPane;

public class Oppgave11 
{
	public static void main(String[] args)
	{
		String resultat;
		
		int m = 3;
		int n = -7;
		int p = 2;
		int minst = m;
		
		resultat = "";
	
		if ( n < minst )
		resultat = resultat + ( minst = n );
		if ( p < minst ) 
		resultat = resultat + ( minst = p );
		
	    JOptionPane.showMessageDialog(null, resultat, "Hvilken verdi er minst?", JOptionPane.INFORMATION_MESSAGE );
}
}
