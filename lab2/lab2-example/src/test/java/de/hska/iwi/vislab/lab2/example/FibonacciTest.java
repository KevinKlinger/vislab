package de.hska.iwi.vislab.lab2.example;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
	
	private HttpServer server;
	private WebTarget target;
	
	@Before
	public void setUp() throws Exception {
		// start the server
		server = Main.startServer();
		// create the client
		Client c = ClientBuilder.newClient();

		// uncomment the following line if you want to enable
		// support for JSON in the client (you also have to uncomment
		// dependency on jersey-media-json module in pom.xml and
		// Main.startServer())
		// --
		// c.configuration().enable(new
		// org.glassfish.jersey.media.json.JsonJaxbFeature());

		target = c.target(Main.BASE_URI);
	}
	
	@After
	public void tearDown() throws Exception {
		server.shutdown();
	}

	@Test
	public void testFirst() {
		String responseMsg = target.path("/fibonacci/0").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		assertEquals("1", responseMsg);
	}
	
	@Test
	public void testNegative() {
		String responseMsg = target.path("/fibonacci/-1").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		assertEquals("Invalid format!", responseMsg);
	}
	
	@Test
	public void testNonInteger() {
		String responseMsg = target.path("/fibonacci/abc").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		assertEquals("Invalid format!", responseMsg);
	}
	
}
