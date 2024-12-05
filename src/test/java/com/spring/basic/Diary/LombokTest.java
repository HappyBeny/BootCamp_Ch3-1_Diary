package com.spring.basic.Diary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LombokTest {
    private String name;

    public static void main(String[] args) {
        LombokTest test = new LombokTest();
        test.setName("Hello Lombok");
        System.out.println(test.getName());
    }
}
