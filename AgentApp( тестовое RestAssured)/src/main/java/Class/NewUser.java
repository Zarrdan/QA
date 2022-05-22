package Class;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class NewUser {
    @NonNull
    private String username;
    private String password;

}
