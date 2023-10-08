package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

    }

    public static ArrayList<Integer[]> sortArrays(int n) {

        ArrayList<int[]> arrays = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int length = random.nextInt(1000);
            int[] nums = new int[length];
            for (int j = 0; j < length; j++) {
                nums[j] = random.nextInt(1000);
            }
            arrays.add(nums);
        }

        ArrayList<Integer[]> evenArrays = new ArrayList<>();
        ArrayList<Integer[]> oddArrays = new ArrayList<>();

        for (int i = 0; i < n; i = i + 2) {
            Integer[] boxedArray = IntStream.of(arrays.get(i))
                    .boxed()
                    .toArray(Integer[]::new);
            oddArrays.add(boxedArray);
        }

        for (int i = 1; i < n; i = i + 2) {
            Integer[] boxedArray = IntStream.of(arrays.get(i))
                    .boxed()
                    .toArray(Integer[]::new);
            evenArrays.add(boxedArray);
        }

        for (Integer[] element : evenArrays) {
            Arrays.sort(element);
        }

        ArrayList<Integer[]> sortedArrays = new ArrayList<>(evenArrays);

        for (Integer[] element : oddArrays) {
            Arrays.sort(element, Collections.reverseOrder());
        }

        sortedArrays.addAll(oddArrays);

        for (Integer[] s : sortedArrays) {
            System.out.println(Arrays.toString(s));
        }

        return sortedArrays;
    }
}