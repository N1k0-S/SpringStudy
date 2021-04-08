package com.wcx.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class People {

    @Autowired
    private Cat cat;


    /**
     * @Qualifier(value = "dog222")
     * 在beans容器中如果存在多个属性的情况，自动装配将无法识别（通过名字或类型（有两个类型）都无法匹配到），使用以上注解来识别
     */
    @Autowired
    @Qualifier(value = "dog222")
    private Dog dog;

    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
