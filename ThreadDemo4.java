//演示了：多线程相比单线程能够提高运行速度（多线程的优点之一）

public class ThreadDemo4 {
    private static final long COUNT = 10_0000_0000;

    public static void main(String[] args) throws InterruptedException {
        serial();     // 串行    （单个线程去执行）
        concurrent();   // 并发  （起两个线程去执行）
    }

    private static class CalcThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            for (long i = 0; i < COUNT; i++) {
                n++;
            }
        }
    }

    //并发执行（也就是 多个线程执行）
    private static void concurrent() throws InterruptedException {
        long begin = System.nanoTime();

        Thread thread1 = new CalcThread();
        thread1.start();//算第1遍
        Thread thread2 = new CalcThread();
        thread2.start();//算第2遍

        int a = 0;
        for (long i = 0; i < COUNT; i++) {//这个由主线程去算：算第3遍
            a++;
        }

        thread1.join();
        thread2.join();

        long end = System.nanoTime();
        double s = (end - begin) * 1.0 / 1000 / 1000 / 1000;
        System.out.printf("并发模式: 耗时: %.4f%n", s);
    }

    //串行执行（也就是 单线程执行）
    private static void serial() {  //也是算了3遍
        long begin = System.nanoTime();

        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b++;
        }
        int c = 0;
        for (long i = 0; i < COUNT; i++) {
            c++;
        }

        long end = System.nanoTime();
        double s = (end - begin) * 1.0 / 1000 / 1000 / 1000;
        System.out.printf("串行模式: 耗时: %.4f%n", s);
    }
}
