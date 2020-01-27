public class ThreadDemo1 {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("我在 method2 中打印");
                // 进程会暂停运行 1 秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void method2() {
        Thread thread = new MyThread();
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        // 两个死循环可以同时开始执行，没有一个卡住另一个的情况
        //以下是我自己 的理解****************
        //主线程同时要做两件事情，1.method2  2.下面语句：打印"我在在main中打印"
        //但两个事情都是死循环，所以将第1个事情交给另一个线程去做，
        //第2个事情则由主线程做
        //最终结果是：两者同时打印
        method2();
        while (true) {
            System.out.println("我在 main 中打印");
            // 进程会暂停运行 1 秒
            Thread.sleep(1000);
        }
    }

   //private static void method1() throws InterruptedException {
   //    while (true) {
   //        System.out.println("我在 method1 中打印");
   //        // 进程会暂停运行 1 秒
   //        Thread.sleep(1000);
   //    }
   //}
}
