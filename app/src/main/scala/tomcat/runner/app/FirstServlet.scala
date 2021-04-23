package tomcat.runner.app

import tomcat.runner.app.FirstServlet.{HTML_END, HTML_START}

import java.util.Date
import javax.servlet.annotation.{WebInitParam, WebServlet}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

@WebServlet(
  description = "My First Servlet",
  urlPatterns = Array("/FirstServlet" , "/FirstServlet.do"),
  initParams = Array(
    new WebInitParam(name = "name", value = "Kek")
  )
)
class FirstServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val out = resp.getWriter
    val date = new Date()
    out.println(s"$HTML_START<h2>Hi There!</h2><br/><h3>Date=$date</h3>$HTML_END")
  }

  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    super.doPost(req, resp)
  }
}

object FirstServlet {
  val HTML_START = "<html><body>"
  val HTML_END = "</body></html>"
}