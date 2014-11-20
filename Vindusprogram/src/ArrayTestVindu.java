import java.awt.*;
import javax.swing.*;

public class ArrayTestVindu extends JFrame
{
	private JTextArea utskrift ;
	private Arraybehandler behandler;
	
	public ArrayTestVindu ()
	{
		super ("Programvindu");
		behandler = new Arraybehandler();
		Container c = getContentPane();
		utskrift = new JTextArea(10,30);
		utskrift.setEditable(false);
		utskrift.setTabSize(5);
		JScrollPane skrollefelt = new JScrollPane(utskrift);
		c.add(skrollefelt);
		setSize(400,300);
		setVisible(true);
	}
	public void demonstrererArrayparametre()
	{
		int tallgrense = 20;
		int[] liste = behandler.lagListe(10, tallgrense);
		utskrift.setText("Illustrasjon av arrayparametres virkemåte " +
				"sammenliknet med parametre av primitiv type\n");
		behandler.print(utskrift, "Opprinnelig array", liste);
		
		behandler.reverser(liste);
		utskrift.append("\nReverserer arrayen bed å bruke den som parameter "+
				"i en metode som utfører reverseringen.");
		behandler.print(utskrift, "\nReversert array", liste);
		
		utskrift.append("\nSiste arrayelement " + liste[liste.length - 1]+
				" skal brukes som aktuell parameter en metode som dobler mottatt parameterverdi.");
		
		int doblet = behandler.dubler(liste[liste.length -1]);
		utskrift.append("\nDoblet verdi av aktuell parameter: " + doblet);
		utskrift.append("\nAktuell parameter har beholdt sin verdi: "+ liste[liste.length -1]);
	}
//	private JTextField skrivefelt;
//	private JLabel ledetekst;{
//	skrivefelt = new JTextField(10);
//	ledetekst = new JLabel ("Fornavn: ");
//	Container c = getContentPane();
//	c.setLayout(new FlowLayout());
//	c.add (ledetekst);
//	c.add (skrivefelt);}
}
