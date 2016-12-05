<%@include file="../header.jsp"%>

<h1> Add Client </h1>

<form method="post" action="${SITE_URL}/admin/client/save">
    
    <div class="form-group">
    <label>Name</label>
    <input name="name" required="required" type="text" class="form-control" />
    </div>
    <br/>
    <div class="form-group">
    <label>Email</label>
    <input name="email" required="required" type="email" class="form-control"/>
    </div>
    <br/>
    <div class="form-group">
    <label>Contact No</label>
    <input name="contactNo" required="required" class="form-control" />
    </div>
    <br/>
    <div class="checkbox">
    <label>Status</label> 
    <label> <input type="checkbox" name="status" <c:if test="unchecked">${client.setStatus=false}</c:if> >Active</label>
    </div>
    <br/>
    <div>
    <button class="btn btn-primary">Save</button>  
    </div>
</form>
<!-- Very VI The name of the inputs' names  and the names in the clients must match with each other -->
<!-- Such as contactNo must be similiar in the entity i.e. Client.java too-->



<%@include file="../footer.jsp"%>