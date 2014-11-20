import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class TestLeseSkriveTilFil 
{
	Writer output = null;
	public void aapneFil()
	{
		try 
		{
			output = new BufferedWriter(new FileWriter("Klasseliste.txt", true));
		} // prøv å åpne 
		catch (IOException e) 
		{
			e.printStackTrace();
		}// feilmelding om det ikke går å åpne
	}// slutt på metoden aapneFil
	
	public void leggTil()
	{
		try 
		{
			output.append("");
		} // prøv å legge til
		catch (IOException e) 
		{
			e.printStackTrace();
		}// hvis ikke feilmelding
	}//slutt på metoden leggTil
	
	public void lukk()
	{
		try 
		{
			output.close();
		} // prøv å lukke
		catch (IOException e) 
		{
			e.printStackTrace();
		}//catch med feilmelding
	}//Slutt på metoden lukk
}//ferdig med klassen TestLeseSkriveTilFil
