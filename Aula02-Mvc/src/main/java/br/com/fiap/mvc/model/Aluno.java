package br.com.fiap.mvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CP2_ALUNO")
@Getter @Setter
public class Aluno {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nm_aluno", length = 100)
    private String nome;

    @Column(name = "ds_rm", precision = 6)
    private Integer rm;

    @Column(name = "ds_email", length = 25)
    private String email;

}
