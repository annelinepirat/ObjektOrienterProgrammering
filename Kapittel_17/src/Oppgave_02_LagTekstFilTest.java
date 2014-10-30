public class Oppgave_02_LagTekstFilTest // ny klasse "Oppgave_02_LagTekstFilTest"
{
	public static void main (String [] args)// start main metode
	{
		Oppgave_02_LagTekstFil program = new Oppgave_02_LagTekstFil ();// oppretter en konstruktør "program" som kaller på "Oppgave_02_LagTekstFil"
		
		program.aapneFil();// konstruktøren kaller opp aapneFil-metoden
		program.leggTilPost();// konstruktøren kaller opp leggTilPost-metoden
		program.lukkFil();// konstruktøren kaller opp lukkFil-metoden
	}// slutt på main metode
}// slutt klasse
