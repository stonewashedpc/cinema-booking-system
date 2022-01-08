package client;

import generated.cinemaService.Category;
import generated.cinemaService.Seat;
import generated.cinemaService.SeatingRow;
import generated.cinemaService.commands.seat.Seat_getRow_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getCategoryName_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getCategory_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getPrice_Command;

public class SeatCell extends Cell<Seat> {

	private SeatingRow row;
	private String categoryName;
	private Integer price;

	public SeatCell(Seat object) {
		super(object);
	}

	@Override
	public SeatCell initialize(Client client) throws Exception {
		row = client.executeCommand(new Seat_getRow_Command(this.object)).getResult();
		categoryName = client.executeCommand(new SeatingRow_getCategoryName_Command(row)).getResult();
		price = client.executeCommand(new SeatingRow_getPrice_Command(row)).getResult();
		return this;
	}

	public SeatingRow getRow() {
		return row;
	}

	public String getCategoryName() {
		return categoryName;
	}
	
	public Integer getPrice() {
		return price;
	}

}
