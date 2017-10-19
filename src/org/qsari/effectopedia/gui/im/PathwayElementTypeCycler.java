/**
 * 
 */
package org.qsari.effectopedia.gui.im;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class PathwayElementTypeCycler
	{
		public static int					STANDARD_SEQUENCE_SIZE			= 4;
		public static int					SEQUENCE_SUBSTANCE_CYCLE	= 0;
		public static int					SEQUENCE_EFFECT_CYCLE				= 2;
		public static int					SEQUENCE_LINK_CYCLE						= 4;
		public static int					SEQUENCE_TEST_CYCLE						= 5;
		public static int					SEQUENCE_SUBST_EFFECT				= 6;
		
		public static boolean	STANDARD_SEQUENCE								= false;
		public static boolean	FIXED_CYCLE														= true;
		
		public PathwayElementTypeCycler(boolean fixedSequence)
			{
				super();
				this.fixedSequence = fixedSequence;
				init();
				sequenceIndex = 0;
				mapDefaultObjects();
			}
			
		public PathwayElementTypeCycler(int sequence, boolean fixedSequence)
			{
				super();
				init();
				mapDefaultObjects();
				this.fixedSequence = fixedSequence;
				sequenceIndex = sequence;
			}
			
		public PathwayElement getLast()
			{
				return this.last;
			}
			
		public PathwayElement getCurrent()
			{
				if (current == null)
					{
						last = null;
						current = sequence.get(sequenceIndex).get(elementIndex);
					}
				return current;
			}
			
		public PathwayElement nextInSequence()
			{
				sequenceIndex++;
				if (sequenceIndex >= STANDARD_SEQUENCE_SIZE)
					sequenceIndex = 2;
				elementIndex = firstElementIndex();
				last = current;
				current = sequence.get(sequenceIndex).get(elementIndex);
				return current;
			}
			
		public PathwayElement nextAfterNextInSequence()
			{
				sequenceIndex += 2;
				if (sequenceIndex >= STANDARD_SEQUENCE_SIZE)
					sequenceIndex = 2;
				elementIndex = firstElementIndex();
				last = current;
				current = sequence.get(sequenceIndex).get(elementIndex);
				return current;
			}
			
		public PathwayElement whatWillBe(int sequenceIncrement, int elementIncrement)
			{
				if (current == null)
					return sequence.get(sequenceIndex).get(elementIndex);
				int s = sequenceIndex + sequenceIncrement;
				if (s >= STANDARD_SEQUENCE_SIZE)
					s = 2;
				int e = firstElementIndex(s);
				e += elementIncrement;
				if (e > sequence.get(sequenceIndex).size() - 1)
					e = firstElementIndex();
				return sequence.get(s).get(e);
			}
			
		public PathwayElement previousInSequence()
			{
				sequenceIndex--;
				if (sequenceIndex < 0)
					sequenceIndex = 0;
				elementIndex = firstElementIndex();
				last = current;
				current = sequence.get(sequenceIndex).get(elementIndex);
				return current;
			}
			
		public PathwayElement lastElement()
			{
				elementIndex = sequence.get(sequenceIndex).size() - 1;
				last = current;
				current = sequence.get(sequenceIndex).get(elementIndex);
				return current;
			}
			
		public PathwayElement nextElement()
			{
				elementIndex++;
				if (elementIndex > sequence.get(sequenceIndex).size() - 1)
					elementIndex = firstElementIndex();
				last = current;
				current = sequence.get(sequenceIndex).get(elementIndex);
				return current;
			}
			
		public PathwayElement nextElement(PathwayElement element)
			{
				if (element == null)
					return getCurrent();
				if (last == element)
					return nextElement();
				if (element.isGeneric())
					{
						if (fixedSequence)
							{
								elementIndex = sequence.get(sequenceIndex).indexOf(defaultObjects.get(element.getClass()));
								if (elementIndex != -1)
									return nextElement();
								else
									return element;
							}
						else
							{
								findIndices(element);
								if (elementIndex == sequence.get(sequenceIndex).size() - 1)
									if (sequenceIndex == 0)
										{
											sequenceIndex = 2;
											elementIndex = firstElementIndex();
											return getCurrent();
										}
									else
										return nextElement();
								else
									return nextElement();
							}
					}
				else
					{
						findIndices(element);
						current = sequence.get(sequenceIndex).get(elementIndex);
						return element;
					}
			}
			
		private void findIndices(PathwayElement element)
			{
				PathwayElement el = defaultObjects.get(element.getClass());
				for (int i = 0; i < STANDARD_SEQUENCE_SIZE; i++)
					{
						elementIndex = sequence.get(i).indexOf(el);
						if (elementIndex != -1)
							{
								sequenceIndex = i;
								break;
							}
					}
			}
			
		public PathwayElement previousElement()
			{
				elementIndex--;
				if (elementIndex < 0)
					elementIndex = sequence.get(sequenceIndex).size() - 1;
				last = current;
				current = sequence.get(sequenceIndex).get(elementIndex);
				return current;
			}
			
		public PathwayElement previousElement(PathwayElement element)
			{
				if (element == null)
					return getCurrent();
				if (last == element)
					return previousElement();
				if (element.isGeneric())
					{
						if (fixedSequence)
							{
								elementIndex = sequence.get(sequenceIndex).indexOf(defaultObjects.get(element.getClass()));
								if (elementIndex != -1)
									return previousElement();
								else
									return element;
							}
						else
							{
								findIndices(element);
								if (elementIndex == sequence.get(sequenceIndex).size() - 1)
									if (sequenceIndex == 0)
										{
											sequenceIndex = 2;
											elementIndex = firstElementIndex();
											return getCurrent();
										}
									else
										return previousElement();
								else
									return previousElement();
							}
					}
				else
					return element;
			}
			
		public int getSequenceIndex()
			{
				return sequenceIndex;
			}
			
		public void setSequenceIndex(int sequenceIndex, boolean fixedSequence)
			{
				this.fixedSequence = fixedSequence;
				if (sequenceIndex == this.sequenceIndex)
					return;
				if (sequenceIndex < sequence.size())
					{
						this.sequenceIndex = sequenceIndex;
						elementIndex = firstElementIndex();
						last = current;
						current = sequence.get(sequenceIndex).get(elementIndex);
					}
			}
			
		public void setElementIndex(int cyclerElementIndex)
			{
				if ((cyclerElementIndex >= 0) && (cyclerElementIndex < sequence.get(sequenceIndex).size()))
					{
						elementIndex = cyclerElementIndex;
						last = null;
						current = sequence.get(sequenceIndex).get(elementIndex);
					}
			}
			
		public void rollback()
			{
				findIndices(last);
			}
			
		public int getElementIndex()
			{
				return elementIndex;
			}
			
		private int firstElementIndex()
			{
				if ((sequenceIndex == 2) && (last != null))
					if (Link_ChemStructToMIE.class.isAssignableFrom(last.getClass()) || Initiator.class.isAssignableFrom(last.getClass()))
						return 0;
					else
						{
							if ((current != null) && ((last instanceof Effect) || ((last instanceof Link_EffectToEffect))))
								return 1;
							else
								return 0;
						}
				else
					return 0;
			}
			
		private int firstElementIndex(int sequence)
			{
				if ((sequence == 2) && (last != null) && (last.getClass().isAssignableFrom(DefaultEffectopediaObjects.DEFAULT_LINK_CSTMIE.getClass())))
					return 1;
				else
					return 0;
			}
			
		private void init()
			{
				sequence = new ArrayList<ArrayList<PathwayElement>>();
				ArrayList<PathwayElement> pathwaySegment = new ArrayList<PathwayElement>(3);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_STRUCTURAL_ALERT);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_BIOLOGICAL_PERTURBATION);
				sequence.add(pathwaySegment);
				pathwaySegment = new ArrayList<PathwayElement>(1);
				// pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_LINK_STRS);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_LINK_CSTMIE);
				sequence.add(pathwaySegment);
				pathwaySegment = new ArrayList<PathwayElement>(4);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_MIE);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_DOWNSTREAM_EFFECT);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_ENDPOINT);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME);
				sequence.add(pathwaySegment);
				pathwaySegment = new ArrayList<PathwayElement>(1);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_LINK_ETE);
				sequence.add(pathwaySegment);
				
				pathwaySegment = new ArrayList<PathwayElement>(3);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_LINK_CSTCS);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_LINK_CSTMIE);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_LINK_ETE);
				sequence.add(pathwaySegment);
				
				pathwaySegment = new ArrayList<PathwayElement>(5);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_IN_CHEMICO_TEST);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_IN_VITRO_TEST);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_EX_VIVO_TEST);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_IN_VIVO_TEST);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_IN_SILICO_TEST);
				sequence.add(pathwaySegment);
				
				pathwaySegment = new ArrayList<PathwayElement>(1);
				pathwaySegment.add(DefaultEffectopediaObjects.DEFAULT_TEST_RESPONCE_MAPPNIG);
				sequence.add(pathwaySegment);
			}
			
		private void mapDefaultObjects()
			{
				defaultObjects = new HashMap<Class<? extends PathwayElement>, PathwayElement>();
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE.getClass(), DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_STRUCTURAL_ALERT.getClass(), DefaultEffectopediaObjects.DEFAULT_STRUCTURAL_ALERT);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_BIOLOGICAL_PERTURBATION.getClass(), DefaultEffectopediaObjects.DEFAULT_BIOLOGICAL_PERTURBATION);
				
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_LINK_CSTCS.getClass(), DefaultEffectopediaObjects.DEFAULT_LINK_CSTCS);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_LINK_CSTMIE.getClass(), DefaultEffectopediaObjects.DEFAULT_LINK_CSTMIE);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_LINK_ETE.getClass(), DefaultEffectopediaObjects.DEFAULT_LINK_ETE);
				
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_MIE.getClass(), DefaultEffectopediaObjects.DEFAULT_MIE);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_DOWNSTREAM_EFFECT.getClass(), DefaultEffectopediaObjects.DEFAULT_DOWNSTREAM_EFFECT);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_ENDPOINT.getClass(), DefaultEffectopediaObjects.DEFAULT_ENDPOINT);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.getClass(), DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME);
				
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_IN_CHEMICO_TEST.getClass(), DefaultEffectopediaObjects.DEFAULT_IN_CHEMICO_TEST);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_IN_VITRO_TEST.getClass(), DefaultEffectopediaObjects.DEFAULT_IN_VITRO_TEST);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_EX_VIVO_TEST.getClass(), DefaultEffectopediaObjects.DEFAULT_EX_VIVO_TEST);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_IN_VIVO_TEST.getClass(), DefaultEffectopediaObjects.DEFAULT_IN_VIVO_TEST);
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_IN_SILICO_TEST.getClass(), DefaultEffectopediaObjects.DEFAULT_IN_SILICO_TEST);
				
				defaultObjects.put(DefaultEffectopediaObjects.DEFAULT_TEST_RESPONCE_MAPPNIG.getClass(), DefaultEffectopediaObjects.DEFAULT_TEST_RESPONCE_MAPPNIG);
			}
			
		public void updateDataSource(DataSource dataSource)
			{
				Iterator<Map.Entry<Class<? extends PathwayElement>, PathwayElement>> it = defaultObjects.entrySet().iterator();
				while (it.hasNext())
					it.next().getValue().setDataSource(dataSource);
				this.dataSource = dataSource;
			}
			
		public DataSource getDataSource()
			{
				return dataSource;
			}
			
		private boolean																																																		fixedSequence;
		private ArrayList<ArrayList<PathwayElement>>																					sequence;
		private HashMap<Class<? extends PathwayElement>, PathwayElement>	defaultObjects;
		private int																																																						sequenceIndex	= 0;
		private int																																																						elementIndex		= 0;
		private PathwayElement																																											last;
		private PathwayElement																																											current;
		private DataSource																																															dataSource				= null;
	}
