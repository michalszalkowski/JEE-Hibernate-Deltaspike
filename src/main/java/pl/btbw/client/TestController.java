package pl.btbw.client;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class TestController {

	@Inject
	private ClientService clientService;

	@GET
	@Path("/")
	public String test() {
		clientService.test();
		return "ok";
	}

}
