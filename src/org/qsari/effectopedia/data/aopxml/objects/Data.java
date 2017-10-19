
package org.qsari.effectopedia.data.aopxml.objects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chemical" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="inchi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="casrn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="jchem-inchi-key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="indigo-inchi-key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="iupac-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="smiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="preferred-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="synonyms" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="formula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="structural-diagram-2d" type="{http://www.w3.org/2001/XMLSchema}hexBinary" minOccurs="0"/>
 *                   &lt;element name="dsstox-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="biological-object" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
 *                 &lt;sequence>
 *                   &lt;element name="biological-organization" type="{http://www.aopkb.org/aop-xml}biological-organization-level-type"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="biological-process" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
 *                 &lt;sequence>
 *                   &lt;element name="biological-organization" type="{http://www.aopkb.org/aop-xml}biological-organization-level-type"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="biological-action" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="stressor" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="chemicals" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="chemical-initiator" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="chemical-id" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                     &lt;attribute name="user-term" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="structural-properties" type="{http://www.aopkb.org/aop-xml}property-values" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="associated-substances" type="{http://www.aopkb.org/aop-xml}substance-info" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="exposure-characterization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="taxonomy" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="key-event" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="short-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="biological-organization-level" type="{http://www.aopkb.org/aop-xml}biological-organization-level-type" minOccurs="0"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="measurement-methodology" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="evidence-supporting-taxonomic-applicability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="organ-term" type="{http://www.aopkb.org/aop-xml}biological-term-type" minOccurs="0"/>
 *                   &lt;element name="cell-term" type="{http://www.aopkb.org/aop-xml}biological-term-type" minOccurs="0"/>
 *                   &lt;element name="applicability" type="{http://www.aopkb.org/aop-xml}applicability-type" minOccurs="0"/>
 *                   &lt;element name="associated-tests" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="biological-events" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="biological-event" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="object-id" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                     &lt;attribute name="process-id" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                     &lt;attribute name="action-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="key-event-stressors" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key-event-stressor" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
 *                                     &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="references" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="source" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="AOPWiki"/>
 *                         &lt;enumeration value="Effectopedia"/>
 *                         &lt;enumeration value="Intermediate Effects DB"/>
 *                         &lt;enumeration value="AOP Xplorer"/>
 *                         &lt;enumeration value="Other"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="source-internal-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
 *                   &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="key-event-relationship" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="upstream-id" type="{http://www.aopkb.org/aop-xml}guid"/>
 *                             &lt;element name="downstream-id" type="{http://www.aopkb.org/aop-xml}guid"/>
 *                             &lt;element name="detail-level" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Hypothetical"/>
 *                                   &lt;enumeration value="One to One"/>
 *                                   &lt;enumeration value="Proportional"/>
 *                                   &lt;enumeration value="Threshold"/>
 *                                   &lt;enumeration value="Response-Response"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="temporal-concordance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="weight-of-evidence" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="biological-plausibility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="emperical-support-linkage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="uncertainties-or-inconsistencies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="quantitative-understanding" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="support-evidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="taxonomic-applicability" type="{http://www.aopkb.org/aop-xml}applicability-type" minOccurs="0"/>
 *                   &lt;element name="evidence-supporting-taxonomic-applicability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="references" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="source" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="AOPWiki"/>
 *                         &lt;enumeration value="Effectopedia"/>
 *                         &lt;enumeration value="Intermediate Effects DB"/>
 *                         &lt;enumeration value="AOP Xplorer"/>
 *                         &lt;enumeration value="Other"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="source-internal-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
 *                   &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="aop" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="short-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="authors" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="status" type="{http://www.aopkb.org/aop-xml}status"/>
 *                   &lt;element name="oecd-project" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="abstract" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="background" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="molecular-initiating-event" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="evidence-supporting-chemical-initiation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="key-event-id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="adverse-outcome" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="examples" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="regulatory-relevance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="organs-affected" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
 *                                     &lt;sequence>
 *                                       &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="scientific-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="key-event-id" type="{http://www.aopkb.org/aop-xml}guid" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="key-event-relationships" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="relationship" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="directness">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="direct"/>
 *                                             &lt;enumeration value="indirect"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="quantitative-understanding-value" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
 *                                       &lt;element name="evidence" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="essentiality-support" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="key-event-essentialities" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="essentiality" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="essentiality-level" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
 *                                       &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="key-event-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="applicability" type="{http://www.aopkb.org/aop-xml}applicability-type" minOccurs="0"/>
 *                   &lt;element name="overall-assessment" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="applicability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="key-event-essentiality-summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="weight-of-evidence-summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="quantitative-considerations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="potential-applications" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="aop-stressors" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="aop-stressor" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
 *                                     &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="references" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="source" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="AOPWiki"/>
 *                         &lt;enumeration value="Effectopedia"/>
 *                         &lt;enumeration value="Intermediate Effects DB"/>
 *                         &lt;enumeration value="AOP Xplorer"/>
 *                         &lt;enumeration value="Other"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="source-internal-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
 *                   &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="vendor-specific" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "chemical",
    "biologicalObject",
    "biologicalProcess",
    "biologicalAction",
    "stressor",
    "taxonomy",
    "keyEvent",
    "keyEventRelationship",
    "aop",
    "vendorSpecific"
})
@XmlRootElement(name = "data", namespace = "http://www.aopkb.org/aop-xml")
public class Data {

    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.Chemical> chemical;
    @XmlElement(name = "biological-object", namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.BiologicalObject> biologicalObject;
    @XmlElement(name = "biological-process", namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.BiologicalProcess> biologicalProcess;
    @XmlElement(name = "biological-action", namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.BiologicalAction> biologicalAction;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.Stressor> stressor;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.Taxonomy> taxonomy;
    @XmlElement(name = "key-event", namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.KeyEvent> keyEvent;
    @XmlElement(name = "key-event-relationship", namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.KeyEventRelationship> keyEventRelationship;
    @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
    protected List<Data.Aop> aop;
    @XmlElement(name = "vendor-specific", namespace = "http://www.aopkb.org/aop-xml")
    protected Data.VendorSpecific vendorSpecific;

    /**
     * Gets the value of the chemical property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chemical property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChemical().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.Chemical }
     * 
     * 
     */
    public List<Data.Chemical> getChemical() {
        if (chemical == null) {
            chemical = new ArrayList<Data.Chemical>();
        }
        return this.chemical;
    }

    /**
     * Gets the value of the biologicalObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biologicalObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiologicalObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.BiologicalObject }
     * 
     * 
     */
    public List<Data.BiologicalObject> getBiologicalObject() {
        if (biologicalObject == null) {
            biologicalObject = new ArrayList<Data.BiologicalObject>();
        }
        return this.biologicalObject;
    }

    /**
     * Gets the value of the biologicalProcess property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biologicalProcess property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiologicalProcess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.BiologicalProcess }
     * 
     * 
     */
    public List<Data.BiologicalProcess> getBiologicalProcess() {
        if (biologicalProcess == null) {
            biologicalProcess = new ArrayList<Data.BiologicalProcess>();
        }
        return this.biologicalProcess;
    }

    /**
     * Gets the value of the biologicalAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biologicalAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiologicalAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.BiologicalAction }
     * 
     * 
     */
    public List<Data.BiologicalAction> getBiologicalAction() {
        if (biologicalAction == null) {
            biologicalAction = new ArrayList<Data.BiologicalAction>();
        }
        return this.biologicalAction;
    }

    /**
     * Gets the value of the stressor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stressor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStressor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.Stressor }
     * 
     * 
     */
    public List<Data.Stressor> getStressor() {
        if (stressor == null) {
            stressor = new ArrayList<Data.Stressor>();
        }
        return this.stressor;
    }

    /**
     * Gets the value of the taxonomy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxonomy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxonomy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.Taxonomy }
     * 
     * 
     */
    public List<Data.Taxonomy> getTaxonomy() {
        if (taxonomy == null) {
            taxonomy = new ArrayList<Data.Taxonomy>();
        }
        return this.taxonomy;
    }

    /**
     * Gets the value of the keyEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.KeyEvent }
     * 
     * 
     */
    public List<Data.KeyEvent> getKeyEvent() {
        if (keyEvent == null) {
            keyEvent = new ArrayList<Data.KeyEvent>();
        }
        return this.keyEvent;
    }

    /**
     * Gets the value of the keyEventRelationship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyEventRelationship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyEventRelationship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.KeyEventRelationship }
     * 
     * 
     */
    public List<Data.KeyEventRelationship> getKeyEventRelationship() {
        if (keyEventRelationship == null) {
            keyEventRelationship = new ArrayList<Data.KeyEventRelationship>();
        }
        return this.keyEventRelationship;
    }

    /**
     * Gets the value of the aop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data.Aop }
     * 
     * 
     */
    public List<Data.Aop> getAop() {
        if (aop == null) {
            aop = new ArrayList<Data.Aop>();
        }
        return this.aop;
    }

    /**
     * Gets the value of the vendorSpecific property.
     * 
     * @return
     *     possible object is
     *     {@link Data.VendorSpecific }
     *     
     */
    public Data.VendorSpecific getVendorSpecific() {
        return vendorSpecific;
    }

    /**
     * Sets the value of the vendorSpecific property.
     * 
     * @param value
     *     allowed object is
     *     {@link Data.VendorSpecific }
     *     
     */
    public void setVendorSpecific(Data.VendorSpecific value) {
        this.vendorSpecific = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="short-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="authors" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="status" type="{http://www.aopkb.org/aop-xml}status"/>
     *         &lt;element name="oecd-project" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="abstract" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="background" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="molecular-initiating-event" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="evidence-supporting-chemical-initiation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="key-event-id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="adverse-outcome" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="examples" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="regulatory-relevance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="organs-affected" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
     *                           &lt;sequence>
     *                             &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="scientific-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="key-event-id" type="{http://www.aopkb.org/aop-xml}guid" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="key-event-relationships" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="relationship" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="directness">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="direct"/>
     *                                   &lt;enumeration value="indirect"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="quantitative-understanding-value" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
     *                             &lt;element name="evidence" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="essentiality-support" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="key-event-essentialities" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="essentiality" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="essentiality-level" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
     *                             &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="key-event-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="applicability" type="{http://www.aopkb.org/aop-xml}applicability-type" minOccurs="0"/>
     *         &lt;element name="overall-assessment" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="applicability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="key-event-essentiality-summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="weight-of-evidence-summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="quantitative-considerations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="potential-applications" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="aop-stressors" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="aop-stressor" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
     *                           &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="references" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="source" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="AOPWiki"/>
     *               &lt;enumeration value="Effectopedia"/>
     *               &lt;enumeration value="Intermediate Effects DB"/>
     *               &lt;enumeration value="AOP Xplorer"/>
     *               &lt;enumeration value="Other"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="source-internal-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
     *         &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "title",
        "shortName",
        "authors",
        "status",
        "oecdProject",
        "_abstract",
        "background",
        "molecularInitiatingEvent",
        "adverseOutcome",
        "keyEventRelationships",
        "essentialitySupport",
        "keyEventEssentialities",
        "applicability",
        "overallAssessment",
        "potentialApplications",
        "aopStressors",
        "references",
        "source",
        "sourceInternalId",
        "uri",
        "qualityAssurance",
        "creationTimestamp",
        "lastModificationTimestamp"
    })
    public static class Aop {

        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String title;
        @XmlElement(name = "short-name", namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String shortName;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String authors;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected Status status;
        @XmlElement(name = "oecd-project", namespace = "http://www.aopkb.org/aop-xml")
        protected String oecdProject;
        @XmlElement(name = "abstract", namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String _abstract;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String background;
        @XmlElement(name = "molecular-initiating-event", namespace = "http://www.aopkb.org/aop-xml")
        protected List<Data.Aop.MolecularInitiatingEvent> molecularInitiatingEvent;
        @XmlElement(name = "adverse-outcome", namespace = "http://www.aopkb.org/aop-xml")
        protected List<Data.Aop.AdverseOutcome> adverseOutcome;
        @XmlElement(name = "key-event-relationships", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.Aop.KeyEventRelationships keyEventRelationships;
        @XmlElement(name = "essentiality-support", namespace = "http://www.aopkb.org/aop-xml")
        protected List<Object> essentialitySupport;
        @XmlElement(name = "key-event-essentialities", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.Aop.KeyEventEssentialities keyEventEssentialities;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected ApplicabilityType applicability;
        @XmlElement(name = "overall-assessment", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.Aop.OverallAssessment overallAssessment;
        @XmlElement(name = "potential-applications", namespace = "http://www.aopkb.org/aop-xml")
        protected String potentialApplications;
        @XmlElement(name = "aop-stressors", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.Aop.AopStressors aopStressors;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String references;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String source;
        @XmlElement(name = "source-internal-id", namespace = "http://www.aopkb.org/aop-xml")
        protected String sourceInternalId;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected List<String> uri;
        @XmlElement(name = "quality-assurance", namespace = "http://www.aopkb.org/aop-xml")
        protected QaType qualityAssurance;
        @XmlElement(name = "creation-timestamp", namespace = "http://www.aopkb.org/aop-xml", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar creationTimestamp;
        @XmlElement(name = "last-modification-timestamp", namespace = "http://www.aopkb.org/aop-xml", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastModificationTimestamp;
        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the shortName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShortName() {
            return shortName;
        }

        /**
         * Sets the value of the shortName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShortName(String value) {
            this.shortName = value;
        }

        /**
         * Gets the value of the authors property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthors() {
            return authors;
        }

        /**
         * Sets the value of the authors property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthors(String value) {
            this.authors = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link Status }
         *     
         */
        public Status getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link Status }
         *     
         */
        public void setStatus(Status value) {
            this.status = value;
        }

        /**
         * Gets the value of the oecdProject property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOecdProject() {
            return oecdProject;
        }

        /**
         * Sets the value of the oecdProject property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOecdProject(String value) {
            this.oecdProject = value;
        }

        /**
         * Gets the value of the abstract property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAbstract() {
            return _abstract;
        }

        /**
         * Sets the value of the abstract property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAbstract(String value) {
            this._abstract = value;
        }

        /**
         * Gets the value of the background property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBackground() {
            return background;
        }

        /**
         * Sets the value of the background property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBackground(String value) {
            this.background = value;
        }

        /**
         * Gets the value of the molecularInitiatingEvent property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the molecularInitiatingEvent property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMolecularInitiatingEvent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Data.Aop.MolecularInitiatingEvent }
         * 
         * 
         */
        public List<Data.Aop.MolecularInitiatingEvent> getMolecularInitiatingEvent() {
            if (molecularInitiatingEvent == null) {
                molecularInitiatingEvent = new ArrayList<Data.Aop.MolecularInitiatingEvent>();
            }
            return this.molecularInitiatingEvent;
        }

        /**
         * Gets the value of the adverseOutcome property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the adverseOutcome property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdverseOutcome().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Data.Aop.AdverseOutcome }
         * 
         * 
         */
        public List<Data.Aop.AdverseOutcome> getAdverseOutcome() {
            if (adverseOutcome == null) {
                adverseOutcome = new ArrayList<Data.Aop.AdverseOutcome>();
            }
            return this.adverseOutcome;
        }

        /**
         * Gets the value of the keyEventRelationships property.
         * 
         * @return
         *     possible object is
         *     {@link Data.Aop.KeyEventRelationships }
         *     
         */
        public Data.Aop.KeyEventRelationships getKeyEventRelationships() {
            return keyEventRelationships;
        }

        /**
         * Sets the value of the keyEventRelationships property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.Aop.KeyEventRelationships }
         *     
         */
        public void setKeyEventRelationships(Data.Aop.KeyEventRelationships value) {
            this.keyEventRelationships = value;
        }

        /**
         * Gets the value of the essentialitySupport property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the essentialitySupport property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEssentialitySupport().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * 
         * 
         */
        public List<Object> getEssentialitySupport() {
            if (essentialitySupport == null) {
                essentialitySupport = new ArrayList<Object>();
            }
            return this.essentialitySupport;
        }

        /**
         * Gets the value of the keyEventEssentialities property.
         * 
         * @return
         *     possible object is
         *     {@link Data.Aop.KeyEventEssentialities }
         *     
         */
        public Data.Aop.KeyEventEssentialities getKeyEventEssentialities() {
            return keyEventEssentialities;
        }

        /**
         * Sets the value of the keyEventEssentialities property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.Aop.KeyEventEssentialities }
         *     
         */
        public void setKeyEventEssentialities(Data.Aop.KeyEventEssentialities value) {
            this.keyEventEssentialities = value;
        }

        /**
         * Gets the value of the applicability property.
         * 
         * @return
         *     possible object is
         *     {@link ApplicabilityType }
         *     
         */
        public ApplicabilityType getApplicability() {
            return applicability;
        }

        /**
         * Sets the value of the applicability property.
         * 
         * @param value
         *     allowed object is
         *     {@link ApplicabilityType }
         *     
         */
        public void setApplicability(ApplicabilityType value) {
            this.applicability = value;
        }

        /**
         * Gets the value of the overallAssessment property.
         * 
         * @return
         *     possible object is
         *     {@link Data.Aop.OverallAssessment }
         *     
         */
        public Data.Aop.OverallAssessment getOverallAssessment() {
            return overallAssessment;
        }

        /**
         * Sets the value of the overallAssessment property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.Aop.OverallAssessment }
         *     
         */
        public void setOverallAssessment(Data.Aop.OverallAssessment value) {
            this.overallAssessment = value;
        }

        /**
         * Gets the value of the potentialApplications property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPotentialApplications() {
            return potentialApplications;
        }

        /**
         * Sets the value of the potentialApplications property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPotentialApplications(String value) {
            this.potentialApplications = value;
        }

        /**
         * Gets the value of the aopStressors property.
         * 
         * @return
         *     possible object is
         *     {@link Data.Aop.AopStressors }
         *     
         */
        public Data.Aop.AopStressors getAopStressors() {
            return aopStressors;
        }

        /**
         * Sets the value of the aopStressors property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.Aop.AopStressors }
         *     
         */
        public void setAopStressors(Data.Aop.AopStressors value) {
            this.aopStressors = value;
        }

        /**
         * Gets the value of the references property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReferences() {
            return references;
        }

        /**
         * Sets the value of the references property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReferences(String value) {
            this.references = value;
        }

        /**
         * Gets the value of the source property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSource() {
            return source;
        }

        /**
         * Sets the value of the source property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Gets the value of the sourceInternalId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceInternalId() {
            return sourceInternalId;
        }

        /**
         * Sets the value of the sourceInternalId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceInternalId(String value) {
            this.sourceInternalId = value;
        }

        /**
         * Gets the value of the uri property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the uri property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUri().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUri() {
            if (uri == null) {
                uri = new ArrayList<String>();
            }
            return this.uri;
        }

        /**
         * Gets the value of the qualityAssurance property.
         * 
         * @return
         *     possible object is
         *     {@link QaType }
         *     
         */
        public QaType getQualityAssurance() {
            return qualityAssurance;
        }

        /**
         * Sets the value of the qualityAssurance property.
         * 
         * @param value
         *     allowed object is
         *     {@link QaType }
         *     
         */
        public void setQualityAssurance(QaType value) {
            this.qualityAssurance = value;
        }

        /**
         * Gets the value of the creationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCreationTimestamp() {
            return creationTimestamp;
        }

        /**
         * Sets the value of the creationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCreationTimestamp(XMLGregorianCalendar value) {
            this.creationTimestamp = value;
        }

        /**
         * Gets the value of the lastModificationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastModificationTimestamp() {
            return lastModificationTimestamp;
        }

        /**
         * Sets the value of the lastModificationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastModificationTimestamp(XMLGregorianCalendar value) {
            this.lastModificationTimestamp = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="examples" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="regulatory-relevance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="organs-affected" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
         *                 &lt;sequence>
         *                   &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="scientific-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="key-event-id" type="{http://www.aopkb.org/aop-xml}guid" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "examples",
            "regulatoryRelevance",
            "organsAffected"
        })
        public static class AdverseOutcome {

            @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
            protected String examples;
            @XmlElement(name = "regulatory-relevance", namespace = "http://www.aopkb.org/aop-xml")
            protected String regulatoryRelevance;
            @XmlElement(name = "organs-affected", namespace = "http://www.aopkb.org/aop-xml")
            protected List<Data.Aop.AdverseOutcome.OrgansAffected> organsAffected;
            @XmlAttribute(name = "key-event-id")
            protected String keyEventId;

            /**
             * Gets the value of the examples property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExamples() {
                return examples;
            }

            /**
             * Sets the value of the examples property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExamples(String value) {
                this.examples = value;
            }

            /**
             * Gets the value of the regulatoryRelevance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRegulatoryRelevance() {
                return regulatoryRelevance;
            }

            /**
             * Sets the value of the regulatoryRelevance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRegulatoryRelevance(String value) {
                this.regulatoryRelevance = value;
            }

            /**
             * Gets the value of the organsAffected property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the organsAffected property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOrgansAffected().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Data.Aop.AdverseOutcome.OrgansAffected }
             * 
             * 
             */
            public List<Data.Aop.AdverseOutcome.OrgansAffected> getOrgansAffected() {
                if (organsAffected == null) {
                    organsAffected = new ArrayList<Data.Aop.AdverseOutcome.OrgansAffected>();
                }
                return this.organsAffected;
            }

            /**
             * Gets the value of the keyEventId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKeyEventId() {
                return keyEventId;
            }

            /**
             * Sets the value of the keyEventId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKeyEventId(String value) {
                this.keyEventId = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
             *       &lt;sequence>
             *         &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="scientific-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "synonym",
                "scientificName"
            })
            public static class OrgansAffected
                extends EvidenceType
            {

                @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
                protected String synonym;
                @XmlElement(name = "scientific-name", namespace = "http://www.aopkb.org/aop-xml", required = true)
                protected String scientificName;

                /**
                 * Gets the value of the synonym property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSynonym() {
                    return synonym;
                }

                /**
                 * Sets the value of the synonym property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSynonym(String value) {
                    this.synonym = value;
                }

                /**
                 * Gets the value of the scientificName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getScientificName() {
                    return scientificName;
                }

                /**
                 * Sets the value of the scientificName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setScientificName(String value) {
                    this.scientificName = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="aop-stressor" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
         *                 &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "aopStressor"
        })
        public static class AopStressors {

            @XmlElement(name = "aop-stressor", namespace = "http://www.aopkb.org/aop-xml")
            protected List<Data.Aop.AopStressors.AopStressor> aopStressor;

            /**
             * Gets the value of the aopStressor property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the aopStressor property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAopStressor().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Data.Aop.AopStressors.AopStressor }
             * 
             * 
             */
            public List<Data.Aop.AopStressors.AopStressor> getAopStressor() {
                if (aopStressor == null) {
                    aopStressor = new ArrayList<Data.Aop.AopStressors.AopStressor>();
                }
                return this.aopStressor;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
             *       &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class AopStressor
                extends EvidenceType
            {

                @XmlAttribute(name = "stressor-id", required = true)
                protected String stressorId;

                /**
                 * Gets the value of the stressorId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStressorId() {
                    return stressorId;
                }

                /**
                 * Sets the value of the stressorId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStressorId(String value) {
                    this.stressorId = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="essentiality" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="essentiality-level" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
         *                   &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="key-event-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "essentiality"
        })
        public static class KeyEventEssentialities {

            @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
            protected List<Data.Aop.KeyEventEssentialities.Essentiality> essentiality;

            /**
             * Gets the value of the essentiality property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the essentiality property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEssentiality().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Data.Aop.KeyEventEssentialities.Essentiality }
             * 
             * 
             */
            public List<Data.Aop.KeyEventEssentialities.Essentiality> getEssentiality() {
                if (essentiality == null) {
                    essentiality = new ArrayList<Data.Aop.KeyEventEssentialities.Essentiality>();
                }
                return this.essentiality;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="essentiality-level" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
             *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
             *       &lt;/sequence>
             *       &lt;attribute name="key-event-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "essentialityLevel",
                "uri"
            })
            public static class Essentiality {

                @XmlElement(name = "essentiality-level", namespace = "http://www.aopkb.org/aop-xml", required = true)
                @XmlSchemaType(name = "string")
                protected ConfidenceLevelType essentialityLevel;
                @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
                protected List<String> uri;
                @XmlAttribute(name = "key-event-id", required = true)
                protected String keyEventId;

                /**
                 * Gets the value of the essentialityLevel property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ConfidenceLevelType }
                 *     
                 */
                public ConfidenceLevelType getEssentialityLevel() {
                    return essentialityLevel;
                }

                /**
                 * Sets the value of the essentialityLevel property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ConfidenceLevelType }
                 *     
                 */
                public void setEssentialityLevel(ConfidenceLevelType value) {
                    this.essentialityLevel = value;
                }

                /**
                 * Gets the value of the uri property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the uri property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getUri().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getUri() {
                    if (uri == null) {
                        uri = new ArrayList<String>();
                    }
                    return this.uri;
                }

                /**
                 * Gets the value of the keyEventId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getKeyEventId() {
                    return keyEventId;
                }

                /**
                 * Sets the value of the keyEventId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setKeyEventId(String value) {
                    this.keyEventId = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="relationship" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="directness">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="direct"/>
         *                         &lt;enumeration value="indirect"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="quantitative-understanding-value" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
         *                   &lt;element name="evidence" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "relationship"
        })
        public static class KeyEventRelationships {

            @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
            protected List<Data.Aop.KeyEventRelationships.Relationship> relationship;

            /**
             * Gets the value of the relationship property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the relationship property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRelationship().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Data.Aop.KeyEventRelationships.Relationship }
             * 
             * 
             */
            public List<Data.Aop.KeyEventRelationships.Relationship> getRelationship() {
                if (relationship == null) {
                    relationship = new ArrayList<Data.Aop.KeyEventRelationships.Relationship>();
                }
                return this.relationship;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="directness">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="direct"/>
             *               &lt;enumeration value="indirect"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="quantitative-understanding-value" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
             *         &lt;element name="evidence" type="{http://www.aopkb.org/aop-xml}confidence-level-type"/>
             *       &lt;/sequence>
             *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "directness",
                "quantitativeUnderstandingValue",
                "evidence"
            })
            public static class Relationship {

                @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
                protected String directness;
                @XmlElement(name = "quantitative-understanding-value", namespace = "http://www.aopkb.org/aop-xml", required = true)
                @XmlSchemaType(name = "string")
                protected ConfidenceLevelType quantitativeUnderstandingValue;
                @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
                @XmlSchemaType(name = "string")
                protected ConfidenceLevelType evidence;
                @XmlAttribute(name = "id", required = true)
                protected String id;

                /**
                 * Gets the value of the directness property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDirectness() {
                    return directness;
                }

                /**
                 * Sets the value of the directness property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDirectness(String value) {
                    this.directness = value;
                }

                /**
                 * Gets the value of the quantitativeUnderstandingValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ConfidenceLevelType }
                 *     
                 */
                public ConfidenceLevelType getQuantitativeUnderstandingValue() {
                    return quantitativeUnderstandingValue;
                }

                /**
                 * Sets the value of the quantitativeUnderstandingValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ConfidenceLevelType }
                 *     
                 */
                public void setQuantitativeUnderstandingValue(ConfidenceLevelType value) {
                    this.quantitativeUnderstandingValue = value;
                }

                /**
                 * Gets the value of the evidence property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ConfidenceLevelType }
                 *     
                 */
                public ConfidenceLevelType getEvidence() {
                    return evidence;
                }

                /**
                 * Sets the value of the evidence property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ConfidenceLevelType }
                 *     
                 */
                public void setEvidence(ConfidenceLevelType value) {
                    this.evidence = value;
                }

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getId() {
                    return id;
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setId(String value) {
                    this.id = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="evidence-supporting-chemical-initiation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="key-event-id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "evidenceSupportingChemicalInitiation"
        })
        public static class MolecularInitiatingEvent {

            @XmlElement(name = "evidence-supporting-chemical-initiation", namespace = "http://www.aopkb.org/aop-xml")
            protected String evidenceSupportingChemicalInitiation;
            @XmlAttribute(name = "key-event-id")
            @XmlSchemaType(name = "anySimpleType")
            protected String keyEventId;

            /**
             * Gets the value of the evidenceSupportingChemicalInitiation property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEvidenceSupportingChemicalInitiation() {
                return evidenceSupportingChemicalInitiation;
            }

            /**
             * Sets the value of the evidenceSupportingChemicalInitiation property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEvidenceSupportingChemicalInitiation(String value) {
                this.evidenceSupportingChemicalInitiation = value;
            }

            /**
             * Gets the value of the keyEventId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKeyEventId() {
                return keyEventId;
            }

            /**
             * Sets the value of the keyEventId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKeyEventId(String value) {
                this.keyEventId = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="applicability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="key-event-essentiality-summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="weight-of-evidence-summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="quantitative-considerations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "description",
            "applicability",
            "keyEventEssentialitySummary",
            "weightOfEvidenceSummary",
            "quantitativeConsiderations",
            "uri"
        })
        public static class OverallAssessment {

            @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
            protected String description;
            @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
            protected String applicability;
            @XmlElement(name = "key-event-essentiality-summary", namespace = "http://www.aopkb.org/aop-xml")
            protected String keyEventEssentialitySummary;
            @XmlElement(name = "weight-of-evidence-summary", namespace = "http://www.aopkb.org/aop-xml")
            protected String weightOfEvidenceSummary;
            @XmlElement(name = "quantitative-considerations", namespace = "http://www.aopkb.org/aop-xml")
            protected String quantitativeConsiderations;
            @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
            protected List<String> uri;

            /**
             * Gets the value of the description property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescription() {
                return description;
            }

            /**
             * Sets the value of the description property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescription(String value) {
                this.description = value;
            }

            /**
             * Gets the value of the applicability property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApplicability() {
                return applicability;
            }

            /**
             * Sets the value of the applicability property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApplicability(String value) {
                this.applicability = value;
            }

            /**
             * Gets the value of the keyEventEssentialitySummary property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKeyEventEssentialitySummary() {
                return keyEventEssentialitySummary;
            }

            /**
             * Sets the value of the keyEventEssentialitySummary property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKeyEventEssentialitySummary(String value) {
                this.keyEventEssentialitySummary = value;
            }

            /**
             * Gets the value of the weightOfEvidenceSummary property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWeightOfEvidenceSummary() {
                return weightOfEvidenceSummary;
            }

            /**
             * Sets the value of the weightOfEvidenceSummary property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWeightOfEvidenceSummary(String value) {
                this.weightOfEvidenceSummary = value;
            }

            /**
             * Gets the value of the quantitativeConsiderations property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuantitativeConsiderations() {
                return quantitativeConsiderations;
            }

            /**
             * Sets the value of the quantitativeConsiderations property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuantitativeConsiderations(String value) {
                this.quantitativeConsiderations = value;
            }

            /**
             * Gets the value of the uri property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the uri property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getUri().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getUri() {
                if (uri == null) {
                    uri = new ArrayList<String>();
                }
                return this.uri;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BiologicalAction
        extends BiologicalTermType
    {

        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
     *       &lt;sequence>
     *         &lt;element name="biological-organization" type="{http://www.aopkb.org/aop-xml}biological-organization-level-type"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "biologicalOrganization"
    })
    public static class BiologicalObject
        extends BiologicalTermType
    {

        @XmlElement(name = "biological-organization", namespace = "http://www.aopkb.org/aop-xml", required = true)
        @XmlSchemaType(name = "string")
        protected BiologicalOrganizationLevelType biologicalOrganization;
        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the biologicalOrganization property.
         * 
         * @return
         *     possible object is
         *     {@link BiologicalOrganizationLevelType }
         *     
         */
        public BiologicalOrganizationLevelType getBiologicalOrganization() {
            return biologicalOrganization;
        }

        /**
         * Sets the value of the biologicalOrganization property.
         * 
         * @param value
         *     allowed object is
         *     {@link BiologicalOrganizationLevelType }
         *     
         */
        public void setBiologicalOrganization(BiologicalOrganizationLevelType value) {
            this.biologicalOrganization = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
     *       &lt;sequence>
     *         &lt;element name="biological-organization" type="{http://www.aopkb.org/aop-xml}biological-organization-level-type"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "biologicalOrganization"
    })
    public static class BiologicalProcess
        extends BiologicalTermType
    {

        @XmlElement(name = "biological-organization", namespace = "http://www.aopkb.org/aop-xml", required = true)
        @XmlSchemaType(name = "string")
        protected BiologicalOrganizationLevelType biologicalOrganization;
        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the biologicalOrganization property.
         * 
         * @return
         *     possible object is
         *     {@link BiologicalOrganizationLevelType }
         *     
         */
        public BiologicalOrganizationLevelType getBiologicalOrganization() {
            return biologicalOrganization;
        }

        /**
         * Sets the value of the biologicalOrganization property.
         * 
         * @param value
         *     allowed object is
         *     {@link BiologicalOrganizationLevelType }
         *     
         */
        public void setBiologicalOrganization(BiologicalOrganizationLevelType value) {
            this.biologicalOrganization = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="inchi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="casrn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="jchem-inchi-key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="indigo-inchi-key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="iupac-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="smiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="preferred-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="synonyms" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="formula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="structural-diagram-2d" type="{http://www.w3.org/2001/XMLSchema}hexBinary" minOccurs="0"/>
     *         &lt;element name="dsstox-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "inchi",
        "casrn",
        "jchemInchiKey",
        "indigoInchiKey",
        "iupacName",
        "smiles",
        "preferredName",
        "synonyms",
        "formula",
        "structuralDiagram2D",
        "dsstoxId"
    })
    public static class Chemical {

        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String inchi;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String casrn;
        @XmlElement(name = "jchem-inchi-key", namespace = "http://www.aopkb.org/aop-xml")
        protected String jchemInchiKey;
        @XmlElement(name = "indigo-inchi-key", namespace = "http://www.aopkb.org/aop-xml")
        protected String indigoInchiKey;
        @XmlElement(name = "iupac-name", namespace = "http://www.aopkb.org/aop-xml")
        protected String iupacName;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String smiles;
        @XmlElement(name = "preferred-name", namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String preferredName;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected Data.Chemical.Synonyms synonyms;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String formula;
        @XmlElement(name = "structural-diagram-2d", namespace = "http://www.aopkb.org/aop-xml", type = String.class)
        @XmlJavaTypeAdapter(HexBinaryAdapter.class)
        @XmlSchemaType(name = "hexBinary")
        protected byte[] structuralDiagram2D;
        @XmlElement(name = "dsstox-id", namespace = "http://www.aopkb.org/aop-xml")
        protected String dsstoxId;
        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the inchi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInchi() {
            return inchi;
        }

        /**
         * Sets the value of the inchi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInchi(String value) {
            this.inchi = value;
        }

        /**
         * Gets the value of the casrn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCasrn() {
            return casrn;
        }

        /**
         * Sets the value of the casrn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCasrn(String value) {
            this.casrn = value;
        }

        /**
         * Gets the value of the jchemInchiKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJchemInchiKey() {
            return jchemInchiKey;
        }

        /**
         * Sets the value of the jchemInchiKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJchemInchiKey(String value) {
            this.jchemInchiKey = value;
        }

        /**
         * Gets the value of the indigoInchiKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndigoInchiKey() {
            return indigoInchiKey;
        }

        /**
         * Sets the value of the indigoInchiKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndigoInchiKey(String value) {
            this.indigoInchiKey = value;
        }

        /**
         * Gets the value of the iupacName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIupacName() {
            return iupacName;
        }

        /**
         * Sets the value of the iupacName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIupacName(String value) {
            this.iupacName = value;
        }

        /**
         * Gets the value of the smiles property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSmiles() {
            return smiles;
        }

        /**
         * Sets the value of the smiles property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSmiles(String value) {
            this.smiles = value;
        }

        /**
         * Gets the value of the preferredName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPreferredName() {
            return preferredName;
        }

        /**
         * Sets the value of the preferredName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPreferredName(String value) {
            this.preferredName = value;
        }

        /**
         * Gets the value of the synonyms property.
         * 
         * @return
         *     possible object is
         *     {@link Data.Chemical.Synonyms }
         *     
         */
        public Data.Chemical.Synonyms getSynonyms() {
            return synonyms;
        }

        /**
         * Sets the value of the synonyms property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.Chemical.Synonyms }
         *     
         */
        public void setSynonyms(Data.Chemical.Synonyms value) {
            this.synonyms = value;
        }

        /**
         * Gets the value of the formula property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFormula() {
            return formula;
        }

        /**
         * Sets the value of the formula property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFormula(String value) {
            this.formula = value;
        }

        /**
         * Gets the value of the structuralDiagram2D property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public byte[] getStructuralDiagram2D() {
            return structuralDiagram2D;
        }

        /**
         * Sets the value of the structuralDiagram2D property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStructuralDiagram2D(byte[] value) {
            this.structuralDiagram2D = value;
        }

        /**
         * Gets the value of the dsstoxId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDsstoxId() {
            return dsstoxId;
        }

        /**
         * Sets the value of the dsstoxId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDsstoxId(String value) {
            this.dsstoxId = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "synonym"
        })
        public static class Synonyms {

            @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
            protected List<String> synonym;

            /**
             * Gets the value of the synonym property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the synonym property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSynonym().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getSynonym() {
                if (synonym == null) {
                    synonym = new ArrayList<String>();
                }
                return this.synonym;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="short-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="biological-organization-level" type="{http://www.aopkb.org/aop-xml}biological-organization-level-type" minOccurs="0"/>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="measurement-methodology" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="evidence-supporting-taxonomic-applicability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="organ-term" type="{http://www.aopkb.org/aop-xml}biological-term-type" minOccurs="0"/>
     *         &lt;element name="cell-term" type="{http://www.aopkb.org/aop-xml}biological-term-type" minOccurs="0"/>
     *         &lt;element name="applicability" type="{http://www.aopkb.org/aop-xml}applicability-type" minOccurs="0"/>
     *         &lt;element name="associated-tests" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="biological-events" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="biological-event" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="object-id" type="{http://www.aopkb.org/aop-xml}guid" />
     *                           &lt;attribute name="process-id" type="{http://www.aopkb.org/aop-xml}guid" />
     *                           &lt;attribute name="action-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="key-event-stressors" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key-event-stressor" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
     *                           &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="references" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="source" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="AOPWiki"/>
     *               &lt;enumeration value="Effectopedia"/>
     *               &lt;enumeration value="Intermediate Effects DB"/>
     *               &lt;enumeration value="AOP Xplorer"/>
     *               &lt;enumeration value="Other"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="source-internal-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
     *         &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "title",
        "shortName",
        "biologicalOrganizationLevel",
        "description",
        "measurementMethodology",
        "evidenceSupportingTaxonomicApplicability",
        "organTerm",
        "cellTerm",
        "applicability",
        "associatedTests",
        "biologicalEvents",
        "keyEventStressors",
        "references",
        "source",
        "sourceInternalId",
        "uri",
        "qualityAssurance",
        "creationTimestamp",
        "lastModificationTimestamp"
    })
    public static class KeyEvent {

        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String title;
        @XmlElement(name = "short-name", namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String shortName;
        @XmlElement(name = "biological-organization-level", namespace = "http://www.aopkb.org/aop-xml")
        @XmlSchemaType(name = "string")
        protected BiologicalOrganizationLevelType biologicalOrganizationLevel;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String description;
        @XmlElement(name = "measurement-methodology", namespace = "http://www.aopkb.org/aop-xml")
        protected String measurementMethodology;
        @XmlElement(name = "evidence-supporting-taxonomic-applicability", namespace = "http://www.aopkb.org/aop-xml")
        protected String evidenceSupportingTaxonomicApplicability;
        @XmlElement(name = "organ-term", namespace = "http://www.aopkb.org/aop-xml")
        protected BiologicalTermType organTerm;
        @XmlElement(name = "cell-term", namespace = "http://www.aopkb.org/aop-xml")
        protected BiologicalTermType cellTerm;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected ApplicabilityType applicability;
        @XmlElement(name = "associated-tests", namespace = "http://www.aopkb.org/aop-xml")
        protected String associatedTests;
        @XmlElement(name = "biological-events", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.KeyEvent.BiologicalEvents biologicalEvents;
        @XmlElement(name = "key-event-stressors", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.KeyEvent.KeyEventStressors keyEventStressors;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String references;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String source;
        @XmlElement(name = "source-internal-id", namespace = "http://www.aopkb.org/aop-xml")
        protected String sourceInternalId;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String uri;
        @XmlElement(name = "quality-assurance", namespace = "http://www.aopkb.org/aop-xml")
        protected QaType qualityAssurance;
        @XmlElement(name = "creation-timestamp", namespace = "http://www.aopkb.org/aop-xml")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar creationTimestamp;
        @XmlElement(name = "last-modification-timestamp", namespace = "http://www.aopkb.org/aop-xml")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastModificationTimestamp;
        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the shortName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShortName() {
            return shortName;
        }

        /**
         * Sets the value of the shortName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShortName(String value) {
            this.shortName = value;
        }

        /**
         * Gets the value of the biologicalOrganizationLevel property.
         * 
         * @return
         *     possible object is
         *     {@link BiologicalOrganizationLevelType }
         *     
         */
        public BiologicalOrganizationLevelType getBiologicalOrganizationLevel() {
            return biologicalOrganizationLevel;
        }

        /**
         * Sets the value of the biologicalOrganizationLevel property.
         * 
         * @param value
         *     allowed object is
         *     {@link BiologicalOrganizationLevelType }
         *     
         */
        public void setBiologicalOrganizationLevel(BiologicalOrganizationLevelType value) {
            this.biologicalOrganizationLevel = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the measurementMethodology property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeasurementMethodology() {
            return measurementMethodology;
        }

        /**
         * Sets the value of the measurementMethodology property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeasurementMethodology(String value) {
            this.measurementMethodology = value;
        }

        /**
         * Gets the value of the evidenceSupportingTaxonomicApplicability property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEvidenceSupportingTaxonomicApplicability() {
            return evidenceSupportingTaxonomicApplicability;
        }

        /**
         * Sets the value of the evidenceSupportingTaxonomicApplicability property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEvidenceSupportingTaxonomicApplicability(String value) {
            this.evidenceSupportingTaxonomicApplicability = value;
        }

        /**
         * Gets the value of the organTerm property.
         * 
         * @return
         *     possible object is
         *     {@link BiologicalTermType }
         *     
         */
        public BiologicalTermType getOrganTerm() {
            return organTerm;
        }

        /**
         * Sets the value of the organTerm property.
         * 
         * @param value
         *     allowed object is
         *     {@link BiologicalTermType }
         *     
         */
        public void setOrganTerm(BiologicalTermType value) {
            this.organTerm = value;
        }

        /**
         * Gets the value of the cellTerm property.
         * 
         * @return
         *     possible object is
         *     {@link BiologicalTermType }
         *     
         */
        public BiologicalTermType getCellTerm() {
            return cellTerm;
        }

        /**
         * Sets the value of the cellTerm property.
         * 
         * @param value
         *     allowed object is
         *     {@link BiologicalTermType }
         *     
         */
        public void setCellTerm(BiologicalTermType value) {
            this.cellTerm = value;
        }

        /**
         * Gets the value of the applicability property.
         * 
         * @return
         *     possible object is
         *     {@link ApplicabilityType }
         *     
         */
        public ApplicabilityType getApplicability() {
            return applicability;
        }

        /**
         * Sets the value of the applicability property.
         * 
         * @param value
         *     allowed object is
         *     {@link ApplicabilityType }
         *     
         */
        public void setApplicability(ApplicabilityType value) {
            this.applicability = value;
        }

        /**
         * Gets the value of the associatedTests property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAssociatedTests() {
            return associatedTests;
        }

        /**
         * Sets the value of the associatedTests property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAssociatedTests(String value) {
            this.associatedTests = value;
        }

        /**
         * Gets the value of the biologicalEvents property.
         * 
         * @return
         *     possible object is
         *     {@link Data.KeyEvent.BiologicalEvents }
         *     
         */
        public Data.KeyEvent.BiologicalEvents getBiologicalEvents() {
            return biologicalEvents;
        }

        /**
         * Sets the value of the biologicalEvents property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.KeyEvent.BiologicalEvents }
         *     
         */
        public void setBiologicalEvents(Data.KeyEvent.BiologicalEvents value) {
            this.biologicalEvents = value;
        }

        /**
         * Gets the value of the keyEventStressors property.
         * 
         * @return
         *     possible object is
         *     {@link Data.KeyEvent.KeyEventStressors }
         *     
         */
        public Data.KeyEvent.KeyEventStressors getKeyEventStressors() {
            return keyEventStressors;
        }

        /**
         * Sets the value of the keyEventStressors property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.KeyEvent.KeyEventStressors }
         *     
         */
        public void setKeyEventStressors(Data.KeyEvent.KeyEventStressors value) {
            this.keyEventStressors = value;
        }

        /**
         * Gets the value of the references property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReferences() {
            return references;
        }

        /**
         * Sets the value of the references property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReferences(String value) {
            this.references = value;
        }

        /**
         * Gets the value of the source property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSource() {
            return source;
        }

        /**
         * Sets the value of the source property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Gets the value of the sourceInternalId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceInternalId() {
            return sourceInternalId;
        }

        /**
         * Sets the value of the sourceInternalId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceInternalId(String value) {
            this.sourceInternalId = value;
        }

        /**
         * Gets the value of the uri property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUri() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUri(String value) {
            this.uri = value;
        }

        /**
         * Gets the value of the qualityAssurance property.
         * 
         * @return
         *     possible object is
         *     {@link QaType }
         *     
         */
        public QaType getQualityAssurance() {
            return qualityAssurance;
        }

        /**
         * Sets the value of the qualityAssurance property.
         * 
         * @param value
         *     allowed object is
         *     {@link QaType }
         *     
         */
        public void setQualityAssurance(QaType value) {
            this.qualityAssurance = value;
        }

        /**
         * Gets the value of the creationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCreationTimestamp() {
            return creationTimestamp;
        }

        /**
         * Sets the value of the creationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCreationTimestamp(XMLGregorianCalendar value) {
            this.creationTimestamp = value;
        }

        /**
         * Gets the value of the lastModificationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastModificationTimestamp() {
            return lastModificationTimestamp;
        }

        /**
         * Sets the value of the lastModificationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastModificationTimestamp(XMLGregorianCalendar value) {
            this.lastModificationTimestamp = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="biological-event" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="object-id" type="{http://www.aopkb.org/aop-xml}guid" />
         *                 &lt;attribute name="process-id" type="{http://www.aopkb.org/aop-xml}guid" />
         *                 &lt;attribute name="action-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "biologicalEvent"
        })
        public static class BiologicalEvents {

            @XmlElement(name = "biological-event", namespace = "http://www.aopkb.org/aop-xml")
            protected List<Data.KeyEvent.BiologicalEvents.BiologicalEvent> biologicalEvent;

            /**
             * Gets the value of the biologicalEvent property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the biologicalEvent property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getBiologicalEvent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Data.KeyEvent.BiologicalEvents.BiologicalEvent }
             * 
             * 
             */
            public List<Data.KeyEvent.BiologicalEvents.BiologicalEvent> getBiologicalEvent() {
                if (biologicalEvent == null) {
                    biologicalEvent = new ArrayList<Data.KeyEvent.BiologicalEvents.BiologicalEvent>();
                }
                return this.biologicalEvent;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="object-id" type="{http://www.aopkb.org/aop-xml}guid" />
             *       &lt;attribute name="process-id" type="{http://www.aopkb.org/aop-xml}guid" />
             *       &lt;attribute name="action-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class BiologicalEvent {

                @XmlAttribute(name = "object-id")
                protected String objectId;
                @XmlAttribute(name = "process-id")
                protected String processId;
                @XmlAttribute(name = "action-id", required = true)
                protected String actionId;

                /**
                 * Gets the value of the objectId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getObjectId() {
                    return objectId;
                }

                /**
                 * Sets the value of the objectId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setObjectId(String value) {
                    this.objectId = value;
                }

                /**
                 * Gets the value of the processId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getProcessId() {
                    return processId;
                }

                /**
                 * Sets the value of the processId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setProcessId(String value) {
                    this.processId = value;
                }

                /**
                 * Gets the value of the actionId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getActionId() {
                    return actionId;
                }

                /**
                 * Sets the value of the actionId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setActionId(String value) {
                    this.actionId = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key-event-stressor" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
         *                 &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "keyEventStressor"
        })
        public static class KeyEventStressors {

            @XmlElement(name = "key-event-stressor", namespace = "http://www.aopkb.org/aop-xml")
            protected List<Data.KeyEvent.KeyEventStressors.KeyEventStressor> keyEventStressor;

            /**
             * Gets the value of the keyEventStressor property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the keyEventStressor property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getKeyEventStressor().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Data.KeyEvent.KeyEventStressors.KeyEventStressor }
             * 
             * 
             */
            public List<Data.KeyEvent.KeyEventStressors.KeyEventStressor> getKeyEventStressor() {
                if (keyEventStressor == null) {
                    keyEventStressor = new ArrayList<Data.KeyEvent.KeyEventStressors.KeyEventStressor>();
                }
                return this.keyEventStressor;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://www.aopkb.org/aop-xml}evidence-type">
             *       &lt;attribute name="stressor-id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class KeyEventStressor
                extends EvidenceType
            {

                @XmlAttribute(name = "stressor-id", required = true)
                protected String stressorId;

                /**
                 * Gets the value of the stressorId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getStressorId() {
                    return stressorId;
                }

                /**
                 * Sets the value of the stressorId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setStressorId(String value) {
                    this.stressorId = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="title">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="upstream-id" type="{http://www.aopkb.org/aop-xml}guid"/>
     *                   &lt;element name="downstream-id" type="{http://www.aopkb.org/aop-xml}guid"/>
     *                   &lt;element name="detail-level" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Hypothetical"/>
     *                         &lt;enumeration value="One to One"/>
     *                         &lt;enumeration value="Proportional"/>
     *                         &lt;enumeration value="Threshold"/>
     *                         &lt;enumeration value="Response-Response"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="temporal-concordance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="weight-of-evidence" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="biological-plausibility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="emperical-support-linkage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="uncertainties-or-inconsistencies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="quantitative-understanding" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="support-evidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="taxonomic-applicability" type="{http://www.aopkb.org/aop-xml}applicability-type" minOccurs="0"/>
     *         &lt;element name="evidence-supporting-taxonomic-applicability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="references" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="source" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="AOPWiki"/>
     *               &lt;enumeration value="Effectopedia"/>
     *               &lt;enumeration value="Intermediate Effects DB"/>
     *               &lt;enumeration value="AOP Xplorer"/>
     *               &lt;enumeration value="Other"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="source-internal-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
     *         &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "title",
        "description",
        "temporalConcordance",
        "weightOfEvidence",
        "quantitativeUnderstanding",
        "taxonomicApplicability",
        "evidenceSupportingTaxonomicApplicability",
        "references",
        "source",
        "sourceInternalId",
        "uri",
        "qualityAssurance",
        "creationTimestamp",
        "lastModificationTimestamp"
    })
    public static class KeyEventRelationship {

        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected Data.KeyEventRelationship.Title title;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String description;
        @XmlElement(name = "temporal-concordance", namespace = "http://www.aopkb.org/aop-xml")
        protected String temporalConcordance;
        @XmlElement(name = "weight-of-evidence", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.KeyEventRelationship.WeightOfEvidence weightOfEvidence;
        @XmlElement(name = "quantitative-understanding", namespace = "http://www.aopkb.org/aop-xml")
        protected Data.KeyEventRelationship.QuantitativeUnderstanding quantitativeUnderstanding;
        @XmlElement(name = "taxonomic-applicability", namespace = "http://www.aopkb.org/aop-xml")
        protected ApplicabilityType taxonomicApplicability;
        @XmlElement(name = "evidence-supporting-taxonomic-applicability", namespace = "http://www.aopkb.org/aop-xml")
        protected String evidenceSupportingTaxonomicApplicability;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String references;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String source;
        @XmlElement(name = "source-internal-id", namespace = "http://www.aopkb.org/aop-xml")
        protected String sourceInternalId;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected String uri;
        @XmlElement(name = "quality-assurance", namespace = "http://www.aopkb.org/aop-xml")
        protected QaType qualityAssurance;
        @XmlElement(name = "creation-timestamp", namespace = "http://www.aopkb.org/aop-xml")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar creationTimestamp;
        @XmlElement(name = "last-modification-timestamp", namespace = "http://www.aopkb.org/aop-xml")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastModificationTimestamp;
        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link Data.KeyEventRelationship.Title }
         *     
         */
        public Data.KeyEventRelationship.Title getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.KeyEventRelationship.Title }
         *     
         */
        public void setTitle(Data.KeyEventRelationship.Title value) {
            this.title = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the temporalConcordance property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTemporalConcordance() {
            return temporalConcordance;
        }

        /**
         * Sets the value of the temporalConcordance property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemporalConcordance(String value) {
            this.temporalConcordance = value;
        }

        /**
         * Gets the value of the weightOfEvidence property.
         * 
         * @return
         *     possible object is
         *     {@link Data.KeyEventRelationship.WeightOfEvidence }
         *     
         */
        public Data.KeyEventRelationship.WeightOfEvidence getWeightOfEvidence() {
            return weightOfEvidence;
        }

        /**
         * Sets the value of the weightOfEvidence property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.KeyEventRelationship.WeightOfEvidence }
         *     
         */
        public void setWeightOfEvidence(Data.KeyEventRelationship.WeightOfEvidence value) {
            this.weightOfEvidence = value;
        }

        /**
         * Gets the value of the quantitativeUnderstanding property.
         * 
         * @return
         *     possible object is
         *     {@link Data.KeyEventRelationship.QuantitativeUnderstanding }
         *     
         */
        public Data.KeyEventRelationship.QuantitativeUnderstanding getQuantitativeUnderstanding() {
            return quantitativeUnderstanding;
        }

        /**
         * Sets the value of the quantitativeUnderstanding property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.KeyEventRelationship.QuantitativeUnderstanding }
         *     
         */
        public void setQuantitativeUnderstanding(Data.KeyEventRelationship.QuantitativeUnderstanding value) {
            this.quantitativeUnderstanding = value;
        }

        /**
         * Gets the value of the taxonomicApplicability property.
         * 
         * @return
         *     possible object is
         *     {@link ApplicabilityType }
         *     
         */
        public ApplicabilityType getTaxonomicApplicability() {
            return taxonomicApplicability;
        }

        /**
         * Sets the value of the taxonomicApplicability property.
         * 
         * @param value
         *     allowed object is
         *     {@link ApplicabilityType }
         *     
         */
        public void setTaxonomicApplicability(ApplicabilityType value) {
            this.taxonomicApplicability = value;
        }

        /**
         * Gets the value of the evidenceSupportingTaxonomicApplicability property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEvidenceSupportingTaxonomicApplicability() {
            return evidenceSupportingTaxonomicApplicability;
        }

        /**
         * Sets the value of the evidenceSupportingTaxonomicApplicability property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEvidenceSupportingTaxonomicApplicability(String value) {
            this.evidenceSupportingTaxonomicApplicability = value;
        }

        /**
         * Gets the value of the references property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReferences() {
            return references;
        }

        /**
         * Sets the value of the references property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReferences(String value) {
            this.references = value;
        }

        /**
         * Gets the value of the source property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSource() {
            return source;
        }

        /**
         * Sets the value of the source property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Gets the value of the sourceInternalId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceInternalId() {
            return sourceInternalId;
        }

        /**
         * Sets the value of the sourceInternalId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceInternalId(String value) {
            this.sourceInternalId = value;
        }

        /**
         * Gets the value of the uri property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUri() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUri(String value) {
            this.uri = value;
        }

        /**
         * Gets the value of the qualityAssurance property.
         * 
         * @return
         *     possible object is
         *     {@link QaType }
         *     
         */
        public QaType getQualityAssurance() {
            return qualityAssurance;
        }

        /**
         * Sets the value of the qualityAssurance property.
         * 
         * @param value
         *     allowed object is
         *     {@link QaType }
         *     
         */
        public void setQualityAssurance(QaType value) {
            this.qualityAssurance = value;
        }

        /**
         * Gets the value of the creationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCreationTimestamp() {
            return creationTimestamp;
        }

        /**
         * Sets the value of the creationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCreationTimestamp(XMLGregorianCalendar value) {
            this.creationTimestamp = value;
        }

        /**
         * Gets the value of the lastModificationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastModificationTimestamp() {
            return lastModificationTimestamp;
        }

        /**
         * Sets the value of the lastModificationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastModificationTimestamp(XMLGregorianCalendar value) {
            this.lastModificationTimestamp = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="support-evidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "description",
            "supportEvidence"
        })
        public static class QuantitativeUnderstanding {

            @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
            protected String description;
            @XmlElement(name = "support-evidence", namespace = "http://www.aopkb.org/aop-xml")
            protected String supportEvidence;

            /**
             * Gets the value of the description property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescription() {
                return description;
            }

            /**
             * Sets the value of the description property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescription(String value) {
                this.description = value;
            }

            /**
             * Gets the value of the supportEvidence property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSupportEvidence() {
                return supportEvidence;
            }

            /**
             * Sets the value of the supportEvidence property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSupportEvidence(String value) {
                this.supportEvidence = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="upstream-id" type="{http://www.aopkb.org/aop-xml}guid"/>
         *         &lt;element name="downstream-id" type="{http://www.aopkb.org/aop-xml}guid"/>
         *         &lt;element name="detail-level" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Hypothetical"/>
         *               &lt;enumeration value="One to One"/>
         *               &lt;enumeration value="Proportional"/>
         *               &lt;enumeration value="Threshold"/>
         *               &lt;enumeration value="Response-Response"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "upstreamId",
            "downstreamId",
            "detailLevel"
        })
        public static class Title {

            @XmlElement(name = "upstream-id", namespace = "http://www.aopkb.org/aop-xml", required = true)
            protected String upstreamId;
            @XmlElement(name = "downstream-id", namespace = "http://www.aopkb.org/aop-xml", required = true)
            protected String downstreamId;
            @XmlElement(name = "detail-level", namespace = "http://www.aopkb.org/aop-xml", defaultValue = "Hypothetical")
            protected String detailLevel;

            /**
             * Gets the value of the upstreamId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUpstreamId() {
                return upstreamId;
            }

            /**
             * Sets the value of the upstreamId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUpstreamId(String value) {
                this.upstreamId = value;
            }

            /**
             * Gets the value of the downstreamId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDownstreamId() {
                return downstreamId;
            }

            /**
             * Sets the value of the downstreamId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDownstreamId(String value) {
                this.downstreamId = value;
            }

            /**
             * Gets the value of the detailLevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDetailLevel() {
                return detailLevel;
            }

            /**
             * Sets the value of the detailLevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDetailLevel(String value) {
                this.detailLevel = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="biological-plausibility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="emperical-support-linkage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="uncertainties-or-inconsistencies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value",
            "biologicalPlausibility",
            "empericalSupportLinkage",
            "uncertaintiesOrInconsistencies"
        })
        public static class WeightOfEvidence {

            @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
            protected String value;
            @XmlElement(name = "biological-plausibility", namespace = "http://www.aopkb.org/aop-xml")
            protected String biologicalPlausibility;
            @XmlElement(name = "emperical-support-linkage", namespace = "http://www.aopkb.org/aop-xml")
            protected String empericalSupportLinkage;
            @XmlElement(name = "uncertainties-or-inconsistencies", namespace = "http://www.aopkb.org/aop-xml")
            protected String uncertaintiesOrInconsistencies;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the biologicalPlausibility property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBiologicalPlausibility() {
                return biologicalPlausibility;
            }

            /**
             * Sets the value of the biologicalPlausibility property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBiologicalPlausibility(String value) {
                this.biologicalPlausibility = value;
            }

            /**
             * Gets the value of the empericalSupportLinkage property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmpericalSupportLinkage() {
                return empericalSupportLinkage;
            }

            /**
             * Sets the value of the empericalSupportLinkage property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmpericalSupportLinkage(String value) {
                this.empericalSupportLinkage = value;
            }

            /**
             * Gets the value of the uncertaintiesOrInconsistencies property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUncertaintiesOrInconsistencies() {
                return uncertaintiesOrInconsistencies;
            }

            /**
             * Sets the value of the uncertaintiesOrInconsistencies property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUncertaintiesOrInconsistencies(String value) {
                this.uncertaintiesOrInconsistencies = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="quality-assurance" type="{http://www.aopkb.org/aop-xml}qa-type" minOccurs="0"/>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="chemicals" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="chemical-initiator" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="chemical-id" type="{http://www.aopkb.org/aop-xml}guid" />
     *                           &lt;attribute name="user-term" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="structural-properties" type="{http://www.aopkb.org/aop-xml}property-values" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="synonym" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="associated-substances" type="{http://www.aopkb.org/aop-xml}substance-info" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="exposure-characterization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="creation-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="last-modification-timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "qualityAssurance",
        "description",
        "chemicals",
        "structuralProperties",
        "synonym",
        "associatedSubstances",
        "link",
        "exposureCharacterization",
        "creationTimestamp",
        "lastModificationTimestamp"
    })
    public static class Stressor {

        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String name;
        @XmlElement(name = "quality-assurance", namespace = "http://www.aopkb.org/aop-xml")
        protected QaType qualityAssurance;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml", required = true)
        protected String description;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected Data.Stressor.Chemicals chemicals;
        @XmlElement(name = "structural-properties", namespace = "http://www.aopkb.org/aop-xml")
        protected List<PropertyValues> structuralProperties;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected List<String> synonym;
        @XmlElement(name = "associated-substances", namespace = "http://www.aopkb.org/aop-xml")
        protected List<SubstanceInfo> associatedSubstances;
        @XmlElement(namespace = "http://www.aopkb.org/aop-xml")
        protected List<String> link;
        @XmlElement(name = "exposure-characterization", namespace = "http://www.aopkb.org/aop-xml")
        protected String exposureCharacterization;
        @XmlElement(name = "creation-timestamp", namespace = "http://www.aopkb.org/aop-xml")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar creationTimestamp;
        @XmlElement(name = "last-modification-timestamp", namespace = "http://www.aopkb.org/aop-xml")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar lastModificationTimestamp;
        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the qualityAssurance property.
         * 
         * @return
         *     possible object is
         *     {@link QaType }
         *     
         */
        public QaType getQualityAssurance() {
            return qualityAssurance;
        }

        /**
         * Sets the value of the qualityAssurance property.
         * 
         * @param value
         *     allowed object is
         *     {@link QaType }
         *     
         */
        public void setQualityAssurance(QaType value) {
            this.qualityAssurance = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the chemicals property.
         * 
         * @return
         *     possible object is
         *     {@link Data.Stressor.Chemicals }
         *     
         */
        public Data.Stressor.Chemicals getChemicals() {
            return chemicals;
        }

        /**
         * Sets the value of the chemicals property.
         * 
         * @param value
         *     allowed object is
         *     {@link Data.Stressor.Chemicals }
         *     
         */
        public void setChemicals(Data.Stressor.Chemicals value) {
            this.chemicals = value;
        }

        /**
         * Gets the value of the structuralProperties property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the structuralProperties property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStructuralProperties().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PropertyValues }
         * 
         * 
         */
        public List<PropertyValues> getStructuralProperties() {
            if (structuralProperties == null) {
                structuralProperties = new ArrayList<PropertyValues>();
            }
            return this.structuralProperties;
        }

        /**
         * Gets the value of the synonym property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the synonym property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSynonym().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSynonym() {
            if (synonym == null) {
                synonym = new ArrayList<String>();
            }
            return this.synonym;
        }

        /**
         * Gets the value of the associatedSubstances property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the associatedSubstances property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAssociatedSubstances().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SubstanceInfo }
         * 
         * 
         */
        public List<SubstanceInfo> getAssociatedSubstances() {
            if (associatedSubstances == null) {
                associatedSubstances = new ArrayList<SubstanceInfo>();
            }
            return this.associatedSubstances;
        }

        /**
         * Gets the value of the link property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the link property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLink().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLink() {
            if (link == null) {
                link = new ArrayList<String>();
            }
            return this.link;
        }

        /**
         * Gets the value of the exposureCharacterization property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExposureCharacterization() {
            return exposureCharacterization;
        }

        /**
         * Sets the value of the exposureCharacterization property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExposureCharacterization(String value) {
            this.exposureCharacterization = value;
        }

        /**
         * Gets the value of the creationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCreationTimestamp() {
            return creationTimestamp;
        }

        /**
         * Sets the value of the creationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCreationTimestamp(XMLGregorianCalendar value) {
            this.creationTimestamp = value;
        }

        /**
         * Gets the value of the lastModificationTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastModificationTimestamp() {
            return lastModificationTimestamp;
        }

        /**
         * Sets the value of the lastModificationTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastModificationTimestamp(XMLGregorianCalendar value) {
            this.lastModificationTimestamp = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="chemical-initiator" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="chemical-id" type="{http://www.aopkb.org/aop-xml}guid" />
         *                 &lt;attribute name="user-term" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "chemicalInitiator"
        })
        public static class Chemicals {

            @XmlElement(name = "chemical-initiator", namespace = "http://www.aopkb.org/aop-xml")
            protected List<Data.Stressor.Chemicals.ChemicalInitiator> chemicalInitiator;

            /**
             * Gets the value of the chemicalInitiator property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the chemicalInitiator property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getChemicalInitiator().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Data.Stressor.Chemicals.ChemicalInitiator }
             * 
             * 
             */
            public List<Data.Stressor.Chemicals.ChemicalInitiator> getChemicalInitiator() {
                if (chemicalInitiator == null) {
                    chemicalInitiator = new ArrayList<Data.Stressor.Chemicals.ChemicalInitiator>();
                }
                return this.chemicalInitiator;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="chemical-id" type="{http://www.aopkb.org/aop-xml}guid" />
             *       &lt;attribute name="user-term" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ChemicalInitiator {

                @XmlAttribute(name = "chemical-id")
                protected String chemicalId;
                @XmlAttribute(name = "user-term")
                protected String userTerm;

                /**
                 * Gets the value of the chemicalId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChemicalId() {
                    return chemicalId;
                }

                /**
                 * Sets the value of the chemicalId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChemicalId(String value) {
                    this.chemicalId = value;
                }

                /**
                 * Gets the value of the userTerm property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserTerm() {
                    return userTerm;
                }

                /**
                 * Sets the value of the userTerm property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserTerm(String value) {
                    this.userTerm = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.aopkb.org/aop-xml}biological-term-type">
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Taxonomy
        extends BiologicalTermType
    {

        @XmlAttribute(name = "id", required = true)
        protected String id;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax' maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.aopkb.org/aop-xml}guid" />
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class VendorSpecific {

        @XmlAnyElement(lax = true)
        protected List<Object> any;
        @XmlAttribute(name = "id", required = true)
        protected String id;
        @XmlAttribute(name = "name", required = true)
        protected String name;
        @XmlAttribute(name = "version")
        protected String version;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the version property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersion() {
            return version;
        }

        /**
         * Sets the value of the version property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersion(String value) {
            this.version = value;
        }

    }

}
