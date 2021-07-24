package app.northwind.business.concrete;

import app.northwind.business.abstracts.CategoryService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.CategoryDao;
import app.northwind.model.entity.concrete.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new DataResult<List<Category>>(true, this.categoryDao.findAll());
    }

    @Override
    public DataResult<Category> getById(int id) {
        return new DataResult<Category>(true, this.categoryDao.getById(id));
    }

    @Override
    public DataResult<Category> add(Category data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Category>(null);

        return new DataResult<Category>(true, "Successfully added.", this.categoryDao.save(data));
    }

    @Override
    public DataResult<List<Category>> addAll(List<Category> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Category>>(true, "Successfully added.", this.categoryDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Category> update(Category data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Category>(null);

        return new DataResult<Category>(true, "Successfully added.", this.categoryDao.save(data));
    }

    @Override
    public DataResult<List<Category>> updateAll(List<Category> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Category>>(null);

        return new DataResult<List<Category>>(true, "Successfully added.", this.categoryDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.categoryDao.getById(id))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Category data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.categoryDao.getById(data.getId()))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
