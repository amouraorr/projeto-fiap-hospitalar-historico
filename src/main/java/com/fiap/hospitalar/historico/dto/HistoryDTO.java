package com.fiap.hospitalar.historico.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryDTO {

    private Long id;
    private String paciente;
    private String medico;
    private String enfermeiro;
    private LocalDateTime dataHora;
    private String status; // Por exemplo, status da consulta
}
