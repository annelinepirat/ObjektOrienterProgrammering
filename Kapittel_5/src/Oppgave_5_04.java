import javax.swing.JOptionPane;
/* Lag et program som beregner og skriver ut summen av alle 
 * hele tall mellom to grenser som brukeren skriver inn. 
 * Programmet skal starte med å lese inn nedre og øvre grense 
 * for summen. Dersom innlest øvre grense er mindre enn eller 
 * lik nedre grense, skal programmet skrive ut en melding til 
 * brukeren om dette og deretter avslutte. Ellers skal
 * programmet beregne nevnte sum - nedre grense skal tas med 
 * i summen, men ikke øvre grense - og summen skal skrives ut.*/
public class Oppgave_5_04
{
    public static void main( String args[] )
    {
    	int nedreGrense = 0, ovreGrense = 0, sum = 0;
    	String regnestykke = "";
    	String fra = JOptionPane.showInputDialog("Skriv inn et heltall som skal være nedre grense");
    	String til = JOptionPane.showInputDialog("Skriv inn et heltall som skal være øvre grense");
    	nedreGrense = Integer.parseInt(fra);
    	ovreGrense = Integer.parseInt(til);
    	
    	if (nedreGrense < ovreGrense)
    	{
    		for ( int i = nedreGrense; i < ovreGrense; i += 1)
    		{
    			sum += i;
			
    			if(i > nedreGrense) regnestykke += "+"; //Sleng på teksten "+", men ikkje i første runda.
    			regnestykke += i;
    		}
 
		JOptionPane.showMessageDialog( null, "Summen blir: "+ sum +"\nRegnestykket blir: "+ regnestykke );
    	}
    	else
    		JOptionPane.showMessageDialog(null, "Tallet som du satte som nedre grense er større enn øvre grense!");
    }
}