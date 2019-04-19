import java.util.ArrayList;

public class Main {

    public static void main(String... args) {
        try {
            if (args.length != 2) {
                System.out.print("Invalid number of arguments! \n");
                System.exit(1);
            }

            int studentsCount = Integer.parseInt(args[0]);
            int teachersCount = Integer.parseInt(args[1]);

            if ((studentsCount < 0) || (teachersCount < 1)) {
                System.out.print("Invalid arguments! \n");
                System.exit(1);
            }
            System.out.println(studentsCount + " " + teachersCount);

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
            System.out.print("Invalid expressions! \n");
            System.exit(1);
        }
    }
}
