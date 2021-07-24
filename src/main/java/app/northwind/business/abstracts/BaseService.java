package app.northwind.business.abstracts;

import app.northwind.core.utilities.result.DataResult;
import app.northwind.core.utilities.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {

    DataResult<List<T>> getAll();

    DataResult<T> getById(int id);

    DataResult<T> add(T date);

    DataResult<List<T>> addAll(List<T> data);

    DataResult<T> update(T data);

    DataResult<List<T>> updateAll(List<T> data);

    Result delete(int id);

    Result delete(T data);

}
