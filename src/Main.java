
public class Main {
    static boolean win = false;

    public static void main(String[] args) {
        long random = (long) (Math.random() * 100000000);
        System.out.println(random);
        Thread timer = new Thread(() -> {
            int i = 0;
            try {
                while (!win) {
                    System.out.println(i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread player = new Thread(() -> {
            while (!win) {
                long guessNumber = (long) (Math.random() * 1_000_000_000);
                if (guessNumber == random) {
                    win = true;
                    System.out.println(guessNumber);
                }
            }
        });
        timer.start();
        player.start();
    }

}