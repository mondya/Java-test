package tryresources;

import org.apache.groovy.util.Maps;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class TestTryResources {
    //关闭流推荐使用try-with-resources
    public static void main(String[] args) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("test");
        /*
        try {
            outputStream = new FileOutputStream("d:/test.xlsx");
            xssfWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null)
            outputStream.close();
        }
         */
        try (OutputStream outputStream = new FileOutputStream("d:/tryResources")) {
            xssfWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
