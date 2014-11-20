import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Maanedstrekningsvindu extends JFrame implements 
        ActionListener
{
	private Trekningsautomat lykkehjul;
	private JTextField utskrift;
	private JButton trekk;
	private JLabel ledetekst;

	public Maanedstrekningsvindu()
	{
		super( "Månedstrekning" );
		lykkehjul = new Trekningsautomat();
		ledetekst = new JLabel( "Trukket måned: " );
		utskrift = new JTextField( 12 );
		utskrift.setEditable( false );  //gjør tekstfeltet ikke-editerbart
		trekk = new JButton( "Trekk måned" );
		trekk.addActionListener( this );  //registrerer vinduet som 
                                      //lytteobjekt for knappen
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.add( trekk );
		c.add( ledetekst );
		c.add( utskrift );
	}

	//Kalles opp hver gang brukeren klikker på knappen trekk.
	public void actionPerformed( ActionEvent e )
	{		
		String måned = lykkehjul.trekkMåned();
		utskrift.setText( måned );
	}
}