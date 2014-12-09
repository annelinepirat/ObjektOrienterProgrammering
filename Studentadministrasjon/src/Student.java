/*************************************************************************
 * @author Øystein
 * Student.class
 * 
 * Klassen representerer en student som en del av en gruppe i 
 * Studentadministrasjonsprogrammet.
 * 
 * Klassen skal inneholde, sette og svare på
 * 1.Studentens navn
 * 2.Studentens studiestart
 * 3.Studentens kjønn
 * 4.Studentens oppgaver (dypere informasjon om oppgavene lagres 
 * i et eget oppgave-objekt).
 * 5.Studentens status i forhold til om alle oppgaver er godkjente, og 
 * studenten er klar til eksamen.
 * 6.Studentnummer (vi tar ikke denne i bruk, men legger den ved da vi 
 * kan se en fremtidig nytte av dette; skille studenter med likt navn og 
 * samkjøring mot andre skolesystemer).
 * 7.Studentens fagområde
 **************************************************************************/
import java.io.Serializable;
import java.util.Vector;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Student implements Serializable{
	
	//Studentens fornavn
	private String fornavn = "";		
	//Studentens etternavn
	private String etternavn = "";	
	//Studentens fagområde (f.eks. Matematikk)
	private String fagomrade ="";	
	/*Variabel for kjønn; true = mann, 
	false = kvinne (tilfeldig valgt, trenger ikke tolkes... :)*/
	private boolean mann = true;		
	//Studentens studiestart f.eks. 2014
	private int studiestart = 2014;	
	//Studentnummer f.eks. s123456789
	private String studentnummer = "";	
	//En vektor som inneholder alle studentens oppgaver.
	private Vector<Oppgave> oppgaver = new Vector();
	
	
	/*En tom konstruktør i tilfellet man trenger å 
	opprette et studentobjekt før en har data til å fylle det.*/
	public Student(){
		
	}
	
	//Konstruktør for å opprette en ny student med alle verdier satt.
	public Student(String forNavn, 
			String etterNavn, 
			int studieStart, 
			boolean kjonnMann, 
			String fagOmrade, 
			Vector<Oppgave> oppgaver){
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
	

	/*Returnerer studentens hele navn dersom metoden blir kalt. 
	Dette skjer f.eks. ved at man System.out.println studentobjektet, 
	eller ved at man legger objektet i en liste. Med andre ord, 
	denne metoden bestemmer hvordan objektet vises i en liste.*/
	public String toString(){
		return fornavn + " " + etternavn;
	}
	
	//Setter eller endrer studentens fagområde
	public void setFag(String fag){
		this.fagomrade = fag;
	}

	//Returnerer studentens fagområdet
	public String getFag(){
		return fagomrade;
	}
	
	//Setter eller endrer studentens studestart
	public void setStudiestart(String studieStart){
		try{
			this.studiestart = Integer.parseInt(studieStart);
		}catch (Exception e){
			System.out.println(
					"Feil ved lesing av studestart. "
					+ "Setter studiestart til gjeldene \u00E5r!" + e);
			//Ved feil, sett årstall til innenvÊrende år
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
	
	/*Returnerer true hvis dame, false hvis mann 
	(denne metoden er laget i likestillingens navn!)*/
	public boolean isDame(){
		return !mann;
	}
	
	//Returnerer kjønnet som en streng.
	public String getKjonn(){
		if (mann) return "Mann"; else return "Kvinne";
	}
	
	//Setter eller endrer studentens kjønn
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
	
	/*Kontrollerer hver eneste oppgave studenten har, og 
	returnerer true hvis alle er godkjente (altså at studenten kan ta eksamen) 
	og false hvis ikke.*/
	public boolean isGodkjent(){

		/*Gå gjennom alle oppgaver, dersom en ikke er godkjent: returner 
		false eller returner true*/
		for (int i = 0; i < oppgaver.size(); i++){
			if (oppgaver.elementAt(i).isGodkjent())
				continue;
			else
				return false;
				
		}
		
		//returner FALSE dersom studenten ennå ikke har gjort noen oppgaver.
		if (oppgaver.size() < 1) 
			return false;
		
		return true;
	}
}
