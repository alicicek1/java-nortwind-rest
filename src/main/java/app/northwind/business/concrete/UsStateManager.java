package app.northwind.business.concrete;

import app.northwind.business.abstracts.UsStatesService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.UsStatesDao;
import app.northwind.model.entity.concrete.UsStates;
import app.northwind.model.entity.concrete.UsStates;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsStateManager implements UsStatesService {

    private UsStatesDao usStatesDao;

    @Autowired
    public UsStateManager(UsStatesDao usStatesDao) {
        this.usStatesDao = usStatesDao;
    }

    @Override
    public DataResult<List<UsStates>> getAll() {
        return new DataResult<List<UsStates>>(true, this.usStatesDao.findAll());
    }

    @Override
    public DataResult<UsStates> getById(int id) {
        return new DataResult<UsStates>(true, this.usStatesDao.getById(id));
    }

    @Override
    public DataResult<UsStates> add(UsStates data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<UsStates>(null);

        return new DataResult<UsStates>(true, "Successfully added.", this.usStatesDao.save(data));
    }

    @Override
    public DataResult<List<UsStates>> addAll(List<UsStates> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<UsStates>>(true, "Successfully added.", this.usStatesDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<UsStates> update(UsStates data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<UsStates>(null);

        return new DataResult<UsStates>(true, "Successfully added.", this.usStatesDao.save(data));
    }

    @Override
    public DataResult<List<UsStates>> updateAll(List<UsStates> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<UsStates>>(null);

        return new DataResult<List<UsStates>>(true, "Successfully added.", this.usStatesDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.usStatesDao.getById(id))) {
                this.usStatesDao.deleteById(id);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(UsStates data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.usStatesDao.getById(data.getId()))) {
                this.usStatesDao.delete(data);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
