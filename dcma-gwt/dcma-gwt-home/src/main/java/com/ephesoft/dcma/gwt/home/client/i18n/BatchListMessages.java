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

package com.ephesoft.dcma.gwt.home.client.i18n;

import com.ephesoft.dcma.gwt.core.client.i18n.LocaleCommonMessages;

/**
 * The interface is used to define all the messages used in the Batch List page and support internationalization.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.gwt.core.client.i18n.LocaleCommonMessages
 */
public interface BatchListMessages extends LocaleCommonMessages {

	/**
	 * The message indicating number of batches being shown on in the table, if on first page of batch list table.
	 */
	String MSG_TABLE_BATCHES_LIST = "msg_table_batches_list";

	/**
	 * The default value to be shown in the table.
	 */
	String MSG_TABLE_BATCHES_LIST_DEFAULT = "msg_table_batches_list_default";

	/**
	 * The value to be shown in there is no data in the table.
	 */
	String MSG_TABLE_NO_DATA = "msg_table_no_data";

	/**
	 * The message indicating number of batches being shown on in the table, if not on first page of batch list table.
	 */
	String MSG_TABLE_BATCHES_TWO = "msg_table_batches_two";

	/**
	 * Message displayed when no batch is found with entered text.
	 */
	String MSG_SEARCH_FAILURE = "search_failure";

	/**
	 * Message displayed when error occurs while searching for a batch.
	 */
	String MSG_SEARCH_ERROR = "search_error";

	/**
	 * Message displayed when error occurs retaining batch list priority.
	 */
	String ERROR_WHILE_RETAINING_BATCH_LIST_PRIORITY = "error_while_retaining_the_batch_list_priority";

}
