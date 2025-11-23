package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public WebDriver erDriver;
	public ExtentSparkReporter ExtSparkReporter;///UI of the reports
	public ExtentReports ExtReports;///Populate the common info on report
	public ExtentTest ExtTest;///Create new Test cases entries and updates the status of test methods
	public String ReportName;
	
	public void onStart(ITestContext TestContext) {
		
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        ReportName = "TestReport_" + timestamp + ".html";

        String reportPath = System.getProperty("user.dir") + File.separator + "Results\\Reports" + File.separator + ReportName;
        ExtSparkReporter = new ExtentSparkReporter(reportPath);
	
		ExtSparkReporter.config().setDocumentTitle("Demo Automation Report");
		ExtSparkReporter.config().setReportName("Slider Functional Flow");
		ExtSparkReporter.config().setTheme(Theme.STANDARD);
        
		ExtReports = new ExtentReports();
		ExtReports.attachReporter(ExtSparkReporter);
		ExtReports.setSystemInfo("Demo Application", "Slider");
		ExtReports.setSystemInfo("Module", "Jquerry");
		ExtReports.setSystemInfo("Sub Modules", "slider left, slider right,");
		ExtReports.setSystemInfo("User Name", System.getProperty("user.name"));
		ExtReports.setSystemInfo("Environment", "QA");
		String os = TestContext.getCurrentXmlTest().getParameter("os");
		ExtReports.setSystemInfo("Operating System", os);
		
		String browser = TestContext.getCurrentXmlTest().getParameter("browser");
		ExtReports.setSystemInfo("Browser", browser);
		
		List<String> IncludeGroups = TestContext.getCurrentXmlTest().getIncludedGroups();
		if(!IncludeGroups.isEmpty()) {
			ExtReports.setSystemInfo("Groups", IncludeGroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult result) {
		ExtTest = ExtReports.createTest(result.getMethod().getMethodName());///Create a new entry
		ExtTest.assignCategory(result.getMethod().getGroups());///to display groups in reports
		ExtTest.log(Status.PASS, result.getName()+" got successfully executed");///update the status into the reports
	}
	
	public void onTestFailure(ITestResult result) {
		ExtTest = ExtReports.createTest(result.getMethod().getMethodName());
	    ExtTest.assignCategory(result.getMethod().getGroups());
	    ExtTest.log(Status.FAIL, result.getName() + " got failed");
	    ExtTest.log(Status.INFO, result.getThrowable().getMessage());
	    try {
	        WebDriver erDriver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
	        if (erDriver != null) {
            // 💡 Screenshot capture directly here
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String testName = result.getName();
            TakesScreenshot ts = (TakesScreenshot) erDriver;
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + File.separator + "Results\\ScreenShots" + File.separator + testName + "_" + timeStamp + ".png";
            File targetFile = new File(screenshotPath);
            FileUtils.copyFile(sourceFile, targetFile);

            // Attach to ExtentReports
            ExtTest.addScreenCaptureFromPath(screenshotPath);
	        } else {
	            ExtTest.log(Status.WARNING, "WebDriver instance was not found for screenshot.");
	        }
	    } catch (IOException e) {
	        ExtTest.log(Status.WARNING, "⚠️ Screenshot capture failed: " + e.getMessage());
	    }
	}

	public void onTestSkipped(ITestResult result) {
		ExtTest = ExtReports.createTest(result.getMethod().getMethodName());///Create a new entry
		ExtTest.assignCategory(result.getMethod().getGroups());///to display groups in reports
		ExtTest.log(Status.SKIP, result.getName()+" got skipped");///update the status into the reports
		ExtTest.log(Status.INFO, result.getThrowable().getMessage());

	}
	
	public void onFinish(ITestContext TestContext) {
		ExtReports.flush();
		
		try {
            File reportFile = new File(System.getProperty("user.dir") + File.separator + "Results\\Reports" + File.separator + ReportName);
            Desktop.getDesktop().browse(reportFile.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
		/*
		try {
		    // Correct report URL
		    URL url = new URL("file:///" + System.getProperty("user.dir") + "\\Results\\Reports\\" + ReportName);

		    ImageHtmlEmail email = new ImageHtmlEmail();
		    email.setDataSourceResolver(new DataSourceUrlResolver(url));
		    email.setHostName("smtp.gmail.com");
		    email.setSmtpPort(465);
		    
		    // ✅ Use your App Password here (not your Gmail password)
		    email.setAuthenticator(new DefaultAuthenticator("jeevanpgowda27@gmail.com", "tixo wrez bxne otnp"));
		    
		    email.setSSLOnConnect(true);
		    email.setFrom("jeevanpgowda27@gmail.com");
		    email.setSubject("Automation Test Results");
		    email.setMsg("In4Suite - Expenses Module | Automation Test Results | QA");
		    email.addTo("jeevangowda016@gmail.com");
		    
		    // Attach the HTML report
		    email.attach(url, "Extent Report", "Please check test report....");

		    // Send the email
		    email.send();

		    System.out.println("✅ Email sent successfully!");

		} catch (Exception e) {
		    e.printStackTrace();
		    System.err.println("❌ Failed to send email: " + e.getMessage());
		}
		*/
	}

}