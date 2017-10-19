package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InLab;
import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.TransformationFunctionType;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.gui.comp.LinePanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.ReferenceIDsComboBoxModel;

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
public class LinkExperimentalEvicencesUI extends ContextSensitivePanel implements LoadableEditorUI, ActionListener
	{
		/**
		* 
		*/
		private static final long	serialVersionUID		= 1L;
		public final static int			UP																= 0;
		public final static int			DOWN														= 1;
		public final static int			LABEL													= 0;
		public final static int			NAME														= 1;
		public final static int			UNIT														= 2;
		
		public final String[]					IN_VIVO_RESPONSE		= new String[]
			{ "In-vivo Response", "in-vivo response", "in-vivo resp. unit" };
		public final String[]					IN_VIVO_TREATMENT	= new String[]
			{ "In-vivo Treatment", "in-vivo treatment", "in-vivo treat. unit" };
		public final String[]					TEST_RESPONSE					= new String[]
			{ "Test Response", "test response", "test resp. unit" };
		public final String[]					TEST_TREATMENT				= new String[]
			{ "Test Treatment", "test treatment", "test treat. unit" };
			
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LinkExperimentalEvicencesUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public LinkExperimentalEvicencesUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("experimental_evicences");
				transformedTemplateChangeListeners = new ArrayList<TransformedTemplatesChangeListener>();
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						GridBagLayout thisLayout = new GridBagLayout();
						this.setPreferredSize(new java.awt.Dimension(535, 327));
						thisLayout.rowWeights = new double[]
							{ 0.1, 0.3, 0.1, 0.3, 0.1, 0.1, 0.1 };
						thisLayout.rowHeights = new int[]
							{ 20, 60, 20, 60, 20, 20, 20 };
						thisLayout.columnWeights = new double[]
							{ 0.1, 0.45, 0.45, 0.2, 0.1, 0.45, 0.45 };
						thisLayout.columnWidths = new int[]
							{ 24, 60, 60, 40, 20, 60, 60 };
						this.setLayout(thisLayout);
						this.setBackground(Color.white);
							{
								jlTransformationSet[UP] = new JLabel();
								this.add(jlTransformationSet[UP], new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jlTransformationSet[UP].setText(TRANSFORMATION_SET_LABELS[0]);
								jlTransformationSet[UP].setName("up_tr_set");
							}
							{
								jcbTransformationSetModel[UP] = new ReferenceIDsComboBoxModel<TransformationSet>();
								jcbTransformationSet[UP] = new JComboBox<TransformationSet>();
								this.add(jcbTransformationSet[UP], new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbTransformationSet[UP].setModel(jcbTransformationSetModel[UP]);
								jcbTransformationSet[UP].setBackground(Color.white);
								jcbTransformationSet[UP].addActionListener(this);
								jcbTransformationSet[UP].setVisible(false);
								jcbTransformationSet[UP].setName("up_tr_set");
							}
							{
								jtfEffect[UP] = new JTextField();
								this.add(jtfEffect[UP], new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfEffect[UP].setText("Upstream (key) event / effect");
								jtfEffect[UP].setBorder(lightBorder);
								jtfEffect[UP].setName("upstream_effect");
							}
							{
								jcbTestModel[UP] = new ReferenceIDsComboBoxModel<Test>();
								jcbTest[UP] = new JComboBox<Test>();
								this.add(jcbTest[UP], new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbTest[UP].setModel(jcbTestModel[UP]);
								jcbTest[UP].setBackground(Color.white);
								jcbTest[UP].addActionListener(this);
								jcbTest[UP].setName("upstream_test");
							}
							{
								jcbStressorModel[UP] = new ReferenceIDsComboBoxModel<SubstanceData>();
								jcbStressor[UP] = new JComboBox<SubstanceData>();
								this.add(jcbStressor[UP], new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbStressor[UP].setModel(jcbStressorModel[UP]);
								jcbStressor[UP].setBackground(Color.white);
								jcbStressor[UP].addActionListener(this);
								jcbStressor[UP].setName("upstream_stressor");
							}
							{
								jbEffect[UP] = createButton(UIResources.imageEffect);
								this.add(jbEffect[UP], new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jbEffect[UP].setName("upstream_effect");
								
							}
							{
								jbTransfFunction[UP] = createButton(UIResources.imageTestResponseMapping);
								this.add(jbTransfFunction[UP], new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jbTransfFunction[UP].setName("up_tr_set");
							}
							{
								jbTest[UP] = createButton(UIResources.imageTest);
								this.add(jbTest[UP], new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jbTest[UP].setName("upstream_test");
							}
							{
								lpArrow1UP = new LinePanel(LinePanel.NORTH_ARROW);
								this.add(lpArrow1UP, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								lpArrow1UP.setBackground(Color.white);
							}
							{
								jpArrow2UP = new LinePanel(LinePanel.NORTH_ARROW);
								jpArrow2UP.setLayout(null);
								this.add(jpArrow2UP, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								jpArrow2UP.setBackground(Color.white);
							}
							{
								jpArrow3UP = new LinePanel(LinePanel.NE_CORNER);
								this.add(jpArrow3UP, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								jpArrow3UP.setBackground(Color.white);
							}
							{
								sduiInVivoResponse[UP] = new SampleDescriptionUI(IN_VIVO_RESPONSE[LABEL], IN_VIVO_RESPONSE[NAME], IN_VIVO_RESPONSE[UNIT], rootHelpContext);
								this.add(sduiInVivoResponse[UP], new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiInVivoResponse[UP].setName("up_in_vivo_response");
							}
							{
								sduiInVivoTreatment[UP] = new SampleDescriptionUI(IN_VIVO_TREATMENT[LABEL], IN_VIVO_TREATMENT[NAME], IN_VIVO_TREATMENT[UNIT], rootHelpContext);
								this.add(sduiInVivoTreatment[UP], new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiInVivoTreatment[UP].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, false));
								sduiInVivoTreatment[UP].setName("up_in_vivo_treatment");
							}
							{
								sduiTestResponse[UP] = new SampleDescriptionUI(TEST_RESPONSE[LABEL], TEST_RESPONSE[NAME], TEST_RESPONSE[UNIT], rootHelpContext);
								this.add(sduiTestResponse[UP], new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiTestResponse[UP].setName("up_test_response");
							}
							{
								sduiTestTreatment[UP] = new SampleDescriptionUI(TEST_TREATMENT[LABEL], TEST_TREATMENT[NAME], TEST_TREATMENT[UNIT], rootHelpContext);
								this.add(sduiTestTreatment[UP], new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiTestTreatment[UP].setName("up_test_treatment");
							}
							{
								jtfEffect[DOWN] = new JTextField();
								this.add(jtfEffect[DOWN], new GridBagConstraints(5, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfEffect[DOWN].setText("Downstream (key) event / effect");
								jtfEffect[DOWN].setBorder(lightBorder);
								jtfEffect[DOWN].setName("downstream_effect");
							}
							{
								jbEffect[DOWN] = createButton(UIResources.imageEffect);
								this.add(jbEffect[DOWN], new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jbEffect[DOWN].setName("downstream_effect");
							}
							{
								jbTransfFunction[DOWN] = createButton(UIResources.imageTestResponseMapping);
								this.add(jbTransfFunction[DOWN], new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jbTransfFunction[DOWN].setName("down_tr_set");
							}
							{
								jbTest[DOWN] = createButton(UIResources.imageTest);
								this.add(jbTest[DOWN], new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jbTest[DOWN].setName("downstream_test");
							}
							{
								jlTransformationSet[DOWN] = new JLabel();
								this.add(jlTransformationSet[DOWN], new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jlTransformationSet[DOWN].setText(TRANSFORMATION_SET_LABELS[0]);
								jlTransformationSet[DOWN].setName("down_tr_set");
							}
							{
								jcbTransformationSetModel[DOWN] = new ReferenceIDsComboBoxModel<TransformationSet>();
								jcbTransformationSet[DOWN] = new JComboBox<TransformationSet>();
								this.add(jcbTransformationSet[DOWN], new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbTransformationSet[DOWN].setModel(jcbTransformationSetModel[DOWN]);
								jcbTransformationSet[DOWN].setBackground(Color.white);
								jcbTransformationSet[DOWN].addActionListener(this);
								jcbTransformationSet[DOWN].setVisible(false);
								jcbTransformationSet[DOWN].setName("down_tr_set");
							}
							{
								jcbTestModel[DOWN] = new ReferenceIDsComboBoxModel<Test>();
								jcbTest[DOWN] = new JComboBox<Test>();
								this.add(jcbTest[DOWN], new GridBagConstraints(5, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbTest[DOWN].setModel(jcbTestModel[DOWN]);
								jcbTest[DOWN].setBackground(Color.white);
								jcbTest[DOWN].addActionListener(this);
								jcbTest[DOWN].setName("downstream_test");
							}
							{
								jcbStressorModel[DOWN] = new ReferenceIDsComboBoxModel<SubstanceData>();
								jcbStressor[DOWN] = new JComboBox<SubstanceData>();
								this.add(jcbStressor[DOWN], new GridBagConstraints(5, 5, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbStressor[DOWN].setModel(jcbStressorModel[DOWN]);
								jcbStressor[DOWN].setBackground(Color.white);
								jcbStressor[DOWN].addActionListener(this);
								jcbStressor[DOWN].setName("downstream_stressor");
							}
							{
								sduiInVivoTreatment[DOWN] = new SampleDescriptionUI(IN_VIVO_TREATMENT[LABEL], IN_VIVO_TREATMENT[NAME], IN_VIVO_TREATMENT[UNIT], rootHelpContext);
								this.add(sduiInVivoTreatment[DOWN], new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiInVivoTreatment[DOWN].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, false));
								sduiInVivoTreatment[DOWN].setName("down_in_vivo_treatement");
							}
							{
								sduiInVivoResponse[DOWN] = new SampleDescriptionUI(IN_VIVO_RESPONSE[LABEL], IN_VIVO_RESPONSE[NAME], IN_VIVO_RESPONSE[UNIT], rootHelpContext);
								this.add(sduiInVivoResponse[DOWN], new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiInVivoResponse[DOWN].setName("down_in_vivo_response");
							}
							{
								sduiTestTreatment[DOWN] = new SampleDescriptionUI(TEST_TREATMENT[LABEL], TEST_TREATMENT[NAME], TEST_TREATMENT[UNIT], rootHelpContext);
								this.add(sduiTestTreatment[DOWN], new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiTestTreatment[DOWN].setName("down_test_treatement");
							}
							{
								sduiTestResponse[DOWN] = new SampleDescriptionUI(TEST_RESPONSE[LABEL], TEST_RESPONSE[NAME], TEST_RESPONSE[UNIT], rootHelpContext);
								this.add(sduiTestResponse[DOWN], new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								sduiTestResponse[DOWN].setName("down_test_response");
							}
							{
								lpArrow1DN = new LinePanel(LinePanel.NORTH_ARROW);
								lpArrow1DN.setLayout(new BorderLayout());
								lpArrow1DN.add(getEquvalencePanel(false), BorderLayout.CENTER);
								this.add(lpArrow1DN, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
							{
								lpArrow2DN = new LinePanel(LinePanel.NORTH_ARROW);
								this.add(lpArrow2DN, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
							{
								lpArrow3DN = new LinePanel(LinePanel.NE_CORNER);
								this.add(lpArrow3DN, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
							{
								lpInVivoTreatmentEq = getEquvalencePanel(true);
								this.add(lpInVivoTreatmentEq, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
							{
								lpTestTreatment = new LinePanel(null);
								this.add(lpTestTreatment, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
							{
								lpStudy = new LinePanel(new int[][]
									{
									{ LinePanel.S | LinePanel.W, LinePanel.S | LinePanel.E },
									{ LinePanel.NS, LinePanel.NS } }).setLineStroke(LinePanel.LIGHT_STROKE);
								this.add(lpStudy, new GridBagConstraints(3, 4, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
							{
								jbStudy = createButton(UIResources.imageStudy);
								this.add(jbStudy, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jbStudy.setName("study");
							}
							{
								jcbStudyModel = new ReferenceIDsComboBoxModel<Method_Study>();
								jcbStudy = new JComboBox<Method_Study>();
								this.add(jcbStudy, new GridBagConstraints(1, 6, 6, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbStudy.setModel(jcbStudyModel);
								jcbStudy.setBackground(Color.white);
								jcbStudy.addActionListener(this);
								jcbStudy.setName("study");
							}
						RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);	
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		private JButton createButton(ImageIcon icon)
			{
				JButton button = new JButton();
				button.setMaximumSize(buttonSize);
				button.setMinimumSize(buttonSize);
				button.setPreferredSize(buttonSize);
				button.setBackground(Color.white);
				button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				button.setIcon(icon);
				return button;
			}
			
		private LinePanel getEquvalencePanel(boolean opaque)
			{
				LinePanel eqP = new LinePanel(new int[][]
					{
					{ 0 },
					{ LinePanel.EW },
					{ 0 } });
				eqP.setLineColor(Color.lightGray).setLineStroke(LinePanel.LIGHT_STROKE);
				eqP.setOpaque(opaque);
				return eqP;
				
			}
			
		public void loadEffect(Effect effect, ReferenceID<Test> referenceID, int interfaceIndex)
			{
				if (effect != null)
					{
						jtfEffect[interfaceIndex].setText(effect.getTitle());
						jcbTestModel[interfaceIndex].load(supportEvidences, interfaceIndex, effect.getRelatedTests(), false);
						Test test = (Test) supportEvidences.getCachedObject(interfaceIndex);
						if (!test.isDefaultID())
							jcbStressorModel[interfaceIndex].load(supportEvidences, stressorEvidenceIndex + interfaceIndex, test.getSubstanceData(), false);
						updateTransformationSet(test, interfaceIndex);
					}
			}
			
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof FunctionalRelationship)
					{
						fnRel = ((FunctionalRelationship) o);
						supportEvidences = fnRel.getSupportEvidenceIDs();
						link = (Link_EffectToEffect) fnRel.getOwner();
					}
				ReferenceID<Test> upstreamTestR = new ReferenceID<Test>();
				ReferenceID<Test> downstreamTestR = new ReferenceID<Test>();
				loadEffect(link.getFromEffect().getCachedObject(), upstreamTestR, UP);
				loadEffect(link.getToEffect().getCachedObject(), downstreamTestR, DOWN);
				updateStudy();
			}
			
		public void updateOptimalSize()
			{
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
				else
					invalidate();
			}
			
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				Object source = evt.getSource();
				for (int i = UP; i <= DOWN; i++)
					{
						if (source == jcbTest[i])
							{
								updateTest((Test) jcbTest[i].getSelectedItem(), i);
								return;
							}
						else if (source == jcbStressor[i])
							{
								updateStressor((SubstanceData) jcbStressor[i].getSelectedItem(), i);
								return;
							}
						else if (source == jcbTransformationSet[i])
							{
								updateTransformationSet((TransformationSet) jcbTransformationSet[i].getSelectedItem(), i);
								return;
							}
					}
				if (source == jcbStudy)
					updateStudy();
			}
			
		private void updateTest(Test test, int which)
			{
				if (!test.isDefaultID())
					{
						jcbStressorModel[which].load(supportEvidences, stressorEvidenceIndex + which, test.getSubstanceData(), false);
						updateTransformationSet(test, which);
					}
				updateStudy();
			}
			
		private void updateTransformationSet(Test test, int which)
			{
				if (test.isDefaultID())
					{
						jlTransformationSet[which].setText(TRANSFORMATION_SET_LABELS[0]);
						jcbTransformationSet[which].setVisible(false);
					}
				else
					{
						Effect effect = (which == UP) ? link.getFromEffect().getCachedObject() : link.getToEffect().getCachedObject();
						TestResponseMapping trm = test.getTestResponseMapping(effect);
						TransformationSet[] tss = trm.getTransformationSets().getCachedObjects();
						if ((tss == null) || (tss.length == 0))
							{
								jlTransformationSet[which].setText(TRANSFORMATION_SET_LABELS[0]);
								jcbTransformationSet[which].setVisible(false);
							}
						else
							{
								jlTransformationSet[which].setText(TRANSFORMATION_SET_LABELS[1]);
								jcbTransformationSet[which].setVisible(true);
								jcbTransformationSetModel[which].load(supportEvidences, transformationSetEvideceIndex + which, tss, false);
							}
					}
			}
			
		private void updateTransformationSet(TransformationSet transformationSet, int which)
			{
				jlTransformationSet[which].setText(TRANSFORMATION_SET_LABELS[2]);
				updateStressor((SubstanceData) jcbStressor[which].getSelectedItem(), which);
			}
			
		private void updateStressor(SubstanceData substanceData, int which)
			{
				SubstanceData upDataSubstance = (SubstanceData) supportEvidences.getCachedObject(stressorEvidenceIndex + UP);
				if (!upDataSubstance.isDefaultID())
					updateSimpleDescriptions(upDataSubstance.getTemplates(), UP);
				
				SubstanceData downDataSubstance = (SubstanceData) supportEvidences.getCachedObject(stressorEvidenceIndex + DOWN);
				if (!downDataSubstance.isDefaultID())
					updateSimpleDescriptions(downDataSubstance.getTemplates(), DOWN);
				
				if (!(upDataSubstance.isDefaultID() || downDataSubstance.isDefaultID()))
					{
						createTransformedTemplate(upDataSubstance.getTemplates(), downDataSubstance.getTemplates());
						fireDataTemplateChanged(new EventObject(this));
					}
			}
			
		private DataTemplates createTransformedTemplate(DataTemplates upDataTemplates, DataTemplates downDataTemplates)
			{
				transformedDataTemplate = new DataTemplates();
				transformedDataTemplate.setSecondaryAxisTemplateIndex();
				transformedDataTemplate.setChartTitle("Transformed dose responses");
				
				TransformationSet upTrSet = (TransformationSet) jcbTransformationSet[UP].getSelectedItem();
				TransformationSet downTrSet = (TransformationSet) jcbTransformationSet[DOWN].getSelectedItem();
				
				DataTemplate upDataTemplate = upDataTemplates.get(0).clone();
				upDataTemplate.cloneProperties(link);
				upDataTemplate.setMarkerOutlineColor(DefaultDataTemplates.DT_UPSTREAM.getMarkerOutlineColor());
				DataTemplate downDataTemplate = downDataTemplates.get(0).clone();
				downDataTemplate.cloneProperties(link);
				downDataTemplate.setMarkerOutlineColor(DefaultDataTemplates.DT_DOWNSTREAM.getMarkerOutlineColor());
				;
				transformedDataTemplate.add(upDataTemplate);
				transformedDataTemplate.add(downDataTemplate);
				
				if (upTrSet != null)
					{
						upTrSet.apply(upDataTemplate);
						transformedDataTemplate.setxAxisTitle(upTrSet.getTranformedTitle(TransformationFunctionType.TREATEMENT));
						transformedDataTemplate.setDefaultXDisplayUnit(upTrSet.getTranformedUnit(TransformationFunctionType.TREATEMENT));
						transformedDataTemplate.setyPrimaryAxisTitle(upTrSet.getTranformedTitle(TransformationFunctionType.RESPONSE));
						transformedDataTemplate.setDefaultYDisplayUnit(upTrSet.getTranformedUnit(TransformationFunctionType.RESPONSE));
						sduiInVivoResponse[UP].setLabels(transformedDataTemplate.getyPrimaryAxisTitle(), transformedDataTemplate.getDefaultYDisplayUnit());
						sduiInVivoTreatment[UP].setLabels(transformedDataTemplate.getxAxisTitle(), transformedDataTemplate.getDefaultXDisplayUnit());
					}
				else
					{
						transformedDataTemplate.setyPrimaryAxisTitle(upDataTemplates.getyPrimaryAxisTitle());
						transformedDataTemplate.setxAxisTitle(upDataTemplates.getxAxisTitle());
					}
				if (downTrSet != null)
					{
						downTrSet.apply(downDataTemplate);
						transformedDataTemplate.setxAxisTitle(downTrSet.getTranformedTitle(TransformationFunctionType.TREATEMENT));
						transformedDataTemplate.setDefaultXDisplayUnit(downTrSet.getTranformedUnit(TransformationFunctionType.TREATEMENT));
						transformedDataTemplate.setySecondaryAxisTitle(downTrSet.getTranformedTitle(TransformationFunctionType.RESPONSE));
						transformedDataTemplate.setSecondaryYDisplayUnit(downTrSet.getTranformedUnit(TransformationFunctionType.RESPONSE));
						sduiInVivoResponse[DOWN].setLabels(transformedDataTemplate.getySecondaryAxisTitle(), transformedDataTemplate.getSecondaryYDisplayUnit());
						sduiInVivoTreatment[DOWN].setLabels(transformedDataTemplate.getxAxisTitle(), transformedDataTemplate.getDefaultXDisplayUnit());
					}
				else
					{
						transformedDataTemplate.setySecondaryAxisTitle(downDataTemplates.getyPrimaryAxisTitle());
						if (downDataTemplates.getxAxisTitle() != upDataTemplates.getxAxisTitle())
							;// Show error;
					}
					
				return transformedDataTemplate;
			}
			
		private void updateSimpleDescriptions(DataTemplates templates, int which)
			{
				sduiTestResponse[which].setLabels(templates.getyPrimaryAxisTitle(), templates.getDefaultYDisplayUnit());
				sduiTestTreatment[which].setLabels(templates.getxAxisTitle(), templates.getDefaultXDisplayUnit());
				sduiInVivoResponse[which].setLabels(templates.getyPrimaryAxisTitle(), templates.getDefaultYDisplayUnit());
				sduiInVivoTreatment[which].setLabels(templates.getxAxisTitle(), templates.getDefaultXDisplayUnit());
			}
			
		private void updateStudy()
			{
				Test upstreamTest = (Test) supportEvidences.getCachedObject(UP);
				Test downstreamTest = (Test) supportEvidences.getCachedObject(DOWN);
				if ((upstreamTest instanceof Test_InLab) && (downstreamTest instanceof Test_InLab))
					{
						jcbStudyModel.load(supportEvidences, studyEvidenceIndex, ((Test_InLab) upstreamTest).getStudyIDs().getCachedObjects(), false);
						jcbStudyModel.intersectOptions(((Test_InLab) downstreamTest).getStudyIDs().getCachedObjects());
					}
			}
			
		public DataTemplates getTransformedDataTemplate()
			{
				return transformedDataTemplate;
			}
			
		public interface TransformedTemplatesChangeListener
			{
				public void transformedTemplateChanged(EventObject event);
			}
			
		public void addDataTemplateChangeListener(TransformedTemplatesChangeListener listener)
			{
				transformedTemplateChangeListeners.add(listener);
			}
			
		public void removeDataTemplateChangeListener(TransformedTemplatesChangeListener listener)
			{
				transformedTemplateChangeListeners.remove(listener);
			}
			
		protected void fireDataTemplateChanged(EventObject event)
			{
				for (TransformedTemplatesChangeListener listener : transformedTemplateChangeListeners)
					listener.transformedTemplateChanged(event);
			}
			
		public static String getSupportEvidenceDescription(FunctionalRelationship fnRel)
			{
				if (fnRel == null)
					return null;
				ReferenceIDs<EffectopediaObject> supportEvidences = fnRel.getSupportEvidenceIDs();
				StringBuilder sb = new StringBuilder();
				SubstanceData substanceData = (SubstanceData) supportEvidences.getCachedObject(UP + stressorEvidenceIndex);
				Test test;
				if (!substanceData.isDefaultID())
					{
						sb.append(substanceData.toString());
						test = (Test) supportEvidences.getCachedObject(LinkExperimentalEvicencesUI.UP);
						sb.append(" tested in ");
						sb.append(test.getTitle());
					}
				substanceData = (SubstanceData) supportEvidences.getCachedObject(DOWN + stressorEvidenceIndex);
				if (!substanceData.isDefaultID())
					{
						if (sb.length() > 0)
							sb.append(" and ");
						sb.append(substanceData.toString());
						test = (Test) supportEvidences.getCachedObject(LinkExperimentalEvicencesUI.DOWN);
						sb.append(" tested in ");
						sb.append(test.getTitle());
					}
				Method_Study study = (Method_Study) supportEvidences.getCachedObject(studyEvidenceIndex);
				if (!study.isDefaultID())
					{
						sb.append(". Both tests are part of ");
						sb.append(study.getTitle());
					}
				return sb.toString();
			}
			
		protected ArrayList<TransformedTemplatesChangeListener>	transformedTemplateChangeListeners;
		
		private DataTemplates																																			transformedDataTemplate							= null;
		private FunctionalRelationship																										fnRel;
		private ReferenceIDs<EffectopediaObject>																supportEvidences;
		private Link_EffectToEffect																													link;
		private LinePanel																																							lpArrow1UP;
		private LinePanel																																							jpArrow2UP;
		private LinePanel																																							jpArrow3UP;
		private LinePanel																																							lpArrow3DN;
		private LinePanel																																							lpArrow2DN;
		private LinePanel																																							lpArrow1DN;
		private LinePanel																																							lpStudy;
		private LinePanel																																							lpTestTreatment;
		private LinePanel																																							lpInVivoTreatmentEq;
		private JButton[]																																							jbEffect																						= new JButton[2];
		private JTextField[]																																				jtfEffect																					= new JTextField[2];
		private JButton[]																																							jbTransfFunction														= new JButton[2];
		private JButton[]																																							jbTest																								= new JButton[2];
		@SuppressWarnings("unchecked")
		private JComboBox<Test>[]																															jcbTest																							= (JComboBox<Test>[]) new JComboBox[2];
		@SuppressWarnings("unchecked")
		private ReferenceIDsComboBoxModel<Test>[]															jcbTestModel																		= (ReferenceIDsComboBoxModel<Test>[]) new ReferenceIDsComboBoxModel[2];
		public final static int																																	stressorEvidenceIndex									= 2;
		@SuppressWarnings("unchecked")
		private JComboBox<SubstanceData>[]																						jcbStressor																			= (JComboBox<SubstanceData>[]) new JComboBox[2];
		@SuppressWarnings("unchecked")
		private ReferenceIDsComboBoxModel<SubstanceData>[]						jcbStressorModel														= (ReferenceIDsComboBoxModel<SubstanceData>[]) new ReferenceIDsComboBoxModel[2];
		private JLabel[]																																								jlTransformationSet											= new JLabel[2];
		@SuppressWarnings("unchecked")
		private JComboBox<TransformationSet>[]																		jcbTransformationSet										= (JComboBox<TransformationSet>[]) new JComboBox[2];
		@SuppressWarnings("unchecked")
		private ReferenceIDsComboBoxModel<TransformationSet>[]		jcbTransformationSetModel					= (ReferenceIDsComboBoxModel<TransformationSet>[]) new ReferenceIDsComboBoxModel[2];
		public final static int																																	transformationSetEvideceIndex	= 5;
		private SampleDescriptionUI[]																											sduiTestResponse														= new SampleDescriptionUI[2];
		private SampleDescriptionUI[]																											sduiInVivoTreatment											= new SampleDescriptionUI[2];
		private SampleDescriptionUI[]																											sduiInVivoResponse												= new SampleDescriptionUI[2];
		private SampleDescriptionUI[]																											sduiTestTreatment													= new SampleDescriptionUI[2];
		public final static int																																	studyEvidenceIndex												= 4;
		private ReferenceIDsComboBoxModel<Method_Study>									jcbStudyModel;
		private JComboBox<Method_Study>																									jcbStudy;
		private JButton																																									jbStudy;
		private final String[]																																		TRANSFORMATION_SET_LABELS					= new String[]
			{ "No transformation", "Select transf. fn. set:", "Transf. fn. set:" };
		private final Border																																				lightBorder																			= BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
		private Dimension																																							buttonSize																				= new java.awt.Dimension(24, 24);
	}
