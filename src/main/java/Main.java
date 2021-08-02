import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;


public class Main {

	public static void main(String[] args) {
		
		JUnitCore junit = new JUnitCore();
	    junit.addListener((RunListener)new TextListener(System.out));
	    Result result = junit.run(new Class[] { 
	    		MyTestDemo.class
	    });
	    if (result.getFailureCount() > 0) {
	      System.out.println("Test failed.");
	      System.exit(1);
	    } else {
	      System.out.println("Test finished successfully.");
	      System.exit(0);
	    } 

	}

}
