package tomcat.runner.app

import javax.servlet.annotation.WebServlet
import javax.servlet.http.{Cookie, HttpServlet, HttpServletRequest, HttpServletResponse}

@WebServlet(
  description = "Login Servlet",
  urlPatterns = Array("/LoginServlet")
)
class LoginServlet extends HttpServlet {
  val userId = "Kek"
  val password = "Kek"

  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    //get request parameters for userID and password
    val user = req.getParameter("user")
    val pwd = req.getParameter("pwd")

    if (userId == user && password ==pwd) {
      val loginCookie = new Cookie("user", user)
      //setting cookie to expiry in 30 mins
      loginCookie.setMaxAge(30 * 60)
      resp.addCookie(loginCookie)
      resp.sendRedirect("LoginSuccess.jsp")
    } else {
      val rd = getServletContext.getRequestDispatcher("/login.html")
      val out = resp.getWriter
      out.println("<font color=red>Either user name or password is wrong.</font>")
      rd.include(req, resp)
    }
  }
}

object LoginServlet {
  val serialVersionUID = 1L
}
