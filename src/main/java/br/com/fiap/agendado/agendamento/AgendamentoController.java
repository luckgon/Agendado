package br.com.fiap.agendado.agendamento;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    @GetMapping
    public String index(Model model){
        model.addAttribute("agendamentos", List.of("agenda 1", "agenda 2", "agenda 3"));
        return"agendamento/index";
    }
    
}
