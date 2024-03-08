package br.com.marciorodrigues.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException{

    public UserFoundException(){
        super("Username/E-mail já cadastrado(s)!");
    }
}
