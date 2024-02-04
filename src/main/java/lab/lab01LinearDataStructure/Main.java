package lab.lab01LinearDataStructure;

import lab.lab01LinearDataStructure.implementations.ArrayList;
import interfaces.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("one");
        names.add("2");
        names.add("3");
        names.add("4");
        names.add("five");

        names.add(2, "almost two");
        names.add(2, "phone");
        names.add(2, "something");
        names.add(2, "hair");
        names.add(2, "nails");
        names.add(2, "eyes");

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names.get(2));
        System.out.println(names.get(3));
        System.out.println(names.get(4));
        System.out.println(names.get(5));
        System.out.println(names.get(6));
        System.out.println(names.get(7));
        System.out.println(names.get(8));
        System.out.println(names.get(9));
        System.out.println(names.get(10));
        System.out.println(names.get(11));
    }
}
