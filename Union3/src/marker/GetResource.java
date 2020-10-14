package marker;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import property.ViolationProperty;
import views.View;

public class GetResource {

	public static IWorkspaceRoot getWorcspaceRoot() {

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		return workspace.getRoot();

	}

	public static IProject getProject(String projectName) {

		IWorkspaceRoot root = getWorcspaceRoot();
		return root.getProject(projectName);

	}

	public static IResource getResource(String projectName) {

		IProject project = getProject(projectName);
		return (IResource)project.getAdapter(IResource.class);

	}

	public static String getProjectname() {

		String projectname = null;

		try {

			View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("Union3.ErrorView");
			String projectpath = view.getDirectory();
			String[] pathlist = projectpath.split("\\\\",0);
			projectname = pathlist[pathlist.length - 1];
			System.out.println(projectname);

		} catch (PartInitException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}

		return projectname;
	}
}
