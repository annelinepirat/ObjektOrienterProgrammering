import javax.swing.JOptionPane;

public class Oppgave9 {

	public static void main(String[] args) {
		
		double a = 8 * 6 / 3;
		double b =	64 % 2;
		double c = 18.0 / 6;
		double d = 10 * 3 - 4;
		double e = 17 / 9;
		double f = 48  / 7 * 2;
		double g = 3 * (17 / 3) + 17 % 3;
		double h = 19.0 / 4.0;
		double i = 92 - 3 * 4;
		double j = 10 % 3;		
		
		JOptionPane.showMessageDialog(null, 
				"8 * 6 / 3 = " + a + 
				"\n 64 % 2 = " + b + 
				"\n 18.0 /6 = " + c + 
				"\n 10 * 3 - 4 = " + d + 
				"\n 17 / 9 = " + e +
				"\n 48  / 7 * 2 = " + f +
				"\n 3 * (17 / 3) + 17 % 3 = " + g + 
				"\n 19.0 / 4.0 = " + h +
				"\n 92 - 3 * 4 = " + i + 
				"\n 10 % 3 = " + j);
	}

}
