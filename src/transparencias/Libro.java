package transparencias;

public class Libro {
	String titulo;
	String autor;
	String editorial;
	int pagina;
	int AñoPublicacion;
	public Libro(String titulo, String autor, String editorial, int pagina, int añoPublicacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.pagina = pagina;
		AñoPublicacion = añoPublicacion;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", pagina=" + pagina
				+ ", AñoPublicacion=" + AñoPublicacion + "]\n";
	}

	
}
