package br.com.fiap.agendado.agendamento;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired 
    AgendamentoService service;


    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        System.out.println(user);
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
        return "agendamentos/form";
    }

    @PostMapping
    public String save(@Valid Agendamento agendamento, BindingResult result){
        if(result.hasErrors()) return "/agendamentos/form";
        
        System.out.println(agendamento);
        service.save(agendamento);
        return"redirect:/agendamentos";
    }

    @GetMapping("conclude/{id}")
    public String conclude(@PathVariable Long id){
        service.done(id);
        return "redirect:/agendamentos";

    }

}
