package generics;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class GenericDAO<T, PK extends Serializable> implements IGenericDAO<T, PK>{

	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public GenericDAO(){
		ParameterizedType c = (ParameterizedType) getClass().getGenericSuperclass();
		type = (Class<T>) c.getActualTypeArguments()[0];
		System.out.println(type.getName());
	}
	@Override
	public T save(T entity) {
		return null;
	}

}
