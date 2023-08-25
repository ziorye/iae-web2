<%--
  Created by IntelliJ IDEA.
  User: who-am-i
  Date: 8/25/23
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html class="h-100">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <meta name="description" content="有想法就去做，努力将想法变成现实">
    <meta name="keywords" content="学,做,学习,实作">
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" %>">
    <link rel="stylesheet" href="build/assets/app.css"></link>
</head>
<body class="d-flex flex-column h-100">
<header>
    <nav class="navbar navbar-expand-lg navbar-light navbar-site mb-2rem">
        <div class="container">
            <a class="navbar-brand" href="login" title="example">
                <svg class="align-top" width="93px" height="32px" viewBox="0 0 278.188 90.5" xmlns="http://www.w3.org/2000/svg">
                    <g id="xz-logo" transform="translate(-1185.953 -542)">
                        <path id="lt" transform="translate(1184 614)" fill="#212529" d="M1.953-25.1a12.346,12.346,0,0,1,1.953-6.445,31.025,31.025,0,0,1,5.176-6.3A51.134,51.134,0,0,1,16.406-43.6a73.862,73.862,0,0,1,8.35-4.736,53.007,53.007,0,0,1,8.3-3.223,25.987,25.987,0,0,1,7.08-1.172,9.818,9.818,0,0,1-1.416,5.176,18.77,18.77,0,0,1-3.76,4.395,48.709,48.709,0,0,1-5.225,3.955q-2.881,1.9-5.664,3.76T18.75-31.543a19.858,19.858,0,0,0-4.1,4.395,1.06,1.06,0,0,1-.2.391v1.172a3.789,3.789,0,0,0,.2.488,5.388,5.388,0,0,1,.928.977A4.47,4.47,0,0,0,16.7-23.047a25.809,25.809,0,0,0,2.295,1.465q1.807,1.074,4.2,2.637t5.078,3.223q2.686,1.66,5.029,3.223t4.1,2.686Q39.16-8.691,39.844-8.3a7.186,7.186,0,0,1,1.025.928A7.186,7.186,0,0,1,41.8-6.348a1.843,1.843,0,0,0,.1.586,1.336,1.336,0,0,0,.049.293,1.336,1.336,0,0,1,.049.293.8.8,0,0,1-.049.244.8.8,0,0,0-.049.244,1.607,1.607,0,0,0-.1.488,6.594,6.594,0,0,1-.879,1.172q-.684.781-1.318,1.416T38.379-.488A1.871,1.871,0,0,1,37.6,0a15.722,15.722,0,0,1-4.834-1.221,66.153,66.153,0,0,1-7.227-3.271Q21.582-6.543,17.432-9.18a78.91,78.91,0,0,1-7.617-5.469A38.4,38.4,0,0,1,4.15-20.215,8.212,8.212,0,0,1,1.953-25.1Z"/>
                        <g id="xz">
                            <path id="x" transform="translate(1261 621.987)" fill="#212529" stroke="#212529" stroke-width="1" d="M3.418-1.66a17.419,17.419,0,0,1-.781-7.227,29.807,29.807,0,0,1,1.611-6.885,48.723,48.723,0,0,1,3.027-6.689q1.807-3.32,3.32-6.592a43.683,43.683,0,0,0,2.441-6.592,17.448,17.448,0,0,0,.537-6.738q-.1-.684-.391-2.637t-.635-4.541q-.342-2.588-.732-5.566t-.732-5.566q-.342-2.588-.635-4.541a22.534,22.534,0,0,1-.293-2.539,15.281,15.281,0,0,1,.635-6.738,11.408,11.408,0,0,1,2.393-4.2,3.423,3.423,0,0,1,2.588-1.27q1.221.1,1.221,1.953-.1,1.27-.146,4.395T16.8-66.943q0,3.564.049,6.689t.146,4.395a8.229,8.229,0,0,0,.2,1.367q.2.977.439,2.051t.537,2a5.64,5.64,0,0,0,.488,1.221q5.664-9.18,11.67-13.916t11.23-5.811a13.355,13.355,0,0,1,9.131.977,10.845,10.845,0,0,1,5.371,6.445q1.465,4.395.049,10.645T49.219-37.3a22.549,22.549,0,0,1-7.227,6.641,18.947,18.947,0,0,1-7.275,2.246,23.755,23.755,0,0,1-6.836-.391q-3.271-.684-5.859-1.27a18.027,18.027,0,0,0-4.346-.537,2.374,2.374,0,0,0-2.344,1.807q-.488,1.367-1.318,3.955T12.4-19.531Q11.621-16.8,10.938-14.6t-.781,2.686a10.735,10.735,0,0,0-.146,3.223,17.668,17.668,0,0,1-.146,3.955,7.515,7.515,0,0,1-1.318,3.32A3.993,3.993,0,0,1,5.078,0q-.2,0-.83-.635A4.511,4.511,0,0,1,3.418-1.66Zm23.73-32.227a7.84,7.84,0,0,0,5.859,1.953,14.3,14.3,0,0,0,5.957-1.953,25.421,25.421,0,0,0,7.422-6.494,25.337,25.337,0,0,0,4.053-7.666,21.271,21.271,0,0,0,1.025-7.52,12.931,12.931,0,0,0-1.709-6.1,7.538,7.538,0,0,0-4.15-3.369,8.59,8.59,0,0,0-6.2.684A28,28,0,0,0,31.4-58.35,69.066,69.066,0,0,0,21.973-45.8a9.436,9.436,0,0,0-.781,3.906,6.785,6.785,0,0,0,.928,3.076,10.22,10.22,0,0,0,2.2,2.588Q25.684-35.059,27.148-33.887Z"/>
                            <path id="z" transform="translate(1324 644.732)" fill="#DE3712" stroke="#DE3712" stroke-width="1" d="M6.836-37.3a8.175,8.175,0,0,1-2.295-1.709,10.633,10.633,0,0,1-2-2.783,6.37,6.37,0,0,1-.732-3.076,3.239,3.239,0,0,1,1.611-2.588L45.8-76.27a13.1,13.1,0,0,0,4.1-3.711,2.308,2.308,0,0,0,.1-2.637,5.378,5.378,0,0,0-2.881-1.709,29.366,29.366,0,0,0-4.883-.977,48.955,48.955,0,0,0-5.957-.342q-3.174,0-6.006.1t-5.078.342a20.058,20.058,0,0,0-3.223.537q-2.93.781-3.467-.146t.537-2.344a11.859,11.859,0,0,1,3.32-2.783A10.665,10.665,0,0,1,27.148-91.5q1.27-.1,4.053-.2t6.152.1a55.9,55.9,0,0,1,6.836.83,21.009,21.009,0,0,1,6.055,2,9.011,9.011,0,0,1,3.809,3.564,6.79,6.79,0,0,1,.146,5.518,5.427,5.427,0,0,1-.537,1.172q-.439.781-.977,1.611t-1.074,1.514a3.449,3.449,0,0,1-.732.781l-37.3,25.391a11.036,11.036,0,0,0-1.9,2.051,9.193,9.193,0,0,0-1.562,2.93,3.2,3.2,0,0,0,.2,2.588q.635,1.123,3.271.928a37.2,37.2,0,0,0,4.395.244q3.125.049,6.641.049t6.641-.049a37.2,37.2,0,0,0,4.395-.244,11.081,11.081,0,0,0,2.051-.391q1.563-.391,3.613-.928t4.443-1.123q2.393-.586,4.443-1.123t3.613-.977q1.563-.439,2.051-.537h3.418a6.641,6.641,0,0,1,.146,2.93,2.455,2.455,0,0,1-1.807,2.148q-4.395,1.172-10.986,2.783a133.455,133.455,0,0,1-13.818,2.588A86.88,86.88,0,0,1,18.7-34.57,27.6,27.6,0,0,1,6.836-37.3Z"/>
                            <path id="dot" transform="translate(1345.367 632)" fill="#DE3712" stroke="#DE3712" stroke-width="1" d="M5.047-1.129a3.519,3.519,0,0,1-.332-2.424A6.4,6.4,0,0,1,5.777-5.977,8.51,8.51,0,0,1,7.7-7.936,4.826,4.826,0,0,1,10.061-8.9a3.64,3.64,0,0,1,2.357.564,5.035,5.035,0,0,1,1.859,2.557,3.1,3.1,0,0,1,.1,2.225,4.706,4.706,0,0,1-1.229,1.926A7.657,7.657,0,0,1,11.09-.232a7.514,7.514,0,0,1-2.357.7A4.83,4.83,0,0,1,6.541.232,2.519,2.519,0,0,1,5.047-1.129Z"/>
                        </g>
                        <path id="gt" transform="translate(1416 616)" fill="#212529" d="M8.3-4.2A9.354,9.354,0,0,1,9.668-8.3a44.377,44.377,0,0,1,3.516-5.42q2.148-2.881,4.639-5.957t4.834-5.859Q25-28.32,26.758-30.42T29.3-33.5a2.1,2.1,0,0,1,.1-.537,2.1,2.1,0,0,0,.1-.537l-.1-.488a1.087,1.087,0,0,1-.1-.488,5.558,5.558,0,0,0-.977-1.172,5.558,5.558,0,0,0-1.172-.977q-.586-.391-2.344-1.465T20.7-41.8q-2.344-1.563-5.029-3.223t-5.029-3.174Q8.3-49.707,6.543-50.83A21,21,0,0,0,4.1-52.246a5.646,5.646,0,0,1-2-2.051,6.363,6.363,0,0,1-.537-2.832,37.6,37.6,0,0,1,6.885.83,92.015,92.015,0,0,1,8.936,2.246q4.688,1.416,9.473,3.369a62.168,62.168,0,0,1,8.594,4.248A30.343,30.343,0,0,1,41.7-41.6a7.353,7.353,0,0,1,2.441,4.98,2.1,2.1,0,0,1-.1.537,2.1,2.1,0,0,0-.1.537q-.879,1.074-2.637,3.174t-4,4.834q-2.246,2.734-4.736,5.713t-4.785,5.615q-2.295,2.637-4.15,4.785T20.9-8.3q-1.465,1.66-2.344,2.832a23.515,23.515,0,0,1-1.611,1.953,4.835,4.835,0,0,1-1.66,1.172,6.863,6.863,0,0,1-2.588.391q-.391,0-1.123-.049a7.649,7.649,0,0,1-1.465-.244,3.331,3.331,0,0,1-1.27-.635A1.6,1.6,0,0,1,8.3-4.2Z"/>
                    </g>
                </svg>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="切换导航">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!-- Left Side Of Navbar -->
                <ul class="navbar-nav mr-auto">
                </ul>

                <!-- Right Side Of Navbar -->
                <ul class="navbar-nav ml-auto d-flex align-items-lg-center">
                    <li class="nav-item">
                        <a class="nav-link d-flex align-items-center " href="login#">
                            <svg class="mr-2 mb-0" width="16" height="16" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5 8 5.961 14.154 3.5 8.186 1.113zM15 4.239l-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923l6.5 2.6zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464L7.443.184z"/>
                            </svg>
                            简历
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link d-flex align-items-center " href="login#">
                            <svg class="mr-2 mb-0" width="16" height="16" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                <path d="M3 5.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 8zm0 2.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z"/>
                            </svg>
                            博客
                        </a>
                    </li>


                    <li class="nav-item"><a href="login" class="btn btn-sm btn-primary transition-3d-hover my-3 my-lg-0">登录</a></li>
                </ul>
            </div>
        </div>
    </nav>


