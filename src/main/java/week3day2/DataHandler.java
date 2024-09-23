package week3day2;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
public class DataHandler {
public static String[][] readDatafromExcel(String ExcelFileName){
	XSSFWorkbook workbook;
	String[][] data =null;
	try {
		workbook =new XSSFWorkbook("src/main/resources/data/"+ExcelFileName+".xlsx");
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		int colcount= sheet.getRow(0).getLastCellNum();
		data= new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
	
	
}
public static String[][] readDatafromCSV(String CSVFileName){
	CSVReader reader;
	String[][] data =null;
	List<String[]> rowrecords =null;
			try {
				reader =new CSVReaderBuilder(new FileReader("src/main/resources/data/"+CSVFileName+".csv")).withSkipLines(1).build();
				rowrecords = reader.readAll();
				data= new String[rowrecords.size()][rowrecords.get(0).length];
				for(int i=0;i<rowrecords.size();i++) {
					for(int j=0;j<rowrecords.get(0).length;j++) {
						data[i][j]=rowrecords.get(i)[j];
					}
				}
			}
			 catch (CsvException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
			}
			
		
}
