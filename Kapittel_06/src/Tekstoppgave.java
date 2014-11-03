/*Lag en metode som leser inn en tekst fra skjermen og 
 * sjekker at den innleste verdien er et tall innenfor 
 * et bestemt intervall. Hvis den innleste verdien ikke 
 * er et tall, skal dette komme fram i en feilmelding. 
 * Hvis verdien er et tall utenfor intervallet, skal 
 * dette komme fram i en feilmelding. Hvis den innleste 
 * verdien er et tall innenfor intervallet, skal metoden 
 * returnere tallet.*/

public class Tekstoppgave
{
	private String test(String tallInn)
	{
		//setter variablene
		String utskrift;
		int tall;
		try 
		{
			tall = Integer.parseInt(tallInn);
			if (tall > 3 && tall < 12)//sjekker om tallet er innenfor grensene eller ei
			{
				utskrift = tall + " er innenfor grensene.";
			}
			else
			{
				utskrift = tall + " er ikke innenfor grensene.";
			}
		}//slutt try
		catch( NumberFormatException nfe )//feil melding hvis det ikke er tall
		{
			utskrift = "Du har ikke skrevet et tall.";
		}// sutt catch
		return utskrift;//setter utskrift og returnerer den
	}//slutt metode test
	
	public String getVerdi(String tallUt)//Starter metode getVerdi som sendes til TekstoppgaveTest
	{
		return test (tallUt);//setter verdi til "tallUt" nemlig "test" som da returneres til TekstoppgaveTest
	}//slutt metode getVerdi
}//slutt klassen