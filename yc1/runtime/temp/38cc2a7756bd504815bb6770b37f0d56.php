<?php if (!defined('THINK_PATH')) exit(); /*a:2:{s:46:"D:\yc1/application/admin\view\login\index.html";i:1499782200;s:46:"D:\yc1/application/admin\view\public\base.html";i:1499781956;}*/ ?>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            X-admin v1.0
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="/public/Admin/css/x-admin.css" media="all">
    </head>
    
    
   
    <body style="background-color: #393D49">
        <div class="x-box">
            <div class="x-top">
                <i class="layui-icon x-login-close">
                    &#x1007;
                </i>
                <ul class="x-login-right">
                    <li style="background-color: #F1C85F;" color="#F1C85F">
                    </li>
                    <li style="background-color: #EA569A;" color="#EA569A">
                    </li>
                    <li style="background-color: #393D49;" color="#393D49">
                    </li>
                </ul>
            </div>
            <div class="x-mid">
               
                <div class="input">
                    <form  method="post" action="<?php echo url('Admin/login/index'); ?>"  class="layui-form">
                        <div class="layui-form-item x-login-box">
                            <label for="username" class="layui-form-label">
                                <i class="layui-icon">&#xe612;</i>
                            </label>
                            <div class="layui-input-inline">
                                <input type="text" id="username" name="username" required="" lay-verify="username"
                                autocomplete="off" placeholder="username" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item x-login-box">
                            <label for="pass" class="layui-form-label">
                                <i class="layui-icon">&#xe628;</i>
                            </label>
                            <div class="layui-input-inline">
                                <input type="password" id="pass" name="password" required="" lay-verify="pass"
                                autocomplete="off" placeholder="******" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item x-login-box">
                            <label for="pass" class="layui-form-label">
                                <i class="layui-icon">&#xe60a;</i>
                            </label>
                            <div class="layui-input-inline">
                                <input type="text" id="pass" name="captcha" required="" lay-verify="pass"
                                autocomplete="off" placeholder="验证码" class="layui-input">
                            </div>
                        </div>
                         <div class="layui-form-item x-login-box">
                            <label for="pass" class="layui-form-label">
                                <i class="layui-icon"></i>
                            </label> 
                            <img style="cursor:pointer"src="<?php echo captcha_src('Admin/Login/captcha'); ?>"  onclick="this.src='<?php echo captcha_src('Admin/Login/captcha'); ?>'+Math.random();"/>
                      </div>
                        <div class="layui-form-item" id="loginbtn">
                            <button  class="layui-btn" lay-filter="save" lay-submit="">
                                登 录
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <p style="color:#fff;text-align: center;">Copyright © 2017.Company name All rights X-admin </p>
        <script src="/public/Admin/lib/layui/layui.js" charset="utf-8">
        </script>
     
    </body>


<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->




    </html>