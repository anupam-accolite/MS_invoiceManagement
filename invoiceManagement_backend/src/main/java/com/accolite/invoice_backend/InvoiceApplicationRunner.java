package com.accolite.invoice_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.accolite.invoice_backend.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class InvoiceApplicationRunner {

    public static void main(final String[] args) {
        SpringApplication.run(InvoiceApplicationRunner.class, args);
    }
}
