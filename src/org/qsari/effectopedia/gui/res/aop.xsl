<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" indent="yes" doctype-system="about:legacy-compat" />   
 
<!-- 
    Add Stressors in TOC
    Empty Stressor properties are not displayed
    Should we display Links 
    Should we display empty elements (with a negative id)
    References
    Structure of Tests
-->

<xsl:template match="/">
<html>
  <head>
    <title>Pathway</title>
    <link rel="stylesheet" type="text/css" href="res/aop.css" />
  </head>
  <body>
      <xsl:apply-templates select = "/xml:effectopedia/xml:pathways/xml:Pathway" /> 
  </body>
</html>
</xsl:template>

<xsl:template match="/xml:effectopedia/xml:pathways/xml:Pathway">
    <xsl:apply-templates select="xml:title" />
    <xsl:apply-templates select="xml:keywords" />
    <xsl:apply-templates select="xml:description/xml:objects/xml:DescriptionSection|xml:description/xml:objects/xml:DescriptionSection_Structured" />
    <!-- process references -->
    <xsl:apply-templates select="xml:elements" />
    <div class="pathwaySeparator"></div>
</xsl:template>

<xsl:template match="xml:title">
    <span class="imgPathway"></span>
    <h1><xsl:value-of select="." />&#160;(id:<xsl:value-of select="../@xml:id" />)</h1>
		<div class="pathwayDiagram">
		<img>
			<xsl:attribute name="src">
			<xsl:value-of select="concat('res/',../@xml:id,'.svg')" />
			</xsl:attribute>
		</img>
		</div>
</xsl:template>

<xsl:template match="xml:keywords">
  <div class="descriptionContent">  
    <div class="keywordsTitle">Pathway Keywords: <xsl:value-of select="." /></div>
  </div>
</xsl:template>

<!-- DescriptionSection or DescriptionsSection_Structured -->
<xsl:template match="xml:description/xml:objects/xml:DescriptionSection|xml:description/xml:objects/xml:DescriptionSection_Structured">
    <h2>
        <xsl:attribute name="id"><xsl:value-of select="../../@xml:id" /></xsl:attribute>
        <xsl:value-of select="xml:title" />
    </h2>
    <p><xsl:value-of select="xml:content" disable-output-escaping="yes" /></p>
    <xsl:apply-templates select="xml:structured_content/xml:conent_object/xml:objects" />    
</xsl:template>

<!-- Content of DescriptionsSection_Structured -->
<xsl:template match="xml:structured_content/xml:conent_object/xml:objects">
  <div class="naviContent">  
    <xsl:apply-templates select="xml:DescriptionSection_Structured" />
  </div>  
</xsl:template>


<xsl:template match="xml:DescriptionSection_Structured">
    <a class="naviLink">
      <xsl:attribute name="href">#<xsl:value-of select="xml:structured_content/xml:conent_object/xml:object_id"/></xsl:attribute>  
        <h3>
          <xsl:value-of select="xml:title" />
        </h3>
    </a>
    <p><xsl:value-of select = "xml:content" disable-output-escaping="yes" /></p>
</xsl:template>

<xsl:template match="xml:elements">
    <xsl:apply-templates select="xml:org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts|xml:org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation|xml:org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure" />
    <xsl:apply-templates select="xml:org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent|xml:org.qsari.effectopedia.core.objects.Effect_AdverseOutcome|xml:org.qsari.effectopedia.core.objects.Effect_DownstreamEffect|xml:org.qsari.effectopedia.core.objects.Effect_Endpoint" />
</xsl:template>

