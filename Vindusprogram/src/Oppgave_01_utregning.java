public class Oppgave_01_utregning 
{
	public static String konvertertLengde (double km)
	{
		if (km > 0)
		{
			double ms = km * 1000 / 3600;
			
			String resultat = "";
			if (ms > 0)
			{
				resultat += ms + " m/s.";
			}
			return resultat;
		}
		else
			return "Kan ikke regne ut negativ verdi.";
	}
}
