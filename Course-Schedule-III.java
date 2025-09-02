class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int total = 0;
        for(int[] course : courses){
            int lastday = course[1];
            int duration = course[0];

            total+=duration;
            pq.offer(duration);

            if(total>lastday){
                total-=pq.poll();
            }
        }
        return pq.size();
    }
}