function login() {

        $.ajax({
            type: "post",
            url: "/user/login",
            contentType: "application/json", //必须有
            async: true,
          /*  data: $("#fm").serialize(),*/
           data:"number="+number+"&password="+password,
            success: function (res) {
               Window.location.href=res;
            },
            error: function () {
                alert("failure");
            }

        })


}

