package org.pc.util.mapping;

public class UserDto {
    private String username;
    private String email;
    private String role;

    public UserDto(String name, String email, String role) {
        this.username = name;
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    public UserDto(User user) {
        this(user.getName(),
            user.getEmail(),
            user.getRole());
    }
}
