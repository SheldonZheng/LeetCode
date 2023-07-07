class Solution {
    public int findCrossingTime(int n,int k,int[][] time) {
        PriorityQueue<Integer> waitLeft = new PriorityQueue<>((x,y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        });

        PriorityQueue<Integer> waitRight = new PriorityQueue<>((x,y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        });


        PriorityQueue<int[]> workLeft = new PriorityQueue<int[]>((x,y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });

        PriorityQueue<int[]> workRight = new PriorityQueue<int[]>((x,y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });

        int remain = n,curTime = 0;
        for (int i = 0; i < k; i++) {
            waitLeft.offer(i);
        }

        while (remain > 0 || !workRight.isEmpty() || !waitRight.isEmpty()) {
            while (!workLeft.isEmpty() && workLeft.peek()[0] <= curTime) {
                waitLeft.offer(workLeft.poll()[1]);
            }

            while (!workRight.isEmpty() && workRight.peek()[0] <= curTime) {
                waitRight.offer(workRight.poll()[1]);
            }

            if (!waitRight.isEmpty()) {
                int id = waitRight.poll();
                curTime += time[id][2];
                workLeft.offer(new int[]{curTime + time[id][3],id});
            } else if (remain > 0 && !waitLeft.isEmpty()) {
                int id = waitLeft.poll();
                curTime += time[id][0];
                workRight.offer(new int[]{curTime + time[id][1],id});
                remain--;
            } else {
                int nextTime = Integer.MAX_VALUE;
                if (!workLeft.isEmpty()) {
                    nextTime = Math.min(nextTime,workLeft.peek()[0]);
                }
                if (!workRight.isEmpty()) {
                    nextTime = Math.min(nextTime,workRight.peek()[0]);
                }
                if (nextTime != Integer.MAX_VALUE) {
                    curTime = Math.max(nextTime,curTime);
                }
            }


        }
        return curTime;
    }
}
