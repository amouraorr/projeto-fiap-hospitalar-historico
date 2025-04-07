package com.fiap.hospitalar.historico.resolver;

import com.fiap.hospitalar.historico.model.History;
import com.fiap.hospitalar.historico.service.ConsultationService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryResolver implements GraphQLQueryResolver {

    @Autowired
    private ConsultationService service;

    public List<History> getPatientHistory(Long patientId) {
        return service.getConsultationsByPatientId(patientId);
    }
}
