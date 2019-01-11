package Selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import jdk.internal.dynalink.beans.StaticClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreateLog {

    ExtentReports extent;
    ExtentHtmlReporter reporter;
    HashMap<String,ExtentTest> storeAllLogger;

    CreateLog(){

        reporter = new ExtentHtmlReporter("./Report/Log.html");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        storeAllLogger = new HashMap<String, ExtentTest>();
    }

    @Test
    public void createLogger(String header){

        String key = header.trim();

        ExtentTest logger = extent.createTest(key);
        storeAllLogger.put(key , logger);

    }

    public void writeLog(String header, String message, boolean status){

        String key = header.trim();

        if (storeAllLogger.containsKey(key)){

            ExtentTest objExistLogger = storeAllLogger.get(key);

            if (status){
                objExistLogger.log(Status.PASS, message);
            }
            else {
                objExistLogger.log(Status.FAIL, message);
            }
            extent.flush();
        }


    }

}
