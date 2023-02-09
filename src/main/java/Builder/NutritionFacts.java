package Builder;

import org.apache.poi.common.usermodel.LineStyle;

import java.io.Serializable;
import java.util.List;

public class NutritionFacts implements Serializable {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;
    private List<Person> personList;
    private String suer;

    static class Builder {
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;
        private List<Person> personList;
        private String suer;

        public Builder servingSize(int val) {
            servingSize = val;
            return this;
        }

        public Builder servings(int val) {
            servings = val;
            return this;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder personList(List<Person> persons) {
            personList = persons;
            return this;
        }

        public Builder suer(String val) {
            suer = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
        personList = builder.personList;
        suer = builder.suer;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                ", personList=" + personList +
                ", suer=" + suer +
                '}';
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public String getSuer() {
        return suer;
    }
}
