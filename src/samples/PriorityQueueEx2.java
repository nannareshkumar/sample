package test;

/**
 * Created by home on 3/4/2020.
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueEx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Student2> pq = new PriorityQueue<Student2>(12, new StudentComparator());

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("ENTER")) {
                String name = sc.next();
                double cgpa = sc.nextDouble();
                int token = sc.nextInt();

                pq.offer(new Student2(token, name, cgpa));
            } else if (command.equals("SERVED")) {
                pq.poll();
            }
        }

        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!pq.isEmpty()) {
                System.out.println(pq.poll().name);
            }
        }

        sc.close();
    }
}

class Student2 {
    int token;
    String name;
    double cgpa;

    Student2(int token, String name, double cgpa) {
        this.token = token;
        this.name = name;
        this.cgpa = cgpa;
    }
}

class StudentComparator implements Comparator<Student2> {

    // Overriding compare()method of Comparator  
    // for descending order of cgpa 
    public int compare(Student2 s1, Student2 s2) {
        if (s1.cgpa < s2.cgpa)
            return 1;
        else if (s1.cgpa > s2.cgpa)
            return -1;

        return 0;
    }
} 