package goit.gojava7.ryzhkov.servlet.manufacturer;

import goit.gojava7.ryzhkov.dao.ManufacturerDaoImpl;
import goit.gojava7.ryzhkov.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ManufacturerGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setManufacturerFromDbToRequestByIdFromRequest(req);
        goToViewPage(req, resp);
    }

    private UUID getManufacturerIdFromRequest(HttpServletRequest req) {
        String uuidString = req.getParameter("id");
        UUID id = UUID.fromString(uuidString);
        return id;
    }

    private void setManufacturerFromDbToRequestByIdFromRequest(HttpServletRequest req) {
        UUID id = getManufacturerIdFromRequest(req);
        Manufacturer manufacturer = new ManufacturerDaoImpl().getById(id);
        req.setAttribute("manufacturer", manufacturer);
    }

    private void goToViewPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/manufacturer/manufacturer.jsp").forward(req, resp);
    }

}
