package br.com.eduardonunesdev.educafacil.services.exceptions;

public class ResourceExistsException extends RuntimeException{

    public ResourceExistsException(String message) {
        super(message);
    }
}
