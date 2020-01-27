//中断一个线程

//方法2：调用 interrupt() 方法来通知
public class StopThread2 {
    private static class Worker extends Thread {
        Worker() {
            super("李四");
        }

        @Override
        public void run() {
            while (!this.isInterrupted()) {
                System.out.println(this.getName() + ": 我正在转账，别烦我");
                try {
                    Thread.sleep(1); //在收到对方是骗子的通知后，有可能程序从这条语句就出去了
                } catch (InterruptedException e) {
                    System.out.println("我从睡梦中惊醒");
                    break;      //但也可能是从这跳出程序的
                    //e.printStackTrace();
                }
            }

          System.out.println(this.getName() + ": 对方是骗子，我不转账了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        System.out.println("我是张三，正在等李四转账");
        Thread.sleep(10 * 1000);
        System.out.println("打听到对方是骗子，通知李四停止转账");
        worker.interrupt();//通知哪个线程停止，就要调用哪个线程的interrupt方法
        System.out.println("通知李四完毕");
        worker.join();
        System.out.println("李四停止转账");
    }
}
