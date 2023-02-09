package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;
import java.util.Objects;

//Excel常见操作
public class ExcelUtils {
    //创建表头
    public static XSSFWorkbook buildExcelTitle(XSSFWorkbook xssfWorkbook, Map<Integer,Object> map, String sheetName){
        XSSFSheet sheet = xssfWorkbook.createSheet(sheetName);
//        for (Map.Entry<Integer,Object> obj : map.entrySet()){
//            obj.getKey();
//        }
        XSSFRow row = sheet.createRow(0);
        map.forEach((k,v) ->{
            createCell(row,k,v);
        });
        //createFreezePane
        /**
         * 第一个参数：代表要冻结的列数
         * 第二个参数：代表要冻结的行数
         * 第三个参数：表示右边区域可见的首列序号，锁定列之后才会有效果
         * 第四个参数：表示下边区域可见的首列序号，锁定行之后才会有效果
         */
        sheet.createFreezePane(1,1,30,20);
        return xssfWorkbook;
    }

    static void createCell(Row row,Integer column, Object value){
        if (column != null){
            Cell cell = row.createCell(column);
            cell.setCellValue(Objects.isNull(value) ? "" : value.toString());
        }
    }
}
