<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h2>Paddlefoot - The Second CD</h2>

<table>
  <tr>
    <th>Song title</th>
    <th>Audio Format</th>
  </tr>
  <tr>
    <td>Neon Lights</td>
    <td><a href="musicStore/sound/${productCode}/neon.mp3">MP3</a></td>
  </tr>
  <tr>
    <td>Tank Hill</td>
    <td><a href="musicStore/sound/${productCode}/tank.mp3">MP3</a></td>
  </tr>
</table>

<p><a href="?action=viewAlbums">View list of albums</a></p>
<p><a href="?action=viewCookies">View all cookies</a></p>

<jsp:include page="footer.jsp"/>
