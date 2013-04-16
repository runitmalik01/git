function UMItem(id,name,typeId,typeName) {
	this.id = id != null ? id : "";
	this.name = name != null ? name : "";
	this.typeId = typeId != null ? typeId : "";
	this.typeName = typeId != null ? typeName : "";
}
function UMType(id,name,items) {
	this.id = id != null ? id : "";
	this.name = name != null ? name : "";
	this.getItems = items != null ? items : new Array();
	UMType.prototype.toString  = UMTypeToString;
}
function UMTypeToString() {
	toStr = this.name;
	toStr += ": ";
	for (var i in this.getItems) {
		if (i > 0) {
			toStr += ", ";
		}
		toStr += this.getItems[i].name;
	}
	return toStr;
}
function evolveTypes(arrayUMItems) {
	arrayUMTypes = new Array();
	if (arrayUMItems != null) {
		for (i=0;i < arrayUMItems.length;i++) {
			uMItem = arrayUMItems[i];
			indexType = findUMItem(arrayUMTypes,uMItem.typeId);
			if (indexType != -1) {
				arrayUMTypes[indexType].getItems.push(uMItem);
			} else {
				uMType = new UMType(uMItem.typeId,uMItem.typeName)
				uMType.getItems.push(uMItem);
				arrayUMTypes.push(uMType);
			}
		}
	}
	return arrayUMTypes;
}
function evolveItemsFromTypes (arrayUMTypes, segmentTypeId) {
	arrayUMItems = new Array();
	if (arrayUMItems != null) {
		if (arrayUMTypes.length > 0) {
			for (var i in arrayUMTypes) {
				if (segmentTypeId == "" || segmentTypeId == null || arrayUMTypes[i].id == segmentTypeId){
				arrayUMItems = arrayUMItems.concat(arrayUMTypes[i].getItems);
			}
		}
	}
	}
	return arrayUMItems;
}
function findUMItem (arrayUMItem,itemId) {
	if (arrayUMItem == null || arrayUMItem.length == 0) {
		return -1;
	}
	for (var i in arrayUMItem) {
		if (arrayUMItem[i].id == itemId) {
			return i;
		}
	}
	return -1;
}