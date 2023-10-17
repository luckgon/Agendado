package br.com.fiap.agendado.agendamento;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired 
    AgendamentoService service;


    @GetMapping
    public String index(Model model){
        model.addAttribute("agendamentos", service.findAll());
        return"agendamentos/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/agendamentos";
    }


    
    @GetMapping("novo")
    public String form(){
        return "agendamento/form";
    }

    @PostMapping
    public String save(Agendamento agendamento){
        service.save(agendamento);
        return"redirect:/agendamento";
    }

}
