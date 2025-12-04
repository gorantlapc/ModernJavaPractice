package org.pc.util.mapping;

import java.util.List;
import java.util.Optional;

public class MappingUtil {
    public static Optional<List<UserDto>> mapToDtos(List<User> users) {
        if (users == null) {
            throw new RuntimeException("Users list must not be empty");
        }
        List<UserDto> list = users.stream().map(UserDto::new).toList();
        return Optional.of(list);
    }
}
