package app.northwind.business.concrete;

import app.northwind.business.abstracts.OrderService;
import app.northwind.core.extension.CommonExtension;
import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.ErrorDataResult;
import app.northwind.core.utilities.result.Result;
import app.northwind.dataAccess.abstracts.OrderDao;
import app.northwind.model.entity.concrete.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderManager implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public DataResult<List<Order>> getAll() {
        return new DataResult<List<Order>>(true, this.orderDao.findAll());
    }

    @Override
    public DataResult<Order> getById(int id) {
        return new DataResult<Order>(true, this.orderDao.getById(id));
    }

    @Override
    public DataResult<Order> add(Order data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Order>(null);

        return new DataResult<Order>(true, "Successfully added.", this.orderDao.save(data));
    }

    @Override
    public DataResult<List<Order>> addAll(List<Order> data) {
        if (data.stream().count() > 0) {
            return new DataResult<List<Order>>(true, "Successfully added.", this.orderDao.saveAll(data));
        }
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<Order> update(Order data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<Order>(null);

        return new DataResult<Order>(true, "Successfully added.", this.orderDao.save(data));
    }

    @Override
    public DataResult<List<Order>> updateAll(List<Order> data) {
        if (CommonExtension.IsNull(data)) return new ErrorDataResult<List<Order>>(null);

        return new DataResult<List<Order>>(true, "Successfully added.", this.orderDao.saveAll(data));
    }

    @Override
    public Result delete(int id) {
        if (CommonExtension.IsNotNull(id)) {
            if (CommonExtension.IsNotNull(this.orderDao.getById(id))) {
                this.orderDao.deleteById(id);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result delete(Order data) {
        if (CommonExtension.IsNotNull(data)) {
            if (CommonExtension.IsNotNull(this.orderDao.getById(data.getId()))) {
                this.orderDao.delete(data);
                return new Result(true, "Successfully deleted.");
            }
        }
        return new ErrorDataResult(null);
    }
}
