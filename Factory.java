package biblioteca;

public class Factory {
	@SuppressWarnings("static-access")
	public Dao getDao(Class<?> klass, String type) throws Exception {
		Class<?> forName = klass.forName(klass.getName() + type);
		return (Dao) forName.newInstance();
	}

}