<xsl:template match="xml:org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts|xml:org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation|xml:org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure">
    <div class="stressorTitle">Stressor 
        <xsl:if test="name()='xml:org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts'"><span class="imgInitiator_StructuralAlerts"></span></xsl:if>
        <xsl:if test="name()='xml:org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation'"><span class="imgInitiator_BiologcalPerturbation"></span></xsl:if>
        <xsl:if test="name()='xml:org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure'"><span class="imgInitiator_ChemicalStructure"></span></xsl:if>
        <xsl:value-of select="xml:title" />
    </div>
    
    <!--
        <xsl:variable name="afterWidth" select="substring-after(xml:structure2DImage/xml:value,'w=')"/>  
        <xsl:variable name="widthEnd" select="substring-before($afterWidth,'h=')"/>
        
        <xsl:variable name="afterHeight" select="substring-after(xml:structure2DImage/xml:value,'h=')"/>  
        <xsl:variable name="heightEnd" select="substring-before($afterWidth,'media=')"/>        
    -->
        
    <div class="initiator2DImageDiv">
      <img>
        <xsl:attribute name="src"><xsl:value-of select="xml:structure2DImage/xml:value" /></xsl:attribute>  
        <!-- <xsl:attribute name="width"><xsl:value-of select="substring($afterWidth,1,string-length($widthEnd)-1)" /></xsl:attribute> -->
        <!-- <xsl:attribute name="height"><xsl:value-of select="xml:structure2DImage/xml:value" /></xsl:attribute>   -->
      </img>
    </div>    
    <table class="initiatorPropertiesTable">
      <tr class="tableHeader"><td>Descriptor</td><td>Value</td></tr> 
      <xsl:for-each select="xml:identification/xml:property">
          <xsl:if test="xml:value">
              <tr><td><xsl:value-of select="xml:type/@xml:name" /></td><td><xsl:value-of select="xml:value" /></td></tr>
          </xsl:if>
      </xsl:for-each>
    </table>
    <!-- <a href="#top" class="topLink">Top &#8593;</a> -->
</xsl:template>

<xsl:template match="xml:org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent|xml:org.qsari.effectopedia.core.objects.Effect_AdverseOutcome|xml:org.qsari.effectopedia.core.objects.Effect_DownstreamEffect|xml:org.qsari.effectopedia.core.objects.Effect_Endpoint">
    <div class="eventTitle">     
      <xsl:attribute name="id"><xsl:value-of select="./@xml:id"/></xsl:attribute>        
      <xsl:if test="name()='xml:org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent'"><span class="imgEffect_MolecularInitiatingEvent" title="Molecular Initiating Event"></span></xsl:if>
      <xsl:if test="name()='xml:org.qsari.effectopedia.core.objects.Effect_DownstreamEffect'"><span class="imgEffect_DownstreamEffect" title="Downstream Effect"></span></xsl:if>        
      <xsl:if test="name()='xml:org.qsari.effectopedia.core.objects.Effect_Endpoint'"><span class="imgEffect_Endpoint" title="Endpoint"></span></xsl:if>
      <xsl:if test="name()='xml:org.qsari.effectopedia.core.objects.Effect_AdverseOutcome'"><span class="imgEffect_AdverseOutcome" title="Adverse Outcome"></span></xsl:if>
      <xsl:value-of select="xml:title" />
    </div>
    <xsl:apply-templates select="xml:description/xml:objects/xml:DescriptionSection" />
    <a class="topLink">
        <xsl:attribute name="href">#<xsl:value-of select="../../xml:description/@xml:id" /></xsl:attribute>
        Top &#8593;
    </a>
</xsl:template>

<xsl:template match="xml:description/xml:objects/xml:DescriptionSection">
  <div class="descriptionContent">  
    <div class="descriptionSectionTitle"><xsl:value-of select="xml:title" /></div>
    <p><xsl:value-of select = "xml:content" disable-output-escaping="yes" /></p>   
  </div>
</xsl:template>

</xsl:stylesheet>    
    
    
    
<!--

          <xsl:variable name="id" select="xml:property/xml:type/@xml:id"/>
          <xsl:variable name="zero" select="0"/>
          <xsl:if test="number($id) > number($zero)">
          
-->