package org.qsari.effectopedia.core.object.elemets;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.TraceableProperties;
import org.qsari.effectopedia.system.UserList;

public class QualityAssurance extends IndexedObject implements Importable, Exportable
	{
		public UserList getContributors()
			{
				return contributors;
			}
		
		public UserList getReviewers()
			{
				return reviewers;
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		
		public QualityAssurance(EffectopediaObject owner)
			{
				super();
				this.owner = owner;
				SearchableItem sa = new SearchableItem(owner, QA_CONTRIBUTORS_PID, SearchIndices.AUTHOR_INDEX);
				this.contributors = new UserList("contributors", sa);
				sa = new SearchableItem(owner, QA_REVIEWERS_PID, SearchIndices.AUTHOR_INDEX);
				this.reviewers = new UserList("reviewers", sa);
			}
		
		public void reset()
			{
				contributors.reset();
				reviewers.reset();
			}
		
		public static final long					QA_CONTRIBUTORS_PID	= TraceableProperties.REGISTERED.add("contributors changed", "", Pathway.class);
		public static final long					QA_REVIEWERS_PID				= TraceableProperties.REGISTERED.add("reviewers changed", "", Pathway.class);
		
		protected UserList											contributors;
		protected UserList											reviewers;
		protected EffectopediaObject	owner;
	}
