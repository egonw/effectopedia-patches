***** Effectopedia 0.9.55 Alpha Update Log ***** 

Unofficial release of the Dec 2015 version. Please do not publish information on the effectopedia server using this version. Major upgrade of the feature list with respect to ver. 0.9.46. Detailed description of the new features will be available in the official release.

***** Effectopedia 0.9.46 Alpha Update Log ***** 

 - Investigations and studies now have their own user interfaces in the Edit tab of the program. The first description section in both interfaces is used as a summary and displayed when investigations and studies have been referenced in the test assay descriptions.  Further development in both interfaces is envisioned in near future. 
 - Existing Investigation and Study dialogs were also added allowing users to choose from existing descriptions when adding new items in the list of associated object in the test assay edit interface.
 - Description sections now support HTML formatted text (with no Java Script and limited CSS styling). Plain text is still the default option for the content of the section. To enable editing the "use" html chebox has to be selected. Click on the HTML toggle button to switch between the HTML code and preview. 
 - New experimental data summary for a substance has been added to the description of the Test Assays. The interface allows selection of a chemical and displays summary table and chart of the most important data measured by the assay (usually dose response). 
 - Estrogen binding example in centralized database has been split into two examples separating the oxidation of hemoglobin initiated cascade to a separate pathway. 
 - Bug Fix: The list of user names was initialized prior to the execution of Effectopedia automatic proxy detection which resulted in not displaying the user names correctly on some systems that utilize proxy. The new version does the proxy detection prior to user name initializations. 
 - BugFix : Existing Effect, Test  and Method dialogs were not including the newly created objects in the current session into the list of existing objects. The problem has been fixed by forced update prior loading

***** Effectopedia 0.9.45 Alpha Update Log ***** 
- Using the ISATab naming convention new Investigation and Study concepts were introduced in the test method descriptions. Study is higher level concept containing the common description and parameters of set of test assays. Similarly Investigation captures the common aspects of set of Studies. The new elements were also added to the file format. Centralized Effectopedia database was upgraded to the new format. 
- The user interface of several editors (Chemical, Test, Effect) was updated with a new multi-column list of referred pathway elements. In the Effect editor for example user can no click on the incoming and outgoing links in addition to upstream causes and downstream effects. Also there is a list of associated tests which can be used for navigation as well. Title sections of the test panels on both sides of a link editor could also be used for navigation with double-clicking.
- New interface component was implemented which could be collapsed to a single title raw and expanded to show additional content below. The new interface is now used in the description sections as well as in the investigation and study lists.
- Existing Effects Dialog and Existing Test Dialog were updated to provide a preview of the selected pathway element. The interface also verifies if the selected element is not already visible in the pathway screen and id so generates an error message.
- New ex-vivo test category of test methods was added. A list of default description sections was added to the standard laboratory test method description. The list of sections is preliminary and will be updated after brother discussion.  
- Bug fix: resizing of EffectUI, LinkUI, InLabTestUI,... was fixed and now adding multiple additional elements (e.g. new descriptions sections) does grow the panel proportionally so all elements are still accessible via scrolling.
- Bug Fix: Method class did not implemented clone method which caused problems with loading of XMLFiles.
- Bug Fix: The maximal ID in XML files is no longer off by one (greater with one of the maximal ID number in the file)

***** Effectopedia 0.9.44 Alpha Update Log ***** 
- One raster (PNG) and one vector (SVG) image formats were added under the save file dialog allowing saving current pathway view in an image file. The content of the export is also controlled by the current zoom level and chosen projection of the pathway space which is also exported in the image. PNG format does represent all that is visible on the screen while SVG format is currently limited to all graphic primitives of the pathway elements, their titles, IDs and link mapping types. 
- Description sections have been updated to estimate more precisely the visual height of the content and adjust the interface accordingly. Scroll bars appear if the content is larger from what is allocated on the screen. 
- Initial implementation on the batch copy and paste of the description sections form any HTML formatted document Wikipedia / OpenOffice and MS Word was introduced
- Bug Fix: File extension is now automatically added if not specified by the user (the default is aopz)


