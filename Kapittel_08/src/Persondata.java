//Persondata.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Persondata extends JFrame implements ActionListener
{
  private JTextField navnefelt, nummerfelt;
  private JTextArea utskrift;
  private JButton ny, vis, finn;
  private Personregister register;

  public Persondata()
  {
    super( "Persondata" );
    navnefelt = new JTextField( 20 );
    nummerfelt = new JTextField( 12 );
    utskrift = new JTextArea( 10, 25 );
    utskrift.setEditable( false );
    ny = new JButton( "Registrer ny person" );
    ny.addActionListener( this );
    vis = new JButton( "Vis alle registrerte personer" );
    vis.addActionListener( this );
    finn = new JButton( "Finn person med gitt nummer" );
    finn.addActionListener( this );
    register = new Personregister();
    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    c.add( new JLabel( "Navn:" ) );
    c.add( navnefelt );
    c.add( new JLabel( "Nr.:" ) );
    c.add( nummerfelt );
    c.add( ny );
    c.add( vis );
    c.add( finn );
    c.add( new JScrollPane( utskrift ) );
  }

  public void nyPerson()
  {
    String navn = navnefelt.getText();
    int nr = Integer.parseInt( nummerfelt.getText() );
    Person ny = new Person( navn, nr );
    boolean ok = register.nyPerson( ny );
    if ( ok )
      utskrift.setText( navn + " ble registrert." );
    else
      utskrift.setText( "Ingen registrering pga. fullt register!" );
  }

  public void visRegister()
  {
    utskrift.setText( "Registrerte personer:\n" );
    utskrift.append( register.visAlleNavn() );
  }

  public void finnPerson()
  {
    int nr = Integer.parseInt( nummerfelt.getText() );
    String data = register.visPerson( nr );
    if ( data != null )
      utskrift.setText( data );
    else
      utskrift.setText( "Finnes ikke i registeret!" );
  }

  public void actionPerformed( ActionEvent e )
  {
    if ( e.getSource() == ny )
      nyPerson();
    else if ( e.getSource() == vis )
      visRegister();
    else if ( e.getSource() == finn )
      finnPerson();
  }
}