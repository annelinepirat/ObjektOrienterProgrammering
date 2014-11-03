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
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void leggTil()
	{
		try 
		{
			output.append("");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void lukk()
	{
		try 
		{
			output.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
