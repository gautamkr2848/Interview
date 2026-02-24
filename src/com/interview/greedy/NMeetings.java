package com.interview.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NMeetings {

    static void maxMeetings(int start[], int end[]) {
        List<Meeting> meet = new ArrayList<>();

        for(int i = 0; i < start.length; i++)
            meet.add(new Meeting(start[i], end[i], i+1));

        Collections.sort(meet, (o1, o2) -> o1.end.compareTo(o2.end));

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for(int i = 1;i<start.length;i++) {
            if(meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] =   {2,4,5,7,9,9};
        maxMeetings(start,end);
    }
}

class Meeting {
    Integer start;
    Integer end;
    Integer pos;

    public Meeting(Integer start, Integer end, Integer pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
