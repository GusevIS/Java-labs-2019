public class Main
{
    public static void main(String ... argc)
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
