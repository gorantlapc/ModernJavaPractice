package org.pc.util.mapping;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MappingUtilTest {

    private static List<User> users;

    @BeforeAll
    static void setUp() {
        users = List.of(
                new User("Alice", "pc@gmail.com", "Engineering"),
                new User("Bob", "gp@gmail.com", "Marketing"),
                new User("Charlie", "ar@gmail.com", "Engineering")
        );
    }

    @Test
    void mapToDtos() {
        Optional<List<UserDto>> userDtos = MappingUtil.mapToDtos(users);
        assertTrue(userDtos.isPresent());
        assertEquals(3, userDtos.get().size());
        assertEquals("Alice", userDtos.get().getFirst().username());
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> MappingUtil.mapToDtos(null));
        assertEquals("Users list must not be empty", runtimeException.getMessage());

    }
}