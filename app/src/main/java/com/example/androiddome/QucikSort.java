package com.example.androiddome;

import java.util.Arrays;

public class QucikSort {


    private static void sort(int[] data, int first, int last) {
        if (first >= last) {
            return;
        }
        int i = first;
        int j = last;
        int index = data[first];//获取基准数

        while (i < j) {
            while (i < j && data[j] >= index)
                j--;
            while (i < j && data[i] <= index) {
                i++;
            }
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
        data[first] = data[i];
        data[i] = index;
        sort(data, first, i - 1);
        sort(data, i + 1, last);
    }


    public static void main(String[] args) {
        int[] data = {5, 7, 9, 6, 7,7,7,712, 1,12,85,55,45,25,755,45,61,36, 10, 11, 14, 16, 17, 20, 33, 55, 13};
        sort(data, 0, data.length - 1);
        System.out.printf(Arrays.toString(data));
    }


}
