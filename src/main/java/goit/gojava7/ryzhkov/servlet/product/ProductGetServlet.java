package goit.gojava7.ryzhkov.servlet.product;

import goit.gojava7.ryzhkov.dao.ProductDaoImpl;
import goit.gojava7.ryzhkov.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ProductGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setProductFromDbToRequestByIdFromRequest(req);
        goToViewPage(req, resp);
    }

    private UUID getProductIdFromRequest(HttpServletRequest req) {
        String uuidString = req.getParameter("id");
        UUID id = UUID.fromString(uuidString);
        return id;
    }

    private void setProductFromDbToRequestByIdFromRequest(HttpServletRequest req) {
        UUID id = getProductIdFromRequest(req);
        Product product = new ProductDaoImpl().getById(id);
        req.setAttribute("product", product);
    }

    private void goToViewPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/product/product.jsp").forward(req, resp);
    }

}
