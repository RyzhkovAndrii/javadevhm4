package goit.gojava7.ryzhkov.dao;

import goit.gojava7.ryzhkov.model.Manufacturer;

import java.util.UUID;

public class ManufacturerDaoImpl extends HibernateDao<Manufacturer, UUID> implements ManufacturerDao {

    public ManufacturerDaoImpl() {
        setType(Manufacturer.class);
    }

}
