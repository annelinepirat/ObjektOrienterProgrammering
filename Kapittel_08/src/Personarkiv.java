import javax.swing.JFrame;

public class Personarkiv
{
  public static void main( String[] args )
  {
    Persondata vindu = new Persondata();
    vindu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    vindu.setSize( 290, 350 );
    vindu.setVisible( true );
  }
}