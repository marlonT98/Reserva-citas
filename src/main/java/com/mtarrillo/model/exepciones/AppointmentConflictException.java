package com.mtarrillo.model.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exepcion personbalizada
@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class AppointmentConflictException extends  RuntimeException {

    private static final long serialVersionID =1L;

    public AppointmentConflictException(String mensaje){
        super(mensaje);
    }

}
