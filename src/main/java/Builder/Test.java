package Builder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Person person = new Person.Builder().id(100L).name("小明").age(22).build();
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        NutritionFacts nutritionFacts = new NutritionFacts.Builder().servingSize(100).servings(1).carbohydrate(9).personList(personList).build();
        System.out.println(nutritionFacts);
        String email = nutritionFacts.getPersonList().get(0).getEmail();
        if (StringUtils.isEmpty(email)){
            System.out.println("hello");
        }
        String s = JSON.toJSONString(nutritionFacts,SerializerFeature.WriteMapNullValue);
        String s1 = JSON.toJSONString(nutritionFacts, SerializerFeature.WriteNullStringAsEmpty);
        String s2 = JSON.toJSONString(nutritionFacts, SerializerFeature.WriteNonStringValueAsString);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }
}
