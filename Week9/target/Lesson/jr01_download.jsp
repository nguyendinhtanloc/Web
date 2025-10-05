<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<h2>Joe Rut - Genuine Wood Grained Finish</h2>

<table>
  <tr>
    <th>Song title</th>
    <th>Audio Format</th>
  </tr>
  <tr>
    <td>Filter</td>
    <td><a href="musicStore/sound/${productCode}/filter.mp3">MP3</a></td>
  </tr>
  <tr>
    <td>So Long Lazy Ray</td>
    <td><a href="musicStore/sound/${productCode}/so_long.mp3">MP3</a></td>
  </tr>
</table>

<p><a href="?action=viewAlbums">View list of albums</a></p>
<p><a href="?action=viewCookies">View all cookies</a></p>

<jsp:include page="footer.jsp"/>
