package br.com.fiap.agendado.agendamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class AgendamentoService {
    
    @Autowired
    AgendamentoRepository repository;

    @GetMapping
    public List <Agendamento> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

    public void save(Agendamento agendamento) {
        repository.save(agendamento);
    }

    public void done(Long id) {
        var optional = repository.findById(id);

        var agendamento = optional.get();

        agendamento.setStatus(agendamento.getStatus()+1);
        repository.save(agendamento);
    }


}
