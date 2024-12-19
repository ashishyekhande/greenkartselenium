package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility {

	public WebDriver w;
	public utility(WebDriver w) {

		this.w =w;
		
	}

	public WebElement waitforelement(WebElement ele)
	{
		WebDriverWait wt = new WebDriverWait(w, Duration.ofSeconds(10));
		WebElement ele1=	wt.until(ExpectedConditions.visibilityOf(ele));
		return ele1;
		
	}
	
	public WebElement smartList(List<WebElement> ele, String str)
	{
		WebElement ele1 = ele.stream().filter(s->s.getText().equalsIgnoreCase(str)).findAny().orElse(null);
		return ele1;
	}
	
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("window.scrollBy(0, 500)");
	}
	
}
