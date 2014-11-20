public class Tidskonverterer
{
    //returnerer parameterverdien konvertert til timer, minutter og sekunder
    public static String konvertertTid( int sekunder )
    {
      if ( sekunder >= 0 )
      {
        int timer = sekunder / 3600;
        sekunder = sekunder % 3600;
        int minutter = sekunder / 60;
        sekunder = sekunder % 60;

        String resultat = "";
        if ( timer > 0 )
        {
          resultat += timer + " time";
          if ( timer > 1 )
          	resultat += "r";
          resultat += " ";
        }
        if ( minutter > 0 )
        {
          resultat += minutter + " minutt";
          if ( minutter != 1 )
            resultat +=  "er";
          resultat += " ";
        }
        if ( sekunder > 0 )
        {
          resultat += sekunder + " sekund";
          if ( sekunder > 1 )
            resultat += "er";
        }
        return resultat;
      }
      else
        return "Konverterer ikke negativ tid!";// returnerer til
    }// slutt på utregningene
}// slutt på klassen Tidskonverterer