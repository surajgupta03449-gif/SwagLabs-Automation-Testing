package Ulitlity;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentreportManager {

    public static ExtentReports report;

    public static ExtentReports getReportInstance() {

        if (report == null) {
        	Date d = new Date();
        	String reportName = d.toString().replace(":", "_").replace(" ", "_");

            ExtentHtmlReporter htmlReporter =
                    new ExtentHtmlReporter("C:\\Users\\hp\\eclipse-workspace\\TEST_PROJECT\\ExtentReports\\"+ reportName + ".html");

            report = new ExtentReports();   // ✅ Remove 'ExtentReports' here

            report.attachReporter(htmlReporter);

            report.setSystemInfo("OS", "Windows");
            report.setSystemInfo("Environment", "Production");
            report.setSystemInfo("Build Number", "7.00");
            report.setSystemInfo("Browser", "Chrome");

            htmlReporter.config().setDocumentTitle("UI Automation");
            htmlReporter.config().setReportName("UI Test Report");
        }

        return report;
    }
}