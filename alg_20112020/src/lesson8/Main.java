package lesson8;

import org.w3c.dom.Node;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>();

        chm.put(1, "one");
        chm.put(2, "two");
        chm.put(3, "three");
        chm.put(4, "four");
        chm.put(5, "five");
        chm.put(6, "six");
        chm.put(7, "seven");
        chm.put(8, "eight");


        System.out.println(chm);
        System.out.println("size = " + chm.size());
        System.out.println("------------------");
        System.out.println(chm.delete(9));
        System.out.println(chm.delete(2));
        System.out.println(chm);
        System.out.println("size = " + chm.size());
        System.out.println("------------------");
        System.out.println(chm.deleteAndNode(9));
        System.out.println(chm.deleteAndNode(4));
        System.out.println(chm);
        System.out.println("size = " + chm.size());

//        System.out.println(chm.get(3));
//        Random random = new Random();
//
//        for (int i = 0; i < 12; i++) {
//            chm.put(random.nextInt(100),"" );
//        }


//        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>();
////        lphm.put(1, "one");
////        lphm.put(2, "two");
////        lphm.put(3, "three");
////        lphm.put(4, "four");
//
//        //        System.out.println(lphm.get(30));
//
//        for (int i = 0; i < 90 ; i++) {
//            lphm.put(random.nextInt(10000),"" );
//        }
//
//        System.out.println(lphm);

    }
}
