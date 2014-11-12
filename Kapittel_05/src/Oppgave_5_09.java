import javax.swing.JOptionPane;

public class Oppgave_5_09
{
    public static void main( String args[] )
    {
    	int nedreGrense, ovreGrense, sum;// setter ulike variabler
    	String regnestykke;// setter ulike variabler
    	do// starter do-while løkke
    	{
    	nedreGrense = 0;// setter ulike variabler
    	ovreGrense = 0;// setter ulike variabler
    	sum = 0;// setter ulike variabler
    	regnestykke = "";// setter ulike variabler
    	String fra = JOptionPane.showInputDialog("Skriv inn et heltall som skal være nedre grense");// leser inn fra brukeren
    	String til = JOptionPane.showInputDialog("Skriv inn et heltall som skal være øvre grense");// leser inn fra brukeren
    	nedreGrense = Integer.parseInt(fra);// parser fra til nedreGrense
    	ovreGrense = Integer.parseInt(til);// parser "til" til ovreGrense
    	
    	
    	if (nedreGrense < ovreGrense)// hvis nedreGrense er mindre enn ovreGrense
    	{
    		for ( int i = nedreGrense; i < ovreGrense; i += 1)// start for-løkke
    		{
    			sum += i;// legger til "i" i sum (hvis i er 2 og sum er 1 blir sum til 3)
			
    			if(i > nedreGrense) // hvis i er større enn nedreGrense
    				regnestykke += "+"; // legg til "+" i regnestykke
    				regnestykke += i;// legg til i i regnestykke
    		}// slutt for-løkke
		JOptionPane.showMessageDialog( null, "Summen blir: "+ sum +"\nRegnestykket blir: "+ regnestykke );// melding til brukeren
    	}// slutt på if
    	else// hvis nedreGrense er større enn ovreGrense
    		JOptionPane.showMessageDialog(null, "Tallet som du satte som nedre grense er større enn øvre grense!");// melding til bruker
    	} while (nedreGrense < ovreGrense);// kjør så lenge nedreGrense er mindre enn ovreGrense
    }// slutt på main metode
}// slutt på klassen