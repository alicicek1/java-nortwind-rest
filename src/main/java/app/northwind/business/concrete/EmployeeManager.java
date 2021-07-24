package app.northwind.business.concrete;

import app.northwind.business.abstracts.EmployeeService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.EmployeeDao;
import app.northwind.model.entity.concrete.Category;
import app.northwind.model.entity.concrete.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new DataResult<List<Employee>>(true, this.employeeDao.findAll());
    }

    @Override
    public DataResult<Employee> getById(int id) {
        return new DataResult<Employee>(true, this.employeeDao.getById(id));
    }

    @Override
    public DataResult<Employee> add(Employee data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Employee>(null);

        return new DataResult<Employee>(true, "Successfully added.", this.employeeDao.save(data));
    }

    @Override
    public DataResult<List<Employee>> addAll(List<Employee> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Employee>>(true, "Successfully added.", this.employeeDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Employee> update(Employee data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Employee>(null);

        return new DataResult<Employee>(true, "Successfully added.", this.employeeDao.save(data));
    }

    @Override
    public DataResult<List<Employee>> updateAll(List<Employee> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Employee>>(null);

        return new DataResult<List<Employee>>(true, "Successfully added.", this.employeeDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.employeeDao.getById(id))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Employee data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.employeeDao.getById(data.getId()))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
