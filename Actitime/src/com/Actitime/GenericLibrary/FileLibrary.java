package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


	public class FileLibrary {
		/**
		 * this method is a generic method which is used to read the data from Property File.
		 * @param key
		 * @return
		 * @throws IOException
		 */
		public String readDataFromProprtyFile(String key) throws IOException {
			FileInputStream fis =new FileInputStream("./TestData/commondata.property");
			Properties p=new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
			}
		    /**
		     * this method is a genric method which is used to read data from Excel sheet
		     * @param sheetname
		     * @param row
		     * @param cell
		     * @return
		     * @throws EncryptedDocumentException
		     * @throws IOException
		     */
			public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("./Testdata/TestData1.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			return data;
			}
	}


