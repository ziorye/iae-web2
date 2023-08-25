package day0825;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class User {
    Long id;
    String name;
    String email;
    String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
