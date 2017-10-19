import java.io.PrintStream;
import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.modelling.ExecutableModel;
import org.qsari.effectopedia.core.modelling.ExecutionProgressListener;

import org.qsari.effectopedia.data.objects.Descriptor;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectProperty.ValueAndUnit;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;

/**
 * <code>JavaExecutableModel</code> is free source code part of Effectopedia
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * <p>
 * <code>JavaExecutableModel</code> is a minimalistic implementation of the
 * <code>ExecutableModel<code> interface which allows Effectopedia to execute models written
 * in Java. Effectopedia needs Java SE Development Kit 7 (JDK) or later
 * installed on the local machine in order to compile and execute this source
 * code. You can istall JDK form <a
 * href="http://www.oracle.com/technetwork/java/javase/downloads/index.html"
 * >here</a> For successful compilation you will also need
 * <code>effectopedia.jar</code> which is either the file you are currently
 * running or is supplied in the same directory as with your effectopedia.exe.
 * In both cases Effectopedia should detect the location and pass it as a
 * -classpath option to the java compiler.
 * </p>
 *
 * @author <a href="mailto:hristo.aladjov@effectopedia.org">Hristo Aladjov</a>
 * @version 1.0
 */
public class JavaExecutableModel implements ExecutableModel
 {
  
  /**
   * The <code>execute</code> method performs the execution of this model. It
   * uses the supplied model parameters to calculate the model output based on
   * the model input. All method parameters and return result are represented
   * using the same self describing data structure <code>ObjectProperties</code>
   * . Please refer to <code>printObjectPropertys</code> to get better
   * understanding on how to use this structure.
   *
   * @param input
   *         The input data of the model represented as a list of object
   *         proeprties.
   * @param modelParameters
   *         The list of parameters of the model to be executed. This list is
   *         usually defined in the global in-silco model (
   *         <code>Method_InSilicoGlobalModel</code> class). The local values of
   *         the parameters can be modified in the Effectopedia interface (using
   *         sliders and drop down lists) and stored for each individual
   *         tested/predicted substance or
   * @param output
   *         The output data of the model represented as a list of object
   *         proeprties. In this particular implementation the output is a clone
   *         of the input (i.e. no data transformation is made)
   * @return execute <code>true</code> if the execution of the model was
   *         successful and <code>false</code> otherwise.
   * @see ObjectProperties
   * @see printObjectProperties
   * @since 1.0
   */
  @Override
  public boolean execute(ObjectProperties input, ObjectProperties modelParameters, ObjectProperties output)
   {
    fireExecutionProgressMade(0);
    console.println("Executing Model for:");
    printObjectPropertys(input, "I. Input");
    printObjectPropertys(modelParameters, "II. Model Parameters");
    console.println(input.getProperty(0).getClass().getName());
    ObjectPropertyMultivalued_Documented inputChemConc = (ObjectPropertyMultivalued_Documented) input.getProperty(0);
    ObjectPropertyMultivalued_Documented outputResponse = (ObjectPropertyMultivalued_Documented) output.getProperty(0);
    int cnt = inputChemConc.valuesCount();
    // Verify it the output properties are properly initialized
    if (outputResponse.valuesCount() != cnt)
     {
      outputResponse.clearValuePairs();
      outputResponse.add(cnt);
     }
    // Calculate linear response
    Double slope = modelParameters.getProperty("Slope").getValue().getAsDouble();
    Double intercept = modelParameters.getProperty("Intercept").getValue().getAsDouble();
    int progress = 0;
    int progressStep = (cnt>0)?Math.round(100/cnt):100;
    for (int i = cnt - 1; i >= 0; i--)
     {
      Double x = inputChemConc.getValueAndUnitPair(i).getDoubleValue();
      Double y = slope*x+intercept;
      Documented_Value outputVal = outputResponse.getValueAndUnitPair(i); 
      outputVal.setDoubleValue(y);
      outputVal.getDescriptor(0).setFromDouble(x);
      progress += progressStep;
      fireExecutionProgressMade(progress);
     }
    fireExecutionProgressMade(100);
    return true;
   }
  
  /**
   * Add a new <code>ExecutionProgressListener</code> to the list of listeners.
   * This allows Effectopedia interface to show the progress of the execution in
   * a progress bar.
   *
   * @param listener
   *         The <code>ExecutionProgressListener</code> to be added
   * @see ExecutionProgressListener
   * @since 1.0
   */
  @Override
  public void addExecutionProgressListener(ExecutionProgressListener listener)
   {
    listeners.add(listener);
   }
  
  /**
   * Remove a <code>ExecutionProgressListener</code> from the list of listeners.
   *
   * @param listener
   *         The <code>ExecutionProgressListener</code> to be removed
   * @see ExecutionProgressListener
   * @since 1.0
   */
  @Override
  public void removeExecutionProgressListener(ExecutionProgressListener listener)
   {
    listeners.remove(listener);
   }
  
  /**
   * Notifies all <code>ExecutionProgressListener</code> from the list for the
   * progress made.
   *
   * @param percentComplete
   *         The <code>percentComplete</code> is an integer number between 0 and
   *         100 which represents the progress of the model execution.
   * @see ExecutionProgressListener
   * @since 1.0
   */
  public void fireExecutionProgressMade(int percentComplete)
   {
    for (ExecutionProgressListener l : listeners)
     l.onProgress(percentComplete);
   }
  
  /**
   * Set the output print stream for this model. Effectopedia uses this method
   * to display all model messages in a console component. If method is called
   * with null argument then the output is reset to the default System.out
   * stream.
   *
   * @param percentComplete
   *         The <code>percentComplete</code> is an integer number between 0 and
   *         100 which represents the progress of the model execution.
   * @see ExecutionProgressListener
   * @since 1.0
   */
  public void setConsole(PrintStream console)
   {
    this.console = (console == null) ? System.out : console;
   }
  
  /**
   * Helper method not required by the <code>ExecutableModel</code> interface
   * which can be used to display the values of the object properties in the
   * print stream of the model to display all model.
   *
   * @param properties
   *         The <code>ObjectProperties</code> to be printed.
   * @param name
   *         Display name of the object property to be printed.
   * @see PrintStream
   * @since 1.0
   */
  public void printObjectPropertys(ObjectProperties properties, String name)
   {
    if (properties != null)
     {
      /**
       * <code>ObjectProperties</code> contains a reference to an
       * <code>ObjectPropertyTypeContainer</code> class which defines the
       * structure of this list of properties. This class is a list of
       * <code>ObjectPropertyType</code> objects which describe the individual
       * properties contained in the list.
       */
      this.console.println(name + " (" + properties.getTypes().size() + ")");
      // Iterate over the contained ObjectProperties
      StringBuilder sb = new StringBuilder();
      for (ObjectProperty op : properties.getProperties())
       {
        // Get the type of the current object property - op
        ObjectPropertyType type = (ObjectPropertyType) op.getType();
        
        // Object property name
        sb.append(type.getName());
        // Object property type description
        sb.append(" has the following description ");
        sb.append(type.getDescription());
        
        // Object property name
        sb.append(type.getName());
        // Check if the object property can contain multiple values.
        if (type.isAcceptingMultipleValues())
         // The op instance is of ObjectProperty type
         sb.append(" can not contain multiple values.\n");
        else if (type.isDocumented())
         // The op instance is of ObjectProperty_Multivalued type
         sb.append(" can contain multiple documented values.\n");
        else
         // The op instance is of ObjectPropertyMultivalued_Documented type
         sb.append(" can contain multiple values.\n");
        
        sb.append(type.getName());
        sb.append(" can contain data from type ");
        // The data type of the op value
        sb.append(type.getBaseValueType().getName());
        if (type.getFixedValuesList() != null)
         {
          sb.append(" only from the following list of possible values: ");
          sb.append(type.getFixedValuesList().toString());
         }
        if (type.getDefaultUnit() != null)
         {
          sb.append(" with the default data units of:");
          sb.append(type.getDisplayUnit());
         }
        sb.append("\n");
        
        // Object property type can have zero or more additional descriptors
        if (type.getDescriptors().size() > 0)
         {
          sb.append(type.getName());
          sb.append(" has ");
          sb.append(type.getDescriptors().size());
          sb.append(" additional descriptor(s).These descriptors are:\n");
          
          for (DescriptorType descrType : type.getDescriptors().getAll())
           {
            // Descriptor types name
            sb.append("  ");
            sb.append(descrType.getName());
            sb.append(" has the following description:");
            // Descriptor types description
            sb.append(descrType.getDescription());
            sb.append(" has values from type:");
            sb.append(descrType.getBaseValueType().getName());
            if (descrType.getFixedValuesList() != null)
             {
              sb.append(" and can have values only from the following list: ");
              sb.append(descrType.getFixedValuesList().toString());
             }
            if (descrType.getDefaultUnit() != null)
             {
              sb.append(" with the default data units of:");
              sb.append(descrType.getDisplayUnit());
             }
            sb.append("\n");
           }
         }
        
        printObjectPtopertyValues(op, sb);
        // Object properties can be hierarchical and contain list of sub
        // properties.Use the same method recursivly to display their structure
        // and values
        printObjectPropertys(op.getSubProperties(), name + ".sub_properties");
       }
      console.println(sb.toString());
     }
    else
     console.println("null");
   }
  
  protected void printObjectPtopertyValues(ObjectProperty objectProperty, StringBuilder sb)
   {
    if (objectProperty instanceof ObjectPropertyMultivalued_Documented)
     {
      for (Documented_Value value : ((ObjectPropertyMultivalued_Documented) objectProperty).getValuePairs())
       {
        sb.append(objectProperty.getType().getName());
        sb.append(" has the following value: ");
        sb.append(value.getDisplayValue());
        sb.append(value.getDisplayUnit());
        sb.append(" and range [ ");
        sb.append(value.getDisplayMinValue());
        sb.append(value.getDisplayUnit());
        sb.append(", ");
        sb.append(value.getDisplayMinValue());
        sb.append(value.getDisplayUnit());
        sb.append("] ");
        sb.append(" descriptors: [");
        for (Descriptor descriptor : value.getDescriptors())
         {
          sb.append(descriptor.getType().getName());
          sb.append(": ");
          sb.append(descriptor.getDisplayValue());
          sb.append(descriptor.getDisplayUnit());
          sb.append(" ");
         }
        sb.append("]");
        
        sb.append(" notes: ");
        sb.append(value.getNotes());
        
        sb.append(" references: ");
        sb.append(value.getReferences());
        sb.append(value.getDisplayUnit());
        sb.append("\n");
       }
     }
    else if (objectProperty instanceof ObjectPropertyMultivalued)
     {
      for (ValueAndUnit value : ((ObjectPropertyMultivalued) objectProperty).getValuePairs())
       {
        sb.append("value: ");
        sb.append(value.getDisplayValue());
        sb.append(value.getDisplayUnit());
        sb.append("\n");
       }
     }
    else
     {
      sb.append("value: ");
      sb.append(objectProperty.getDisplayValue());
      sb.append(objectProperty.getDisplayUnit());
      sb.append("\n");
     }
   }
  
  protected PrintStream                          console   = System.out;
  protected ArrayList<ExecutionProgressListener> listeners = new ArrayList<ExecutionProgressListener>();
 }

