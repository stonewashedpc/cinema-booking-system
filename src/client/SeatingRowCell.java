package client;

import generated.cinemaService.SeatingRow;
import generated.cinemaService.commands.seatingRow.SeatingRow_getCategoryName_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getSeats_Command;

public class SeatingRowCell extends Cell<SeatingRow> {

	private Integer nr;
	private String categoryName;
	private Integer seatCount;

	public SeatingRowCell(SeatingRow object) {
		super(object);
	}

	@Override
	public SeatingRowCell initialize(Client client) throws Exception {
		this.nr = this.object.getNr();
		this.categoryName = client.executeCommand(new SeatingRow_getCategoryName_Command(this.object)).getResult();
		this.seatCount = client.executeCommand(new SeatingRow_getSeats_Command(this.object)).getResult().size();
		return this;
	}

	public Integer getNr() {
		return nr;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

}
