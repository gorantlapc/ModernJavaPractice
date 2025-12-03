package org.pc.exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AuditLogger implements AutoCloseable {
    private boolean closed = false;
    private BufferedWriter writer;

    public AuditLogger(String file) {
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            throw new RuntimeException("Unable to open file", e);
        }

    }

    public boolean write(String message) {
        try {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public void close() throws Exception {
        writer.flush();
        writer.close();
        closed = true;
    }

    public boolean isClosed() {
        return closed;
    }
}
