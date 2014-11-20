import java.util.Random;
import javax.swing.JTextArea;

public class Arraybehandler
{
    //returnerer slumptallsarray med lengde lik første parameter og
    //slumptall fra og med 0 til andre parameter
    public int[] lagListe( int lengde, int grense )
    {
      int[] slumptall = new int[ lengde ];
      Random generator = new Random();
      for ( int i = 0; i < slumptall.length; i++ )
        slumptall[ i ] = generator.nextInt( grense );
      return slumptall;
    }

    //reverserer arrayen som er parameter
    public void reverser( int[] tabell )
    {
      int n = tabell.length - 1;
      for ( int i = 0; i < tabell.length / 2; i++ )
      {
        int elem = tabell[ i ];
        tabell[ i ] = tabell[ n - i ];
        tabell[ n - i ] = elem;
      }
    }

    //printer ut array med ønsket overskrift
    public void print(JTextArea utskrift, String overskrift, int[] liste)
    {
      utskrift.append( overskrift + "\n" );
      for ( int i = 0; i < liste.length; i++ )
      {
        utskrift.append( String.valueOf( liste[ i ] ) + "\t" );
        if ( (i + 1) % 10 == 0 )
          utskrift.append( "\n" );
      }
    }

    // dobler parameterverdien og returnerer den
    public int dubler( int k )
    {
      k *= 2;
      return k;
    }
}