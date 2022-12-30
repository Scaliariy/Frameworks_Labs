
import java.util.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import sumdu.edu.ua.studentweb.CustomExceptions.EmailException;
import sumdu.edu.ua.studentweb.Support.Student;
import sumdu.edu.ua.studentweb.Support.Utils;


/**
 *
 * @author Erlkonig
 */
public class StatsCalculatorTest {    
    static LinkedList<Student> studs;
    
    @BeforeAll
    public static void setupData(){
        studs=new LinkedList<>();
        studs.add(new Student("Test1", "Test1", "18", "test1@test.ua", "test", "faculty1"));
        studs.add(new Student("Test2", "Test2", "25", "test2@test.ua", "test1", "faculty1"));
        studs.add(new Student("Test3", "Test3", "20", "test3@test.ua", "test2", "faculty2"));
        studs.add(new Student("Test4", "Test4", "24", "test4@sumdu.edu.ua", "test3", "faculty3"));
    }
    @Test
    public void getEmailDomainTest(){
    String result=Utils.getEmailDomain("test@gmail.com");
    assertEquals(result,"gmail.com");
    }
    @Test
    public void whenExceptionThrown_thenExpectationSatisfied() throws EmailException {
    studs.add(new Student("Exception","Exception","-1","email","test","test"));
    	Assertions.assertThrows(EmailException.class, () -> {
		Utils.calculatePopularDomain(studs);
	});
    studs.remove(4);
    }
    @Test
    public void patternMatchesTest() {
    String emailAddress = "username@domain.com";
    assertTrue(Utils.patternMatches(emailAddress));
    }
    @Test
    public void calculatePopularDomainTest() throws EmailException{
    String result=Utils.calculatePopularDomain(studs);
    assertEquals("test.ua",result);
    }
    @Test
    public void calculateMeanAgeTest(){
    double result=Utils.calculateMeanAge(studs);
    assertEquals(21.75,result);
    }
    @Test
    public void calculateYoungestStudentTest() {
        double result = Utils.calculateYoungestStudent(studs);
        assertEquals(18, result);
    }

    @Test
    public void calculateOldestStudentTest() {
        double result = Utils.calculateOldestStudent(studs);
        assertEquals(25, result);
    }

    @Test
    public void calculateSumduDomainTest() throws EmailException {
        double count = Utils.calculateSumduDomain(studs);
        assertEquals(1, count);
    }

    @Test
    public void calculateDifferentGroupsTest() {
        String result = Utils.calculateDifferentGroups(studs);
        assertEquals("""
                     test2 : 1
                     test3 : 1
                     test : 1
                     test1 : 1
                     """, result);
    }

    @Test
    public void calculateNumberStudentsFromDifferentFacultiesTest() {
        String result = Utils.calculateNumberStudentsFromDifferentFaculties(studs);
        assertEquals("""
                     faculty3 : 1
                     faculty2 : 1
                     faculty1 : 2
                     """, result);
    }
}
