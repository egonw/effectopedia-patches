package org.qsari.effectopedia.core.objects;

import java.util.HashSet;
import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.ids.ReferenceIDs.ReferenceIDsChangeListener;
import org.qsari.effectopedia.base.ids.ReferenceIDs.ReferenceIDsListChange;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.object.elemets.Coordinates;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.quantification.AggregationFunction;
import org.qsari.effectopedia.data.quantification.Factor;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.system.TraceableProperties;

public class Effect extends DocumentedKnowledge_Located implements Importable, Exportable, Cloneable, Traceable, Factor, ReferenceIDsChangeListener
	{
		public Effect()
			{
				super();
				// relatedTestIDs =
				// DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TESTS_REFIDS);
				relatedTestMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				if (DefaultEffectopediaObjects.DEFAULT_EFFECT_METADATA != null)
					metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_EFFECT_METADATA);
			}
			
		public Effect(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				// relatedTestIDs =
				// DefaultEffectopediaObjects.DEFAULT_TESTS_REFIDS.clone(this,dataSource);
				relatedTestMappingIDs = DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS.clone(this, dataSource);
				if (DefaultEffectopediaObjects.DEFAULT_EFFECT_METADATA != null)
					metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_EFFECT_METADATA);
			}
			
		@Override
		public void init(boolean asDefaultObject)
			{
				coordinates = new Coordinates(this, DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions());
				responseFn = new AggregationFunction(this);
				responseFn.createState().createResponseFunctionIfNeeded(true);
				metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_EFFECT_METADATA);
				updateParenthood();
			}
			
		@Override
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				// containedIDs.put(relatedTestIDs.getID(), relatedTestIDs);
				containedIDs.put(relatedTestMappingIDs.getID(), relatedTestMappingIDs);
			}
			
		@Override
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				// containedIDs.put(relatedTestIDs.getExternalID(), relatedTestIDs);
				containedIDs.put(relatedTestMappingIDs.getExternalID(), relatedTestMappingIDs);
			}
			
		@Override
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				// relatedTestIDs =
				// EffectopediaObject.cloneIfInDefaultObjects(relatedTestIDs,this,dataSource);
				relatedTestMappingIDs = EffectopediaObject.cloneIfInDefaultObjects(relatedTestMappingIDs, this, dataSource);
			}
			
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				relatedTestMappingIDs = EditHistory.replaceArchivedObjectsWtihClones(relatedTestMappingIDs, this, dataSource);
			}
			
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				// if (relatedTestIDs!=null)
				// relatedTestIDs.process(batch);
				if (relatedTestMappingIDs != null)
					relatedTestMappingIDs.process(batch);
			}
			
		public void updateParenthood()
			{
				super.updateParenthood();
				// relatedTestIDs = EffectopediaObject.updateParent(relatedTestIDs,this);
				if (relatedTestMappingIDs == null)
					relatedTestMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestMappingIDs = EffectopediaObject.updateParent(relatedTestMappingIDs, this);
			}
			
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				// relatedTestIDs =
				// dataSource.get(relatedTestIDs.getClass(),relatedTestIDs.getID());
				relatedTestMappingIDs = dataSource.get(relatedTestMappingIDs.getClass(), relatedTestMappingIDs.getID());
			}
			
		public Test[] getRelatedTests()
			{
				TestResponseMapping[] trm = relatedTestMappingIDs.getCachedObjects();
				Test[] tests = new Test[trm.length];
				for (int i = trm.length - 1; i >= 0; i--)
					tests[i] = trm[i].test.getCachedObject();
				return tests;
			}
			
		public ReferenceIDs<TestResponseMapping> getRelatedTestMappingIDs()
			{
				return relatedTestMappingIDs;
			}
			
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Effect)
					{
						((Effect) eoDestintation).setGroup(this.getGroup());
						if (assignContainedEO)
							this.relatedTestMappingIDs.assignFieldsTo(((Effect) eoDestintation).getRelatedTestMappingIDs(), assignContainedEO);
						if (responseFn != null) // TODO test if
							this.responseFn.assignFieldsTo(((Effect) eoDestintation).getResponseAggregationFn(), eoDestintation, eoDestintation.getDataSource());
					}
			}
			
		public void cloneFieldsTo(Effect clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				// clone.relatedTestIDs = this.relatedTestIDs.clone(clone,dataSource);
				clone.relatedTestMappingIDs = this.relatedTestMappingIDs.clone(clone, dataSource);
				if (responseFn != null)
					clone.responseFn = this.responseFn.clone(clone, dataSource);
			}
			
		public Effect clone()
			{
				Effect clone = new Effect();
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public Effect clone(EffectopediaObject parent, DataSource dataSource)
			{
				Effect clone = new Effect(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						loadGroupsFromOldRepresentation(element);
						relatedTestMappingIDs = io.load(ReferenceIDs.class, relatedTestMappingIDs, element.getChild("related_test_mapping_ids"));
						BaseIOElement respFn = element.getChild("response_fn");
						if (respFn != null)
							{
								if (responseFn == null)
									responseFn = new AggregationFunction(this);
								responseFn.load(respFn, io);
							}
					}
			}
			
		private void loadGroupsFromOldRepresentation(BaseIOElement element)
			{
				BaseIOValue grp = element.getValueElement("group");
				if (grp != null)
					{
						String grpValue = grp.getValue();
						if ((grpValue != null) && (grpValue.length() > 0))
							setGroup(grpValue);
					}
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(relatedTestMappingIDs.store(io.newElement("related_test_mapping_ids"), io));
				if (responseFn != null)
					element.addChild(responseFn.store(io.newElement("response_fn"), io));
				return element;
			}
			
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				relatedTestMappingIDs.updateExternalID(element.getChild("related_test_mapping_ids"));
			}
			
		public ReferenceIDs<?> getUpstreamLinkIDs()
			{
				return null;
			}
			
		public ReferenceIDs<?> getDownstreamLinkIDs()
			{
				return null;
			}
			
		public boolean hasIncommingMappings()
			{
				return false;
			}
			
		public boolean hasOutgoingMappings()
			{
				return relatedTestMappingIDs.size() > 0;
			}
			
		@Override
		public void map(PathwayElement element)
			{
				if (element instanceof TestResponseMapping)
					relatedTestMappingIDs.addIfDifferent((TestResponseMapping) element);
			}
			
		@Override
		public void unmap(PathwayElement element)
			{
				if (element instanceof TestResponseMapping)
					relatedTestMappingIDs.remove((TestResponseMapping) element);
			}
			
		public PathwayElement[] incommingMappings()
			{
				return null;
			}
			
		public PathwayElement[] outgoingMappings()
			{
				return relatedTestMappingIDs.getCachedObjects();
			}
			
		public static Effect newEffect(EffectopediaObject parent, DataSource dataSource, int segmentIndex, int outcomeIndex)
			{
				if (segmentIndex == 4 /* TODO */)
					return new Effect_MolecularInitiatingEvent(parent, dataSource);
				else if (segmentIndex == outcomeIndex)
					return new Effect_AdverseOutcome(parent, dataSource);
				else if (segmentIndex == outcomeIndex - 1)
					return new Effect_Endpoint(parent, dataSource);
				else
					return new Effect_DownstreamEffect(parent, dataSource);
			}
			
		public String getGroup()
			{
				if (metadata != null)
					{
						ObjectProperty op = metadata.getProperty(DefaultEffectopediaObjects.DEFAULT_GROUPS);
						if (op != null)
							return op.getDisplayValue();
					}
				return "";
				
			}
			
		public void setGroup(String group)
			{
				if (metadata != null)
					{
						ObjectProperty op = metadata.getProperty(DefaultEffectopediaObjects.DEFAULT_GROUPS);
						if (op != null)
							op.setValue(group);
					}
			}
			
		@Override
		public ObjectProperty getCurrentState()
			{
				return getResponseAggregationFn().getProperties().getProperty(0);
			}
			
		public AggregationFunction getResponseAggregationFn()
			{
				if (responseFn == null)
					return responseFn = (new AggregationFunction(this)).createState().createResponseFunctionIfNeeded(true);
				return responseFn.createResponseFunctionIfNeeded(!responseFn.isInitialized());
			}
			
		public void setResponseAggregationFn(AggregationFunction responseFn)
			{
				this.responseFn = responseFn;
			}
			
		@Override
		public void ReferenceIDsChanged(ReferenceIDsListChange evt)
			{
				if (responseFn == null)
					responseFn = (new AggregationFunction(this)).createState().createResponseFunctionIfNeeded(true);
				else if (!responseFn.isInitialized())
					responseFn.createState().createResponseFunctionIfNeeded(true);
				else
					responseFn.update(evt.lowestIndexChanged, evt.highestIndexChanged);
			}
			
		public HashSet<Class<? extends Effect>> getCompatibleEffectTypes()
			{
				HashSet<Class<? extends Effect>> types = new HashSet<Class<? extends Effect>>();
				if (hasIncommingAssociations())
					for (PathwayElement e : incommingAssociations())
						if (e instanceof Initiator)
							{
								types.clear();
								types.add(Effect_MolecularInitiatingEvent.class);
								return types;
							}
						else
							{
								types.add(Effect_DownstreamEffect.class);
								types.add(Effect_Endpoint.class);
							}
				else
					{
						types.add(Effect_MolecularInitiatingEvent.class);
						types.add(Effect_DownstreamEffect.class);
						types.add(Effect_Endpoint.class);
					}
				if (hasOutgoingAssociations())
					{
						for (PathwayElement e : outgoingAssociations())
							if (e instanceof Effect_AdverseOutcome)
								types.add(Effect_AdverseOutcome.class);
					}
				else
					types.add(Effect_AdverseOutcome.class);
				return types;
			}
			
		public static final long																				E_GROUP_PID	= TraceableProperties.REGISTERED.add("group", "", Effect.class);
		
		// protected ReferenceIDs<Test> relatedTestIDs;
		protected ReferenceIDs<TestResponseMapping>	relatedTestMappingIDs;
		protected AggregationFunction															responseFn;
	}
