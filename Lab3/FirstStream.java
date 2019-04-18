public class FirstStream implements Runnable
{
    private Stock stock;
    private int parameter;

    FirstStream(Stock newStock, int parameter)
    {
        this.stock = newStock;
        this.parameter = parameter;
    }

    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " start");
        stock.countOfThreads++;
        while (parameter != 0)
        {
            synchronized (stock) {
                stock.add(1000);

                parameter--;
                stock.notify();

                    try {
                        if ((parameter > 0) && (stock.countOfThreads != 1))
                            stock.wait();
                    } catch (InterruptedException e) { }

            }
        }
        stock.countOfThreads--;
    }
}
