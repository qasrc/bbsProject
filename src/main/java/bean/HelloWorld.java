package bean;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * helloword Servlet
 *
 * @author zhan
 * Created on 2017/08/17  14:06
 */
@WebServlet(name = "helloServlet", loadOnStartup = 1)
public class HelloWorld extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Hello World");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (StringUtils.isBlank(name)) {
            name = "World";
        }
        req.setAttribute("name", name);
        req.getRequestDispatcher("response.jsp").forward(req, resp);
    }
}
