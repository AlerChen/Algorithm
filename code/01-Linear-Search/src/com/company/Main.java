package com.company;

public class Main {

    private String name;

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world");

        System.out.println("-----------");

        SimpleLineSearch simpleLineSearch = new SimpleLineSearch();
        int[] dataArr = {1,4,5,3,2,6,8};
        int target = 9;
        int result = simpleLineSearch.searchNumInArray(dataArr,target);
        System.out.println("result is " + result);

        System.out.println("-----------");

        /* 静态方法 */
        int result2 = LinearSearch.search(dataArr,8);
        System.out.println("static method result is " + result2);

        System.out.println("-----------");

        Integer[] dataArray = {1,3,5,6,7,8};

        /* 范型 */
        int result3 = LinearSearch.search(dataArray,5);
        System.out.println("<E> method result is " + result3);

        System.out.println("------------");

        /* 不同类的equals方法实现 */
        Student[] students = {new Student("ABC"),
                            new Student("BBB"),
                            new Student("EEE")};

        Student bbb = new Student("bbb");
        int result4 = LinearSearch.search(students,bbb);
        System.out.println("student index is " + result4);
        System.out.println("------------");
        System.out.println("------------");



    }

}
