package app.northwind.business.concrete;

import app.northwind.business.abstracts.TerritoryService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.TerritoryDao;
import app.northwind.model.entity.concrete.Territory;
import app.northwind.model.entity.concrete.Territory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TerritoryManager implements TerritoryService {

    private TerritoryDao territoryDao;

    @Autowired
    public TerritoryManager(TerritoryDao territoryDao) {
        this.territoryDao = territoryDao;
    }

    @Override
    public DataResult<List<Territory>> getAll() {
        return new DataResult<List<Territory>>(true, this.territoryDao.findAll());
    }

    @Override
    public DataResult<Territory> getById(int id) {
        return new DataResult<Territory>(true, this.territoryDao.getById(id));
    }

    @Override
    public DataResult<Territory> add(Territory data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Territory>(null);

        return new DataResult<Territory>(true, "Successfully added.", this.territoryDao.save(data));
    }

    @Override
    public DataResult<List<Territory>> addAll(List<Territory> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Territory>>(true, "Successfully added.", this.territoryDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Territory> update(Territory data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Territory>(null);

        return new DataResult<Territory>(true, "Successfully added.", this.territoryDao.save(data));
    }

    @Override
    public DataResult<List<Territory>> updateAll(List<Territory> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Territory>>(null);

        return new DataResult<List<Territory>>(true, "Successfully added.", this.territoryDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.territoryDao.getById(id))) {
                this.territoryDao.deleteById(id);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Territory data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.territoryDao.getById(data.getId()))) {
                this.territoryDao.delete(data);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
