package org.qsari.effectopedia.data.ambit.test;

import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import net.idea.opentox.cli.OTClient;
import net.idea.opentox.cli.structure.Compound;
import net.idea.opentox.cli.structure.CompoundClient;
import net.idea.opentox.cli.structure.Substance;
import net.idea.opentox.cli.structure.SubstanceClient;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.ObjectPropertyTypesContainer;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

import ambit2.base.data.SubstanceRecord;
import ambit2.base.data.study.EffectRecord;
import ambit2.base.data.study.IParams;
import ambit2.base.data.study.Params;
import ambit2.base.data.study.Protocol;
import ambit2.base.data.study.ProtocolApplication;
import ambit2.base.data.substance.ExternalIdentifier;
import ambit2.base.relation.composition.CompositionRelation;

public class CompoundClientTest<POLICY_RULE> {

	static String TEST_SERVER = "http://localhost:8080/ambit2";

	public static void main(String[] args) throws Exception {
		Effectopedia.EFFECTOPEDIA.setData(Effectopedia.DEFAULT_DATASOURCE);
		OTClient otclient = new OTClient();
		try {
			CompoundClientTest test = new CompoundClientTest();

			/*
			 * test.readStructure(otclient, String.format("%s%s/1", TEST_SERVER,
			 * Resources.compound));
			 */
			// test.searchStructure(otclient,"50-00-0");

			// test.searchStructure(otclient, "c1ccccc1");

			/*
			 * String compound_uri = String .format("%s/compound/2322",
			 * TEST_SERVER); List<Substance> substances =
			 * test.getSubstanceByCompound(otclient, null, compound_uri);
			 */
			SubstanceRecord record = new SubstanceRecord();
			record.addMeasurement(initacutetox());
			record.addMeasurement(initpc());
			System.out.println(record.getMeasurements());
			
			Test ef_test = new Test();
			test.substance2Effectopedia(record,ef_test);

		} catch (Exception x) {
			x.printStackTrace();
		} finally {
			otclient.close();
		}
	}

	protected void substance2Effectopedia(SubstanceRecord record,
			Test effectopediaTest) throws Exception {

		org.qsari.effectopedia.core.objects.Substance substance = new org.qsari.effectopedia.core.objects.Substance();
		record.getSubstanceUUID();
		List<ExternalIdentifier> ids = record.getExternalids();
		
		
		List<ProtocolApplication> measurements = record.getMeasurements();
		ObjectPropertyTypesContainer container = new ObjectPropertyTypesContainer();

		for (ProtocolApplication papp : measurements) {

			List<EffectRecord<String, IParams, String>> effects = papp
					.getEffects();

			for (EffectRecord<String, IParams, String> effect : effects) {

				ObjectPropertyType opt = new ObjectPropertyType(
						effect.getEndpoint(),
						null,
						SubstanceData.class,
						effect.getEndpoint(),
						effect.getTextValue() == null ? DataValue_Double.class
								: DataValue_String.class, // TODO smth smarts
															// about types
															// DataValue_String
						new DataUnit(effect.getUnit()),
						ActionTypes.GM_PARAMETER); // TODO

				container.add(opt);

				IParams conditions = effect.getConditions();
				Iterator keys = conditions.keySet().iterator();
				while (keys.hasNext()) {
					Object key = keys.next();

					DescriptorType dt = new DescriptorType(key.toString(),
							key.toString(), DataValue_String.class, null);// TODO
																			// unit);
					opt.getDescriptors().add(dt);
				}

			}

		}
		// now values
		for (ProtocolApplication papp : measurements) {

			org.qsari.effectopedia.core.objects.SubstanceData substanceData = new SubstanceData(effectopediaTest,null,null); 
					//TODO new org.qsari.effectopedia.core.objects.SubstanceData(effectopediaTest,substance,null);
			effectopediaTest.getSubstanceDataIDs().add(substanceData);
			ObjectProperties props = new ObjectProperties(substanceData,
					container);
			List<EffectRecord<String, IParams, String>> effects = papp
					.getEffects();

			for (EffectRecord<String, IParams, String> effect : effects) {

				IParams conditions = effect.getConditions();
				Iterator keys = conditions.keySet().iterator();
				ObjectPropertyMultivalued_Documented p = (ObjectPropertyMultivalued_Documented) props
						.getProperty(effect.getEndpoint());

				ObjectPropertyMultivalued_Documented.Documented_Value v = new ObjectPropertyMultivalued_Documented.Documented_Value();
				if (effect.getTextValue() != null)
					v.setValue(effect.getTextValue().toString());
				else {
					if (effect.getLoValue() != null)
						v.setMinValue(effect.getLoValue().toString());
					if (effect.getUpValue() != null)
						v.setMaxValue(effect.getUpValue().toString());
				}
				v.setUnit(effect.getUnit());

				while (keys.hasNext()) {

					Object key = keys.next();
					// TODO
				}
			}
		}
	}

