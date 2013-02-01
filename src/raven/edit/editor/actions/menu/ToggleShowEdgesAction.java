package raven.edit.editor.actions.menu;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import raven.edit.editor.EditorView;
import raven.edit.editor.EditorViewDelegate;

public class ToggleShowEdgesAction extends AbstractAction {
	
	private EditorViewDelegate delegate;
	
	public ToggleShowEdgesAction(String text, ImageIcon icon, String description, Integer mnemonic, EditorViewDelegate delegate) {
		super(text, icon);
		
		this.delegate = delegate;
		
		putValue(SHORT_DESCRIPTION, description);
		putValue(MNEMONIC_KEY, mnemonic);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Toggle the visibility of graph edges
		System.err.println("Toggle show edges unimplemented!");
		delegate.getView().repaint();
	}
}
