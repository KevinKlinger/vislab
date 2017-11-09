package fibonacci;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "fibonacci" path)
 */
@Path("fibonacci")
public class FibonacciREST {
	
	private static final int DEFAULT_STATE = 0;
	private static int state = DEFAULT_STATE;

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return The fibonacci number at the given position.
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{position}")
	public String getFibonacciAtPosition(@PathParam("position") String position) {

		if (position.matches("\\d+")) {
			state = Integer.parseInt(position);
			return "" + getFibonacci(state);
		} else {
			return "Invalid format! Expected /position";
		}
	}

	/**
	 * Handling REST request for a range of fibonacci numbers.
	 * 
	 * @param from
	 *            First desired fibonnaci number
	 * @param to
	 *            Last desired fibonnaci number
	 * @return A list of the desired fibonnaci numbers.
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{from}/{to}")
	public String getFibonacciRange(@PathParam("from") String from, @PathParam("to") String to) {

		if (from.matches("\\d+") && to.matches("\\d+")) {
			String returnValue = "";

			for (int i = Integer.parseInt(from); i <= Integer.parseInt(to); i++) {
				returnValue += getFibonacci(i) + "\n";
			}
			return returnValue;
		}
		return "Invalid format! Expected /from/to";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("next")
	public Response getNextFibonacci() {
		state++;
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("")
	public String getCurrentFibonacci() {
		return "" + getFibonacci(state);
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("")
	public String resetFibonacci() {
		state = DEFAULT_STATE;
		return "" + getFibonacci(state);
	}
	
	
	

	/**
	 * Calculates the fibonacci number at given position.
	 * 
	 * @param position
	 *            The desired position
	 * @return The fibonacci number at the specified position.
	 */
	private int getFibonacci(int position) {
		if (position == 0) {
			return 0;
		}

		int i = 0, j = 1, k, t;
		for (k = 1; k < position; ++k) {
			t = i + j;
			i = j;
			j = t;
		}
		return j;
	}
}
