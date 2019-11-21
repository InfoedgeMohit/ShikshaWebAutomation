package com.shiksha.resourses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static void readHamburgerExcel(String path) throws Exception {
		String sheetPath = path;
		try {
			FileInputStream inputStream = new FileInputStream(sheetPath);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			int rows = firstSheet.getLastRowNum();
			for (int i = 1; i < rows + 1; i++) {
				Row row = firstSheet.getRow(i);
				Variables.hamburgerSpcilization.put(getCellData(row, 0) + ","
						+ getCellData(row, 1) + "," + getCellData(row, 2),
						getCellData(row, 3));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	static void createNewExcel(String path) {
        FileOutputStream fout;
        try {
               fout = new FileOutputStream(path);
               XSSFWorkbook workbook = new XSSFWorkbook();
               workbook.write(fout);
               workbook.close();
               fout.close();
        } catch (FileNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        
        
 }

	static void setCellData(String path,String sheetname,int rownum,int cellnum,String data) {
        try {
        	path = new java.io.File(".").getCanonicalPath()
					+ "\\src\\test\\resources\\" + path + ".xlsx";
               FileInputStream fin;
               try {
                     fin = new FileInputStream(path);
               }catch(java.io.FileNotFoundException ex) {
                     createNewExcel(path);
                     fin = new FileInputStream(path);
               }
               XSSFWorkbook workbook = new XSSFWorkbook(fin);
               XSSFSheet sheet = workbook.getSheet(sheetname);
               if(sheet==null)
                     sheet = workbook.createSheet(sheetname);
               XSSFRow row =sheet.getRow(rownum);
               if(row==null)
                     row = sheet.createRow(rownum);
               XSSFCell cell = row.getCell(cellnum);
               if(cell==null)
                     cell = row.createCell(cellnum);
               
               cell.setCellValue(data);
               
               FileOutputStream fout = new FileOutputStream(path);
               
               workbook.write(fout);
               workbook.close();
               fout.close();
               
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        
        

 }

	public static int getColumn_Count(String path) {
		try { 
			String sheetPath = new java.io.File(".").getCanonicalPath()
					+ "\\src\\test\\resources\\" + path + ".xlsx";
			FileInputStream inputStream = new FileInputStream(sheetPath);
			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			//Row row = firstSheet.getRow(0);
			Row row=firstSheet.getRow(0);
			int i=0;
			
			@SuppressWarnings("unused")
			String x = "";
			do {
				
				//System.out.println(i);
				Cell c = row.getCell(i++);
				x= c.getStringCellValue();
			
			}while(row.getCell(i+1)!=null);
			return i;
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getColumn_Name(String path, int i) {

		try {
			String sheetPath = new java.io.File(".").getCanonicalPath()
					+ "\\src\\test\\resources\\" + path + ".xlsx";
			FileInputStream inputStream = new FileInputStream(sheetPath);

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);

			Row row = firstSheet.getRow(0);
			return row.getCell(i).getStringCellValue();

		} catch (Exception e) {
		}
		return null;
	}

	public static String getKey(int column, String path) {
		String sheetPath = path;
		String key = "";
		try {
			FileInputStream inputStream = new FileInputStream(sheetPath);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Row row = firstSheet.getRow(0);
			key = getCellData(row, column);
		} catch (Exception e) {
		}
		return key;
	}

	public static ArrayList<HashMap<String, String>> readData(String path)
			throws Exception {
		String sheetPath = new java.io.File(".").getCanonicalPath()
				+ "\\src\\test\\resources\\" + path + ".xlsx";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> excelData = new HashMap<String, String>();

		try {
			FileInputStream inputStream = new FileInputStream(sheetPath);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			int rows = firstSheet.getLastRowNum();
			for (int i = 1; i < rows + 1; i++) {
				Row row = firstSheet.getRow(i);
				int column = row.getLastCellNum();
				for (int j = 0; j < column + 1; j++) {
					String key = getKey(j, sheetPath);
					String value = getCellData(row, i);
					excelData.put(key, value);
				}
				list.add(excelData);
			}

		} catch (Exception e) {

		}

		return list;
	}

	public static String getData(int i, String Data, String path) {
		i = i + 1;
		String data = "";
		try {
			data = genericReadData(path, i, Data.trim());
		}

		catch (Exception e) {

		}

		return data;

	}

	public static String genericReadData(String path, int rownum,
			String columnName) throws Exception {
		String sheetPath = new java.io.File(".").getCanonicalPath()
				+ "\\src\\test\\resources\\" + path + ".xlsx";
		String value = "";
		try {
			FileInputStream inputStream = new FileInputStream(sheetPath);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			// int rows = firstSheet.getLastRowNum();
			Row row = firstSheet.getRow(rownum);
			int column = row.getLastCellNum();
			for (int j = 0; j < column + 1; j++) {
				String key = getKey(j, sheetPath);
				if (key.equalsIgnoreCase(columnName)) {
					value = getCellData(row, j);
					break;
				}

			}
		} catch (Exception e) {

		}

		return value;
	}

	public static int getRows(String path) throws Exception {
		String live = "live";
		String sheetPath = new java.io.File(".").getCanonicalPath()
				+ "\\src\\test\\resources\\" + path + ".xlsx";
		for (Entry<String, HashMap<String, String[]>> driverObject : Variables.driverExcelObject
				.entrySet()) {
			String className = driverObject.getKey();
			HashMap<String, String[]> testCase = Variables.driverExcelObject
					.get(className);
			for (Entry<String, String[]> tc : testCase.entrySet()) {
				String[] data = new String[7];
				data = tc.getValue();
				live = data[6];
				break;
			}
			break;
		}

		if (live.toLowerCase().contains("live")) {
			sheetPath = new java.io.File(".").getCanonicalPath()
					+ "\\src\\test\\resources\\Live" + path + ".xlsx";
		}
		int value = 0;
		try {
			FileInputStream inputStream = new FileInputStream(sheetPath);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			int rows = firstSheet.getLastRowNum();
			value = rows;
		} catch (Exception e) {

		}

		return value;
	}

	@SuppressWarnings("deprecation")
	public static String getCellData(Row row, int colNum) {
		String cellData = "";
		Cell cell = row.getCell(colNum);
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			cellData = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cellData = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			cellData = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			cellData = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			cellData = "";
		}
		return cellData;
	}

}
