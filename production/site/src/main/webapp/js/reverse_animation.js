// ===================================================================
// Author: Matt Kruse <matt@mattkruse.com>
// WWW: http://www.mattkruse.com/
//
// NOTICE: You may use this code for any purpose, commercial or
// private, without any further permission from the author. You may
// remove this notice from your final code if you wish, however it is
// appreciated by the author if at least my web site address is kept.
//
// You may *NOT* re-distribute this code in any way except through its
// use. That means, you can include it in your product, or your web
// site, or any other form where the code is actually being used. You
// may not put the plain javascript up on your site for download or
// include it in your javascript libraries for download. 
// If you wish to share this code with others, please just point them
// to the URL instead.
// Please DO NOT link directly to my .js files from your site. Copy
// the files to your server and use them there. Thank you.
// ===================================================================

/* SOURCE FILE: date.js */
YUI().use('anim', function(Y) {
    var module = Y.one('#demo');

    // add fx plugin to module body
    var content = module.one('.yui3-bd').plug(Y.Plugin.NodeFX, {
        from: { height: 0 },
        to: {
            height: function(node) { // dynamic in case of change
                return node.get('scrollHeight'); // get expanded height (offsetHeight may be zero)
            }
        },

        easing: Y.Easing.easeOut,
        duration: 0.5
    });

    var onClick = function(e) {
        e.preventDefault();
        module.toggleClass('yui3-closed');
        content.fx.set('reverse', !content.fx.get('reverse')); // toggle reverse 
        content.fx.run();
    };

    // use dynamic control for dynamic behavior
    var control = Y.Node.create(
        '<a title="collapse/expand element" class="yui3-toggle">' +
            '<em>toggle</em>' +
        '</a>'
    );

    // append dynamic control to header section
    module.one('.yui3-hd').appendChild(control);
    control.on('click', onClick);

});
// module 2 
YUI().use('anim', function(Y) {
    var module = Y.one('#demo2');

    // add fx plugin to module body
    var content = module.one('.yui3-bd2').plug(Y.Plugin.NodeFX, {
        from: { height: 0 },
        to: {
            height: function(node) { // dynamic in case of change
                return node.get('scrollHeight'); // get expanded height (offsetHeight may be zero)
            }
        },

        easing: Y.Easing.easeOut,
        duration: 0.5
    });

    var onClick = function(e) {
        e.preventDefault();
        module.toggleClass('yui3-closed');
        content.fx.set('reverse', !content.fx.get('reverse')); // toggle reverse 
        content.fx.run();
    };

    // use dynamic control for dynamic behavior
    var control = Y.Node.create(
        '<a title="collapse/expand element" class="yui3-toggle">' +
            '<em>toggle</em>' +
        '</a>'
    );

    // append dynamic control to header section
    module.one('.yui3-hd2').appendChild(control);
    control.on('click', onClick);

});

YAHOO.util.Event.addListener(window, "load", function() {
    YAHOO.example.InlineCellEditing = function() {
        // Custom formatter for "address" column to preserve line breaks
        var formatAddress = function(elCell, oRecord, oColumn, oData) {
            elCell.innerHTML = "<pre class=\"address\">" + YAHOO.lang.escapeHTML(oData) + "</pre>";
        };

        var myColumnDefs = [
            {key:"empTan","label":"Employer TAN", formatter:formatAddress, editor: new YAHOO.widget.TextareaCellEditor()},
            {key:"empName", "label":"Employer Name",formatter:"text", editor: new YAHOO.widget.TextboxCellEditor({disableBtns:true})},
            {key:"empSalaries", "label":"Employer Salaries",editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber})},
            {key:"totalTaxDeducted", "label":"Total Tax Deducted",editor: new YAHOO.widget.TextboxCellEditor({validator:YAHOO.widget.DataTable.validateNumber})}
        ];

        var myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.tdsSalaries);
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema = {
            fields: ["empTan","empName","empSalaries","totalTaxDeducted"]
        };

        var myDataTable = new YAHOO.widget.DataTable("cellediting", myColumnDefs, myDataSource, {});

        // Set up editing flow
        var highlightEditableCell = function(oArgs) {
            var elCell = oArgs.target;
            if(YAHOO.util.Dom.hasClass(elCell, "yui-dt-editable")) {
                this.highlightCell(elCell);
            }
        };
        myDataTable.subscribe("cellMouseoverEvent", highlightEditableCell);
        myDataTable.subscribe("cellMouseoutEvent", myDataTable.onEventUnhighlightCell);
        myDataTable.subscribe("cellClickEvent", myDataTable.onEventShowCellEditor);
        
        return {
            oDS: myDataSource,
            oDT: myDataTable
        };
    }();
});
//contact_info js
YUI().use('anim', function(Y) {
 var mod = Y.one('#dem');

 // add fx plugin to module body
 var content = mod.one('.yui3-bdd').plug(Y.Plugin.NodeFX, {
     from: { height: 0 },
     to: {
         height: function(node) { // dynamic in case of change
             return node.get('scrollHeight'); // get expanded height (offsetHeight may be zero)
         }
     },

     easing: Y.Easing.easeOut,
     duration: 0.5
 });

 var onClick = function(e) {
     e.preventDefault();
     mod.toggleClass('yui3-closed');
     content.fx.set('reverse', !content.fx.get('reverse')); // toggle reverse 
     content.fx.run();
 };

 // use dynamic control for dynamic behavior
 var control = Y.Node.create(
     '<a title="collapse/expand element" class="yui3-toggle">' +
         '<em>toggle</em>' +
     '</a>'
 );

 // append dynamic control to header section
 mod.one('.yui3-hdd').appendChild(control);
 control.on('click', onClick);

});

