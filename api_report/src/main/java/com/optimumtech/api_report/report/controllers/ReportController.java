package com.optimumtech.api_report.report.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.optimumtech.api_report.report.services.ReportService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    
    //http://localhost:8084/report/report
    @GetMapping("/user")
    public ResponseEntity<byte[]> generateReport(){
        try {
            byte [] report = reportService.generateReport("ReporteUsuarios");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");    
            return ResponseEntity.ok().headers(headers).body(report);
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el stacktrace en la consola
            String errorMsg = "Error al generar el reporte: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg.getBytes());
        }
    }
    
}
