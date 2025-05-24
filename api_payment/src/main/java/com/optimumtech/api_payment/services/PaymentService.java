package com.optimumtech.api_payment.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.optimumtech.api_payment.models.entities.Payment;
import com.optimumtech.api_payment.models.requests.PaymentCreate;
import com.optimumtech.api_payment.models.requests.PaymentResponse;
import com.optimumtech.api_payment.models.requests.PaymentUpdate;
import com.optimumtech.api_payment.models.requests.UserResponse;
import com.optimumtech.api_payment.repositories.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserClient userClient;

    // Constructor para inyección de dependencias
    @Autowired
    public PaymentService(PaymentRepository paymentRepository, UserClient userClient) {
        this.paymentRepository = paymentRepository;
        this.userClient = userClient;
    }

    public List<Payment> obtenerTodos() {
        return paymentRepository.findAll();
    }

    public Payment obtenerPorId(int id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    // public Payment registrar(PaymentCreate dto) {
    //     // Obtener info del usuario vía WebClient
    //     UserResponse user = userClient.getUserById(dto.getUserId()).block();

    //     if (user == null) {
    //         throw new RuntimeException("Usuario no encontrado para id: " + dto.getUserId());
    //     }

    //     System.out.println("Registrando pago para el usuario con email: " + user.getEmail());

    //     Payment payment = new Payment();
    //     payment.setUserId(dto.getUserId());
    //     payment.setCourseId(dto.getCourseId());
    //     payment.setAmount(dto.getAmount());
    //     payment.setStatus("Pendiente");
    //     payment.setFechaPago(new Date());
    //     payment.setPaymentMethod(dto.getPaymentMethod());

    //     Payment savedPayment = paymentRepository.save(payment);

    //     System.out.println("ID del pago registrado: " + savedPayment.getId());

    //     return savedPayment;
    // }

    public PaymentResponse registrar(PaymentCreate dto) {
        UserResponse user = userClient.getUserById(dto.getUserId()).block();

        if (user == null) {
            throw new RuntimeException("Usuario no encontrado para id: " + dto.getUserId());
        }

        Payment payment = new Payment();
        payment.setUserId(dto.getUserId());
        payment.setCourseId(dto.getCourseId());
        payment.setAmount(dto.getAmount());
        payment.setStatus("Pendiente");
        payment.setFechaPago(new Date());
        payment.setPaymentMethod(dto.getPaymentMethod());

        Payment savedPayment = paymentRepository.save(payment);

        PaymentResponse response = new PaymentResponse();
        response.setId(savedPayment.getId());
        response.setUserId(savedPayment.getUserId());
        response.setCourseId(savedPayment.getCourseId());
        response.setAmount(savedPayment.getAmount());
        response.setStatus(savedPayment.getStatus());
        response.setPaymentMethod(savedPayment.getPaymentMethod());
        response.setEmail(user.getEmail());
        response.setFechaPago(savedPayment.getFechaPago());

        return response;
    }


    public Payment actualizar(PaymentUpdate dto) {
        Payment payment = obtenerPorId(dto.getId());
        if (dto.getStatus() != null) {
            payment.setStatus(dto.getStatus());
        }
        return paymentRepository.save(payment);
    }

    public void eliminar(int id) {
        Payment pago = paymentRepository.findById(id).orElse(null);
        if (pago == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado");
        }
        paymentRepository.delete(pago);
    }
}
