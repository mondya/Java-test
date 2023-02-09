package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortTest {
    private Long id;
    private Integer idx;
    private Boolean top;
    private String name;
}
