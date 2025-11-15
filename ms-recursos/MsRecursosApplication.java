//
// ¡ESTE ES EL ARREGLO DEFINITIVO!
//
package com.tpi.ms_recursos; // El paquete CON guión bajo

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; // 1. Importamos esto

@SpringBootApplication
//
// 2. AGREGAMOS ESTA ANOTACIÓN:
// Le decimos a Spring que escanee AMBOS paquetes.
//
@ComponentScan(basePackages = {
    "com.tpi.ms_recursos",  // El paquete principal (CON guión bajo)
    "com.tpi.msrecursos"    // El paquete "viejo" (SIN guión bajo)
})
public class MsRecursosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRecursosApplication.class, args);
    }
}