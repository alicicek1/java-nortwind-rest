package app.northwind.business.concrete;

import app.northwind.business.abstracts.ShipperService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.ShipperDao;
import app.northwind.model.entity.concrete.Product;
import app.northwind.model.entity.concrete.Shipper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShipperManager implements ShipperService {

    private ShipperDao shipperDao;

    @Autowired
    public ShipperManager(ShipperDao shipperDao) {
        this.shipperDao = shipperDao;
    }

    @Override
    public DataResult<List<Shipper>> getAll() {
        return new DataResult<List<Shipper>>(true, this.shipperDao.findAll());
    }

    @Override
    public DataResult<Shipper> getById(int id) {
        return new DataResult<Shipper>(true, this.shipperDao.getById(id));
    }

    @Override
    public DataResult<Shipper> add(Shipper data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Shipper>(null);

        return new DataResult<Shipper>(true, "Successfully added.", this.shipperDao.save(data));
    }

    @Override
    public DataResult<List<Shipper>> addAll(List<Shipper> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Shipper>>(true, "Successfully added.", this.shipperDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Shipper> update(Shipper data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Shipper>(null);

        return new DataResult<Shipper>(true, "Successfully added.", this.shipperDao.save(data));
    }

    @Override
    public DataResult<List<Shipper>> updateAll(List<Shipper> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Shipper>>(null);

        return new DataResult<List<Shipper>>(true, "Successfully added.", this.shipperDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.shipperDao.getById(id))) {
                this.shipperDao.deleteById(id);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Shipper data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.shipperDao.getById(data.getId()))) {
                this.shipperDao.delete(data);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
