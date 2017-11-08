package fibonacci;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "fibonacci" path)
 */
@Path("/fibonacci/{position}")
public class FibonacciREST {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return The fibonacci number at the given position.
     */
    
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getFibonacciAtPosition(@PathParam("position") String position) {
		
		if(position.matches("\\d")) {
			int number = getFibonacci(Integer.parseInt(position));
			return "" + number;			
		} else {
			return "Invalid format!";
		}
		
	}
	
	/**
	 * Calculates the fibonacci number at given position.
	 * @param position The desired position
	 * @return The fibonacci number at the specified position.
	 */
    private int getFibonacci(int position) {
        int i = 0, j = 1, k, t;
        for (k = 1; k < position; ++k) {
            t = i + j;
            i = j;
            j = t;
        }
        return j;
    }
}
