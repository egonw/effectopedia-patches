package org.qsari.effectopedia.base;

import org.qsari.effectopedia.history.EditHistory;

/**
 * Traceable interface provides a mean for tagging <code>IndexedObject</code>
 * descendents which are monitored in <code>EditHistory</code> class. When a
 * field of <code>IndexedObject</code> descendents is modified by its setter
 * user action is recorded containing information about: object that was
 * modified ( <code>objectId </code> ), reference to the archive copy of the
 * previous state ( <code> objectArchiveId </code> ), object class
 * <code>objectClassId</code>, action type <code>objectActionId</code>, date
 * time location <code>stampId</code>, and user <code>userId</code>;
 * 
 * @see IndexedObject
 * @see EditHistory
 * @see EditHistoryAction_SimpleAction
 * 
 * @version 1.0 @(#)Traceable.java 1.0
 * @author Hristo Aladjov
 */

public interface Traceable
	{
		
	}
