Two versions of Effectopedia are available effectopedia.jar and effectopediaT.jar which are functionally identical but one (Effectopedia.jar) connects to the production and the other (effectopediaT.jar) to the test server. EffectopediaT.jar also has an extra tab - System Console - to capture the system error messages and exceptions. You can use either of the jar files without need of installation on Windows, Mac OS, Linux and other operating systems supporting Java SE 8. You can use the windows setup file available in Windows_Installer folder if you prefer to run Effectopedia as a native windows application. Effectopedia could be also used offline by loading the last official release of the centralized database file available in OfflineDB folder. 

       ***** Effectopedia 1.2 (r584) Beta Update Log ***** 17 Oct 2017
**********************************************************************************
This release of Effectopedia introduces Phase II of the changes in the user interface targeted at improved user experience while reducing the chances for errors.
 - The single element pathway modes have been redesigned to show temporary image of the element which is going to be added/modified if the user clicks at the current position. Using this approach, it is always evident what will happen, however there are two drawbacks of the implementation - 1) currently the inserting of the new object is not smooth and cause jittering effect 2) when the final intended change is made there is no elegant exit of the mode (currently escape key or right click cancel). Element wizard mode (previously known as CLET) now inserts links between the elements automatically so the user can only choоse the location of the elements that have coordinates. In all new implementations the most recently added element is automatically loaded in the element editor.
 - Newly created elements in the new CELT pathway wizard mode are automatically loaded in the element editor panel. 
 - Context sensitive help for the former CLET wizard was updated with new help for the Pathway Element Wizard.
 - Recently added context sensitive pop up menu has been updated. Right click on temporary object now allows the current element placement mode to be terminated.

       ***** Effectopedia 1.1 (r583) Beta Update Log ***** 17 Oct 2017
**********************************************************************************
This release of Effectopedia introduces Phase I of the changes in the user interface targeted at improved user experience while reducing the chances for errors.
 - New popup menu was defined available on right click on Windows systems and long click on MacOS. The popup menu provides access to the properties editor of the element under the cursor. If no pathway element is under the cursor, then pathway properties can be accessed. Additionally, in the pathway popup menu there are options for refreshing the diagram (F5), changing its appearance by modifying font size and showing / hiding of all test methods and response mappings.  (Key) events, initiators and test have an item in the menu called Type which will allows the conversion of the type of the element under the cursor. This functionality is currently available for generic pathway elements only. All context menus also include an option for deletion of the current element. If selection is available, then two more items are also available (in the popup) hiding of the selection and deletion of the selection.
 - Pathway space now allowing users to hide empty segments. The new feature is available in the context popup menu and allows hiding empty segments of the pathway view allowing more compact rendition of the pathway diagram. This option is also respected in image export formats and HTML export which always hides empty segments. The new option is global and affects all pathway views. Currently there is no restriction of using this option in pathway building mode however when new pathway is created the mode is switched back to visible empty segments.
- Initial implementation of HTML export feature. The HTML export is generated as transformation of the Effectopedia's AOP file format with the help of a style based on xsl style sheet. Current version allows export of the entire data source in a single HTML file and includes Pathway, Chemical and (key) Event descriptions. Pathway diagram, links, tests, and test response mappings are still not processed. Along with the html file additional res directory is created which contains the aop file used in the export the style sheet aop.xsl, aop.css and element icons. The export also includes the pathway diagrams in a form of scrollable SVG images. The SVG image files are named after the pathway ID which is displayed in them and are stored in the res folder. On successful export user is notified with a message which additionally allows to open the newly created html file in the browser. Remote file upload is currently not supported.
 - Welcome screen was updated and now instead of list of links includes four large buttons allowing quick access to four major actions available in Effectopedia. 
 - Pathway editor interface buttons were updated and now include "+" symbol in front of each pathway element (signifying that the button is for adding elements). CLET icon was substituted with a Wizard icon. Linear pathway segment wizards were combined under a single drop down toggle button.
- Several improvements were made to existing wizard mode which detect user errors and ignore them. Also experimental mouse pointer repositioning was introduced for testing (to check if it helps the most frequent operation of adding element to the right of lastly created one). After placing an element which is not entirely visible the canvas is now automatically scrolled to show the complete element.
- The column header in the pathway viewer (indicating the zoom level details) was removed to simplify the interface.
 - Existing element editor panels for Test and (key) Events were updated. In the current implementation the preview of the selected element is collapsed by default which allows the “define new” and “use selected” buttons to be used without scrolling the panel.
 - Text field changes in the element editor panel trigger automatic refresh of the affected pathway element in the diagram. Current mechanism does not catch changes in the biological context or other table based fields.
 - Mouse scroll wheel can be used for zooming in and out the pathway diagram and the middle mouse button for panning. This functionality is available in all modes.
 - Highlight color of the pathway elements in the diagram was changed from red to darker version of the original color to add a distinction between highlight and selection. In addition to color the element under the cursor also have 1 pixel thicker frame.
 - Horizontal alignment of the element title edit fields were reverted to the standard left alignment. To prevent (the default Swing behaviour) showing only the last part of longer titles the caret was moved to the position 0 upon loading.
 - New strategy for properly closing the application when the user clicks on the X was introduced which adds WindowListener instead of previously defined ShutdownHook (which was not exiting the JavaFX platform properly). Currently exit() method was added to UIFactory interface which in different implementations cleans up / disposes the used resources. Current version works on Windows but needs to be tested on MAC OS and Linux.
 - Current segment (under the cursor) is highlighted on the vertical and horizontal axis in all modes. When moving the mouse outside of the pathway diagram highlight is removed. 
 - Drag mode was updated and now supports dragging of elements outside of their original segment which is equivalent to changing the biological context of the element. Only Effects and Tests can be dragged since they are the only elements with context. Diagram is redrawn after the dragging is complete to update the link locations with the remaining elements from the diagram.
 - Updated versions of Aromatase Inhibition and Oxidative Stress pathway files is now available. Three AOPS were imported form AOP-Wiki 18,51,64 and merged in a single file. 
 - Pathway Source Code Generator was updated.
 - BugFix: The interface did not allow building of links with the same level of biological organization if the downstream element was placed in different segment and displayed in position to the left of the upstream element. Currently the positions of the segments are compared and if they do not break the upstream workflow the links are created.
 - BugFix: Default placement of new test response mapping was corrected and now uses the slot between the (key) event and the test (if available). The old implementation did always insert the TRM on a new row.
 - BugFix: Coordinates are now assigned by setAll only if the number of coordinates in the current object is the same as the one provided by the parameter.
 - BugFix: Coordinates of Test_InSilico default object were not assigned with the updated DEFAULT_CONTEXT
 - BugFix: PathwaySourceCodeGenerator was modified to work with also with MemoryDS (do no longer assumes that the dataSource is RevisionBasedDS)
 - BugFix: Replace in view now removes the old element from the list of visualized elements
 - BugFix: Pathway viewer was redrawing the currently edited element even when not showing on the screen (e.g. when user is in Edit tab and View tab is not visible)
 - BugFix: HTML export did not override the existing SVG files correctly. The new version deletes the any pre existing file with the same name.
 - BugFix: Shift key was not longer allowing placement of the Tests in CELT mode.
 - BugFix: KeyReleased event was not always triggered when mouse event was generated as well. Current version updates key modifiers on mouse events as well.
 - BugFix: when new AOP is created the ViewUI loaded field was not initialized and trying to refresh the screen (by pressing F5) did hide all content.

       ***** Effectopedia 1.0.75 (r565) Beta Update Log ***** 12 Jun 2017
**********************************************************************************
 - This version introduces the initial implementation of AOP-XML import compatible with the latest 0.9.7. schema. In this import all structured fields form AOP-XML is transferred into Effectopedia and attempt is made for some free HTML fields to be parsed into separate objects (e.g. References). Default values for Key Event biological context are established if not specified in the AOP-XML. 
 - New (key) event meta information was introduced allowing the description of the short name (originating in AOP-Wiki) and event components types. The user interface for Effectopedia header was changed to use the object properties list editor.
 - Context sensitive help was updated to show “no help available” when no help is provided for the current context.
 - BugFix: Searching of keywords and groups for adverse effects was not producing results due to wrong name of the index (without the plural s)
 - BugFix: experimentalEvidenceUI was not updating the functional relationship user interface (fnRelUI) when loading new data. Current version bonds the two interfaces together
 - BugFix: Generation of response response data in the absence of time data was causing an error when trying to transfer the values for time. Current version does not attempt to transfer time data if they are not available.

        ***** Effectopedia 1.0.5 (r548) Beta Update Log ***** 13 Mar 2017
