package xuefei.done.me.search;

/**
 * @description: 二分查找
 * @author: xuefei
 * @date: 2022/08/26 00:23
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {-1,0,3,5,9,12};

        System.out.println(binarySearch(arr,9));

    }

    public static boolean binarySearch(int[] arr,int target){
        if (arr == null){
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target){
                return true;
            }
            if (arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static int nearestIndex(int[] arr,int target){
        int index = -1;
        if (arr == null){
            return index;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target){
                index = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return index;
    }

}
