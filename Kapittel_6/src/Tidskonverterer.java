
public class Tidskonverterer 
{
	private int antSekunder;// definerer en int verdi 
	
	public void setAntSekunder(int sekundInput)// får en input fra bruker ved hjelp av input i annen klasse
	{
		antSekunder = sekundInput;// antSekunder settes lik sekundInput fra bruker
	}
	public int getAntSekuder ()// lager en get verdi og returnerer antSekunder
	{
		return antSekunder;
	}
	public String konvertertTid ()// lager en string som konverterer tiden
	{
		int timer = antSekunder / 3600, restTimer = antSekunder % 3600, minutter = restTimer / 60, sekunder = restTimer % 60;
		return timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder.";
	}
}// slutt på klassen