package br.com.marciorodrigues.gestao_vagas.modules.canditate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marciorodrigues.gestao_vagas.exceptions.UserFoundException;
import br.com.marciorodrigues.gestao_vagas.modules.canditate.CandidateEntity;
import br.com.marciorodrigues.gestao_vagas.modules.canditate.CanditateRepository;

@Service
public class CreateCandidateUseCase {
    
      @Autowired
private CanditateRepository canditateRepository;

        public CandidateEntity execute(CandidateEntity candidateEntity){

        canditateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user)->{
            throw new UserFoundException();
        });

        return canditateRepository.save(candidateEntity);
    }
}
