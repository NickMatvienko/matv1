package patterns.sierra_bates_patterns.command;

/**
 * Created by a on 16.02.17.
 */
/*Receiver class*/
public class Light {
    public Light(){  }

    public void turnOn(){
        System.out.println("The light is on");
    }

    public void turnOff(){
        System.out.println("The light is off");
    }
}