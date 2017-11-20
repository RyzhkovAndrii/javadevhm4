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

public class ProductUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setProductFromDbToRequestByIdFromRequest(req);
        setListManufacturersFormDbToRequest(req);
        goToUpdatePage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Product product = getProductFromRequest(req);
            new ProductDaoImpl().update(product);
        } catch (Exception e) {
            goToErrorPage(req, resp);
            return;
        }
        goToDonePage(req, resp);
    }

    private UUID getProductIdFromRequest(HttpServletRequest req) {
        String uuidString = req.getParameter("id");
        UUID id = UUID.fromString(uuidString);
        return id;
    }

    private Product getProductFromRequest(HttpServletRequest req) {
        UUID id = getProductIdFromRequest(req);
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Manufacturer manufacturer = getProductManufacturerFromRequest(req);
        Product product = new ProductDaoImpl().getById(id);
        product.setName(name);
        product.setPrice(price);
        product.setManufacturer(manufacturer);
        return product;
    }

    private Manufacturer getProductManufacturerFromRequest(HttpServletRequest req) {
        UUID manufacturerId = UUID.fromString(req.getParameter("manufacturerId"));
        Manufacturer manufacturer = new ManufacturerDaoImpl().getById(manufacturerId);
        return manufacturer;
    }

    private void setProductFromDbToRequestByIdFromRequest(HttpServletRequest req) {
        UUID id = getProductIdFromRequest(req);
        Product product = new ProductDaoImpl().getById(id);
        req.setAttribute("product", product);
    }

    private void setListManufacturersFormDbToRequest(HttpServletRequest req) {
        req.setAttribute("manufacturers", new ManufacturerDaoImpl().getAll());
    }

    private void goToUpdatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/product/productUpdate.jsp").forward(req, resp);
    }

    private void goToDonePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String okMessage = "product was updated";
        req.setAttribute("message", okMessage);
        req.getRequestDispatcher("done").forward(req, resp);
    }

    private void goToErrorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = "can't update product";
        req.setAttribute("message", errorMessage);
        req.getRequestDispatcher("error").forward(req, resp);
    }

}
