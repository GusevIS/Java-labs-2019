public class Lab3
{
    private Graphs graph;

    public Lab3(Graphs graph)
    {
        this.graph = graph;
    }

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
            graph.textArea3.append(Thread.currentThread().getName() + " start \n");
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
            graph.textArea3.append(this.getName() + " start \n");
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

    public class Stock
    {
        double count = 0;
        int countOfThreads = 0;

        synchronized void add(double num)
        {
            this.count += num;
            graph.textArea3.append("add " + num + " " + Thread.currentThread().getName() + "\n");
            graph.textArea3.append("current stock " + count + "\n");
        }
    }

    public void startLab3(String ... args)
    {
        try
        {
            if (args.length != 2)
            {
                graph.textArea3.append("Invalid number of arguments! \n");
                return;
            }

            int parameter1 = Integer.parseInt(args[0]);
            int parameter2 = Integer.parseInt(args[1]);

            if ((parameter1 < 0) || (parameter2 < 0))
            {
                graph.textArea3.append("Invalid argument! \n");
                return;
            }
            graph.textArea3.append(parameter1 + " " + parameter2 + "\n");

            Stock newStock = new Stock();
            Thread firstStream = new Thread(new FirstStream(newStock, parameter1));
            SecondStream secondStream = new SecondStream(newStock, parameter2);

            firstStream.start();
            secondStream.start();
        }
        catch (Exception e)
        {
            graph.textArea3.append("Invalid expression1! \n");
        }
    }


}
