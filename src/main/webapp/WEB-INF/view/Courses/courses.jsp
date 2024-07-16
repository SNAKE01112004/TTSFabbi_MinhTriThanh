<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Minh Trí Thành</title>
    <link rel="stylesheet" href="/asset/css/course.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            list-style: none;
            text-decoration: none;
            border: 0px;
            outline: 0;
            appearance: none;
            font-family: Arial, Helvetica, sans-serif;
        }

        body {
            width: 100%;
            height: 100vh;
        }

        .container {
            width: 100%;
            height: 100%;
            margin: auto;
            display: grid;
            grid-template-columns: 17rem auto;
        }

        /* sidebar bên trái*/
        /* logo */
        aside {
            height: 100vh;
            width: 295px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            background-color: #fff;
            padding: 1rem;
        }

        .top-list-logo {
            width: 100%;
            margin: auto;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        .top-list-logo img {
            padding: 9px 0px;
            max-width: 100%;
            height: auto;
        }

        .top-list-logo span {
            width: 90%;
            border: 1px solid rgb(0, 0, 0, 0.1);
            margin-top: 1rem;
        }

        /* CSS chung cho sidebar */
        .sidebar {
            width: 100%;
            margin-top: .5rem;
        }

        .sidebar ul li {
            position: relative;
            width: 100%;
        }

        .sidebar ul li a {
            width: 100%;
            display: flex;
            align-items: center;
            gap: .7rem;
            padding: .5rem;
            border-radius: .4rem;
            padding: 15px;
            color: #000000; /* Màu chữ mặc định */
            text-decoration: none; /* Loại bỏ gạch chân */
        }

        .sidebar ul li a span {
            color: #000000;
        }

        .sidebar ul li a .title {
            font-size: 1rem;
        }

        .sidebar ul li a:focus,
        .sidebar ul li a:focus span,
        .sidebar ul li a:focus .title {
            background-color: rgb(254, 119, 27);
            color: #ffffff;
        }

        /* dropdown */
        .dropdown-content {
            display: none;
            width: 100%;
            background-color: #b4b4b4;
            z-index: 1;
        }

        /* Khi dropdown có lớp 'show', nó sẽ hiển thị */
        .dropdown-content.show {
            display: block;
        }

        .dropdown-content a:focus {
            background-color: rgb(254, 119, 27);
            color: #ffffff;
        }

        /* main */
        /* main-content */
        .main-content {
            width: 100%;
            margin-left: 1.2rem;
            padding: 1.2rem;
        }

        /* main-top */
        .main-top {
            width: 100%;
            padding: 1.6rem;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            border-radius: .4rem;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .main-navigation {
            margin-top: .7rem;
        }

        .main-information {
            display: flex;
            align-items: center;
            gap: .6rem;
            height: 100%;
        }

        .main-information-line {
            height: 100%;
            border: 1px solid rgba(0, 0, 0, 0.2);
        }

        .main-information-account img {
            width: 3.5rem;
            height: 3.5rem;
            border-radius: 50%;
        }

        /* main-second-top */
        .main-second-top {
            width: 100%;
            margin: auto;
            margin-top: 20px;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h3 {
            text-align: left;
        }

        .controls {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .filters {
            display: flex;
        }

        .filter-link {
            padding: 10px 10px;
            margin: 0 5px;
            color: black;
            text-decoration: none;
            font-weight: bold;
        }

        .filter-link.active {
            color: #FE771B;
        }

        .search-and-create {
            display: flex;
            align-items: center;
        }

        .search-and-create input {
            padding: 10px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 300px;
        }

        .create-button, .filter-button {
            padding: 10px 20px;
            margin: 0 5px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .create-button {
            background-color: #007bff;
            color: white;
        }
        .filter-button {
            background-color: #f0f0f0;
            color: black;
        }
        .program-table {
            width: 100%;
            border-collapse: collapse;
        }
        .program-table th, .program-table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .program-table th {
            background-color: #f0f0f0;
        }
        .status {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 12px;
            color: white;
        }

        .status.published {
            background-color: #28a745;
        }

        .status.draft {
            background-color: #ffc107;
        }

        .status.disabled {
            background-color: #dc3545;
        }

        .action-button {
            color: #007bff;
            text-decoration: none;
        }

        .action-button:hover {
            text-decoration: underline;
        }

        /* main-three-top */
        .main-three-top {
            width: 100%;
            margin-top: 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .page {
            display: flex;
            justify-content: center;
            list-style-type: none;
            padding: 0;
            margin: 20px 0;
        }
        .page li {
            margin: 0 5px;
        }
        .page li a {
            display: block;
            padding: 8px 16px;
            text-decoration: none;
            color: #007bff;
            border: 1px solid #ddd;
            border-radius: 4px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }
        .page li a:hover {
            background-color: #007bff;
            color: white;
        }
        .page li.active a {
            background-color: #007bff;
            color: black;
            border-color: #007bff;
        }
        .page li[aria-disabled="true"] a {
            pointer-events: none;
            color: #ddd;
            border-color: #ddd;
            background-color: #f8f9fa;
        }
    </style>
</head>

<body>
<div class="container">
    <aside>
        <div class="navigation">
            <div class="top-list-logo">
                <img src="https://dev-cms.minhtrithanh.com/logo.png" alt="logo">
                <span></span>
            </div>
            <div class="sidebar">
                <ul>
                    <li class="sidebar-content">
                        <a href="/user">
                            <span class="icon"><i class="fa-solid fa-graduation-cap"></i></span>
                            <span class="title">Học viên</span>
                        </a>
                    </li>

                    <li class="sidebar-content dropdown">
                        <a href="#" class="dropdown-toggle">
                            <span class="icon"><i class="fa-solid fa-book"></i></span>
                            <span class="title">Quản lý chương trình</span>
                            <sqan class="icon"><i class="fa-solid fa-angle-down"></i></sqan>
                        </a>
                        <ul class="dropdown-content">
                            <li><a href="categories"><span>Danh sách nhóm chương trình</span></a></li>
                            <li><a href="#"><span>Danh sách chương trình</span></a></li>
                            <li><a href="#"><span>Danh sách buổi phát trực tuyến</span></a></li>
                        </ul>
                    </li>

                    <li class="sidebar-content">
                        <a href="#">
                            <span class="icon"><i class="fa-solid fa-certificate"></i></span>
                            <span class="title">Đánh giá bài tập</span>
                        </a>
                    </li>

                    <li class="sidebar-content">
                        <a href="#">
                            <span class="icon"><i class="fa-solid fa-dollar-sign"></i></span>
                            <span class="title">Quản lý giao dịch</span>
                        </a>
                    </li>

                    <li class="sidebar-content">
                        <a href="#">
                            <span class="icon"><i class="fa-solid fa-ticket"></i></span>
                            <span class="title">Quản lý ưu đãi</span>
                        </a>
                    </li>

                    <li class="sidebar-content dropdown">
                        <a href="#" class="dropdown-toggle">
                            <span class="icon"><i class="fa-solid fa-circle-question"></i></span>
                            <span class="title">CSKH</span>
                            <span class="icon"><i class="fa-solid fa-angle-down"></i></span>
                        </a>
                        <ul class="dropdown-content">
                            <li><a href="#"><span>Tin nhắn</span></a></li>
                            <li><a href="#"><span>Yêu cầu liên hệ</span></a></li>
                        </ul>
                    </li>

                    <li class="sidebar-content">
                        <a href="#">
                            <span class="icon"><i class="fa-regular fa-comments"></i></span>
                            <span class="title">Quản lý tin nhắn</span>
                        </a>
                    </li>

                    <li class="sidebar-content">
                        <a href="#">
                            <span class="icon"><i class="fa-regular fa-bell"></i></span>
                            <span class="title">Quản lý thông báo</span>
                        </a>
                    </li>

                    <li class="sidebar-content">
                        <a href="#">
                            <span class="icon"><i class="fa-regular fa-calendar-check"></i></span>
                            <span class="title">Sự kiện</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </aside>

    <main class="main-content">
        <div class="main-top">
            <div class="main-title">
                <h1>Danh sách chương trình</h1>
                <div class="main-navigation">
                    <span>Trang chủ</span>
                    <span><svg width="12px" height="12px" viewBox="0 0 1024 1024" class="icon" version="1.1"
                               xmlns="http://www.w3.org/2000/svg">
                                <path d="M256 120.768L306.432 64 768 512l-461.568 448L256 903.232 659.072 512z"
                                      fill="#000000"/>
                            </svg>
                            Danh sách chương trình
                        </span>
                </div>
            </div>

            <div class="main-information">
                    <span class="icon">
                        <svg width="25px" height="25px" viewBox="0 0 24 24" fill="none"
                             xmlns="http://www.w3.org/2000/svg">
                            <path
                                    d="M9.00195 17H5.60636C4.34793 17 3.71872 17 3.58633 16.9023C3.4376 16.7925 3.40126 16.7277 3.38515 16.5436C3.37082 16.3797 3.75646 15.7486 4.52776 14.4866C5.32411 13.1835 6.00031 11.2862 6.00031 8.6C6.00031 7.11479 6.63245 5.69041 7.75766 4.6402C8.88288 3.59 10.409 3 12.0003 3C13.5916 3 15.1177 3.59 16.2429 4.6402C17.3682 5.69041 18.0003 7.11479 18.0003 8.6C18.0003 11.2862 18.6765 13.1835 19.4729 14.4866C20.2441 15.7486 20.6298 16.3797 20.6155 16.5436C20.5994 16.7277 20.563 16.7925 20.4143 16.9023C20.2819 17 19.6527 17 18.3943 17H15.0003M9.00195 17L9.00031 18C9.00031 19.6569 10.3435 21 12.0003 21C13.6572 21 15.0003 19.6569 15.0003 18V17M9.00195 17H15.0003"
                                    stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                        </svg>
                    </span>
                <div class="main-information-line"></div>
                <div class="main-information-account">
                    <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAA13SURBVHgB7V1tetNGF70jJ1BoKGYFiBU0WQFhBYQV4KwA+F+IQ97/CSvArICwAsIKkq4AdQW4LYFSYuk9ZzRyZFmyZXlGkkvO8xgTf8iyztzvO9dKVgSf+/5mKLKplPiekru8jyLxzdN+9vWRyFDxpiTAn0M8EOD9f0ShnF2InN3pB0NpIZS0EJ/6frcjsr3myX2c4WYYgQiRrthFALLOcOx330M5AUGBtACtIYQkrHvSw+p/iJW/LfUjwO0kDOXNrX5wIg2hUULGktCRJw2RUIQAC2Pwz0je1C05jRBCIn4CCaNInjpQRbYxqFNqaiVkxYiYAOzNyWgk+66JqYWQVSYiC5z/8bdQnrlSZc4J+XLgP4En0191InIw+DeUfdvEOCMEUuFf78hr18Y6gioJYXxhhLehVh5LvQgQ7+xvvAgGYglOCKlDKkD0K97/zM8xQd7f+/6R58ldBIE7Ui+sSYtVQmgrrnnyGv91dUGGkIgzXPA3s1YliOlDYvakXgQg5cGypFgjhCoKZLyXnDSGLXih3LuxwBdughhc0Gc3XwRHUhFWCPm7728rT946NtzDn18Ed2RBnL/0I6kZWAT9G8+DfakAT5bE1//5j6G339fgRXUphYu8YdHX2wLtJxbCa6mApQg5P/D3EMUOpCZc9+Qw+xilM32fxrVO7V5XGr3zff+UdnWRN1VWWSQDxrUvNSNRB0zHf4chhd06pIeDxOQOsrbHiVFt6vymEMnZv5E29qXS/ZUkhG5tU1+W6iCRBmaH4XX5nY5swg3uQoKeNH1+U0D54LqSt+VfviDO+/4OaCz9AY6gXUxIxx4JwcV/xweZuv82kl08/lHahwGckt15L1pIQmgkozjOaBr+NSU9ELEpIaqAkA7eRqF8WO+04vzy0PtKNToHpQlJ4owW5aQewp/9PYoLSxpInQxVu+oqE6C6pVc66zWlCbkWezi+tAVK19fjGCOSE/zbxWL5VVoOeKVHs9zxNSkB47HUnR+aC6ipPyERx/S2Oh4kN2rctpVB91ps5Lfynpxr1I2qaouRHIKENxD9k3WRs5/YVWLcSZ1dhkqN2iTFsxDJ/s97QT/78FxCEHGSDF+axRAkvNqI5EjN8ec/v/RZBKPxbHv9ZQhPcSubjJxpQ85jr8CXBsF6B5KKW7ewmlSJ4ApZ4CO+XqWMfUvBzPiU11UoIVQBCLxOm/SqWPPY2AueSgUwkldx9rnVkgIpuZeWkkIJIXuNurjQsVXJIDb6wRmredJyZKUkV0KaNuS4kLu2yqJ/Hfg7a5EcttnYQ0ruJLmuXAnJ0211wSYZxC/Pg2MUjO7huM+kpYAbPNYEU4SYoKUnDcA2GWkYY3+vpcb+YfKfKUIak47IbvdGHlj+VUhKCrvh2wRkHZIM9gQhjUlHQZDkAiSljcaebUy8n0idIPrdlvpxbJuMpFMSwWRPjDHnfhEv7lg5GzHlUmsT7XzgdO6b+0vUHZVTn1OF3LDU/UcirrNGIlLZXW4QjNzvjSXE6DBfagQyn4827JGxCfv3dmVyWdPoQkP5YxvieTU3BNCII3gTC2CNYd1xT1gt8GQ7bUO2pSZQVd20ZDcoGex8aZlJqIbISAjzPlLj6roI7QRpJqOwCjWQUlBjleXV6l0NfukHx2IBJmbypSWI4srlMrirCYELeF9qAqJlKzGAcUJ60iKAEH63QKpCSTeWEHZv1IOBLRdXdZrJKLA+U/DUkNvdQtOSlPe8zM8Q+J5pdfSlBtiSDtoOh90lMy9aNNLfYeo13PM+6/0mOzA3ZePBzapFOrhp0pZ0rCmngR/LxYULhymO6PLijxEZLcMpE3nv24i3KBTWl5Kkp4eqWi2EXIziHU82oDynNs+/QO2+kBSFwl2+dHa/vPTZKtXLe9uXA5/eYB4hQ2a5E5K91LwQZyD7tjwro66cLiJqDdbwi7wmfH5uQDsjZcNumZ2C9zzTWe74Ow0pIc6by/ChJ2IJbKwWx4Da0dsecN4f8p6/iPLtAVuU8l4fRvnagWqcZCAO7Elsx4dLb9gpA05CEEtAMtK9ikV9gonWInugTFvS1BNQdTJN1AAl5EHecXBdfv8UN2Noj5GTizzlWGVRXdmcfqBseoRQPTMqiL4U2ANtd7PqDO6ubqzIuL2jUN5dFJ2zkscIbk8lKRGE8iclxGlniU11peHlr9pKUOJ/YwWxwCYQNLiSWfUg8claZ9KxgFHWNjLMEIXX3e3kxEy0T9munlDkrA5CPkh70TUd/TPjg5zGOz/MbAji7i3ej0QmnBdc+KOp4QmwQaE3rfLwujP3NiQUKyl2h/AjToFgsSxPfcH7SWrx6edx8T4kf9M4J2085j5+PL4PJg8nz1ghxfG2sx+1Lu4JGdqqeSRQ4qZBgfsaeNGzxtozWxxyGiTOYB929Xuh+yeOFY8VpAral1QQCSP+wASIkvVuSR4/wykhStmXjuyXL3UenEmCCz0jD0X40pHHiD+epuMPvGcz2UnLC8Yqp37c5K70a5V8yjnegC5tcr6UjMS54fGywWVia0mIkxVH0K0Ty4gqZFNZ1u148mnjefCAvVlFRjzZX24GZyboptNLYxKSYzMmyQSqDFyTvB0k4bbE5Bwlz6/njB5JbK1TQkTZb0rDBQikAvR2sgN/j6uc25Sl+Hv3eEtH453MeA4c603HdIlwwqmkpIitq5yAOs7bgRxIyaQBz9k/nzgFHkTSpYQEYhnrS7jRRgI+Xo83hs773kNKE6NvGv303kCeAx9Lb01L2kE70eVwg7+4YxkSlrajjMqNukqSmDyPwbi3VzlsrXRhgM3KC6Q6fJNX8vVxYBOwgnfNhR9fOF5wBnQbe0EPz2/h1jcXeAy6zOz/0n9AikD2W31cxDeMwKEmD9N21MyE2SMRnNuiYmnvpjMZSs+YUuaglnHTU7767eMfYhmWzzkwO5n04vmKVX+B1d6Jx9UOkykMvJhe3NkyYPTduazlB0KJiWLjjQt+V7ciIQOiAz8zycE07vVJLiXGjLLi/hthM3hyMmtKuZMQZ4igb+0R4ptJC7QriQQ+BTFHoZLXZvfxLo355wP/DKu6BzJ6MmdaKYkdKenj+j5cV/IRZNDGDBL1lexqDuNMwBgqxbx1QCydded83vffK1WiaoiURsQt0/MrjLmTFszn+DjGKyyEh5BMn/FH2fwciQlJOCd0x3EMM9Z7jN51O1RKOghPewkriCgqWQ6G2mHZVV26quNIOoMeCkxvs3vIYaRJEvfAH5IMBoeLJEspcYjMt2ijuPB5S1IpYU7Tt5cO9VcJ2XhgBnr6IhhpUvF8xC1Kb3YTD/7eoaFm5c/0qsXBIC7msn3IdA4m4h9Ibt72C925qPMyyn3l0DYoJaXUVvo9sA+46Du46Mfmb90NEqaKS7phDUYbXpOfPEZdv2wfshfJI6ivU/3/UX6zoNbxZm/3oVhGeu+cK1j0uKYmiyYzG/N0fVXwfOkKF21O0rmsTjiZMraF7pq6LY5xEY+jDWR59KiusDh7iR3RlT6omdDiBp8NnO+snWJjL8jF3pDE5xbH0J5MXHmrUtsJhD9TEYmOl6CqfmUuKr2toa7vQYy736lDbY9UDeMv5fyL0NDCCD9IDQoYz0RRcZtNd8273Bqts74otVIzFBlppji8ePOPXxcZxGX6PbJcahW92qqs2ErQ9ezLIhJ/6ug2yaBbvx4vilgtR/Eg5u8zyDDHY+C3XK9uBUwEbucH/qnNPl/mbG7VtJkzwdd46l2pqUAg7Vj34qKqmUgBUxpMtyfBm1ScF1wVEwUqrIh3YhFFbTQuwVX/DTq/qBcqDSYZsSJfQ9WdcuAy7SgM+yfVkcMwfgk9xO6io16XwQQhF/l9RdVRX1f9BOhq68rfYlOBdCxyE646CllbLGYxgOTjHEErNWGCEH6RKLIoJQ0Hm1RDeqwGck+ziMkbAcUcn5ll30VA91hqwlTyz3ay0VUKvgp0PULpX4K7n7Ux0eVvHlKVxanzFMIFc1hVkZuNLZ1JLQGX80uWgc5VefpHYDQ5poOz0FYwvfQdNsd15mGt4MP3bRHSlB2ZB+NV8XaUPBbBeP+TQ0p6tqNrFNYrICUDKz8hBL+f6We5QikU9mV14lbJ5VdFqiPjCvNRSIjNqTl1uo2rjpmdi7q5K1o+F5VMurnCfMxtJY0i2ZXlcSUhJTGXEDPdc9lRGN28X8C5wjRKNVtTdS07NgIe25WUlEDp7ncERY+WqczRhb7ytuajNCGMUJccIKl/O12uMBML7Q9J74+ogjVHLav/JSy8YUf3Q4XVPC/2Rl0Z99motIOK5c2qnteVcZ+NpXpvK/ZzDc0vAtSSrFs1LLXHULvDi6uv7jW1kmNca8FSEpKAtQVvsRGtV1JSACu7cBnNZ/dxz8GVlBTA2rboRbo9NOACN/Vrzm2G1X3qqW6P3RLS0r2uWvurnI3Big3JQ2pL18yqY13NA6sCZ4QkSPfIFrxkYtPljw7nw2cYRLI3im2lBWqMPwhptcl7leFcQtJI1FheXxSkqHfjt+CN/OColZAEmhhkfjOqLPeXL380NEJIGpyO0OHsj3i6gv7h+h+ZlMYJSZBIDc5oG8Ww/o9Kyv8BpVtNVkiXeNEAAAAASUVORK5CYII="
                         alt="image account">
                </div>
            </div>
        </div>

        <div class="main-second-top">
            <h3>Quản lý danh sách chương trình</h3>
            <div class="controls">
                <div class="filters">
                    <a href="#" class="filter-link active">Tất cả</a>
                    <a href="#" class="filter-link">Chương trình thường</a>
                    <a href="#" class="filter-link">Chương trình VIP</a>
                    <a href="#" class="filter-link">Chương trình phiếu</a>
                </div>
                <div class="search-and-create">
                    <input type="text" placeholder="Tìm kiếm theo tên chương trình">
                    <button class="create-button">Tạo mới chương trình</button>
                    <button class="filter-button">Lọc</button>
                </div>
            </div>
            <table class="program-table">
                <thead>
                    <tr>
                        <th>Tên chương trình</th>
                        <th>Trạng thái</th>
                        <th>Chuyên gia</th>
                        <th>Chi phí chương trình</th>
                        <th>Nhóm chương trình</th>
                        <th>Số lượng buổi học</th>
                        <th>Số lượng học viên</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
<%--                   <c:forEach items="${listCourses}" var="courses">--%>
                    <tr>
                        <td>Lực Test<%--${courses.coursesName}--%></td>
                        <td><span class="status published">Đã xuất bản</span></td>
                        <td>Nguyễn Thị Lanh<%--${courses.teacherId}--%></td>
                        <td>0</td>
                        <td>Audio cho cả gia đình<%--${courses.categoriesId}--%></td>
                        <td>1</td>
                        <td>0</td>
                        <td><a href="#" class="action-button">Vô hiệu hóa</a></td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="main-three-top">
            <div class="total">
                <span>Hiển thị ${begin} đến ${end} trong ${totalElement} bản ghi</span>
            </div>
            <div class="page">
                <c:if test="${totalPage >0}">
                    <c:if test="${number <= 0}">
                        <li aria-disabled="true"><a href="#">Previous</a></li>
                    </c:if>
                    <c:if test="${number > 0}">
                        <li><a href="?page=${number-1}">Previous</a></li>
                    </c:if>
                    <c:forEach begin="0" end="${totalPage-1}" var="i">
                        <c:choose>
                            <c:when test="${number == i}">
                                <li class="active"><a href="?page=${i}">${i+1}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="?page=${i}">${i+1}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${number < totalPage -1}">
                        <li><a href="?page=${number+1}">Next</a></li>
                    </c:if>
                    <c:if test="${number >= totalPage-1}">
                        <li aria-disabled="true"><a  href="#">Next</a></li>
                    </c:if>
                </c:if>
            </div>
        </div>
    </main>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        var dropdownToggles = document.querySelectorAll('.dropdown-toggle');

        dropdownToggles.forEach(function (toggle) {
            toggle.addEventListener('click', function (event) {
                event.preventDefault(); // Ngăn chặn việc theo liên kết
                // Tìm phần tử cha là .dropdown
                var parent = toggle.closest('.dropdown');
                // Đóng tất cả các dropdown khác
                var otherDropdowns = document.querySelectorAll('.dropdown-content.show');
                otherDropdowns.forEach(function (dropdown) {
                    if (dropdown !== parent.querySelector('.dropdown-content')) {
                        dropdown.classList.remove('show');
                    }
                });

                // Toggle phần tử dropdown hiện tại
                var dropdownContent = parent.querySelector('.dropdown-content');
                if (dropdownContent) {
                    dropdownContent.classList.toggle('show');
                }
            });
        });
        // Đóng dropdown nếu click ra ngoài
        document.addEventListener('click', function (event) {
            var isClickInsideDropdown = event.target.closest('.dropdown');
            if (!isClickInsideDropdown) {
                var openDropdowns = document.querySelectorAll('.dropdown-content.show');
                openDropdowns.forEach(function (dropdown) {
                    dropdown.classList.remove('show');
                });
            }
        });
    });
</script>
</body>

</html>