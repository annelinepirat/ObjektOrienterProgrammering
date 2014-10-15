import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class SirkelTest 
{
	public static void main (String [] args)
	{
		Sirkel sirkelData = new Sirkel(); // oppretter konstruktør
		
		double radiusInput = Double.parseDouble (JOptionPane.showInputDialog(null, "Skriv inn radiusen på en sirkel:")); //får input fra bruker og parser til double verdi
		sirkelData.setRadius(radiusInput); //gir verdi radiusInput til setRadius variabel
		
		 DecimalFormat formateringsobjekt = sirkelData.desimalKonvertering();// hvorfor må dette være static? Og hvordan gjøre det?
		 String utskriftRadius = formateringsobjekt.format(sirkelData.getRadius());// er det mulig å gjøre dette anderledes?
		 String utskriftDiameter = formateringsobjekt.format(sirkelData.diameter());
		 String utskriftOmkrets = formateringsobjekt.format(sirkelData.omkrets());
		 String utskriftAreal = formateringsobjekt.format(sirkelData.areal()); // alt over er formateringer
		
		String utskrift = "Radius: " + utskriftRadius + 
						"\nDiameter: " + utskriftDiameter + 
						"\nOmkrets: " + utskriftOmkrets + 
						"\nAreal: " + utskriftAreal; // bestemmer hva som skal stå i utskriften
		
		JOptionPane.showMessageDialog(null, utskrift); // utskriftboks
		} // slutt på main metoden
}// slutt på klassen