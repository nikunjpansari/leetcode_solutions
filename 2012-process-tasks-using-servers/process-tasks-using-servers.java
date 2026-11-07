class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m  = tasks.length;
        int[] ans = new int[m];


        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
            (a, b)-> {
                if(a[0]!=b[0]){
                    return Integer.compare(a[0],b[0]);
                }
                return Integer.compare(a[1],b[1]);
            }
        );
        PriorityQueue<long[]> busyServers= new PriorityQueue<>(
            (a,b)->{
                if(a[0]!= b[0]){
                    return Long.compare(a[0],b[0]);
                }
                if(a[1] != b[1]){
                    return Long.compare(a[1],b[1]);
                }
                return Long.compare(a[2],b[2]);
            }
        );
        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        long currentTime = 0;

        for(int i =0;i<m;i++){

            currentTime = Math.max(currentTime, i);

            while (!busyServers.isEmpty()
                    && busyServers.peek()[0] <= currentTime) {

                long[] server = busyServers.poll();

                int weight = (int) server[1];
                int serverIndex = (int) server[2];

                freeServers.offer(new int[]{weight, serverIndex});
            }

            if(freeServers.isEmpty()){
                currentTime = busyServers.peek()[0];

                while (!busyServers.isEmpty()
                    && busyServers.peek()[0] <= currentTime) {

                long[] server = busyServers.poll();

                int weight = (int) server[1];
                int serverIndex = (int) server[2];

                freeServers.offer(new int[]{weight, serverIndex});
            }
            }
            int[] selectedServer = freeServers.poll();
            long finishTime = currentTime + tasks[i];
            int weight = selectedServer[0];
            int index = selectedServer[1];

            ans[i] = index;

            busyServers.offer(new long[]{
                finishTime, weight , index
            });
            }
               return  ans;
        }
     
    }