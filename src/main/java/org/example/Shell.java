package org.example;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Shell {
    public static void main(String[] args) {
        //Integer[] a = {12, 15, 14, 13, 16, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i =100; i < 100000; i*=10){
            Double [] a = new Double[i];
            for (int j =0; j < a.length; j++) {
                a[j]=StdRandom.uniform();
            }
            sort(a);
        }

    }

    public static void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        int comparesCount = 0;
        StdOut.println("For array size of : "+N);
        while (h > 1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h; j -= h) {
                    comparesCount++;
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                }
            /* print the number of compares before changing value of h */
            double comparesRatio = (double) comparesCount / a.length;
            StdOut.println(" Here are the ratio of compares :" + comparesRatio + " For increment length: " + h);

            h = h / 3;
            /* reset the counter for the number of compares */
            comparesCount = 0;
        }

    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
}
