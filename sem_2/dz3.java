import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.*;


public class dz3 {
     public static void main(String[] args) {
        Logger ll = Logger.getLogger(dz3.class.getName());
        String logsPath = "log.txt";
        FileHandler fh = new FileHandler(logsPath, true);
        ll.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();

        fh.setFormatter(formatter);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int a = rand.nextInt(10);
            ll.log(Level.INFO, "element: " + a);
            
        }

        ll.log(Level.WARNING, "logge off");
        ll.info("test");
        ll.warning("logsPath");


     }
}
