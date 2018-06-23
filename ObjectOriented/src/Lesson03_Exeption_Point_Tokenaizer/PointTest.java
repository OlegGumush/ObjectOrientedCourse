package Lesson03_Exeption_Point_Tokenaizer;
public class PointTest {
	public static void main(String[] args) {
		Point p1 = new Point(1.5, 2);
		Point p2;
		System.out.println("p1="+p1.toString());
		String param = "[1,3.5]";
		String param1 = "[a,3.5]";
		String param2 = "[10,3.5, 7]";
		String param3 = null;
                
                //i am try to catch the exception 
                //if the operation work i dont need to catch
		try {
			//p2 = new Point(param);
			//p2 = new Point(param3);
			//p2 = new Point(param2);
			p2 = new Point(param);
			System.out.println("p2="+p2.toString());
		}
                //if the exception - null
                //the catch variable NULLEXEPTION
		catch (NullException ep) 
		{
			System.err.println(ep);
			System.exit(-1);  // exit the java program!
		}
                //if format exeption ....
		catch (NumberFormatException e) {
			System.err.println(" the coordinate is not a number!! "+e);
			return;//System.exit(-2);  // exit the java program!
		}
		// *** if any other 'unknown' exception happens.. ***
		catch (Exception e) {
			System.err.println("** unknown error !! **"+e);
			System.exit(-2);  // exit the java program!
		}
		finally{
			System.out.println("finally block");
		}
	}

}
