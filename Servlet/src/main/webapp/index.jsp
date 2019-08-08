<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <script src = "http://code.jquery.com/jquery-3.4.1.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>

    <script type = "text/javascript">
        $(document).ready(function(){
            $.get("/untitled-1/get_users",function(data){
                console.log(data);
                var str = "";
                for (var i = 0; i < data.length; i++) {
                    str += data[i].id + ")" + data[i].fio + data[i].phone + "<br>";
                }
                $(".users").html(str);
            });
        });
    </script>
    <body>
        <div class = "users"> </div>
    </body>
</html>