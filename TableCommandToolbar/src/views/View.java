package views;

import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import handler.ViewHandler;

public class View extends ViewPart {
	Table table;
	Text label;
	Button button;
	Combo combo;
	Text text;
	String path;

	public View() {
		// TODO 自動生成されたコンストラクター・スタブ
		System.out.println("Viewのコンストラクタから");
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO 自動生成されたメソッド・スタブ
		Composite container = new Composite(parent,SWT.NONE);
		container.setLayout(new GridLayout(2,true));

		CreateTable cTable = new CreateTable(container);
		//CreateTextField cText = new CreateTextField(container);
		CreateDirectoryButton cButton = new CreateDirectoryButton(container);
		CreateComboBox cCombo = new CreateComboBox(container);


		table = cTable.getTable();
		combo = cCombo.getCombo();
		button = cButton.getDirectoryButton();
		text = cButton.getText();

	}

	public void update(String str) {
		TableItem item = new TableItem(table,SWT.NONE);
		item.setText(0,str);
		item.setText(1,"〇");
		item.setText(2,"×");
		item.setText(3,"〇");
		item.setText(4,"×");
	}

	public String getDirectory() {
		return text.getText();
	}
	@Override
	public void setFocus() {
		// TODO 自動生成されたメソッド・スタブ

	}


}
