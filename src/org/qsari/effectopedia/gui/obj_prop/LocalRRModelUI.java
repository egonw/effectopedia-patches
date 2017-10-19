package org.qsari.effectopedia.gui.obj_prop;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.objects.ModelPreset;
import org.qsari.effectopedia.data.objects.ModelPresets;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.quantification.Factor;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
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
public class LocalRRModelUI extends LocalDRModelUI
	{
		
		public LocalRRModelUI(RootHelpContext rootHelpContext)
		{
			super(rootHelpContext);
		}

		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new LocalRRModelUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof FunctionalRelationship)
					{
						funRel = (FunctionalRelationship) o;
						link = (Link) funRel.getOwner();
						model = funRel.getModel();
						method = funRel.getModelMethod();
						if (model.isDefaultID())
							model = null;
						gmsModelSelector.showToolbar(true);
						gmsModelSelector.load(funRel, readonly);
						if (model != null)
							{
								pmPresetModel.setModelPresets(model.getModelPersets());
								modelParameters = model.getModelParamaters();
								if (!model.hasDefaultPreset(ModelPresets.REQUESTED))
									{
										ModelPreset preset = new ModelPreset(getModelInput(), model.getModelParamaters(), getModelOutput());
										preset.setCalculated(false);
										preset.setTitle("Default model parameter values");
										preset.setDescription("All model parameters use their default values as defined by model developer");
										pmPresetModel.addElement(preset);
									}
								else
									mpvuiModelParameters.load(modelParameters, false);
							}
						updateInterface();
						updateOptimalSize();
					}
			}
		
		@Override
		protected ObjectProperties getModelInput()
			{
				PathwayElement upstreamElement = link.incommingAssociations()[0];
				if (upstreamElement instanceof Factor)
					return link.getModifyingFactors().combineWith(((Factor) upstreamElement).getCurrentState());
				return link.getModifyingFactors().getAllObjectProperties();
			}
		
		@Override
		protected ObjectProperties getModelOutput()
			{
				return funRel.getProperties();
			}

		@Override
		public void globalModelSelected(ActionEvent evt)
			{
				method = funRel.getModelMethod();
				load(funRel, false);
			}
		

		protected Link																			link;
		protected FunctionalRelationship	funRel;
		private static final long								serialVersionUID	= 1L;
	}
