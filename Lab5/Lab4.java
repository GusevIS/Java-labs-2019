import java.util.Random;
import java.util.ArrayList;

public class Lab4 {
    private Graphs graph;

    public Lab4(Graphs graph)
    {
        this.graph = graph;
    }

    public class StudentsThread extends Thread {
        StudentsThread(int number)
        {
            super("Student" + (number + 1));
        }

        @Override
        public void run()
        {
            synchronized (this)
            {
                try
                {
                    this.wait();
                }
                catch(InterruptedException e) { }
            }
            graph.textArea4.append(Thread.currentThread().getName() + "\n");
        }
    }

    public class TeachersThread extends Thread {
        private int index, nextIndex;
        private boolean isFirst = false;
        private ArrayList<TeachersThread> teachers;
        private ArrayList<StudentsThread> students;
        private Random random = new Random();

        TeachersThread(ArrayList<TeachersThread> teachers, ArrayList<StudentsThread> students, int index)
        {
            super("Teacher" + (index + 1));
            this.teachers = teachers;
            this.students = students;
            this.index = index;
            if (index == 0)
            {
                isFirst = true;
            }
        }

        @Override
        public void run()
        {
            if (index + 1 < teachers.size())
                nextIndex = index + 1;
            else
                nextIndex = 0;

            while (true) {

                if (!isFirst)
                {
                    synchronized (teachers.get(index)) {
                        try {
                            teachers.get(index).wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
                else if (teachers.size() != 1)
                    isFirst = false;

                synchronized (students)
                {
                    if (students.size() > 0) {
                        graph.textArea4.append(Thread.currentThread().getName() + "-");
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

                }
            }
        }
    }

    public void startLab4(String... args) {
        try {
            if (args.length != 2) {
                graph.textArea4.append("Invalid number of arguments! \n");
                return;
            }

            int studentsCount = Integer.parseInt(args[0]);
            int teachersCount = Integer.parseInt(args[1]);

            if ((studentsCount < 0) || (teachersCount < 1)) {
                graph.textArea4.append("Invalid arguments! \n");
                return;
            }
            graph.textArea4.append(studentsCount + " " + teachersCount + "\n");

            ArrayList<StudentsThread> students = new ArrayList<>();
            for (int i = 0; i < studentsCount; i++)
            {
                students.add(new StudentsThread(i));
                students.get(i).start();
            }

            ArrayList<TeachersThread> teachers = new ArrayList<>();
            for (int i = 0; i < teachersCount; i++)
            {
                teachers.add(new TeachersThread(teachers, students, i));
            }

            for (int i = teachersCount; i > 0; i--)
            {
                teachers.get(i - 1).start();
            }

        } catch (Exception e) {
            graph.textArea4.append("Invalid expressions! \n");
            return;
        }
    }
}