**********************************************************************************
 - When locally stored file version of the centralized database is published or there are one or more updates of the centralized database during user’s editing session merging of the two versions is required. Various merging scenario were tested included adding new AOPs and/or modifying existing ones. As result several changes were introduced. Edit history comparison is now limited to history actions which predate the merging operation. Comparison of edit history of contained objects is now refined and does handle owned objects correctly. When transferring objects from one data source to another the original unique object identifier is copied. All contained objects are also added to the destination indices. Once transferring is complete referrals to the objects are updated using a new method. These changes required refactoring of certain methods of the existing code. Conflict editor needs to be further tested.
 - Last release introduced new internal representation of the pathway elements while keeping the existing file format. Several small changes were made in order for the new representation to support standard re-indexing during loading 
 - BugFix: New elements representation is now included in the standard reload referred objects operations.This bug affected loading of historical versions of the data source. 
 - BugFix: newly introduced elements representation was not added to indices when loading pathway objects.
 - BugFix: Cloned pathway elements did not clone their list of associated pathways (unless default). The condition for default list was removed. 
 - BugFix: First element of newly created pathway (most often chemical initiator) was not added to the pathway elements when created. Several of single element modes were updated and now correctly handle the first added element.
 - BugFix: Default mac address was overridden with the last loaded from an AOP. Current version does the initialization once as before and creates individual copies for each object to load.

        ***** Effectopedia 1.0.3 (r546) Beta Update Log ***** 04 Mar 2017
**********************************************************************************
 - Data source merging capabilities of Effectopedia are undergoing major refactoring. The main use of the merging functionality is in conflict handling and synchronisation of different file versions. This process allows for example locally saved version of the centralized database to be merged back to server repository. Current version allows two arbitrary data sources to be compared and equivalent objects identified based on their unique sourceIDs. In a subsequent step the edit history of the objects is compared and objects are classified as equal, different with compatible edit history (can be auto merged) and different with conflicting changes. Compatible objects are then automatically merged and data source synchronization dialog displayed for the rest. Underlying functionality of the synchronization dialog is implemented but not tested completely. 
- The implementation of historical revisions loading was refactored. The new simplified implementation has been tasted to work with links provided by AOPKB.org (which is currently out of synchronization and refers to old AOP revisions)
- Effectopedia server backend was migrated to Google Cloud platform. Currently the Effectopedia main website, Moodle content management system, file handling API and user database are all running from the new server.   
- The single sign-on authentication mechanism (using Keycloak) was integrated in Effectopedia. All existing user accounts have been transferred to Keycloack. User display names are temporary replaced by the contributors’ e-mails while secure retrieval of display names is developed. 
- Subversion based implementation of the centralized database is in final stages of development and testing. The SVN server is locked before initiating the publishing process, and released lock is released right after the commit action. If an existing lock is found, system waits random interval of time and retry up to 3 times before giving up. User is notified and another cycle or retries can be initiated. Alternatively system can save all changes locally with provisional new identifiers (not confirmed to be unique form the server). The SVN based version of Effectopedia application now checks for provisional versions of the files before loading the normal revision form the local repository. This allow previously uncommitted changes to be published upon server availability. The new data source merging mechanisms are used to detect any conflicts between different revisions. Some additional optimizations were also made: allowing faster loading of Effectopedia if no update from the centralized repository is needed, saving only the modified files when in multi file saving mode. 
- This release introduces the concept of teams which allows currently signed user to make contributions on behalf of a team. By default, the logged user is listed as the first author of the team of contributors. If changes were already made by another team member his/her name will be listed as first author preserving the order of contributions. Currently there is no user interface for choosing the team which user can represent in the current session (by default it will be yourself) and no tools for creating new teams. Current implementation is used internally for retrospectively generating the list of contributors for AOP manually transferred from AOP Wiki. 
- Pathway selection dialog (currently used when saving AOPs as Java files) was updated and now contains a checkbox allowing to toggle the selection of all pathways. 
- The context of the Edit components and other parts of the user interface has been updated to support showing the relevant context sensitive help. Description sections also provide additional context related which allows different context help to be provided depending on the original designation of the description section.
- User interface for Labs was updated. Substance title user interface was modified and now instead of the used data template shows the substance and the lab in which the experiment was conducted. The drop down list of labs is also automatically updated if new lab is added / removed modified in the list of labs.
- Pathway source code generator now has a new repair feature which traverses the downstream links and mappings starting from segment roots and adds all pathway elements which contain current pathway in their list of associated pathways. 
- File format version was updated to 1.03 due to changes in the pathway elements internal representation which now allows standard monitoring of the edit history. While the change is backward compatible with the old format edit history for this list of elements is not existent and can not be recreated. It is advisable all old format files to be submitted to Effectopedia DT for conversion. 
- The source code for generating the EAGMST endorsed AOPs was updated and now reflects the most recent version of the pathways. This included an updated version of Aromatase Inhibition pathways. The new version adds the necessary MATLAB source code to execute the HPG axis model which is still not parametrized.
- One more MATLAB model example OxidativeStrss3 was added for testing models that provide output in time.
- BugFix: Edit history object referrals were unable to load correct Effectopedia Object resulting in errors when loading historical revisions of data source.
- BugFix: All pathway associations were lost if a generic element is changed from one type to another (with pathway building tools) in the cases when more than one AOP was associated with the element.
- BugFix: Default x axis display unit was generating null pointer exception in case data did not have assigned unit along with the descriptor value or missing default descriptor unit. This bug was causing  Proportional and Threshold relationships to fail to display the corresponding function charts. 
- BugFix: The API for rendering structure images does not always return image with requested dimensions. Therefore, the code now checks the output and resizes the image if needed.
- BugFix: The interface for selecting the method to run in the substance data did not initialize correctly if no model is still created.
- BugFix: Data substance in Lab did not initialize correctly (so templates, substance, lab and object properties were not initialized)
- BugFix: Synonym list in the SourceGenerator class was not adding separators between the synonyms
- BugFix: Cloning of aggregation function resulted in not initialized data templates. The fixed version now updates the cloned template.
- BugFix: Rendering of some table headers was updated to work even if there are no data to be displayed.

        ***** Effectopedia 1.0.0 (r503) Beta Update Log ***** 31 Dec 2016
**********************************************************************************
- All changes to effectopedia objects preserve the original object before the change is applied. While the current version handles individual changes correctly multiple changes to the same object might lead to inconsistencies. This new version of the code handles correctly all but one case. In this case an object is modified (e.g. title) and also two of its reference lists (e.g. new pathway is associated with element and new link is made with another element). In this case the edit history contains two historic objects (instead of one) one containing the first two changes (title + pathway reference list) and the second the (title + link reference list). Since both ot those changes are made in the same session the archival object needs to point to the previous version of the title, and the previous state of both lists by replacing the cloned object reference ids with the archival IDs which were created for them.
 - BugFix: Aggregation function was not loading in the key event interfaces even in cases when there are multiple upstream causes which need to be aggregated. Current version loads the aggregation function interface in both cases when data are loaded from file or other data source or created in the user interface.

        ***** Effectopedia 0.9.90 (r501) Beta Update Log ***** 29 Dec 2016
**********************************************************************************
To be refined....

 - The use of ResponseFn in Effect(s) was further developed and tested. Current implementation does not create analytic function in case the number of factors to combine is less then 2. Also AggregationFunction class was optimized to avoid saving the default values for the DataTemplate and the response function and if no user data are supplied the it does save only the default aggregation type.The interface is also updated and do not attempt to load aggregationFunction which should not be initialized.
All generated examples and other pathways now contain update their essentiality summary tables. Normally when a pathway is loaded in the editor these essentiality tables are updated. If element of the pathway does not have corresponding entry in the table (or is at the wrong position) new entry is creared (or assigned at the correct position). All of these changes would result in changes of the output XML file even if no user changes are made. The newly generated Effectopedia files already contain all summary tables in the right order so only user changes are tracked.
 - Multi-file and standard AOPZ Effectopedia files were generated with the new source.
