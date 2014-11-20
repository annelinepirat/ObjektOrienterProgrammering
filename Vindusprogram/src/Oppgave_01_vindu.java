import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Oppgave_01_vindu extends JFrame implements ActionListener
{
	private JTextArea utskriftsområde; //for utskrift av resultater
	private JTextField skrivefelt;     //for input
	private JLabel skrivefelttekst;    //for tekst foran skrivefeltet
	
	public Oppgave_01_vindu()
	{
		super( "km/h til m/s" );
	    utskriftsområde = new JTextArea( 10, 30 );
	    JScrollPane skrollområde = new JScrollPane( utskriftsområde );
	    skrivefelt = new JTextField( 10 );
	    skrivefelt.addActionListener( this );  //registrerer vindusobjektet
	                                     //som lytteobjekt for skrivefeltet
	    skrivefelttekst = new JLabel( "km/h som skal konverteres:" );
	    Container c = getContentPane(); //vinduets komponentkontainer
	    c.setLayout( new FlowLayout() ); //komponentene skal plasseres etter
	                                     //hverandre rad for rad
	    c.add( skrivefelttekst );   //plasserer komponentene i kontaineren
	    c.add( skrivefelt );        //i den rekkefølge vi vil ha dem
	    c.add( skrollområde );
	    utskriftsområde.setText( "Konverterte kilometer\n" );
	}

	  //metode som blir kalt opp hver gang det trykkes på retur-tasten 
	  //mens markøren står i skrivefeltet
	public void actionPerformed( ActionEvent e )
	{
		String utskrift = "";
		String input = skrivefelt.getText(); //leser inn det som 
	                                         //står i tekstfeltet
	    double km = Double.parseDouble ( input );
	    if (km >= 0)
	    {
	    		utskrift = input + " = " + 
		            Oppgave_01_utregning.konvertertLengde( km );	
	    }
	    else
	    	utskrift = Oppgave_01_utregning.konvertertLengde(km);
	    
	    utskriftsområde.append( utskrift + "\n" );
	}
}
