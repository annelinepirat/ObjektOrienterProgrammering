
public class Karakterprotokoll 
{
	private String elevFornavn;
	private String elevEtternavn;
	private int karakter;
	
	public Karakterprotokoll()
	{
		this("","",0);
	}
	
	public Karakterprotokoll(String fnavn, String enavn, int kar)
	{
		setElevForNavn (fnavn);
		setElevEtterNavn (enavn);
		setKar (kar);
	}
	
	public void setElevForNavn (String fnavn)
	{
		elevFornavn = fnavn;
	}
	public String getElevForNavn()
	{
		return elevFornavn;
	}
	
	public void setElevEtterNavn (String enavn)
	{
		elevEtternavn = enavn;
	}
	public String getElevEtterNavn()
	{
		return elevEtternavn;
	}
	
	public void setKar(int kar)
	{
		karakter = kar;
	}
	public int getKar ()
	{
		return karakter;
	}
}
