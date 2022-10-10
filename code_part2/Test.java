public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Address a1 = new Address("Queen", 48, "KINPIN2");
        Address a2 = new Address("KINGEDWARD", 800, "KIN6N5");
        // Array of type address that has length of 5
        Address[] add = new Address[5];
        add[0] = a1;
        add[1] = a2;

        Employee e1 = new Employee("Faleao", 40, 15.50, add);

        System.out.println(e1.toString());

    }

}