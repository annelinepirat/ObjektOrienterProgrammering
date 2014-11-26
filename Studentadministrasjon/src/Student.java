import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

/*Class Student
 * Klassen representerer en student som en del av en gruppe i Studentadministrasjonsprogrammet.
 *  
 */


public class Student implements Serializable{

	//Class Student
	//variabler fag, studiestart, oppgaver, kj�nn, fornavn, etternavn, id, godkjentforeksamen
	//
	//funksjoner for � hente og sette alle variablene.
	//set og get
	//
	//id variablen kan settes som en Date.long (dette bare for � lage et unikt nummer p� studentet.. det kan jo hende at noen med samme navn g�r p� skolen.)
	//
	//funksjon isgodkjent
	//hvis alle oppgaver er godkjent, returner true.
	
	
	private String forNavn = "";					//Studentens fornavn
	private String etterNavn = "";					//Studentens etternavn
	private String fagOmrade ="";					//Studentens fagomr�de (f.eks. Matematikk)
	private boolean mann = true;					//Variabel for kj�nn; true = mann, false = kvinne (tilfeldig valgt, trenger ikke tolkes... :)
	private int studieStart = 2014;					//Studentens studiestart f.eks. 2014
	private String studentNummer = "";				//Studentnummer f.eks. s123456789
	private Vector<Oppgave> oppgaver = new Vector();//En vektor som inneholder alle studentens oppgaver
	
	
	//En tom konstrukt�r
	public Student(){
		
	}
	
	//Konstrukt�r for � opprette en ny student med alle verdier satt.
	public Student(String forNavn, String etterNavn, int studieStart, boolean kjonnMann, String fagOmrade, Vector<Oppgave> oppgaver){
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.studieStart = studieStart;
		this.mann = kjonnMann;
		this.fagOmrade = fagOmrade;
		this.oppgaver = oppgaver;
	}
	
	
	//Returnerer studentens fornavn
	public String getFornavn(){
		return forNavn;
	}
	
	//Setter eller endrer studentens fornavn
	public void setFornavn(String forNavn){
		this.forNavn = forNavn;
	}
	
	//Returnerer studentens etternavn
	public String getEtternavn(){
		return etterNavn;
	}
	
	//Setter eller endrer studentens etternavn
	public void setEtternavn(String etterNavn){
		this.etterNavn = etterNavn;
	}
	

	//Returnerer studentens hele navn dersom metoden blir kalt. Dette skjer f.eks. ved at man System.out.println studentobjektet, eller ved at man
	//legger objektet i en liste. Med andre ord, denne metoden bestemmer hvordan objektet vises i en liste.
	public String toString(){
		return forNavn + " " + etterNavn;
	}
	
	//Setter eller endrer studentens fagomr�de
	public void setFag(String fag){
		this.fagOmrade = fag;
	}

	//Returnerer studentens fagomr�det
	public String getFag(){
		return fagOmrade;
	}
	
	//Setter eller endrer studentens studestart
	public void setStudiestart(String studieStart){
		try{
			this.studieStart = Integer.parseInt(studieStart);
		}catch (Exception e){
			System.out.println("Feil ved lesing av studestart. " + e);
			//Ved feil, sett �rstall til innenv�rende �r
			GregorianCalendar gc = new GregorianCalendar();
			this.studieStart = gc.get( Calendar.YEAR);
		}
	}
	
	//Returnerer studentens studiestart
	public int getStudiestart(){
		return studieStart;
	}
	
	//Returnerer true hvis mann, false hvis dame.
	public boolean isMann(){
		return mann;
	}
	
	//Returnerer true hvis dame, false hvis mann (denne metoden er laget i likestillingens navn!)
	public boolean isDame(){
		return !mann;
	}
	
	//Returnerer kj�nnet som en streng.
	public String getKjonn(){
		if (mann) return "Mann"; else return "Kvinne";
	}
	
	//Setter eller endrer studentens kj�nn
	public void setKjonn(boolean mann){
		this.mann = mann;
	}
	
	//Setter eller endrer studentens fornavn
	public void setStudentnummer(String studentnummer){
		this.studentNummer = studentnummer;
	}
	
	//Returnerer studentnummer
	public String getStudentnummer(){
		return studentNummer;
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
	
	//Kontrollerer hver eneste oppgave studenten har, og returnerer true hvis alle er godkjente (alts� at studenten kan ta eksamen) og false hvis ikke.
	public boolean isGodkjent(){

		//G� gjennom alle oppgaver, dersom en ikke er godkjent: returner false
		for (int i = 0; i < oppgaver.size(); i++){
			if (oppgaver.elementAt(i).isGodkjent())
				continue;
			else
				return false;
				
		}
		
		return true;
	}
}


/*
import java.util.ArrayList;

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
*/