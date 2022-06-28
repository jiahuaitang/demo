package com.example.demo.test;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class ThreadDemo {

    public static void main(String[] args) {
        uti.setTt("1");
        uti.setTtt("2");
        te t = new te();
        t.testss();


    }

}
class uti{
    private static final  ThreadLocal<String> tt = new ThreadLocal<>();
    private static final  ThreadLocal<String> ttt = new InheritableThreadLocal<>();
    uti(){
    };

    public static void setTt(String id) {
        tt.set(id);
    }
    public static void setTtt(String id) {
        ttt.set(id);
    }
    public static String getTt(){
        return  tt.get();
    }
    public static String getTtt(){
        return  ttt.get();
    }

}

class te{
    public void testss() {
        new Thread(() -> {
            System.out.println("t1" + uti.getTt());
            System.out.println("t11" + uti.getTtt());
        }).start();

        new Thread(() -> {
            System.out.println("t2" +uti.getTt());
            System.out.println("t22" + uti.getTtt());
        }).start();

        new Thread(() -> {
            System.out.println("t3" + uti.getTt());
            System.out.println("tt3" + uti.getTtt());
        }).start();
    }
}


class Demo1 implements Runnable{
    @Override
    public void run() {
        ThreadLocal<String> tt = new ThreadLocal<>();
        tt.set("1");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1"+tt.get());
    }
}

class Demo2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocal<String> tt = new ThreadLocal<>();
        System.out.println("t2"+tt.get());
    }
}