package dominio;

public class Curso {

	private int id;
	private String nome;
	private int notaDificuldade;
	private int notaFlexibilidade;
	private int notaMercadoDeTrabalho;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNotaDificuldade() {
		return notaDificuldade;
	}
	public void setNotaDificuldade(int notaDificuldade) {
		this.notaDificuldade = notaDificuldade;
	}
	public int getNotaFlexibilidade() {
		return notaFlexibilidade;
	}
	public void setNotaFlexibilidade(int notaFlexibilidade) {
		this.notaFlexibilidade = notaFlexibilidade;
	}
	public int getNotaMercadoDeTrabalho() {
		return notaMercadoDeTrabalho;
	}
	public void setNotaMercadoDeTrabalho(int notaMercadoDeTrabalho) {
		this.notaMercadoDeTrabalho = notaMercadoDeTrabalho;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
