package raven.edit.tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import raven.edit.editor.ViewportDelegate;
import raven.game.RavenObject;
import raven.game.triggers.TriggerWeaponGiver;
import raven.math.Vector2D;
import raven.script.RavenScript;

public class ShotgunTool extends EditorTool {

	private Vector2D shotSpawnPoint;
	private Point mouseLocation;
	private Vector2D levelCursor;

	public ShotgunTool(ViewportDelegate delegate) {
		super(delegate);
		
		levelCursor = null;
	}
	
	// EditorTool needs 

	@Override
	public void paintComponent(Graphics g) {
		if(shotSpawnPoint != null) {
			Graphics2D g2d = (Graphics2D)g;
			// Render the level cursor
			if (levelCursor != null) {
				Ellipse2D highlight = new Ellipse2D.Double(levelToView(levelCursor).getX() - 7, levelToView(levelCursor).getY() - 7, 14, 14);
				g2d.setColor(Color.YELLOW);
				g2d.draw(highlight);
			}

		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			if (levelCursor != null)
			level.addSpawnPoint(levelCursor);
		}
}

	@Override
	public void mouseEntered(MouseEvent e) {
		viewport.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		viewport.setCursor(Cursor.getDefaultCursor());
		levelCursor = null;
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseLocation = e.getPoint();
		levelCursor = viewToLevel(mouseLocation);
		
		if (e.isPopupTrigger()) {
			JMenuItem item = new JMenuItem("Not implemented yet...");
			JPopupMenu popup = new JPopupMenu();
			popup.add(item);
			popup.show(e.getComponent(), e.getX(), e.getY());
		} else if (e.getButton() == MouseEvent.BUTTON1) {
			level.addWeaponGiver(RavenObject.SHOTGUN, levelCursor, RavenScript.getInt("DefaultGiverTriggerRange"));
		}

		e.consume();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Check if we're selecting a nearby point
		mouseLocation = e.getPoint();
		levelCursor = viewToLevel(mouseLocation);			
		
		viewport.repaint();
		
		e.consume();
	}
}
