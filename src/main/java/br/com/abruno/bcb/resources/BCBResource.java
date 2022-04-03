package br.com.abruno.bcb.resources;

import java.text.ParseException;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.abruno.bcb.exceptions.DataInvalidaException;
import br.com.abruno.bcb.proxy.BCBCambioProxy;
import br.com.abruno.bcb.utils.Utils;


@Path("/v1/api/bcb")
@Tag(name = "Cotacao Dólar")
public class BCBResource {

	@Inject
	@RestClient
	BCBCambioProxy bcbCambioProxy;

	@Path("/periodo/{dataFinalCotacao}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca a cotação do dólar no dia informado e a do dia anterior", summary = "Cotações do dólar nos dias informado e anterior")
	@APIResponse(responseCode = "200", description = "Ok")
	@APIResponse(responseCode = "400", description = "Data inválida")
	@GET
	public String getPeriodoCotacao(@PathParam("dataFinalCotacao") @Schema(description="Data da cotação", example="03-04-2021") @NotEmpty(message = "Campo obrigatório") String dataFinalCotacao) throws DataInvalidaException, ParseException {
		return bcbCambioProxy.getPeriodoCotacao(Utils.getDataAnterior(dataFinalCotacao), dataFinalCotacao);
	}

	@Path("/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca a cotação do dólar no dia informado", summary = "Cotação do dólar no dia informado")
	@APIResponse(responseCode = "200", description = "Ok")
	@APIResponse(responseCode = "400", description = "Data inválida")
	@GET
	public String getCotacaoData(@PathParam("data") @Schema(description="Data da cotação", example="\'03-04-2021\'") @NotEmpty(message = "Campo obrigatório") String data) throws DataInvalidaException, ParseException {
		return bcbCambioProxy.getCotacaoData(Utils.dataValida(data));
	}
}