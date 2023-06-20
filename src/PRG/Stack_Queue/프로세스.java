package PRG.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 0;
        Queue<Pairnum> que = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            que.add(new Pairnum(i, priorities[i]));
        }
        Pairnum start;
        Iterator it = null;
        boolean tag = true;
        while (!que.isEmpty()) {
            tag = true;
            start = que.poll();
            it = que.iterator();

            while (it.hasNext()) {
                if (start.b < ((Pairnum) it.next()).b) {
                    que.add(start);
                    tag = false;
                    break;
                }
            }
            if (tag) {
                cnt++;
                if (start.a == location) {
                    answer = cnt;
                    que.clear();
                }
            }
        }
        return answer;
    }
}
class Pairnum {
    int a;
    int b;
    Pairnum(int a, int b) {
        this.a = a;
        this.b = b;
    }
}