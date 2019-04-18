public class SecondStream extends Thread
{
    private Stock stock;
    private int parameter;

    SecondStream(Stock newStock, int parameter)
    {
        this.stock = newStock;
        this.parameter = parameter;
    }

    @Override
    public void run()
    {
        System.out.println(this.getName() + " start");
        stock.countOfThreads++;
        while (parameter != 0)
        {
            synchronized (stock) {
                stock.add(10);

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
