package br.com.eduardonunesdev.educafacil.services.contracts;

import br.com.eduardonunesdev.educafacil.model.User;

public interface AuthenticatedUserService {

    User getLoggedInUser();
}
