import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(
                "Biblioteca Central", "San José, Costa Rica"
        );

        Usuario usuario1 = new Usuario(
                "U001", "Sebastián", "sebas@gmail.com", "88888888"
        );

        Usuario usuario2 = new Usuario(
                "U002", "María", "maria@gmail.com", "87777777"
        );

        Libro libro1 = new Libro(
                "L001", "Clean Code", "Robert C. Martin", 2008
        );

        Libro libro2 = new Libro(
                "L002", "Effective Java", "Joshua Bloch", 2018
        );

        Libro libro3 = new Libro(
                "L003", "Design Patterns", "Erich Gamma", 1994
        );

        System.out.println("\n=== REGISTRO DE USUARIOS ===");
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        System.out.println("\n=== REGISTRO DE LIBROS ===");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        System.out.println("\n=== BÚSQUEDAS ===");
        System.out.println(biblioteca.buscarLibro("L001"));
        System.out.println(biblioteca.buscarUsuario("U001"));

        System.out.println("\n=== PRIMER PRÉSTAMO ===");

        Prestamo prestamo1 = new Prestamo(
                "P001",
                usuario1,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        DetallePrestamo detalle1 = new DetallePrestamo(libro1);
        DetallePrestamo detalle2 = new DetallePrestamo(libro2);

        System.out.println("Libro 1 agregado: " +
                prestamo1.agregarDetalle(detalle1));

        System.out.println("Libro 2 agregado: " +
                prestamo1.agregarDetalle(detalle2));

        System.out.println("Préstamo registrado: " +
                biblioteca.registrarPrestamo(prestamo1));

        System.out.println("\n=== BUSCAR PRÉSTAMO ===");
        System.out.println(biblioteca.buscarPrestamo("P001"));

        System.out.println("\n=== DEVOLUCIÓN ===");
        System.out.println("Primera devolución: " +
                detalle1.registrarDevolucion());

        System.out.println("Segunda devolución: " +
                detalle2.registrarDevolucion());

        System.out.println("\n=== SEGUNDO PRÉSTAMO ===");

        Prestamo prestamo2 = new Prestamo(
                "P002",
                usuario2,
                LocalDate.now(),
                LocalDate.now().plusDays(14)
        );

        DetallePrestamo detalle3 = new DetallePrestamo(libro1);

        System.out.println("Libro agregado: " +
                prestamo2.agregarDetalle(detalle3));

        System.out.println("Préstamo registrado: " +
                biblioteca.registrarPrestamo(prestamo2));

        System.out.println("\n=== ESTADO DE LA BIBLIOTECA ===");
        System.out.println(biblioteca);
    }
}