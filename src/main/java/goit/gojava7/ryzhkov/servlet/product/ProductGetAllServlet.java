package goit.gojava7.ryzhkov.servlet.product;

import goit.gojava7.ryzhkov.dao.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductGetAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setListProductsFormDbToRequest(req);
        goToViewPage(req, resp);
    }

    private void setListProductsFormDbToRequest(HttpServletRequest req) {
        req.setAttribute("products", new ProductDaoImpl().getAll());
    }

    private void goToViewPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/product/products.jsp").forward(req, resp);
    }

}
