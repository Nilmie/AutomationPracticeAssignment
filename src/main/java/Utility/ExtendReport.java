package Utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ExtendReport {
	
		ExtentReports extent;
	    ExtentTest logger;
	   public void setUpReport ()
	   {
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExecutionReport.html", true);
	   }
	   
	   
	   public void logEventsInfo (String value)
	   {
		   logger.log(LogStatus.INFO, value);
	   }
	   
	   public void logEventsWarning (String value)
	   {
		   logger.log(LogStatus.WARNING, value);
	   }
	   
	   public void logEventsFail (String value)
	   {
		   logger.log(LogStatus.FAIL, value);
	   }
	   
	   public void logEvents (String value)
	   {
		   logger.log(LogStatus.PASS, value);
	   }
	   
	   public void startTestCase (String testcaseName)
	   {
		   logger = extent.startTest(testcaseName);
	   }
	   public void createFinalReport()
	   {
		   extent.flush();
		  
	   }
}