package Generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	public String togetDataFromExcel(String Sheetname,int rownum,int celnum) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./TestData/TestScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(Sheetname).getRow(rownum).getCell(celnum).getStringCellValue();
		wb.close();
		return data;
		
	}	
		
	public int togetRowCount(String Sheetname) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./TestData/TestScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		  int rowcount = wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rowcount;
		
	}	
		
	public void setDataToExcel(String Sheetname,int rownum,int celnum) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./TestData/TestScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(Sheetname).getRow(rownum).getCell(celnum);
		FileOutputStream fis1=new FileOutputStream("./TestData/TestScriptdata.xlsx");
		wb.write(fis1);
		wb.close();
		
	}	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
