//Time Complexity: O(V + E)
//Space Complexity: O(V + E)
//Did this code run in leetcode: Yes

//Approach:
// 1. Build indegree[] and adjacency list; push all nodes with indegree 0 into a queue;
// 2. Pop and decrement indegrees of neighbors; enqueue neighbors that reach 0;
// 3. If processed count equals numCourses, return true (no cycle), else false.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pr : prerequisites){
            //pr[0] - dependent, pr[1] - independent

            indegrees[pr[0]]++;
            if(!map.containsKey(pr[1])){
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> dependencies = map.get(curr);

            if(dependencies != null){
                for(int dependent : dependencies){
                    indegrees[dependent]--;
                    if(indegrees[dependent] == 0){
                        q.add(dependent);
                        count++;
                    }
                }
            }
        }
        if(count == numCourses) return true;
        return false;
    }
}
