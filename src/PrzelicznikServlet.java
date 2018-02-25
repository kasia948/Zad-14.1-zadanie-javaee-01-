import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/przelicznik")
public class PrzelicznikServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String metry = request.getParameter("metry");
//      String centymetry = request.getParameter("centymetry");
//      String milimetry = request.getParameter("milimetry");

        Integer metryINT = Integer.valueOf(metry);

//        Integer centymetryINT = Integer.valueOf(centymetry);
//        Integer milimetryINT = Integer.valueOf(milimetry);

        MetricConverter metConv = new MetricConverter();
        int wynik1 = metConv.calculateCM(metryINT);


        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.print("Podana wartość w przeliczeniu na: \n centymetry: "+wynik1);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
