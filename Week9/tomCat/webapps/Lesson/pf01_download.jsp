<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h2>Paddlefoot - The First CD</h2>

<table>
  <tr>
    <th>Song title</th>
    <th>Audio Format</th>
  </tr>
  <tr>
    <td>64 Corvair</td>
    <td><a href="musicStore/sound/${productCode}/corvair.mp3">MP3</a></td>
  </tr>
  <tr>
    <td>Whiskey Before Breakfast</td>
    <td><a href="musicStore/sound/${productCode}/whiskey.mp3">MP3</a></td>
  </tr>
</table>

<p><a href="?action=viewAlbums">View list of albums</a></p>
<p><a href="?action=viewCookies">View all cookies</a></p>

<jsp:include page="footer.jsp"/>
