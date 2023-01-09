import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();
        ThirdThread thirdThread = new ThirdThread();
        firstThread.start();
        secondThread.start();
        thirdThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        thirdThread.shutDown();

    }


}

class FirstThread extends Thread {
        public void run(){
            for(int i = 0; i<10;i++){
                System.out.println(i*i);
            }
            System.out.println("FirstThread ended"+ "\n------------------------");
        }
}

class SecondThread extends Thread {
    public void run(){
        int[] arr = {1,2,3,4,5};
        for(int i : arr){
            System.out.println(i*256);
        }
        System.out.println("SecondThread ended"+ "\n------------------------");
    }
}

class ThirdThread extends Thread {
   private volatile boolean flag = true;

    public void run(){
        while(flag){
            System.out.println("Hi");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     void shutDown(){
        this.flag = false;
         System.out.println("ThirdThread shut down" + "\n------------------------");
     }
}
