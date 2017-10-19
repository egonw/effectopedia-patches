package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Nonlinear;
import org.qsari.effectopedia.gui.LinkExperimentalEvicencesUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.RootHelpContext;

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
public class ExperimentalDataEvidencesUI extends CollapsableTitledPanel implements LoadableEditorUI, SizeOptimizableUI
	{
		
		public ExperimentalDataEvidencesUI(RootHelpContext rootHelpContext)
			{
				super(new JPanel(), new EvidenceTitleUI(rootHelpContext), false,rootHelpContext);
				evidencesUI = (JPanel) getBodyPanel();
				titleUI = (EvidenceTitleUI) getTitlePanel();
				setAllowRedirecting(false);
				setAllowHTMLContent(false);
				setName("experimental");
				initEvidenceUI();
			}
		
		private void initEvidenceUI()
			{
				try
					{
							{
								this.evidencesUI.setBackground(Color.white);
								BoxLayout thisLayout = new BoxLayout(this.evidencesUI, javax.swing.BoxLayout.Y_AXIS);
								this.setBorder(BorderFactory.createTitledBorder(null, "Support evidences", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
								collapsedHeight = 40;
								this.evidencesUI.setLayout(thisLayout);
									{
										qrnuiExpermimentalData = new QuantitativeRelationship_NonlinearUI(rootHelpContext);
										this.evidencesUI.add(qrnuiExpermimentalData);
										qrnuiExpermimentalData.setVisible(false);
										titleUI.setEvidenceUI(qrnuiExpermimentalData);
									}
									{
										leeuiExperimentalEvidences = new LinkExperimentalEvicencesUI(rootHelpContext);
										this.evidencesUI.add(leeuiExperimentalEvidences);
									}
								RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof FunctionalRelationship)
					fnRel = (FunctionalRelationship) o;
				else
					return;
				if (fnRel.getOwner() instanceof Link_EffectToEffect)
					link = (Link_EffectToEffect) fnRel.getOwner();
				else
					return;
				leeuiExperimentalEvidences.load(fnRel, readonly);
				loadTransformedTemplate();
				titleUI.setFnRelUI(fnRelUI);
				titleUI.load(fnRel, readonly);
			}
		
		public void loadTransformedTemplate()
			{
				DataTemplates templates = leeuiExperimentalEvidences.getTransformedDataTemplate();
				if (templates != null)
					{
						qrnuiExpermimentalData.load(templates, true);
						qrnuiExpermimentalData.setVisible(true);
						titleUI.enableRRGeneration(fnRel instanceof FunctionalRelationship_Nonlinear, templates);
					}
				updateOptimalSize();
			}
		
		public LinkExperimentalEvicencesUI getLinkExperimentalEvicencesUI()
			{
				return leeuiExperimentalEvidences;
			}
		
		public void setFnRelUI(JPanel fnRelUI)
			{
				this.fnRelUI = fnRelUI; 
			}
		
		public JPanel getFnRelUI()
			{
				return fnRelUI;
			}

		public EvidenceTitleUI getTitleUI()
			{
				return titleUI;
			}
		

		/**
	 * 
	 */
		private static final long																				serialVersionUID	= 1L;
		private FunctionalRelationship															fnRel;
		private Link_EffectToEffect																		link;
		private JPanel																															fnRelUI;
		private JPanel																															evidencesUI;
		private EvidenceTitleUI																						titleUI;
		private LinkExperimentalEvicencesUI										leeuiExperimentalEvidences;
		private QuantitativeRelationship_NonlinearUI	qrnuiExpermimentalData;
	}
