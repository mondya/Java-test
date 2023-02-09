package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xhh
 * @date 2021/12/22 13:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    
    private Integer id;
    
    private String userName;
    
    private Integer age;
    
    private String password;
    
    private String userCode;
    
    private Date dateCreated;
    
    private Date lastUpdated;
}
