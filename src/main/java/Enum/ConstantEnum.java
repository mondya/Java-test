package Enum;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author xhh
 * @date 2021/12/21 10:01
 */
public class ConstantEnum {
    static enum UserTypeEnum{
        STUDENT( (byte)1,"ROLE_STUDENT"),
        TEACHER((byte)2 , "ROLE_TEACHER"),
        PARENT((byte)3,"ROLE_PARENT"),
        DOCTOR((byte)4,"ROLE_DOCTOR");
        public Byte type;
        public String name;

        UserTypeEnum(Byte type, String name) {
            this.type = type;
            this.name = name;
        }
        static UserTypeEnum getUserTypeEnum(Byte type){
            for (UserTypeEnum u: UserTypeEnum.values()) {
                if (u.type.equals(type)){
                    return u;
                }
            }
            return null;
        }
    }
}

class Test{
    public static void main(String[] args) {
        String name = Objects.requireNonNull(ConstantEnum.UserTypeEnum.getUserTypeEnum((byte)4)).name;
        System.out.println(name);
    }
}
