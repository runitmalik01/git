///////// PUBLIC METHODS /////////////////

Tree = function(instanceName) {

	this.objName = instanceName; // this tree instance name

	this.currentTreeId = null;
    this.relPathToTreeDir = null;
    this.onClickNodeHandler = null;
    this.onDblClickNodeHandler = null;
    this.makeNonSelectableGray = null;

    this.highlightNodeId = null;
	// Set up this variable to define maximum childs count to be displayed
	this.maxChildsCount = -1; //infinity
	this.maxChildsCountOverflowHandler = null;

    this.currentMenu = null;
	this.currentNodeId = null;
	this.onFinishRefreshNandler = null;

	this.nodesIsBeingLoaded = new Array();

	this.previousDraggable = null;
	this.previousDroppable = new Array();
	this.dragSupportEnable = false;
	this.draggableParents = new Array();
	this.onDropHandler = null;

	this.turnOffEvents = false;
}


/**
 * Set no node as current
 */
Tree.prototype.dropCurrentNode = function () {
    if ( this.currentNodeId ) {
        obj = document.getElementById("name" + this.currentNodeId);
        if (obj) obj.className = "";

        this.currentNodeId = null;
        TreeDWRServer.setSelectedNode(this.currentTreeId, null);
    }
}
/**
*Set highlight node
*
*/
Tree.prototype.highlightNode = function (nodeId) {
	this.highlightNodeId = nodeId;

    if (this.highlightNodeId) {
    	obj = document.getElementById("name"+this.highlightNodeId);
    	if (obj) obj.className = "selectedNode";
    }

}

/**
* Sets current node
* No checks will be perfomed
*/
Tree.prototype.setCurrent = function (nodeId) {
    if (this.currentNodeId) {
        obj = document.getElementById("name"+this.currentNodeId);
        if (obj) obj.className = "";
    }

    if (this.highlightNodeId) {
    	obj = document.getElementById("name"+this.highlightNodeId);
        if (obj) obj.className = "";
    }

    obj = document.getElementById("name"+nodeId);

    if ( obj ) {
        this.currentNodeId = nodeId;
        obj.className = "selectedNode";
        if (!this.isVisible(obj))
            obj.scrollIntoView(true);

		this.setUpDND(nodeId);
	} else
		clearDNDValues(this);

    this.currentNodeId = nodeId;

    TreeDWRServer.setSelectedNode(this.currentTreeId, this.currentNodeId);
}

Tree.prototype.hasAncestor = function (itemId, ancestorId) {
	if (ancestorId==null)
		return false;

	parentId = itemId;
	do {
		parentId = this.getParentNodeId(parentId);
	} while ( parentId!=null && parentId!=ancestorId );

	return parentId == ancestorId;
}

/**
* Returns current selected node id
*/
Tree.prototype.getCurrentNodeId = function () {
    return this.currentNodeId;
}

/**
* Expands node that have been loaded
* This asynchronous function
*/
Tree.prototype.expandLoadedNode = function (nodeId, onFinishFunction) {
    parents = new Array();
    do {
        parents[parents.length] = nodeId;
        nodeId = this.getParentNodeId(nodeId);
    } while (nodeId!=null);

    path = new Array();
    q = parents.length-1;
    i=0;
    while (q>=0) path[i++] = parents[q--];

    this.expandNode(path, onFinishFunction);
}

/**
* Rerurns parent tree node ID
*/
Tree.prototype.getParentNodeId = function (nodeId) {
    elem = document.getElementById("name" + nodeId);
    if (elem) {
        do {
            if (elem.parentElement)
                elem = elem.parentElement;
            else
                elem = elem.parentNode;

            if (!elem) return null;

            if (elem.id) break;
        } while (true);

        return elem.id;
    } else
        return null;
}

