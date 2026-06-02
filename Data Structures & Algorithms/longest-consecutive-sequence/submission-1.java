class Solution {
    public int longestConsecutive(int[] nums) {
        // create lookup map
        HashMap<Integer, Boolean> hmap = new HashMap<>();
        for (int i: nums) hmap.put(i, true);

        Deque<Integer> seqStart = new ArrayDeque<>();
        // if prev element not present add to queue
        for (int i: nums) {
            if (!hmap.getOrDefault(i-1, false)) {
                seqStart.offer(i);
            }
        }

        int longSeq = 0;
        int localCnt = 0;
        while (!seqStart.isEmpty()){
            int ele = seqStart.poll();
            localCnt = 1;
            while (hmap.getOrDefault(ele+1, false)){
                ele++;
                localCnt++;
            }
            longSeq = Math.max(longSeq, localCnt);
        }

        return longSeq;
    }
}
