/******************************************************************
 * @author Øystein
 * Gruppe.class													
 * Et samleobjekt for student-objekter.
 * 
 * ->Legg til studenter
 * ->Returner liste av studentene som array
 * ->Returner vectoren med alle studentene
 * 
 * 
 * 
 * LAGET AV ANNE-LINE OG ØYSTEIN ... kanskje
 * 
 * 
 ******************************************************************/
import java.io.Serializable;
import java.util.Vector;

//Serializable for enkelt lagring.
public class Gruppe implements Serializable 
{
	//Vector til å oppbevare alle studentobjektene (Vector ettersom denne er dynamisk).
	private Vector<Student> studenter = new Vector<Student>(); 
	
	public Gruppe() //Tom konstruktør.
	{
		
	}
	
	public void leggTilStudent(Student stud) //Legg til et studentobjekt.
	{
		studenter.addElement(stud);
	}
	
	public Student[] hentStudenterAsArray() //Returnerer studentene som en array.
	{
		Student[] stud = new Student[studenter.size()];
		studenter.toArray(stud);
		return stud;
	}
	
	//Returnerer vectoren med alle studentene.
	public Vector<Student> hentStudenterAsVector() 
	{
		return studenter;
	}
}