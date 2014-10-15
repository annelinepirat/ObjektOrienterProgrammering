import javax.swing.JOptionPane;

public class Kursboktest3 
{
	public static void main (String[] args)
	{			
		Kursbok3 protokoll = new Kursbok3(); //oppretter objekt
		
		JOptionPane.showMessageDialog(null, "Opprinnelig kursnavn: " + protokoll.getKursnavn() ); 
		// viser opprinnelig verdi til datafeltet kursnavn
		
		String navn = JOptionPane.showInputDialog(null, "Skriv kursnavn: "); //Leser inn kursnavn
		protokoll.setKursnavn( navn ); // lagrer innlest navn i objektet
		
		JOptionPane.showMessageDialog(null, "Registrert kursnavn: " + protokoll.getKursnavn() );
		// viser den nye verdien til datafeltet kursnavn
		
		protokoll.visTittel(); // skriver ut tittel med kursnavn
	}
}
