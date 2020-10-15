package a_Merge;
import java.util.Arrays;

/**
* 归并排序
* */
public class MergeSort{

    /** Life Circle */
    private MergeSort(){};

    /** Public Method */

    public <E extends Comparable<E>> void sort(E[] arr, int l, int r){



    }

    /**
    * 合并两个有序区间: arr[l,mid], arr[mid+1,r]
    * */
    public <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){

        /* 归并排序需要辅助数组,无法原地完成 */
        E[] tempArr = Arrays.copyOfRange(arr,l,r+1);
        int i = l;
        int j = mid + 1;

        for (int k = l; k < r; k++) {
            if (i > mid){/* 左序列空 */
                arr[k] = tempArr[j - l];// -l偏移值, l不一定是从0开始
                j++;
            }else if (j > r){/* 右序列空 */
                arr[k] = tempArr[i - l];
                i++;
            }else if (arr[i].compareTo(arr[j]) <= 0){/* 左序列元素 < 右序列元素 */
                arr[k] = tempArr[i - l];
                i++;
            }else {/* 左序列元素 > 右序列元素 */
                arr[k] = tempArr[j - l];
                j++;
            }
        }
    }

}
