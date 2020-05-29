package filemarkerTest;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.texteditor.MarkerUtilities;
import filemarker.Activator;

public class OriginalMarker {
	public static final String MARKER_ID = Activator.PLUGIN_ID + ".FileMarker";

	public static IMarker createMarker(IResource resource, int line, int start, int end, String message)
	{
		IMarker marker = null;

		try {
			marker = resource.createMarker(MARKER_ID);
			marker.setAttribute(IMarker.TRANSIENT, true);
			marker.setAttribute(IMarker.CHAR_START, start);
			marker.setAttribute(IMarker.CHAR_END, end);
			marker.setAttribute(IMarker.LINE_NUMBER, line);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
			marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			marker.setAttribute(IMarker.MESSAGE, message);

		} catch (CoreException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
		return marker;

//		Map<String, Object> attributes = new HashMap<String, Object>();
//		attributes.put(IMarker.TRANSIENT, true);    // �}�[�J�[�̉i����:true
//		attributes.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_NORMAL));      // �}�[�J�[�̗D��x:��
//		attributes.put(IMarker.SEVERITY, Integer.valueOf(IMarker.SEVERITY_WARNING));    // �}�[�J�[�̏d�v�x:�x��
//		attributes.put(IMarker.LINE_NUMBER, line);  // �}�[�J�[��\��������s�ԍ�
//		attributes.put(IMarker.MESSAGE, message); // �}�[�J�[�ɕ\�����郁�b�Z�[�W
//
//        try {
//        	MarkerUtilities.createMarker(resource, attributes, MARKER_ID);  // �}�[�J�[���쐬
//        } catch (CoreException e) {
//        	e.printStackTrace();
//        }
	}


	public static void deleteMarker(IResource resource)
	{
		try {
        	resource.deleteMarkers(MARKER_ID, false, IResource.DEPTH_ZERO);  // �}�[�J�[���쐬
        } catch (CoreException e) {
        	e.printStackTrace();
        }
	}
}
