import java.util.Scanner;

public class ManualControl {

    public static void main(String[] args) throws Exception {

        JTello tello = new JTello();

        tello.connect();
        tello.takeOff();

        System.out.println("Enter \"land\" to land the drone!");

        String input = "";
        String val = "";
        Scanner sc = new Scanner(System.in);

        while (!input.equals("land")) {


            try {

                System.out.print("Enter command: f/b/l/r");
                input = sc.next();

                System.out.println("Enter value");
                val = sc.next();

                // TODO: Add method calls

            } catch (Exception err) {
                System.out.println("Bad input, or please read error: " + err);
            }


        }

        tello.land();


    }

}
