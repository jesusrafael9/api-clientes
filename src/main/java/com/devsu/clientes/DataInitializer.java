package com.devsu.clientes;

import com.devsu.clientes.model.Cliente;
import com.devsu.clientes.model.Persona;
import com.devsu.clientes.repository.ClienteRepository;
import com.devsu.clientes.repository.PersonaRepository;
import com.devsu.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class DataInitializer {

    @Value("${app.insertarDatos}")
    private boolean insertarDatos;

    @Autowired
    private ClienteService clienteService;

    @Bean
    public CommandLineRunner loadData(PersonaRepository personaRepository, ClienteRepository clienteRepository) {
        return args -> {
            if (insertarDatos) {

                Persona persona1 = new Persona();
                persona1.setIdentificacion("1234567890");
                persona1.setNombre("Juan");
                persona1.setEdad(25);
                persona1.setGenero("Masculino");
                persona1.setDireccion("Calle 123");
                persona1.setTelefono("1234567890");

                Cliente cliente1 = new Cliente();
                cliente1.setPersona(persona1);
                cliente1.setId(1L);
                cliente1.setEmail("juan@devsu.com");
                cliente1.setContrasena("123");
                cliente1.setEstado("True");

                Optional<Cliente> existingCliente1 = clienteService.getClienteById(cliente1.getId());
                if (existingCliente1.isEmpty()) {
                    clienteRepository.save(cliente1);
                }

                Persona persona2 = new Persona();
                persona2.setIdentificacion("0987654321");
                persona2.setNombre("Maria");
                persona2.setEdad(30);
                persona2.setGenero("Femenino");
                persona2.setDireccion("Avenida 456");
                persona2.setTelefono("0987654321");

                Cliente cliente2 = new Cliente();
                cliente2.setId(2L);
                cliente2.setPersona(persona2);
                cliente2.setEmail("maria@devsu.com");
                cliente2.setContrasena("456");
                cliente2.setEstado("True");

                Optional<Cliente> existingCliente2 = clienteService.getClienteById(cliente2.getId());
                if (existingCliente2.isEmpty()) {
                    clienteRepository.save(cliente2);
                }

                Persona persona3 = new Persona();
                persona3.setIdentificacion("1122334455");
                persona3.setNombre("Carlos");
                persona3.setEdad(35);
                persona3.setGenero("Masculino");
                persona3.setDireccion("Boulevard 789");
                persona3.setTelefono("1122334455");

                Cliente cliente3 = new Cliente();
                cliente3.setId(3L);
                cliente3.setPersona(persona3);
                cliente3.setEmail("carlos@devsu.com");
                cliente3.setContrasena("789");
                cliente3.setEstado("True");

                Optional<Cliente> existingCliente3 = clienteService.getClienteById(cliente3.getId());
                if (existingCliente3.isEmpty()) {
                    clienteRepository.save(cliente3);
                }
            }
        };
    }
}
