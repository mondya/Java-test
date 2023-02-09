package xhh;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import test.DayVO;

import java.util.*;

public class TestString2 {
    public static void main(String[] args) {
        Table<String, String, String> employeeTable = HashBasedTable.create();
        employeeTable.put("IBM", "101", "Mahesh");
        employeeTable.put("IBM", "102", "Ramesh");
        employeeTable.put("IBM", "103", "Suresh");

        employeeTable.put("Microsoft", "101", "Sohan");
        employeeTable.put("Microsoft", "101", "THE");
        employeeTable.put("Microsoft", "112", "Mohan");
        employeeTable.put("Microsoft", "113", "Rohan");

        employeeTable.put("TCS", "101", "Ram");
        employeeTable.put("TCS", "122", "Shyam");
        employeeTable.put("TCS", "123", "Sunil");

        Map<String, String> ibm = employeeTable.row("IBM");
        String microsoft = employeeTable.get("Microsoft", "101");
        System.out.println("microsoft:"+ microsoft);
        ibm.forEach((k, v) -> {
            System.out.println("Emp id: " + k + ", Name: " + v);
        });
        
        Map<String, String> column = employeeTable.column("101");
        for (Map.Entry<String, String> co : column.entrySet()) {
            System.out.println(" id: " + co.getKey() + ", Name: " + co.getValue());
        }

        Collection<String> values = employeeTable.values();
        values.forEach(System.out::println);
        Multimap<String, List<DayVO>> multimap = HashMultimap.create();
        List<DayVO> dayVOS = new ArrayList<>();
        dayVOS.add(new DayVO(1L,1L));
        multimap.put("1",dayVOS);
    }
}
