public class Estudiante extends Usuario {
    
    private String carnet;
    private String carrera;

    public Estudiante(String idUsuario, String nombre, String correo, String telefono, String carnet, String carrera) {
        super(idUsuario, nombre, correo, telefono);
        this.carnet = carnet;
        this.carrera = carrera;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}