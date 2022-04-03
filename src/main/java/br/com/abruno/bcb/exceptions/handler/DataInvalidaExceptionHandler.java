package br.com.abruno.bcb.exceptions.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.abruno.bcb.exceptions.DataInvalidaException;
import br.com.abruno.bcb.exceptions.ExceptionResponse;


@Provider
public class DataInvalidaExceptionHandler implements ExceptionMapper<DataInvalidaException>{


	@Override
	public Response toResponse(DataInvalidaException e) {
		
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(new ExceptionResponse(e.getMessage(), false)).build();
        
	}
	

}
