package marker;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class JumpMarker {

	private String projectName = "WinRate2";
	GetResource resourceObj = new GetResource();

	public void getMarker(String tableName,String columName) {
		//�W�����v���Ă݂�
		IResource resource = resourceObj.getResource(projectName);


		try {
			resource.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if(resource.getType() == IResource.FILE)
					{
						String ext = resource.getFileExtension();
						System.out.println(resource);
						System.out.println(ext);
						if(ext != null)
						{
							if(ext.equals("java"))
							{
								System.out.println(tableName + ":" + columName);
								IMarker[] markers = null;
								try {
									for(IMarker m : resource.findMarkers(IMarker.PROBLEM, true,IResource.DEPTH_INFINITE))
									{
										if(((String) m.getAttribute(IMarker.MESSAGE)).startsWith(tableName + ":" + columName))
										{

											//�t�@�C������A�N�e�B�u�G�f�B�^�̎擾
											IWorkbench workbench = PlatformUI.getWorkbench();
											IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
											IWorkbenchPage page = window.getActivePage();
											IEditorPart editor = IDE.openEditor(page, (IFile)resource);

											IDE.gotoMarker(editor, m);

										}
									}
								} catch (CoreException e1) {
									// TODO �����������ꂽ catch �u���b�N
									e1.printStackTrace();
								}
							}
						}

					}
					return true;
				}
			});
		} catch (CoreException e2) {
			// TODO �����������ꂽ catch �u���b�N
			e2.printStackTrace();
		}
	}

	public void getMarker(String message) {
		//�W�����v���Ă݂�
		IResource resource = resourceObj.getResource(projectName);

		try {
			resource.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if(resource.getType() == IResource.FILE)
					{
						String ext = resource.getFileExtension();
						System.out.println(resource);
						System.out.println(ext);
						if(ext != null)
						{
							if(ext.equals("java"))
							{
								System.out.println("�����܂ł��Ă邩");
								IMarker[] markers = null;
								try {
									for(IMarker m : resource.findMarkers(IMarker.PROBLEM, true,IResource.DEPTH_INFINITE)){
										if(((String) m.getAttribute(IMarker.MESSAGE)).startsWith(message)) {
											System.out.println("markers�̂��try�̒��g" + m);

											//�t�@�C������A�N�e�B�u�G�f�B�^�̎擾
											IWorkbench workbench = PlatformUI.getWorkbench();
											IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
											IWorkbenchPage page = window.getActivePage();
											IEditorPart editor = IDE.openEditor(page, (IFile)resource);

											IDE.gotoMarker(editor, m);

										}
									}
								} catch (CoreException e1) {
									// TODO �����������ꂽ catch �u���b�N
									e1.printStackTrace();
								}
							}
						}
					}
					return true;
				}
			});
		} catch (CoreException e2) {
			// TODO �����������ꂽ catch �u���b�N
			e2.printStackTrace();
		}
	}
}

		//if(resource.getName().equals(item[0].getText(0) + ".java")) {