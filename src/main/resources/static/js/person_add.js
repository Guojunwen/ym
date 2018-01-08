$(".close").click(function(){
    $("#warn").alert();
});
function backIndex() {
    window.history.go(-1);
}
function savePerson() {
    var params = $("#editForm").serialize();
    $.ajax({
        url: "sys/person/save",
        data: params,
        dataType:"json",
        success: function (result) {
            alert("success: " + result.msg);
            self.location=document.referrer;
        }
    });
};