package br.com.marciorodrigues.gestao_vagas.modules.canditate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @NotBlank
    private String name;
    
    @NotBlank
    @Pattern(regexp = "\\S+", message = "[username] não pode conter espaços em branco")
    private String username;
    @Email(message = "E-mail inválido!")
    private String email;
    @Length(min = 5, max = 10)
    private String password;
    
    private String description;
    
    private String curriculum; 

    @CreationTimestamp
    private LocalDateTime createdAt;


}
