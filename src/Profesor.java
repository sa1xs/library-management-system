public class Profesor extends Usuario {
    
    private String numeroEmpleado;
    private String departamento;

    public Profesor(String idUsuario, String nombre, String correo, String telefono, String numeroEmpleado, String departamento) {
        super(idUsuario, nombre, correo, telefono);
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
