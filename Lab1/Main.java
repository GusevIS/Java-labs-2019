public class Main
{
    public static void main(String args[])
    {
        try
        {
            if (args.length != 3) {
                System.out.print("Invalid number of arguments! \n");
                System.exit(0);
            }
            double [] sides = new double[3];
            sides[0] = Double.parseDouble(args[0]);
            sides[1] = Double.parseDouble(args[1]);
            sides[2] = Double.parseDouble(args[2]);

            if (isNotTriangle(sides))
                System.out.println("These sides cannot be a triangle");
            else
                System.out.println("These sides can be a triangle");

        }
        catch (Exception e)
        {
            System.out.print("Invalid expression1! \n");
        }
    }

    public static boolean isNotTriangle(double sides[])
    {
        return ((sides[0] >= sides[1] + sides[2]) || (sides[2] >= sides[1] + sides[0]) || (sides[1] >= sides[0] + sides[2]) );
    }
}
