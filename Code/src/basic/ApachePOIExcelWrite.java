package basic;

/**
 * Important Jars are : 
 * poi-3.16.jar
 * poi-ooxml-3.16.jar
 * poi-ooxml-schemas-3.16.jar
 * dom4j.jar
 * xmlbeans-2.6.0.jar
 * commons-collections4-4.1.jar
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;

public class ApachePOIExcelWrite {

	private static final String FILE_NAME = "C:\\Users\\rishu.goenka\\Desktop\\MyFirstExcel.xlsx";

	public static void main(String[] args) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
			Object[][] datatypes = { { "Datatype", "Type", "Size(in bytes)" }, { "int", "Primitive", 2 },
					{ "float", "Primitive", 4 }, { "double", "Primitive", 8 }, { "char", "Primitive", 1 },
					{ "String", "Non-Primitive", "No fixed size" } };

			int rowNum = 0;
			System.out.println("Creating excel");
			for (Object[] datatype : datatypes) {
				Row row = sheet.createRow(rowNum++);
				int colNum = 0;
				for (Object field : datatype) {
					Cell cell = row.createCell(colNum++);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}
			}
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
