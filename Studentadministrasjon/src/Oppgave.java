/*********************************************************************************
 * @author Anders Lind Johnsen													*
 *																				*
 * Beskrivelse																	*
 * Klassen oppgave er å teste om studentene har fått sine oppgaver og 			*
 * arbeidskrav godkjent, og følgelig «godkjenner» om de kan gå opp til eksamen.	*
 *																				*
 * Klassen inneholder informasjon om en enkelt oppgave studenten har gjort. 		*
 * Dato for når oppgaven ble levert, om det er gitt tilbakemelding, om den er 	*
 * godkjent.																		*
 * 																				*
 * Klassen kalles opp/får sin input fra Student 									*				*																	*
 *********************************************************************************/

import java.io.Serializable;

public class Oppgave implements Serializable{
	
	/*variabler levertdato (når oppgaven ble levert), fått
	tilbakemelding (er det gitt tilbakemelding), 
	godkjent (er oppgaven godkjent).*/
	private String tilbakeMelding = " ";
	private boolean godkjent = false;
	 //Valg string for dato for å gjøre det enklere å håndtere
	private String levertDato = " ";
	private String oppgaveNavn = " ";
	
	public Oppgave(){ //Tom konstruktør
		
	}
	
	public Oppgave(String oppgaveNavn, 
			boolean godkjent, 
			String levertDato, 
			String tilbakeMelding){ //konstuktør som samtidig tar i mot alle variablene
		this.godkjent = godkjent;
		this.levertDato = levertDato;
		this.tilbakeMelding = tilbakeMelding;
		this.oppgaveNavn = oppgaveNavn;
	}
	
	// setter oppgavenavn
	public void setOppgaveNavn(String oppgaveNavn){ 
		this.oppgaveNavn = oppgaveNavn;
	}
	
	// returnerer oppgavenavn
	public String getOppgaveNavn(){ 
		return oppgaveNavn;
	}
	
	public String toString(){
		return oppgaveNavn;
	}
	
	//setter dato for oppgavelevert
	public void setLevertDato(String levertDato){ 
		this.levertDato = levertDato;
	}
	
	//returnerer dato for oppgavelevert
	public String getLevertDato(){ 
		return levertDato;
	}
	/*Returnerer true hvis det er gitt tilbakemelding 
	(hvis tilbakeMelding string inneholder tekst).*/
	public boolean isTilbakeMeldingOk(){ 
		if (tilbakeMelding == null){
			return false;
		}else if (tilbakeMelding.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	//Lar deg sette tilbakemeldingsteksten.
	public void settTilbakeMelding(String tilbakeMelding){ 
		this.tilbakeMelding = tilbakeMelding;
	}
	
	// Lar deg sette om det er gitt tilbakemelding
	public String getTilbakeMelding(){ 
		return tilbakeMelding;
	}
	
	//Lar deg sette om oppgaven er godkjent eller ei
	public void setGodkjent(boolean godkjent){ 
		this.godkjent = godkjent;
	}
	
	//returnerer true hvis oppgaven er godkjent.
	public boolean isGodkjent(){
		return godkjent;
	}
}