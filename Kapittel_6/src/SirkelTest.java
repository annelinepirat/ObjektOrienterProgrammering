import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class SirkelTest 
{
	public static void main (String [] args)
	{
		Sirkel sirkelData = new Sirkel(); // oppretter konstruktør
		
		double radiusInput = Double.parseDouble (JOptionPane.showInputDialog(null, "Skriv inn radiusen på en sirkel:")); //får input fra bruker og parser til double verdi
		sirkelData.setRadius(radiusInput); //gir verdi radiusInput til setRadius variabel
		
		String formateringsstreng = "#,###,##0.00";
		DecimalFormat df = new DecimalFormat(formateringsstreng);

		String utskrift = "Radius: " + df.format(sirkelData.getRadius()) + 
						"\nDiameter: " + df.format(sirkelData.diameter()) + 
						"\nOmkrets: " + df.format(sirkelData.omkrets()) + 
						"\nAreal: " + df.format(sirkelData.areal()); // bestemmer hva som skal stå i utskriften
		
		JOptionPane.showMessageDialog(null, utskrift); // utskriftboks
		} // slutt på main metoden
}// slutt på klassen