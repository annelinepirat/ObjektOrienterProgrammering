
public class Karakterprotokoll 
{
	private String elevFornavn;
	private String elevEtternavn;
	private String fagene;
	private int karakter1;
	private int karakter2;
	private int karakter3;
	private int karakter4;
	private int karakter5;
	
	public Karakterprotokoll()
	{
		this("","","",0,0,0,0,0);
	}
	
	public Karakterprotokoll(String fnavn, String enavn, String fag, int kar1, int kar2, int kar3, int kar4, int kar5)
	{
		setElevForNavn (fnavn);
		setElevEtterNavn (enavn);
		setFag (fag);
		setKar1 (kar1);
		setKar2 (kar2);
		setKar3 (kar3);
		setKar4 (kar4);
		setKar5 (kar5);
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

	public void setFag(String fag)
	{
		fagene = fag;
	}
	public String getFag ()
	{
		return fagene;
	}
	
	public void setKar1(int kar1)
	{
		karakter1 = kar1;
	}
	public int getKar1 ()
	{
		return karakter1;
	}
	
	public void setKar2 (int kar2)
	{
		karakter2 = kar2;
	}
	public int getKar2 ()
	{
		return karakter2;
	}
	
	public void setKar3 (int kar3)
	{
		karakter3 = kar3;
	}
	public int getKar3 ()
	{
		return karakter3;
	}
	
	public void setKar4 (int kar4)
	{
		karakter4 = kar4;
	}
	public int getKar4 ()
	{
		return karakter4;
	}
	
	public void setKar5 (int kar5)
	{
		karakter5 = kar5;
	}
	public int getKar5 ()
	{
		return karakter5;
	}
}
