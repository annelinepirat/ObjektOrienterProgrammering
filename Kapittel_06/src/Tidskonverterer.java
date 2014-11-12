
public class Tidskonverterer 
{
	private int antSekunder;// definerer en int verdi 
	
	public void setAntSekunder(int sekundInput)// får en input fra bruker ved hjelp av input i annen klasse
	{
		antSekunder = sekundInput;// antSekunder settes lik sekundInput fra bruker
	}
	public int getAntSekuder ()// lager en get verdi og returnerer antSekunder
	{
		return antSekunder;// returnerer antSekunder
	}
	public String konvertertTid ()// lager en string som konverterer tiden
	{
		int timer = antSekunder / 3600, restTimer = antSekunder % 3600, minutter = restTimer / 60, sekunder = restTimer % 60;//oppretter en variabel timer, restTimer, minutter og sekunder og regner ut og setter vrdier
		return timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder.";// dette skal returneres til konvertertTid
	}
}// slutt på klassen og set/get