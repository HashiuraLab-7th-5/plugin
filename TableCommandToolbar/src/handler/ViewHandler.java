package handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import views.View;

public class ViewHandler implements IHandler {

	public ViewHandler() {
		System.out.println("Handlerのコンストラクタから");
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO 自動生成されたメソッド・スタブ

		try {
			View view = (View) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("TableCommandToolbar.view");
			//動作確認用　
			//view.update("excetuから");

			System.out.println("Handlerのexecuteから");
			System.out.println(view.getDirectory());

		} catch (PartInitException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ

	}



	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