The genric property of the Documented_value was moved in the parent class, and is used now in helper function hasData() which can be used to optimize the object export and store its properties only if there is a value to be stored.
 - The use of ResponseFn in Effect(s) was further developed and tested. Current implementation does not create analytic function in case the number of factors to combine is less then 2. Also AggregationFunction class was optimized to avoid saving the default values for the DataTemplate and the response function and if no user data are supplied the it does save only the default aggregation type.The interface is also updated and do not attempt to load aggregationFunction which should not be initialized.
All generated examples and other pathways now contain update their essentiality summary tables. Normally when a pathway is loaded in the editor these essentiality tables are updated. If element of the pathway does not have corresponding entry in the table (or is at the wrong position) new entry is creared (or assigned at the correct position). All of these changes would result in changes of the output XML file even if no user changes are made. The newly generated Effectopedia files already contain all summary tables in the right order so only user changes are tracked.
 - Multi-file and standard AOPZ Effectopedia files were generated with the new source.
 - The genric property of the Documented_value was moved in the parent class, and is used now in helper function hasData() which can be used to optimize the object export and store its properties only if there is a value to be stored.
 - startNewRevision is wiser now and does not start a new revision if no changes are recorded in the revision history.
 - Updated rev?.zip files containing the centralized database revisions.
 - SourceID now has additional field for the dataSourceID. To avoid problems with the backward compatibility the dataSourceID is now added as attribute to the sourceID file export
DataSource generation function was updated to support XML and AOPZ export depending on the selected defaultFormatFlavour
New attempt (unsuccessfull) to solve the concurrent thread modification exception by introducing synchronised blocks.
 - getIDbyExternalID was modified to search the externalID in live processedIDs first and if not found in archivedProcessedIDs. This behaviour no longer depends on isCreateLive()
 - The revision number array is now updated using startNewReviosion() instead of previous more complex and untested solution.
 - Storing the data source which did not had any changes does not produce new revision number (with empty EditHistory and the same StoredTraces). This allows production of identical multi file structure and content.
Current implementation for loading source traces reqires all live objects to be already loaded. This in uncompressed multi file option is achieved by ordering the found directories at the loading path using the new function makeLiveIndicesFirst. For compressed multi file entries have to be created in specific order of the entries to be processed correctly when loading. Live elements and archive elements are stored / loaded first then edit history and stored traces and finally the aop.xml
Effectopedia now supports handling of data sources from different DataSourceFormats. Currently implemented are the single and multi file XML data sources. The respective changes in the File save and open dialogs were made. Currently the default format flavour is the aopz (which contains single zipped xml representation of the whole database). New flavour aopzm has been added which has the same file extension "aopz" but in the archive objects are stored using the multi file approach.
DataSourceFormat now has isCompatible method which checks if the sourceName supports the format and is in the right flavour. The implementation for XMLFileDS and XMLMultiFileDS is not complete and no XML validation is made. Instead only file extensions are checked for AOP and XML files and for AOPZ files if the zip archive contains single zip entry called pathways.aop or multiple zip entries.
A minor change in XMLMultiFileDS has been introduced when saving local files it now uses the file name as name of the sub directory where the files will be stored.
Method_InSilicoGlobalModel has been modified to accept different model callers. The original implementation maintained a referenceIDs list to all related(in silico) test method. This list has been generalized and now can contain reference to any EffectopediaObject. This allows links to with their response response models also to be added to this list. This change has been noted in the file format version and the new format is now 0.988
 - GlobalModelSelectorUI has one additional button on its toolbar allowing the editing the properties of the currently selected model.
New font scale shortcuts has been introduced as quick alternative to complete options menu which controls all visual aspects of the pathway diagram. The new shortcuts for increasing the font size are "Ctrl"+"+" or "Ctrl"+"=", for decreasing font size "Ctrl"+"-". To reset the font size and object scaling to default use "Ctrl"+"0".
"F5" can now be used to refresh the pathway screen.
Initial implementation of the time-response-response curve derivation based on two time-dose-response families of curves. Current version has not been tested adequately with mixture of dose-response and time-dose-response or with dose-responses only. Data templates of all related ObjectProperties were updated to support time-dose responses. The object property for response responses was also updated to include time as one of the possible descriptors. Time based response response data templates were also added. New DTsGroupedDualYDispalySettings helper class was also introduced to allow time course families of curves in the dual axis chart.
New dialog has been introduced which allows editing of the DataTemplates of a quantitative nonlinear relationship (QuantitativeRelationship_NonlinearUI). The new dialog is triggered by a single click in the Table header (indicated by the little settings icon)
The new dialog has rather complex invoking mechanism since table header renderer does not normally handle events. Single click mouse action is detected similarly to interface modes - where single click handler started as a process but stopped if double click action is detected.
SubstanceData now has a field to maintain the substance reference. There is still no interface available to display or edit this field.

Initial implementation of the time dose response data handling and visualisation. Time dose response data can be used in the substance data interface using the recently introduced templates. A family of curves for each tested concentration is displayed in the chart. Different data series are distinguished by the fill color of the chart series marker. Both tested and reference substance data can be simultaneously displayed. DataTemplate implementation of the data series generation is flexible and the order of the time and dose can be easily reversed allowing to build different chart with x axis as concentration and the family of curves produced for different time points. Current implementation has not been tested thoroughly and XML import and export methods are still not called.
DataSampleValueFactory classes were updated to allow retrieval of information when different pairs belong to different chart series (and series element does not have the same dimensionality as the object property pairs)
Partial implementation of aggregation functions now allows (key) events with multiple upstream causes to have a function that combines their influences to a single output. Current implementation uses analytic expression to define the relationship between all the upstream causes. New interface for the current status of an (key) event and aggregation functions was also implemented. Analytic function interface was modified to hide the chart panel in case of aggregation function. While Aggregation function is integrated in Effect object the source has not been updated to suport loading and storing of the new property. Further testing is also needed for the Aggregation function initialization.
New class Factors was introduced to aid with operations applicable to a list of factors without maintining the list of factors itself. ModifyingFactors is now derivative of the Factors class and maintains a list of ReferenceIDs
New data templates were introduced for time-response and time-dose-response. Time response template can be loaded in the table and chart and axis titles and table headers are updated automatically. Several changes were made to allow data-time response format (and sorting) of the data table. Chart showing a family of curves for a tested chemical (each showing the time course of the response for a different chemical concentration) remains to be implemented. New chartGroup was introduced in DataTemplate to support this expansion.
The file format version was updated to 0.9.875 to acknowledge the creation of the new data templates.
ReferenceIDs now supports listeners for changes of 
the list of referred IDs
Two sets of test examples were created all based on the centralized database. The first is the updated version of Effectopedia?.aopz files and the second is zipped multi file version of the same revisions located in "mf" sub directory in test.

Initial (incomplete) work on EffectopediaObjectTest jUnit test. EffectopediaObjects has been defined as abstract to enforce the definition of addNew method, however instance of EffectopediaObjects class was found to be useful for an index containing EffectopediaObject. Since storage of EffectopediaObject is needed on during test time Indices class has been expanded for that purpose in the body of the EffectopediaObjectTest.
Partial changes were also made for the modifying factors so they can be used for both the newly developed ResponseFunction for (key) events and as modifying factors for (key) event relationships
Complete Test unit for IndexedObject. Indexed object is declared as abstract class with no abstract methods (just to prevent direct instantiation) and most of the test use anonymous instance, however for some of the cloning tests DefaultIndexedObject class has been derived.
Test unit is placed in the same package as the original file to allow access to all protected methods and fields.
Updated copies of Effectopedia?.aopz and multi - file versions of the Effectopedia database.

 - BugFix: Cloning of multi-valued object property caused crash when 0 pairs are present.
 - BugFix: Documented_value did not clone the subproperties like its parent class ValueAndUnit
 - BugFix: DEFAULT_UPSTREAM_CAUSE was part of the description of the analytic function. It seems like a copy paste error but it might have forgotten use???
 - BugFix: Coordinated for Effects did not initialize with the last changes of the default context dimensions (missing the Generation dimension)
 - BugFix: Default Substance object is modified to show different Pure substance title depending on the parent chemical initiator. This lead to different title export in the XML output of the object. The default title is now used for the default XML export.
 - BugFix: Bug introduced in the last revision by not startNewRevision before saving the current changes in the edit history.
 - BugFix: Source traces did not initialize properly the object identifier. Current version does update it from the externalID. Once set the sourceID.ID can not be changed.
 - BugFix: Sorting of the essentiality summary referneces always produced and archived version of the object irrespectively of weather to IDs were changed or not. Current version verifies if the ids need resorting and if yes then changes the ids object
 - BugFix: Default objects are added to all newly created data sources however the processedIDs and processedArchiveIDs were never updated. Two solutions are currently tested FileDS clears the processedArchiveIDs as before but then gets all currenlty loaded in the data source archive objects archiveIndices.getAll(processedArchivedIDs);
