$("#add").click(function(){
    alert("1");
    $.ajax({
        url:"/dishes/add",
        type:"POST",
        dataType:"json",
        data:{disheName:$("#dishesName2").val(),disheDes:$("#dishesDes2").val()},
        success:function(data){
            if (data.code == 0) {
                alert("添加成功");
            } else {
                alert("添加失败");
            }
        }
    });
});