public class CreateThreadPractice {
    private static class P1 extends Thread{
        private long count=100_0000;
        @Override
        public void run() {
            long sum1=0;
            for(int i=1;i<=count;i++){
                sum1+=i;
            }
            System.out.println("P1: 1 + 2 + ... + n = "+sum1);
        }
    }
    private static class P2 extends Thread{
        private long count=100_0001;
        @Override
        public void run() {
            long sum2=0;
            for(int i=1;i<=count;i+=2){
                sum2+=i;
            }
            System.out.println("P2: 1 + 3 + ... + n = "+sum2);
        }
    }
    private static class P3 extends Thread{
        private long count=10_0000;
        @Override
        public void run() {
            long sum3=0;
            for(int i=1;i<=count;i++){
                sum3+=i*i;
            }
            System.out.println("P3: 1 + 4 + ... + n = "+sum3);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread t1 = new P1();
        Thread t2 = new P2();
        Thread t3 = new P3();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end = System.currentTimeMillis();
        System.out.println((end - begin) * 1.0 / 1000);
    }
}
