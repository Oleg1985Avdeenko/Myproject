package servlet;

import command.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Util.*;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    private String command = null;
    private Command commandExecutor = null;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        extracted(req, resp);
        command = req.getParameter(COMMAND);
        if (VIEW.compareTo(command) == 0) {
            commandExecutor = new ViewCar();
            commandExecutor.execute(req);
            req.getRequestDispatcher(JSP_VIEW_JSP).forward(req, resp);
        } else if (EDIT.compareTo(command) == 0) {
            req.setAttribute(CAR_ID, req.getParameter(CAR_ID));
            req.setAttribute(PRICE, req.getParameter(PRICE));
            req.setAttribute(AVAILABILITY, req.getParameter(AVAILABILITY));
            req.getRequestDispatcher(JSP_EDIT_JSP).forward(req, resp);
        } else if (ADD.compareTo(command) == 0) {
            req.getRequestDispatcher(JSP_ADD_JSP).forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        extracted(req, resp);
    }

    private void extracted(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        command = req.getParameter(COMMAND);
        if (VIEW.compareTo(command) == 0) {
            commandExecutor = new ViewCar();
            commandExecutor.execute(req);
            req.getRequestDispatcher(JSP_VIEW_JSP).forward(req, resp);
        } else if (EDIT.compareTo(command) == 0) {
            req.setAttribute(CAR_ID, req.getParameter(CAR_ID));
            req.setAttribute(PRICE, req.getParameter(PRICE));
            req.setAttribute(AVAILABILITY, req.getParameter(AVAILABILITY));
            commandExecutor = new EditCar();
            commandExecutor.execute(req);
            req.getRequestDispatcher(JSP_VIEW_JSP).forward(req, resp);
        } else if (ADD.compareTo(command) == 0) {
            req.setAttribute(PRICE, req.getParameter(PRICE));
            req.setAttribute(AVAILABILITY, req.getParameter(AVAILABILITY));
            commandExecutor = new AddCar();
            commandExecutor.execute(req);
            req.getRequestDispatcher(JSP_VIEW_JSP).forward(req, resp);
        } else if (DELETE.compareTo(command) == 0) {
            req.setAttribute(CAR_ID, req.getParameter(CAR_ID));
            commandExecutor = new DeleteCar();
            commandExecutor.execute(req);
            req.getRequestDispatcher(JSP_VIEW_JSP).forward(req, resp);
        }
    }

}
