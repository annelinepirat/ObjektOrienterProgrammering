import javax.swing.JOptionPane;
/*Lag et program som beregner og 
 * skriver ut (i en dialogboks) summen
 * 2 + 4 + 6 + 8 + ... + 98*///Altså 2-gangen
public class Oppgave_5_01
{
	public static void main (String [] args)
	{
		int sum = 0; // her bestemmes variabelen sum
		
		for (int i = 2; i <= 98; i+=2 ) //setter variabelen i til 2, den skal gjennomføres så lenge i er mindre eller lik 98, i skal økes med 2 hver runde
			sum += i; // sum = sum + i
			
			JOptionPane.showMessageDialog (null, sum);//Skriver ut dialogboksen med variabelen sum
	}
}
