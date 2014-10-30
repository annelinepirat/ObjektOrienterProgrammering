/*Lag en metode som leser inn en tekst fra skjermen og 
 * sjekker at den innleste verdien er et tall innenfor 
 * et bestemt intervall. Hvis den innleste verdien ikke 
 * er et tall, skal dette komme fram i en feilmelding. 
 * Hvis verdien er et tall utenfor intervallet, skal 
 * dette komme fram i en feilmelding. Hvis den innleste 
 * verdien er et tall innenfor intervallet, skal metoden 
 * returnere tallet.*/
import javax.swing.*;

public class TekstoppgaveTest 
{
	public static void main (String [] args)
	{
		String utskrift = "";
		
		double tallInn = Double.parseDouble(JOptionPane.showInputDialog("Skriv inn et tall mellom 3 og 12"));
		
		Tekstoppgave talldata = new Tekstoppgave(tallInn);
		String
	}
}
