package packtwo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import packone.Login_Page;
import packone.Methods;
import packone.Telugu_Page;
public class Calling_methods {
	public static void main(String[] args) throws Exception {

		Methods m=new Methods();
		m.excelconn("C:\\Users\\user\\Desktop\\8Hybrid\\Test Data\\Rutuparna\\TC01.xls", "Sheet1");
		m.launchapp(m.s.getCell(0,0).getContents(),"C:\\Users\\user\\Desktop\\8Hybrid\\Test Results\\Rutuparna\\launchapp.png");
		Login_Page login=PageFactory.initElements(m.driver,Login_Page.class);
		m.Elementpresent(login.name,true,"C:\\Users\\user\\Desktop\\8Hybrid\\Test Results\\Rutuparna\\elepresent.png");
		m.Elementenable(login.Profile_for,true,"C:\\Users\\user\\Desktop\\8Hybrid\\Test Results\\Rutuparna\\eleenable.png");
		m.titlecontains("India",true);
		m.titlelength(30);
		//Select profile based on index
		Select s=new Select(login.Profile_for);
		s.selectByVisibleText("Son");
		
		//count the no of values in dropdown
		List<WebElement> items=login.Profile_for.findElements(By.tagName("option"));
		if(items.size()==10)
			System.out.println("pass-6");
		else
			System.out.println("fail-6");
		
		login.name.sendKeys(m.s.getCell(0,1).getContents());
		m.Elementcount("a",30);
		login.telugulink.click();
		
		Telugu_Page t=PageFactory.initElements(m.driver,Telugu_Page.class);
		t.name.sendKeys(m.s.getCell(0,1).getContents());
		
		WebDriverWait ww=new WebDriverWait(m.driver,30);
		ww.until(ExpectedConditions.titleContains("Telugu"));
		m.titlecontains("telugu",true);
		m.closeapp();	
		
		
	}

}
