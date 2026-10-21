import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {

    private String idPrestamo;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private List<DetallePrestamo> detalles;

    public Prestamo(String idPrestamo, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaLimite) {
        this.idPrestamo = idPrestamo;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.detalles = new ArrayList<>();
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public List<DetallePrestamo> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "Préstamo:" +
                "\nID: " + idPrestamo +
                "\nUsuario: " + usuario.getNombre() +
                "\nFecha de préstamo: " + fechaPrestamo +
                "\nFecha límite: " + fechaLimite +
                "\nCantidad de libros: " + detalles.size();
    }

    public boolean agregarDetalle(DetallePrestamo detalle) {
        if (detalle == null || detalle.getLibro() == null) {
            System.out.println("No se puede agregar un detalle de préstamo sin datos.");
            return false;
        }

        for (DetallePrestamo detalleRegistrado : detalles) {
            if (detalleRegistrado.getLibro().getIdLibro()
                    .equals(detalle.getLibro().getIdLibro())) {

                System.out.println("El libro ya está registrado en el préstamo.");
                return false;
            }
        }

        if (detalle.getLibro().isDisponible()) {
            System.out.println("El libro está disponible");
        } else {
            System.out.println("El libro no está disponible");
            return false;
        }

        if (!detalle.getLibro().prestar()) {
            System.out.println("No se pudo prestar el libro.");
            return false;
        }
        detalles.add(detalle);
        return true;
    }
}
