<!DOCTYPE html>
<html >  
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/contact_us_style.css">
    </head>
    <body>
        <div id="form-main" dir = "rtl">
            <div id="form-div">
                <form class="form" id="form1">
                    <p class="name" >
                        <input name="name" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="نام" id="name" />
                    </p>
                    <p class="email">
                        <input name="email" type="text" class="validate[required,custom[email]] feedback-input" id="email" placeholder="پست الکترونیکی" />
                    </p>
                    <p class="text">
                        <textarea name="text" class="validate[required,length[6,300]] feedback-input" id="comment" placeholder="نظر شما"></textarea>
                    </p>
                    <div class="submit">
                        <input type="submit" value="ارسال" id="button-red"/>
                        <div class="ease"></div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>