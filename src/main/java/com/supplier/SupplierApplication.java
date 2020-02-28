package com.supplier;

import com.supplier.TCPServer.TCPConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupplierApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class, args);
        TCPConnection tcp = new TCPConnection();
        tcp.startConnection();
    }

}
