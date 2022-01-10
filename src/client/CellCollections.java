package client;

import java.util.ArrayList;
import java.util.Collection;

import generated.cinemaService.CShow;
import generated.cinemaService.Category;
import generated.cinemaService.Film;
import generated.cinemaService.Hall;
import generated.cinemaService.Reservation;
import generated.cinemaService.Seat;
import generated.cinemaService.SeatingRow;

public final class CellCollections {

	private CellCollections() {
	}

	public static Collection<CShowCell> toCShowCellCollection(Collection<CShow> objects, Client client)
			throws Exception {
		Collection<CShowCell> cellCollection = new ArrayList<>();
		for (CShow cShow : objects) {
			CShowCell cell = new CShowCell(cShow);
			cellCollection.add(cell.initialize(client));
		}
		return cellCollection;
	}

	public static Collection<SeatCell> toSeatCellCollection(Collection<Seat> objects, Client client) throws Exception {
		Collection<SeatCell> cellCollection = new ArrayList<>();
		for (Seat seat : objects) {
			SeatCell cell = new SeatCell(seat);
			cellCollection.add(cell.initialize(client));
		}
		return cellCollection;
	}

	public static Collection<ReservationCell> toReservationCellCollection(Collection<Reservation> objects,
			Client client) throws Exception {
		Collection<ReservationCell> cellCollection = new ArrayList<>();
		for (Reservation reservation : objects) {
			ReservationCell cell = new ReservationCell(reservation);
			cellCollection.add(cell.initialize(client));
		}
		return cellCollection;
	}
	
	public static Collection<FilmCell> toFilmCellCollection(Collection<Film> objects,
			Client client) throws Exception {
		Collection<FilmCell> cellCollection = new ArrayList<>();
		for (Film film : objects) {
			FilmCell cell = new FilmCell(film);
			cellCollection.add(cell.initialize(client));
		}
		return cellCollection;
	}
	
	public static Collection<HallCell> toHallCellCollection(Collection<Hall> objects,
			Client client) throws Exception {
		Collection<HallCell> cellCollection = new ArrayList<>();
		for (Hall hall : objects) {
			HallCell cell = new HallCell(hall);
			cellCollection.add(cell.initialize(client));
		}
		return cellCollection;
	}
	
	public static Collection<SeatingRowCell> toSeatingRowCellCollection(Collection<SeatingRow> objects,
			Client client) throws Exception {
		Collection<SeatingRowCell> cellCollection = new ArrayList<>();
		for (SeatingRow row : objects) {
			SeatingRowCell cell = new SeatingRowCell(row);
			cellCollection.add(cell.initialize(client));
		}
		return cellCollection;
	}
	
}
