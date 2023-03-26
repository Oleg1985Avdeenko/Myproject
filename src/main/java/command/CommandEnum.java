package command;

import command.views.*;

public enum CommandEnum {
    VIEW_CAR(new ViewCar()),
    VIEW_MODEL(new ViewModel()),
    VIEW_COLOR(new ViewColor()),
    VIEW_ENGINE(new ViewEngine()),
    VIEW_OPTION(new ViewEngine()),
    VIEW_TRANSMISSION(new ViewTransmission()),
    VIEW_CLIENT(new ViewClient()),
    VIEW_ORDER(new ViewOrder()),
    ;

    private  final Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public  Command getCommand() {
        return command;
    }
}
