package sensors;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PressureSensorAPI extends HttpServlet {
	private static final long serialVersionUID = 8479234892379L;
	List<PressureSensor> pressuresensors = new ArrayList<>();
	
	
	
	public void init() throws ServletException {
		pressuresensors.add(new PressureSensor(10.3, 1L, 1, 100.));
		pressuresensors.add(new PressureSensor(14.3, 1L, 2, 110.));
		pressuresensors.add(new PressureSensor(13.3, 1L, 3, 120.));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Gson gson = new Gson();
		String json = gson.toJson(pressuresensors);
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
		
		PressureSensor pressuresensor = gson.fromJson(reader, PressureSensor.class);
		if (pressuresensor.getBoardId() == null || pressuresensor.getId() == null
				|| pressuresensor.getAltitude() == null || pressuresensor.getPressure() == null) {
			response.setStatus(400);
			response.getWriter().write("Missing required parameters");
			return;
		}
		
		pressuresensor.setTimest(System.currentTimeMillis());
		pressuresensors.add(pressuresensor);
		response.setStatus(201);
		response.setContentType("application/json");
		String json = gson.toJson(pressuresensor);
		response.getWriter().write(json);
		
		
	}
}
