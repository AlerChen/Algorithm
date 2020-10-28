package d_TimeComplexity;

public class SelectionSort {

    private SelectionSort(){};
    
    /*
    选择排序: 每次遍历数组,找出当前最小的
    */
    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }


    private static <E> void swap(E[] arr,int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] arr = {2, 4, 1, 3, 6, 4, 2, 7};
        sort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
