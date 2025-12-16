package com.roadmap;


import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class A026_Leet_000_Greedy_Activity_Selection_Problem {
    public static void main(String[] args) {

        Activity[] activities = {
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9),
                new Activity(5, 9)
        };

        // Sort activities by finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        int count = 0;
        int lastFinishTime = -1; // Initialize with a time before any activity starts

        for (Activity activity : activities) {
            if (activity.start >= lastFinishTime) {
                count++;
                lastFinishTime = activity.end;
                System.out.println("Selected Activity: [" + activity.start + ", " + activity.end + "]");
            }
        }
        System.out.println("Maximum number of activities: " + count);

    }

}