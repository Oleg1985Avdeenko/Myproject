package servlet;

import command.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
//
//    private String command1 = null;
//    private Command commandExecutor = null;
//    private Command commandExecutor1 = null;
//    private Command commandExecutor2 = null;

@Override
protected void doGet(final HttpServletRequest request,
                     final HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws ServletException, IOException {
        String page;
        Command command = CommandFactory.getInstance()
                .defineCommand(req);
        page = Objects.requireNonNull(command).execute(req);
        getServletContext().getRequestDispatcher(page).forward(req, resp);
    }
}
