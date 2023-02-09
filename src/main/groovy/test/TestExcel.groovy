package test

import org.apache.commons.lang3.StringUtils
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class TestExcel {

    static void getExcel(XSSFWorkbook wb) {
        FileOutputStream fos = null;
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
        //groovy自动资源管理
        fos.close();
    }
    
    static void excel(){
        XSSFWorkbook workbook = new XSSFWorkbook()
        XSSFSheet sheet = workbook.createSheet("hello")
        XSSFRow row = sheet.createRow(0)
        XSSFCell cell = row.createCell(0)
    }

    static void main(String[] args) {
        String str = " "
//        str.replace()
        str = str.replaceAll("\\s*","")
        println StringUtils.isEmpty(str)
        println str
    }
}
