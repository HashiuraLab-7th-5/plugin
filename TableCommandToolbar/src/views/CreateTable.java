package views;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class CreateTable {

	Table table;
	GridData gd = new GridData();

	public CreateTable(Composite container) {
		String MicroStructure[] = {"Aggregation", "Inheritance", "Delegation", "Leaf Class", "Node Class", "Realization", "Redorectopn"};

		gd.heightHint = 200;
		gd.widthHint = 700;
		gd.horizontalSpan = 2;

		TableViewer viewer = new TableViewer(container,SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);

		table = viewer.getTable();
		table.setLayoutData(gd);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn col1 = new TableColumn(table,SWT.LEFT);
		col1.setText("Miceo-StructureÅ_Class");
		col1.setWidth(200);
		TableColumn col2 = new TableColumn(table,SWT.LEFT);
		col2.setText("Graphic");
		col2.setWidth(150);
		TableColumn col3 = new TableColumn(table,SWT.LEFT);
		col3.setText("Picture");
		col3.setWidth(130);
		TableColumn col4 = new TableColumn(table,SWT.LEFT);
		col4.setText("Line");
		col4.setWidth(130);
		TableColumn col5 = new TableColumn(table,SWT.LEFT);
		col5.setText("Rectangle");
		col5.setWidth(130);

		for(int i = 1; i <= MicroStructure.length; i++)
		{
			TableItem item = new TableItem(table,SWT.NONE);
			item.setText(0,MicroStructure[i-1]);
			item.setText(1,"ÅZ");
			item.setText(2,"Å~");
			item.setText(3,"ÅZ");
			item.setText(4,"Å~");
		}
	}

	Table getTable() {
		return table;
	}
}
