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

public class TempHumSensorAPI extends HttpServlet {
	private static final long serialVersionUID = 8479234892379L;
	List<TempHumSensor> temphumsensors = new ArrayList<>();
	
	
	
	public void init() throws ServletException {
		temphumsensors.add(new TempHumSensor(15., 70., 1L, 1));
		temphumsensors.add(new TempHumSensor(24., 21., 2L, 2));
		temphumsensors.add(new TempHumSensor(32., 67., 3L, 3));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Gson gson = new Gson();
		String json = gson.toJson(temphumsensors);
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
		
		TempHumSensor temphumsensor = gson.fromJson(reader, TempHumSensor.class);
		if (temphumsensor.getBoardId() == null || temphumsensor.getId() == null
				|| temphumsensor.getTemperature() == null || temphumsensor.getHumidity() == null) {
			response.setStatus(400);
			response.getWriter().write("Missing required parameters");
			return;
		}
		
		temphumsensor.setTimest(System.currentTimeMillis());
		temphumsensors.add(temphumsensor);
		response.setStatus(201);
		response.setContentType("application/json");
		String json = gson.toJson(temphumsensor);
		response.getWriter().write(json);
		
		
	}
}
