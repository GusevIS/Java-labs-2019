public class Lab2
{
    private Graphs graph;
    public Lab2(Graphs graph)
    {
        this.graph = graph;
    }

    public class ClassA implements InterfaceI1
    {
        public void a()
        {
            graph.textArea2.append("ClassA method a \n");
        }

        public void i1()
        {
            graph.textArea2.append("InterfaceI1 method i1 \n");
        }
    }

    public class ClassB extends ClassA implements InterfaceI2
    {
        public void b()
        {
            graph.textArea2.append("ClassB method b \n");

        }

        public void i2()
        {
            graph.textArea2.append("InterfaceI2 method i2 \n");
        }
    }

    public interface InterfaceI1
    {
        void i1();
    }

    public interface InterfaceI2 extends InterfaceI1
    {
        void i2();
    }


    public void startLab2(String ... argc)
    {
        ClassB testB = new ClassB();

        testB.b();
        testB.a();
        testB.i2();
        testB.i1();

        InterfaceI1 testI1 = testB;
        testI1.i1();
        ClassB testI = (ClassB) testI1;

        testI.a();
        testI.b();
        testI.i2();
    }
}
