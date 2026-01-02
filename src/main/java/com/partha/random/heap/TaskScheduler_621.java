package com.partha.random.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TaskScheduler_621 {

    public static void main(String[] args) {
        TaskScheduler_621 s = new TaskScheduler_621();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        s.leastInterval(tasks, n);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char each : tasks){
            map.put(each, map.getOrDefault(each, 0)+1);
        }
        Task[] taskList = new Task[map.keySet().size()];
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        int index =0;
        for(Map.Entry<Character, Integer> each : entrySet){
            taskList[index] = new Task(String.valueOf(each.getKey()), each.getValue(), 0);
            index++;
        }

        int time = 0;
        PriorityQueue<Task> available = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        PriorityQueue<Task> coolingDown = new PriorityQueue<>((a,b) -> Integer.compare(a.timeReady, b.timeReady));

        for(Task each : taskList){
            available.add(each);
        }

        while(!available.isEmpty() || !coolingDown.isEmpty()){
            time++;
            while(!coolingDown.isEmpty() && coolingDown.peek().timeReady < time){
                available.add(coolingDown.poll());
            }
            Task current = null;
            if(!available.isEmpty()){
                current = available.poll();
                if(current.freq > 1){
                    current.freq = current.freq -1;
                    current.timeReady = time + n;
                    coolingDown.add(current);
                }
            }


        }
        return time;

    }
}

class Task{
    public String taskName;
    public int freq;
    public int timeReady;

    public Task(String taskName, int freq, int timeReady){
        this.taskName= taskName;
        this.freq = freq;
        this.timeReady = timeReady;
    }
}
