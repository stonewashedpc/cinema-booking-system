package client;

import java.util.ArrayList;
import java.util.Collection;

import client.forms.SeatCell;
import generated.cinemaService.CShow;
import generated.cinemaService.Seat;

public final class CellCollections {
	
	private CellCollections() {
	}
	
	public static Collection<CShowCell> toCShowCellCollection(Collection<CShow> objects, Client client) throws Exception {
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
}
