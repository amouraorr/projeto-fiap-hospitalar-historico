package com.fiap.hospitalar.historico.service;

import com.fiap.hospitalar.historico.model.History;
import com.fiap.hospitalar.historico.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private HistoryRepository repository;

    public List<History> getConsultationsByPatientId(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}
