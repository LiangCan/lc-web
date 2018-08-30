package com.lc.web.utils;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {


    static List<String> list = new CopyOnWriteArrayList<String>();



//    public static void main(String[] args) {
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//
//         new Thread() {
//            public void run() {
//                Iterator<String> iterator = list.iterator();
//
//                while (iterator.hasNext()) {
//                    System.out.println(Thread.currentThread().getName()
//                            + ":" + iterator.next());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            };
//        }.start();
//
//        new Thread() {
//            public synchronized void run() {
//                Iterator<String> iterator = list.iterator();
//                while (iterator.hasNext()) {
//                    String element = iterator.next();
//                    System.out.println(Thread.currentThread().getName() + ":" + element);
//                    if (element.equals("c")) {
//                        list.remove(element);
//                    }
//                }
//            };
//        }.start();
//
//    }

}
