package seleniumRevision;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Cookie.Builder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class seleniumPractice {
	
	@Test
	public void practice()
	{
		WebDriver driver = new ChromeDriver();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
//	options.addArguments("--headless");
	options.setAcceptInsecureCerts(true);
	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring((NoSuchElementException.class));
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//	driver.manage().window().maximize();
//	driver.findElement(By.xpath("//label[normalize-space()='Radio1']/input")).click();
//	System.out.println(driver.findElement(By.xpath("//label[normalize-space()='Radio1']/input")).isSelected());
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	WebElement dynamicDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'ui-autocomplete-input')]")));
//	dynamicDropdown.sendKeys("Ind");
//	WebElement optionValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'ui-menu-item-wrapper') and normalize-space()='India']")));
//	optionValue.click();
//	System.out.println(dynamicDropdown.getAttribute("value"));
//	Select staticDropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
//	staticDropdown.selectByIndex(1);
//	driver.findElement(By.id("name")).sendKeys("Dileep");
//	driver.findElement(By.cssSelector("#alertbtn")).click();
//	driver.switchTo().alert().dismiss();
//	driver.findElement(By.id("opentab")).click();
//	Set<String> windows = driver.getWindowHandles();
//	Iterator<String> it = windows.iterator();
//	String newHandle = windows.stream().filter(h-> !h.equals(driver.getWindowHandle())).findFirst().orElseThrow();
//	System.out.println(newHandle);
//	while(it.hasNext())
//	{
//		driver.switchTo().window(it.next());
//		System.out.print(driver.getCurrentUrl());
//	}
//	driver.switchTo().frame("courses-iframe");
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
	driver.findElement(By.xpath("//a[text()='Top']")).click();
	System.out.println(driver);
//	driver.quit();
	}
	
	@Test
	
	public void dragANdDrop()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions actions = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//h5[text()='High Tatras']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(drag));
		WebElement drop = driver.findElement(By.xpath("//div[@id='trash']"));
		actions.dragAndDrop(drag, drop).build().perform();
		

	}
	
	@Test
	public void colorPicker()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement slider = driver.findElement(By.xpath("//div[@id='red']//span"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(-100, 0).build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
	}
	
	@Test
	public void javaScriptExecutor()
	{
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.globalsqa.com/angularJs-protractor/Scrollable/");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement target= driver.findElement(By.xpath("(//td[text()='PIERRE'])[last()]"));
//		js.executeScript("arguments[0].scrollIntoView({behaviour:'smooth',block:'center'});", target);
//		js.executeScript("window.open('https://www.google.com','_blank')");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("download.default_directory","download_path");
		File file = new File("pom.xml");
		try {
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void excelOperations() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumPractice\\src\\main\\resources\\AI_Engineer_365Day_Learning_Tracker.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheetAt(0);
		System.out.println(sheet.getRow(1).getCell(4));
		sheet.getRow(1).getCell(4).setCellValue("Java selenium Practice");
		System.out.println(sheet.getRow(1).getCell(4));
		try (FileOutputStream out = new FileOutputStream("C:\\\\Users\\\\LENOVO\\\\eclipse-workspace\\\\SeleniumPractice\\\\src\\\\main\\\\resources\\\\AI_Engineer_365Day_Learning_Tracker.xlsx")) {
            wb.write(out);          // <‑ THIS creates / overwrites the file
        }
		
		wb.close();
	}
	
	@Test
	public void brokenLinks() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		List<WebElement> links = driver.findElements(By.xpath("//div[contains(@class,'col-md-6')]//a"));
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			URL linkUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseConde = connection.getResponseCode();
			if(responseConde  >= 400)
			{
				System.out.println("fail");
			}
		}
	}
	
	@Test
	public void screenShot() throws IOException
	{WebDriver driver = new ChromeDriver();
	driver.get("https://www.globalsqa.com/angularJs-protractor/Scrollable/");
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destFile = new File("screenshots","example.png");
	FileUtils.copyFile(src, destFile);
	WebElement target= driver.findElement(By.xpath("(//td[text()='PIERRE'])[last()]"));
	File elementScreenshot = target.getScreenshotAs(OutputType.FILE);
	File elementFile = new File("screenshots","elementSpecific.png");
	FileUtils.copyFile(elementScreenshot, elementFile);


	}
	
}
