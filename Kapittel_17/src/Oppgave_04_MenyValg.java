public enum Oppgave_04_MenyValg 
{
	NULL_BALANSE (1),
	KREDITT_BALANSE (2),
	DEBIT_BALANSE (3),
	SLUTT (4);
	
	private final int verdi;
	
	Oppgave_04_MenyValg (int verdiValg)// send inn verdiValg
	{
		verdi = verdiValg;//sett verdi lik verdiValg
	}//slutt på metoden Oppgave_04_MenyValg
	
	public int getVerdi()
	{
		return verdi;// send tilbake verdi(som settes over)
	}// slutt på metoden getVerdi
}// slutt på klassen
