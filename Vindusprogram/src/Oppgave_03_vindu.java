import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Oppgave_03_vindu extends JFrame implements ActionListener
{
	private JTextArea utskriftsområde;	// for utskrift av resultater
	private JTextField skrivefeltBredde;
	private JTextField skrivefeltHøyde;// for input
	private JLabel skrivefelttekstBredde;
	private JLabel skrivefelttekstHøyde;// for tekst foran skrivefeltet
	private JButton knapp; 				// for knappen
	
	public Oppgave_03_vindu()
	{
		super ("Areal av rektangel");
		utskriftsområde = new JTextArea(20, 30);
		utskriftsområde.setEditable (false);
		JScrollPane skrollområde = new JScrollPane (utskriftsområde);
		skrivefeltBredde = new JTextField(10);
		skrivefeltBredde.addActionListener(this);
		skrivefelttekstBredde = new JLabel("Skriv inn bredden av rektangelet: ");
		skrivefeltHøyde = new JTextField(10);
		skrivefeltHøyde.addActionListener(this);
		skrivefelttekstHøyde = new JLabel("Skriv inn høyden av rektangelet: ");
		knapp = new JButton ("Beregn areal av ditt rektangel");
		knapp.addActionListener(this);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(skrivefelttekstBredde);
		c.add(skrivefeltBredde);
		c.add(skrivefelttekstHøyde);
		c.add(skrivefeltHøyde);
		c.add(knapp);
		c.add(skrollområde);
		//c.add(utskriftsområde);
	}
	
	public void actionPerformed (ActionEvent e)
	{
		String inputBredde = skrivefeltBredde.getText();
		double bredde = Double.parseDouble(inputBredde);
		String inputHøyde = skrivefeltHøyde.getText();
		double høyde = Double.parseDouble(inputHøyde);
		
		String utskrift = Oppgave_03.arealRektangel(bredde, høyde);
		utskriftsområde.append(utskrift + "\n");
	}
}
