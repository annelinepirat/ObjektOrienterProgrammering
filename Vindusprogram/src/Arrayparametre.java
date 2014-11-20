//Illustrasjon av arrayparametres virkemåte sammenliknet med
//parametre av primitiv type
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class Arrayparametre
{
	public static void main( String[] args )
	{
		Arraybehandler behandler = new Arraybehandler();
		int tallgrense = 20;
		//oppretter slumptallsliste og printer den ut
		int[] liste = behandler.lagListe( 10, tallgrense );
		JTextArea utskrift = new JTextArea();
		utskrift.setTabSize(5);
		utskrift.setText( "Illustrasjon av arrayparametres virkemåte " +
						"sammenliknet med parametre av primitiv type\n" );
		behandler.print( utskrift, "Opprinnelig array", liste );

		//reverserer lista og printer ut reversert liste
		behandler.reverser( liste );
		utskrift.append( 
				"\nReverserer arrayen ved å bruke den som parameter " +
				"i en metode som utfører reverseringen." );
		behandler.print( utskrift, "\nReversert array", liste );

		//printer ut siste listeelement
		utskrift.append(
					"\nSiste arrayelement " + liste[ liste.length - 1 ]  +
					" skal brukes som aktuell parameter en metode som dobler " +
					"mottatt parameterverdi." );

		//viser virkning av dubleringsmetode
		int doblet = behandler.dubler( liste[ liste.length - 1 ] );
		utskrift.append( "\nDoblet verdi av aktuell parameter: " +
						doblet );
		utskrift.append( "\nAktuell parameter har beholdt sin verdi: " +
						liste[ liste.length - 1 ] );

		JOptionPane.showMessageDialog( null, utskrift, "Arrayparametre",
						JOptionPane.PLAIN_MESSAGE );
	}
}