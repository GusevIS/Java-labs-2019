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
        while (parameter != 0)
        {
            synchronized (stock)
            {
                stock.add(1000, parameter);
            }
            parameter--;
        }
    }
}
