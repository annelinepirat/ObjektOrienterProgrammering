/*Oppgave fra kapittel 17

Lag et program som lager karakterprotokoll.
Programmet skal hente navnene fra en fil klasseliste, 
lese inn karaktene for hver elev på en oppgave og lagre dem i en fil fagprotokoll.

Lag først et program som genererer en fil med klasseliste. 
Du skal også gnerere en fil fagprotokoll. 
Så lenge det er flere elever på lista, les hvert elevnavn 
fra lista, og les inn en karakter i et elevobjekt. 
Skriv elevnavn og tilknyttet karakter inn fila norskprotokoll.

Lag et program som skriver alle dataene fra fila fagprotokoll ut på skjerm.

Utvid programmet slik at du kan lese inn karakterer for fem ulike 
oppgaver og generere en samlekarakter.

(Denne oppgaven kan vi bruke to fredager på.)*/
public class LagKlasselisteTest // lager klassen LagKlasselisteTest
{
	public static void main (String [] args)// oppretter main metode
	{
		LagKlasseliste program = new LagKlasseliste();// Oppretter en konstruktør med navn program
		
		program.aapneFil();// program starter metoden aapneFil
		program.leggTilElev();// program starter metoden leffTilElev
		program.lukkFil();// program starter metoden lukkFil
	}// slutt main metode
}// slutt på klassen
