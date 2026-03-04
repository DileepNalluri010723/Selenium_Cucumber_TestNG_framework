package seleniumRevision;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class testNg {


//	
//	@BeforeTest
//	public void beforeTest () { System.out.println("BEfore test");}
//	
//	@BeforeClass
//	public void beforeClass () { System.out.println("BEfore class");}
//	
//	@BeforeMethod
//	public void beforeMethod () { System.out.println("BEfore method");}

//	@Test
//	public void test(){ 
//		System.out.println("Test");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		System.out.println(driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "Practice Page");
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(driver.getTitle(), "Rahul shetty");
//		sa.assertAll();
//		}
	
//	@DataProvider(name="addData")
//	public static Object[][] data()
//	{
//		return new Object[][] {
//			{1,2,4},
//			{234,5234,423},
//			{2,5,7}
//		};
//	}
//	
//	@Test(dataProvider ="addData")
//	public void dataProviderTest(int a, int b, int expected)
//	{
//		Assert.assertTrue(a +b == expected);
//	}
	
	@Parameters({"a","b","sum"})
	@Test
	public void parametersTestUsingTestNg(int a, int b, int expected)
	{
		Assert.assertTrue(a +b == expected);
	}
	
//	@AfterMethod
//	public void afterMethod() { System.out.println("After method");}
//	
//	@AfterClass
//	public void afterClass () { System.out.println("After class");}
//	
//	@AfterTest
//	public void afterTest () { System.out.println("After test");}
//	
	@AfterSuite
	public void afterSuite() {System.out.println("AFter suite");
	};

}

