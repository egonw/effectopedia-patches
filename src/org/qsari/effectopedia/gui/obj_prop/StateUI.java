/**
 * 
 */
package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.data.quantification.AggregationFunction;
import org.qsari.effectopedia.data.quantification.AggregationFunction.AggregationType;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * @author Hristo Aladjov
 * 
 */
public class StateUI extends ContextSensitivePanel implements LoadableEditorUI, SizeOptimizableUI, ActionListener
	{
		
		/**
		 * @param args
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new StateUI("Aggregation response funciton",null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		/**
		 * 
		 */
		public StateUI(String title,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI(title);
			}
		
		public void initGUI(String title)
			{
				this.setPreferredSize(optimalSize);
				this.setBorder(BorderFactory.createTitledBorder(title));
				BorderLayout thisLayout = new BorderLayout();
				this.setLayout(thisLayout);
				this.setBackground(Color.white);
					{
						qrauiAggregationFn = new QuantitativeRelationship_AnalyticUI("",rootHelpContext);
						jpAggregationType = getAggregationTypePanel();
						ctpAggregationFn = new CollapsableTitledPanel(qrauiAggregationFn, jpAggregationType, false,rootHelpContext);
						ctpAggregationFn.setVisible(needsAggregation);
						this.add(ctpAggregationFn, BorderLayout.CENTER);
					}
					{
						qrnuiState = new QuantitativeRelationship_NonlinearUI("",rootHelpContext);
						this.add(qrnuiState, BorderLayout.NORTH);
					}
			}
		
		protected JPanel getAggregationTypePanel()
			{
				JPanel panel = new JPanel();
				panel.setBackground(Color.white);
				panel.setLayout(new BorderLayout());
					{
						jlAggregationType = new JLabel("Upstream cause(s) aggregation: ");
						panel.add(jlAggregationType, BorderLayout.WEST);
					}
					{
						ComboBoxModel<AggregationType> jcbAggregationTypeModel = new DefaultComboBoxModel<AggregationType>(AggregationFunction.AGGREGATION_TYPES);
						jcbAggregationType = new JComboBox<AggregationType>();
						panel.add(jcbAggregationType, BorderLayout.CENTER);
						jcbAggregationType.setModel(jcbAggregationTypeModel);
						jcbAggregationType.setBackground(Color.white);
						jcbAggregationType.addActionListener(this);
					}
				return panel;
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof AggregationFunction)
					{
						loading = true;
						this.stateFn = (AggregationFunction) o;
						this.setBorder(BorderFactory.createTitledBorder(((Titleable) stateFn.getOwner()).getTitle()));
						needsAggregation = this.stateFn.getFactors().getCount() > 1;
						updateGUI();
						qrnuiState.load(stateFn, readonly);
						jcbAggregationType.setSelectedItem(stateFn.getAggregationType());
						if (needsAggregation)
							qrauiAggregationFn.load(stateFn, readonly);
						this.setVisible(needsAggregation || predictiveMode);
						loading = false;
						updateOptimalSize();
					}
			}
		
		protected void updateGUI()
			{
				qrnuiState.setVisible(predictiveMode);
				ctpAggregationFn.setVisible(needsAggregation);
				updateOptimalSize();
			}
		
		@Override
		public void updateOptimalSize()
			{
				optimalSize.width = qrnuiState.getPreferredSize().width;
				optimalSize.height = (predictiveMode) ? qrnuiState.getPreferredSize().height : 0;
				if (needsAggregation)
					optimalSize.height += ctpAggregationFn.getPreferredSize().height;
				if (this.isVisible())
					{
						Insets insets = this.getBorder().getBorderInsets(this);
						optimalSize.height += insets.bottom + insets.top;
					}
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
		
		public void actionPerformed(ActionEvent arg0)
			{
				if (loading)
					return;
				Object source = arg0.getSource();
				if (source == jcbAggregationType)
					stateFn.setAggregationType((AggregationType) jcbAggregationType.getModel().getSelectedItem());
			}
		
		protected boolean isPredictiveMode()
			{
				return predictiveMode;
			}
		
		protected void setPredictiveMode(boolean predictiveMode)
			{
				this.predictiveMode = predictiveMode;
			}
		
		protected boolean isNeedsAggregation()
			{
				return needsAggregation;
			}
		
		protected JComboBox<AggregationType>											jcbAggregationType;
		protected JLabel																															jlAggregationType;
		protected JPanel																															jpAggregationType;
		protected QuantitativeRelationship_AnalyticUI		qrauiAggregationFn;
		protected CollapsableTitledPanel															ctpAggregationFn;
		protected QuantitativeRelationship_NonlinearUI	qrnuiState;
		protected boolean																														needsAggregation	= false;
		protected boolean																														predictiveMode			= false;
		
		protected AggregationFunction																		stateFn;
		private Dimension																														optimalSize						= new java.awt.Dimension(400, 600);
		
		/**
	 * 
	 */
		private static final long																						serialVersionUID	= 1L;
		private boolean																																loading										= false;
	}
