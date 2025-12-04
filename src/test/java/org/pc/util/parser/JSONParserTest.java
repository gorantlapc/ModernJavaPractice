package org.pc.util.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.pc.util.dtos.Order;
import org.pc.util.dtos.Student;
import org.pc.util.dtos.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class JSONParserTest {
    JSONParser parser = new JSONParser();

    @Test
    void readJson() throws IOException {
        List<User> users = parser.readJson("users.json", User.class);
        assertNotNull(users);
        assertEquals(20, users.size());
        List<Order> orders = parser.readJson("orders.json", Order.class);
        assertNotNull(orders);
        assertEquals(3, orders.size());
        Exception ex = assertThrows(IOException.class, () -> parser.readJson("order.json", Order.class));
        assertEquals("File not found: order.json", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"classA","classB","classC"})
    void readJsonToMap(String key) {
        try {
            Map<String, List<Student>> stringListMap = parser.readJsonToMap("students.json", Student.class);
            assertNotNull(stringListMap);
            assertEquals(3, stringListMap.size());
            assertTrue(stringListMap.keySet().contains(key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}