import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    
    private String idPrestamo;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private List<DetallePrestamo> detalles;

    public Prestamo(String idPrestamo, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaLimite, List<DetallePrestamo> detalles) {
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
}