***** Effectopedia 0.9.43 Alpha Update Log ***** 
 - New automated proxy settings detection and search strategies were implemented using proxy-vole library. Effectopedia now tries to detect and use the correct proxy server if available prior to establishing connection to the Effectopedia.org server. 
 - A minimalistic chart component was implemented. It can be currently viewed, but not controlled with the user interface, in the quantitative descriptions of the links and is dedicated to plottinh dose / response or response / response curves. Current version supports only line charts with linear or logarithmic scale. 
 - With the internal restructuring Jabref source code was packed as a external library jar file. Old version of Michael Thomas Flanagan's Java Scientific Library was stripped from not utilized classes and added to the project as flangan.jar file. The library is currently used only for its implementation of Nelder and Mead Simplex method in the charts to approximate experimental data.
 - Bug Fix: Files started in memory were saved with incorrect externalIDs (in case multiple data sources were loaded). ExternalIDs of the XML exported files are now cleared with correct IDs.
 - Bug fix: A function (DEBUG_getIDs) used for debug purposes only is fixed and now works even if downstreamLinkIDs and referenceIDS are not initialized.


***** Effectopedia 0.9.42 Alpha Update Log ***** 
 - The new version offers refined integration of the test methods as evidences for individual MIEs, biological effects and adverse outcomes. Four distinct types of test methods can be specified: in-chemico, in-vitro, in-vivo, in-silico. New component TestResoinceMapping was introduced to represent the relationship between the test method and its biological effect. The user interface has been updated to allow editing and loading of test response mappings and the new four types of test methods. The list of default objects and file format was amended to support the new set of objects. Specific editors in-silico models and test response mapping has to be created and the in-chemico, in-vitro and in-vivo editors need to be updated.  Existing files are readable in the current version but not all features are tested to be working. Effectopedia database was generated from script to be coherent with the new format. 
 - Internal changes were made so the Quantitative Relationship in links so they use a common formalism with the relationships in the test response mappings. 
 - Effect and Test objects were modified and no longer refer to Test and Effects directly but instead hold references to TestResponseMappings. New mapping associations were universally introduced in the PathwayElement(s). 

***** Effectopedia 0.9.41 Alpha Update Log ***** 
 - The interface of the address bar was updated. The location combo box now includes copy and paste buttons for the current dataSource and location. The revision number and location ID are also edit-able text fields. When new address is pasted it is initially parsed and matched against any of the already loaded dataSource. If the dataSource exists it is rolled to the revision and the location provided in the url and the content is loaded in the viewer.
 - Revision navigation has been further tested to work with all existing examples.
 - Major revision on all publishing scenario were performed. Publishing new content on the server when edits were made directly in Effectopedia centralized DB was successfully matched to the content which is merged from independent data source. New approach was introduced merging pathways and their elements which updates all internal references. All cloned objects obtain a new EffectopediaID so the convention for unique ids for all objects besides default objects is preserved. The verification and handling of conflicts from parallel edits needs further testing. Data source merge interface was updated and tested.
 - When new pathway elements in connected to existing element the new elements is associated with the complete list of pathways of the existing element. This behavior might  be further refined and include the list of visible pathways only.
 - Bug Fix: The method isLinked was generating a null pointer exception when exploring the outgoing connections causing problems with the depiction of newly placed elements. 
 - Bug Fix: The order of execution of storing the originals before updating nested effectopedia objects was fixed so parent objects are cloned before the contained objects are changed. 
 - Bug Fix: After loading from file the pathway elements might contain references to the default objects instead of clones (which can lead to modification of the content of a default object). New methods were added to ensure all pathway elements contain references to clones of default objects only. 
 - Bug Fix: Adding defaultData when loading new XML file was made from current data set instead of the default memory data source
 - Bug Fix: The clone method of biological perturbation was not overriding properly the method of the Substance class and therefore the Substance.clone method was called instead.
 - Bug Fix: The edit history of is now correctly copied from the base data source.
 - Bug Fix: Pathway wizard now uses correct data source when cloning the default elements. 
 - Bug Fix: Coordinate units were are now properly read from the XML file.
 - Bug Fix: All properties of chemical substances (info, properties, ...) were not cloned. New methods were added to implement the cloning of object properties.
 - Bug Fix: Existing Pathway Dialog was not using the current data source when creating a clone of the default object.
 - Bug Fix: EditHistory was changed to produce consecutive actionID and stampID in the output XML file. The original actionID and stampID-s are ignored since stampIDs is dependent on the order of the loading of the files in the Effectopedia
 - Optimization: When cloning pathways the embaded pathway elements were created in the constructor and immediately replaced from the ones created in the cloneFieldsTo method. That was avoided by calling the default constructor which points the default objects without cloning.


