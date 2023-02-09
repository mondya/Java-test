package Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private Integer age;
    private Long id;
    private String email;

    public static class Builder {
        private String name;
        private Integer age;
        private Long id;
        private String email;

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        id = builder.id;
        email = builder.email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
