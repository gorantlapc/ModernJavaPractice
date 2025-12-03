package org.pc.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AuditLoggerTest {

    @Test
    void write() throws Exception {
        AuditLogger logger;
        try (AuditLogger resource = new AuditLogger("audit.log")) {
            logger = resource;
            boolean isWrite = logger.write("writing message to resource file");
            assertTrue(isWrite);
        }
        assertTrue(logger.isClosed());

    }
}