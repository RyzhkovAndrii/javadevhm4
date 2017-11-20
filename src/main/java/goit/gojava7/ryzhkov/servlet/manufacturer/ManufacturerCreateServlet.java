package goit.gojava7.ryzhkov.servlet.manufacturer;

import goit.gojava7.ryzhkov.dao.ManufacturerDaoImpl;
import goit.gojava7.ryzhkov.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManufacturerCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/manufacturer/manufacturerCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Manufacturer manufacturer = getManufacturerWithOutIdFromRequest(req);
            new ManufacturerDaoImpl().save(manufacturer);
        } catch (Exception e) {
            goToErrorPage(req, resp);
            return;
        }
        goToDonePage(req, resp);
    }

    private Manufacturer getManufacturerWithOutIdFromRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        return manufacturer;
    }

    private void goToDonePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String okMessage = "manufacturer was created";
        req.setAttribute("message", okMessage);
        req.getRequestDispatcher("done").forward(req, resp);
    }

    private void goToErrorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = "can't create manufacturer";
        req.setAttribute("message", errorMessage);
        req.getRequestDispatcher("error").forward(req, resp);
    }

}
