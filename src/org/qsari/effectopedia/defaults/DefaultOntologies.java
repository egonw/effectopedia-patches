package org.qsari.effectopedia.defaults;

import java.util.HashMap;

import org.qsari.effectopedia.ontologies.Ontology;
import org.qsari.effectopedia.ontologies.OntologyClass;
import org.qsari.effectopedia.ontologies.OntologyInstance;
import org.qsari.effectopedia.ontologies.OntologyInstances;

public class DefaultOntologies
	{
		public static final Ontology DEFAULT = new Ontology("Default");
		
		public static final HashMap<OntologyClass,OntologyInstance> defaultInstance = new HashMap<OntologyClass,OntologyInstance>();
		public static final HashMap<OntologyClass,OntologyInstances> defaultInstances = new HashMap<OntologyClass,OntologyInstances>();

		
		public static final OntologyClass	ENZYME	= new OntologyClass(DEFAULT,"Enzyme");
		static
		{
			defaultInstance.put(ENZYME, new OntologyInstance(ENZYME,"Enzyme name"));
			defaultInstances.put(ENZYME, new OntologyInstances(ENZYME,""));
		}

		public static final OntologyInstances	LIVER_S9	= new OntologyInstances(ENZYME,"Liver S9");
		static
		{
			LIVER_S9.add(new OntologyInstance(ENZYME,"Aldehyde Oxidase"));
			LIVER_S9.add(new OntologyInstance(ENZYME,"Cytochromes P450 (CYP)"));
			LIVER_S9.add(new OntologyInstance(ENZYME,"Flavin Monooxygenases (FMO)"));
			LIVER_S9.add(new OntologyInstance(ENZYME,"Glutathione Transferase (GST)"));
			LIVER_S9.add(new OntologyInstance(ENZYME,"Monamine Oxidase (MAO)"));
			LIVER_S9.add(new OntologyInstance(ENZYME,"Sulfurotrnasferase (SULT)"));
			LIVER_S9.add(new OntologyInstance(ENZYME,"Uridine Glucuronide Transferase (UGT)"));
		}
		static String[] test = {"alcohol dehydrogenase","alcohol dehydrogenase (NADP+)","homoserine dehydrogenase","(R,R)-butanediol dehydrogenase","acetoin dehydrogenase","glycerol dehydrogenase","propanediol-phosphate dehydrogenase","glycerol-3-phosphate dehydrogenase (NAD+)","D-xylulose reductase","L-xylulose reductase","D-arabinitol 4-dehydrogenase","L-arabinitol 4-dehydrogenase","L-arabinitol 2-dehydrogenase","L-iditol 2-dehydrogenase","D-iditol 2-dehydrogenase","galactitol 2-dehydrogenase","mannitol-1-phosphate 5-dehydrogenase","inositol 2-dehydrogenase","glucuronate reductase","glucuronolactone reductase","aldehyde reductase","UDP-glucose 6-dehydrogenase","histidinol dehydrogenase","quinate dehydrogenase","shikimate dehydrogenase","glyoxylate reductase","L-lactate dehydrogenase","D-lactate dehydrogenase","glycerate dehydrogenase","3-hydroxybutyrate dehydrogenase","3-hydroxyisobutyrate dehydrogenase","mevaldate reductase","mevaldate reductase (NADPH)","hydroxymethylglutaryl-CoA reductase (NADPH)","3-hydroxyacyl-CoA dehydrogenase","acetoacetyl-CoA reductase","malate dehydrogenase","malate dehydrogenase (oxaloacetate-decarboxylating)","malate dehydrogenase (decarboxylating)","malate dehydrogenase (oxaloacetate-decarboxylating) (NADP+)","isocitrate dehydrogenase (NAD+)","isocitrate dehydrogenase (NADP+)","phosphogluconate 2-dehydrogenase","phosphogluconate dehydrogenase (decarboxylating)","L-gulonate 3-dehydrogenase","L-arabinose 1-dehydrogenase","glucose 1-dehydrogenase","galactose 1-dehydrogenase","glucose-6-phosphate dehydrogenase","3alpha-hydroxysteroid dehydrogenase (B-specific)","3(or 17)beta-hydroxysteroid dehydrogenase","3alpha-hydroxycholanate dehydrogenase","3alpha(or 20beta)-hydroxysteroid dehydrogenase","allyl-alcohol dehydrogenase","lactaldehyde reductase (NADPH)","ribitol 2-dehydrogenase","fructuronate reductase","tagaturonate reductase","3-hydroxypropionate dehydrogenase","2-hydroxy-3-oxopropionate reductase","4-hydroxybutyrate dehydrogenase","estradiol 17beta-dehydrogenase","testosterone 17beta-dehydrogenase","testosterone 17beta-dehydrogenase (NADP+)","pyridoxine 4-dehydrogenase","omega-hydroxydecanoate dehydrogenase","mannitol 2-dehydrogenase","gluconate 5-dehydrogenase","alcohol dehydrogenase [NAD(P)+]","glycerol dehydrogenase (NADP+)","octanol dehydrogenase","(R)-aminopropanol dehydrogenase","(S,S)-butanediol dehydrogenase","lactaldehyde reductase","methylglyoxal reductase (NADH-dependent)","glyoxylate reductase (NADP+)","isopropanol dehydrogenase (NADP+)","hydroxypyruvate reductase","malate dehydrogenase (NADP+)","D-malate dehydrogenase (decarboxylating)","dimethylmalate dehydrogenase","3-isopropylmalate dehydrogenase","ketol-acid reductoisomerase","homoisocitrate dehydrogenase","hydroxymethylglutaryl-CoA reductase","aryl-alcohol dehydrogenase","aryl-alcohol dehydrogenase (NADP+)","oxaloglycolate reductase (decarboxylating)","tartrate dehydrogenase","glycerol-3-phosphate dehydrogenase [NAD(P)+]","phosphoglycerate dehydrogenase","diiodophenylpyruvate reductase","3-hydroxybenzyl-alcohol dehydrogenase","(R)-2-hydroxy-fatty-acid dehydrogenase","(S)-2-hydroxy-fatty-acid dehydrogenase","3-oxoacyl-[acyl-carrier-protein] reductase","acylglycerone-phosphate reductase","3-dehydrosphinganine reductase","L-threonine 3-dehydrogenase","4-oxoproline reductase","all-trans-retinol dehydrogenase (NAD+)","pantoate 4-dehydrogenase","pyridoxal 4-dehydrogenase","carnitine 3-dehydrogenase","indolelactate dehydrogenase","3-(imidazol-5-yl)lactate dehydrogenase","indanol dehydrogenase","L-xylose 1-dehydrogenase","apiose 1-reductase","ribose 1-dehydrogenase (NADP+)","D-arabinose 1-dehydrogenase","D-arabinose 1-dehydrogenase [NAD(P)+]","glucose 1-dehydrogenase (NAD+)","glucose 1-dehydrogenase (NADP+)","galactose 1-dehydrogenase (NADP+)","aldose 1-dehydrogenase","D-threo-aldose 1-dehydrogenase","sorbose 5-dehydrogenase (NADP+)","fructose 5-dehydrogenase (NADP+)","2-deoxy-D-gluconate 3-dehydrogenase","2-dehydro-3-deoxy-D-gluconate 6-dehydrogenase","2-dehydro-3-deoxy-D-gluconate 5-dehydrogenase","L-idonate 2-dehydrogenase","L-threonate 3-dehydrogenase","3-dehydro-L-gulonate 2-dehydrogenase","mannuronate reductase","GDP-mannose 6-dehydrogenase","dTDP-4-dehydrorhamnose reductase","dTDP-6-deoxy-L-talose 4-dehydrogenase","GDP-6-deoxy-D-talose 4-dehydrogenase","UDP-N-acetylglucosamine 6-dehydrogenase","ribitol-5-phosphate 2-dehydrogenase","mannitol 2-dehydrogenase (NADP+)","sorbitol-6-phosphate 2-dehydrogenase","15-hydroxyprostaglandin dehydrogenase (NAD+)","D-pinitol dehydrogenase","sequoyitol dehydrogenase","perillyl-alcohol dehydrogenase","3beta-hydroxy-Delta5-steroid dehydrogenase","11beta-hydroxysteroid dehydrogenase","16alpha-hydroxysteroid dehydrogenase","estradiol 17alpha-dehydrogenase","20alpha-hydroxysteroid dehydrogenase","21-hydroxysteroid dehydrogenase (NAD+)","21-hydroxysteroid dehydrogenase (NADP+)","3alpha-hydroxy-5beta-androstane-17-one 3alpha-dehydrogenase","sepiapterin reductase","ureidoglycolate dehydrogenase","glycerol 2-dehydrogenase (NADP+)","3-hydroxybutyryl-CoA dehydrogenase","UDP-N-acetylmuramate dehydrogenase","7alpha-hydroxysteroid dehydrogenase","dihydrobunolol dehydrogenase","cholestanetetraol 26-dehydrogenase","erythrulose reductase","cyclopentanol dehydrogenase","hexadecanol dehydrogenase","2-alkyn-1-ol dehydrogenase","hydroxycyclohexanecarboxylate dehydrogenase","hydroxymalonate dehydrogenase","2-dehydropantolactone reductase (A-specific)","2-dehydropantoate 2-reductase","sterol-4alpha-carboxylate 3-dehydrogenase (decarboxylating)","2-oxoadipate reductase","L-rhamnose 1-dehydrogenase","cyclohexane-1,2-diol dehydrogenase","D-xylose 1-dehydrogenase","12alpha-hydroxysteroid dehydrogenase","glycerol-3-phosphate 1-dehydrogenase (NADP+)","3-hydroxy-2-methylbutyryl-CoA dehydrogenase","D-xylose 1-dehydrogenase (NADP+)","cholest-5-ene-3beta,7alpha-diol 3beta-dehydrogenase","geraniol dehydrogenase","carbonyl reductase (NADPH)","L-glycol dehydrogenase","dTDP-galactose 6-dehydrogenase","GDP-4-dehydro-D-rhamnose reductase","prostaglandin-F synthase","prostaglandin-E2 9-reductase","indole-3-acetaldehyde reductase (NADH)","indole-3-acetaldehyde reductase (NADPH)","long-chain-alcohol dehydrogenase","5-amino-6-(5-phosphoribosylamino)uracil reductase","coniferyl-alcohol dehydrogenase","cinnamyl-alcohol dehydrogenase","15-hydroxyprostaglandin-D dehydrogenase (NADP+)","15-hydroxyprostaglandin dehydrogenase (NADP+)","(+)-borneol dehydrogenase","(S)-usnate reductase","aldose-6-phosphate reductase (NADPH)","7beta-hydroxysteroid dehydrogenase (NADP+)","1,3-propanediol dehydrogenase","uronate dehydrogenase","IMP dehydrogenase","tropinone reductase I","(-)-menthol dehydrogenase","(+)-neomenthol dehydrogenase","3(or 17)alpha-hydroxysteroid dehydrogenase","3beta(or 20alpha)-hydroxysteroid dehydrogenase","long-chain-3-hydroxyacyl-CoA dehydrogenase","3-oxoacyl-[acyl-carrier-protein] reductase (NADH)","3alpha-hydroxysteroid dehydrogenase (A-specific)","2-dehydropantolactone reductase (B-specific)","gluconate 2-dehydrogenase","farnesol dehydrogenase","benzyl-2-methyl-hydroxybutyrate dehydrogenase","morphine 6-dehydrogenase","dihydrokaempferol 4-reductase","6-pyruvoyltetrahydropterin 2'-reductase","vomifoliol dehydrogenase","(R)-4-hydroxyphenyllactate dehydrogenase","isopiperitenol dehydrogenase","mannose-6-phosphate 6-reductase","chlordecone reductase","4-hydroxycyclohexanecarboxylate dehydrogenase","(-)-borneol dehydrogenase","(+)-sabinol dehydrogenase","diethyl 2-methyl-3-oxosuccinate reductase","3alpha-hydroxyglycyrrhetinate dehydrogenase","15-hydroxyprostaglandin-I dehydrogenase (NADP+)","15-hydroxyicosatetraenoate dehydrogenase","N-acylmannosamine 1-dehydrogenase","flavanone 4-reductase","8-oxocoformycin reductase","tropinone reductase II","hydroxyphenylpyruvate reductase","12beta-hydroxysteroid dehydrogenase","3alpha(17beta)-hydroxysteroid dehydrogenase (NAD+)","N-acetylhexosamine 1-dehydrogenase","6-endo-hydroxycineole dehydrogenase","carveol dehydrogenase","methanol dehydrogenase","cyclohexanol dehydrogenase","pterocarpin synthase","codeinone reductase (NADPH)","salutaridine reductase (NADPH)","D-arabinitol 2-dehydrogenase","galactitol-1-phosphate 5-dehydrogenase","tetrahydroxynaphthalene reductase","(S)-carnitine 3-dehydrogenase","mannitol dehydrogenase","fluoren-9-ol dehydrogenase","4-(hydroxymethyl)benzenesulfonate dehydrogenase","6-hydroxyhexanoate dehydrogenase","3-hydroxypimeloyl-CoA dehydrogenase","sulcatone reductase","sn-glycerol-1-phosphate dehydrogenase","4-hydroxythreonine-4-phosphate dehydrogenase","1,5-anhydro-D-fructose reductase","L-idonate 5-dehydrogenase","3-methylbutanal reductase","dTDP-4-dehydro-6-deoxyglucose reductase","1-deoxy-D-xylulose-5-phosphate reductoisomerase","tRNA-dihydrouridine16/17 synthase [NAD(P)+]","2-(R)-hydroxypropyl-CoM dehydrogenase","2-(S)-hydroxypropyl-CoM dehydrogenase","3-keto-steroid reductase","GDP-L-fucose synthase","(R)-2-hydroxyacid dehydrogenase","vellosimine dehydrogenase","2,5-didehydrogluconate reductase","(+)-trans-carveol dehydrogenase","serine 3-dehydrogenase","3beta-hydroxy-5beta-steroid dehydrogenase","3beta-hydroxy-5alpha-steroid dehydrogenase","(R)-3-hydroxyacid-ester dehydrogenase","(S)-3-hydroxyacid-ester dehydrogenase","GDP-4-dehydro-6-deoxy-D-mannose reductase","quinate/shikimate dehydrogenase","methylglyoxal reductase (NADPH-dependent)","S-(hydroxymethyl)glutathione dehydrogenase","3''-deamino-3''-oxonicotianamine reductase","isocitrate---homoisocitrate dehydrogenase","D-arabinitol dehydrogenase (NADP+)","xanthoxin dehydrogenase","mannitol dehydrogenase (cytochrome)","L-lactate dehydrogenase (cytochrome)","D-lactate dehydrogenase (cytochrome)","D-lactate dehydrogenase (cytochrome c-553)","malate oxidase","glucose oxidase","hexose oxidase","cholesterol oxidase","aryl-alcohol oxidase","L-gulonolactone oxidase","galactose oxidase","pyranose oxidase","L-sorbose oxidase","pyridoxine 4-oxidase","alcohol oxidase","catechol oxidase (dimerizing)","(S)-2-hydroxy-acid oxidase","ecdysone oxidase","choline oxidase","secondary-alcohol oxidase","4-hydroxymandelate oxidase","long-chain-alcohol oxidase","glycerol-3-phosphate oxidase","thiamine oxidase","L-galactonolactone oxidase","hydroxyphytanate oxidase","nucleoside oxidase","N-acylhexosamine oxidase","polyvinyl-alcohol oxidase","D-arabinono-1,4-lactone oxidase","vanillyl-alcohol oxidase","nucleoside oxidase (H2O2-forming)","D-mannitol oxidase","alditol oxidase","vitamin-K-epoxide reductase (warfarin-sensitive)","vitamin-K-epoxide reductase (warfarin-insensitive)","quinoprotein glucose dehydrogenase","choline dehydrogenase","2-hydroxyglutarate dehydrogenase","gluconate 2-dehydrogenase (acceptor)","dehydrogluconate dehydrogenase","glycerol-3-phosphate dehydrogenase","D-2-hydroxy-acid dehydrogenase","lactate---malate transhydrogenase","alcohol dehydrogenase (acceptor)","pyridoxine 5-dehydrogenase","glucose dehydrogenase (acceptor)","fructose 5-dehydrogenase","sorbose dehydrogenase","glucoside 3-dehydrogenase","glycolate dehydrogenase","malate dehydrogenase (acceptor)","cellobiose dehydrogenase (acceptor)","uracil dehydrogenase","alkan-1-ol dehydrogenase (acceptor)","D-sorbitol dehydrogenase (acceptor)","glycerol dehydrogenase (acceptor)","polyvinyl-alcohol dehydrogenase (acceptor)","hydroxyacid-oxoacid transhydrogenase","quinate dehydrogenase (pyrroloquinoline-quinone)","3-hydroxycyclohexanone dehydrogenase","(R)-pantolactone dehydrogenase (flavin)","glucose-fructose oxidoreductase","pyranose dehydrogenase (acceptor)","2-oxo-acid reductase","formate dehydrogenase","aldehyde dehydrogenase (NAD+)","aldehyde dehydrogenase (NADP+)","aldehyde dehydrogenase [NAD(P)+]","benzaldehyde dehydrogenase (NADP+)","betaine-aldehyde dehydrogenase","glyceraldehyde-3-phosphate dehydrogenase (NADP+)","acetaldehyde dehydrogenase (acetylating)","aspartate-semialdehyde dehydrogenase","glyceraldehyde-3-phosphate dehydrogenase (phosphorylating)","glyceraldehyde-3-phosphate dehydrogenase (NADP+) (phosphorylating)","malonate-semialdehyde dehydrogenase","succinate-semialdehyde dehydrogenase [NAD(P)+]","glyoxylate dehydrogenase (acylating)","malonate-semialdehyde dehydrogenase (acetylating)","aminobutyraldehyde dehydrogenase","glutarate-semialdehyde dehydrogenase","glycolaldehyde dehydrogenase","lactaldehyde dehydrogenase","2-oxoaldehyde dehydrogenase (NAD+)","succinate-semialdehyde dehydrogenase (NAD+)","2-oxoisovalerate dehydrogenase (acylating)","2,5-dioxovalerate dehydrogenase","methylmalonate-semialdehyde dehydrogenase (acylating)","benzaldehyde dehydrogenase (NAD+)","aryl-aldehyde dehydrogenase","aryl-aldehyde dehydrogenase (NADP+)","L-aminoadipate-semialdehyde dehydrogenase","aminomuconate-semialdehyde dehydrogenase","(R)-dehydropantoate dehydrogenase","retinal dehydrogenase","N-acetyl-gamma-glutamyl-phosphate reductase","phenylacetaldehyde dehydrogenase","3alpha,7alpha,12alpha-trihydroxycholestan-26-al 26-oxidoreductase","glutamate-5-semialdehyde dehydrogenase","hexadecanal dehydrogenase (acylating)","formate dehydrogenase (NADP+)","cinnamoyl-CoA reductase","4-carboxy-2-hydroxymuconate-6-semialdehyde dehydrogenase","sulfoacetaldehyde dehydrogenase (acylating)","formaldehyde dehydrogenase","4-trimethylammoniobutyraldehyde dehydrogenase","long-chain-aldehyde dehydrogenase","2-oxoaldehyde dehydrogenase (NADP+)","long-chain-fatty-acyl-CoA reductase","pyruvate dehydrogenase (NADP+)","oxoglutarate dehydrogenase (NADP+)","4-hydroxyphenylacetaldehyde dehydrogenase","gamma-guanidinobutyraldehyde dehydrogenase","butanal dehydrogenase","phenylglyoxylate dehydrogenase (acylating)","glyceraldehyde-3-phosphate dehydrogenase (NAD(P)+) (phosphorylating)","5-carboxymethyl-2-hydroxymuconic-semialdehyde dehydrogenase","4-hydroxymuconic-semialdehyde dehydrogenase","4-formylbenzenesulfonate dehydrogenase","6-oxohexanoate dehydrogenase","4-hydroxybenzaldehyde dehydrogenase","salicylaldehyde dehydrogenase","mycothiol-dependent formaldehyde dehydrogenase","vanillin dehydrogenase","coniferyl-aldehyde dehydrogenase","fluoroacetaldehyde dehydrogenase","glutamyl-tRNA reductase","formate dehydrogenase (cytochrome)","pyruvate dehydrogenase (cytochrome)","formate dehydrogenase (cytochrome-c-553)","carbon-monoxide dehydrogenase (cytochrome b-561)","aldehyde oxidase","pyruvate oxidase","oxalate oxidase","glyoxylate oxidase","pyruvate oxidase (CoA-acetylating)","indole-3-acetaldehyde oxidase","pyridoxal oxidase","aryl-aldehyde oxidase","retinal oxidase","4-hydroxyphenylpyruvate oxidase","abscisic-aldehyde oxidase","pyruvate dehydrogenase (acetyl-transferring)","oxoglutarate dehydrogenase (succinyl-transferring)","3-methyl-2-oxobutanoate dehydrogenase (2-methylpropanoyl-transferring)","pyruvate synthase","2-oxobutyrate synthase","2-oxoglutarate synthase","carbon-monoxide dehydrogenase (ferredoxin)","aldehyde ferredoxin oxidoreductase","glyceraldehyde-3-phosphate dehydrogenase (ferredoxin)","3-methyl-2-oxobutanoate dehydrogenase (ferredoxin)","indolepyruvate ferredoxin oxidoreductase","carbon-monoxide dehydrogenase (acceptor)","aldehyde dehydrogenase (pyrroloquinoline-quinone)","formaldehyde dismutase","formylmethanofuran dehydrogenase","carboxylate reductase","aldehyde dehydrogenase (FAD-independent)","dihydropyrimidine dehydrogenase (NAD+)","dihydropyrimidine dehydrogenase (NADP+)","Delta4-3-oxosteroid 5beta-reductase","cortisone alpha-reductase","cucurbitacin Delta23-reductase","fumarate reductase (NADH)","meso-tartrate dehydrogenase","acyl-CoA dehydrogenase (NADP+)","enoyl-[acyl-carrier-protein] reductase (NADH)","enoyl-[acyl-carrier-protein] reductase (NADPH, B-specific)","2-coumarate reductase","prephenate dehydrogenase","prephenate dehydrogenase (NADP+)","dihydroorotate dehydrogenase (NAD+)","dihydroorotate dehydrogenase (NADP+)","beta-nitroacrylate reductase","3-methyleneoxindole reductase","kynurenate-7,8-dihydrodiol dehydrogenase","cis-1,2-dihydrobenzene-1,2-diol dehydrogenase","trans-1,2-dihydrobenzene-1,2-diol dehydrogenase","7-dehydrocholesterol reductase","cholestenone 5alpha-reductase","biliverdin reductase","1,6-dihydroxycyclohexa-2,4-diene-1-carboxylate dehydrogenase","dihydrodipicolinate reductase","2-hexadecenal reductase","2,3-dihydro-2,3-dihydroxybenzoate dehydrogenase","cis-1,2-dihydro-1,2-dihydroxynaphthalene dehydrogenase","progesterone 5alpha-reductase","2-enoate reductase","maleylacetate reductase","protochlorophyllide reductase","2,4-dienoyl-CoA reductase (NADPH)","phosphatidylcholine desaturase","geissoschizine dehydrogenase","cis-2-enoyl-CoA reductase (NADPH)","trans-2-enoyl-CoA reductase (NADPH)","enoyl-[acyl-carrier-protein] reductase (NADPH, A-specific)","2-hydroxy-6-oxo-6-phenylhexa-2,4-dienoate reductase","xanthommatin reductase","12-oxophytodienoate reductase","arogenate dehydrogenase","trans-2-enoyl-CoA reductase (NAD+)","2'-hydroxyisoflavone reductase","biochanin-A reductase","alpha-santonin 1,2-reductase","15-oxoprostaglandin 13-oxidase","cis-3,4-dihydrophenanthrene-3,4-diol dehydrogenase","2'-hydroxydaidzein reductase","2-methyl-branched-chain-enoyl-CoA reductase","(3S,4R)-3,4-dihydroxycyclohexa-1,5-diene-1,4-dicarboxylate dehydrogenase","precorrin-6A reductase","cis-2,3-dihydrobiphenyl-2,3-diol dehydrogenase","phloroglucinol reductase","2,3-dihydroxy-2,3-dihydro-p-cumate dehydrogenase","1,2-dihydroxy-3-methyl-1,2-dihydrobenzoate dehydrogenase","dibenzothiophene dihydrodiol dehydrogenase","terephthalate 1,2-cis-dihydrodiol dehydrogenase","pimeloyl-CoA dehydrogenase","2,4-dichlorobenzoyl-CoA reductase","phthalate 4,5-cis-dihydrodiol dehydrogenase","5,6-dihydroxy-3-methyl-2-oxo-1,2,5,6-tetrahydroquinoline dehydrogenase","cis-dihydroethylcatechol dehydrogenase","cis-1,2-dihydroxy-4-methylcyclohexa-3,5-diene-1-carboxylate dehydrogenase","1,2-dihydroxy-6-methylcyclohexa-3,5-dienecarboxylate dehydrogenase","zeatin reductase","Delta14-sterol reductase","Delta24(241)-sterol reductase","Delta24-sterol reductase","1,2-dihydrovomilenine reductase","2-alkenal reductase","divinyl chlorophyllide a 8-vinyl-reductase","precorrin-2 dehydrogenase","anthocyanidin reductase","arogenate dehydrogenase (NADP+)","arogenate dehydrogenase [NAD(P)+]","L-galactonolactone dehydrogenase","dihydroorotate oxidase","coproporphyrinogen oxidase","protoporphyrinogen oxidase","bilirubin oxidase","acyl-CoA oxidase","dihydrouracil oxidase","tetrahydroberberine oxidase","secologanin synthase","tryptophan alpha,beta-oxidase","pyrroloquinoline-quinone synthase","succinate dehydrogenase (ubiquinone)","6-hydroxynicotinate reductase","15,16-dihydrobiliverdin:ferredoxin oxidoreductase","phycoerythrobilin:ferredoxin oxidoreductase","phytochromobilin:ferredoxin oxidoreductase","phycocyanobilin:ferredoxin oxidoreductase","succinate dehydrogenase","butyryl-CoA dehydrogenase","acyl-CoA dehydrogenase","3-oxosteroid 1-dehydrogenase","3-oxo-5alpha-steroid 4-dehydrogenase","3-oxo-5beta-steroid 4-dehydrogenase","glutaryl-CoA dehydrogenase","2-furoyl-CoA dehydrogenase","isovaleryl-CoA dehydrogenase","dihydroorotate dehydrogenase","2-methylacyl-CoA dehydrogenase","long-chain-acyl-CoA dehydrogenase","cyclohexanone dehydrogenase","benzoyl-CoA reductase","isoquinoline 1-oxidoreductase","quinoline 2-oxidoreductase","quinaldate 4-oxidoreductase","quinoline-4-carboxylate 2-oxidoreductase","4-hydroxybenzoyl-CoA reductase","(R)-benzylsuccinyl-CoA dehydrogenase","coproporphyrinogen dehydrogenase","all-trans-retinol 13,14-reductase","alanine dehydrogenase","glutamate dehydrogenase","glutamate dehydrogenase [NAD(P)+]","glutamate dehydrogenase (NADP+)","L-amino-acid dehydrogenase","serine 2-dehydrogenase","valine dehydrogenase (NADP+)","leucine dehydrogenase","glycine dehydrogenase","L-erythro-3,5-diaminohexanoate dehydrogenase","2,4-diaminopentanoate dehydrogenase","glutamate synthase (NADPH)","glutamate synthase (NADH)","lysine dehydrogenase","diaminopimelate dehydrogenase","N-methylalanine dehydrogenase","lysine 6-dehydrogenase","tryptophan dehydrogenase","phenylalanine dehydrogenase","aspartate dehydrogenase","glycine dehydrogenase (cytochrome)","D-aspartate oxidase","L-amino-acid oxidase","D-amino-acid oxidase","monoamine oxidase","pyridoxal 5'-phosphate synthase","amine oxidase (copper-containing)","D-glutamate oxidase","ethanolamine oxidase","putrescine oxidase","L-glutamate oxidase","cyclohexylamine oxidase","protein-lysine 6-oxidase","L-lysine oxidase","D-glutamate(D-aspartate) oxidase","L-aspartate oxidase","glycine oxidase","glycine dehydrogenase (decarboxylating)","glutamate synthase (ferredoxin)","D-amino-acid dehydrogenase","taurine dehydrogenase","amine dehydrogenase","aralkylamine dehydrogenase","glycine dehydrogenase (cyanide-forming)","pyrroline-2-carboxylate reductase","pyrroline-5-carboxylate reductase","dihydrofolate reductase","methylenetetrahydrofolate dehydrogenase (NADP+)","formyltetrahydrofolate dehydrogenase","saccharopine dehydrogenase (NAD+, L-lysine-forming)","saccharopine dehydrogenase (NADP+, L-lysine-forming)","saccharopine dehydrogenase (NAD+, L-glutamate-forming)","saccharopine dehydrogenase (NADP+, L-glutamate-forming)","D-octopine dehydrogenase","1-pyrroline-5-carboxylate dehydrogenase","methylenetetrahydrofolate dehydrogenase (NAD+)","D-lysopine dehydrogenase","alanopine dehydrogenase","ephedrine dehydrogenase","D-nopaline dehydrogenase","methylenetetrahydrofolate reductase [NAD(P)H]","Delta1-piperideine-2-carboxylate reductase","strombine dehydrogenase","tauropine dehydrogenase","N5-(carboxyethyl)ornithine synthase","thiomorpholine-carboxylate dehydrogenase","beta-alanopine dehydrogenase","1,2-dehydroreticulinium reductase (NADPH)","opine dehydrogenase","FMN reductase [NAD(P)H]","flavin reductase (NADPH)","berberine reductase","vomilenine reductase","pteridine reductase","6,7-dihydropteridine reductase","sarcosine oxidase","N-methyl-L-amino-acid oxidase","N6-methyl-lysine oxidase","(S)-6-hydroxynicotine oxidase","(R)-6-hydroxynicotine oxidase","L-pipecolate oxidase","dimethylglycine oxidase","polyamine oxidase","dihydrobenzophenanthridine oxidase","pyrimidodiazepine synthase","electron-transferring-flavoprotein dehydrogenase","methylenetetrahydrofolate reductase (ferredoxin)","dimethylamine dehydrogenase","trimethylamine dehydrogenase","sarcosine dehydrogenase","dimethylglycine dehydrogenase","L-pipecolate dehydrogenase","nicotine dehydrogenase","methylglutamate dehydrogenase","spermidine dehydrogenase","proline dehydrogenase","methylenetetrahydromethanopterin dehydrogenase","5,10-methylenetetrahydromethanopterin reductase","cytokinin dehydrogenase","NAD(P)+ transhydrogenase (B-specific)","NAD(P)+ transhydrogenase (AB-specific)","cytochrome-b5 reductase","NADPH---hemoprotein reductase","NADPH---cytochrome-c2 reductase","leghemoglobin reductase","NAD(P)H oxidase","NAD(P)H dehydrogenase (quinone)","NADH:ubiquinone reductase (H+-translocating)","monodehydroascorbate reductase (NADH)","NADPH:quinone reductase","p-benzoquinone reductase (NADPH)","2-hydroxy-1,4-benzoquinone reductase","trimethylamine-N-oxide reductase","NADPH dehydrogenase","NADH dehydrogenase","NADH dehydrogenase (quinone)","NADPH dehydrogenase (quinone)","nitrate reductase (NADH)","nitrate reductase [NAD(P)H]","nitrate reductase (NADPH)","nitrite reductase [NAD(P)H]","hyponitrite reductase","azobenzene reductase","GMP reductase","nitroquinoline-N-oxide reductase","hydroxylamine reductase (NADH)","4-(dimethylamino)phenylazoxybenzene reductase","N-hydroxy-2-acetamidofluorene reductase","nitrite reductase (NO-forming)","nitrite reductase (cytochrome; ammonia-forming)","trimethylamine-N-oxide reductase (cytochrome c)","nitroalkane oxidase","acetylindoxyl oxidase","factor-independent urate hydroxylase","hydroxylamine oxidase","3-aci-nitropropanoate oxidase","ferredoxin---nitrite reductase","ferredoxin---nitrate reductase","hydroxylamine reductase","nitrate reductase","nitrous-oxide reductase","nitric-oxide reductase","hydrazine oxidoreductase","1,2-dihydroxynaphthalene dioxygenase","sulfite reductase (NADPH)"};
  static
  {
  	for (int i=0;i<test.length;i++)
  		new OntologyInstance(ENZYME,test[i]);
  }
	}