class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int course = pre[0];
            int need = pre[1];
            list.get(need).add(course);
        }

        boolean[] recStack = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];

        for(int i=0;i<list.size();i++){
            if(!vis[i] && isCycle(list, i, recStack, vis)){
                return false;
            }
        }
        return true;
    }
    public boolean isCycle(List<List<Integer>> list, int node, boolean[] rec, boolean[] vis){
        if(rec[node]){
            return true;
        }
        if(vis[node]){
            return false;
        }
        rec[node] = true;
        vis[node] = true;
        for(int j=0;j<list.get(node).size();j++){
            if(isCycle(list, list.get(node).get(j),rec, vis)){
                return true;
            }
        }
        rec[node]=false;
        return false;
    }
}