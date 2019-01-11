package Selenium;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



        //System.setProperty("webdriver.chrome.driver","BrowserDrivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","BrowserDrivers/geckodriver.exe");
        System.setProperty("webdriver.ie.driver","BrowserDrivers/IEDriverServer.exe");

        System.out.println( "Hello World!" );

//        Image im = new Image();
//        im.ClickImage();

        //Table table1 = new Table();
       // table1.getTable();
//
        String userName = "TaniaSultana01";
        String password = "amtDirect01!";
        String clintId = "201483";

        TestTableAmt ob = new TestTableAmt();
        if (ob.login(userName,password,clintId)){
            System.out.println("Login successful");
           if (ob.navigate("My Account", "Client Profile")){
                System.out.println("Navigate Successful!");
                ob.verifyTableValue("test", "Test", "Test");
           }
       }
    }
}
