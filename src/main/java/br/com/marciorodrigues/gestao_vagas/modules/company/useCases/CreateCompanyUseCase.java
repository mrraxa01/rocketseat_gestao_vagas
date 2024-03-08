package br.com.marciorodrigues.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marciorodrigues.gestao_vagas.exceptions.UserFoundException;
import br.com.marciorodrigues.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.marciorodrigues.gestao_vagas.modules.company.repositories.CompanyRepository;
@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity){
        
        companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user)->{
            throw new UserFoundException();
        });

        return companyRepository.save(companyEntity);


    }
}
