import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_05 
{	
   public static void main( String[] args )
   {
	   String input = JOptionPane.showInputDialog(
			   "Programmet teller og skriver " +
			   "ut alle bokstavene i tekststrengen du skriver." );
	   char[] alfabet = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E',
			   'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K',
			   'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 
			   'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W',
			   'x', 'X', 'y', 'Y', 'z', 'Z', 'æ', 'Æ', 'ø', 'Ø', 'å', 'Å' };//ny char-array med alle bokstavene i alfabtet
	   int antall = 0;
	   
	   int [] forekomst = new int [58];//oppretter int-array med 58 plasser (det dobbelte av bokstavene i alfabetet siden vi har små og store bokstaver

	   JTextArea tekstområde = new JTextArea();
	   tekstområde.setText("Antall bokstaver i innlest tekst:\n");

	   for ( int i = 0; i < input.length(); i++ )// starter i på 0 og vi går igjennom hele input fra brukeren tegn for tegn
	   {
		   char tegn = input.charAt( i );//lagrer input i char tegn

		   for ( int j = 0; j < alfabet.length; j++ )// starter j på 0 og går igjennom char alfabet
		   {
			   if ( tegn == alfabet[ j ] )// ser om tegn og alfabet[j] er like
			   {
				   forekomst [j] ++;//legger til en mer i forekomst [j]
				   antall++; 	// legger til en mer i antall (bokstaver)			  
			   }
		   }//slutt på indre for-løkke
	   }// slutt på ytre for-løkke
	   
	   int teller = 0;
	   
	   for ( int i = 0; i < alfabet.length; i++)
	   {
		   if (forekomst[i] != 0)
		   {
			   tekstområde.append (alfabet[i] + " : " + forekomst [i] + "\t");// appender med alfabet [i] og forekomst [i] (for eksempel hvis det er 2 små a'er så står det a : 2)
			   //vil bare ha 10 bokstaver på hver linje i utskriften
			   teller++;
			   if (teller % 10 == 0)
			   {
				   tekstområde.append("\n");
			   }
		   }
	   }// slutt på for-løkke som legger til tekst til utskrift for brukeren

     tekstområde.append ("\nI alt " + antall + " bokstaver.");//Legger til tekst nederst i tekstvindu
     JOptionPane.showMessageDialog( null, tekstområde, "Bokstaver",
             JOptionPane.PLAIN_MESSAGE );// utskrift til brukeren
   }// slutt på main metoden
}//Slutt på klassen