package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.TransformationFunctionType;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.AdjustbleUserInterfaceTools;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
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
public class TransformationFunctionUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, ActionListener
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public TransformationFunctionUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
			}
		
		public void initGUI()
			{
				BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
				this.setLayout(thisLayout);
				this.setBackground(Color.white);
					{
						jpTransformationSettings = new JPanel();
						BorderLayout jpTransformationSettingsLayout = new BorderLayout();
						jpTransformationSettings.setLayout(jpTransformationSettingsLayout);
						this.add(jpTransformationSettings);
						jpTransformationSettings.setBackground(Color.white);
							{
								ComboBoxModel<TransformationFunctionType> jcbTransformationTypeModel = new DefaultComboBoxModel<TransformationFunctionType>(TransformationFunctionType.TYPES);
								jcbTransformationType = new JComboBox<TransformationFunctionType>();
								jpTransformationSettings.add(jcbTransformationType, BorderLayout.CENTER);
								jcbTransformationType.setModel(jcbTransformationTypeModel);
								jcbTransformationType.setBackground(Color.white);
								jcbTransformationType.addActionListener(this);
							}
							{
								jlTransform = new JLabel();
								jpTransformationSettings.add(jlTransform, BorderLayout.WEST);
								jlTransform.setText("Transform: ");
							}
					}
					{
						analyticFnRelUI = new QuantitativeRelationship_AnalyticUI(rootHelpContext);
						this.add(analyticFnRelUI);
					}
				
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				TransformationFunctionType transformationType = (TransformationFunctionType) jcbTransformationType.getSelectedItem();
				if ((fnRel!=null)&&(transformationType != fnRel.getTransformationType()) && (parentListUI != null))
					{
						fnRel.setTransformationType(transformationType);
						fnRel = parentListUI.generateDefaultTitles(fnRel);
						analyticFnRelUI.updateChart();
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if ((o == null) || !(o instanceof FunctionalRelationship))
					{
						fnRel = null;
						analyticFnRelUI = null;
						return;
					}
				fnRel = (FunctionalRelationship) o;
				jcbTransformationType.setSelectedItem(fnRel.getTransformationType());
				analyticFnRelUI.load(fnRel, readonly);
			}
		
		@Override
		public void updateOptimalSize()
			{
				if (analyticFnRelUI != null)
					{
						optimalSize.width = analyticFnRelUI.getPreferredSize().width;
						optimalSize.height = analyticFnRelUI.getPreferredSize().height;
					}
				optimalSize.height += jpTransformationSettings.getPreferredSize().height;
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
		
		public TransformationFunctionsListUI getParentListUI()
			{
				return parentListUI;
			}
		
		public void setParentListUI(TransformationFunctionsListUI parentListUI)
			{
				this.parentListUI = parentListUI;
			}
		
		protected FunctionalRelationship														fnRel;
		private Dimension																													optimalSize	= new Dimension(400, 300);
		private QuantitativeRelationship_AnalyticUI			analyticFnRelUI;
		private JPanel																																jpTransformationSettings;
		private JComboBox<TransformationFunctionType>	jcbTransformationType;
		private JLabel																																jlTransform;
		private TransformationFunctionsListUI									parentListUI;
	}