***** Effectopedia 0.9.4 Alpha Update Log ***** 
 - Revision navigation is now implemented and needs further testing. The file location URL now contains the loaded pathway/pathway element besides the revision number. Earlier versions of the currently shown element - loaded in the pathway viewer - can be displayed by simply clicking on back button for revision navigation.
 - Local files now keep the location of the last edited pathway or element and automatically load it in the editor when file is opened.
 - Default Objects in Effectopedia file now have a fixed creation date which will change when new default object is introduced into the system (until now the current application execution time stamp was used)
 - Several internal optimizations were performed reducing the number of archival objects created and subsequently stored in files. The overall size of Effectopedia database was reduced to less than 2.4 Mb uncompressed (form more than 7.0Mb). As a result of the changes old Effectopedia files can not be browsed for their edit history.
 - DataSourceID was introduced which is provided by the Effectopedia.org server. The ID is obtained once and kept the same during the multiple revisions of the file.
 - Search results are now sorted by the order of creation of the elements.
 - DefaultObjects are now ignored in the search results
 - Server version of Effectopedia database was re-created from script in the new internal format 0.9.4. Old Effectopedia jar and executable files will give a warning for the file format version and need to be upgraded to the current Effectopedia version.
 - Multiple bug fixes related to the loading of the revision history, reference and default objects from local or remote XML files.


***** Effectopedia 0.9.38 Alpha Update Log ***** 
 - New System Console was added as a feedback interface. Current version of the console becomes visible on the first error. It shows both the Java console and the error log. The new interface also allows copying the content of the console along with the list of mouse and keyboard actions, and the error stream to the clipboard. Additionally the user can launch the default e-mail client and paste the content of the report and send it as a feedback. 
 - The cycling of the effect type (with single click on a preselected generic object) was updated and now switches only between types allowed for the current object. For example MIEs connected to a chemical could not be cycled, AdverseOutcomes are excluded from the cycle when the element has outgoing associations, MIEs are also excluded from the cycle if the previous component is not a Substance subclass.
 - Bug Fix: the problem of loading links as a segment root or disconnected links was eliminated by assigning default segment.
 - Bug Fix: Newly inserted references are editable when the whole object is not in the read only mode.
 - Bug Fix: The use of type cycling was prone to visual errors since the arcs were connected to the original visual element (which have been substituted by a object of a new type). The problem did manifest itself when the position of the new object becomes different than the original. In this case arcs were hanging in the void - which did not cause any logical errors (the pathway could be correctly displayed if the viewer is reloaded). In the current release the arcs are substituted with new ones connected to the new visual object
 - Bug Fix: The new elements added to the pathway space always had the default size, indiscriminately of the current zoom level. In the new release the elements are pre-scaled with the respect of the zoom level.
 - Bug Fix: Switching the pathway axis to different dimension often caused parts of the vertical axis to become unreachable with scrolling down. The new version calculates the available space correctly and updates the size of all synchronized headers and footers.

***** Effectopedia 0.9.37 Alpha Update Log ***** 
 - New script version of the DNA Intercalation Mediated Cardiomyopathy pathway was added to the source. The pathway is not published yet. 
 - Bug fix: “Ctrl+del” deletion of the elements caused complete disconnection the selected elements. The new version disconnects the pathway elements only if all the pathways they are associated with are currently visible. In all cases the deleted elements are disassociated from the currently visible pathways 
 - Bug fix: The VisulaOptions menu is now updated with the loaded data and aligning and visual properties of the pathway elements can be adjusted as before. 
 - Internal sorting of the pathway elements was rewritten and no longer uses recursive methods. This should avoid possible stack overflow problems. 
 - New internal function for batch assigning of context dimension for all elements of a certain pathway was added.

***** Effectopedia 0.9.36 Alpha Update Log ***** 
- Biological perturbations were introduced. This new pathway element provides the means to encode the cases in which higher level of biological organization effect has molecular level consequences and would require backward connection (which is not allowed for clarity). The current implementation allows the pathway editor to work with the new element and support all the existing features. 
- Bug Fix: The zoom level is reset to default when new information is loaded in the PathwayViewer 		
- XMLFile version was updated to 0.936. New version control check was introduced (executed when file is loaded). Warning messages are generated when file format version is greater than currently supported.

