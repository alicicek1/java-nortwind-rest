package app.northwind.business.concrete;

import app.northwind.business.abstracts.EmployeeTerritoryService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.EmployeeTerritoryDao;
import app.northwind.model.entity.concrete.EmployeeTerritory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeTerritoryManager implements EmployeeTerritoryService {

    private EmployeeTerritoryDao employeeTerritoryDao;

    @Autowired
    public EmployeeTerritoryManager(EmployeeTerritoryDao employeeTerritoryDao) {
        this.employeeTerritoryDao = employeeTerritoryDao;
    }

    @Override
    public DataResult<List<EmployeeTerritory>> getAll() {
        return new DataResult<List<EmployeeTerritory>>(true, this.employeeTerritoryDao.findAll());
    }

    @Override
    public DataResult<EmployeeTerritory> getById(int id) {
        return new DataResult<EmployeeTerritory>(true, this.employeeTerritoryDao.getById(id));
    }

    @Override
    public DataResult<EmployeeTerritory> add(EmployeeTerritory data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<EmployeeTerritory>(null);

        return new DataResult<EmployeeTerritory>(true, "Successfully added.", this.employeeTerritoryDao.save(data));
    }

    @Override
    public DataResult<List<EmployeeTerritory>> addAll(List<EmployeeTerritory> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<EmployeeTerritory>>(true, "Successfully added.", this.employeeTerritoryDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<EmployeeTerritory> update(EmployeeTerritory data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<EmployeeTerritory>(null);

        return new DataResult<EmployeeTerritory>(true, "Successfully added.", this.employeeTerritoryDao.save(data));
    }

    @Override
    public DataResult<List<EmployeeTerritory>> updateAll(List<EmployeeTerritory> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<EmployeeTerritory>>(null);

        return new DataResult<List<EmployeeTerritory>>(true, "Successfully added.", this.employeeTerritoryDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.employeeTerritoryDao.getById(id))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(EmployeeTerritory data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.employeeTerritoryDao.getById(data.getId()))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
