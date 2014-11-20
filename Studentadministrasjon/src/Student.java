import java.util.ArrayList;
import java.util.Random;

public class Student 
{
	//klassevariabler
	String fornavn = "";
	String etternavn = "";
	String kjonn = "";
	int studiestart = 0;
	String fag = "";
	int studentnummer = 0;
	boolean godkjentEksamen = false;
	ArrayList<Oppgave> oppgaver;
	boolean mann = false;
	//konstruktør
	public Student(String elevFornavn, String elevEtternavn, String elevKjonn, int studieStart, String fagomrade,  boolean mann) 
	{
		this.fornavn = elevFornavn;
		this.etternavn = elevEtternavn;
		this.kjonn = elevKjonn;
		this.studiestart = studieStart;
		this.fag = fagomrade;
		this.mann = mann;
		this.oppgaver = new ArrayList<Oppgave>();
//		Random randomTall = new Random();
//		this.studentnummer = randomTall.nextInt(99999);
	}

	public void setFag(String fag) 
	{
		this.fag = fag;
	}
	public String getFag() 
	{
		return fag;
	}

	public void setStudiestart(int studiestart) 
	{
		this.studiestart = studiestart;
	}
	public int getStudiestart() 
	{
		return studiestart;
	}

	public void setMann(boolean mann) 
	{
		this.mann = mann;
	}

	public boolean isMann() 
	{
		return mann;
	}

	public void setFornavn(String fornavn) 
	{
		this.fornavn = fornavn;
	}
	public String getFornavn() 
	{
		return fornavn;
	}
	
	public void setEtternavn(String etternavn) 
	{
		this.etternavn = etternavn;
	}
	public String getEtternavn() 
	{
		return etternavn;
	}
	
	public void setKjonn(String kjonn)
	{
		this.kjonn = kjonn;
	}
	public String getKjonn()
	{
		return kjonn;
	}

//	public int getStudentnummer() 
//	{
//		return studentnummer;
//	}
//
//	public void setStudentnummer(int studentnummer) 
//	{
//		this.studentnummer = studentnummer;
//	}

	public boolean isGodkjentEksamen() 
	{
		for(Oppgave temp : oppgaver) 
		{ //gÂ gjennom alle oppgaver
			if(temp.isGodkjent()) 
			{ // er den godkjent?
				godkjentEksamen = true;
			}
			else 
			{ //ikke godkjent
				godkjentEksamen = false;
				break; //hopp ut
			}
		}
		return godkjentEksamen;
	}

	public void setOppgaver(ArrayList<Oppgave> oppgaver) 
	{
		this.oppgaver = oppgaver;
	}
	public ArrayList<Oppgave> getOppgaver() 
	{
		return oppgaver;
	}
	
	public void setEnOppgave(Oppgave oppgave) 
	{
		this.oppgaver.add(oppgave);
	}
}