	protected void searchStructure(OTClient otclient, String query)
			throws Exception {
		searchStructure(otclient, null, query);
	}

	protected List<Substance> getSubstanceByCompound(OTClient otclient,
			SubstanceClient cli, String compound_uri) throws Exception {
		URL server = new URL(TEST_SERVER);
		try {
			if (cli == null)
				cli = otclient.getSubstanceClient();

			List<Substance> substances = cli.getSubstancesRelatedToCompound(
					TEST_SERVER, compound_uri, false);

			for (Substance substance : substances) {
				System.out.println(substance.getResourceIdentifier());
				if (substance.getRecord().getRelatedStructures() != null)
					for (CompositionRelation r : substance.getRecord()
							.getRelatedStructures()) {
						System.out.println(r.getSecondStructure());
						System.out.println(r.getRelationType());
					}
			}
			return substances;

		} catch (Exception x) {
			throw x;
		} finally {

		}
	}

	protected void searchStructure(OTClient otclient, CompoundClient cli,
			String query) throws Exception {
		URL server = new URL(TEST_SERVER);
		try {
			if (cli == null)
				cli = otclient.getCompoundClient();

			List<URL> uris = cli.searchExactStructuresURI(server, query);
			for (URL uri : uris) {

				// readStructure(otclient, cli, uri.toString());

				readStructure(
						otclient,
						cli,
						String.format("%s?feature_uris[]=%s/feature",
								uri.toString(), uri.toString()));

			}
		} catch (Exception x) {
			throw x;
		} finally {

		}
	}

	protected void readStructure(OTClient otclient, CompoundClient cli,
			String uri) throws Exception {
		try {
			if (cli == null)
				cli = otclient.getCompoundClient();
			/*
			 * List<Compound> substances = cli.getIdentifiersAndLinks(new URL(
			 * String.format("%s", TEST_SERVER)), new URL(uri));
			 */
			List<Compound> substances = cli.getJSON(new URL(uri));
			for (Compound cmp : substances) {

				Initiator_ChemicalStructure struc = compound2Effectopedia(cmp);
				System.out.println(struc.DEBUG_getIDs());
				System.out.println(struc.getProperties().getCount());
			}
		} catch (Exception x) {
			throw x;
		} finally {

		}
	}

	protected Initiator_ChemicalStructure compound2Effectopedia(Compound cmp)
			throws Exception {
		System.out.println(cmp.getName());
		System.out.println(cmp.getResourceIdentifier());
		System.out.println(cmp.getCas());
		System.out.println(cmp.getSMILES());
		System.out.println(cmp.getInChI());

		Initiator_ChemicalStructure struc = new Initiator_ChemicalStructure();

		ObjectProperties ids = new ObjectProperties(null,
				DefaultEffectopediaObjects.CHEMICAL_STRUCT_IDENT);
		struc.setIdentification(ids);

		ObjectProperty cas = ids.getProperty("CASNO");
		cas.setValue(cmp.getCas().replace("-", ""));

		ObjectProperty name = ids.getProperty("IUPAC_NAME");
		name.setValue(cmp.getIupacName());

		ObjectProperty smiles = ids.getProperty("SMILES");
		smiles.setValue(cmp.getSMILES());

		ObjectProperty formula = ids.getProperty("Formula");
		formula.setValue(cmp.getFormula());

		ObjectProperty inchi = ids.getProperty("InChI");
		inchi.setValue(cmp.getInChI());

		ObjectProperty inchikey = ids.getProperty("InChI_Key");
		inchikey.setValue(cmp.getInChIKey());

		struc.getSynonyms().setValue(cmp.getName());

		ObjectProperty img = struc.getStructure2DImage();
		img.setValue(cmp.getResourceIdentifier().toString()
				+ "?media=image/png&w=200&h=200");

		moreProperties(struc, cmp);

		return struc;
	}