***** Effectopedia 0.9.35 Alpha Update Log ***** 
- New feature was added to CLET mode allowing the insertion of intermediate effect up or downstream from existing link. The link is automatically reconnected and a second link is inserted to maintain the pathway connectivity.
- The true delete method is now partially implemented, allowing the deletion of non-generic objects. The objects are disassociated from the currently visible pathways but still remain accessible trough search and show up in the list of existing elements.
- Substance type cycler now starts the cycle with a chemical instead of structural alert.
- The order of the elements in Effect in Terms Axis was changed to "unknown,long-term,mid-term,short-term,mixed"
- PathwayViewer now renders correctly connected fragments of PathwayElements that are not  associated with a pathway. The problems occurred in older version when user switched the view space projection containing fragments not associated with any pathway
- The address bar user interface was modified to show tooltip with the current file name, and its layout was changed to allowing better resizing behavior. 
- Bug fix:When changing one of the pathway space axis the other might not have been initialized. The current version verifies that both dimensions are set before rebuilding the view
- Bug fix: Multiple phenomena pronounced when changing the pathway space axis, data sources, creating a new pathway with the selected data source, etc were all fixed by complete re-loading of the DataView in all related classes.
- Bug fix: Associated pathways list is once again modifiable with the toolbar menu. The function of redirecting the interface on double click was also maintained. 
- Bug Fix:When existing element is inserted into the pathway viewer the replaced element and all its arcs are now completely removed from the view
- Big fix: When pathway elements were deleted their links to other objects remained untouched. The current version unliks the currently deleted object from other objects.
- Bug fix: The showing of full caption now verifies against for empty text and does cause division by zero and no rendering of the element. 
- Bug fix: When title and ID are selected to be visible in the Effect depiction and the title is empty the ID was ignored and not displayed. Current version shows the ID even in case the title is empty. 
- Bug fix: Each new pathway element created in CLET mode when cyclic over element type replaces the old element and reassign the existing links to the new object.

***** Effectopedia 0.9.34 Alpha Update Log ***** 
- Pathway space axis labels are now automatically extened or shrunk in synchrone with the size of the content.
- Bug fix: The list of associated pathways can be successfully modified with the list editor toolbar. In the last revision readolny flag was raised preventing the Existing pathway dialog from showing. 
- Bug fix: Interrupting the workflow of CLET interface mode was reversing the direction of the workflow by default. Now the direction of the new cycle is evaluated based on the the exact user action. This caused generation of two Structural Alerts instead of one Structural Alert and link.

***** Effectopedia 0.9.33 Alpha Update Log ***** 
- Bug Fix: The new script generated versions of Effectopedia pathways were affected by the disabled search indices which in their turn resulted in creating of duplicate objects. (The internal searches failed during the script execution preventing the system to reuse the existing objects)
- Bug Fix: location external or internal ID of the object caused a crash in case of non assigned locationObject  
- Effectopedia now supports unlinking of objects which currently can be used only internally.
- Bug Fix: The list of associated pathways in PathwaysListUI was not read-only. This is required in order for double clicking to work and load the existing pathway editing interface.
- Bug Fix: QualityAssuranceUI was crashing when the list of contributors is empty. This was manifested when a new Chemical was edited for the first time. 
- Some additional internal fixes were made which could become problematic in future usage scenarios.

***** Effectopedia 0.9.32 Alpha Update Log ***** 
- Several cosmetic improvements have been introduced. Related Effects interface now has different titles for upstream causes and downstream effects. All subcomponents also use consistent terms.
- Effect Editor caption is now selected based on the class that is currently loaded for editing. 
- Existing Chemicals Effects and Pathways dialogs now support sorting of their lists. Currently Title sort is used as a default sorting method.
- Bug Fix: RelatedEffects was changing its read-only property based on the object that is loaded in the editor. The Existing list of related effects was made read-only to prevent accidental deletion of associations. 

***** Effectopedia 0.9.31 Alpha Update Log ***** 
- Browsing of HistoricalDS pathways is now possible. Users could not make any changes to historical versions of pathways and their elements. If historical data source is loaded in the viewer all editing buttons become hidden and double click on any of the displayed elements loads pathway elements in read only editors.
- Search in HistoricalDS is now possible. 
- SearchResult objects now contain the DataSource from which they were obtained. This however is not displayed to the user
- UINavigator now supports two new mechanisms for setting up the ReadOnly flag for the editor before loading. One is event based and the other is the encoded in the url readonly flag.

***** Effectopedia 0.9.3 Alpha Update Log ***** 
- CommandToolbarUI was moved to the top of the application in order to emphasize that all commands are executed for the the currently selected datasource. 
- New address bar with location and navigation was designed and implemented. The location combobox shows the list of available data sources. During program loading the location combobox is initialized with connection to the centralized database string and upon successful download it does display the current revision number.
- Bug Fix: Coordinates of Sex axis were not correcly read from old files still using the Gender name for the same axis. Small patch was added to make the new version backward compatible 

***** Effectopedia 0.9.295 Alpha Update Log ***** 
- Bug fix: The interface of newly added description sections was not linked to the newly created objects causing loss of changes made in the current session. Another side effect of this miss linkage is the absence of scrollbars when the content is bigger of the visible viewport. Both problems were solved by linking the interface and newly created description section object.
- Gender axis was renamed to Sex axis along with all internal variables associated with it.
- New "copy" and "paste" capabilities were introduced to Reference interface. They allow coping the full list of references and adding the a new line separated references from clipboard into the list.

