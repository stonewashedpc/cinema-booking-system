package client;

import generated.cinemaService.CShow;
import generated.cinemaService.commands.cShow.CShow_getFilm_Command;
import generated.cinemaService.commands.cShow.CShow_getHall_Command;

public class CShowCell extends Cell<CShow> {

	private String hallName;
	private String filmName;
	private Boolean reservable;

	public CShowCell(CShow object) {
		super(object);
	}
	
	@Override
	public CShowCell initialize(Client client) throws Exception {
		filmName = client.executeCommand(new CShow_getFilm_Command(this.object)).getResult().getName();
		hallName = client.executeCommand(new CShow_getHall_Command(this.object)).getResult().getName();
		reservable = this.object.getReservable();
		return this;
	}

	public String getHallName() {
		return hallName;
	}

	public String getFilmName() {
		return filmName;
	}

	public Boolean getReservable() {
		return reservable;
	}

	public void setReservable(Boolean reservable) {
		this.reservable = reservable;
	}
	
}
