package app.northwind.business.concrete;

import app.northwind.business.abstracts.SupplierService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.SupplierDao;
import app.northwind.model.entity.concrete.Supplier;
import app.northwind.model.entity.concrete.Supplier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SupplierManager implements SupplierService {

    private SupplierDao supplierDao;

    @Autowired
    public SupplierManager(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    public DataResult<List<Supplier>> getAll() {
        return new DataResult<List<Supplier>>(true, this.supplierDao.findAll());
    }

    @Override
    public DataResult<Supplier> getById(int id) {
        return new DataResult<Supplier>(true, this.supplierDao.getById(id));
    }

    @Override
    public DataResult<Supplier> add(Supplier data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Supplier>(null);

        return new DataResult<Supplier>(true, "Successfully added.", this.supplierDao.save(data));
    }

    @Override
    public DataResult<List<Supplier>> addAll(List<Supplier> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Supplier>>(true, "Successfully added.", this.supplierDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Supplier> update(Supplier data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Supplier>(null);

        return new DataResult<Supplier>(true, "Successfully added.", this.supplierDao.save(data));
    }

    @Override
    public DataResult<List<Supplier>> updateAll(List<Supplier> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Supplier>>(null);

        return new DataResult<List<Supplier>>(true, "Successfully added.", this.supplierDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.supplierDao.getById(id))) {
                this.supplierDao.deleteById(id);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Supplier data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.supplierDao.getById(data.getId()))) {
                this.supplierDao.delete(data);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