The same is done for the live objects. MultiFileDS does use different strategy - it does not clear at all processedIDs and processedArchivedIDs relaying on the newly updated putAll and putDefault implementations which do explicitly call 
liveIndices.getAll(processedIDs);
archiveIndices.getAll(processedArchivedIDs);
 - BugFix: getEffectopediaObjectByExternalID did search in processed objects only when isCreateLive() mode was active. This did cause loading problems for source traces and others. Current fix has not been tested for side effects.
 - BugFix: addToArchive did allow live objects to be added to archive as well. This is no longer possible when in internalLoad mode
 - BugFix: the loading of EditHitory tried to load non-existing attribute and not proceeding with the load if the attribute was not found.
 - BugFix: The title frame of the collapsable titled panel is now considered in the calculations of the optimal size. It was ignored before leading to hiding part of the content when the panels are collapsed.
 - BugFix: Deletion in quantitative nonlinear relatioships when no row is selected caused the loss of table header. Current version does not trigger delete action if there is no selected row;
 - BugFix: AutoSave is assigned now before the execution generateContent()
 - BugFix: Analytic function interface now correctly calculates the component size (including the component title) and one additional row for the table of parameters.
 - BugFix: Chart panel caused null pointer exception in case of non initialized chart. Current version renders blank component in those cases.
 - BugFix: New implementation of multi-thread saving of files now keep track on all publishing threads. To prevent changes of the information while publishing use waitUntilPublished()
 - BugFix: Cloning of multi-valued object property caused crash when 0 pairs are present.
 - BugFix: Documented_value did not clone the subproperties like its parent class ValueAndUnit
 - BugFix: DEFAULT_UPSTREAM_CAUSE was part of the description of the analytic function. It seems like a copy paste error but it might have forgotten use??? 
 - BugFix: Coordinated for Effects did not initialize with the last changes of the default context dimensions (missing the Generation dimension)
- BugFix: Default Substance object is modified to show different Pure substance title depending on the parent chemical initiator. This lead to different title export in the XML output of the object. The default title is now used for the default XML export.

        ***** Effectopedia 0.9.875 (r483) Beta Update Log ***** 30 Nov 2016
**********************************************************************************
 - CLET mode now shows a confirmation dialog if user is about to break the current building sequence. By default the tool can be used from upstream to downstream (left to right). If the new element is placed upstream from the last one the Confirmation dialog shows. The dialog also has a check box "Do not ask me again" which allows user to control the behavior of the dialog for the current session.
 - Element editor has been updated and now offers selection panel for existing tests. Both test and effect dialogs and panels have been changed to constrain the lists only to the elements of the same time (e.g. if the element is MIE the list contain only MIEs). 
 - BugFix: Weigh of Evidences for key event relationships now contains use HTML option and button to switch between the HTML code and rendered result. 
 - BugFix: The Link tool did allow making connections between effects/key events and tests, test response mappings and other links. The updated interface now allows only Initiators and effects to be connected with a link.
 - BugFix: If no suggestions are available the existing effects/tests default editor is loaded
 - BugFix: Replace with existing element now works for tests and effects when using the element editor
 - BugFix: Define new test or effect now loads the default element editor (instead of reloading the selection dialog)


        ***** Effectopedia 0.9.87 (r479) Beta Update Log ***** 20 Nov 2016
**********************************************************************************
 - Object property lists were updated and now support all type of properties categorical, single/multi-valued, documented or not, with sub properties or without. The new interface allows editing of object properties of any kind. The definition of the object properties type could be done with the refined Object Property Type dialog which now introduces editing capabilities for categorical properties, different display name of the property and the descriptors list title. Collapsible titled panel now displays the list of property values as separate rows in the title. These rows allow quick editing of the parameter values. Advanced editing could be perfomed in the body of the panel where the values of descriptors, ranges and sub properties can be modified. All new interfaces need additional testing. The new object property lists are currently used in the Global model interface as editors for the model parameters and metadata. 
 - New generated AOP - ModelTester was added. This AOP contains for in-silico models written in MATLAB, Java and R. The first three are linear and the last R model is dose response model. All models include meta data and model parameter descriptions. Each of the four tests which refer to one of the global models contain measured and nominal data for one compound so all models are ready to execute without any additional data entry.
 - SystemConsole tab now remains hidden until the first message in the error stream appears. Exceptions that are handled now are reported as part of the normal console stream.
 - Some spelling errors were fixed (e.g. Leads in the title of Links)
 - Aromatase inhibition generated pathway was updated and now includes all descriptions form AOP-Wiki along with the associated test methods. Sample in-silico model was also introduced in the place where HPG axis model will be developed. SubstanceData were added for Fadrozole and used as a test case for the sample model
 - New expand/collapse all panels are available now for any list of CollapsableTitledPanel elements. The new functionality is implemented as a TitledBorder and provides a button for this actions. 
 - BugFix: Sub properties were not cloned properly
 - BugFix: Newly loaded editor are now auto scrolling the interface so the bound rectangle of the header is visible. 
 - BugFix: The console text area resizes properly and displays scroll bars if necessary 
 - BugFix: Essentiality description is now resorted in the order of pathway elements. The new sort method is called every as part of updateEssentiality (called when the pathway description is loaded in the element editor) 
 - BugFix: SegmentRoots were not correctly initialized when the AOP element has incoming connections all belonging to a different pathway. Now the incoming association is considered only if it is part of the current pathway. 
 - BugFix: CharTitle did crash when null title was passed as argument for the title.


        ***** Effectopedia 0.9.86 (r473) Beta Update Log ***** 05 Oct 2016
**********************************************************************************
- New user interface was added to all link editors which allows the selection of existing Initiators and Effects as modifying factors. Future versions of Effetopedia will support more general modifying factor definitions allowing the use of environmental parameters like temperature, different types of radiation, pressure, gravitation and so on. Enzyme system which is currently used in the substance to substance links will be also converted to a modifying factor.
- Several new elements have been introduced to the Object Property Type definition. One of the these elements is the category of the property. The category will be used for filtering properties in their dedicated editors e.g. when categorizing properties of structures and substances PubChem categories will be used. This allows separation of all identification information, calculated properties, measured in different editor panels.
 - New categorical type of property has been also defined - this property does not maintain a value but can be used as a hierarchal level of the category definitions. Display Name and Descriptors Captions are two new elements of the object property type which control the visualization of the type.
 - The default behaviour of the pathway wizard mode was changed now instead of creating new AOP each time the wizard is used it does use the last created AOP in the view. This allows all tools to work on the same AOP or small network. A separate AOP can still be created using the Ctrl key
 - BugFix: Pathway wizard mode now creates the MIE on molecular instead on organelle level of biological organization.


        ***** Effectopedia 0.9.85 (r467) Beta Update Log ***** 15 Sep 2016
**********************************************************************************
 - KER (Links between effects) interface was updated and now allows the use of in-silico models as support evidences. These models have different set of input parameters compared to Dose Response models. While DR models use only chemical concentrations as input RR models include the state of the upstream element of the link (response in case of effect or concentration in case of chemical) and list of modifying factors. Modifying factors is defined as list of general Effectopedia objects that can be key events / effects / biological perturbations. Future versions will also provide interface allowing more general factors definition such as temperature, radiation, etc.  The modifying factors interface is still not implemented and execution of in-silico RR models is not possible.
 - Local model settings user interface now allows the selection of the associated global model in a drop down list. Earlier versions used the first item from the list of associated global models.
 - BugFix: Address bar no longer hides the command toolbar when the file name is too long.
 - BugFix: The pathway viewer user interface was not initialized properly to update the newly introduced help context and caused null pointer exception on every mouse click in the interface modes
 - BugFix: Pathway editor modes now handle the case where no previous element is available (in the reset state of the editor mode) while determining the context for the help system.  
 - BugFix: Source generator did not escape the " symbol from the descriptions which was leading to non functional Java code.


        ***** Effectopedia 0.9.80 (r461) Beta Update Log ***** 29 Aug 2016
