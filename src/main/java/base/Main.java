package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {     //constructor
public static Properties prop;
public static WebDriver driver;
public Main(){
try {
prop = new Properties();
FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop\\eclipse\\POMFramework"
+ "\\src\\propertyFiles\\config.properties");
prop.load(file);
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
}
}
public static void initialization() {
System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
}
public static void tearDown() {
driver.close();
}

}

// TestNG   interview question???
//   |
//   V
// TTD (Test driven develpment)=> Test cases <- Requirement -> code | Testing on code?? problem (understanding 
//of tester and developer will be diffrent)
// reach out to client/product owner to clarify the problem and solve and move forward for this reason you need TTD 
// TDD solves this situation by : requirment -> everyone sit together to understand it, then test cases are developed,
// then developers are going to write code based on those test cases -> then testing is done -> less defects will be identified








