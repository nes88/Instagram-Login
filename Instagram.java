package web.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;


public class Instagram {

protected WebDriver driver;
public static String loginUrl = "https://www.instagram.com/accounts/login/?source=auth_switcher";

@Before
public void setUp() {

try {

DesiredCapabilities capabilities = DesiredCapabilities.chrome();
System.setProperty("webdriver.chrome.driver", "/Users/nesli/deneme/Driver/chromedriver");
driver = new ChromeDriver(capabilities);
driver.manage().window().maximize();
driver.manage().deleteAllCookies();

//dynamic wait
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

} catch (Exception e) {
e.printStackTrace();
}
}

@Test
public void Login() {

try {
driver.get(loginUrl);
driver.findElement(name("username")).sendKeys("nesli.necipoglu@gmail.com");
Thread.sleep(1000);
driver.findElement(name("password")).sendKeys("123456");
Thread.sleep(1000);
driver.findElement(xpath("/html[1]/body[1]/span[1]/section[1]/main[1]/div[1]/article[1]/div[1]/div[1]/div[1]/form[1]/div[4]")).click();
Thread.sleep(1000);

} catch (InterruptedException e) {
e.printStackTrace();
}
}


@After
public void tearDown() throws Exception {

}
}
