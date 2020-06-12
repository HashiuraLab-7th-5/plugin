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
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return marker;

//		Map<String, Object> attributes = new HashMap<String, Object>();
//		attributes.put(IMarker.TRANSIENT, true);    // マーカーの永続化:true
//		attributes.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_NORMAL));      // マーカーの優先度:中
//		attributes.put(IMarker.SEVERITY, Integer.valueOf(IMarker.SEVERITY_WARNING));    // マーカーの重要度:警告
//		attributes.put(IMarker.LINE_NUMBER, line);  // マーカーを表示させる行番号
//		attributes.put(IMarker.MESSAGE, message); // マーカーに表示するメッセージ
//
//        try {
//        	MarkerUtilities.createMarker(resource, attributes, MARKER_ID);  // マーカーを作成
//        } catch (CoreException e) {
//        	e.printStackTrace();
//        }
	}


	public static void deleteMarker(IResource resource)
	{
		try {
        		resource.deleteMarkers(MARKER_ID, false, IResource.DEPTH_ZERO);  // マーカーを作成
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
