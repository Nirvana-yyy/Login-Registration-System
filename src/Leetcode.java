import org.junit.Test;

import java.util.*;

/**
 * @author YJL
 */
public class Leetcode {

    public List<List<Integer>> threeSum(int[] nums) {
        List list = new ArrayList();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        int i,left,right;
        for ( i = 0; i < nums.length-2; i++) {
            left = nums[i+1];
            right = nums[nums.length-1];
            while(left != right){
                if (left + right >-i){
                    right--;
                }else if (left+right <-i){
                    left++;
                }else{
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    break;
                }
            }
        }
        return null;
    }
    public int trap(int[] height) {
        int left, right;
        int leftMax, rightMax;
        int res = 0;
        left = 0;
        right = height.length-1;
        leftMax = 0;
        rightMax = 0;
        while (left != right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] > height[right]) {
                res += rightMax - height[right];
                right--;
            } else if (height[left] <= height[right]) {
                res += leftMax - height[left];
                left++;
            }
        }
        return res;
    }
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if (stack.empty()){
                    break;
                }
                int left = stack.peek();
                int width = i-left-1;
                int depth = Math.min(height[i],height[left]) - height[top];
                res += width * depth;
            }
            stack.add(i);
        }

        return res;
    }
}
