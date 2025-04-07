package com.fiap.hospitalar.historico.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiap.hospitalar.historico.dto.HistoryDTO;
import com.fiap.hospitalar.historico.model.History;
import com.fiap.hospitalar.historico.repository.HistoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @KafkaListener(topics = "consultas-agendadas", groupId = "historico")
    public void processarConsulta(String mensagem) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HistoryDTO historyDTO = objectMapper.readValue(mensagem, HistoryDTO.class);
            History history = new History();
            history.setPaciente(historyDTO.getPaciente());
            history.setMedico(historyDTO.getMedico());
            history.setEnfermeiro(historyDTO.getEnfermeiro());
            history.setDataHora(LocalDateTime.parse((CharSequence) historyDTO));
            historyRepository.save(history);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}