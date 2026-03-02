class Solution {
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }

        int[] notFound = new int[2];
        notFound[0] = -1;
        notFound[1] = -1;

        return notFound;
    }
}
