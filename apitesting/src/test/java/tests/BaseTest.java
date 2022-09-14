package tests;

import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import service.ServiceFactory;
import utilities.ExtentReport;
import utilities.configManager;

public class BaseTest {
	
	private String configFileName;
	Properties PROPS;
	private String CrntWrkgnDir;
	ServiceFactory serviceFactory;
	String htmlfilename;
	
	ExtentReport extentReport;
	
	@BeforeSuite
	public void preSetup() throws Exception {
		
		CrntWrkgnDir = System.getProperty("user.dir");
		
		configFileName = CrntWrkgnDir + "/src/test/resources/config/config.properties";
		
		PROPS = configManager.configProperties(configFileName);
		
		// creating a html report
		htmlfilename = CrntWrkgnDir + "/src/test/resources/reports/htmlReport.html";
		extentReport = new ExtentReport(htmlfilename);
	}
	
	@BeforeClass
	public void Setup() {
		
		extentReport.createTestCase("Setup : Update all configs");
		RestAssured.baseURI = PROPS.getProperty("baseUrl");
		
		extentReport.addLog(Status.INFO, "BaseUrl" + " : " + PROPS.getProperty("baseUrl"));
		serviceFactory = new ServiceFactory();
	}
	
	@AfterMethod
	public void postexeccheck(ITestResult result) {
		
		String testname = result.getName();
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			extentReport.addLog(Status.PASS, "All test steps have passed");
		}else if (result.getStatus() == ITestResult.FAILURE) {
			extentReport.addLog(Status.FAIL, "Test case has failed");
		}
	}
	
	@AfterClass
	public void cleaner() {
		RestAssured.reset();
		extentReport.closeReports();
	}
}
