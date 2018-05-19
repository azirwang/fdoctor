<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
<script src="js/jquery-1.7.2.min.js"></script>
</head>
<body>
<button id="bid" click="a">获取总数</button>
<span id="massage"></span>
</body>
</html>
<script type="text/javascript">
    $("#bid").click(function(){
    	$.post('/fdoctor/service/getFoodCountById.do',{
    		foodId : "10111"
		},function(data){	
				$("#massage").text(data);
		},"json");
    });
</script>