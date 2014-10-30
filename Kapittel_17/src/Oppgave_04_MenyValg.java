public enum Oppgave_04_MenyValg 
{
NULL_BALANSE (1),
KREDITT_BALANSE (2),
DEBIT_BALANSE (3),
SLUTT (4);

private final int verdi;

Oppgave_04_MenyValg (int verdiValg)
{
	verdi = verdiValg;
}

public int getVerdi()
{
	return verdi;
}
}
