import javax.swing.JOptionPane;

public class Oppgave14 
{
   public static void main( String args[] )
   {
	   String sifferstring = JOptionPane.showInputDialog(null, "Skriv inn heltall for å se om det er delelig med 3", "Heltall delelig med 3?", JOptionPane.QUESTION_MESSAGE);
	   String resultat = "";
	   
	   int tallvariabel = Integer.parseInt(sifferstring);
	   
	   if ( tallvariabel % 3 == 0 )
		   resultat = resultat + tallvariabel + " er delelig med 3!";
	   if ( tallvariabel % 3 != 0 )
		   resultat = resultat + tallvariabel + " er ikke delelig med 3!";
	   
	   JOptionPane.showMessageDialog( null, resultat, 
	              "Delelig med 3?",
	         JOptionPane.INFORMATION_MESSAGE );
   }
}