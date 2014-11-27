//import java.io.Serializable; tror ikke Serializable er nødvendig
import java.util.Vector;

public class Gruppe //implements Serializable 
{
	private Vector<Student> studenter = new Vector<Student>();
	
//	public Gruppe() // hva gjør denne?
//	{
//		
//	}
	
	public void leggTilStudent(Student stud)
	{
		studenter.addElement(stud);
	}
	
	public Student[] hentStudenterAsArray()
	{
		Student[] stud = new Student[studenter.size()];
		studenter.toArray(stud);
		return stud;
	}
	
	public Vector<Student> hentStudenterAsVector()
	{
		return studenter;
	}
}