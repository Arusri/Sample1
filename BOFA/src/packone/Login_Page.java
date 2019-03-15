package packone;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page {
	
	public @FindBy(id="REGISTERED_BY") WebElement Profile_for;
	public @FindBy(id="NAME") WebElement name;
	public @FindBy(xpath="//*[@id=\"close\"]/center/div[2]/div[3]/div/div/ul/li[11]/a") WebElement telugulink;
}
