package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.texteditor.MarkerUtilities;

import filemarkerTest.OriginalMarker;

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
//		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
//        IEditorInput editorInput = editorPart.getEditorInput();
//        IResource resource = (IResource)editorInput.getAdapter(IResource.class);

		String projectName = "WinRate2";
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		IResource resource = (IResource)project.getAdapter(IResource.class);

		try {
			resource.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if(resource.getType() == IResource.FILE) {
						System.out.println("���\�[�X�̎�ނ̓t�@�C��");
						String ext = resource.getFileExtension();
				    	System.out.println(ext);
				    	if(ext.equals("java"))
				    		OriginalMarker.deleteMarker(resource);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}


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
