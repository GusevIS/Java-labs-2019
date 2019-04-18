public class Stock
{
    double count = 0;
    int countOfThreads = 0;

    synchronized void add(double num)
    {
        this.count += num;
        System.out.println("add " + num + " " + Thread.currentThread().getName());
        System.out.println("current stock " + count + "\n");
    }
}
