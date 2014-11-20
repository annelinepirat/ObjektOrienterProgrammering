import java.io.Serializable;

public class KontoPost implements Serializable
{
	private int konto;
	private String forNavn;
	private String etterNavn;
	private double balanse;
	
	public KontoPost()
	{
		this (0, "", "", 0.0);
	}
	
	public KontoPost (int knt, String fnavn, String enavn, double bal)
	{
		setKonto(knt);
		setForNavn(fnavn);
		setEtterNavn(enavn);
		setBalanse(bal);
	}// slik skal utskriften
	
	public void setKonto(int knt)
	{
		konto = knt;
	}
	public int getKonto()
	{
		return konto;
	}
	
	public void setForNavn(String fnavn)
	{
		forNavn = fnavn;
	}
	public String getForNavn()
	{
		return forNavn;
	}
	
	public void setEtterNavn(String enavn)
	{
		etterNavn = enavn;
	}
	public String getEtterNavn()
	{
		return etterNavn;
	}
	
	public void setBalanse(double bal)
	{
		balanse = bal;
	}
	public double getBalanse()
	{
		return balanse;
	}// slutt på menge set/get 
}//slutt på klasse
