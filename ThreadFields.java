public class ThreadFields {
    public static void main(String[] args) {
        Thread current=Thread.currentThread();
        System.out.println(current.getId());
        System.out.println(current.getName());
        System.out.println(current.getPriority());
        System.out.println(current.getState());
        System.out.println(current.isAlive());
        System.out.println(current.isInterrupted());
        System.out.println(current.isDaemon());//是否后台线程

    }
}
