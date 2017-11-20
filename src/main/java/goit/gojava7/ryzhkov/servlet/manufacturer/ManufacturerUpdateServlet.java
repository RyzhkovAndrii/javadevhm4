package goit.gojava7.ryzhkov.servlet.manufacturer;

import goit.gojava7.ryzhkov.dao.ManufacturerDaoImpl;
import goit.gojava7.ryzhkov.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ManufacturerUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setManufacturerFromDbToRequestByIdFromRequest(req);
        goToUpdatePage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Manufacturer manufacturer = getManufacturerFromRequest(req);
            new ManufacturerDaoImpl().update(manufacturer);
        } catch (Exception e) {
            goToErrorPage(req, resp);
            return;
        }
        goToDonePage(req, resp);
    }

    private UUID getManufacturerIdFromRequest(HttpServletRequest req) {
        String uuidString = req.getParameter("id");
        UUID id = UUID.fromString(uuidString);
        return id;
    }

    private Manufacturer getManufacturerFromRequest(HttpServletRequest req) {
        UUID id = getManufacturerIdFromRequest(req);
        String name = req.getParameter("name");
        Manufacturer manufacturer = new ManufacturerDaoImpl().getById(id);
        manufacturer.setName(name);
        return manufacturer;
    }

    private void setManufacturerFromDbToRequestByIdFromRequest(HttpServletRequest req) {
        UUID id = getManufacturerIdFromRequest(req);
        Manufacturer manufacturer = new ManufacturerDaoImpl().getById(id);
        req.setAttribute("manufacturer", manufacturer);
    }

    private void goToUpdatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/manufacturer/manufacturerUpdate.jsp").forward(req, resp);
    }

    private void goToDonePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String okMessage = "manufacturer was updated";
        req.setAttribute("message", okMessage);
        req.getRequestDispatcher("done").forward(req, resp);
    }

    private void goToErrorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = "can't update manufacturer";
        req.setAttribute("message", errorMessage);
        req.getRequestDispatcher("error").forward(req, resp);
    }

}
