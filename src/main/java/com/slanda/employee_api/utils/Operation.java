package com.slanda.employee_api.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Operation {
    enum OrderEnum {
        ASC,
        DESC
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,5,7,2,5,8,9,4,6);


        System.out.println("===========================");
        System.out.println("ASC");
        list(numbers, OrderEnum.ASC);

        System.out.println("===========================");
        System.out.println("DESC");
        list(numbers, OrderEnum.DESC);
    }

    public static void list(List<Integer> numbers, OrderEnum order) {
        switch ( order ) {
            case DESC ->  numbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            case ASC -> numbers = numbers.stream().sorted().collect(Collectors.toList());
        }

        numbers.forEach(System.out::println);
    }
}