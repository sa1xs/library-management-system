import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    
    private String nombre;
    private String direccion;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca(String nombre, String direccion, List<Libro> libros, List<Usuario> usuarios, List<Prestamo> prestamos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
