package com.xin.dfs;

/**
 * @author xinjiakun
 * @title: CanFinish
 * @projectName coding
 * @description: 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * 方法1 dfs深搜判断图中是否有环
 *
 * 方法2  统计课程安排图中每个节点的入度，生成 入度表 indegrees。
 * 借助一个队列 queue，将所有入度为 00 的节点入队。
 * 当 queue 非空时，依次将队首节点出队，在课程安排图中删除此节点 pre：
 * 并不是真正从邻接表中删除此节点 pre，而是将此节点对应所有邻接节点 cur 的入度 -1−1，即 indegrees[cur] -= 1。
 * 当入度 -1−1后邻接节点 cur 的入度为 00，说明 cur 所有的前驱节点已经被 “删除”，此时将 cur 入队。
 * 在每次 pre 出队时，执行 numCourses--；
 * 若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 00。
 * 因此，拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排。
 * @date 2019/11/10 16:20
 */
public class CanFinish_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || numCourses == 0) {//base case
            return true;
        }
        int help[] = new int[numCourses];//保存每个节点状态   未被访问 help[i]=0  被当前节点dfs访问 help[i]=1 被其他节点dfs访问 help[i]=-1
        for (int i = 0; i < numCourses; i++) {//对每一个节点进行dfs
            if (!helper(i, prerequisites, help)) {//成环直接返回false
                return false;
            }
        }
        return true;
    }
    //递归dfs
    private boolean helper(int x, int[][] prerequisites, int[] help) {
        if (help[x] == -1) {//已被其他dfs访问
            return true;
        } else if (help[x] == 1) {//已被当前dfs访问  成环
            return false;
        }
        for (int i = 0; i < prerequisites.length; i++) {//有子节点 则递归
            if (prerequisites[i][1] == x) {
                help[x] = 1;
                if (helper(prerequisites[i][0], prerequisites, help)) {//递归查找子节点
                    help[x] = -1;
                } else {
                    return false;
                }
            }
        }
        //无子节点
        help[x] = -1;
        return true;
    }

    public static void main(String[] args) {
        CanFinish_207 canFinish = new CanFinish_207();
        int[][] array = {{1, 0}};
        System.out.println(canFinish.canFinish(2, array));
    }
}
