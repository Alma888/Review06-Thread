//打印线程的几种状态

public class StateDemo {
    public static void main(String[] args) {
        for(Thread.State state:Thread.State.values()){
            System.out.println(state);
        }
    }
}
