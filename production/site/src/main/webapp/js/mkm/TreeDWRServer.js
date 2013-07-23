
function TreeDWRServer() { }
TreeDWRServer._path = '/selfservice/dwr';

TreeDWRServer.getSubnodes = function(p0, p1, p2, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'getSubnodes', p0, p1, p2, callback);
}

TreeDWRServer.moreNodes = function(p0, p1, p2, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'moreNodes', p0, p1, p2, callback);
}

TreeDWRServer.lessNodes = function(p0, p1, p2, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'lessNodes', p0, p1, p2, callback);
}

TreeDWRServer.expandNodes = function(p0, p1, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'expandNodes', p0, p1, callback);
}

TreeDWRServer.getMenus = function(p0, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'getMenus', p0, callback);
}

TreeDWRServer.expandNode = function(p0, p1, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'expandNode', p0, p1, callback);
}

TreeDWRServer.collapseNode = function(p0, p1, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'collapseNode', p0, p1, callback);
}

TreeDWRServer.setSelectedNode = function(p0, p1, callback) {
    DWREngine._execute(TreeDWRServer._path, 'TreeDWRServer', 'setSelectedNode', p0, p1, callback);
}
