package marker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import database.SQLiteSample;
import property.ViolationPropertyContext;
import views.View;

public class CreateMarker {

	//private ArrayList<String[]> tableData = new ArrayList<String[]>();


	public static void createMarker() throws PartInitException {
		ArrayList<Map<String,String>> tableData = new ArrayList<Map<String,String>>();
		SQLiteSample sql = new SQLiteSample();

		try {

			String tableName = "union_test"; //仮で作ったテーブル;

			sql.conectSample();
			tableData = sql.getTable(tableName);

			//resourceを取得してマーカーの付与
			String projectname = GetResource.getProjectname();
			IResource resource = GetResource.getResource(projectname);


			assignment(resource,tableData);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}


	private static void assignment(IResource resource,ArrayList<Map<String,String>> sqldata) throws PartInitException {

		ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();

		if(sqldata.size() != 0) {

			//クラス名とstart,endを調べてマーカー
			Iterator it = ((List<Map<String, String>>) sqldata).iterator();
			while(it.hasNext()) {
				Map<String,String> data = (Map<String,String>) it.next();
				String errorcode = data.get("errorcode");
				ArrayList<String> errorProperty = new ArrayList<String>();

				//comboboxからパターンをとる
				View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("Union3.ErrorView");
				String patternname = view.getPattern();

				ViolationPropertyContext propertycontext = new ViolationPropertyContext(patternname,errorcode);
				errorProperty = propertycontext.getErrorViolation();

				String classname = getClassname(data);
				String start = getStartError(data);
				String end	 = getEndError(data);
				String errormessage = errorProperty.get(2);


				try {
					resource.accept(new IResourceVisitor() {
						public boolean visit(IResource resource) throws CoreException {
							if(resource.getType() == IResource.FILE)
							{
								if(resource.getName().equals(classname + ".java"))
								{
									IPath path = resource.getFullPath();

									try {
										manager.connect(path, LocationKind.IFILE,null);
									} catch (CoreException e) {
										// TODO 自動生成された catch ブロック
										e.printStackTrace();
									}

									ITextFileBuffer buffer = manager.getTextFileBuffer(path,LocationKind.IFILE);
									IDocument document = buffer.getDocument();
									FindReplaceDocumentAdapter finder = new FindReplaceDocumentAdapter(document);
									ErrorMarker.addMarker(resource, Integer.valueOf(start), Integer.valueOf(end), errormessage);
								}
							}
							return true;
						}
					});
				} catch (CoreException e2) {
					// TODO 自動生成された catch ブロック
					e2.printStackTrace();
				}

			}

		}
	}

	private static String getClassname(Map<String,String> sqldata) {

		return sqldata.get("classname");

	}

	private static String getStartError(Map<String,String> sqldata) {

		return sqldata.get("start");

	}

	private static String getEndError(Map<String,String> sqldata) {

		return sqldata.get("end");

	}
/* ＝の密を求めるやつ
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

			        //Properyオブジェクトの作成
			        Property property = new Property("FactoryMethod");
			        String message = property.getProperty("InheritanceLine");

			        System.out.println("メッセージ" + message);

			        marker = ErrorMarker.addMarker(resource, lineNumber, front_num, back_num + 1, message);
				}
			}

		} catch (BadLocationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
*/

}

