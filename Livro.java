package biblioteca;

public class Livro  extends Base{
	private String nome;
	private String author;
	
	public Livro() {}
	
	public Livro(int id) {
		super(id);
	}

	
	public Livro(int id, String nome, String author) {
		super(id);
		this.nome = nome;
		this.author = author;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
