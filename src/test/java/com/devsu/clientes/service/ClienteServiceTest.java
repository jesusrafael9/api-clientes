package com.devsu.clientes.service;

import com.devsu.clientes.model.Cliente;
import com.devsu.clientes.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenGetAllClientes_thenReturnClienteList() {

        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        List<Cliente> expectedClientes = Arrays.asList(cliente1, cliente2);
        when(clienteRepository.findAll()).thenReturn(expectedClientes);

        List<Cliente> actualClientes = clienteService.getAllClientes();

        assertEquals(expectedClientes, actualClientes);
    }

    @Test
    void whenGetClienteById_thenReturnCliente() {

        Long id = 1L;
        Cliente expectedCliente = new Cliente();
        when(clienteRepository.findById(id)).thenReturn(Optional.of(expectedCliente));

        Optional<Cliente> actualCliente = clienteService.getClienteById(id);

        assertTrue(actualCliente.isPresent());
        assertEquals(expectedCliente, actualCliente.get());
    }

    @Test
    void whenSaveCliente_thenReturnSavedCliente() {

        Cliente clienteToSave = new Cliente();
        Cliente expectedCliente = new Cliente();
        when(clienteRepository.save(clienteToSave)).thenReturn(expectedCliente);

        Cliente actualCliente = clienteService.saveCliente(clienteToSave);

        assertEquals(expectedCliente, actualCliente);
    }

    @Test
    void whenDeleteCliente_thenVerifyDeletion() {

        Long id = 1L;
        doNothing().when(clienteRepository).deleteById(id);

        clienteService.deleteCliente(id);

        verify(clienteRepository, times(1)).deleteById(id);
    }
}