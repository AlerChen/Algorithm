package com.company;

public class RunTimesTest {


    public static void main(String[] args) {

        int[] dataSize = {1000000,10000000};
        for (int num : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderArray(num);
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.search(data, num);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + num + " 100 runs : " + time + " s");
        }
        /*
            n = 1000000 100 runs : 0.196308374 s
            n = 10000000 100 runs : 1.522379307 s

            时间复杂度: O(n)
            随着数据量的增加, 执行时间与数据量的增加呈正比.
            1000000 -> 0.19
            10000000 -> 1.5

            1000000 * 10 -> 0.19 * 10 (约等于)

        * */
    }
}