***** Effectopedia 0.9.29 Alpha Update Log ***** 
- Bug fix: Associated pathways list had a readonly property set to true by default ignoring the object's and interface settings making the addition of new pathways impossible. Now the property is set according to the element read-only flag. - All title fields in the element editors have hints that contain the content of the entire field. - Bug fix: When the content of a description section is updated with text larger than the component size no scroll bars appear (unless the whole editor is reloaded). The description section editor was updated to respond to changes of its content.

*****  Effectopedia 0.9.285 Alpha Update Log *****
- Effectopedia jar (windows wrapped executable version) now accept file name as command line parameter to open in the list of available data sources. 
- Script version for about 300 new MIEs, endpoints and adverse outcomes was completed and the result was stored in a new revision (4) of Effectopedia database.
- Big fix: Cloning of DataValues representing searchable properties was cloning the SearchableItem including the referred object which is now correctly redirected to the new clone parent object.

*****  Effectopedia 0.9.28 Alpha Update Log *****
- The appearance of the effects and chemicals in the pathway viewer can be customized. The visual content of effect and chemical was broken into sections which could be individually enabled and disabled. Several new displayable fields were added – Quality Assurance, Pathway Associations and Groups and Keywords. The new options are available in the View tab in the formatting section of the buttons. 
- New search results navigator was introduced at the bottom of the search results page. It provides links for navigation between result pages (if more than one) and also reports the total number of matches.
- Gender list now includes hermaphrodite. ContexDimensions were updated accordingly
- Big fix: Scale is now reset to the default level on loading a new pathway in the editor.
- Big fix: The effect editor user interface now scrolls to the top on loading.


*****  Effectopedia 0.9.27 Alpha Update Log *****

- Effectopedia no longer uses FTP protocol for communication with the server and instead uses HTTP for all of its transactions.
- New list capability was added to the search tab showing all elements form a certain type in the search results
- Multiple changes to both server side processing and generation of notifications were made. The new capabilities are still undergoing testing and not active in the current release.
- Big list of MIEs, Adverse Outcomes and Endpoints was prepared as a script for adding into the Effectopedia database. Further refinement will be performed on the list before the list is published.

*****  Effectopedia 0.9.25 Alpha Update Log *****

- New FeedbackToolbar was added to all editor headers enabling users to create general comments about the edited objects. 
- Discussion associated with a given topic is now correctly loaded in the editor. New topic element was added to the DiscussionPosting XML import/export that preserves the parent object (which is the topic for the postings)
- Related topics panel is now functional. It lists all related topics from the associated list of pathways. By clicking on a certain row from the table of topics the topic is loaded along with its postings.
- The discussion interface now has two modes: one for creating and editing discussion topics and the other for discussion postings. If the topic is newly created or the same user is logged in and no postings exist the editor is topic edit mode otherwise in posting edit mode.
- QualityAssurance interface now displays the list of reviewers along with the list of contributors.
- Bug fix. Discussion postings now calculates the needed amount of space for visualizing the postings' content


*****  Effectopedia 0.9.24 Alpha Update Log *****

- The notification system now generates the notifications based on revision history. All actions since last revision are added as notifications to the SYSTEM user. Currently no user specific notifications are created. So far the notifications system has been tested only with new discussion topics. 
- Revisions array form EditHistory is now updated just before the file is saved to XML stream
- Bug fix. The References class has not been added to list of REGISTERED TracableClasses resulting in the smaller number of copied default objects in the EditHistory when using addDefault method
- Bug fix. Complete edit history is now preserved. Some actions were omitted in the older versions


*****  Effectopedia 0.9.235 Alpha Update Log *****

- Pathway editors now display "- read only" in their captions when a flagged object is loaded.
- The readonly inheritance was modified for the nested EffectopediaObjects. The read only status is determined as a disjunction between the "Load" function parameter (often reflecting parent readonly flag) and self readonly flag. 
- Script version of Lhasa pathway examples was updated.
- Bug fix. The new locking mechanism was not protecting references from editing. 
- Bug fix. The discussion topics are now successfully located after publishing and starting a new session.

*****  Effectopedia 0.9.23 Alpha Update Log *****

- Mechanism for locking the editing of whole pathways or separate elements/subelements was introduced. This is achieved with the new "readonly" XML attribute in pathway elements' description. Elements with such attribute will load in the editors in read only mode and cannot be modified.
