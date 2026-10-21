import java.time.LocalDate;

public class DetallePrestamo {

    private Libro libro;
    private LocalDate fechaDevolucion;

    public DetallePrestamo(Libro libro) {
        this.libro = libro;
        this.fechaDevolucion = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Detalle del préstamo:" +
                "\nLibro: " + libro.getTitulo() +
                "\nFecha de devolución: " +
                (fechaDevolucion == null ? "Pendiente" : fechaDevolucion);
    }

    public boolean registrarDevolucion() {

        if (fechaDevolucion != null) {
            System.out.println("Este libro ya fue devuelto.");
            return false;
        }
        
        if (!libro.devolver()) {
            System.out.println("No se pudo devolver el libro.");
            return false;
        }

        fechaDevolucion = LocalDate.now();

        System.out.println("El libro fue devuelto correctamente.");
        return true;
    }
}
