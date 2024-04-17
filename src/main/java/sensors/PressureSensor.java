package sensors;

import java.util.Objects;

public class PressureSensor {
	private Double pressure;
	private Double altitude;
	private Long timest;
	private Long boardId;
	private Integer id;

	public PressureSensor() {
		super();
		this.timest = System.currentTimeMillis();
	}

	public PressureSensor(Double pressure, Long boardId, Integer id, Double altitude) {
		super();
		this.pressure = pressure;
		this.boardId = boardId;
		this.timest = System.currentTimeMillis();
		this.id = id;
		this.altitude = altitude;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
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
		return Objects.hash(altitude, boardId, id, pressure, timest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PressureSensor other = (PressureSensor) obj;
		return Objects.equals(altitude, other.altitude) && Objects.equals(boardId, other.boardId)
				&& Objects.equals(id, other.id) && Objects.equals(pressure, other.pressure)
				&& Objects.equals(timest, other.timest);
	}

}
