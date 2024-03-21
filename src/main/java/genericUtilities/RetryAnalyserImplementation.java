package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementaion to IRetryAnlyser of TestNG
 * @author Chaitra M
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count = 0 ;
	int retryCount = 3 ;//manual analysis
	public boolean retry(ITestResult result) {
		
		//0<3 1<3 2<3 3<3NO
		while(count<retryCount)
		{
			count++;// 1 2 3
			return true;//retry retry retry
		}
		
		return false;//not retry
	}
	
	

}
