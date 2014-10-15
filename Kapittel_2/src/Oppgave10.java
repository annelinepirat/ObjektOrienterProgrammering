import javax.swing.JOptionPane;
public class Oppgave10 {

	public static void main(String[] args) {
		
		String resultat;
		int m = 5;
		int n = -7;
		
		resultat = "";
		
		if (m < n)
			resultat = resultat + m + " < " + n;
		if (n >= m)
			resultat = resultat + n + " >= " + m;
		if (n <= m)
			resultat = resultat + "\n" + n + " <= " + m;
		if (n > m)
			resultat = resultat + "\n" + n + " > " + m;
		if (m != n)
			resultat = resultat + "\n" + m + " != " + n;
		if (m == n)
			resultat = resultat + "\n" + m + " == " + n;
		
		JOptionPane.showMessageDialog(null, resultat, "Sammenligning av tall", JOptionPane.INFORMATION_MESSAGE);
				
	}

}
