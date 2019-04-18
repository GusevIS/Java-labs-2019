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
        System.out.println(Thread.currentThread().getName());
    }
}
