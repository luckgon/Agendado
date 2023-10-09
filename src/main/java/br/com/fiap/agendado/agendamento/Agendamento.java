package br.com.fiap.agendado.agendamento;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Agendamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @NotBlank
    String paciente;
    

    String medico;

    String data;

    @Min(1) @Max(10)
    Integer score;

    @Min(1) @Max(100)
    Integer status;
}
