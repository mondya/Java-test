package xhh;

/**
 * @author xhh
 * @date 2021/10/2 14:18
 */
//1.8接口可以使用static default方法体
public interface TestInterface {
    int get();
    default int getall(){
        return 1;
    }
    static int getById(){
        return 2;
    }
}
