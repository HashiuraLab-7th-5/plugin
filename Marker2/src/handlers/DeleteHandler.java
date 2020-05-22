package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.texteditor.MarkerUtilities;

import markerTest.OriginalMarker;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class DeleteHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
        IEditorInput editorInput = editorPart.getEditorInput();
        IResource resource = (IResource)editorInput.getAdapter(IResource.class);

        OriginalMarker.deleteMarker(resource);
		return null;
	}
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	@Override
	public void dispose() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	

	@Override
	public boolean isEnabled() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

}
