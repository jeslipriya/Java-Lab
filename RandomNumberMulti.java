import java.util.Random;

class NumberGenerator extends Thread{
    private final NumberProcessor processor;

    public NumberGenerator(NumberProcessor processor){
        this.processor = processor;
    }

    @Override
    public void run(){
        Random random = new Random();

        while (true) { 
            int number = random.nextInt(100);
            System.out.println("Generated: " + number);
            processor.processNumber(number);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class NumberProcessor{
    private int number;

    public synchronized void processNumber(int number){
        this.number = number;
        notifyAll();
    }

    public void square(){
        while (true) { 
            synchronized (this) {
                try {
                    wait();
                    if (number%2 == 0) {
                        System.out.println("Square: " + (number*number));
                    }
                } 
                
                catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
    
    public void cube(){
        while (true) { 
            synchronized (this) {
                try {
                    wait();
                    if (number%2 != 0) {
                        System.out.println("Cube: " + (number*number*number));
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
public class RandomNumberMulti {
    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        NumberGenerator generator = new NumberGenerator(processor);
        Thread squareThread = new Thread(processor::square);
        Thread cubeThread = new Thread(processor::cube);
        generator.start();
        squareThread.start();
        cubeThread.start();
    }
}
