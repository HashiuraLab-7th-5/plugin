package makererrormap;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import views.View;

public class CreateTable extends Creator{

	Composite container;
	TabFolder tabfolder;

	public CreateTable(Composite container,TabFolder tabfolder) {

		this.container = container;
		this.tabfolder = tabfolder;
	}

	@Override
	public ProductTable createProduct() {
		// TODO 自動生成されたメソッド・スタブ
		String patternname = new String();
		ProductTable tableObject = null;

		try {
			// ConboBoxで選択されたパターンを調べる
			View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("Union3.ErrorView");
			patternname = view.getPattern();

		} catch (PartInitException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if		(patternname.equals("Factory Method"))
		{

			tableObject = new CreateFactoryMethodTable(container,tabfolder);
		}
		else if	(patternname.equals("Composite"))
		{
			tableObject = new CreateCompositeTable(container,tabfolder);
		}
		else if(patternname.equals("Adapter"))
		{
			tableObject = new CreateAdapterTable(container,tabfolder);
		}

		return tableObject;
	}

}
