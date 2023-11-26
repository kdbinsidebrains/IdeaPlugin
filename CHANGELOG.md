# KdbInsideBrains Changelog

## [4.6.0]

### Changed

- CredentialProvider redesigned to process hostname/port along with credentials as username/port is required for some
  authentication methods.

## [4.5.0]

### Added

- Connection URI can be dropped into InstanceTree from any place

### Changed

- Send Data Into... splits connected and disconnected instance with connected at the top.
- Testing version is 2023.2.5

### Fixed

- HDB table raises an error: the table is returned in format `col1...`colN!`<tableName> and can't be cast to Flip so
  returned as Dict now instead.

## [4.4.1]

### Fixed

- Code Completion causes deadlock from time to time: issue #76

## [4.4.0]

### Added

- Shortcuts added for Copy/Save active chart
- All overlays/instruments are copied/saved into clipboard as well

### Changed

- Chart SVG library changed to the latest one

### Fixed

- IDEA Save dialog is used to save a chart as PNG or SVG
- Charting takes into account local timezone for drawing correct scale
- Measure charting tool shows temporal values for domain

## [4.3.0]

### Added

- Inactive console tab with running query marked with an execution icon as well as finished query with notificaion icon
  that allows track state of simultaneously running queries.

### Fixed

- Running query icon size fixed for coloured elements in InstanceView

## [4.2.2]

### Fixed

- Supporting of sorted dictionaries (type 127) added

## [4.2.1]

### Fixed

- Table Result tab is not visible in slat few for the first result.

## [4.2.0]

### Added

- New Watches functionality has been introduced. Please check more details
  here: https://www.kdbinsidebrains.dev/features/watches
- KdbConsole restores last state after restart, including all open connections

### Changed

- Expanding a value of a dictionary uses the key name (if it's a string) for new tab name instead of default "Expanded
  Result"

## [4.1.1]

### Added

- 2023.2 EAP version checked and added to supported list

## [4.1.0]

### Added

- Show Thousands Separator functionality added to a Table Result View. It allows to show thousands comma separator for
  any number. Thousands separators only shown in the Table Result View and copied to clipboard but not added to any
  exporting data, like Excel or CSV: https://www.kdbinsidebrains.dev/features/tables#thousands-separator

### Changed

- Filters and Show Index Column as well as new Thousands Separator moved to inner popup 'View Settings' menu for space
  optimization.

### Fixed

- Move an Instance Tree item to wrong position causes an exception.

## [4.0.0]

### Changed

- Lowest IDEA version is 2022.3 to support latest changes and get rid of some errors.
- Libs upgrade to required versions

### Added

- QuickInstance toolbar for NewUI

## [3.8.1]

### Added

- Function Dependency Analysis introduced: https://www.kdbinsidebrains.dev/features/analysis
- IDEA 2023.1 release version added and set as default for testing.

### Fixed

- 'Execute ...' menu only is visible for Q/K files.

## [3.7.1]

### Fixed

- 'Table Result' is opened even there is no table result.
- Active instance style changed to bold underline.

## [3.7.0]

### Added

- 2023.1 EAP version checked and added to supported list
- Asynchronous connection has been added: a message sent with messageType=0 (asynchronous) and asynchronous response is
  expected as result.
- Active Instance is underlined in Instances View
- Changing active connection in the toolbar or via Kdb Console selects the instance in KDB Instances View (configuration
  option. Enabled by default).
- If a query returns not a table, 'Table Result' view is cleaned (configuration option. Enabled by default)

## [3.6.3]

### Fixed

- Backward capability of 2020.* restored for charting

## [3.6.2]

### Fixed

- KDB SDK supporting for MacOS added

## [3.6.1]

### Fixed

- Parsing and formatting of cumulative forward iterator (,/:) fixed
- Block comment adds new line after and before commented code
- Remove Unused Variable action takes into account context and removed only var definition inside conditions and
  controls.

## [3.6.0]

### Added

- Show a dictionary size and key/value types in the Inspector
- Introduce Variable/Field refactoring actions have been added

### Fixed

- Namespace reference is ignored if there is at least one variable/lambda or another namespace is defined in it
- Not spaces between cascading arguments at invocation
- Empty list is not shown in TableView

### Changed

- Connect/disconnect actions in InstancesTree moved to the left

## [3.5.1]

### Fixed

- Reference resoling performance was improved to resolve Execution actions slow preparation
- IndexColumn updated after filtering in TableView

## [3.5.0]

### Added

- Charting templates have been introduced: https://www.kdbinsidebrains.dev/features/charting#templates:
  - Save/Restore a chart configuration
  - Quick charting by template
  - Templates manager

### Fixed

- Changelog fixed

## [3.4.0]

### Added

- Dedicated Live Templates context (KDB+ Q) added with a few templates:
  - sel - create simple select query: select ... from ... where
  - td - today: .z.d
  - yd - yesterday: .z.d-1
  - l10s - time within last 10 seconds by time column
  - l5m - time within last 5 minutes by time column
- Code Completion improved for queries:
  - suggest a table name after 'from' keyword
  - the selection from a table, when columns are extracted and suggested in 'select', 'be' and 'where' sections
  - completion works for defined tables as well as loaded from the Inspector
- Keys are loaded from KDB Instance at inspection time, NOTE: The Inspector query was changed

### Fixed

- Indexer identifies and parses correctly tables and lambdas. Correct type and parameters are shown in suggestions now.
- Variables defined in the Inspector are ignored by UndefinedVariableInspection now
- Issue #61 fixed - the inspection is ignored for complex system "l ",... constructions

## [3.3.0]

### Added

- Copy formatted/rich text from history console (was plain only before)
- Index Column in a Table View enabled by default.
- Inspector scan on connected option enabled by default.

## [3.2.1]

### Fixed

- Search by canonical name in the Inspector

## [3.2.0]

### Added

- Inspector has been improved and more functionality added:
  - Scroll to source
  - Diff with source for a function
  - Restore expanded/selected item between connection change/refresh

### Fixed

- NewUI support removed for now as causes more errors
- memory leak error for InstancesTree fixed (disposed via Disposer now)

## [3.1.0]

### Added

- XMas Tree for key columns from 14 to 31 Dec (enabled by default but can be disabled in configs).

### Fixed

- Tabs memory leak in InstancesTree fixed.

## [3.0.0]

### Added

- IDEA 2022.3 supported now but without 'New UI': the toolbar isn't shown in the mode somehow
- Finally new website with all the features and uses has been launched:  https://www.kdbinsidebrains.dev
- The version increased to 3.0.0 just to synchronize new site with current state as there are a lot of small changes in
  the
  plugin:
  - Split logs by months introduced: https://www.kdbinsidebrains.dev/settings/options#log-queries
  - Ability to change background of the console for colored
    instances: https://www.kdbinsidebrains.dev/features/instances#highlighting-severity
- IDEA 2022.3 supporting added

### Fixed

- Many typos and minor issues fixed

## [2.1.0]

### Added

- Ability to run a *.q file from the project tree has been added.

## [2.0.0]

### Added

- All major features have been finally implemented so the version changed to major 2.x.x from now.

- Library and Module dependencies have been added. Please select 'KDB+ Q Source' library type to add external source
  code to a project (like core files) for navigation and indexing.

### Fixed

- InstanceTreeView memory leak fixed and the structure is correctly disposed now
- Some names in usages dialog fixed

## [1.15.0]

### Added

- Upload a file to an instance has been added. You can select a local file and assign its content to a
  variable

### Changed

- Export to CSV uses comma separator from now with appropriate escaping logic

### Fixed

- All possible deprecated and marked for removal warnings were resolved.
- issue #58: charting time values are offset - wrong timezone is used for date/time axis

## [1.14.0]

### Added

- Code completion takes Inspector result into account: if the KdbInspector is active when code completion takes
  variables. function and tables from loaded structure with 'inspector' location.

## [1.13.0]

### Added

- New KdbInspector tool windows has been added that discovers dynamic structure of an instance.
  The function still experimental so please use carefully. Auto-discovery (discovery after connection) can be enabled
  in options but disabled by default.
  <br><br>
  Related Q query for discovery can be found in
  Git: https://github.com/kdbinsidebrains/plugin/blob/main/src/main/resources/org/kdb/inside/brains/inspector.q

### Changed

- All KDB Plugin services moved to DumbAware and the plugin can be used at indexing time.

### Fixed

- Unary primitive functions formatting incorrect. All added into grammar logic as UnaryFunction. They are inner
  implementation of some functions

## [1.12.0]

### Added

- Table declaration annotations added:
  - tailing semicolon marked as an error
  - set of semicolon (empty declarations) marked as an error
  - even expressions are allowed without column names, they are marked as a warning if it's not declaration

### Fixed

- in TableResult filter Copy action copies component full id instead of text: fixed. Copies column name instead.
- Hidden columns copied to buffer anyway: fully redesigned and works as expected now
- Selection by index column does nothing if table is not in focus: the focus is grabbed now

## [1.11.0]

### Added

- Expand a list/dict/table by double-click in TableResult (can be disabled in options)
- Columns fileter added to TableResult view on the right side: particular columns can be hidden/shown based on the
  filter.

### Fixed

- TableResult takes almost all space in right spit

### Changed

- 'Flip Selected Rows' is opened as a new tab like new expand action instead of a window now.
  Ctrl+Dbl Click is hot-click for the action.

## [1.10.0]

### Added

- "Open TableResultView in separate frame" action has been removed and replaced by DragAndDrop/Docking. You can now
  just drag out a Table Result tab anywhere to detach it or drag it back, if required.

### Deprecated

- Supporting of IDE **2020.3.x** will be removed soon due to high volume of marked for removal APIs.

## [1.9.0]

### Added

- Average/Count/Sum in TableResult for selected cells: for all numerical cells in selection average and sum
  is calculated as well as number of total selected cells

## [1.8.1]

### Fixed

- Show dictionaries with a table as keys or values in TableResult view

## [1.8.0]

### Added

- The plugin icon has been changed to resolve conflict with another plugin
- Show row indexes column in a TableResult has been added. Can be individually enabled per TableResult and
  enable/disabled on KDB+Q Settings panel. Disabled by default.

### Fixed

- Typos in some labels
- An exception at 'Flip Table' action

## [1.7.0]

### Added

- Symbol references introduced
- Open TableResultView in separate frame actin added
- Flip selected rows in separate table view action added
- Open In Editor action added to TableResultView. You can open content of any cell in separate editor tab
  by Alt+Enter or Alt+double left click. Can be used to open JSON, XML or any text content for quick view or edit.
- Import/Export Scopes and instances added
- Context naming convention checks added: leading dot, one level depth and spaces are checking

### Fixed

- Clipboard XML exporting fixed for XML text in a cell
- Removing items from instances tree requires additional approval

## [1.6.2]

### Fixed

- Default InstancesToolWindows type is Tabbed instead of Combo as requested by many users

## [1.6.1]

### Fixed

- Items are auto-expanded at search in InstanceTree
- Max decimal precisions is 16 digits now and size is limited by the spinner in the settings
- Export to Excel and CSV ignores symbol and string wrapping options and export only raw data
- Nulls in Excel exported as empty value
- Copy/Paste takes into account symbol and string wrapping options

## [1.6.0]

### Added

- CredentialsPlugin functionality redesigned:
  - plugins copied into Idea System folder (current approach will be auto-migrated)
  - duplicate plugins are not allowed and adding new version replaces exist one
  - plugion version and description added (plugins must be recomplited)

## [1.5.0]

### Added

- Credentials plugin structure has been improved and redesigned a bit but backward compatible: plugin version has been
  added with "undefined" default value for now.

### Fixed

- Global and Scope credential changes show appropriate error if something is wrong
- Credentials plugin completely destroyed when removed and releases all resources

## [1.4.0]

### Added

- Idea 2022.2 supporting added
- Show public and private assignments in the StrictureView
- Show current element in the NavigationBar, base on the StructureView

## [1.3.1]

### Fixed

- Only console settings are restored: #36
- Not all iterators shown in console result: #37

## [1.3.0]

### Added

- Ability to split Console and TableResults views in Instance Console View: vertically or horizontally. You can set
  default split type in configuration (by default - no split) or set required for each Instance Console View.

### Fixed

- Tooltip for a TableResult has been removed - was added for debug and contains irrelevant information
- Closing last Instance Console View doesn't close Kdb Console tool window

## [1.2.0]

### Added

- Quick definition of an unknown function (quickfix) has been added

## [1.1.2]

### Fixed

- A function's arguments/parameters suggestion has been fixed

## [1.1.1]

### Fixed

- Key columns shown wrong after moving around in TableResult

## [1.1.0]

### Added

- New 'Execute Global Assignment' action has been added: by pressing 'Ctrl + Shift + Enter' or from context menu you
  can send whole global definition for current context into an instance.

  For example, if you have a function definition then 'Execute Global Assignment' will execute the definition wherever
  the cursor is inside the function. It also works for global multiline expressions.

### Fixed

- Long query overlays query time and rows count in a table result view. The query truncated to available size now.

## [1.0.1]

### Fixed

- Freezes at cascading parentheses parsing has been fixed

## [1.0.0]

### Added

- Code formatting has been added. **Warning: it's not recommended to reformat all code at once**
- Type suggestions added for a column definition

## [0.24.0]

### Fixed

- Idea 2022.1 integration fixed (search in a TableView)

## [0.23.1]

### Fixed

- a string shown in a TableView
- chart fails if there is no time/float columns

## [0.23.0]

### Fixed

- Hovering for striped tables is not shown.
- TableView background is not correct if 'stripe table' is disabled for keyed tables.
- Disabling 'wrap string' option also disables 'Stripe table' option.
- Key column symbol is not shown for keyed table but dictionary.

## [0.22.0]

### Added

- a list shown in a TableView (can be disabled in options. Enabled by default.)

### Changed

- a dict in a TableView can be disabled in options

## [0.21.1]

### Fixed

- a string inside a string parsing fixed

## [0.21.0]

### Added

- Dark icons set added with IntelliJ Idea colors
- Charting is ready now:
  - New Magnet/Snap tool has been added with ability to snap to line, vertex or disable the tool (default)
  - Values Tool shows only series values and no range values anymore
  - Measure Tool has context menu with remove/clear ability

## [0.20.0]

### Added

- If a TableResult has more than 200K rows*cols - a 300ms timeout for filtering update has been added after the search
  field change. That allows to write the full search text before do the real search work to reduce freezes for huge
  table result. Can be disabled in the search toolbar for the current search session.

### Changed

- Console behaviours changed:
  - Closing a console tab also closes the connection as well now
  - Changing active console tab changes active connection, so it's the same as select active connection from the
    toolbar

## [0.19.0]

### Fixed

- Table Result search's been fixed and can process strings now.

### Added

- EPA 2021.1 supporting added
- Table Result supports search by words and regex with or without case match
- Right side toolbar in charts view has been added instead of context menu
- Charting tools have been introduced:
  - **Crosshair tool** - to show current values for the mouse position
  - **Measure tool** - draw measuring rectangles on the chart with values diff: left mouse click to start, move, left
    mouse click to finish. Esc to cancel current drawing.
  - **Points collector** - save any chart clicked values into the points collector table with ability to export or
    send
    into another KDB instance.

## [0.18.1]

### Fixed

- resolved #20: QDocs doesn't work for variables

## [0.18.0]

### Added

- Charting configuration has been redesigned
- Candlestick chart has been added
- Line charts have been updated:
  - Spline, Steps, Bar, Area, Diff and Scatter line charts have been added
  - Ability to change line width and show shapes added
  - Transparent colors and axes orders added

## [0.17.1]

### Fixed

- KdbInstances color selection doesn't work in 2021.3.x versions
- Connection state notifications are not shown after the plugin update without restart
- Line Chart can't draw not double numbers

## [0.17.0]

### Added

- Line Charting has been added to the Table View

### Changed

- Icon colors changed for dark theme
- Restart is not required anymore for the plugin

## [0.16.0]

### Changed

- Excel exporting format changed to xlsx (Excel 2007) instead of xls (Excel 95)
  - 1,048,576 rows instead of 65,536 and 16,384 cols instead of 256
  - Streams worksheet is used to reduce memory footprint

- Export actions run as a background task to reduce UI freeze

## [0.15.0]

### Changed

- Supporting of Idea 2021.3 (build 213.*) has been added
- GrammaKit upgraded to 2021.2.1, IdeaPlugin to 1.3.0, Changelog to 1.3.1

## [0.14.0]

### Changed

- Grammar has been fully redesigned and performance has been significantly improved for nested expressions
- StructureView has been updated as well: a variable type is show based on assignment expression
- Files importing has been redesigned and improved. The 'system l' construction supports files refactoring now.
- Supporting version upgraded to 2021.2.3

### Fixed

- Auto-Reconnection logic executes the query, not just does reconnection
- auto-completion has been disabled for parameter names

### Added

- Symbols indexing has been added but not injected in dependency logic yet
- Auto-popup has been added for importing files for both, '\l ' and 'system l' constructions

## [0.13.0]

### Added

- Auto-Reconnection option has been added: when a query is executed and connection's been lost, it's auto-restoring
  first and notification is raised is it can't be restored. Enabled by default.
- 'Reconnect Instance' options has been added in connection lost notification. The notification is moved to Warning from
  Error.

### Fixed

- Linux 'Run Configuration' fixed (thanks to zvenczel-kx)
- Latest IDE version is supported now (2021.2.2). Many compatibility issues have been fixed as well.

## [0.12.2]

### Added

- Local variables added into completion list

## [0.12.1]

### Fixed

- Quick Documentation format has been fixed
- Missed keyword docs have been added

## [0.12.0]

### Added

- Queries logging functionality has been added: each finished query is logged into .kdbinb folder into daily files (can
  be disabled in settings).

### Fixed

- Copy/Paste issue in the console has been fixed: market is not copied anymore.

## [0.11.0]

### Added

- Documentations for all keywords and system (.Q, .h, .j and .z namespaces) functions have been added. Press Ctrl+Q on a
  function.
- Dynamic documentation based on comments with qdoc-tags
  supporting: https://code.kx.com/developer/libraries/documentation-generator/#qdoc-tags. Press Ctrl+Q on a variable.
- TypeCast to hh, mm, ss has been fixed. Lower and upper (parse from a string) casting is supported now.

### Fixed

- Issue with files renaming/moving (files refactoring) has been fixed.
- Global/Local variables inside a lamba defined in a namespace are detected correctly now.
- Variable references work inside a table definition

## [0.10.1]

### Added

- Arguments for .z, .j, .h and commands have been described in the completion

### Changed

- Duplicate connection from console tab has been fixed (https://github.com/kdbinsidebrains/plugin/issues/3)
- Namespace declaration issue fixed (https://github.com/kdbinsidebrains/plugin/issues/2)

## [0.10.0]

### Added

- Lambda parameters info has been added (Ctrl+P)]
- Arguments for keywords and .Q namespace have been described in completion

### Changed

- Correct variable type is shown in the completion popup
- Lambda parameters are shown in the completion popup

## [0.9.0]

### Added

- StructureView for Q files is ready
- A toolbar to a table result view has been added

## [0.8.0]

### Added

- Variable references have been updated and works fine inside global/local and query contexts.
- MixinLambdaVarDeclaration added - minix local and global scope of a variable is shown as an error with quick fix (
  changing scope into initial one).

### Changed

- Inline comment parsing has been finished and appropriate code doesn't blink anymore
- Psi tree elements slightly redesigned to reduce complexity
- Export rows/columns fixed
- Nulls are exported into Excel instead of wrong Q values
- Export re-uses current TableResultView formatting options (string escaping and so on) instead of default one.

### Removed

- QInplaceRenameHandler removed from the project

## [0.7.12]

### Added

- system "l " added to import pattern

### Changed

- UnresolvedImport moved from an Annotation to an Inspection
- UnusedLocalVariable moved from an Annotation to an Inspection
- QImportReferenceProvider optimized
- QVariableReferenceProvider - much better but shows global variables in local scope
- The plugin description has been updated

## [0.7.10]

### Changed

- Grammar has been redesigned to remove lags and issues. Complexity of q.flex was reduced and partly moved to q.bnf
- All KdbInstance related staff (toolwindow, services) are DumbAware now.
- Gradle plugin has been updated to get changelogs from this file and release with publishPlugin

### Removed

- Dicts processing were removed from flex/bnf - too complex and takes ages for parsing

## [0.6.2] - DOESN'T WORK WITH BIG FILES

### Added

- Initial public version of the plugin