public class Libro
{
    
    int id; // Identificador o clave del libro
    String titulo;
    String autor;
    Genero genero;
    int    edicion;
    Libro siguiente;

    public Libro( int id, String titulo, String autor, Genero genero, int edicion)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.edicion = edicion;
        this.siguiente = null;
    }
    
    public String toString(){
        return titulo+", "+autor+", "+ genero +", "+ edicion + ".";
    }
}