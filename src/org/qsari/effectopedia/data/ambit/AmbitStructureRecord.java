package org.qsari.effectopedia.data.ambit;

import org.qsari.effectopedia.data.interfaces.IdentifiableDataSource;
import org.qsari.effectopedia.data.interfaces.IdentifiableEffectopediaObject;
import org.qsari.effectopedia.data.interfaces.IdentifiableStructure;
import org.qsari.effectopedia.data.json.JSONNode;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;

import com.fasterxml.jackson.databind.JsonNode;

public class AmbitStructureRecord implements IdentifiableStructure
	{

		public AmbitStructureRecord(JsonNode entry)
			{
				updateFromJSON(entry);
			}
		
		public ObjectProperties getIdentification()
			{
				return identification;
			}
		
		public void setIdentification(ObjectProperties identification)
			{
				this.identification = identification;
			}
		
		public ObjectProperties getProperties()
			{
				return null;
			}
		
		public void setProperties(ObjectProperties properties)
			{
				
			}
		
		public ObjectProperty getStructure2DImage()
			{
				return null;
			}
		
		public void setStructure2DImage(ObjectProperty structure2dImage)
			{
				
			}
		
		public ObjectProperty getSynonyms()
			{
				return null;
			}
		
		public void setSynonyms(ObjectProperty synonyms)
			{
				
			}
		
		public String getStructureName()
			{
				return null;
			}
		
		public void setStructureName(String Name)
			{
				
			}
		
		protected void updateFromJSON(JsonNode node)
			{
				getIdentifiersFromJSON(node);
			}
		
		private void getIdentifiersFromJSON(JsonNode node)
			{
				/*
				 * identification = new ObjectProperties(null,
				 * DefaultEffectopediaObjects.CHEMICAL_STRUCT_IDENT); ObjectProperty cas =
				 * identification.getProperty("CASNO"); Object ambitCAS =
				 * structure.getProperty(Property.getCASInstance()); if (ambitCAS != null)
				 * cas.setValue(ambitCAS.toString()); ObjectProperty iupac_name =
				 * identification.getProperty("IUPAC_NAME"); Object ambitIUPACName =
				 * structure.getProperty(Property.getNameInstance()); if (ambitIUPACName !=
				 * null) iupac_name.setValue(ambitIUPACName.toString()); ObjectProperty
				 * smiles = identification.getProperty("SMILES");
				 * smiles.setValue(structure.getSmiles()); ObjectProperty formula =
				 * identification.getProperty("Formula");
				 * formula.setValue(structure.getFormula()); ObjectProperty inchi =
				 * identification.getProperty("InChI");
				 * inchi.setValue(structure.getInchi()); ObjectProperty inchi_key =
				 * identification.getProperty("InChI_Key");
				 * inchi_key.setValue(structure.getInchiKey());
				 */
			}
		
		private JSONNode setIdentifiersToJSON()
			{
				/*
				 * ObjectProperty cas = identification.getProperty("CASNO"); Object ambitCAS
				 * = structure.getProperty(Property.getCASInstance()); if (ambitCAS != null)
				 * cas.setValue(ambitCAS.toString()); ObjectProperty iupac_name =
				 * identification.getProperty("IUPAC_NAME"); Object ambitIUPACName =
				 * structure.getProperty(Property.getNameInstance()); if (ambitIUPACName !=
				 * null) iupac_name.setValue(ambitIUPACName.toString()); ObjectProperty
				 * smiles = identification.getProperty("SMILES");
				 * structure.setSmiles(smiles.getDisplayValue()); ObjectProperty formula =
				 * identification.getProperty("Formula");
				 * structure.setFormula(formula.getDisplayValue()); ObjectProperty inchi =
				 * identification.getProperty("InChI");
				 * structure.setInchi(inchi.getDisplayValue()) ; ObjectProperty inchi_key =
				 * identification.getProperty("InChI_Key");
				 * structure.setInchiKey(inchi_key.getDisplayValue());
				 */
				return null;
			}
		
		ObjectProperties	identification	= null;

		@Override
		public IdentifiableEffectopediaObject getParent()
			{
				// TODO Auto-generated method stub
				return null;
			}

		@Override
		public boolean isDefaultID()
			{
				// TODO Auto-generated method stub
				return false;
			}

		@Override
		public long getDefaultID()
			{
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public void setDefaultID(long defualtID)
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public boolean isReadonly()
			{
				// TODO Auto-generated method stub
				return false;
			}

		@Override
		public void setReadonly(boolean readonly)
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public IdentifiableDataSource getDataSource()
			{
				// TODO Auto-generated method stub
				return null;
			}

		@Override
		public long getID()
			{
				// TODO Auto-generated method stub
				return 0;
			}

		@Override
		public void autoSetId()
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public void setExternalID(long value)
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public long getExternalID()
			{
				// TODO Auto-generated method stub
				return 0;
			}
	}