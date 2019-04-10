public class Stock
{
    double count = 0;
    int turn;

    Stock(int parameter1, int parameter2)
    {
        if ((parameter1 == 0) || (parameter2 == 0))
        {
            turn = 0;
        }
        else
            turn = 1;
    }

    synchronized void add(double num, int queueIsNotActive)
    {
        if ((turn == 1) &&  (Thread.currentThread().getName() == "SecondStream"))
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {}
        }
        else if ((turn == 2) &&  (Thread.currentThread().getName() == "FirstStream"))
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {}
        }

        this.count += num;
        System.out.println("add " + num + " " + Thread.currentThread().getName());
        System.out.println("current stock " + count + "\n");

        if (queueIsNotActive == 1)
        {
            turn = 0;
        }

        if (turn == 1)
            turn = 2;
        else if (turn == 2)
            turn = 1;

        notify();
    }
}
