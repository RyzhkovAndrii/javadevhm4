package goit.gojava7.ryzhkov.servlet.manufacturer;

import goit.gojava7.ryzhkov.dao.ManufacturerDao;
import goit.gojava7.ryzhkov.dao.ManufacturerDaoImpl;
import goit.gojava7.ryzhkov.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ManufacturerDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = getManufacturerIdFromRequest(req);
        ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();
        Manufacturer manufacturer = manufacturerDao.getById(id);
        manufacturerDao.remove(manufacturer);
        goToDonePage(req, resp);
    }

    private UUID getManufacturerIdFromRequest(HttpServletRequest req) {
        String uuidString = req.getParameter("id");
        UUID id = UUID.fromString(uuidString);
        return id;
    }

    private void goToDonePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String okMessage = "manufacturer was deleted";
        req.setAttribute("message", okMessage);
        req.getRequestDispatcher("done").forward(req, resp);
    }

}