/**
* Returns first above node id (on the same level)
*/
Tree.prototype.getAboveNodeId = function (nodeId) {
	if( nodeId == null )
		return null;

    parentId = this.getParentNodeId(nodeId);

	if( parentId == null )
		return null;

    elems = document.getElementById(parentId).getElementsByTagName("DIV");

    result = parentId;
    for ( q=0; q<elems.length; q++ ) {
        divId = elems[q].id;
        if ( divId.indexOf("name")==0 ) {
            divId = divId.substring(4, divId.length);
            if (this.getParentNodeId(divId)==parentId)  { // both items on the same tree level
        	    if ( divId==nodeId )
    	            break;
	            else {
                	result = divId;
            	}
            }    
        }
    }

    return result;
}

/**
* Returns the next node id (on the same level)
*/
Tree.prototype.getNextNodeId = function (nodeId) {
	if( nodeId == null )
		return null;

    parentId = this.getParentNodeId(nodeId);

	if( parentId == null )
		return null;

    elems = document.getElementById(parentId).getElementsByTagName("DIV");

    isFound = false;

	for ( q=0; q<elems.length; q++ ) {
        divId = elems[q].id;
        if ( divId.indexOf("name")==0 ) {
            divId = divId.substring(4, divId.length);
            if (this.getParentNodeId(divId)==parentId)  { // both items on the same tree level
				if( isFound )
					return divId;

				if ( divId==nodeId )
    	            isFound = true;
            }
        }
    }

    return null;
}

/**
* Returns node name by id
*/
Tree.prototype.getNodeName = function (nodeId) {
    elem = document.getElementById("name" + nodeId);

    if (elem) {
        return this.toStringFromHtml(elem.innerHTML);
    }

    return null;
}

/**
* Returns all childs of given node as plain array
*/
Tree.prototype.getAllChildNodes = function (nodeId) {
    var elem = document.getElementById(nodeId);
    if (elem) {
    	var result = new Array();
    	var childs = elem.getElementsByTagName("DIV");
    	for (var i=0; i<childs.length; i++) {
    		var s = childs[i].id;
    		if (s.substring(0,4)=="name") {
    			var id = s.substring(4);
    			result.push(id);
    		}
    	}
    	return result;
    } else {
	    return null;
    }
}


///////// Private methods and variables /////////////////

Tree.prototype.getAbsolutePosition = function ( obj ) {
  var rd = { x:0, y:0 };

  if( document.layers ) {
    rd.x = obj.x;
    rd.y = obj.y - 12
  } else {
    do {
      rd.x += obj.offsetLeft;
      rd.y += obj.offsetTop;
      obj = obj.offsetParent;
    } while( obj );
  }
  return (rd);
}

Tree.prototype.isVisible = function (obj) {
    pos = this.getAbsolutePosition(obj);

    if (pos.y > window.document.body.scrollTop
        && pos.y < window.document.body.scrollTop+window.document.body.clientHeight-10 )
        return true;

    return false;
}

Tree.prototype.tryNotOpened = function (id) {
    obj=document.getElementById(id);
    if (obj) {
        visible=(obj.style.display!="none")
        key=document.getElementById("x" + id);

        if (!visible) {
            obj.style.display="block";
            if(key) key.innerHTML=this.toggleHtml('minus', id, 0);
            TreeDWRServer.expandNode(this.currentTreeId, id);

            ibj_innerHTML = this.allTrim(obj.innerHTML);
            return !visible && ibj_innerHTML.length==0
        }
    }

    return false;
}

Tree.prototype.toggleHtml = function (sign, item, childsCount) {
    return "<img src='"+this.relPathToTreeDir+sign+".gif'"+
           " onclick=\"javascript:"+this.objName+".Toggle('"+item+"','"+childsCount+"');\""+
           " hspace='0' vspace='0' border='0'>";

}

Tree.prototype.callLoadSubnodes = function (itemId, addSubnodesHandler) {
    for ( q=0; q<this.nodesIsBeingLoaded.length; q++ ) {
        if ( this.nodesIsBeingLoaded[q] == itemId )
            return;
    }

    this.nodesIsBeingLoaded[this.nodesIsBeingLoaded.length] = itemId;

	TreeDWRServer.getSubnodes(this.currentTreeId, itemId, this.getNodeDeep(itemId)+1, addSubnodesHandler);
}

