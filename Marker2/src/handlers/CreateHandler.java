package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import markerTest.OriginalMarker;

public class CreateHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO 自動生成されたメソッド・スタブ
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
        IEditorInput editorInput = editorPart.getEditorInput();
        IResource resource = (IResource)editorInput.getAdapter(IResource.class);

        // マーカーの作成
        OriginalMarker.createMarker(resource, 2, "OriginalMarker");
		return null;
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ

	}



	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
