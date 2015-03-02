package generics;

import java.io.Serializable;

public interface IGenericDAO<T, PK extends Serializable> {
	T save(T entity);
}
