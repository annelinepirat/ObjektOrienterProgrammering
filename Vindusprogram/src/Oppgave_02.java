
public class Oppgave_02 
{	
	public static String opptaltKast(int valgtTall)
	{
		Oppgave_02_terning kast = new Oppgave_02_terning();
		String resultat = "";
		int antKast = 6000;
		int valgt = 0;
		
		for (int i = 1; i <= antKast; i++)
		{
			if (valgtTall >= 1 && valgtTall <= 6)
			{
				kast.kast();
				int verdi = kast.getVerdi();
				if (verdi == valgtTall)
				{	
					valgt++;
					resultat = "Ditt valg ble slått " + valgt + " ganger.";
				}
			}
			else
				resultat = "Dette tallet finnes ikke på terningen";
		}
		return resultat;
	}
}
