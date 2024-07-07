class Solution {
    public int numWaterBottles(int numBottles, int numExchange) 
    {
        return (int)(numBottles + (numBottles - 1) / (numExchange - 1));
    }
}