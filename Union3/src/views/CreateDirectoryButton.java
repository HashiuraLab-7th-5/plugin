package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CreateDirectoryButton {

	Text text;
	Button directory;
	GridData gd;
	String path;


	public CreateDirectoryButton(Composite container) {


		gd = new GridData();
		gd.horizontalSpan = 1;
		Button button = new Button(container,SWT.PUSH);
		button.setText("�f�B���N�g���̑I��");
		button.setLayoutData(gd);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(new Shell());
				path = dialog.open();
				text.setText(path);
			}
		});

		gd = new GridData();
		gd.horizontalSpan = 1;
		gd.widthHint = 300;
		text = new Text(container,SWT.SINGLE);
		text.setText("C:\\pleiades\\workspace\\�f�U�C���p�^�[��");
	}

	Button getDirectoryButton() {
		return directory;
	}

	Text getText() {
		return text;
	}

	String getPath() {
		return path;
	}

}
