
public class Tidskonverterer 
{
	private int antSekunder;
	
	public void setAntSekunder(int sekundInput)
	{
		antSekunder = sekundInput;
	}
	public int getAntSekuder ()
	{
		return antSekunder;
	}
	public String konvertertTid ()
	{
		int timer = antSekunder / 3600, restTimer = antSekunder % 3600, minutter = restTimer / 60, sekunder = restTimer % 60;
		return timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder.";
	}
}