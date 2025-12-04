package org.pc.util.mapping;

public record UserDto(String username, String email, String role) {

    public UserDto(User user) {
        this(user.getName(),
                user.getEmail(),
                user.getRole());
    }
}
