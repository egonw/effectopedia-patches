package org.qsari.effectopedia.gui.obj_prop;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.data.objects.ModelPreset;
import org.qsari.effectopedia.data.objects.ModelPresets;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class LocalDRModelUI extends LocalModelUI
	{
		public LocalDRModelUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
			}
			
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new LocalDRModelUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof SubstanceData_InSilico)
					{
						substanceData = (SubstanceData_InSilico) o;
						model = substanceData.getModel();
						method = substanceData.getModelMethod();
						gmsModelSelector.showToolbar(false);
						// Test_InSilico test =
						// (Test_InSilico)substanceData.getTest().getCachedObject();
						// gmsModelSelector.load(test.getGlobalModelIDs(), readonly);
						gmsModelSelector.load(substanceData, readonly);
						gmsModelSelector.setSelectedItem(model);
						if (model != null)
							{
								pmPresetModel.setModelPresets(model.getModelPersets());
								modelParameters = model.getModelParamaters();
								if (!model.hasDefaultPreset(ModelPresets.REQUESTED))
									{
										ModelPreset preset = new ModelPreset(substanceData.getLocalModelInputProperties(), model.getModelParamaters(), substanceData.getObjectProperties());
										preset.setCalculated(false);
										preset.setTitle("Default model parameter values");
										preset.setDescription("All model parameters use their default values as defined by model developer");
										pmPresetModel.addElement(preset);
									}
								else
									mpvuiModelParameters.load(modelParameters, false);
							}
						updateInterface();
					}
			}
			
		@Override
		protected ObjectProperties getModelInput()
			{
				return substanceData.getLocalModelInputProperties();
			}
			
		@Override
		protected ObjectProperties getModelOutput()
			{
				return substanceData.getObjectProperties();
			}
			
		@Override
		public void globalModelSelected(ActionEvent evt)
			{
				method = substanceData.getModelMethod();
				load(substanceData, false);
			}
			
		protected SubstanceData_InSilico	substanceData;
		private static final long								serialVersionUID	= 1L;
	}
