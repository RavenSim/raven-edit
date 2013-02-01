package raven.edit.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import raven.edit.editor.EditorViewDelegate;
import raven.edit.tools.HealthTool;

public class HealthToolAction extends AbstractAction {

	private EditorViewDelegate delegate;

	public HealthToolAction(String text, ImageIcon icon, String description,
			Integer mnemonic, EditorViewDelegate delegate) {
		super(text, icon);
		
		this.delegate = delegate;
		
		putValue(SHORT_DESCRIPTION, description);
		putValue(MNEMONIC_KEY, mnemonic);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		delegate.changeTool(new HealthTool(delegate.getView()));
	}

}
