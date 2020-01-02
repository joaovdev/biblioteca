package biblioteca;

public class Main {

	public static void main(String[] args) throws Exception {
		Factory factory = new Factory();
		Dao daoBd = factory.getDao(Livro.class, "Bd");
		daoBd.insert(new Livro(2,"Harry poter","Blubli"));
		
	}
}
