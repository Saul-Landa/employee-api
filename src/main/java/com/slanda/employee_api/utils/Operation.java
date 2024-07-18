package com.slanda.employee_api.utils;

import java.util.*;
import java.util.stream.Collectors;

public class Operation {

    public enum OrderEnum {
        ASC {
            @Override
            public Comparator<Integer> getComparator() {
                return Comparator.naturalOrder();
            }
        },
        DESC {
            @Override
            public Comparator<Integer> getComparator() {
                return Comparator.reverseOrder();
            }
        };

        public abstract Comparator<Integer> getComparator();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Ingrese una lista de números enteros (ingrese 'q' para terminar):");
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        System.out.println("===========================");
        System.out.println("ASC");
        list(numbers, OrderEnum.ASC);

        System.out.println("===========================");
        System.out.println("DESC");
        list(numbers, OrderEnum.DESC);
    }

    public static void list(List<Integer> numbers, OrderEnum order) {
        String numbersOrdered = numbers.stream()
                .sorted(order.getComparator())
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println(numbersOrdered);
    }
}