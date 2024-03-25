package br.com.eduardonunesdev.educafacil.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomErrorMessage {

    protected String mensagem;
    protected int status;

}