Tree.prototype.getNodeDeep = function (nodeId) {
	deep = 0;
	parentNode = nodeId;
	while ( (parentNode=this.getParentNodeId(parentNode)) != null ) deep++;

	return deep;
}

Tree.prototype.nodeHasBeenLoaded = function (itemId) {
    clearArray = new Array();
    for ( q=0; q<this.nodesIsBeingLoaded.length; q++ )
        if ( this.nodesIsBeingLoaded[q] != itemId )
            clearArray[clearArray.length] = this.nodesIsBeingLoaded[q];


    this.nodesIsBeingLoaded = clearArray;
}

Tree.prototype.setCurrentNode = function (id, onSelectFunctionName, onlyOnSelectCall, parentId) {
	if ( this.turnOffEvents ) return;

	if ( this.onClickNodeHandler )
        eval( this.onClickNodeHandler+"(true);");

    if (this.currentNodeId==id) return;

	this.setUpDND(id);

	if (parentId==null)
        parentId = this.getParentNodeId(id);

    if (onSelectFunctionName!=null && onSelectFunctionName!="null") {
        onSelectFunctionCall = onSelectFunctionName+"('"+id+"','"+parentId+"');";
        fResult = eval("if ("+onSelectFunctionName+") "+onSelectFunctionCall);
        if (fResult==false) {
            return;
        }
    }

    if (onlyOnSelectCall)	return;

    this.setCurrent(id);
}

Tree.prototype.getOnClickHref = function (node) {
	return node.selective ?
		   "javascript:"+this.objName+".setCurrentNode('"+node.id+"','"+node.onSelectFunction+"');" :
		   "javascript:"+this.onClickNodeHandler+"(false);";
}

Tree.prototype.getIconTd = function (node) {
	return  "<td width='16' nowrap>"+
            "<img width='16' height='16' src='"+node.iconPath+"' onclick=\""+this.getOnClickHref(node)+"\""+
			" hspace='0' vspace='0' border='0'>"+
            "</td>";
}

Tree.prototype.getNameTd = function (node) {
	fontColor = !node.selective && this.makeNonSelectableGray ? "gray" : "black";
    res_str =
            "<td>"+
              "<div onclick=\""+this.getOnClickHref(node)+"\" "+
                "onDblClick=\""+this.onDblClickNodeHandler+"('"+node.selective+"')\" "+
                "oncontextmenu=\"return "+this.objName+".popupMenu(event, '"+node.menuType+"','"+node.id+"','"+node.onSelectFunction+"');\">"+
                  "<font color='"+fontColor+"'><div id='name"+node.id+"' class='treediv'><a href='#'>"+node.name+"</a></div></font>"+
              "</div>"+
            "</td>";
    return res_str;
}

Tree.prototype.moreOrLessHtml = function (node) {
	funcName = "MORE"==node.id ? "doMore" : "doLess";

	return	"<table border=0 cellpadding=0 cellspacing=0>"+
    	"<tr><td class='treeicon'> </td>"+
             "<td><div onclick=\"javascript:"+this.objName+"."+funcName+"('"+node.parentID+"','"+this.currentTreeId+"')\" class='treediv' ><a href='#'>"+
				node.name+
    	"</a></div></td></tr></table>";
}

Tree.prototype.leafHtml = function (node) {
    rhtml =
    "<table border=0 cellpadding=0 cellspacing=0>"+
        "<tr><td class='treeicon'>"+
                "<div id=\"x"+node.id+"\">"+
                "</div>"+
            "</td>";
    if (node.iconPath)
        rhtml += this.getIconTd(node);

    rhtml += this.getNameTd(node);
    rhtml +=
        "</tr>"+
    "</table>";
    rhtml += "<div id=\""+node.id+"\" style=\"display:none;\" class=\"treenode_none\"></div>";
    return rhtml;
}

