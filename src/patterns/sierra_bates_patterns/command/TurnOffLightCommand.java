package patterns.sierra_bates_patterns.command;

/**
 * Created by a on 16.02.17.
 */
/*the Command for turning off the light*/

public class TurnOffLightCommand implements Command{
    private Light theLight;

    public TurnOffLightCommand(Light light){
        this.theLight=light;
    }

    public void execute(){
        theLight.turnOff();
    }
}