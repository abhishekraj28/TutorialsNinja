package baseCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public Random random=new Random();
	public static WebDriver d;
	public Properties p;
	
	//log4j
	public Logger logger;	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setup(String os,String br) throws IOException {
		
		 FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
		    p = new Properties();
		    p.load(file);
		    
	    logger = LogManager.getLogger(this.getClass());
	    
	    if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
	    	
	    	DesiredCapabilities cap=new DesiredCapabilities();
	    	
	    	//OS
	    	if(os.equalsIgnoreCase("windows")) {
	    		cap.setPlatform(Platform.WIN10);
	    		
	    	}
	    	else if(os.equalsIgnoreCase("linux")) {
	    		cap.setPlatform(Platform.LINUX);
	    	}
	    	else if(os.equalsIgnoreCase("mac")) {
	    		cap.setPlatform(Platform.MAC);
	    	}
	    	else {
	    		System.out.println("no matching platform");
	    		return;
	    	}
	    	
	    	//Browser
	    	switch(br.toLowerCase()) {
	    	case "chrome" : cap.setBrowserName("chrome");
	    	break;
	    	
	    	case "Edge" : cap.setBrowserName("edge");
	    	break;
	    	
	    	case "firefox" : cap.setBrowserName("firefox");
	    	break;
	    	
	    	default:
	    		System.out.println("No matching browser");
	    		return;
	    	}
	    	
	    	d=new RemoteWebDriver(new URL("http://192.168.1.41:4444/wd/hub"),cap);
	    }
	    
	    if(p.getProperty("execution_env").equalsIgnoreCase("local")) {

	    	switch (br.toLowerCase()) {
	    		        case "chrome": d = new ChromeDriver(); break;
	    		        case "edge": d = new EdgeDriver(); break;
	    		        case "firefox": d = new FirefoxDriver(); break;
	    		        default:
	    		            System.out.println("Invalid browser name");
	    		            return;
	    	}	
	    }

	    d.manage().window().maximize();
	    d.manage().deleteAllCookies();
	    d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    d.get(p.getProperty("AppURL1"));
	}
	
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown() {
		d.quit();
	}
	
	public String randomString() {
		String generate=RandomStringUtils.randomAlphabetic(7);
		return generate;
	}
	
	public String randomNumber() {
		String generateNo=RandomStringUtils.randomNumeric(10);
		return generateNo;
	}
	
	public String randomAlphaNumeric() {
		
		String generatePwd=RandomStringUtils.randomAlphanumeric(7);
		String generateNo=RandomStringUtils.randomNumeric(5);
		return generatePwd+generateNo;
	}
	
	 public String getRandomDay() {
	        return String.valueOf(random.nextInt(28) + 1); // Ensuring day 1-28 to avoid invalid dates
	    }

	    public String getRandomMonth() {
	        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	        return months[random.nextInt(months.length)];
	    }

	    public String getRandomYear() {
	        return String.valueOf(random.nextInt(30) + 1990); // Random year between 1990 and 2019
	    }

	    
	    public String captureScreen(String tname) {
	    	
	    	String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	    	TakesScreenshot screenshot=(TakesScreenshot) d;
	    	File file=screenshot.getScreenshotAs(OutputType.FILE);
	    	
	    	String targetfilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+" "+timeStamp+".png";
	    	File targetfile=new File(targetfilePath);
	    	
	    	file.renameTo(targetfile);
	    	return targetfilePath;
	    }
}