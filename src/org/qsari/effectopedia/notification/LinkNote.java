package org.qsari.effectopedia.notification;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.system.TraceableClasses;

public class LinkNote extends ChangeNote implements Exportable
	{
		
		public LinkNote(long userID, long actionID, Pathway pathway, Link link, EffectopediaObject actionObject)
			{
				super(userID, actionID, pathway, link, actionObject);
				this.linkType = link.getLinkNature().getCode();
				if (link.hasIncommingAssociations())
					{
						PathwayElement fromPE = link.incommingAssociations()[0];
						fromPathwayElement = fromPE.getTitle();
						fromPathwayElementID = fromPE.getExternalID();
						fromPathwayElementTypeID = TraceableClasses.REGISTERED.getClassID(fromPE.getClass());
					}
				else
					{
						fromPathwayElement = "";
						fromPathwayElementID = 0;
						fromPathwayElementTypeID = 0;
					}
				if (link.hasOutgoingAssociations())
					{
						PathwayElement toPE = link.outgoingAssociations()[0];
						toPathwayElement = toPE.getTitle();
						toPathwayElementID = toPE.getExternalID();
						toPathwayElementTypeID = TraceableClasses.REGISTERED.getClassID(toPE.getClass());
					}
				else
					{
						toPathwayElement = "";
						toPathwayElementID = 0;
						toPathwayElementTypeID = 0;
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOElement e = io.newElement("from_element").setValue(this.fromPathwayElement);
				e.setAttribute("id", Long.toString(this.fromPathwayElementID));
				e.setAttribute("type", Long.toString(this.fromPathwayElementTypeID));
				element.addChild(e);
				e = io.newElement("to_element").setValue(this.toPathwayElement);
				e.setAttribute("id", Long.toString(this.toPathwayElementID));
				e.setAttribute("type", Long.toString(this.toPathwayElementTypeID));
				element.addChild(e);
				BaseIOElement link = element.getChild("pathway_element");
				link.setAttribute("link_type", Long.toString(this.linkType));
				return element;
			}
		
		public final int				linkType;
		public final String	fromPathwayElement;
		public final long			fromPathwayElementID;
		public final long			fromPathwayElementTypeID;
		public final String	toPathwayElement;
		public final long			toPathwayElementID;
		public final long			toPathwayElementTypeID;
	}
