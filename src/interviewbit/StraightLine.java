package interviewbit;
import java.util.*;

public class StraightLine {

    public static void main(String args[]) {

        Point[] interval = new Point[]{
                new Point(-1,-1), new Point(1, 1), new Point(2, 2)
        };
        StraightLine s = new StraightLine();
        System.out.println("result : " + s.straightLine(interval));
    }

    public int straightLine(Point[] interval) {
        Map<Integer, Set<Point>> map = new HashMap();

        int max =0;
        for (int i = 0; i < interval.length; i++) {
            for (int j = 0; j < interval.length; j++) {
                if (i == j)
                    continue;
                Point a = interval[i];
                Point b = interval[j];
                int slope = Math.abs((b.x - a.x) / (b.y - a.y));
                Set<Point> set = map.get(slope);
                if (set == null) {
                    Set<Point> mis = new HashSet();
                    mis.add(a);
                    mis.add(b);
                    map.put(slope, mis);
                    max = mis.size();
                } else {
                    set.add(a);
                    set.add(b);
                    if(max < set.size())
                        max = set.size();
                }
            }
        }
        return max;
    }
}

  class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
