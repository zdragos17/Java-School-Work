package isp.lab11;

import java.util.HashMap;
import java.util.Map;

public class ATC {

    private Map<String,Aircraft> aircrafts=new HashMap();

    public void addAircraft(String id){
        Aircraft aircraft=new Aircraft(id);
        aircraft.start();
        aircrafts.put(id,aircraft);
        System.out.println("Aircraft with id " + id + " added");
    }

    public void sendCommand(String id, AtcCommand command){
        Aircraft aircraft=aircrafts.get(id);
        aircraft.receiveAtcCommand(command);
        System.out.println("Aircraft with id " + id + " received command " + command);

    }

    public void showAircrafts(){
        System.out.println("Display aircrfats.");
        for(Aircraft aircraft:aircrafts.values()){
            System.out.println(aircrafts.values()+" ");
        }
    }
}

class AtcCommand {
    String command;

    public AtcCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "AtcCommand{" +
                "command='" + command + '\'' +
                '}';
    }
}
