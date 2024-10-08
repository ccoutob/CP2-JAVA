package br.com.fiap.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Faltas {

    private Integer faltas;

    public Double calcularPorcentagemFaltas(){
        return faltas * 1.25;
    }

    public Double calcularMediaFaltas(){return 100 - calcularPorcentagemFaltas();}

}