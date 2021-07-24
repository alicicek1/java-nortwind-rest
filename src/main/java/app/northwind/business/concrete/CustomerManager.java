package app.northwind.business.concrete;

import app.northwind.business.abstracts.CustomerService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.CustomerDao;
import app.northwind.model.entity.concrete.Category;
import app.northwind.model.entity.concrete.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public DataResult<List<Customer>> getAll() {
        return new DataResult<List<Customer>>(true, this.customerDao.findAll());
    }

    @Override
    public DataResult<Customer> getById(int id) {
        return new DataResult<Customer>(true, this.customerDao.getById(id));
    }

    @Override
    public DataResult<Customer> add(Customer data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Customer>(null);

        return new DataResult<Customer>(true, "Successfully added.", this.customerDao.save(data));
    }

    @Override
    public DataResult<List<Customer>> addAll(List<Customer> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Customer>>(true, "Successfully added.", this.customerDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Customer> update(Customer data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Customer>(null);

        return new DataResult<Customer>(true, "Successfully added.", this.customerDao.save(data));
    }

    @Override
    public DataResult<List<Customer>> updateAll(List<Customer> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Customer>>(null);

        return new DataResult<List<Customer>>(true, "Successfully added.", this.customerDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.customerDao.getById(id))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Customer data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.customerDao.getById(data.getId()))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
