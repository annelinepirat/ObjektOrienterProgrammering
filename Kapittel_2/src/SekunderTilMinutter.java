import javax.swing.JOptionPane;

public class SekunderTilMinutter {

	public static void main(String[] args) 
	{
		String antallSekunder;
		int sekunder;
		
		antallSekunder = JOptionPane.showInputDialog("Skriv antall sekunder du kan holde pusten");
		
		sekunder = Integer.parseInt(antallSekunder);
		
		JOptionPane.showMessageDialog(null, "Du klarte å holde pusten i " 
		+ sekunder / 60 + 
		" minutter.");
	}

}
