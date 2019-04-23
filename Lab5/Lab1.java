import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

public class Lab1
{
    private Graphs graph;
    public Lab1(Graphs graph)
    {
        this.graph = graph;
    }
    public void startLab1(String args[])
    {
        try
        {
            if (args.length != 3) {
                this.graph.sendMessageToTextArea("Invalid number of arguments! \n");
                return;
            }
            double [] sides = new double[3];
            sides[0] = Double.parseDouble(args[0]);
            sides[1] = Double.parseDouble(args[1]);
            sides[2] = Double.parseDouble(args[2]);
            if ((sides[0] <= 0) || (sides[1] <= 0) || (sides[2] <= 0)){
                this.graph.sendMessageToTextArea("arguments must be positive! \n");
                return;
            }

            if (isNotTriangle(sides))
                this.graph.sendMessageToTextArea("These sides cannot be a triangle \n");
            else
                this.graph.sendMessageToTextArea("These sides can be a triangle \n");

        }
        catch (Exception e)
        {
            this.graph.sendMessageToTextArea("Invalid expression! \n");
        }
    }

    public static boolean isNotTriangle(double sides[])
    {
        return ((sides[0] >= sides[1] + sides[2]) || (sides[2] >= sides[1] + sides[0]) || (sides[1] >= sides[0] + sides[2]) );
    }
}