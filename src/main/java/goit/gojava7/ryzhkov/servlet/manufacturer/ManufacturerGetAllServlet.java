package goit.gojava7.ryzhkov.servlet.manufacturer;

import goit.gojava7.ryzhkov.dao.ManufacturerDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManufacturerGetAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setListManufacturersFormDbToRequest(req);
        goToViewPage(req, resp);
    }

    private void setListManufacturersFormDbToRequest(HttpServletRequest req) {
        req.setAttribute("manufacturers", new ManufacturerDaoImpl().getAll());
    }

    private void goToViewPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/manufacturer/manufacturers.jsp").forward(req, resp);
    }

}