Tree.prototype.nodeHtml = function (node) {
    toggleIcon = node.isOpened ? "minus" : "plus";

    rHtml =
    "<table border=0 cellpadding=0 cellspacing=0>"+
        "<tr>"+
            "<td class='treeicon'>"+
                "<div id=\"x"+node.id+"\">"+
                "<img onclick=\"javascript:"+this.objName+".Toggle('"+node.id+"',"+node.childsCount+");\" src='"+this.relPathToTreeDir+toggleIcon+".gif'"+
                " width1='18' height1='18' hspace='0' vspace='0' border='0'>"+
                "</div>"+
            "</td>";

    if (node.iconPath)
        rHtml += this.getIconTd(node);

    rHtml += this.getNameTd(node);
    rHtml +=
        "</tr>"+
    "</table>";

    return rHtml;
}

Tree.prototype.subnodesHtml = function (nodes) {
    rHtml = "";

	prevIsNode = false;
    prevDeep = 0;
    for (q=0; q<nodes.length; q++) {
        node = nodes[q];

        deepDifference = node.deep - prevDeep;
        prevDeep = node.deep;

        if (prevIsNode) deepDifference--;

        while ( deepDifference++ < 0 )
           rHtml += "</div>";

        prevIsNode = !node.isLeaf;
        if (!node.isLeaf) {
            rHtml += this.nodeHtml(node)

            displayStyle = node.isOpened ? "block" : "none";
            rHtml += "<div id=\""+node.id+"\" style=\"display:" + displayStyle  + ";\" class=\"treenode_"+displayStyle+"\">";

		} else if ( "MORE"==node.id || "LESS"==node.id ) {
			rHtml += this.moreOrLessHtml(node);
		} else { // just a node
            rHtml += this.leafHtml(node);
        }
    }

    return rHtml;
}

Tree.prototype.updateMenusHandler = function (menus) {
    sHtml = "";

    for (mindex = 0; mindex < menus.length; mindex++) {
        sHtml += "<div id='MenuType" + (mindex+1) + "' class='popupmenu'>";

        items = menus[mindex];

        for (i = 0; i < items.length; i++ ) {
            curItem = items[i];
            sHtml += "<div onclick=\"javascript:"+this.objName+".executeMenuItem('"+curItem.action+"')\">"+
                     "<p onmouseenter=\"this.className='popupmenu_current_item'; font"+mindex+"_"+i+".color='white';\" "+
                        "onmouseleave=\"this.className=''; font"+mindex+"_"+i+".color='black';\">"+
                       "<font id=\"font"+mindex+"_"+i+"\">"+curItem.name+"</font>"+
                     "</p></div>";
        }

        sHtml += "</div>";
    }

    var span = document.getElementById("menuList");
    if (span && typeof(span) != 'undefined') span.innerHTML = sHtml;
}

Tree.prototype.popupMenu = function (e, typeNumber, nodeId, onSelectFunctionName) {
	if ( typeNumber<=0 ) return false;

    this.setCurrentNode(nodeId, onSelectFunctionName);

    if (document.all) e=window.event;
    e.cancelBubble=true;
    this.hideCurrentMenu();
    if (!document.all) {
        this.currentMenu = document.getElementById('MenuType'+typeNumber);
        this.currentMenu.style.display = 'block';

        var _left = e.pageX;
        if( (_left + this.currentMenu.clientWidth ) > document.body.clientWidth ) _left -= this.currentMenu.clientWidth;
        var _top = e.pageY;
        this.currentMenu.style.left = _left+'px';
        this.currentMenu.style.top  = _top+'px';
    }
    else {
        this.currentMenu = document.getElementById('MenuType'+typeNumber);
        this.currentMenu.style.display = 'block';

        var _left = e.clientX+document.body.scrollLeft;
        if( (_left + this.currentMenu.clientWidth ) > document.body.clientWidth ) _left -= this.currentMenu.clientWidth;
        var _top = e.clientY+document.body.scrollTop;
        this.currentMenu.style.left = _left+'px';
        this.currentMenu.style.top  = _top+'px';

    }
    return false;
}

Tree.prototype.hideCurrentMenu = function () {
    if (this.currentMenu) {
        this.currentMenu.style.display = 'none';
        this.currentMenu = null;
    }
}

