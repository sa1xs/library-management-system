import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nombre;
    private String direccion;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca(String nombre, String direccion) {
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

    @Override
    public String toString() {
        return "Biblioteca:" +
                "\nNombre: " + nombre +
                "\nDirección: " + direccion +
                "\nCantidad de libros: " + libros.size() +
                "\nCantidad de usuarios: " + usuarios.size() +
                "\nCantidad de préstamos: " + prestamos.size();
    }

    public void agregarLibro(Libro libro) {
        if (libro == null) {
            System.out.println("No se puede agregar un libro sin datos a la biblioteca.");
            return;
        }
        for (Libro libroRegistrado : libros) {
            if (libroRegistrado.getIdLibro().equals(libro.getIdLibro())) {
                System.out.println("El libro con ID " + libro.getIdLibro() + " ya existe en la biblioteca.");
                return;
            }
        }
        libros.add(libro);
        System.out.println("El libro con ID " + libro.getIdLibro() + " fue agregado a la biblioteca.");
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            System.out.println("No se puede registrar un usuario sin datos en la biblioteca.");
            return;
        }
        for (Usuario usuarioRegistrado : usuarios) {
            if (usuarioRegistrado.getIdUsuario().equals(usuario.getIdUsuario())) {
                System.out.println(
                        "El usuario con ID " + usuario.getIdUsuario() + " ya está registrado en la biblioteca.");
                return;
            }
        }
        usuarios.add(usuario);
        System.out.println("El usuario con ID " + usuario.getIdUsuario() + " fue registrado en la biblioteca.");
    }

    public Libro buscarLibro(String idLibro) {
        if (idLibro == null) {
            System.out.println("No se puede buscar un libro sin ID.");
            return null;
        }
        for (Libro libro : libros) {
            if (libro.getIdLibro().equals(idLibro)) {
                System.out.println("Se encontró un libro con ID " + idLibro + " en la biblioteca.");
                return libro;
            }
        }
        System.out.println("No se encontró un libro con ID " + idLibro + " en la biblioteca.");
        return null;
    }

    public Usuario buscarUsuario(String idUsuario) {
        if (idUsuario == null) {
            System.out.println("No se puede buscar un usuario sin ID.");
            return null;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                System.out.println("Se encontró un usuario con ID " + idUsuario + " en la biblioteca.");
                return usuario;
            }
        }
        System.out.println("No se encontró un usuario con ID " + idUsuario + " en la biblioteca.");
        return null;
    }

    public Prestamo buscarPrestamo(String idPrestamo) {
        if (idPrestamo == null || idPrestamo.isBlank()) {
            System.out.println("No se puede buscar un préstamo sin ID.");
            return null;
        }

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdPrestamo().equals(idPrestamo)) {
                System.out.println("Se encontró el préstamo con ID " + idPrestamo);
                return prestamo;
            }
        }

        System.out.println("No se encontró un préstamo con ID " + idPrestamo);
        return null;
    }

    public boolean registrarPrestamo(Prestamo prestamo) {

        if (prestamo == null ||
                prestamo.getIdPrestamo() == null ||
                prestamo.getIdPrestamo().isBlank() ||
                prestamo.getUsuario() == null ||
                prestamo.getUsuario().getIdUsuario() == null) {

            System.out.println("Los datos del préstamo no son válidos.");
            return false;
        }

        for (Prestamo prestamoRegistrado : prestamos) {
            if (prestamoRegistrado.getIdPrestamo().equals(prestamo.getIdPrestamo())) {
                System.out.println("El préstamo ya existe en la biblioteca.");
                return false;
            }
        }

        Usuario usuarioRegistrado = buscarUsuario(prestamo.getUsuario().getIdUsuario());

        if (usuarioRegistrado != prestamo.getUsuario()) {
            System.out.println("El usuario no está registrado en la biblioteca.");
            return false;
        }

        if (prestamo.getFechaPrestamo() == null ||
                prestamo.getFechaLimite() == null ||
                prestamo.getFechaLimite().isBefore(prestamo.getFechaPrestamo())) {

            System.out.println("Las fechas del préstamo no son válidas.");
            return false;
        }

        if (prestamo.getDetalles().isEmpty()) {
            System.out.println("El préstamo debe contener al menos un libro.");
            return false;
        }

        for (DetallePrestamo detalle : prestamo.getDetalles()) {

            if (detalle == null || detalle.getLibro() == null ||
                    detalle.getLibro().getIdLibro() == null) {
                System.out.println("El préstamo contiene un detalle inválido.");
                return false;
            }

            Libro libroRegistrado = buscarLibro(detalle.getLibro().getIdLibro());

            if (libroRegistrado != detalle.getLibro()) {
                System.out.println("El libro no pertenece al catálogo de la biblioteca.");
                return false;
            }

            if (detalle.getLibro().isDisponible()) {
                System.out.println("El libro todavía no fue marcado como prestado.");
                return false;
            }
        }

        prestamos.add(prestamo);

        System.out.println("El préstamo con ID " + prestamo.getIdPrestamo()
                + " fue registrado correctamente.");

        return true;
    }

}
