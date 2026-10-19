import java.time.LocalDate;

public class DetallePrestamo {
    
    private Libro libro;
    private LocalDate fechaDevolucion;

    public DetallePrestamo(Libro libro, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.fechaDevolucion = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}
