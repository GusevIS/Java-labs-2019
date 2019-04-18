public class Main
{
    public static void main(String ... args)
    {
        try
        {
            if (args.length != 2)
            {
                System.out.print("Invalid number of arguments! \n");
                System.exit(0);
            }

            int parameter1 = Integer.parseInt(args[0]);
            int parameter2 = Integer.parseInt(args[1]);

            if ((parameter1 < 0) || (parameter2 < 0))
            {
                System.out.print("Invalid argument! \n");
                System.exit(0);
            }
            System.out.println(parameter1 + " " + parameter2);

            Stock newStock = new Stock();
            Thread firstStream = new Thread(new FirstStream(newStock, parameter1));
            SecondStream secondStream = new SecondStream(newStock, parameter2);

            firstStream.start();
            secondStream.start();
        }
        catch (Exception e)
        {
            System.out.print("Invalid expression1! \n");
        }
    }
}

