class Solution {
    public int maxArea(int[] height) {
        int maxarea=-1;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int width=right-left;
            int length= Math.min(height[left], height[right]);
            int area=width*length;
            maxarea =Math.max(maxarea,area);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;


    }
}