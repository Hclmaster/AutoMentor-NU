package com.nu.automentor.myTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionTest {
    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<String> list2 = new ArrayList<>();
        list2.add("e");
        list2.add("f");
        list2.add("g");
        list2.add("h");

        List<String> ans = merge(list, list2);
        System.out.println("ans => " + ans);
    }

    // Generic function to join two lists in Java
    public static<T> List<T> merge(List<T> list1, List<T> list2)
    {
        return Stream.of(list1, list2)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }
}
