/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.gwt.foldermanager.client;

import com.ephesoft.dcma.gwt.core.client.DCMAEntryPoint;
import com.ephesoft.dcma.gwt.core.client.EphesoftAsyncCallback;
import com.ephesoft.dcma.gwt.core.client.i18n.LocaleInfo;
import com.ephesoft.dcma.gwt.core.client.ui.ScreenMaskUtility;
import com.ephesoft.dcma.gwt.core.client.view.RootPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class FolderManager extends DCMAEntryPoint<FolderManagerServiceAsync> {

	protected FolderManagementController controller = null;

	@Override
	public LocaleInfo createLocaleInfo(String locale) {
		return new LocaleInfo(locale, "folderManagerConstants", "folderManagerMessages");
	}

	@Override
	public FolderManagerServiceAsync createRpcService() {
		return GWT.create(FolderManagerService.class);
	}

	@Override
	public String getHomePage() {
		return "FolderManager.html";
	}

	@Override
	public void onLoad() {
		LayoutPanel layoutPanel = new LayoutPanel();
		controller = new FolderManagementController(eventBus, rpcService);
		layoutPanel.add(controller.createView());

		final RootPanel rootPanel = new RootPanel(layoutPanel, rpcService);
		rootPanel.getHeader().setEventBus(eventBus);
		rootPanel.getHeader().addTab("Batch Class Management", "BatchClassManagement.html", false);
		rootPanel.getHeader().addTab("Batch Instance Management", "BatchInstanceManagement.html", false);
		rootPanel.getHeader().addTab("Workflow Management", "CustomWorkflowManagement.html", false);
		rootPanel.getHeader().addNonClickableTab("Folder Management", "FolderManager.html");
		ScreenMaskUtility.maskScreen();

		rpcService.isReportingEnabled(new EphesoftAsyncCallback<Boolean>() {

			@Override
			public void customFailure(Throwable arg0) {
				//reporting is optional. Hence doing nothing on failure of getting whether reporting is enabled.
			}

			@Override
			public void onSuccess(Boolean isReportingEnabled) {
				if (isReportingEnabled) {
					rootPanel.getHeader().addTab("Reports", "Reporting.html", false);
				}

			}
		});

		rootPanel.getHeader().getTabBar().selectTab(3);
		rpcService.getUserName(new EphesoftAsyncCallback<String>() {

			@Override
			public void onSuccess(String userName) {
				if (userName != null) {
					rootPanel.getHeader().setUserName(userName);
				}
				ScreenMaskUtility.unmaskScreen();
			}

			@Override
			public void customFailure(Throwable arg0) {
				ScreenMaskUtility.unmaskScreen();
			}
		});

		RootLayoutPanel.get().add(rootPanel);
	}
}
