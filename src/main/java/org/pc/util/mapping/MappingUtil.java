package org.pc.util.mapping;

import java.util.List;

public class MappingUtil {

    static void main() {
        List<User> users = List.of(
                new User("Alice", "pc@gmail.com", "Engineering"),
                new User("Bob", "gp@gmail.com", "Marketing"),
                new User("Charlie", "ar@gmail.com", "Engineering")
        );

        List<UserDto> list = users.stream().map(UserDto::new).toList();
        list.forEach(System.out::println);

    }
}
