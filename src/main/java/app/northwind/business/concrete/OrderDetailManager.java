package app.northwind.business.concrete;

import app.northwind.business.abstracts.OrderDetailService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.OrderDetailDao;
import app.northwind.model.entity.concrete.Category;
import app.northwind.model.entity.concrete.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailManager implements OrderDetailService {

    private OrderDetailDao orderDetailDao;

    @Autowired
    public OrderDetailManager(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    @Override
    public DataResult<List<OrderDetail>> getAll() {
        return new DataResult<List<OrderDetail>>(true, this.orderDetailDao.findAll());
    }

    @Override
    public DataResult<OrderDetail> getById(int id) {
        return new DataResult<OrderDetail>(true, this.orderDetailDao.getById(id));
    }

    @Override
    public DataResult<OrderDetail> add(OrderDetail data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<OrderDetail>(null);

        return new DataResult<OrderDetail>(true, "Successfully added.", this.orderDetailDao.save(data));
    }

    @Override
    public DataResult<List<OrderDetail>> addAll(List<OrderDetail> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<OrderDetail>>(true, "Successfully added.", this.orderDetailDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<OrderDetail> update(OrderDetail data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<OrderDetail>(null);

        return new DataResult<OrderDetail>(true, "Successfully added.", this.orderDetailDao.save(data));
    }

    @Override
    public DataResult<List<OrderDetail>> updateAll(List<OrderDetail> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<OrderDetail>>(null);

        return new DataResult<List<OrderDetail>>(true, "Successfully added.", this.orderDetailDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.orderDetailDao.getById(id))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(OrderDetail data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.orderDetailDao.getById(data.getId()))) {
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
