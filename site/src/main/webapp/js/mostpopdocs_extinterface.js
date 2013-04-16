function registerNS(ns)
{
 var nsParts = ns.split(".");
 var root = window;

 for(var i=0; i<nsParts.length; i++)
 {
  if(typeof root[nsParts[i]] == "undefined")
   root[nsParts[i]] = new Object();

  root = root[nsParts[i]];
 }
}
registerNS("com.knova.kb");
com.knova.kb.writemostpopdocs = function () {
	if ( typeof(com.knova.kb.mdocs) != 'undefined' && com.knova.kb.mdocs.length > 0)  {
		document.write("<ul class='knova_mostpopdocs'>");
		for (var i=0;i<com.knova.kb.mdocs.length;i++){
			document.write("<li>");
			document.write("<a target=\"_blank\" href=\"" + com.knova.kb.mdocs[i].url + "\">" + com.knova.kb.mdocs[i].title + "</a>");
			document.write("</li>");

		}
		document.write("</ul>");
	}
}