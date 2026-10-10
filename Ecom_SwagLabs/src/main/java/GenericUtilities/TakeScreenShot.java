package GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot {
	public void takeScreenShot(WebDriver driver,String modulename) throws IOException
	{
	TakesScreenshot tks= (TakesScreenshot)driver;
	File scr=tks.getScreenshotAs(OutputType.FILE);
	
	String filename="ScreenShot/"+modulename+".jpeg";
	File dest= new File(filename);
	FileHandler.copy(scr, dest);
	}
}