class Solution {
     public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int rightmostSetBit = 1;
        while ((xor & rightmostSetBit) == 0) {
            rightmostSetBit <<= 1;
        }

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0)
                num1 ^= num;
            else 
                num2 ^= num;
        }

        return new int[]{num1, num2};
    }
}