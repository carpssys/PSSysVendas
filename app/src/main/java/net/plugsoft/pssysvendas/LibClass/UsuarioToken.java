package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class UsuarioToken implements Serializable {
    private boolean authenticated;
    private String expiration;
    private String token;
    private String Message;

    public UsuarioToken() { }


    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return Message;
    }
}
