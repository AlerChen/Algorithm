package a_BinarySearchBase;

public class BinarySearch_upper {

    public static void main(String[] args) {

        upper();

    }

    public static void upper(){
        int[] arr = {1,1,3,3,5,5};
        for (int i = 0; i < arr.length; i++) {
            int res = upper(arr,i);
            System.out.printf(res + " ");
        }
        /**
         0 2 2 4 4 6
         */
    }

    /** 查找比目标值大的最小值 */
    public static int upper(int[] arr, int target){
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            }else  {
                r = mid;
            }
        }
        return l;
    }
}
