import javax.swing.JOptionPane;

public class Oppgave_5_09
{
    public static void main( String args[] )
    {
    	int nedreGrense, ovreGrense, sum;
    	String regnestykke;
    	do
    	{
    	nedreGrense = 0;
    	ovreGrense = 0;
    	sum = 0;
    	regnestykke = "";
    	String fra = JOptionPane.showInputDialog("Skriv inn et heltall som skal være nedre grense");
    	String til = JOptionPane.showInputDialog("Skriv inn et heltall som skal være øvre grense");
    	nedreGrense = Integer.parseInt(fra);
    	ovreGrense = Integer.parseInt(til);
    	
    	
    	if (nedreGrense < ovreGrense)
    	{
    		for ( int i = nedreGrense; i < ovreGrense; i += 1)
    		{
    			sum += i;
			
    			if(i > nedreGrense) regnestykke += "+";
    			regnestykke += i;
    		}
    	

		JOptionPane.showMessageDialog( null, "Summen blir: "+ sum +"\nRegnestykket blir: "+ regnestykke );
    	}
    	else
    		JOptionPane.showMessageDialog(null, "Tallet som du satte som nedre grense er større enn øvre grense!");
    	} while (nedreGrense < ovreGrense);
    }
}