Tree.prototype.executeMenuItem = function executeMenuItem(action) {
    this.hideCurrentMenu();
    eval(action+"('"+this.currentNodeId+"')");
}

Tree.prototype.setUpDND = function(nodeId) {
	if ( this.dragSupportEnable ) {
		clearDNDValues(this);
		parentId = this.getParentNodeId(nodeId);

		shouldBeProcessed = false;
		for ( ind=0; ind < this.draggableParents.length; ind++ )
			if ( this.hasAncestor(nodeId, this.draggableParents[ind]) ) {
				shouldBeProcessed = true;
				break;
			}

		if ( shouldBeProcessed ) {
			this.previousDraggable = new Draggable( "name"+nodeId, { revert:true } );

			tmpNodeId = nodeId;
			do {
				tmpNodeId = this.getNextNodeId(tmpNodeId);
				if (tmpNodeId)
					this.addDroppable(tmpNodeId, parentId);
			} while (tmpNodeId);

			tmpNodeId = nodeId;
			do {
				tmpNodeId = this.getAboveNodeId(tmpNodeId);
				if (tmpNodeId!=parentId)
					this.addDroppable(tmpNodeId, parentId);
			} while (tmpNodeId!=parentId);
		}
	}
}

Tree.prototype.addDroppable = function(nodeId, parentId) {
	if (nodeId!=parentId) {
		Droppables.add("name"+nodeId, {onDrop: onDrop});
		if ($(nodeId))
			Droppables.add( nodeId, {onDrop: onDrop} );
	}
	this.previousDroppable[this.previousDroppable.length] = "name"+nodeId;
	if ($(nodeId))
		this.previousDroppable[this.previousDroppable.length] = nodeId;
}

// this should be out of the class
function clearDNDValues(tree) {
	if ( tree.previousDraggable ) {
		tree.previousDraggable.destroy();
		tree.previousDraggable = null;
	}

	if ( tree.previousDroppable ) {
		for (q=0; q<tree.previousDroppable.length; q++)
			Droppables.remove(tree.previousDroppable[q]);

		tree.previousDroppable = new Array();
	}
}

Tree.prototype.updateDraggableParents = function(nodes) {
	for (nIndex=0; nIndex<nodes.length; nIndex++) {
		node = nodes[nIndex];

		found = false;
		dIndex = 0;
		for (p=0; p<this.draggableParents.length; p++)
			if (this.draggableParents[p]==node.id) {
				found = true;
				dIndex = p;
				break;
			}


		if (node.draggableChilds) { // check add draggable parents
			if (!found)
				this.draggableParents[this.draggableParents.length] = node.id;
		} else { // check remove
			if (found)
				this.draggableParents[dIndex] = null;
		}
	}
}

Tree.prototype.lTrim = function (text) {
	if (text==null) {
		text=''
	} else {
		var first = text.charAt(0);
		while(first==' ' || first=='\r' || first=='\n' || first=='\t'){
			text = text.substring(1,text.length);
			first  = text.charAt(0);
		}
	}
	return text;
}


Tree.prototype.allTrim = function (text) {
	if(text==null || text.length<1) return "";
	text = this.lTrim(text);
	var pos = text.length - 1;
	while(text.charAt(pos)==' ' || text.charAt(pos)=='\r' || text.charAt(pos)=='\n' || text.charAt(pos)=='\t') {
		text = text.substring(0,pos);
		pos--;
	}
	return text;
}

Tree.prototype.toStringFromHtml = function (str) {
    str=str.replace(/&lt;/gi,'<');
    str=str.replace(/&gt;/gi,'>');
    str=str.replace(/&quot;/gi,'"');
    str=str.replace(/&#39;/gi,"'");
    str=str.replace(/&amp;/gi,'&');
    return str;
}

function getObjectById( treeId, itemId ){
    var obj = document.getElementById(itemId);
    if( !obj ) obj =  document.getElementById(treeId + "_" + itemId);
    return obj;
}