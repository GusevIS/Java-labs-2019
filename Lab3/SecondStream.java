public class SecondStream extends Thread
{
    private Stock stock;
    private int parameter;

    SecondStream(String name, Stock newStock, int parameter)
    {
        super(name);
        this.stock = newStock;
        this.parameter = parameter;
    }

    @Override
    public void run()
    {
        System.out.println(this.getName() + " start");
        while (parameter != 0)
        {
            synchronized (stock)
            {
                stock.add(10, parameter);
            }
            parameter--;
        }

    }
}
