class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Character,Integer> freqMap = new HashMap();
        
        for(int idx = 0;idx<len;idx++){
            char ch = s.charAt(idx);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> maxHeap;
        maxHeap = new PriorityQueue<Character>((charA,charB)->        
                  Integer.compare(freqMap.get(charB),freqMap.get(charA)));
        
        for(char ch : freqMap.keySet()){
            maxHeap.add(ch);
        }
        
        StringBuilder ansStr = new StringBuilder();
        
        while(maxHeap.size()>0){
            char ch = maxHeap.remove();
            int freq = freqMap.get(ch);
            while(freq>0){
                ansStr.append(ch);
                freq--;
            }
        }
        
        return ansStr.toString();
    }
}