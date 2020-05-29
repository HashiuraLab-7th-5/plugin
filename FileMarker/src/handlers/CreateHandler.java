package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.editors.text.FileDocumentProvider;


import filemarkerTest.OriginalMarker;

public class CreateHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO 自動生成されたメソッド・スタブ
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
						String ext = resource.getFileExtension();
				    	if(ext.equals("java")) {
				    		IPath path = resource.getFullPath();
				    		ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();
				    		manager.connect(path, LocationKind.IFILE,null);
				    		ITextFileBuffer buffer = manager.getTextFileBuffer(path,LocationKind.IFILE);

				    		IDocument document = buffer.getDocument();
				    		//=の前後を調べる
				    		checkEqual(document,resource);

				    	}
					}
					return true;
				}
			});
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}

	public void checkEqual(IDocument document, IResource resource) {
		String equal = "=";

		FindReplaceDocumentAdapter finder = new FindReplaceDocumentAdapter(document);
		try {
			IRegion region = finder.find(0, equal, true, true, false, false);
			if(region != null) {
				int front_num = region.getOffset() - 1;
				int back_num = region.getOffset() + 1;

				char front_char = document.getChar(front_num);
				char back_char = document.getChar(back_num);

				//ifで＝の前後の文字を確認
				if(front_char != ' ' || back_char != ' ') {
					int lineNumber = document.getLineOfOffset(region.getOffset()) + 1;
			        IMarker marker = null;
					//marker create markerに関しては勘違い一応このままにしておく
			        marker = OriginalMarker.createMarker(resource, lineNumber, front_num, back_num + 1, "密です！！");
				}
			}
		} catch (BadLocationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


//	System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
//	System.out.println(resource);
//	System.out.println("全体の文字数" + document.getLength());
//	System.out.println("ifの位置" + region.getOffset());
//	System.out.println("ifあった行数" + linNumber);
// 	System.out.println("ifの行数" + document.computeNumberOfLines(text));
// 	System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");

/*
 * try {
			resource.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if(resource.getType() == IResource.FILE) {
						String ext = resource.getFileExtension();
				    	if(ext.equals("java")) {
				    		IPath path = resource.getFullPath();
				    		ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();
				    		manager.connect(path, LocationKind.IFILE,null);
				    		ITextFileBuffer buffer = manager.getTextFileBuffer(path,LocationKind.IFILE);
				    		IDocument document = buffer.getDocument();

				    		String text = "if";
				    		FindReplaceDocumentAdapter finder = new FindReplaceDocumentAdapter(document);
				    		try {
								IRegion region = finder.find(0, text, true, true, false, false);
								if(region != null) {
									int lineNumber = document.getLineOfOffset(region.getOffset()) + 1;
							        //marker create
							        OriginalMarker.createMarker(resource, lineNumber, "ifの位置");

								}
							} catch (BadLocationException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}
				    	}
					}
					return true;
				}
			});
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
 */
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
