package actuator;

import java.util.Objects;

public class Actuator {
	private Long boardId;
	private Long timest;
	private Boolean isOn;
	private Integer id;
	private Boolean isHot;
	private Boolean isCold;

	public Actuator() {
		super();
		this.timest = System.currentTimeMillis();
	}

	public Actuator(Long boardId, Boolean isOn, Integer id, Boolean isHot, Boolean isCold) {
		super();
		this.boardId = boardId;
		this.timest = System.currentTimeMillis();
		this.isOn = isOn;
		this.id = id;
		this.isHot = isHot;
		this.isCold = isCold;
	}

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	public Long getTimest() {
		return timest;
	}

	public void setTimest(Long timest) {
		this.timest = timest;
	}

	public Boolean getIsOn() {
		return isOn;
	}

	public void setIsOn(Boolean isOn) {
		this.isOn = isOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public Boolean getIsCold() {
		return isCold;
	}

	public void setIsCold(Boolean isCold) {
		this.isCold = isCold;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardId, id, isCold, isHot, isOn, timest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actuator other = (Actuator) obj;
		return Objects.equals(boardId, other.boardId) && Objects.equals(id, other.id)
				&& Objects.equals(isCold, other.isCold) && Objects.equals(isHot, other.isHot)
				&& Objects.equals(isOn, other.isOn) && Objects.equals(timest, other.timest);
	}

}
