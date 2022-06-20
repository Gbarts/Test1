<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../includes/header.jsp" %>    

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시판 목록보기 <a href="/board/register">글등록</a> &nbsp;&nbsp;&nbsp;&nbsp; 총글개수(${pageMaker.total}) <a href="/board/ranking"> 랭킹 </a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>글번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
   
<c:forEach var="board" items="${list}" >              
                                  <tr class="odd gradeX">
                                   <td>${board.bno}</td>
                                   <td><a href="/board/get?bno=${board.bno}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}">${board.title}</a></td>
                                   <td><c:out value="${board.writer}"/></td>
                                   <td><fmt:formatDate pattern="yyy-MM-dd" value="${board.regdate }"/></td>
                                   <td><fmt:formatDate pattern="MM-dd hh:mm" value="${board.updatedate}"/></td>
                                 </tr>
 </c:forEach>     
                                   </tbody>
                            </table>
                             <c:if test="${pageMaker.prev}">
                            <a href="/board/list?pageNum=${pageMaker.startPage-1}&&amount=${pageMaker.cri.amount}"> << </a>  &nbsp;&nbsp;&nbsp;&nbsp;
                            </c:if>
                            
                            <c:forEach begin="${pageMaker.startPage}"  end="${pageMaker.endPage}" var="num">
                            	 <a href="/board/list?pageNum=${num}&amount=${pageMaker.cri.amount}">
                       <%-- 	 현재페이지를 ${param.pageNum } or ${pageMaker.cri.pageNum } or ${critera.pageNum } --%>
                            	 
                            	<c:if test="${pageMaker.cri.pageNum == num }">
                            	<b>${num}</b> 
                            	 </c:if>
                            	 
                            	<c:if test="${pageMaker.cri.pageNum != num }">
                         			${num}
                            	 </c:if>
                            	 </a> &nbsp;&nbsp;&nbsp;&nbsp;
                            </c:forEach>
                            
                            <c:if test="${pageMaker.next}">
                            	<a href="/board/list?pageNum=${pageMaker.endPage+1}&&amount=${pageMaker.cri.amount}"> >> </a>
                            </c:if>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                              ${bno}번 글이 등록되었습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->




    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

<script>
//입력된 글번호 알려주기
var bno = "${bno}";  //읽히는 순서 page->request->session->application
var state ="${state}";
console.log("등록된 글번호는:"+bno);


//알고있어야 하는내용
//1.history.replaceState(data,title,url) 히스토리 상태값을 변경해주는 메소드
//2.history.state 히스토리상태값을 읽는것(history.replaceState()미사용시 null)
if(history.state){//javascript에소는 null이면 false
	console.log("히스토리 상태값이 있다.");
} else {
	console.log("히스토리 상태값이 없다.");
}

history.replaceState({},null,null);

if(bno!=""){   //글번호가 있고
		$("#myModal").modal("show");
}
if(state=="remove"){
	$(".modal-body").text("삭제가 정상적으로 처리되었습니다.");
	$("#myModal").modal("show");
}else if(state=="modify"){
	$(".modal-body").text("수정이 정상적으로 처리되었습니다.");
	$("#myModal").modal("show");
}
</script>


</body>






</html>
