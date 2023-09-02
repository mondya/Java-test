package lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class LambdaDemo01 {
    public static void main(String[] args) {
        // 基本写法
        int num1 = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        
        // 进阶写法
        int num2 = calculateNum((int left, int right) -> {
             return left + right;
        });
        // 或者
        int num3 = calculateNum((int left, int right) -> left + right);

        
        // 最终写法
        int num4 = calculateNum(Integer::sum);
        
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value%2 == 0;
            }
        });
        
        // 泛型，根据返回类型
        Integer conver2Integer1 = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });

        String s1 = typeConver( s -> s + "a");

        printNum2(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value > 0;
            }
        }, new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value < 10;
            }
        });
    }
    
    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(10, 20);
    }
    
    public static void printNum(IntPredicate predicate) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    public static void printNum2(IntPredicate predicate, IntPredicate predicate2) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        for (int i : arr) {
            if (predicate.and(predicate2).test(i)) {
                System.out.println(i);
            }
        }
    }
    
    // 泛型
    public static <R> R typeConver(Function<String, R> function) {
        String str = "1234";
        R result = function.apply(str);
        return result;
    }
}
