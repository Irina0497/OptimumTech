package com.optimumtech.api_report.report.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reportes")
public class ReportController {
    @GetMapping("/usuario-curso/{usuarioId}/{cursoId}")
    public Object generarReporte(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        // Lógica para generar el reporte sin consultar a otras APIs
        return null;
    }
}
