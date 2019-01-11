package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Table {

    WebDriver drive;
    CreateLog log;

    Table(){
         drive = new ChromeDriver();
         log = new CreateLog();
    }

    public void getTable(){

        String baseUrl = " http://demo.guru99.com/test/web-table-element.php";

        drive.manage().window().maximize();
        drive.get(baseUrl);

        WebElement link = null;

        List<WebElement> tableCol = drive.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr[1]/th"));

        List<WebElement> tableRows = drive.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));

            if (tableRows.size()>0){
                link = tableRows.get(1).findElement(By.tagName("a"));
                link.click();   // Click a link in a table

                if (drive.getCurrentUrl().equals("http://demo.guru99.com/")){
                    System.out.println("Click successfully!");

                }
                else {

                }
            }


        System.out.println("Link : " + link );
        System.out.println("Number of rows: " + tableRows.size());





    }

}
