package org.qsari.effectopedia.gui.nav;

import java.util.HashMap;

import org.qsari.effectopedia.gui.WelcomeUI;

public class GUIInitializations
	{
		private static final GUIInitializations	INSTANCE	= new GUIInitializations();
		
		private GUIInitializations()
			{
				
			}
		
		public GUIInitializations getUIInitializations()
			{
				return INSTANCE;
			}
		
		// public static final UIInitialization[] searchForPathway = {new
		// UIInitialization("jcbSearchFor", "setSelectedIndex", Integer.valueOf(5),
		// int.class),new UIInitialization("jtfClause", "setText", "Example1",
		// String.class)};
		// public static final UIInitialization[] searchForChemical = {new
		// UIInitialization("jcbSearchFor", "setSelectedIndex", Integer.valueOf(0),
		// int.class),new UIInitialization("jtfClause", "setText", "", String.class)};
		public static final GUIInitialization[]																		searchForPathway		=
																																																																													{ new GUIInitialization("jcbSearchFor", "setSelectedIndex", Integer.valueOf(1), int.class) };
		public static final GUIInitialization[]																		searchForChemical	=
																																																																													{ new GUIInitialization("jcbSearchFor", "setSelectedIndex", Integer.valueOf(0), int.class) };
		public static final GUIInitialization[]																		signIn												=
																																																																													{ new GUIInitialization("jcbSearchFor", "setSelectedIndex", Integer.valueOf(0), int.class) };
		public static final GUIInitialization[]																		feedback										=
																																																																													{ new GUIInitialization("jtpRedirect", "setText", WelcomeUI.feedbackHTML, String.class) };
		public static final GUIInitialization[]																		welcome											=
																																																																													{ new GUIInitialization("welcome", "loadDefault", null, null) };
		
		public static final HashMap<String, GUIInitialization[]>	MAP															= new HashMap<String, GUIInitialization[]>();
		static
			{
				MAP.put("pathwaySearch", searchForPathway);
				MAP.put("chemicalSearch", searchForChemical);
				MAP.put("signIn", signIn);
				MAP.put("feedback", feedback);
				MAP.put("welcome", welcome);
			}
	}