	protected void moreProperties(Initiator_ChemicalStructure struc,
			Compound cmp) {
		ObjectPropertyTypesContainer container = new ObjectPropertyTypesContainer();
		Enumeration<String> keys = cmp.getProperties().keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(String.format("%s  %s", key, cmp.getProperties()
					.get(key)));

			ObjectPropertyType t = new ObjectPropertyType(null, null,
					struc.getClass(), null, DataValue_String.class, null, 0);

			t.setName(key); // TODO key.getname()
			// t.setFullname
			// t.setAcceptingMultipleValues(acceptingMultipleValues);
			// t.setDocumented(documented); TODO additional fields, reference
			// t.setDefaultUnit(defaultUnit); TODO
			// t.setDescription(description); TODO what it is, e.b. molecular
			// weight
			// t.setFixedValuesList(fixedValuesList); TODO acceptValues

			container.add(t);
			// ObjectPropertyMultivalued_Documented
		}

		ObjectProperties props = new ObjectProperties(struc, container);

		keys = cmp.getProperties().keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();

			String value = cmp.getProperties().get(key);

			ObjectProperty p = props.getProperty(key);
			p.setValue(value);

		}
	}

	protected static ProtocolApplication initpc() {
		Protocol protocol = new Protocol("Partition coefficient, IUC4#5/Ch.2.5");
		protocol.setCategory("PC_PARTITION_SECTION");
		protocol.addGuideline("Method: other (measured)");
		ProtocolApplication papp = new ProtocolApplication<Protocol, IParams, String, IParams, String>(
				protocol);
		IParams params = new Params();
		papp.setParameters(params);
		papp.setReference("reference");
		papp.setDocumentUUID("IUC4-2f64ab27-d2be-352e-b9d8-4f0274fd6633");
		EffectRecord record = new EffectRecord<String, IParams, String>();
		params = new Params();
		params.put("Temperature", "25 \u2103C");
		record.setConditions(params);
		record.setEndpoint("log Pow");
		record.setLoValue(0.35);
		papp.addEffect(record);
		return papp;
	}

	protected static ProtocolApplication initacutetox() {
		Protocol protocol = new Protocol(
				"Acute toxicity: oral, IUC4#2/Ch.5.1.1");
		protocol.setCategory("TO_ACUTE_ORAL_SECTION");
		protocol.addGuideline("Method: other: no data");
		ProtocolApplication papp = new ProtocolApplication<Protocol, IParams, String, IParams, String>(
				protocol);
		IParams params = new Params();
		papp.setParameters(params);
		papp.setReference("Smyth, H. F. Seaton J., and Fischer L. (1941).|The single dose toxicity of some glycols and derivatives.|J. Ind. Hyg. Toxicol. 23, 259-268");
		params.put("Species", "rat");
		params.put("Sex", "male/female");
		papp.setDocumentUUID("IUC4-ae64fc3b-22a4-3173-9362-9cce1ff622ae");
		EffectRecord record = new EffectRecord<String, IParams, String>();
		params = new Params();
		params.put("Temperature", "25 \u2103C");
		params.put("Sex", "male");
		record.setConditions(params);
		record.setEndpoint("LD50");
		record.setLoValue(260);
		record.setUpValue(320);
		record.setUnit("mg/kg bw");
		papp.addEffect(record);
		return papp;
	}

}
