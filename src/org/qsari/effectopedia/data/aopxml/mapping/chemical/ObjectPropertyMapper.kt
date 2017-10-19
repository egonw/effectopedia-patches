package org.qsari.effectopedia.data.aopxml.mapping.chemical

import org.qsari.effectopedia.data.aopxml.mapping.ObjectPropertyMapperBase
import org.qsari.effectopedia.data.aopxml.objects.Data
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects

object ObjectPropertyMapper : ObjectPropertyMapperBase<Data.Chemical>(DefaultEffectopediaObjects.CHEMICAL_STRUCT_IDENT) {
    init {
        this.addMap("CASNO", { it.source.casrn }, { it.target.casrn = it.source.value.toString() })
        this.addMap("IUPAC_NAME", { it.source.iupacName }, { it.target.iupacName = it.source.value.toString() })
        this.addMap("SMILES", { it.source.smiles }, { it.target.smiles = it.source.value.toString() })
        this.addMap("Formula", { it.source.formula }, { it.target.formula = it.source.value.toString() })
        this.addMap("InChI", { it.source.inchi }, { it.target.inchi = it.source.value.toString() })
        this.addMap("InChI_Key", { it.source.jchemInchiKey }, { it.target.jchemInchiKey = it.source.value.toString() })
    }
}
