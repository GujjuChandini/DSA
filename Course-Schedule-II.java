class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<list.size();i++){
            if(!vis[i] && isCycle(list, i, recStack, vis, st)){
                return new int[0];
            }
        }
        int[] res = new int[st.size()];
        for(int i=0;i<res.length;i++){
            res[i]=st.pop();
        }
        return res;
    }
    public boolean isCycle(List<List<Integer>> list, int node, boolean[] rec, boolean[] vis, Stack<Integer> st){
        if(rec[node]){
            return true;
        }
        if(vis[node]){
            return false;
        }
        rec[node] = true;
        vis[node] = true;
        for(int j=0;j<list.get(node).size();j++){
            if(isCycle(list, list.get(node).get(j),rec, vis, st)){
                return true;
            }
        }
        rec[node]=false;
        st.push(node);
        return false;
    }
}