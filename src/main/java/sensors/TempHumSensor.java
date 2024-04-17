package sensors;

import java.util.Objects;

public class TempHumSensor {
	private Double temperature;
	private Double humidity;
	private Long timest;
	private Long boardId;
	private Integer id;

	public TempHumSensor() {
		super();
		this.timest = System.currentTimeMillis();
	}

	public TempHumSensor(Double temperature, Double humidity, Long boardId, Integer id) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.boardId = boardId;
		this.timest = System.currentTimeMillis();
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Long getTimest() {
		return timest;
	}

	public void setTimest(Long timest) {
		this.timest = timest;
	}

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardId, humidity, id, temperature, timest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempHumSensor other = (TempHumSensor) obj;
		return Objects.equals(boardId, other.boardId) && Objects.equals(humidity, other.humidity)
				&& Objects.equals(id, other.id) && Objects.equals(temperature, other.temperature)
				&& Objects.equals(timest, other.timest);
	}

}
