package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship.EvidenceType;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Analytic;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.AdjustbleUserInterfaceTools;
import org.qsari.effectopedia.gui.LinkExperimentalEvicencesUI.TransformedTemplatesChangeListener;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.EvidenceTitleUI.EvidenceTypeChangeListener;

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
public class EvidenceBasedFnRelUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, TransformedTemplatesChangeListener, EvidenceTypeChangeListener
	{
		
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		public EvidenceBasedFnRelUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("fn_rel");
				initGUI();
			}
			
		public void initGUI()
			{
				BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
				this.setLayout(thisLayout);
				this.setBackground(Color.white);
				this.removeAll();
					{
						fnRelUI = analytic ? new QuantitativeRelationship_AnalyticUI(rootHelpContext) : new QuantitativeRelationship_NonlinearUI(rootHelpContext);
						this.add(fnRelUI);
					}
				if (evidenceType.equals(EvidenceType.EXPERIMENTAL_DATA))
					{
						if (experimentalEvidencesUI == null)
							{
								experimentalEvidencesUI = new ExperimentalDataEvidencesUI(rootHelpContext);
								experimentalEvidencesUI.getLinkExperimentalEvicencesUI().addDataTemplateChangeListener(this);
								experimentalEvidencesUI.getTitleUI().addEvidenceTypeChangeListener(this);
							}
						experimentalEvidencesUI.setFnRelUI(fnRelUI);
						this.add(experimentalEvidencesUI);
					}
				else if (evidenceType.equals(EvidenceType.IN_SILICO_MODEL))
					{
						if (inSilicoModelUI == null)
							{
								inSilicoModelUI = new InSilicoModelDataEvidencesUI(rootHelpContext);
								inSilicoModelUI.setFnRelUI(fnRelUI);
								inSilicoModelUI.getTitleUI().addEvidenceTypeChangeListener(this);
							}
						this.add(inSilicoModelUI);
					}
				RootHelpContext.addMouseMotionListeners(this, rootHelpContext, false);
			}
			
		public void load(Object o, boolean readonly)
			{
				if ((o == null) || !(o instanceof FunctionalRelationship))
					{
						fnRel = null;
						fnRelUI = null;
						experimentalEvidencesUI = null;
						return;
					}
				fnRel = (FunctionalRelationship) o;
				analytic = fnRel instanceof FunctionalRelationship_Analytic;
				evidenceType = fnRel.getEvidenceType();
				initGUI();
				((LoadableEditorUI) fnRelUI).load(fnRel, readonly);
				if ((evidenceType.equals(EvidenceType.EXPERIMENTAL_DATA)) && (experimentalEvidencesUI != null))
					{
						experimentalEvidencesUI.load(fnRel, readonly);
						experimentalEvidencesUI.updateOptimalSize();
					}
				else if ((evidenceType.equals(EvidenceType.IN_SILICO_MODEL)) && (inSilicoModelUI != null))
					{
						inSilicoModelUI.load(fnRel, readonly);
						inSilicoModelUI.updateOptimalSize();
					}
				updateOptimalSize();
			}
			
		@Override
		public void evidenceTypeChanged(EventObject event)
			{
				load(fnRel, false);
				if ((evidenceType.equals(EvidenceType.EXPERIMENTAL_DATA)) && (experimentalEvidencesUI != null))
					experimentalEvidencesUI.setExpanded(true);
				else if ((evidenceType.equals(EvidenceType.IN_SILICO_MODEL)) && (inSilicoModelUI != null))
					inSilicoModelUI.setExpanded(true);
			}
			
		@Override
		public void transformedTemplateChanged(EventObject event)
			{
				experimentalEvidencesUI.loadTransformedTemplate();
			}
			
		@Override
		public void updateOptimalSize()
			{
				if (fnRelUI != null)
					{
						optimalSize.width = fnRelUI.getPreferredSize().width;
						optimalSize.height = fnRelUI.getPreferredSize().height;
					}
				if ((evidenceType.equals(EvidenceType.EXPERIMENTAL_DATA)) && (experimentalEvidencesUI != null))
					optimalSize.height += experimentalEvidencesUI.getPreferredSize().height;
				else if ((evidenceType.equals(EvidenceType.IN_SILICO_MODEL)) && (inSilicoModelUI != null))
					optimalSize.height += inSilicoModelUI.getPreferredSize().height;
				
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				setMinimumSize(optimalSize);
				setMaximumSize(optimalSize);
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
			
		@Override
		public void adjustUI(long visualOptions)
			{
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
			
		protected FunctionalRelationship					fnRel;
		private boolean																						analytic					= false;
		private EvidenceType																	evidenceType	= EvidenceType.EXPERIMENTAL_DATA;
		private Dimension																				optimalSize		= new Dimension(400, 300);
		private JPanel																							fnRelUI;
		private ExperimentalDataEvidencesUI		experimentalEvidencesUI;
		private InSilicoModelDataEvidencesUI	inSilicoModelUI;
		
	}
