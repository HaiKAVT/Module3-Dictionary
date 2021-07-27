import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/translate")
public class DictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hello","Xin Chào");
        dictionary.put("How","Thế nào");
        dictionary.put("book","Quyển Vở");
        dictionary.put("computer","Máy Tính");
        dictionary.put("love","Yêu");
        dictionary.put("hate","ghét");

        String search = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if(result != null){
            writer.println("Word: " + search);
            writer.println("Result: " + result);
        } else {
            writer.println("Not Found");
        }
        writer.println("</html>");
    }
}
