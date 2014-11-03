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
		//Lager variablene som skal brukes
		int påNytt;
		String utskrift = "";
		
		Tekstoppgave talldata = new Tekstoppgave();// oppretter konstruktør
		
		//får oss inn i while-løkka hvis man velger ja, hvis ikke avslutte
		påNytt = JOptionPane.showOptionDialog(
				null, 
				"Vil du starte å sjekke et tall?", 
				"Innenfor grensen?", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, null, null);
		while (påNytt == JOptionPane.YES_OPTION)
		{
		String tallInn = JOptionPane.showInputDialog("Skriv inn et tall mellom 3 og 12");//String input som skal sjekkes
		utskrift = talldata.getVerdi(tallInn);//velger hva utskriften skal bli, nemlig verdien "getVerdi"
		
		//starter while på nytt eller avslutte
		JOptionPane.showMessageDialog(null, utskrift);
		påNytt = JOptionPane.showOptionDialog(
				null, 
				"Vil du sjekke et tall til?", 
				"Innenfor grensen?", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, null, null);
		}//slutt while
	}//slutt main
}//slutt klassen
