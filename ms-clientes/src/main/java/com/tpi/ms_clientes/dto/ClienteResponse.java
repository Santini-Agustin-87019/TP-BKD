
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClienteResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Integer dni;
}