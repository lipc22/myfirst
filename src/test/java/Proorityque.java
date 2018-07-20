

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-11**/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Proorityque{


    private static Comparator<Task> taskComparator =new Comparator<Task>() {
        public int compare(Task o1, Task o2) {
            if(o1.priority>o2.priority){
                return -1;
            }else if(o1.priority<o2.priority){
                return 1;
            }
            return 0;
        }

    };
    public static void main(String[] args) {
        PriorityQueue<Task> queue = new PriorityQueue<Task>(11, taskComparator);
        queue.add(new Task(20, "写日记1"));
        queue.add(new Task(50, "写日记2"));
        queue.add(new Task(100, "写日记3"));
        queue.add(new Task(120, "写日记4"));
        Task task = queue.poll();
        while(task !=null){
            System.out.println("处理任务："+task.name+"   优先级："+task.priority);
            task =queue.poll();
        }
    }

}
 class Task{   //任务类
    int priority;
    String name;
    public Task(int priority,String name){
        this.priority=priority;
        this.name=name;
    }
}

