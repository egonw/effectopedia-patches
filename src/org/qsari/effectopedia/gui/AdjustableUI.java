/**
 * 
 */
package org.qsari.effectopedia.gui;

/**
 * @version 1.0 @(#)AdjustableUI.java 1.0
 * @author Hristo Aladjov
 * 
 */

public interface AdjustableUI
	{
		
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components.
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		public void adjustUI(long visualOptions);
		
		public static final long	LABELS								= 0x00000001L;
		public static final long	AUTOIDS							= 0x00000002L;
		public static final long	LIST_TOOLBARS	= 0x00000004L;
		
		public static final long	DESCRIPTION			= 0x00000100L;
		public static final long	CONTEXT							= 0x00000200L;
		public static final long	REFERENCES				= 0x00000400L;
		public static final long	QA   			     	= 0x00000800L;
		public static final long	HEADER								= 0x00001000L;
		
		public static final long	LABS										= 0x00002000L;
		
		public static final long	CHEM2DIMAGE			= 0x00000100L;
		public static final long	CHEMINFO						= 0x00000200L;
		public static final long	CHEMPROP						= 0x00000400L;
		public static final long	CHEMSYNONYMS		= 0x00000800L;
		
		public static final long	DISCUSSTOPIC		= 0x00001000L;
		public static final long	DISCUSSPOST			= 0x00002000L;
		public static final long	DISCUSSREPLY		= 0x00002000L;
		
		public static final long	RELATEDLNK				= 0x00001000L;
		public static final long	RELATEDSUGG			= 0x00002000L;
		public static final long	RELATEDNEW				= 0x00002000L;
		
		public static final long	SUBST_VIEW				= CHEM2DIMAGE+CHEMINFO;
		public static final long	VIEW										= 0xFFFFFF00L;
		public static final long	EDIT										= 0xFFFFFFFFL;
	}
