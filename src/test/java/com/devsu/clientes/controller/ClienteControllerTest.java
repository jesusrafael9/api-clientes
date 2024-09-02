package com.devsu.clientes.controller;

import com.devsu.clientes.model.Cliente;
import com.devsu.clientes.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenGetAllClientes_thenReturnClienteList() {

        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        List<Cliente> expectedClientes = Arrays.asList(cliente1, cliente2);
        when(clienteService.getAllClientes()).thenReturn(expectedClientes);

        List<Cliente> actualClientes = clienteController.getAllClientes();

        assertEquals(expectedClientes, actualClientes);
    }

    @Test
    void whenGetClienteById_thenReturnCliente() {

        Long id = 1L;
        Cliente expectedCliente = new Cliente();
        when(clienteService.getClienteById(id)).thenReturn(Optional.of(expectedCliente));

        ResponseEntity<Cliente> response = clienteController.getClienteById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCliente, response.getBody());
    }

    @Test
    void whenCreateCliente_thenReturnCreatedCliente() {

        Cliente clienteToCreate = new Cliente();
        Cliente expectedCliente = new Cliente();
        when(clienteService.saveCliente(clienteToCreate)).thenReturn(expectedCliente);

        Cliente actualCliente = clienteController.createCliente(clienteToCreate);

        assertEquals(expectedCliente, actualCliente);
    }

    @Test
    void whenUpdateCliente_thenReturnUpdatedCliente() {

        Long id = 1L;
        Cliente clienteDetails = new Cliente();
        Cliente existingCliente = new Cliente();
        Cliente updatedCliente = new Cliente();
        when(clienteService.getClienteById(id)).thenReturn(Optional.of(existingCliente));
        when(clienteService.saveCliente(existingCliente)).thenReturn(updatedCliente);

        ResponseEntity<Cliente> response = clienteController.updateCliente(id, clienteDetails);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCliente, response.getBody());
    }

    @Test
    void whenDeleteCliente_thenVerifyDeletion() {

        Long id = 1L;
        doNothing().when(clienteService).deleteCliente(id);

        ResponseEntity<Void> response = clienteController.deleteCliente(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(clienteService, times(1)).deleteCliente(id);
    }
}