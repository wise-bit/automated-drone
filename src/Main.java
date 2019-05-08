
public class Main {

    public static void main(String[] args) throws Exception {

        // res

        RecognizeFace r = new RecognizeFace("res");

    }

    public static void operateTello() throws Exception {

        JTello tello = new JTello();

        tello.connect();
        tello.takeOff();

        Thread.sleep(5000);

        // tello.up(10);

        for (int i = 0; i < 3; i++) {

            tello.forward(500);
            Thread.sleep(7800);
            tello.cw(90);
            Thread.sleep(3500);

        }

        // Thread.sleep(5000);
        tello.land();

    }

}
