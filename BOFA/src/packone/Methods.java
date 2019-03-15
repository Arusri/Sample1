package packone;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Sheet;
import jxl.Workbook;

public class Methods {
	
	public WebDriver driver;
	public FileInputStream f;
	public Workbook wb;
	public Sheet s;
	
	public void launchapp(String url,String sspath) throws Exception
	{
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File(sspath));
	}
	public void closeapp()
	{
		driver.close();
	}
	public void excelconn(String path,String sname) throws Exception
	{
		f=new FileInputStream(path);
		wb=Workbook.getWorkbook(f);
		s=wb.getSheet(sname);
	}
	public void Elementpresent(WebElement element,boolean exp,String sspath) throws Exception
	{
		boolean a=element.isDisplayed();
		if(a==exp)
		{
			System.out.println("pass-1");
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,new File(sspath));
		}
		else
		{
			System.out.println("fail-1");
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,new File(sspath));
		}
	}
	public void Elementenable(WebElement element,boolean exp,String sspath) throws Exception
	{
		boolean a=element.isEnabled();
		if(a==exp)
		{
			System.out.println("pass-2");
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,new File(sspath));
		}
		else
		{
			System.out.println("fail-2");
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,new File(sspath));
		}
	}
	public void Elementcount(String loc,int exp) throws Exception
	{
		List<WebElement> ecount=driver.findElements(By.tagName(loc));
		if(ecount.size()==exp)
		     System.out.println("pass-3");
		else
	         System.out.println("fail-3");
	}
	public void titlelength(int exp)
	{
		String title=driver.getTitle();
		if(title.length()==exp)
			System.out.println("pass-4");
		else
			System.out.println("fail-4");
	}
	public void titlecontains(String val,boolean exp)
	{
		String title=driver.getTitle();
		if(title.contains(val)==exp)
			System.out.println("pass-5");
		else
			System.out.println("fail-5");
	}
}
