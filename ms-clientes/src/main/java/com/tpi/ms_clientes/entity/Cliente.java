import lombok.*;
import jakarta.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @Email
    @NotBlank
    private String email;

    private String telefono;
    @Past
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @NotNull
    private int dni;

    private Boolean activo;
    
     @PrePersist
    public void prePersist() {
        this.fechaCreacion = new Date();
        if (this.activo == null) this.activo = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = new Date();
    }

}
