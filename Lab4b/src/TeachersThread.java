import java.util.Random;
import java.util.ArrayList;

public class TeachersThread extends Thread {
    private int index, nextIndex;
    private ArrayList<TeachersThread> teachers;
    private ArrayList<StudentsThread> students;
    private Random random = new Random();

    TeachersThread(ArrayList<TeachersThread> teachers, ArrayList<StudentsThread> students, int index)
    {
        super("Teacher" + (index + 1));
        this.teachers = teachers;
        this.students = students;
        this.index = index;
    }

    @Override
    public void run()
    {
        if (index + 1 < teachers.size())
            nextIndex = index + 1;
        else
            nextIndex = 0;
//
//        if (index != 0) {
//            synchronized (teachers.get(index)) {
//                try {
//                    teachers.get(index).wait();
//                } catch (InterruptedException e) {
//                }
//            }
//        }
        //
        while (true) {
            synchronized (teachers.get(index)) {
                try {
                    teachers.get(index).wait();
                } catch (InterruptedException e) { }
            }

            synchronized (students)
            {
                if (students.size() > 0) {
                    System.out.print(Thread.currentThread().getName() + "-");
                    int i = random.nextInt(students.size());
                    synchronized (students.get(i)) {
                        students.get(i).notify();
                        try {
                            students.get(i).join();
                        } catch (InterruptedException e) {
                        }
                        students.remove(i);
                    }
                }

                synchronized (teachers.get(nextIndex))
                {
                    teachers.get(nextIndex).notify();
                    if (students.size() <= 0) {
                        break;
                    }
                }
//
//                synchronized (teachers.get(index)) {
//                    try {
//                        teachers.get(index).wait();
//                    } catch (InterruptedException e) {
//                    }
//                }
//
            }
        }
    }
}
