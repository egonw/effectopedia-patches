package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.ReferenceIDsTableUI;
import org.qsari.effectopedia.gui.ref_ids_table.ReferencesRIDTM;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.util.ClipboardUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ReferencesUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID	= 1L;
		private ListEditorToolbarUI	letuiReferences;
		private ReferencesTableUI			rtbuiReferences;
		
		class ReferencesTableUI extends ReferenceIDsTableUI<Reference> implements ClipboardTransferableUI
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ReferencesTableUI(boolean readonly)
					{
						super(new ReferencesRIDTM(null, readonly),false);
						setName("ref_table");
					}

				@Override
				public Reference add(boolean enableSelectionDialog)
					{
						Reference reference = DefaultEffectopediaObjects.DEFAULT_REFERENCE.clone();
						add(reference);
						return reference;
					}
				
				
				@Override
				public void copy()
					{
						if (references != null)
							{
								StringBuilder sb = new StringBuilder();
								Reference[] list = references.getCachedObjects();
								for (Reference reference : list)
									{
										sb.append(reference.getFormatedReference());
										sb.append("\n");
									}
								ClipboardUtilities.setClipboard(sb.toString());
							}
					}
				
				@Override
				public void paste()
					{
						if (references != null)
							{
								StringTokenizer st = new StringTokenizer(ClipboardUtilities.getClipboard(), "\n");
								while (st.hasMoreTokens())
									{
										Reference reference = DefaultEffectopediaObjects.DEFAULT_REFERENCE.clone();
										reference.setFormatedReference(st.nextToken());
										add(reference);
									}
							}
					}
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ReferencesUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ReferencesUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("references");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "References", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								rtbuiReferences = new ReferencesTableUI(false);
								this.add(rtbuiReferences, BorderLayout.CENTER);
								rtbuiReferences.addMouseMotionListener(this);
							}
							{
								letuiReferences = new ListEditorToolbarUI(rtbuiReferences, "referece", ListEditorToolbarUI.ALL, FlowLayout.RIGHT);
								this.add(letuiReferences, BorderLayout.SOUTH);
								letuiReferences.addMouseMotionListener(this);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components
		 * 
		 * @see AdjustableUI
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		public void adjustUI(long visualOptions)
		
			{
				this.setVisible((visualOptions & REFERENCES) != 0);
				letuiReferences.adjustUI(visualOptions);
			}
		
		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly)
			{
				if ((o != null) && (o instanceof ReferenceIDs))
					{
						references = (ReferenceIDs<Reference>) o;
						readonly = readonly || references.isReadonly();
						rtbuiReferences.setReferenceIDs(references, readonly);
						letuiReferences.updateEditButtons(readonly);
						rtbuiReferences.updateOptimalSize();
					}
			}
		
		public void updateOptimalSize()
			{
				Insets insets = this.getBorder().getBorderInsets(this);
				optimalSize.width = rtbuiReferences.getWidth() + insets.left + insets.right;
				optimalSize.height = letuiReferences.getPreferredSize().height + rtbuiReferences.getPreferredSize().height + insets.top + insets.bottom;
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				Container parent = getParent();
				while (parent != null)
					{
						if (parent instanceof SizeOptimizableUI)
							{
								((SizeOptimizableUI) parent).updateOptimalSize();
								break;
							}
						parent = parent.getParent();
					}
			}
		
		private Dimension	optimalSize	= new Dimension(400, 100);
		
		public void initializeUI()
			{
				rtbuiReferences.initializeUI();
			}
		
		ReferenceIDs<Reference>	references	= null;
	}