**********************************************************************************
 - First draft version of the Context Help for Pathway Viewer/Editor is now available. Context sensitive help uses information of the currently set interface mode along with the position of the mouse on the screen to provide relevant information about the available actions and expected results. Context Help for the Welcome page has been updated as well. 
 - NewLink interface mode was improved to show the arc between the link and the first connected element, even before the link type is determined and link Effectopedia object created.
 - Test console is now available by default in the EffectopediaT version of the program.
 - BugFix: The context for CLET mode was not estimated correctly when mouse cursor was positioned over empty region.
 - BugFix: The insertion of tests in CLET mode was fixed allowing tests to be added in the same segment as the currently selected event with a single click (while holding Shift key).
 - BugFix: Type cycler was not working for Tests in CLET mode.
 - BugFix: The interface for pathway header and footer did not provide context for the help system which resulted in no help available for vertical and horizontal axis.
 - BugFix: MacOS creates additional files in each directory created by a program which were not processed correctly when loading the XML file in the new multi file organisation. Current version ignores hidden files and files with any other extension than .xml
 - BugFix: Ctrl Delete did not work on MacOS and was replaced with Ctrl Mac Delete key (equivalent to Backspace in PC). New OS detection features were added to Configuration class.
 - BugFix: Disassociation of Tests did not "unmap" them form the associated (key) event which caused them to reappear in the pathway. The current release umaps them correctly and they are no longer associated with the (key) events.
 - BugFix: ViewOptionsToolbarUI did not add the motion listeners to the toolbar buttons which resulted in them providing no individual help context.


        ***** Effectopedia 0.9.77 (r458) Beta Update Log ***** 16 Aug 2016
