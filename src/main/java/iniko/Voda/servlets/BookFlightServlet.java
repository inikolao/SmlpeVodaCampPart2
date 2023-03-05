package iniko.Voda.servlets;


import com.mysql.cj.protocol.x.Notice;
import iniko.Voda.DAO.Flight;
import iniko.Voda.DAO.Ticket;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.TicketRepo;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.net.http.HttpResponse;

@WebServlet("/book")
public class BookFlightServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;
    public BookFlightServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        //System.out.println(req.getParameter("value").toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
       // Ticket ticket= Notice.XSessionStateChanged. req.getParameter("ticket");
        HttpSession session = req.getSession();
        Ticket ticket= (Ticket) session.getAttribute("ticket");
        TicketRepo ticketRepo=new TicketRepo();
        ticketRepo.save(ticket);
        session.setAttribute("bookf","yes");
        String fileName = "ticket"+ticket.getId()+".docx";
        File f= new File(fileName);
        System.out.println("look :"+f.getAbsolutePath());

            try (XWPFDocument doc = new XWPFDocument()) {

                // create a paragraph
                XWPFParagraph p1 = doc.createParagraph();
                p1.setAlignment(ParagraphAlignment.CENTER);

                // set font
                XWPFRun r1 = p1.createRun();
                r1.setBold(true);
                r1.setItalic(true);
                r1.setFontSize(22);
                r1.setFontFamily("New Roman");
                r1.setText("Ticket ID: " + ticket.getId());
                r1.addBreak();
                r1.setText("flight home: " + ticket.getFlight().getHomeAirport());
                r1.addBreak();
                r1.setText("flight date: " + ticket.getFlight().getHomeAirport());
                r1.addBreak();
                r1.setText("flight destination: " + ticket.getFlight().getDestinationAirport());
                r1.addBreak();
                r1.setText("Seat: " + ticket.getSeat());
                r1.addBreak();
                r1.setText("Owner: " + ticket.getPassenger().getName() + "  " + ticket.getPassenger().getSurname());
                r1.addBreak();
                r1.setText("Airliner: " + ticket.getFlight().getAirliner().getName());
                // save it to .docx file
                try (FileOutputStream out = new FileOutputStream(fileName)) {
                    doc.write(out);
                    out.close();
                    doc.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("docx write error");
                }
                resp.setContentType("text/plain");
                resp.setHeader("Content-disposition", "attachment; filename=\""+f.getName()+"\"");

                try( FileInputStream in = new FileInputStream(f);
                    OutputStream out = resp.getOutputStream()) {

                    byte[] buffer = new byte[ARBITARY_SIZE];

                    int numBytesRead=-1;
                    while ((numBytesRead = in.read(buffer)) > 0) {
                        out.write(buffer, 0, numBytesRead);
                    }
                   // f.delete();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("docx download error");
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("docx error");
            }







    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
