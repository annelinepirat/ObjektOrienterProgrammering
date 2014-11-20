import javax.swing.JFrame;

public class Konverteringstester
{
  public static void main( String[] args )
  {
    Konverteringsvindu vindu = new Konverteringsvindu();// oppretter konstruktør som peker på konverteringsvindu
    vindu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );//velger at programmet avslutter når brukeren lukker vinduet
    vindu.setSize( 400, 250 );// størrelsen på vinduet er bestemt
    vindu.setVisible( true );// vinduet synes
  }// slutt på main-metoden
}// slutt på Konverteringstester klassen