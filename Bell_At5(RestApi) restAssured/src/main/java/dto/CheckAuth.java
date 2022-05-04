package dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CheckAuth {
    @NonNull
    private String email;
    private String password;
}
