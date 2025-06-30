package com.optimumtech.api_payment;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.optimumtech.api_payment.models.entities.Payment;
import com.optimumtech.api_payment.repositories.PaymentRepository;
import com.optimumtech.api_payment.services.CourseClient;
import com.optimumtech.api_payment.services.PaymentService;
import com.optimumtech.api_payment.services.UserClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class PaymentServiceTest {
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private UserClient userClient;
    @Mock
    private CourseClient courseClient;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerTodos() {
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        when(paymentRepository.findAll()).thenReturn(Arrays.asList(payment1, payment2));

        List<Payment> result = paymentService.obtenerTodos();
        assertEquals(2, result.size());
        verify(paymentRepository, times(1)).findAll();
    }
}
