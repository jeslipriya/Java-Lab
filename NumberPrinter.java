



class NumberPrint extends Thread{
    private final int start;
    private final int end;

    public NumberPrint(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(){
        for (int i = start; i <= end ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class NumberPrinter {
    public static void main(String[] args) {
        Thread t1 = new NumberPrint(90, 100);
        Thread t2 = new NumberPrint(1, 10);

        t1.start();
        t2.start();
    }
}
