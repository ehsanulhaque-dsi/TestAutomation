package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Image
{
    CreateLog createLog;
    WebDriver Drive;

    Image(){
        //Drive = new ChromeDriver();
        //Drive = new FirefoxDriver();
        Drive = new InternetExplorerDriver();
        createLog = new CreateLog();
    }


    public void ClickImage(){

        String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";

        Drive.manage().window().maximize();

        Drive.get(baseUrl);

        WebElement Image = Drive.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]"));

        Image.click();


        System.out.println(Drive.getTitle());

        createLog.createLogger("Login page redirect");

        if (Drive.getTitle().trim().equals("Facebook – log in or sign up")){

            createLog.writeLog("Login page redirect", "Redirect to correct page", true);

            WebElement email = Drive.findElement(By.id("email"));
            WebElement pass = Drive.findElement(By.id("pass"));
            WebElement btnlogin = Drive.findElement(By.id("loginbutton"));

            email.sendKeys("");
            pass.sendKeys("");

            createLog.createLogger("Button Click");

            if (btnlogin.isEnabled()){
                btnlogin.click();
                createLog.writeLog("Button Click","Login button clicked", true);
            }
            else{
                createLog.writeLog("Button Click","Login button clicked", false);
            }
            createLog.createLogger("Login");
            if (Drive.getCurrentUrl().trim().equals("https://www.facebook.com/")){

                createLog.writeLog("Login","Login successfully done ", true);
            }
            else{
                createLog.writeLog("Login","Login failed ", false);
            }
        }
        else{
            createLog.writeLog("Login page redirect", "Redirect to wrong page", false);
        }
    }
}
