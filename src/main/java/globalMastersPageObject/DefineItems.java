package globalMastersPageObject;

import java.io.IOException;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Utility;

public class DefineItems {
  WebDriver dr;
  String pg="DefineItems";
  Utility u= new Utility();
						  
  public DefineItems(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  public void openDefineItems()
  {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Global-Masters.png']"));
 	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Define Items")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/StockManager/DefineUnit.aspx']")));
   }
   public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
   {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
   }
}
