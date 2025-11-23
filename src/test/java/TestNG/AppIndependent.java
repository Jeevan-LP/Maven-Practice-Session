package TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppIndependent{

	public WebDriver BrowserDriver;
	public WebElement Element;
    public WebDriverWait ExpWait;
    public FileInputStream fInput;
	public Properties Pfile;
	public FileOutputStream fOutput;
	public XSSFWorkbook XworkBook;
	public XSSFSheet Xsheet;
	public XSSFRow Xrow;
	public XSSFCell Xcell;
	public XSSFCellStyle Xstyle;
	public JavascriptExecutor jsExecutor;
	public WebElement WElement;
	
	public void JavaScriptclick(WebDriver BrowserDriver,WebElement WElement) {
		 jsExecutor=(JavascriptExecutor)BrowserDriver;
		 jsExecutor.executeScript("arguments[0].click();", WElement);
	}
	
	public void selectCurrentDate(WebDriver driver, WebElement dateInputElement) {
        try {
            dateInputElement.click(); // Open calendar
            String today = new SimpleDateFormat("MMM dd, yyyy").format(new Date());

            List<WebElement> dates = driver.findElements(By.xpath("//td[@aria-label]"));
            for (WebElement d : dates) {
                if (today.equalsIgnoreCase(d.getAttribute("aria-label"))) {
                    d.click(); // Click today
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Date select error: " + e.getMessage());
        }
    }


	public void waitForElementLocated(WebElement Element, int timeout) {
         ExpWait = new WebDriverWait(BrowserDriver, Duration.ofSeconds(timeout));
        ExpWait.until(ExpectedConditions.visibilityOfElementLocated((By) Element));
    }
	public void waitForElementClickable(WebElement Element, int timeout) {
         ExpWait = new WebDriverWait(BrowserDriver, Duration.ofSeconds(timeout));
        ExpWait.until(ExpectedConditions.elementToBeClickable(Element));
    }
	
	public void selectDropdownFromExcel(String XLfileName, String XLsheetName, int Rows, int cells, WebElement dropdownElement)throws Throwable {
		try {
		fInput=new FileInputStream(XLfileName);
		XworkBook=new XSSFWorkbook(fInput);
		Xsheet=XworkBook.getSheet(XLsheetName);
		if (Xsheet == null) {
			XworkBook.close();
			fInput.close();
            throw new IllegalArgumentException("Sheet not found: " + XLsheetName);
        }
		
		Xrow=Xsheet.getRow(Rows);
		if (Xrow == null) {
			XworkBook.close();
			fInput.close();
            throw new IllegalArgumentException("Row not found: " + Xrow);
        }
		
		Xcell=Xrow.getCell(cells);
        if (Xcell == null) {
        	XworkBook.close();
        	fInput.close();
            throw new IllegalArgumentException("Cell not found: " + Xcell);
        }

		String value = new DataFormatter().formatCellValue(Xcell);
        new Select(dropdownElement).selectByVisibleText(value);
		}
		catch (Exception e) {
			System.out.println("Error selecting dropdown: " + e.getMessage());
		}
	}
	
	public void selectTextFieldFromExcel(String XLfileName, String XLsheetName, int Rows, int cells, WebElement TextFieldElement)throws Throwable {
		try {
		fInput=new FileInputStream(XLfileName);
		XworkBook=new XSSFWorkbook(fInput);
		Xsheet=XworkBook.getSheet(XLsheetName);
		if (Xsheet == null) {
			XworkBook.close();
			fInput.close();
            throw new IllegalArgumentException("Sheet not found: " + XLsheetName);
        }
		
		Xrow=Xsheet.getRow(Rows);
		if (Xrow == null) {
			XworkBook.close();
			fInput.close();
            throw new IllegalArgumentException("Row not found: " + Xrow);
        }
		
		Xcell=Xrow.getCell(cells);
        if (Xcell == null) {
        	XworkBook.close();
        	fInput.close();
            throw new IllegalArgumentException("Cell not found: " + Xcell);
        }

		String value = new DataFormatter().formatCellValue(Xcell);
		TextFieldElement.sendKeys(value);
		}
		catch (Exception e) {
			System.out.println("Error selecting dropdown: " + e.getMessage());
		}
	}
	
		////****** Switching Methods........ ******////
		public void MainParentFrame() {
	    	ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='erpContainer']")));
	    }

	    public void LeftFrame() {
	    	ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@name='mainmenuFrame']")));
	    }

	    public void MiddleFrame() {
	    	ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='slideleft']")));
	    }

	    public void MainFrame() {
	    	ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@name='mainFrame']")));
	    }

	    public void RightFrame() {
	    	ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@name='rightframe']")));
	    }
	    
	    public void TopFrame() {
	    	ExpWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='topFrame.aspx']")));
	    }
	  

	    public void DefaultContentFrame() {
	    	BrowserDriver.switchTo().defaultContent();
	    }

	    public void ParentContentFrame() {
	    	BrowserDriver.switchTo().parentFrame();
	    }
	    
	    public void Parentwindow() {
	    	Set<String> windowID = BrowserDriver.getWindowHandles();
			List<String> list = new ArrayList(windowID);
			
			String Parent = list.get(0);
			BrowserDriver.switchTo().window(Parent);
			System.out.println("Switching to (Back to Parent)"+BrowserDriver.getTitle()+" Window");
	    }
	    
	    public void Childwindow() {
	    	Set<String> windowID = BrowserDriver.getWindowHandles();
			List<String> list = new ArrayList(windowID);
			
			String Child = list.get(1);
			BrowserDriver.switchTo().window(Child);
			System.out.println("Switching to (Child)"+BrowserDriver.getTitle()+" Window");
	    }
	    
	    public void NestedChildwindow() {
	    	Set<String> windowID = BrowserDriver.getWindowHandles();
			List<String> list = new ArrayList(windowID);
			
			String NestedChild = list.get(2);
			BrowserDriver.switchTo().window(NestedChild);
			System.out.println("Switching to "+BrowserDriver.getTitle()+" Window");
	    }
	    
	
	    ////****** Wait Conditions Methods........ ******////
		public void elementToBeClickable(WebElement Element) {
		    if (ExpWait == null) {
		        throw new IllegalStateException("ExpWait not initialized in AppIndependentUtility");
		    }
		    ExpWait.until(ExpectedConditions.elementToBeClickable(Element));
		}
	/*
	    public WebElement waitForClickability(WebElement element) {
	        return ExpWait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	
	    public WebElement waitForPresence(By locator) {
	        return ExpWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
	*/
   
	    ////****** Drop downs Methods........ ******////
	    public void singleDropDown(WebElement comPath, String Company_Name) {
		try {
			Thread.sleep(1000);
		Select sct = new Select(comPath);
		Thread.sleep(1000);
		sct.selectByVisibleText(Company_Name);
		Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
    
	    public void selectByVisibleText(WebElement dropdownElement, String visibleText) {
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(visibleText);
	    }
	
	    public void selectByValue(WebElement dropdownElement, String value) {
	        Select select = new Select(dropdownElement);
	        select.selectByValue(value);
	    }
	
	    public void selectByIndex(WebElement dropdownElement, int index) {
	        Select select = new Select(dropdownElement);
	        select.selectByIndex(index);
	    }
	    
	    public void deSelectByVisibleText(WebElement dropdownElement, String visibleText) {
	        Select select = new Select(dropdownElement);
	        select.deselectByVisibleText(visibleText);
	    }
	
	    public void deSelectByValue(WebElement dropdownElement, String value) {
	        Select select = new Select(dropdownElement);
	        select.deselectByValue(value);
	    }
	
	    public void deSelectByIndex(WebElement dropdownElement, int index) {
	        Select select = new Select(dropdownElement);
	        select.deselectByIndex(index);
	    }
	
	    public void deselectAll(WebElement dropdownElement) {
	        Select select = new Select(dropdownElement);
	        select.deselectAll();
	    }
	
	    public void printAllSelectedOptions(WebElement dropdownElement) {
	        Select select = new Select(dropdownElement);
	        for (WebElement option : select.getAllSelectedOptions()) {
	            System.out.println("Selected: " + option.getText());
	        }
	    }   
	    
	    public void ALlOptions(WebElement dropdownElement) {
	            Select select = new Select(dropdownElement);
	            select.getOptions();
	    }
	    
	
	     ////****** Properties class Methods........ ******////
	     public String getKeyValue(String FilePath, String KeyName) throws Throwable {
			fInput=new FileInputStream(FilePath);
			Pfile= new Properties();
			Pfile.load(fInput);
			String Keyvalue = Pfile.getProperty(KeyName);
			//System.out.println(Keyvalue);
			fInput.close();
			return Keyvalue;
		 }
		
		public Set<String> getKeyName(String FilePath) throws Throwable {
			fInput=new FileInputStream(FilePath);
			Pfile= new Properties();
			Pfile.load(fInput);
			Set<String> KeyName = Pfile.stringPropertyNames();
			for(String KName:KeyName) {
				System.out.println(KName);
			}
			fInput.close();
			return KeyName;
		}
	
		
		 ////****** Excel class Methods........ ******////
		public int getRowNumber(String XLfileName, String XLsheetName) throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			int RowNO=Xsheet.getLastRowNum();
			//System.out.println("Number of Rows "+RowNO);
			XworkBook.close();
			fInput.close();
			return RowNO;
		}
		
		public int getCellNumber(String XLfileName, String XLsheetName, int Rows) throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			Xrow=Xsheet.getRow(Rows);
			int CellNo=Xrow.getLastCellNum();
			//System.out.println("Number of Cells "+CellNo);
			XworkBook.close();
			fInput.close();
			return CellNo;
			
		}
		
		//public static String getCellSingleData(String XLfileName, String XLsheetName, int Rows, int cells)// both also correct
		public String getCellData(String XLfileName, String XLsheetName, int Rows, int cells)throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			Xrow=Xsheet.getRow(Rows);
			Xcell=Xrow.getCell(cells);
	
			String data;
			try {
			DataFormatter formatter = new DataFormatter();
			data=formatter.formatCellValue(Xcell);
			System.out.println(formatter.formatCellValue(Xcell));
			}
			catch (Exception e) {
				data="";
			}
			XworkBook.close();
			fInput.close();
			return data;
		}
		
		public void getCellAllData(String XLfileName, String XLsheetName, int Rows) throws Throwable {
			fInput=new FileInputStream(XLfileName);
			XworkBook=new XSSFWorkbook(fInput);
			Xsheet=XworkBook.getSheet(XLsheetName);
			int rowNo=Xsheet.getLastRowNum();
			int cellNo = Xsheet.getRow(Rows).getLastCellNum();
			
			for(int r=0;r<=rowNo;r++) {
				Xrow=Xsheet.getRow(r);
				for(int c=0;c<=cellNo-1;c++) {
					Xcell=Xrow.getCell(c);
					String data;
					try {
					DataFormatter formatter = new DataFormatter();
					data=formatter.formatCellValue(Xcell);
					System.out.print(formatter.formatCellValue(Xcell)+"\t");
					}
					catch (Exception e) {
						data="";
					}
				}
				System.out.println();
			}
			
		}
			
		 public void SetCellData(String XLfileName, String XLsheetName, int Rows, int cells, String data) throws Throwable {
			 fInput=new FileInputStream(XLfileName);
			 XworkBook=new XSSFWorkbook(fInput);
			 Xsheet=XworkBook.getSheet(XLsheetName);
			 Xrow=Xsheet.getRow(Rows);
			 
			 Xcell= Xrow.createCell(cells);
			 Xcell.setCellValue(data);
			 fOutput=new FileOutputStream(XLfileName);
			 XworkBook.write(fOutput);
			 XworkBook.close();
			 fInput.close();
			 fOutput.close();
		}
		
		 public void fillGreenColor(String XLfileName, String XLsheetName, int Rows, int cell) throws Throwable {
			    try (FileInputStream fInput = new FileInputStream(XLfileName);
			         XSSFWorkbook XworkBook = new XSSFWorkbook(fInput)) {
	
			        XSSFSheet Xsheet = XworkBook.getSheet(XLsheetName);
			        XSSFRow Xrow = Xsheet.getRow(Rows);
			        XSSFCell Xcell = Xrow.getCell(cell);
	
			        XSSFCellStyle Xstyle = XworkBook.createCellStyle();
			        Xstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			        Xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
			        Xcell.setCellStyle(Xstyle);
	
			        try (FileOutputStream fOutput = new FileOutputStream(XLfileName)) {
			            XworkBook.write(fOutput);
			        }
			    }
			}
			
		 public void fillRedColor(String XLfileName, String XLsheetName, int Rows, int cell) throws Throwable {
			    try (FileInputStream fInput = new FileInputStream(XLfileName);
			         XSSFWorkbook XworkBook = new XSSFWorkbook(fInput)) {
	
			        XSSFSheet Xsheet = XworkBook.getSheet(XLsheetName);
			        XSSFRow Xrow = Xsheet.getRow(Rows);
			        XSSFCell Xcell = Xrow.getCell(cell);
	
			        XSSFCellStyle Xstyle = XworkBook.createCellStyle();
			        Xstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			        Xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
			        Xcell.setCellStyle(Xstyle);
	
			        try (FileOutputStream fOutput = new FileOutputStream(XLfileName)) {
			            XworkBook.write(fOutput);
			        }
			    }
			}
		 


}