**********************************************************************************
Several internal changes and additions are introduced with this version which will be utilized in the architectural development of Effectopedia. Among these changes are:
- Initial implementation of multi-file storage of Effectopedia content. Four different data patterns (RUSSIAN_DOLL,SALAMI_SLICE, VENETIAN_BLIND, GARDEN_OF_EDEN) were introduced. (Refer to http://www.oracle.com/technetwork/java/design-patterns-142138.html to learn more about the differences between these patterns). The current single file format is using RUSSIAN_DOLL data pattern while the newly introduced multi-file format uses VENETIAN_BLIND data pattern. The new format supports local and remote compressed content (with the same default extension aopz) and local uncompressed directory structure. Files inside the archive and in the local directory structure all use xml extension. The new format is only partially tested and is not officially supported by the user interface.  
 - The new data pattern affects the storage of IDs objects and Pathway elements which in RUSSINA_DOLL are nested and in VENITIAN_BLIND are just referred (and stored in separate file). Loading of referred objects is done in two stages - first only the ExternalIDs are loaded a new instance class (which is not added as live object nor reported in containedIDs). Once the loading of all objects is complete then the temporary instances are replaced by the true pathway elements using their externalIDs. This approach was taken to avoid any changes to the current format implementation. FileDS was refactured to allow easier extension MultiFileDS.
EditHistory now also supports new methods for loading and storing just a single revision instead of the full revision history. SourceTraces was also modified to allow storing the source traces of a particular revision.
 - Effectopedia now supports new “hidden” feature which allows currently loaded pathway to be saved in a form of Java source which can be used to generate it. The generated source code currently does not cover all fields and objects but rather recreates the structure of the pathway, description sections and references for all elements. Quantitative information, link nature, methods, resources and models are not transferred in the current version.
- The new Java source generation functionality is accessible trough the standard save dialog by setting the file extension of the saved file to “.java”. The *.java filter is also available in the save dialog if the "Ctrl" is held during clicking of Save button. New Pathway Selection Dialog was added to allow the selection of one or more pathway(s) to save (all in individual files).
- Sub properties of an object property are no longer associated with the property itself but with the individual values. This change allows a sub properties form the same type to be associated with each value pair. Matlab and R models executors does not support the new feature. Non of the affected units are tested.
 - EffectopediaT.jar and EffectopediaT.exe now have the System Console tab which redirects the system console. Error messages can be used to accompany the bug reports. 
- New "Exception Handled!" error message was added to several exceptions that are safely handled. Complete annotation of all exceptions remains to be done.
 - New Debug server was introduced to help the development process without interrupting the training and centralized data sources.
 - BugFix: Edit interface did not allow starting a new selection in an occupied LayoutObject. This is no longer required.
 - BugFix: Pathway viewer user interface did not always maintain the focus which caused delete actions to be unsuccessful.
 - BugFix: Adding new execution request, or calculating all current requests did not immediately update the status of calculate button.
 - BugFix: Edith History internal method (geLastExternalID()) was fixed to consider the number of default effectopedia objects in order to provide the right ExternalID
 - BugFix: Some of the saved externalIDs  in SourceTrace were not initialized. Current version updates the ExternalID before storing but requires the original object defined by the trace to have valid externalID.
 - BugFix: Model Presets were not cloned for the Method_InSilicoGlobalModel leading to loss of the stored presets when publishing.
 - BugFix: Entering of non numerical value in numerical fields (DataValues_Double, DataValues_Float,DataValues_Integer,DataValues_Long) caused unhandled exception and problems with the rendering of the user interface. Current version ignores all non-numerical changes to the value.
 - BugFix: Cloned ObjectProperties maintained the externalID of the parent object.
 - DefaultClassDisplayNames was depreciated and all of its functions were transferred to TraceableClasses. All affected classes were modified to refer to TraceableClasses.REGISTERED instead of DefaultClassDisplayNames.DISPLAYNAMES
 - NMDAR example was updated with the new default position of the Weight of Evidences (WoE) structured description section.
EssentailityDescription also uses the now relative index of the WoE section. More general solution with indexing and geting description sections by default type need to be added in the future
- BugFix: Default description sections when loaded from a file were not the same object instances as the the default objects in the EffectopediaObject collection. The fix implemented to replace the default objects in the EffectopediaObject collection with the clone if not it is not the same instance but have the same identifiers.
 - New description section was added to (key) event relationship description which corresponds to the How this KE works in the Handbook. Several default titles were also changed.


        ***** Effectopedia 0.9.751 (r445) Beta Update Log ***** 25 Jul 2016
**********************************************************************************
 - New Disassociation Dialog was introduced.The new Disassociation dialog allows upstream and or downstream chain of events to be disassociated from a selected pathway. The new feature helps easy splitting of pathways that were drawn together but have more than one Adverse Outcome or MIE. The automatic association and disassociation methods were updated to work for the associated test methods and mappings as well.
 - Chemical structure, substance and constituent interfaces were updated to support simpler layout which hides some of the information when used as side panel editors with limited space.
 - BugFix: Some of the changes of the key pressed and released status were not handled properly causing unsuccessful Delete attempts.
 - BugFix: The link between chemical structure and MIE did not support the double click navigation using the titles of the chemical or MIE. The link between two chemical structures representing ADME transformations was also fixed and now supports double click navigation.
 - BugFix: By default the CLET tool creates structure to MIE link as a first step after insertion of a chemical, however when the link is replaced by structure to structure link (for connecting two chemicals instead) the original link was just hidden but not disconnected.
 - BugFix: Chemical editor interfaces in the ADME Transformation link and structure to MIE links were not embedded in a scroll pane which did not allow for the content growth and caused problems in rendering larger content.
 - BugFix: The model presets did not initialize correctly the input model parameters with the newly introduced type for measured and nominal concentration. Instad the old dose response type was used causing problems with using the data.
 - BugFix: Updated chemical structure interface did not initialize its size properly when wrong type of object is loaded.
 - BugFix: The link creation mode did not propagate the associations with existing pathways.
 - BugFix: The link creation mode did not implement the default double click behavior (loading the suitable editor for the link element).
 - BugFix: Running second R model after the first one has already been successfully executed did not change the directory to the new one (after checking that the R engine is alive) and as a result showed the output of the first R model. The directory is now updated every time prior to the execution of the model and multiple models can be executed sequentially in the same R session.


        ***** Effectopedia 0.9.75 (r442) Beta Update Log ***** 17 Jul 2016
**********************************************************************************
 - The first release of Effectopedia allowing building and execution of in-silico models written in R, Matlab or Java. Current implementation allows models to be used for calculation of dose response curves following specific chemical exposure. Soon to follow releases will provide interface to build response  response models, transformation functions and ADME models. To execute the models in real time on the local machine additional software requirements need to be met. Alternatively user can request an execution and publish their request allowing the authors or anyone with software requirements met to execute the model and publish the simulation results. Original requester then can load the results along with the feedback from the modeler. 
 - The modeling interface has two separate layers one dedicated for users and the other for model builders. Model builders can use the in-silico global model interface to define: the short summary of model description which is displayed to the users; mathematical description of the model (including MathML formulas); description of model parameters, their default values and normal ranges; source code of the model along with additional resources needed for its execution. The model also contains a system requirements and metadata information which however does not yet have a visualization / editing interface. Model users can use the in-silico model interface where model predictions can be made for individual substances. The interface has summary of model descriptions (and link to the associated global model) and the list of parameters of the model in form of sliders. The sliders are bound by the normal ranges of values of the parameters and have the default value specified from the model author. Users can modify the value of the parameters and if the required software to execute it is installed to see the results in real time (if the model execution time permits). Otherwise they can submit an execution request with the desired combination of parameters to the model builders along with optional description of the selected combination and read the response of the modeler once the calculation is published. 
 - New user interface for editing resources has been added as part of the Global in-silico model interface. The new interface has tabs representing different resources which can be added and removed. The resource titles can be edited by double clicking on the tab header. 
 - As part of the in-silico model substance data new data type has been introduced which represents nominal and measured chemical concentration (optionally in time). This parameter is used as input for all in-silico models. 
 - R and Matlab models source code consists of at least two files. An initialization file, entirely generated from Effectopedia - which transforms the model parameter and input data and parameters into R  lists / Matlab structures and also defines the structure of the output. The second file is represented as Resourse object and contains the source code of the model.
 - Java models consist of minimum one file which implements the interface ExecutableModel. This file is compiled once and then executed with the different model parameters and input to provide predictions. Dislike Matlab and R the Java compilation is performed directly in the memory without need of intermediate file. The successful compilation of the classes that import Effectopedia definitions requires effectopedia.jar to be added to the classPath. Automatic detection of the JDK is not completely tested and is known to have problems in some configurations.
 - The installation requirements for the different supported languages will be summarized in a separate read me file, once experience is gathered for multiple operating systems and environments. Independent of the operating system R models require local R installation and rJava package installation. Matlab models does require Matalb installation on the local machine. Java models require JDK 1.7 or later to be installed on the local machine. 
 - Current release also has updated the chemical structure, substance and constituent interfaces allowing users to add multiple substances to a single structure with potentially different compositions. The default substance for all chemicals is automatically generated and contains single constituent (the substance itself) which makes 100% of the composition. When structure name or smiles is changed the modification is propagated to the substance name and first element of the composition (the only one in pure substances, and main ingredient in other substances).
 - Object property is the underlying universal data structure which is used to represent experimental data, model parameters, and various other data objects. A new universal editor of object property types (defining the structure of the data) was introduced along with the modeling capabilities where it is used for definition of model parameters. The dialog allows the creation of hierarchical property types. 
 - The default dose response data structure now contains time similar to time course data structure. This change will allow future implementation of dose-time-response family of curves. The change has been made backward compatible with the older version of the file format. 
 - Number of replicates has been added to all default dose response data templates as a response from the feedback of the beta testing.
 - Effectopedia start screen logo has been updated and now features OECD.
 - New fading feature was added to the chart component. It allows all previous data series to fade with specific speed before they are removed from the visible series.
 - To facilitate future OSGI integration the modeling framework has been divided into core.modelling package - which contains all interfaces and abstract implementations, and language specific implementations in their executor.language packages. The two main interfaces are ModelExecutor and ExecutableModel. ModelExecutors initialize the execution environment translate and prepare the input data. ExecutableModel interface represent the model which can be executed with different parameters. Both can implement ExecutionProgressUpdater to provide a feedback of the initialization/execution
 - Two of the generated AOPs were updated. Aromatase Inhibition AOP now has the OECD project No and status as well as some other information from AOP-Wiki.
 - New generated pathway was added "Chronic binding of antagonist to N-methyl-D-aspartate receptors (NMDARs) during brain development induces impairment of learning and memory abilities" it does partially cover the information available in the AOP-Wiki for comparative purposes. This example of sets essentiality of links and key events as well as some other properties (LinkType, pathway status, uids, ...) for the first time in any example.
 - Bug: Tootltips rendering for the first time causes major slowdown and freeze of the event swing thread. No fix or workaround is still available.
 - BugFix:  Chemical user interface did not allow scrolling and had problems representing the content when more substances are added. Current version has enclosing scroll pane and can grow with the size of the content.
 - BugFix: Vertical chart axis title did not redraw consistently. Current version also uses optimized routine for 90 degrees rotation.
 - BugFix: Existing Method dialog did not allow choosing Method_InSilicoGlobalModel from the list of existing ones. The new object class support has been added. (There is a susspission that the same bug was fixed before but older version of the code did override the fix)
 - BugFix: RealSlider was generating exceptions and not rendering the slider when Null ranges or value parameters were provided for initialization. The new release adds default ranges and value.
 - BugFix: RModelExecutor now handles the potential problems with loading of jri.dll and no longer closes down the whole Effectopedia application if the library is not successfully linked. R models require rJava package to be installed in R and jri.dll (in Windows) to be available in the R bin directory. R models use the internal console for displaying R messages and output. Error handling is not completely implemented yet.
 - BugFix: InSilicoTestUI did not perform the initialization however scrolling to the top of the interface is still not performed due to the delayed load of the JavaFx component.
 - BugFix: Default list of description sections of the Link_EffectToEffect was using the default for Structure to Structure link.
 - BugFix: The newly introduced Taxonomical Aplicability was not loaded from a data source. The modification already existed in the code but somehow got overwritten.


        ***** Effectopedia 0.9.721 (r425) Beta Update Log ***** 08 Mar 2016
**********************************************************************************
 - BugFix: The recently renamed Biologcal Taxonomy to Taxonomical Aplicability was not recognised wehn reading from a data source and subsequently not saved or published. The change has been already made but lost in some of the source synchronisations. 


        ***** Effectopedia 0.9.72 (r424) Beta Update Log ***** 07 Mar 2016
**********************************************************************************
 - Datasource merging problems were partially fixed. Any Effectopedia data source (with an exception of centralized database itself and its copies) can be published and its content merged with the centralized database. If the data source is already merged with the centralized database then synchronization analysis has to be performed in order to determine which elements have been added / modified. This analysis has been implemented in the past but require further testing before public release.
 - BugFix: Two of the default reference classes describing the list of Global models and the list of associated Studies of a test method were not initiated with default ids. This had multiple implications for internal consistency. 
 - BugFix: Publishing an external datasource is now possible even in the case no pathway is loaded in the pathway viewer. As in the case of visble pathway the full content of the file is published (not only currently loaded pathway)
 - The file format version was updated to  0.9.72 incorporating all the changes and bug fixes. 
 - BugFix: Multiple changes were made ensure complete cloning of Effectopedia objects


        ***** Effectopedia 0.9.71 (r422) Beta Update Log ***** 03 Mar 2016
**********************************************************************************
 - The dedicated editors for all visually represented pathway elements (Effects, Links, Tests, Test Response Mappings) and the Pathway editor were updated to reposition to the top when loading a new object. The old version was scrolling down to unpredictable position hiding the title of the element. 
 - The size of the element editor interfaces was optimized to accommodate the width of the vertical scroll bar if visible. This prevents the appearance of horizontal scroll bar and provides cleaner interface.
 - BugFix: The list of available chemical structures was empty after the first appearance of Existing Chemical Dialog. The list is now updated on every loading and contains the full list of available chemical structures. 
 - BugFix: Adding substance data for newly created test did fail due to uninitialized parenthood of the substances list.
 - Merging DataSources was temporary disabled due to one or more unidentified problems making parts the centralized database file unreadable after publishing.


        ***** Effectopedia 0.9.70 (r420) Beta Update Log ***** 29 Feb 2016
**********************************************************************************
 - First Beta release of Effectopedia. Effectopedia beta releases will be used to identify and remove problems related with the recently introduced and existing features. Special focus for this first beta release will be the handling (addition, removal, editing, storing and loading) of quantitative data: 
   - Dose response curves for individual tested chemical substance and optional reference chemical substance
   - Response-response curves using linear, threshold or experimental nonlinear data
   - Derivation of a response-response curves using dose-response data for the two (key) events on both sides of the relationship. Current version can derive only nonlinear response-response curve and does not handle statistical errors
   - Temporal concordance for two (key) events on both sides of the relationship. 
   - Transformation functions and transformation sets used to convert the output of the test system to equivalent in-vivo treatment and response.
 - Effectopedia now supports a test server. Two different releases Effectopedia.jar and effectopediaT.jar are available for downloading one using the production database the other - test database. Additional warnings have been added on publishing.


        ***** Effectopedia 0.9.64 (r418) Alpha Update Log ***** 28 Feb 2016
**********************************************************************************
 - The new version 0.9.64 introduces Test Response Mapping (TRM) user interface. Test response mapping captures all mathematical transformations which need to be made in order to interpret the output of a test assay in in-vivo settings. Multiple transformation function sets can be defined converting the measured test response to in-vivo response of equivalent concentration of the chemical at different target site of interaction. Target site was also indexed and will be used as a searchable properly to find all test methods which can be mapped to the same target site (usually corresponding to certain MIE). Different transformation sets can be also based on different assumptions, function choices and or applicability domains, etc. To capture all of these properties the transformation set interface has two description sections summarizing the Biological context comparative analysis and the Applicability domain, and a list of transformation functions. The list can contain as many transformation functions as needed and can be also empty in which case no transformation is made.
 - The user interface of the transformation function, allows definition and evaluation of user defined expression. The following functions are currently supported: 
NOT(expression)	Boolean negation, 1 (means true) if the expression is not zero
RANDOM()	Produces a random number between 0 and 1
MIN(e1,e2)	Returns the smaller of both expressions
MAX(e1,e2)	Returns the bigger of both expressions
ABS(expression)	Returns the absolute (non-negative) value of the expression
ROUND(expression,precision)	Rounds a value to a certain number of digits, uses the current rounding mode
LOG(expression)	Returns the natural logarithm (base e) of an expression
LOG10(expression)	Returns the logarithm (base 10) of an expression
EXP(expression)	Returns e to a power of an expression
SQRT(expression)	Returns the square root of an expression
SIN(expression)	Returns the trigonometric sine of an angle (in degrees)
COS(expression)	Returns the trigonometric cosine of an angle (in degrees)
TAN(expression)	Returns the trigonometric tangens of an angle (in degrees)
SINH(expression)	Returns the hyperbolic sine of a value
COSH(expression)	Returns the hyperbolic cosine of a value
TANH(expression)	Returns the hyperbolic tangens of a value
RAD(expression)	Converts an angle measured in degrees to an approximately equivalent angle measured in radians
DEG(expression)	Converts an angle measured in radians to an approximately equivalent angle measured in degrees
IF(Boolean expression, expression 1, expression 2)	conditional expression returning expression 1 if the Boolean expression is true and expression 2 otherwise. 

Boolean operators:
=	Equals
==	Equals
!=	Not equals
<>	Not equals
<	Less than
<=	Less than or equal to
>	Greater than
>=	Greater than or equal to
&&	Boolean and
||	Boolean or

and mathematical operations: 
Mathematical Operators
Operator	Description
+	Additive operator
	Subtraction operator
*	Multiplication operator
/	Division operator
%	Remainder operator (Modulo)
^	Power operator
Transformation functions are executed in the order of definition and modify the original data or the output of previously applied functions. Each function has a scope and transforms only a subset of the variables - for examples Treatment scope modifies chemical concentration (mean and raw data), Response  modifies mean, median, minimal, maximal and raw response data. 
 - Experimental support evidences interface was updated to handle the choice of Transformation Set and allow generation of response - response with or without transformation.
 - The user interface for the analytic function description (also used in the transformation function) now provides additional column for parameter description. This change need to be tested with and without uncertainty columns
 - Graphical representation of the TestResponseMapping is now reduced to two symbols: ? and f for undefined and defined set of transformation functions.
 - Several more editors now respond to double clicking on the title and loading the dedicated editor for the object. 
 - BugFix: Important for Mac OS users! Inconsistency of Java runtime environment on Mac (missing constant declaration, describing the multi-click interval) caused major problems in the use of the pathway editor by generating exceptions on each mouse click. Default interval is now assigned in case the variable is not defined and all interface modes seem to function normally.
 - BugFix: Pasting data in the nonlinear response  response tables did not paste the last raw of data  in the new version the problem was fixed
 - PartialFix: Merging file to the centalizedDB did cause corruption of the cenralizedDB and inability to load it on restart. Several changes have been made which reduced the corruption of the centralizedDB (now it is loading) but not all pathway components (i.e quantitative relationships) load normaly.Some of these changes include:
   - (Technical details) EffectopediaObject.cloneFieldsTo(EffectopediaObject clone) was modified to add the clone to the idMAP in case CLONEIDs==false
   - (Technical details) IDs getContainedIDs now calls recursively the getContainedIDs of the nested objects ( dislike to the parent method which does put the ids only to the parent referred objects and not their content 
   - (Technical details) DescriptionSection_Structured.process(BatchProcessor batch) was also added processing the associated structured content if possible
   - (Technical details) Links now clone their quantitativeRelationships and temporalConcordances 
   - (Technical details) Pathways now clone their groups, uids, statuses 
   - (Technical details) Test clone their substanceDataIDs 
   - (Technical details) Test_InSilico overrides the standard update methods to include globalModelIDs
   - (Technical details) DataSource.autoExternalID is still flagging an error for Assigining externalID for an object which is not indexed in the data set by the time of assigning
 - The addition of DefaultObjects handling TransformationSets lead to introduction of a new version of the file format 0.9.64 which should be also backward compatible with 0.9.61
 - BugFix: getDisplayValue was adding an extra blank space after the value with no apparent need. 
 - BugFix: ObjectPropertyMultivalued was modified to handle the case when multiple entries format has been used but no data recorder (count=0)


        ***** Effectopedia 0.9.63 (r417) Alpha Update Log ***** 22 Feb 2016
**********************************************************************************
 - (Key) even relationship (the link between two effects in the original terminology) editor now supports the definition of multiple quantitative relationships of the same nature. This allows response  response curves and analytic models derived from different information sources and or tested substances to be simultaneously stored and compared.
 - Quantitative relationship editing panel was split into three sections. The first section captures the nonlinear or analytic response-response curve available in the previous version of the interface. The next two sections are available in a collapsible panel titled Support Evidences. Two types of supporting evidences are currently planned: experimental data and in silico models. This release implements only the experimental data support evidences.
 - Experimental data support evidences interface initially shows a diagram allowing the user to define the origin and transformations of the data used for deriving the response response curve. Upstream and downstream (key) events are automatically filled in the diagram. The user then can pick from a list of available tests the method used to measure each of the (key) events. Once test method is selected the tested substance can be selected from the respective lists below the tests. Once the tested substance data is selected for both test methods a new panel appears showing the two (key) events in a single chart with common x axis and dual y axis. This chart is designed to show the transformed test data using the designated transformation functions / test response mappings. Current version however does not use transformation and shows the test data for both (key) events without any transformation. 
 - Current version also allows generation of a response-response curve in the simplest possible case  when mapping only the existing measurements of the upstream (key) event / effect to the downstream (key) event/ effect (no interpolation) for the same chemical concentration. Future versions could allow data interpolation and also fit the data into different analytic models. Statistical errors are also not computed.
 - The interface for editing nonlinear dose response curves was supplemented with two fields allowing editing of a description (notes). The new feature is availble for both: dose response or response-response curves.
 - Temporal Concordance was included in the link description allowing users to add data for two time courses - one for the upstream element of the link and one for the downstream. All relevant interface (including dual axis capabilities in the chart component) for handling the data was also implemented. Currently it is used only in (key) event relationships, but will be potentially added to the all types of links.
 - The new file format version 0.9.63 was introduced capturing all the changes in the default objects (describing time series and evidence supported quantitative relationships). It is backward compatible with the last 0.9.62 version
 - Small cosmetic changes were made into EffectopediaUI and AddressBarUI to allow the display of very long title of a datasource without hiding the command toolbar buttons.
 - EstrogenBinding qAOP chemical information was updated and files regenerated.
 - Several refinements were made with respect to the editing of to the analytic functional relationships.
 - PathwayHeader was slightly optimized to scale better ecpecially when shown in the element editor where the width of the panel is quite small.
 - BugFix: Test_InLab did have a bug using clone.getParent() as paret of the cloned referenceIDs instead of the clone itself
 - BugFix: Test interface mode did not react to double clicking on the tests (which for all other elements brings the dedicated editor for the selected component)
 - BugFix: Some default objects clones in a secondary loaded dataSource had dataSource property pointing to the first loaded dataSource (effectopedia.org...). This caused problems with storing the essentiality descriptions of pathways and potentially many other problems.
 - BugFix: UpdateParenhood of the Pathway method was not using the correct dataSource when creating clones of default objects causing the problem described above.
 - BugFix: PathwayElements remained generic after assigning subobjects referenced by IDs (e.g. Test after adding new substance data). beforeUpdate was overridden to handle this case however does not completely cover any other scenario for modifying the generic status.
 - BugFix: ObjectProperties were using the same types object instance (the default) which caused problems when loading custom types by modifying the default. ObjectProperties now use clones of the types containers.
Default description section title was changed to "Definition" instead of abstract.
 - BugFix: New tested substances were added without parent test.
 - BugFix: New tests added to a pathway were not associated with the pathway
 - Bug Fix: Default object properties containing dose response data were not update to the latest Types which were initialized later in the DefaultEffectopediaObject code.

        ***** Effectopedia 0.9.62 (r411) Alpha Update Log ***** 27 Jan 2016
**********************************************************************************
Multiple changes and additions were made since last public release of version 0.9.46 the most significant of which are described below. Details can be obtained from the SVN release 338-411

              *************** User interface changes ***************
 *********************************************************************************

    -------- Harmonisation with the OECD Guidance and terminology -------------   
 ---------------------------------------------------------------------------------
The basic building block of AOPs: effects and links are now referred as (key) events and (key) event relationships, respectively. Since Link is broader concept it is still used to connect chemical structures with Molecular Initiating Events (MIE)s and two chemicals when representing absorption, distribution, metabolism, and excretion (ADME) processes. Effectopedia encourages linking of existing and creation of new and description of non-key events (e.g. biomarkers) as part of the AOP description. Since events can be key in some pathways and non-key in others the key term is shown in brackets. 
Below are listed some of the harmonisation related changes 
 - Introduction of  LinkType  which could have one of three possible values Unknown, Direct and Indirect. The quantitative nature of relationship is now represented in the field Link Nature
 - (Key) event Relationship Weight of Evidences is a structured description section which provides a field with four possible values  undefined, weak, moderate and strong to summarise the weight of available evidences. The evidences can be further described in the body of the section by describing the biological plausibility, empirical support of linkage and uncertainties or inconsistencies. More details of the empirical support and uncertainties can be provided in the explicit elements (tests, transformation functions (test response mappings), measured data with statistical errors from multiple sources)
 - Support of Essentiality of (Key) Events is now introduced as structured description section of an AOP element. Each event included in the pathway is listed as expandable structured description section.  The essentiality of the key events can be categorised as undefined, weak, moderate and strong. A separate key word will be proposed for non-key events e.g. non-essential. 
 - AOP status free text field was introduced as part of AOP properties
 - A comma separated list of pathway identifiers was also introduced as part of AOP properties. The OECD Project Number can be listed in this field. 
 - Several default description sections were added to different elements. E.g. Quantitative considerations, Applicability of the AOP, Considerations for Potential Application in the pathway description,  Measurement and Detection section in the (key) events, etc. 


    ---------------  Response  response editing interface --------------------
 ---------------------------------------------------------------------------------
Response-response editing interface is now available in the (Key) Event Relationship (the link between two events). The interface allows the editing of Proportional, Threshold and data based Response-Response curves. New more universal Analytic function interface is under development which will allow the definition of wide variety of analytic functions. Also categorical response  response curve will be also added for the cases where no continuous information is available. All data interfaces allow definition statistical errors (available by default are: standard deviation, standard error and 95% confidence interval).  In case of analytic function the statistical error need to be provided using the same function type as the relationship. 


    -------------------  Dose  Response editing interface --------------------   
 ---------------------------------------------------------------------------------
Dose  response editing interface is now available in the Link between Chemical Structure and MIE, as well as part of summary information on tested substances in Test definition. Dose response in the Test definition can also include the data measured for a reference substance. All dependencies are shown in the embedded chart component along with error bars and areas. Appearance of the charts can be customized and saved as part of the description. 


    --------------------  Chemical substance interface  ----------------------
 ---------------------------------------------------------------------------------
Major changes of the chemical structure interface were made with the introduction of substances. While the chemical structure elements represent an abstract notion of chemical a substance represents a physical entity which can be associated with specific supplier or manufacturer. Therefore a single chemical structure can correspond to one or more physical substances. The substances themselves can consist of constituents. Each constituent refers to a specific structure and its typical and actual percent of the mix mass. Each element of the physical mix can be marked as constituent or impurity. Substances can have their own list of identifiers and properties. The new substance interface is embedded in Chemical Structure interface in a collapsible panel


    ------------  Element editor in the Pathway View  ------------------------
 ---------------------------------------------------------------------------------
New element editor is now available in the main pathway viewer available under View tab from the main interface. The new element editor allows users when in edit mode to click on any element of a pathway and load its dedicated editor. When clicking outside of any element the AOP editor is loaded providing overview of the whole pathway. Normal full screen editor is still available with double clicking on the representing visual element (or its title in any editor interface)


    ---------------------  Remote description sections  ----------------------
 ---------------------------------------------------------------------------------
Description sections now can display remote web content not managed in Effectopedia. Two initial sources for remote content were allowed (white listed) Wikipedia and AOP-Wiki. The Wikipedia based description section allows embedding a related Wikipedia pages in the document description. Similarly information from AOP-Wiki can be embedded in Effectopedia. The pages AOP-Wiki content can be directly edited from Effectopedia interface using the normal editing capabilities of AOP-Wiki. 


    ----------------------  Global in-silico models  -------------------------
 ---------------------------------------------------------------------------------
Similarly to Studies which can consist of several lab based experimental assays and tests, several in-silico models can refer to a single global model. A Global in-silico model can be defined and used across several key events and respective (local) in-silico models. The global in-silico model interface is accessible in the in-silico test description can contain mathematical description of the methods used (including MathML formulas) and also a list of parameters describing the model. The parameter list allows users to specify the normal ranged of parameters, mean values, additional descriptors as well as descriptions and references. Each parameter can have more than one value based on different assumptions, references and so on. 

              ***************** File format changes ****************
 *********************************************************************************
- Current file format is version 0.9.61 and is not backward compatible with older versions of Effectopedia (current versions of Effectopedia can still open old versions of the file format but old versions of the program cannot read the current format). The change that produced this lack of backward compatibility is so called DefaultID Negative Revolution. All default objects have negative IDs which are incrementally decreased with the introduction of each new default object. This allows generation of XML files from Java source code which will be used in the future as a backup mechanism. There were several changes in the format related to naming of individual XML elements which also causes lack of backward compatibility. 
 - All experimental and model data are represented in a universal structure called ObjectProperties. This structure is currently used to represent: dose responses and response responses curves, model parameters, analytic function specification, etc. ObjectProperties is a list of ObjectProperty objects each of which has his own type defining its data format. Each object is also array of objects which contain a list of specified values e.g. mean, min, max value, description, reference as well as user defined list of descriptors for example chemical concentration, temperature in which the measurement was taken. Object properties can be also hierarchical and contain a list of sub properties. In summary the structure can represent a table with arbitrary number of columns and rows each cell of which is either simple value or can be another table. 

              *************** Architectural changes ****************
 *********************************************************************************
Major internal source code restructuring was performed to allow cleaner separation of individual modules in line with the adopted OSGI architecture. The essential Effectopedia classes are defined in the kernel bundle of packages which include core, base, data, history, search and other system packages. The kernel does not refer to any external libraries nor depend on any other bundle and can be compiled in a standalone jar with approximate size of 1.5Mb. As part of this package is BaseIO interface which separates the data structure from different format implementations. Multiple implementations can be registered allowing Effectopedia to load and save information from different file formats and systems. Currently two XML format implementations are available one based on JDOM library (originally used in Effectopedia) and one based on Jackson library which is also used for the JSON implementation of BaseIO. All Effectopedia specific graphic representations of objects and their layout is implemented in go bundle. This bundle is used as a dependency from the base gui bundle which along with gui.swing implements the graphic user interface of Effectopedia.  gui.javafx library provides rendering of webpages based on java webkit but is currently not available as bundle and prevent the full transition of Effectopedia toward OSGI. 

                ***** Effectopedia < 0.9.62 Alpha Update Log ***** 
*********************************************************************************
Changes log for earlier versions is available in the respective folders under Archive.
