package app.northwind.business.concrete;

import app.northwind.business.abstracts.RegionService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.RegionDao;
import app.northwind.model.entity.concrete.Region;
import app.northwind.model.entity.concrete.Region;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegionManager implements RegionService {

    private RegionDao regionDao;

    @Autowired
    public RegionManager(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public DataResult<List<Region>> getAll() {
        return new DataResult<List<Region>>(true, this.regionDao.findAll());
    }

    @Override
    public DataResult<Region> getById(int id) {
        return new DataResult<Region>(true, this.regionDao.getById(id));
    }

    @Override
    public DataResult<Region> add(Region data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Region>(null);

        return new DataResult<Region>(true, "Successfully added.", this.regionDao.save(data));
    }

    @Override
    public DataResult<List<Region>> addAll(List<Region> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Region>>(true, "Successfully added.", this.regionDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Region> update(Region data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Region>(null);

        return new DataResult<Region>(true, "Successfully added.", this.regionDao.save(data));
    }

    @Override
    public DataResult<List<Region>> updateAll(List<Region> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Region>>(null);

        return new DataResult<List<Region>>(true, "Successfully added.", this.regionDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.regionDao.getById(id))) {
                this.regionDao.deleteById(id);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Region data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.regionDao.getById(data.getId()))) {
                this.regionDao.delete(data);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
