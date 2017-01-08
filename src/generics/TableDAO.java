package generics;

public class TableDAO extends GenericDAO<TableEntity, String>{

	public static void main(String[] args) {
		TableDAO d = new TableDAO();
		TableEntity entity = new TableEntity();
		d.save(entity);
	}

}
