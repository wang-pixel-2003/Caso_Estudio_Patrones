package Backend.Model.Libro;

public class Libro {

    private int idLibro;
    private int estado;
    private String titulo;
    private String autor;
    private String categoria;
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Libro(){


    }
    public Libro(String titulo){
        this.titulo = titulo;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(int idLibro, int estado,String titulo, String autor, String categoria) {
        this.idLibro=idLibro;
        this.estado=estado;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    /***
     * Sobre escribe la informacion y retorna el libro
     * @return
     */

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", estado=" + estado +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
