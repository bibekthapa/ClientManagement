


<%@include file="header.jsp"%>




<div class="pull-right">
    <p>
    <a href="${SITE_URL}/admin/client/add" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>
    
    
    </a>
    </p>
        
    
   
    
    
</div>

<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact Number</th>
        <th>Added Date</th>
        <th>Status</th>   
        <th>Action</th>
    </tr>
    <c:forEach var="client" items="${clients}">
    <tr>
        <td>${client.id}</td>
        <td>${client.name}</td>
        <td>${client.email}</td>
        <td>${client.contactNo}</td>
        <td>${client.addedDate}</td>
        <td>
            <c:choose>
            <c:when test="${client.status}">
                Active
            </c:when>
            <c:otherwise>
                Inactive
            </c:otherwise>
            </c:choose>
           </td>
           <td>
               
               <a href="${SITE_URL}/admin/client/edit/${client.id}" class="btn btn-success">
                   <span class="glyphicon glyphicon-pencil" ></span>
               </a>              
               <label>  </label>
               <label>  </label>
              
               <a href="${SITE_URL}/admin/client/delete/${client.id}" class="btn btn-danger" onclick="return confirm('Are you sure to Delete')">
               <span class="glyphicon glyphicon-trash"></span>
               </a>
              
               
               
           </td>
        
        
    </tr>
    </c:forEach>
    
</table>




<%@include file="footer.jsp" %>