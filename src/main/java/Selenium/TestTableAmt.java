package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import sun.security.util.Password;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestTableAmt {

    WebDriver drive;

    TestTableAmt(){
        drive = new ChromeDriver();
    }

    public boolean login(String name, String pass, String id) {

        String baseUrl = "https://qa3.testamt.com/";

        drive.manage().window().maximize();
        drive.get(baseUrl);

        WebElement userName = drive.findElement(By.id("txtUSER_NAME"));
        WebElement password = drive.findElement(By.id("txtPassword"));
        WebElement clintId = drive.findElement(By.id("txtClient_Number"));
        WebElement btnLogin = drive.findElement(By.xpath("//*[@id=\"LoginController-div\"]/div/div[1]/div/div/div[2]/form/div[4]/div[2]/input"));

        userName.sendKeys(name);
        password.sendKeys(pass);
        clintId.sendKeys(id);
        btnLogin.click();

        if (drive.getCurrentUrl().equals("https://qa3.testamt.com/Home/Index")) {
            return true;
        }else {
            return false;
        }
    }

    public boolean navigate(String parent, String child){


        WebElement dropdown = drive.findElement(By.id("amt-menu-main-collapse"));
        List<WebElement> items = dropdown.findElements(By.tagName("li"));

        for (WebElement li : items) {

            if (li.getText().equals(parent)){
                //System.out.println("List Items is : "+ li.getText());
                li.click();
                List<WebElement> accountItems = li.findElements(By.tagName("ul"));
                for (WebElement ul : accountItems
                     ) {
                   List<WebElement> cProfile = drive.findElements(By.tagName("li"));
                    for (WebElement it : cProfile
                         ) {
                        if (it.getText().equals(child)){
                            it.click();
                            if (drive.getCurrentUrl().equals("https://qa3.testamt.com/Security/ClientInfo")){
                                return true;
                            }
                        }
                    }

                }
            }

        }
        return false;
    }


    public void verifyTableValue(String val1, String val2, String path){

        try {
            JavascriptExecutor jsExe = (JavascriptExecutor) drive;
            WebElement btnInterestRate = drive.findElement(By.id("btn_npv_interest"));

            jsExe.executeScript("arguments[0].click();", btnInterestRate);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            //System.out.println(e);
        }


    }


}
