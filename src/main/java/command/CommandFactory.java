package command;

import javax.servlet.http.HttpServletRequest;

import static utils.Util.COMMAND;

public class CommandFactory {

    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return COMMAND_FACTORY;
    }


    public Command defineCommand(final HttpServletRequest request) {
        String action = request.getParameter(COMMAND);
        if (action == null || action.isEmpty()) {
            return null;
        }
        CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
        return commandEnum.getCommand();
    }
}
