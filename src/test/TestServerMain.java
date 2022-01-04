package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import database.ResetDB;

class TestServerMain {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ResetDB updateDB = new ResetDB();
		updateDB.updateDB();
	}

	@Test
	void test() {
		assertEquals(1 + 2, 3);
	}
}
