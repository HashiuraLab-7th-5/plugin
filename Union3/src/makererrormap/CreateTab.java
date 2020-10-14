package makererrormap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;

import database.SQLiteSample;

public class CreateTab {

	Creator tablecreator;
	TabFolder tabFolder;
	GridData gd = new GridData();


	public CreateTab(Composite container,TabFolder tabFolder) {

		this.tabFolder = tabFolder;
		tablecreator = new CreateTable(container,tabFolder);

		gd.heightHint = 200;
		gd.widthHint = 650;
	}


	public void createTab() {

		ArrayList<Map<String,String>> tableData = new ArrayList<Map<String,String>>();
		SQLiteSample sql = new SQLiteSample();
		ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();

		String tableName = "union_test"; //����Aggregation�e�[�u��;

		//SQLite���猟�o���ʂ��Ƃ��Ă���
		try {
			sql.conectSample();
			tableData = sql.getTable(tableName);

		} catch (IOException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}

		TabItem item = new TabItem(tabFolder,SWT.NONE);

		ProductTable tablemap = tablecreator.createProduct();
		tablemap.makeTableData(tableData); //�Z�~�̍X�V

		Table errormap = tablemap.getWidget();
		item.setText("�^�u");
		item.setControl(errormap);

	}
}
