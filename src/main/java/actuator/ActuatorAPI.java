package actuator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActuatorAPI extends HttpServlet{
	
	private static final long serialVersionUID = 8479234892379L;
	List<Actuator> actuators = new ArrayList<>();
	
	
	
	public void init() throws ServletException {
		actuators.add(new Actuator(1L, true, 1, true, false));
		actuators.add(new Actuator(1L, true, 2, false, true));
		actuators.add(new Actuator(1L, false, 3, false, false));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Gson gson = new Gson();
		String json = gson.toJson(actuators);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		BufferedReader reader = request.getReader();
		
		Actuator actuator = gson.fromJson(reader, Actuator.class);
		if (actuator.getBoardId() == null || actuator.getIsOn() == null || actuator.getId() == null
				|| actuator.getIsHot() == null || actuator.getIsCold() == null) {
			response.setStatus(400);
			response.getWriter().write("Missing required parameters");
			return;
		}
		
		actuator.setTimest(System.currentTimeMillis());
		actuators.add(actuator);
		response.setStatus(201);
		response.setContentType("application/json");
		String json = gson.toJson(actuator);
		response.getWriter().write(json);
		
		
	}
}
