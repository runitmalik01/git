<%@page session="false"
            contentType="text/html; charset=utf-8"
            import="java.io.IOException,
                    java.io.InputStream,
        java.io.OutputStream,
        javax.servlet.ServletContext,
        javax.servlet.http.HttpServlet,
        javax.servlet.http.HttpServletRequest,
        javax.servlet.http.HttpServletResponse,
        java.io.File,
        java.io.FileInputStream"
 %>
<%  
//Set the headers.
String fileName = (String) request.getAttribute("fileName");
response.setContentType("application/x-download"); 
response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
String filePath = (String) request.getAttribute("filePath");

File file = new File(filePath);
FileInputStream fileIn = new FileInputStream(file);
ServletOutputStream outstream = response.getOutputStream();

byte[] outputByte = new byte[40096];

while(fileIn.read(outputByte, 0, 40096) != -1)
{
    outstream.write(outputByte, 0, 40096);
}
fileIn.close();
outstream.flush();
outstream.close();

%>