</header>

<div class="container" id="main_content">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">登录</div>

                <div class="card-body">
                    <p class="text-center text-muted font-size-12"><span class="text-primary">✔（推荐方案）</span>使用第三方账号登录</p>
                    <p class="text-center">
                        <a class="btn btn-outline-primary" href="login#" role="button">
                            <svg class="bi bi-github" width="20" height="20" viewBox="0 0 20 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"></path>
                            </svg>
                            GitHub
                        </a>
                    </p>
                    <p class="mt-5 text-center text-muted font-size-12">（备选方案）邮箱、密码登录</p>
                    <c:if test="${error != null}">
                        <p class="text-center text-primary">${error}</p>
                    </c:if>

                    <form method="POST" action="login">
                        <div class="form-group row">
                            <label for="email" class="col-md-4 col-form-label text-md-right">邮箱</label>

                            <div class="col-md-6">
                                <input id="email" type="email" class="form-control " name="email" value="" required autocomplete="email" autofocus>

                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="password" class="col-md-4 col-form-label text-md-right">密码</label>

                            <div class="col-md-6">
                                <input id="password" type="password" class="form-control " name="password" required autocomplete="current-password">

                            </div>
                        </div>


                        <div class="form-group row">
                            <div class="col-md-6 offset-md-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="remember-me" id="remember-me" >

                                    <label class="form-check-label" for="remember-me">
                                        记住我
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row mb-0">
                            <div class="col-md-8 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    登录
                                </button>

                                <a class="btn btn-link font-size-12 text-muted" href="login#">
                                    忘记密码
                                </a>

                                <a class="btn btn-link font-size-12 text-muted" href="login#">
                                    注册新账号
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="blog-footer mt-auto">
    <div class="container text-muted">
        <p class="text-center text-lg-left">
            <span>Designed by <a href="login#">@you</a> - From X to Z</span>
        </p>
    </div>
</footer>
<script type="module" src="build/assets/app.js"></script>
</body>
</html>