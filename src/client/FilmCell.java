package client;

import generated.cinemaService.Film;

public class FilmCell extends Cell<Film> {

	private String filmName;

	public FilmCell(Film object) {
		super(object);
	}

	@Override
	public FilmCell initialize(Client client) throws Exception {
		this.filmName = this.object.getName();
		return this;
	}

	public String getFilmName() {
		return filmName;
	}
	
	@Override
	public String toString() {
		return filmName;
	}
}
