package com.mkyong.benchmark.bk;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ForEachTest {

    private final String[] DATA_FOR_TESTING_ARRAY = createArray();
    private final List<String> DATA_FOR_TESTING_LIST = Arrays.asList(createArray());

    public static void main(String[] argv) {

        ForEachTest obj = new ForEachTest();
        obj.forEachArray();
        obj.forEachList();
    }

    public void forEachArray() {
        System.out.println("\n--------- ForEachArray -------\n");
        long startTime = new Date().getTime();

        for (String i : DATA_FOR_TESTING_ARRAY) {
            String s = i + i;
            //System.out.println(s);
        }

        long endTime = new Date().getTime();
        long difference = endTime - startTime;
        System.out.println("ForEachArray - Elapsed time in milliseconds: " + difference);
    }

    public void forEachList() {
        System.out.println("\n--------- ForEachList -------\n");
        long startTime = new Date().getTime();

        for (String i : DATA_FOR_TESTING_LIST) {
            String s = i + i;
            //System.out.println(s);
        }

        long endTime = new Date().getTime();
        long difference = endTime - startTime;
        System.out.println("ForEachList - Elapsed time in milliseconds: " + difference);
    }


    private static String[] createArray() {
        int N = 10_000_000;

        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = "Array " + i;
        }
        return array;
    }

}