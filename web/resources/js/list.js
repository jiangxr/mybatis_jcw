/*
调用后台批量删除方法
 */
function deleteBatch(basePath) {
  const path = basePath + "DeleteBatchServlet.action";
  // document.getElementById("mainForm").setAttribute("action", path);
  // document.getElementById("mainForm")
  // console.log(path);
  // console.log($("#mainForm").attr("action"));
  $("#mainForm").attr("action", path);
  // console.log($("#mainForm").attr("action"));
  $("#mainForm").submit();
}