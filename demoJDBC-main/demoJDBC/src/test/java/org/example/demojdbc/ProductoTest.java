package org.example.demojdbc;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductoTest {

    @Autowired
    private ProductoRepository repo;

    @Test
    public void testInsertarYLeerProducto() {
        Producto p = new Producto(1, "Teclado", 29.99);
        repo.save(p);

        Optional<Producto> encontrado = repo.findById(1);
        assertTrue(encontrado.isPresent());
        assertEquals("Teclado", encontrado.get().getNombre());
    }

    @Test
    public void testActualizarProducto() {
        Producto p = new Producto(2, "Raton", 15.00);
        repo.save(p);

        p.setPrecio(17.50);
        repo.save(p);

        Producto actualizado = repo.findById(2).orElse(null);
        assertNotNull(actualizado);
        assertEquals(17.50, actualizado.getPrecio());
    }

    @Test
    public void testEliminarProducto() {
        Producto p = new Producto(3, "Monitor", 120.00);
        repo.save(p);

        repo.deleteById(3);

        boolean existe = repo.findById(3).isPresent();
        assertFalse(existe);
    }
}
