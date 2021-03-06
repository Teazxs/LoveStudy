package com.example.wangzhibo.lovestudy.arithmetic.array;

/**
 * Created by samwangzhibo on 2019-08-21.
 */
public class ArrayTest {
  public static void main(String[] args) {
    int[] nums = {13, 16, 17, 23, 53, 67, 7, 10, 12};
    findMinNum(nums);
    // 奇数在前 偶数在后
    qiFirstOuLast(nums);
  }

  private static void qiFirstOuLast(int[] nums) {
     int low=0, high=nums.length-1;
     int tempNum = nums[low];

     // 2.递进条件
    while (low < high){
      while (low < high && nums[high] % 2 == 0){
          high--;
      }

      while (low < high && nums[low] % 2 != 0){
        low++;
      }
    }
  }

  private static int findMinNum(int[] nums) {
    int low=0,high = nums.length -1, mid=(low/high) / 2;
    while(low < high - 1){
      if (nums[mid] > nums[low]){
        low = mid;
      }else if (nums[mid] < nums[high]){
        high = mid;
      }
    }
    return Math.min(nums[low], nums[high]);
  }
}
