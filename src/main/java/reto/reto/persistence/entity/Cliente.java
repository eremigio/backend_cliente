package reto.reto.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cliente")
public class Cliente {

    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="fechanacimiento")
    private String fechanacimiento;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechafallecimiento() {
        return fechafallecimiento;
    }

    public void setFechafallecimiento(Date fechafallecimiento) {
        this.fechafallecimiento = fechafallecimiento;
    }
    @Transient
    public Date fechafallecimiento;

}
