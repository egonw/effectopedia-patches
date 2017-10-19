package org.qsari.effectopedia.gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.core.objects.Test_InChemico;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;

public class UIResources
	{
		private static final UIResources INSTANCE = new UIResources();
		
		private UIResources()
			{
				
			}
			
		public UIResources getGOUtils()
			{
				return INSTANCE;
			}
			
		public static final ImageIcon	imageIconMicroPlus													= new ImageIcon(UIResources.class.getResource("res/plus7x7.png"));
		public static final ImageIcon	imageIconMicroMinus												= new ImageIcon(UIResources.class.getResource("res/minus7x7.png"));
		public static final ImageIcon	imageIconAdd																			= new ImageIcon(UIResources.class.getResource("res/Add15x15.png"));
		public static final ImageIcon	imageIconDelete																= new ImageIcon(UIResources.class.getResource("res/Delete15x15.png"));
		public static final ImageIcon	imageIconReset																	= new ImageIcon(UIResources.class.getResource("res/Reset15x15.png"));
		public static final ImageIcon	imageIconDiscuss															= new ImageIcon(UIResources.class.getResource("res/Discuss15x15.png"));
		public static final ImageIcon	imageIconChat																		= new ImageIcon(UIResources.class.getResource("res/Chat15x15.png"));
		public static final ImageIcon	imageIconSend																		= new ImageIcon(UIResources.class.getResource("res/Send15x15.png"));
		public static final ImageIcon	imageIconCopy																		= new ImageIcon(UIResources.class.getResource("res/Copy15x15.png"));
		public static final ImageIcon	imageIconPaste																	= new ImageIcon(UIResources.class.getResource("res/Paste15x15.png"));
		public static final ImageIcon	imageIconShow																		= new ImageIcon(UIResources.class.getResource("res/Show15x18.png"));
		public static final ImageIcon	imageIconHide																		= new ImageIcon(UIResources.class.getResource("res/Hide15x18.png"));
		public static final ImageIcon	imageIconOptions															= new ImageIcon(UIResources.class.getResource("res/options15x15.png"));
		
		public static final ImageIcon	imageIconExpand																= new ImageIcon(UIResources.class.getResource("res/Expand16x16.png"));
		public static final ImageIcon	imageIconCollapse														= new ImageIcon(UIResources.class.getResource("res/Collapse16x16.png"));
		public static final ImageIcon	imageIconExpandAct													= new ImageIcon(UIResources.class.getResource("res/ExpandA16x16.png"));
		public static final ImageIcon	imageIconCollapseAct											= new ImageIcon(UIResources.class.getResource("res/CollapseA16x16.png"));
		public static final ImageIcon	imageIconExpandAll													= new ImageIcon(UIResources.class.getResource("res/ExpandAll17x28.png"));
		public static final ImageIcon	imageIconCollapseAll											= new ImageIcon(UIResources.class.getResource("res/CollapseAll17x28.png"));
		public static final ImageIcon	imageIconExpandAllAct										= new ImageIcon(UIResources.class.getResource("res/ExpandAllA17x28.png"));
		public static final ImageIcon	imageIconCollapseAllAct								= new ImageIcon(UIResources.class.getResource("res/CollapseAllA17x28.png"));
		
		public static final ImageIcon	imageHTML																						= new ImageIcon(UIResources.class.getResource("res/HTML40x16.png"));
		public static final ImageIcon	imageHTMLOver																		= new ImageIcon(UIResources.class.getResource("res/HTMLO40x16.png"));
		public static final ImageIcon	imageHTMLAct																			= new ImageIcon(UIResources.class.getResource("res/HTMLA40x16.png"));
		
		public static final ImageIcon	imageFileOpen																		= new ImageIcon(UIResources.class.getResource("res/FileOpen24x28.png"));
		public static final ImageIcon	imageFileSave																		= new ImageIcon(UIResources.class.getResource("res/FileSave24x24.png"));
		public static final ImageIcon	imagePublish																			= new ImageIcon(UIResources.class.getResource("res/Publish24x24.png"));
		public static final ImageIcon	imageIconMCopy																	= new ImageIcon(UIResources.class.getResource("res/Copy20x20.png"));
		public static final ImageIcon	imageIconMPaste																= new ImageIcon(UIResources.class.getResource("res/Paste20x20.png"));
		
		public static final ImageIcon	imageBack																						= new ImageIcon(UIResources.class.getResource("res/Back24x24.png"));
		public static final ImageIcon	imageForward																			= new ImageIcon(UIResources.class.getResource("res/Forward24x24.png"));
		public static final ImageIcon	imageDisabled																		= new ImageIcon(UIResources.class.getResource("res/Disabled24x24.png"));
		
		public static final ImageIcon	imageChemical																		= new ImageIcon(UIResources.class.getResource("res/Chemical24x24.png"));
		public static final ImageIcon	imageReactiveChemical										= new ImageIcon(UIResources.class.getResource("res/ReactiveChemical24x24.png"));
		public static final ImageIcon	imageStructuralAlert											= new ImageIcon(UIResources.class.getResource("res/StructuralAlert24x24.png"));
		public static final ImageIcon	imageBiologicalPerturbation				= new ImageIcon(UIResources.class.getResource("res/BiologicalPerturbation24x24.png"));
		public static final ImageIcon	imageLink																						= new ImageIcon(UIResources.class.getResource("res/Link24x24.png"));
		public static final ImageIcon	imageEffect																				= new ImageIcon(UIResources.class.getResource("res/Effect24x24.png"));
		public static final ImageIcon	imageMIE																							= new ImageIcon(UIResources.class.getResource("res/MIE24x24.png"));
		public static final ImageIcon	imageEndpoint																		= new ImageIcon(UIResources.class.getResource("res/Endpoint24x24.png"));
		public static final ImageIcon	imageAdverseOutcome												= new ImageIcon(UIResources.class.getResource("res/AdverseOutcome24x24.png"));
		public static final ImageIcon	imageStudy																					= new ImageIcon(UIResources.class.getResource("res/Study24x24.png"));
		public static final ImageIcon	imageInvestigation													= new ImageIcon(UIResources.class.getResource("res/Investigation24x24.png"));
		
		public static final ImageIcon	imageTest																						= new ImageIcon(UIResources.class.getResource("res/Test24x24.png"));
		public static final ImageIcon	imageInvivoTest																= new ImageIcon(UIResources.class.getResource("res/InvivoTest24x24.png"));
		public static final ImageIcon	imageModel																					= new ImageIcon(UIResources.class.getResource("res/Model24x24.png"));
		public static final ImageIcon	imageTestResponseMapping							= new ImageIcon(UIResources.class.getResource("res/TestResponseMapping24x24.png"));
		
		public static final ImageIcon	imageNewChemical															= new ImageIcon(UIResources.class.getResource("res/newChemical36x27.png"));
		public static final ImageIcon	imageNewStructuralAlert								= new ImageIcon(UIResources.class.getResource("res/newStructuralAlert36x27.png"));
		public static final ImageIcon	imageNewBiologicalPerturbation	= new ImageIcon(UIResources.class.getResource("res/newBiologicalPerturbation36x27.png"));
		public static final ImageIcon	imageNewLink																			= new ImageIcon(UIResources.class.getResource("res/newLink36x27.png"));
		public static final ImageIcon	imageNewEffect																	= new ImageIcon(UIResources.class.getResource("res/newEffect36x27.png"));
		public static final ImageIcon	imageNewMIE																				= new ImageIcon(UIResources.class.getResource("res/newMIE36x27.png"));
		public static final ImageIcon	imageNewEndpoint															= new ImageIcon(UIResources.class.getResource("res/newEndpoint36x27.png"));
		public static final ImageIcon	imageNewAdverseOutcome									= new ImageIcon(UIResources.class.getResource("res/newAdverseOutcome36x27.png"));
		public static final ImageIcon	imageNewTest																			= new ImageIcon(UIResources.class.getResource("res/newTest36x27.png"));
		public static final ImageIcon	imageNewInvivoTest													= new ImageIcon(UIResources.class.getResource("res/newInvivoTest36x27.png"));
		public static final ImageIcon	imageNewModel																		= new ImageIcon(UIResources.class.getResource("res/newModel36x27.png"));
		public static final ImageIcon	imageNewTestResponseMapping				= new ImageIcon(UIResources.class.getResource("res/newTestResponseMapping36x27.png"));
		public static final ImageIcon	imageNewElementWizard										= new ImageIcon(UIResources.class.getResource("res/newElementWizard36x27.png"));
		
		public static final ImageIcon	imageCLET																						= new ImageIcon(UIResources.class.getResource("res/CLET24x24.png"));
		
		public static final ImageIcon	imagePathwayWizard													= new ImageIcon(UIResources.class.getResource("res/PathwayW24x36.png"));
		public static final ImageIcon	imageChemicalWizard												= new ImageIcon(UIResources.class.getResource("res/ChemicalW24x36.png"));
		public static final ImageIcon	imageUpstreamEffectWizard						= new ImageIcon(UIResources.class.getResource("res/UEffectW24x36.png"));
		public static final ImageIcon	imageDownstreamEffectWizard				= new ImageIcon(UIResources.class.getResource("res/DEffectW24x36.png"));
		public static final ImageIcon	imageZoomIn																				= new ImageIcon(UIResources.class.getResource("res/zoom_in_24x36.png"));
		public static final ImageIcon	imageZoomOut																			= new ImageIcon(UIResources.class.getResource("res/zoom_out_24x36.png"));
		public static final ImageIcon	imageDrag																						= new ImageIcon(UIResources.class.getResource("res/hand_24x36.png"));
		public static final ImageIcon	imageEdit																						= new ImageIcon(UIResources.class.getResource("res/edit_24x36.png"));
		
		public static final ImageIcon	imageHACenter																		= new ImageIcon(UIResources.class.getResource("res/HACenter24x24.png"));
		public static final ImageIcon	imageHALeft																				= new ImageIcon(UIResources.class.getResource("res/HALeft24x24.png"));
		public static final ImageIcon	imageHARight																			= new ImageIcon(UIResources.class.getResource("res/HARight24x24.png"));
		public static final ImageIcon	imageHAFill																				= new ImageIcon(UIResources.class.getResource("res/HAFill24x24.png"));
		
		public static final ImageIcon	imageVAMiddle																		= new ImageIcon(UIResources.class.getResource("res/VAMiddle24x24.png"));
		public static final ImageIcon	imageVATop																					= new ImageIcon(UIResources.class.getResource("res/VATop24x24.png"));
		public static final ImageIcon	imageVABottom																		= new ImageIcon(UIResources.class.getResource("res/VABottom24x24.png"));
		public static final ImageIcon	imageVAFill																				= new ImageIcon(UIResources.class.getResource("res/VAFill24x24.png"));
		
		public static final ImageIcon	imageEffectDispOpt													= new ImageIcon(UIResources.class.getResource("res/EffectDispOpt24x24.png"));
		public static final ImageIcon	imageChemicalDispOpt											= new ImageIcon(UIResources.class.getResource("res/ChemicalDispOpt24x24.png"));
		
		public static final ImageIcon	imagePathway																			= new ImageIcon(UIResources.class.getResource("res/Pathway24x24.png"));
		public static final ImageIcon	imageProperty																		= new ImageIcon(UIResources.class.getResource("res/Property24x24.png"));
		public static final ImageIcon	imageReference																	= new ImageIcon(UIResources.class.getResource("res/Reference24x24.png"));
		public static final ImageIcon	imageReferences																= new ImageIcon(UIResources.class.getResource("res/References24x24.png"));
		public static final ImageIcon	imageLitReference														= new ImageIcon(UIResources.class.getResource("res/LitReference24x24.png"));
		public static final ImageIcon	imageDescription															= new ImageIcon(UIResources.class.getResource("res/description24x24.png"));
		public static final ImageIcon	imageDescriptionStruct									= new ImageIcon(UIResources.class.getResource("res/description_structured24x24.png"));
		public static final ImageIcon	imageDescriptionIDs												= new ImageIcon(UIResources.class.getResource("res/descriptionIDs24x24.png"));
		
		public static final ImageIcon	imageOverrideLWR															= new ImageIcon(UIResources.class.getResource("res/OverrideRightWithLeft24x36.png"));
		public static final ImageIcon	imageOverrideRWL															= new ImageIcon(UIResources.class.getResource("res/OverrideLeftWithRight24x36.png"));
		public static final ImageIcon	imageOverrideSelLWR												= new ImageIcon(UIResources.class.getResource("res/OverrideSelRightWithLeft24x36.png"));
		public static final ImageIcon	imageOverrideSelRWL												= new ImageIcon(UIResources.class.getResource("res/OverrideSelLeftWithRight24x36.png"));
		
		public static final ImageIcon	imageLoading																			= new ImageIcon(UIResources.class.getResource("res/Loading24x24.gif"));
		public static final ImageIcon	imageDBServer																		= new ImageIcon(UIResources.class.getResource("res/DBServer24x24.png"));
		public static final ImageIcon	imageLocalFile																	= new ImageIcon(UIResources.class.getResource("res/LocalFile24x24.png"));
		public static final ImageIcon	imageLocalMemory															= new ImageIcon(UIResources.class.getResource("res/LocalMemory24x24.png"));
		
		public static final ImageIcon	imageError																					= new ImageIcon(UIResources.class.getResource("res/error22x24.png"));
		public static final ImageIcon	imageCancel																				= new ImageIcon(UIResources.class.getResource("res/button_cancel.png"));
		
		public static final ImageIcon	imageArrowLeft																	= new ImageIcon(UIResources.class.getResource("res/arrow_left24x24.png"));
		public static final ImageIcon	imageArrowRight																= new ImageIcon(UIResources.class.getResource("res/arrow_right24x24.png"));
		public static final ImageIcon	imageArrowRightDown												= new ImageIcon(UIResources.class.getResource("res/arrow_right_down24x24.png"));
		public static final ImageIcon	imageArrowDownRight												= new ImageIcon(UIResources.class.getResource("res/arrow_down_right24x24.png"));
		
		public static final ImageIcon	imageRefresh																			= new ImageIcon(UIResources.class.getResource("res/refresh_16x16.png"));
		public static final ImageIcon	imageFontSizeIncrease										= new ImageIcon(UIResources.class.getResource("res/font_increase_16x16.png"));
		public static final ImageIcon	imageFontSizeDecrease										= new ImageIcon(UIResources.class.getResource("res/font_decrease_16x16.png"));
		public static final ImageIcon	imageFontSizeDefault											= new ImageIcon(UIResources.class.getResource("res/font_default_16x16.png"));
		
		public static final ImageIcon	imageSearch																				= new ImageIcon(UIResources.class.getResource("res/search64x64.png"));
		public static final ImageIcon	imageNewAOP																				= new ImageIcon(UIResources.class.getResource("res/newAOP64x64.png"));
		public static final ImageIcon	imageHistory																			= new ImageIcon(UIResources.class.getResource("res/history64x64.png"));
		public static final ImageIcon	imageFeedback																		= new ImageIcon(UIResources.class.getResource("res/feedback64x64.png"));
		
		public static final ImageIcon	imageSearchAct																	= new ImageIcon(UIResources.class.getResource("res/search_act64x64.png"));
		public static final ImageIcon	imageNewAOPAct																	= new ImageIcon(UIResources.class.getResource("res/newAOP_act64x64.png"));
		public static final ImageIcon	imageHistoryAct																= new ImageIcon(UIResources.class.getResource("res/history_act64x64.png"));
		public static final ImageIcon	imageFeedbackAct															= new ImageIcon(UIResources.class.getResource("res/feedback_act64x64.png"));
		
		public static Font												fontCaption																				= new java.awt.Font("Tahoma", 1, 12);
		
		public static void zoomFont(float percentChange)
			{
				UIDefaults defaults = UIManager.getDefaults();
				for (Enumeration<Object> e = defaults.keys(); e.hasMoreElements();)
					{
						Object key = e.nextElement();
						Object value = defaults.get(key);
						if (value instanceof Font)
							{
								Font font = (Font) value;
								int newSize = Math.round(font.getSize() * percentChange);
								if (value instanceof FontUIResource)
									defaults.put(key, new FontUIResource(font.getName(), font.getStyle(), newSize));
								else
									defaults.put(key, new Font(font.getName(), font.getStyle(), newSize));
							}
					}
			}
			
		public static ImageIcon getIconForClass(Class<?> objectClass)
			{
				if (objectClass == null)
					return null;
				if (objectClass.isAssignableFrom(Initiator_ChemicalStructure.class))
					return imageChemical;
				else if (objectClass.isAssignableFrom(Initiator_StructuralAlerts.class))
					return imageStructuralAlert;
				else if (objectClass.isAssignableFrom(Effect_MolecularInitiatingEvent.class))
					return imageMIE;
				else if (objectClass.isAssignableFrom(Effect_DownstreamEffect.class))
					return imageEffect;
				else if (objectClass.isAssignableFrom(Effect_Endpoint.class))
					return imageEndpoint;
				else if (objectClass.isAssignableFrom(Effect_AdverseOutcome.class))
					return imageAdverseOutcome;
				else if (Link.class.isAssignableFrom(objectClass))
					return imageLink;
				else if ((objectClass.isAssignableFrom(Test.class)) || (objectClass.isAssignableFrom(Test_ExVivo.class)) || (objectClass.isAssignableFrom(Test_InVivo.class)))
					return imageInvivoTest;
				else if ((objectClass.isAssignableFrom(Test_InVitro.class)) || (objectClass.isAssignableFrom(Test_InChemico.class)))
					return imageTest;
				else if (objectClass.isAssignableFrom(Test_InSilico.class))
					return imageModel;
				else if (objectClass.isAssignableFrom(Pathway.class))
					return imagePathway;
				else if (objectClass.isAssignableFrom(DescriptionSection_Structured.class))
					return imageDescriptionStruct;
				else if (objectClass.isAssignableFrom(DescriptionSection.class))
					return imageDescription;
				else if (objectClass.isAssignableFrom(DescriptionIDs.class))
					return imageDescriptionIDs;
				else if (objectClass.isAssignableFrom(ReferenceID.class))
					return imageReference;
				else if (objectClass.isAssignableFrom(ReferenceIDs.class))
					return imageReferences;
				else if (objectClass.isAssignableFrom(Reference.class))
					return imageLitReference;
				else if (objectClass.isAssignableFrom(EffectopediaObject.class))
					return imageProperty;
				else if (objectClass.isAssignableFrom(TestResponseMapping.class))
					return imageTestResponseMapping;
				return null;
			}
			
		public static Cursor	openHandCursor;
		public static Cursor	grabHandCursor;
		public static Cursor	openHandOverObjectCursor;
		public static Cursor	grabObjectWithHandCursor;
		public static Cursor	chemicalCursor;
		public static Cursor	effectCursor;
		public static Cursor	linkCursor;
		public static Cursor	testCursor;
		public static Cursor	mappingCursor;
		public static Cursor	incompatibleCursor;
		public static Cursor	zoomInCursor;
		public static Cursor	zoomOutCursor;
		
		public static String resourceAsString(String relativePath)
			{
				String result;
				try
					{
						Path path = Paths.get(UIResources.class.getResource(relativePath).toURI());
						result = new String(Files.readAllBytes(path), StandardCharsets.ISO_8859_1);
					}
				catch (Exception e)
					{
						result = "";
						e.printStackTrace();
					}
				return result;
			}
			
			{
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Point hotSpot = new Point(4, 4);
				Image image = toolkit.getImage(UIResources.class.getResource("res/hand_open32x32.png"));
				openHandCursor = toolkit.createCustomCursor(image, hotSpot, "OPEN_HAND_CURSOR");
				image = toolkit.getImage(UIResources.class.getResource("res/hand_grip32x32.png"));
				grabHandCursor = toolkit.createCustomCursor(image, hotSpot, "GRAB_HAND_CURSOR");
				image = toolkit.getImage(UIResources.class.getResource("res/hand_open_obj32x32.png"));
				openHandOverObjectCursor = toolkit.createCustomCursor(image, hotSpot, "OPEN_HAND_OVER_OBJECT_CURSOR");
				image = toolkit.getImage(UIResources.class.getResource("res/hand_grip_obj32x32.png"));
				grabObjectWithHandCursor = toolkit.createCustomCursor(image, hotSpot, "GRAB_OBJECT_HAND_CURSOR");
				image = toolkit.getImage(UIResources.class.getResource("res/chemical32x32.png"));
				chemicalCursor = toolkit.createCustomCursor(image, hotSpot, "CHEMICAL");
				image = toolkit.getImage(UIResources.class.getResource("res/effect32x32.png"));
				effectCursor = toolkit.createCustomCursor(image, hotSpot, "EFFECT");
				image = toolkit.getImage(UIResources.class.getResource("res/link32x32.png"));
				linkCursor = toolkit.createCustomCursor(image, hotSpot, "LINK");
				image = toolkit.getImage(UIResources.class.getResource("res/test32x32.png"));
				testCursor = toolkit.createCustomCursor(image, hotSpot, "TEST");
				image = toolkit.getImage(UIResources.class.getResource("res/mapping32x32.png"));
				mappingCursor = toolkit.createCustomCursor(image, hotSpot, "MAPPING");
				image = toolkit.getImage(UIResources.class.getResource("res/incompatible32x32.png"));
				incompatibleCursor = toolkit.createCustomCursor(image, hotSpot, "INCOMPATIBLE");
				image = toolkit.getImage(UIResources.class.getResource("res/zoom_in32x32.png"));
				zoomInCursor = toolkit.createCustomCursor(image, hotSpot, "ZOOM_IN");
				image = toolkit.getImage(UIResources.class.getResource("res/zoom_out32x32.png"));
				zoomOutCursor = toolkit.createCustomCursor(image, hotSpot, "ZOOM_OUT");
			}
			
	}
