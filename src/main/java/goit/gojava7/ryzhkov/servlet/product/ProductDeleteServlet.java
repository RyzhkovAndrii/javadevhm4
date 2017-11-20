package goit.gojava7.ryzhkov.servlet.product;

import goit.gojava7.ryzhkov.dao.ProductDao;
import goit.gojava7.ryzhkov.dao.ProductDaoImpl;
import goit.gojava7.ryzhkov.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ProductDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = getProductIdFromRequest(req);
        ProductDao productDao = new ProductDaoImpl();
        Product product = productDao.getById(id);
        productDao.remove(product);
        goToDonePage(req, resp);
    }

    private UUID getProductIdFromRequest(HttpServletRequest req) {
        String uuidString = req.getParameter("id");
        UUID id = UUID.fromString(uuidString);
        return id;
    }

    private void goToDonePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String okMessage = "product was deleted";
        req.setAttribute("message", okMessage);
        req.getRequestDispatcher("done").forward(req, resp);
    }

}
