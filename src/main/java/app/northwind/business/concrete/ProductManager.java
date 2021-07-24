package app.northwind.business.concrete;

import app.northwind.business.abstracts.ProductService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.ProductDao;
import app.northwind.model.entity.concrete.Product;
import app.northwind.model.entity.concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }


    @Override
    public DataResult<List<Product>> getAll() {
        return new DataResult<List<Product>>(true, this.productDao.findAll());
    }

    @Override
    public DataResult<Product> getById(int id) {
        var bb = this.productDao.getOne(id);
        var a = new DataResult<Product>(true, this.productDao.getOne(id));
        var aa = new DataResult<Product>(true, this.productDao.getById(id));
        return new DataResult<Product>(true, this.productDao.getOne(id));
    }

    @Override
    public DataResult<Product> add(Product data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Product>(null);

        return new DataResult<Product>(true, "Successfully added.", this.productDao.save(data));
    }

    @Override
    public DataResult<List<Product>> addAll(List<Product> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Product>>(true, "Successfully added.", this.productDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Product> update(Product data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Product>(null);

        return new DataResult<Product>(true, "Successfully added.", this.productDao.save(data));
    }

    @Override
    public DataResult<List<Product>> updateAll(List<Product> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Product>>(null);

        return new DataResult<List<Product>>(true, "Successfully added.", this.productDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.productDao.getById(id))) {
                this.productDao.deleteById(id);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Product data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.productDao.getById(data.getId()))) {
                this.productDao.delete(data);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
