package com.abc.magento;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation {

	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static ChromeDriver driver;
	public static String getCellValues(int rownum, int cellnum) {
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String data = cell.getStringCellValue();
		return data;
	}

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\Selenium_workspace\\HybridExcelApp\\src\\com\\abc\\utilities\\Hybrid.xlsx");
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet("magento");
		int numOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(numOfRows);

		for (int i = 1; i < numOfRows; i++) {
			String action = getCellValues(i, 2);

			switch (action) {
			case "open":
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				break;
			case "navigate":
				driver.get(getCellValues(i, 4));
				break;
			case "click":
					driver.findElement(By.xpath(getCellValues(i, 3))).click();
				break;
			case "type":
					driver.findElement(By.xpath(getCellValues(i, 3))).sendKeys(getCellValues(i, 4));
				break;
				
			case "quit":
				driver.quit();
			default:
				break;
			}
		}
	}

}
