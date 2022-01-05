package client;

import java.util.Collection;

import generated.cinemaService.CShow;
import generated.cinemaService.Reservation;
import generated.cinemaService.Seat;
import generated.cinemaService.commands.cShow.CShow_getFilm_Command;
import generated.cinemaService.commands.cShow.CShow_getHall_Command;
import generated.cinemaService.commands.reservation.Reservation_getBooking_Command;
import generated.cinemaService.commands.reservation.Reservation_getSeat_Command;
import generated.cinemaService.commands.reservation.Reservation_getShow_Command;
import generated.cinemaService.commands.reservation.Reservation_isBooked_Command;
import generated.cinemaService.commands.seat.Seat_getPrice_Command;
import generated.cinemaService.commands.seat.Seat_getRow_Command;
import generated.cinemaService.commands.seatingRow.SeatingRow_getPrice_Command;

public class ReservationCell extends Cell<Reservation> {
	
	private String hallName;
	private String filmName;
	private Integer seatCount;
	private Integer totalPrice = 0;
	private Boolean isBooked;

	public ReservationCell(Reservation object) {
		super(object);
	}

	@Override
	public ReservationCell initialize(Client client) throws Exception {
		CShow show = client.executeCommand(new Reservation_getShow_Command(this.object)).getResult();
		hallName = client.executeCommand(new CShow_getHall_Command(show)).getResult().getName();
		filmName = client.executeCommand(new CShow_getFilm_Command(show)).getResult().getName();
		Collection<Seat> seats = client.executeCommand(new Reservation_getSeat_Command(this.object)).getResult();
		seatCount = seats.size();
		for (Seat seat : seats) {
			Integer seatPrice = client.executeCommand(new Seat_getPrice_Command(seat)).getResult();
			totalPrice += seatPrice;
		}
		isBooked = client.executeCommand(new Reservation_isBooked_Command(object)).getResult();
		return this;
	}

	public String getHallName() {
		return hallName;
	}

	public String getFilmName() {
		return filmName;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

}
