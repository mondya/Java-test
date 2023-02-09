package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.ExcelUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TestExcel {
    public static void main(String[] args) throws IOException {
        getExcel();
    }

    static void getExcel(XSSFWorkbook wb) {
        FileOutputStream fos = null;
        try {
            Sheet sheet = wb.createSheet("sheetName");
            Row row = sheet.createRow(0); //第一行
            Cell cell = row.createCell(2);//第一个单元格
            cell.setCellValue("企业名称");//单元格赋值
            Cell cell2 = row.createCell(3);
            BigDecimal bigDecimal = new BigDecimal("1");
            cell2.setCellValue(String.valueOf(bigDecimal));
            CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 1, 2, 2);
            sheet.addMergedRegion(cellRangeAddress);
            CellRangeAddress c2 = new CellRangeAddress(0, 0, 3, 5);
            sheet.addMergedRegion(c2);
            fos = new FileOutputStream("d:/workbook.xlsx");
            wb.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //测试ExcelUtils
    static void getExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = "学生表";
        Map<Integer, Object> titleMap = new HashMap<>();
        titleMap.put(0, "姓名");
        titleMap.put(1, "班级");
        titleMap.put(2, "学号");
        titleMap.put(3, "年级");
        titleMap.put(4, "学校");
        titleMap.put(5, "学校");
        titleMap.put(6, "学校");
        titleMap.put(7, "学校");
        titleMap.put(8, "学校");
        titleMap.put(9, "学校");
        titleMap.put(10, "学校");
        titleMap.put(11, "学校");
        titleMap.put(12, "学校");
        titleMap.put(13, "学校");
        titleMap.put(14,"学校");
        titleMap.put(15, "学校");
        titleMap.put(16, "学校");
        titleMap.put(17, "学校");
        titleMap.put(18, "学校");
        titleMap.put(19, "学校");
        titleMap.put(20, "学校");
        titleMap.put(21, "学校");
        titleMap.put(22, "学校");
        XSSFWorkbook xssfWorkbook = ExcelUtils.buildExcelTitle(workbook, titleMap, sheetName);
        try (OutputStream fileOutputStream = new FileOutputStream("d:/报告.xlsx")) {
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
