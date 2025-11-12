import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class ClienteRequest {
    // Long idUsuario; // si luego validás contra ms-referenciales
    @NotBlank private String nombre;
    @NotBlank private String apellido;
    @Email @NotBlank private String email;
    private String telefono;
    @Past private java.util.Date fechaDeNacimiento;
    @NotNull private Integer dni;
}
