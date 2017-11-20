package goit.gojava7.ryzhkov.servlet.product;

import goit.gojava7.ryzhkov.dao.ManufacturerDaoImpl;
import goit.gojava7.ryzhkov.dao.ProductDaoImpl;
import goit.gojava7.ryzhkov.model.Manufacturer;
import goit.gojava7.ryzhkov.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setListManufacturersFormDbToRequest(req);
        req.getRequestDispatcher("jsp/product/productCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Product product = getProductWithOutIdFromRequest(req);
            new ProductDaoImpl().save(product);
        } catch (Exception e) {
            goToErrorPage(req, resp);
            return;
        }
        goToDonePage(req, resp);
    }

    private void setListManufacturersFormDbToRequest(HttpServletRequest req) {
        req.setAttribute("manufacturers", new ManufacturerDaoImpl().getAll());
    }

    private Product getProductWithOutIdFromRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Manufacturer productManufacturer = getProductManufacturerFromRequest(req);
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setManufacturer(productManufacturer);
        return product;
    }

    private Manufacturer getProductManufacturerFromRequest(HttpServletRequest req) {
        UUID manufacturerId = UUID.fromString(req.getParameter("manufacturerId"));
        Manufacturer manufacturer = new ManufacturerDaoImpl().getById(manufacturerId);
        return manufacturer;
    }

    private void goToDonePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String okMessage = "product was created";
        req.setAttribute("message", okMessage);
        req.getRequestDispatcher("done").forward(req, resp);
    }

    private void goToErrorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = "can't create product";
        req.setAttribute("message", errorMessage);
        req.getRequestDispatcher("error").forward(req, resp);
    }

}
