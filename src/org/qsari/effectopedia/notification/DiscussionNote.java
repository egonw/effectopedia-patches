package org.qsari.effectopedia.notification;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;

public class DiscussionNote extends ChangeNote implements Exportable
{
	public DiscussionNote(long userID, long actionID, Pathway pathway, PathwayElement pathwayElement, EffectopediaObject actionObject, String subject, String posting)
		{
   super (userID,actionID,pathway,pathwayElement,actionObject);
			this.subject = subject;
			this.posting = posting;
		}
	
	public BaseIOElement store(BaseIOElement element, BaseIO io)
		{
			super.store(element, io);
			element.addValueElement(io.newValue("subject").setValue(subject));
			element.addValueElement(io.newValue("posting").setValue(posting));
			return element;
		}
	
	public final String	subject;
	public final String	posting;
}

