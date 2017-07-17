package servlets;


import accounts.AccountService;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RegistrationServlet extends HttpServlet {

    private final String REGISTRATION_HTML = "registration.html";
    private String login = "";
    private String password = "";
    private String email = "";
    private AccountService accountService = new AccountService();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", login == null ? "" : login);

        response.getWriter().println(PageGenerator.getPage(REGISTRATION_HTML, pageVariables));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        login = request.getParameter("login");
        password = request.getParameter("password");
        email = request.getParameter("email");

        response.setContentType("text/html;charset=utf-8");

        if       ( login == null || login.isEmpty()
                || password == null || password.isEmpty()
                || email == null || email.isEmpty() )
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            accountService.registration(login, password, email);
            response.setStatus(HttpServletResponse.SC_OK);
        }

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", login == null ? "" : login);

        response.getWriter().println(PageGenerator.getPage(REGISTRATION_HTML, pageVariables));
    }
}
