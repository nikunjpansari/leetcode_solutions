class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int time = 0;
        for(int i=0; i<tasks.size(); i++){
            int pTime = processorTime.get(i/4);
            int timeTaken = pTime + tasks.get(i);
            time = Math.max(timeTaken, time);
        }
        return time;
    }
}