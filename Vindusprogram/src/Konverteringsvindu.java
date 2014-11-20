import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Konverteringsvindu extends JFrame implements ActionListener
{
	private JTextArea utskriftsområde; //for utskrift av resultater
	private JTextField skrivefelt;     //for input
	private JLabel skrivefelttekst;    //for tekst foran skrivefeltet

	public Konverteringsvindu()
	{
		super( "Tidskonvertering" );
		utskriftsområde = new JTextArea( 10, 30 );// parameterene i parantes bestemmer hvor mye som er synlig i vinduet før det blir scroll
		JScrollPane skrollområde = new JScrollPane( utskriftsområde );// sier det kan skrolles i utskriftområdet
		skrivefelt = new JTextField( 10 );// konstruktør som peker på JTextField
		skrivefelt.addActionListener( this );  //registrerer vindusobjektet
                                     //som lytteobjekt for skrivefeltet
		skrivefelttekst = new JLabel( "Sekunder som skal konverteres:" );//ny konstruktør som peker påJLabel
		Container c = getContentPane(); //vinduets komponentkontainer
		c.setLayout( new FlowLayout() ); //komponentene skal plasseres etter
                                     //hverandre rad for rad
		c.add( skrivefelttekst );   //plasserer komponentene i kontaineren
		c.add( skrivefelt );        //i den rekkefølge vi vil ha dem
		c.add( skrollområde );		// bestemmer at det er mulig å scrolle
		utskriftsområde.setText( "Konverterte sekunder\n" );// det som står øverst i utskriftsområdet
	}

	//metode som blir kalt opp hver gang det trykkes på enter-tasten 
	//mens markøren står i skrivefeltet
	public void actionPerformed( ActionEvent e )
	{
		String input = skrivefelt.getText(); //leser inn det som 
    										//står i tekstfeltet
		int sek = Integer.parseInt( input );// integerer input fra 
    										//brukeren til tall (sek)
		String utskrift = input + " = " + 
				Tidskonverterer.konvertertTid( sek );//utskrift settes lik 
    												//input fra brukeren og 
    												//utregningen Tidskonverterer 
    												//har gjort og returnerer
		utskriftsområde.append( utskrift + "\n" );// legger til i utskriftsområde, 
    											//slik at alt som er gjort tidligere 
    											//synes i vinduet
	}// slutt på metoden actionPerformed altså den som kobler sammen denne klassen og Tidskonverterer
}// slutt på klassen Konverteringsvindu