package tomcat.runner.app

import javax.servlet.annotation.WebServlet
import javax.servlet.http.{Cookie, HttpServlet, HttpServletRequest, HttpServletResponse}

@WebServlet(
  description = "Logout Servlet",
  urlPatterns = Array("/LogoutServlet")
)
class LogoutServlet extends HttpServlet {
  val userId = "Kek"
  val password = "Kek"

  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    resp.setContentType("text/html")
    Option(req.getCookies).foreach { cookies =>
      cookies.find(_.getName == "user").foreach(resp.addCookie)
    }
    resp.sendRedirect("login.html")
  }
}

object LogoutServlet {
  val serialVersionUID = 1L
}

