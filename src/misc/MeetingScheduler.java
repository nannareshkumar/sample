package misc;

/*
* https://www.careercup.com/question?id=5720778041458688
* */

import java.io.ObjectInputStream.GetField;
import java.util.*;

public class MeetingScheduler {

    /**
     * @param args
     *Design a meeting scheduler. One way is to use an array to represent each interval,
     *like every 15 mins. Although it provides O(1) look up, if interval is small,
     *it seems like we are wasting a lot of space. Any alternative approach that can save space?
     *If we keep a sorted array of meetings sorted by start time, look up will be O(logn),
     *but inserting the new meeting in the middle of the array will require shifting elements, which is O(n).
     */

    Set<Meeting> meetingShedularSet=new TreeSet<Meeting>();
    Map<String,Meeting> map=new HashMap<String,Meeting>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MeetingScheduler ms=new MeetingScheduler();
        ms.addMeeting(new Meeting(900, 1000));
        ms.addMeeting(new Meeting(1030, 1100));
        ms.addMeeting(new Meeting(1101, 1130));
        ms.addMeeting(new Meeting(1131, 1245));
        ms.addMeeting(new Meeting(1105, 1145));
        ms.addMeeting(new Meeting(1205, 1345));
        ms.addMeeting(new Meeting(830, 899));

        Meeting meeting=ms.getMeeting(900, 1000);
        if(meeting!=null) {
            System.out.println("Meeting is sheduled at : "+meeting.getStartTime());
        }  else {
            System.out.println("Meeting does not exist");
        }
    }

    public void addMeeting(Meeting meeting) {
        if(!meetingShedularSet.contains(meeting)) {
            meetingShedularSet.add(meeting);
            map.put(String.valueOf(meeting.getStartTime()+meeting.getEndTime()), meeting);
        }  else {
            System.out.println("Meeting with start time :"+meeting.getStartTime()+" and end time :"+meeting.getEndTime()+" is conflicting with other meeting");
        }
    }

    public Meeting getMeeting(int startTime,int endTime) {
        return map.get(String.valueOf(startTime+endTime));
    }

}


class Meeting implements Comparable<Meeting> {

    private Integer startTime;
    private Integer endTime;

    Meeting(int startTime,int endTime) {
        this.startTime=startTime;
        this.endTime=endTime;
    }
    public Integer getStartTime() {
        return startTime;
    }
    public Integer getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Meeting o) {

        if(o.getStartTime().compareTo(this.endTime)> 0) {
            return 1;
        } else if(o.getEndTime().compareTo(this.startTime)< 0) {
            return -1;
        } else {
            return 0;
        }
    }

}