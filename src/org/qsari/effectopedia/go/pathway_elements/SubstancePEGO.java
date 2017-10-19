package org.qsari.effectopedia.go.pathway_elements;

import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.Standard8IOPorts;
import org.qsari.effectopedia.go.Standard8IOPorts.Distribution;

public abstract class SubstancePEGO extends PathwayElementGO
	{
		public SubstancePEGO(PathwayElement o)
			{
				super(o);
				ports = new Standard8IOPorts(this,Distribution.RECTANGULAR);
			}
	}
