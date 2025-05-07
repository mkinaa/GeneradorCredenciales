import java.time.LocalDate;

public class CredencialPrototype implements Cloneable {
    private String nombre;
    private String cargo;
    private String rut;
    private LocalDate fecha_caducidad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public LocalDate getFechaCaducidad() {
        return fecha_caducidad;
    }

    public void setFechaCaducidad(LocalDate fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    @Override
    public CredencialPrototype clone() {
        try {
            CredencialPrototype copia = (CredencialPrototype) super.clone();
    
            copia.nombre = this.nombre;
            copia.cargo = this.cargo;
            copia.rut = this.rut;
            copia.fecha_caducidad = this.fecha_caducidad != null
                ? LocalDate.of(this.fecha_caducidad.getYear(),
                               this.fecha_caducidad.getMonthValue(),
                               this.fecha_caducidad.getDayOfMonth())
                : null;
    
            return copia;
        } catch (CloneNotSupportedException e) {
            System.out.println("Error al clonar la credencial");
            return null;
        }
    }
    
}

