//线程不安全

//用对于一个变量n，起一个线程让其自增Count次，再起另一个线程让其自减Count次
//求最终结果n等于几？  ===》理论上来说应该是0，但是不尽然，
// 这是由于线程不安全问题引起的
public class Wrong {
    public static final int Count=10_0000;
    public static int n=0;

    private static class Add extends Thread{
        @Override
        public void run() {
            for(int i=0;i<Count;i++){
                n++;
            }
        }
    }
    private static class Sub extends Thread{
        @Override
        public void run() {
            for(int i=0;i<Count;i++){
                n--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Add();
        Thread thread2=new Sub();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(n);
    }
}
