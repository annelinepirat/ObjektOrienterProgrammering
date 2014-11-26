import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

/*Student.class
 * 
 * Klassen representerer en student som en del av en gruppe i Studentadministrasjonsprogrammet.
 * 
 * Klassen skal inneholde, sette og svare pÂ
 * 1.Studentens navn
 * 2.Studentens studiestart
 * 3.Studentens kj¯nn
 * 4.Studentens oppgaver (dypere informasjon om oppgavene lagres i et eget oppgave-objekt).
 * 5.Studentens status i forhold til om alle oppgaver er godkjente, og studenten er klar til eksamen.
 * 6.Studentnummer (vi tar ikke denne i bruk, men legger den ved da vi kan se en fremtidig nytte av dette; skille studenter med likt navn og samkj¯ring mot andre skolesystemer).
 * 7.Studentens fagomrÂde
 *  
 *  LAGET AV ÿYSTEIN MÿRKESDAL
 *  
 */


public class Student implements Serializable{
	
	private String fornavn = "";					//Studentens fornavn
	private String etternavn = "";					//Studentens etternavn
	private String fagomrade ="";					//Studentens fagomrÂde (f.eks. Matematikk)
	private boolean mann = true;					//Variabel for kj¯nn; true = mann, false = kvinne (tilfeldig valgt, trenger ikke tolkes... :)
	private int studiestart = 2014;					//Studentens studiestart f.eks. 2014
	private String studentnummer = "";				//Studentnummer f.eks. s123456789
	private Vector<Oppgave> oppgaver = new Vector();//En vektor som inneholder alle studentens oppgaver.
	
	
	//En tom konstrukt¯r i tilfellet man trenger Â opprette et studentobjekt f¯r en har data til Â fylle det.
	public Student(){
		
	}
	
	//Konstrukt¯r for Â opprette en ny student med alle verdier satt.
	public Student(String forNavn, String etterNavn, int studieStart, boolean kjonnMann, String fagOmrade, Vector<Oppgave> oppgaver){
		this.fornavn = forNavn;
		this.etternavn = etterNavn;
		this.studiestart = studieStart;
		this.mann = kjonnMann;
		this.fagomrade = fagOmrade;
		this.oppgaver = oppgaver;
	}
	
	
	//Returnerer studentens fornavn
	public String getFornavn(){
		return fornavn;
	}
	
	//Setter eller endrer studentens fornavn
	public void setFornavn(String forNavn){
		this.fornavn = forNavn;
	}
	
	//Returnerer studentens etternavn
	public String getEtternavn(){
		return etternavn;
	}
	
	//Setter eller endrer studentens etternavn
	public void setEtternavn(String etterNavn){
		this.etternavn = etterNavn;
	}
	

	//Returnerer studentens hele navn dersom metoden blir kalt. Dette skjer f.eks. ved at man System.out.println studentobjektet, eller ved at man
	//legger objektet i en liste. Med andre ord, denne metoden bestemmer hvordan objektet vises i en liste.
	public String toString(){
		return fornavn + " " + etternavn;
	}
	
	//Setter eller endrer studentens fagomrÂde
	public void setFag(String fag){
		this.fagomrade = fag;
	}

	//Returnerer studentens fagomrÂdet
	public String getFag(){
		return fagomrade;
	}
	
	//Setter eller endrer studentens studestart
	public void setStudiestart(String studieStart){
		try{
			this.studiestart = Integer.parseInt(studieStart);
		}catch (Exception e){
			System.out.println("Feil ved lesing av studestart. Setter studiestart til gjeldene Âr!" + e);
			//Ved feil, sett Ârstall til innenvÊrende Âr
			GregorianCalendar gc = new GregorianCalendar();
			this.studiestart = gc.get( Calendar.YEAR);
		}
	}
	
	//Returnerer studentens studiestart
	public int getStudiestart(){
		return studiestart;
	}
	
	//Returnerer true hvis mann, false hvis dame.
	public boolean isMann(){
		return mann;
	}
	
	//Returnerer true hvis dame, false hvis mann (denne metoden er laget i likestillingens navn!)
	public boolean isDame(){
		return !mann;
	}
	
	//Returnerer kj¯nnet som en streng.
	public String getKjonn(){
		if (mann) return "Mann"; else return "Kvinne";
	}
	
	//Setter eller endrer studentens kj¯nn
	public void setKjonn(boolean mann){
		this.mann = mann;
	}
	
	//Setter eller endrer studentens fornavn
	public void setStudentnummer(String studentnummer){
		this.studentnummer = studentnummer;
	}
	
	//Returnerer studentnummer
	public String getStudentnummer(){
		return studentnummer;
	}

	//Legger til en oppgave (et oppgaveobjekt) i studentens oppgaveliste.
	public void addOppgave(Oppgave opg){
		oppgaver.addElement(opg);
	}
	
	//Returnerer alle studentens oppgaver som en array av oppgaveobjekter.
	public Oppgave[] getOppgaver(){ //Returnerer alle oppgavene som en array.
		Oppgave[] opg = new Oppgave[oppgaver.size()];
		oppgaver.toArray(opg);
		return opg;
	}
	
	//Returnerer alle studentens oppgaver som en Vector
	public Vector<Oppgave> getOppgaverAsVector(){
		return oppgaver;
	}
	
	//Kontrollerer hver eneste oppgave studenten har, og returnerer true hvis alle er godkjente (altsÂ at studenten kan ta eksamen) og false hvis ikke.
	public boolean isGodkjent(){

		//GÂ gjennom alle oppgaver, dersom en ikke er godkjent: returner false eller returner true
		for (int i = 0; i < oppgaver.size(); i++){
			if (oppgaver.elementAt(i).isGodkjent())
				continue;
			else
				return false;
				
		}
		
		if (oppgaver.size() < 1) //returner FALSE dersom studenten ennÂ ikke har gjort noen oppgaver.
			return false;
		
		return true;
	}
}
