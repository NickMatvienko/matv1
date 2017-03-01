package patterns.sierra_bates_patterns.command;

/**
 * Created by a on 16.02.17.
 */
/*The test class*/
public class TestCommand{
    public static void main(String[] args){
        Light l = new Light();
        Command switchUp=new TurnOnLightCommand(l);
        Command switchDown=new TurnOffLightCommand(l);

        Switch s = new Switch(switchUp,switchDown);

        s.flipUp();
        s.flipDown();
    }
}