package client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public abstract class RowClickListener extends MouseAdapter {

	public RowClickListener() {
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		JTable table = (JTable) event.getSource();
		if (event.getClickCount() == 2 && table.getSelectedRow() != -1) {
			this.onDoubleClick(event);
		}
	}
	
	public abstract void onDoubleClick(MouseEvent event);
}
