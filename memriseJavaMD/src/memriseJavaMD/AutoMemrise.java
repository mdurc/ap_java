package memriseJavaMD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;

import java.util.HashMap;
import java.util.List;
	
public class AutoMemrise {

	public static void main(String args[]) throws IOException, InterruptedException
    {//memrise automation by Matt Durcan
		
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mjrdp\\git\\repository4\\memriseJavaMD\\execFiles\\chromedriver.exe");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        // Instantiate a ChromeDriver class.
        
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=/Users/mdurcan/Library/Application Support/Google/Chrome/");
		options.addArguments("--profile-directory=Profile 3");
        WebDriver driver = new ChromeDriver();
  
        // Maximize the browser
        //driver.manage().window().maximize();
  
        // Launch Website
        Actions a = new Actions(driver);
        
        driver.get("https://app.memrise.com/aprender/speed?course_id=6261810");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(90));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-af59h9-2")));
        HashMap<String, String> map = new HashMap<String, String>();
        map = findMap();
        int count=0;
        boolean t = true;
        int runs =0;
        while(t) {
        	run(driver, a, map);
        	Thread.sleep(1000);
        	count++;
        	if(count==100) {
        		runs++;
        		if(runs==5) {
        			Thread.sleep(5000);
            		t=false;
            		driver.quit();
            		System.exit(0);
            	}
        		Thread.sleep(5000);
        		clickRetry(driver,a);
        		count=0;
            	Thread.sleep(7000);
        	}
        }
        
    }
	public static void run(WebDriver driver, Actions a, HashMap<String,String> map) throws InterruptedException {
	      	WebElement question= driver.findElement(By.className("sc-af59h9-2"));
	      	
		        String key = question.getText();
		        
		        System.out.println(key);
		        String answer = map.get(key);
		        List<WebElement> possible = driver.findElements(By.className("sc-kDvujY"));
		        
		        int count=1;
		        for (WebElement option : possible) {
		            String french = option.getText();
		            if(key.equals("prejudice")) {
			        	if(french.equals(answer)||french.equals("le préjugé")) {
			        		String input = Integer.toString(count);
			            	System.out.println(french+"\n-----");
			            	a.sendKeys(input).build().perform();
			        	}
			        }else if(french.equals(answer)) {
		            	String input = Integer.toString(count);
		            	System.out.println(french+"\n-----");
		            	a.sendKeys(input).build().perform();
		            }
		            count++;
		        }
		        
	        
        }
	
	
	public static void clickRetry(WebDriver driver, Actions a)throws ArrayIndexOutOfBoundsException {
		
		//refresh
		
		driver.navigate().refresh();
	}
	
	
	
	
	public static HashMap<String,String> findMap()throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\mjrdp\\git\\repository4\\memriseJavaMD\\docFiles\\document.txt"));

	    // Create the hash map
	    HashMap<String, String> map = new HashMap<>();

	    // Read each line of the file and add it to the map
	    String line;
	    boolean isOddLine = true;
	    String key = "";
	    String value = "";
	    while ((line = reader.readLine()) != null) {
	      if (isOddLine) {
	    	value = line;
	      } else {
	        key = line;
	        map.put(key, value);
	      }
	      isOddLine = !isOddLine;
	    }

	    // Close the reader
	    reader.close();
		return map;
	}
}
