import javax.swing.JFrame;

public class Maanedstrekker
{
  public static void main( String[] args )
  {
    Maanedstrekningsvindu vindu = new Maanedstrekningsvindu();
    vindu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    vindu.setSize( 500, 80 );
    vindu.setVisible( true );
  }
}