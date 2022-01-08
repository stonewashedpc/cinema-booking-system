package client;

import generated.cinemaService.Hall;

public class HallCell extends Cell<Hall> {
	
	private String hallName;

	public HallCell(Hall object) {
		super(object);
	}

	@Override
	public HallCell initialize(Client client) throws Exception {
		this.hallName = this.object.getName();
		return this;
	}

	public String getHallName() {
		return hallName;
	}
	
	@Override
	public String toString() {
		return hallName;
	}

}
