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
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String metry = request.getParameter("metry"); //przypisuje stringa z formularza do stringa metry
        String centymetry = request.getParameter("centymetry");
        String milimetry = request.getParameter("milimetry");
        MetricConverter metConv = new MetricConverter();
        PrintWriter writer = response.getWriter();


        if (metry != null&& centymetry == null && milimetry == null ) { //sprawdzam czy metry nie jest nullem
            Integer metryINT = Integer.valueOf(metry); //przerabiam metry na liczbę
            int wynik1 = metConv.calculateCMfromM(metryINT);
            int wynik2 = metConv.calculateMMfromM(metryINT);
            writer.print("Podana wartość w przeliczeniu na:<br>metry: " + metryINT + "<br>centymetry: " + wynik1 + "<br>milimetry: " + wynik2);
        } else if (metry == null && centymetry != null && milimetry == null) {
            Integer centINT = Integer.valueOf(centymetry);
            int wynik3 = metConv.calculateMfromCM(centINT);
            int wynik4 = metConv.calculateMMfromCM(centINT);
            writer.print("Podana wartość w przeliczeniu na:<br>metry: " + wynik3 + "<br>centymetry: " + centINT + "<br>milimetry: " + wynik4);
        } else if (metry == null && centymetry == null && milimetry != null) {
            Integer mmINT = Integer.valueOf(milimetry);
            int wynik5 = metConv.calculateMfromMM(mmINT);
            int wynik6 = metConv.calculateMfromCM(mmINT);
            writer.print("Podana wartość w przeliczeniu na:<br>metry: " + wynik5 + "<br>centymetry: " + wynik6 + "<br>milimetry: " + mmINT);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
