// a servlet job is to process HTTP request parameters.
// for this case, it will create a javabean object based on the information
// submitted by the user via form. After that, it will execute the query on LoginDAO
// using the information stored by the javabean.
// Lastly, it will redirect the user to the right page based on the logic below

package mvcpackage.controller;

// import both the javabean model and the DAO
import mvcpackage.model.bean.Login;
import mvcpackage.model.dao.LoginDAO;

// we will be using sessions, so we need to import HttpSession
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/LoginServlet", name = "LoginServlet") // the WebServlet value is what the form will have to point to

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // store the parameter "username" that was passed through the form
        String username = request.getParameter("username");

        // store the parameter "password" that was passed through the form
        String password = request.getParameter("password");

        // initializes a new Login javabean object and set the two variables with username / password
        Login loginBean = new Login();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            // if the validate method from the DAO returns true
            if (LoginDAO.validate(loginBean)) {
                HttpSession session = request.getSession(); // create a session (to be explained in class)
                session.setAttribute("username", username); // set an attribute called username with the value of username
                response.sendRedirect("success.jsp"); // redirect the user to the success page
            } else {
                response.sendRedirect("error.jsp"); // redirect the user to the error page
            }

        }catch (Exception e) {
            System.out.println("Servlet error");
            e.printStackTrace();
        }


    }
}
