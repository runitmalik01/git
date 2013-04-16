





// script for creating popup window

YUI().use('datatable-mutable', 'panel', 'dd-plugin', function (Y) {
	
	var addRowBtn  = Y.one('#update'),
	dt, panel, nestedPanel;
	
	var addRowBtn1=Y.one('#updatecontact'),
    dt1, panel1, nestedPanel1;

	var addRowBtn2=Y.one('#updateresidential'),
	dt2,panel2,nestedPanel2;
	
	var addRowBtn3=Y.one('#updatebankdetail'),
	dt3,panel3,nestedPanel3;
	
	var addRowBtn4=Y.one('#previouspi');
	
	var addRowBtn5=Y.one('#previousci');
	
	var addRowBtn6=Y.one('#previousri');
    
    // Create the main modal form.
    panel = new Y.Panel({
        srcNode      : '#panelContent',
        width        : 850,
        zIndex       : 5,
        centered     : true,
        modal        : true,
        visible      : false,
        render       : true,
        plugins      : [Y.Plugin.Drag]
    });

    panel1 = new Y.Panel({
        srcNode      : '#panelContent1',
        width        : 780,
        zIndex       : 5,
        centered     : true,
        modal        : true,
        visible      : false,
        render       : true,
        plugins      : [Y.Plugin.Drag]
    });

    panel2 = new Y.Panel({
        srcNode      : '#panelContent2',
        width        : 850,
        zIndex       : 5,
        centered     : true,
        modal        : true,
        visible      : false,
        render       : true,
        plugins      : [Y.Plugin.Drag]
    });
    
    panel3 = new Y.Panel({
        srcNode      : '#panelContent3',
        width        : 850,
        zIndex       : 5,
        centered     : true,
        modal        : true,
        visible      : false,
        render       : true,
        plugins      : [Y.Plugin.Drag]
    });
       
    // When the addRowBtn is pressed, show the modal form.
    addRowBtn.on('click', function (e) {      
    	panel.show();           
    });
    
    addRowBtn1.on('click', function (e) {    	   
    	panel1.show();          
        panel.hide();        
    });
    
    addRowBtn2.on('click', function (e) { 	   
    	panel2.show();          
        panel1.hide();
    });
    
    addRowBtn3.on('click', function (e) {	   
    	panel3.show();  
        panel2.hide();
    });
    
    addRowBtn4.on('click', function (e){
    	panel.show();
    	panel1.hide();
    });

    addRowBtn5.on('click', function (e){
    	panel1.show();
    	panel2.hide();
    });

    addRowBtn6.on('click', function (e){
    	panel2.show();
    	panel3.hide();
    });
});


