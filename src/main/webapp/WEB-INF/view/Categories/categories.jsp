<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Minh Trí Thành</title>
    <link rel="stylesheet" href="/asset/css/index.css">
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
            margin-top: 1.5rem;
            width: 100%;
            height: 35rem;
            border-radius: .4rem;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);

        }

        .second-content-top {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        /* main-second-content */
        .second-content-top {
            padding: 1rem;
        }

        .second-content-title span:first-child {
            font-weight: bold;
            font-size: 1.2rem;
        }

        .second-content-title span:last-child {
            color: #b4b4b4;
            font-size: .8rem;
        }


        .search-box {
            position: relative;
            width: 300px;
        }

        .search-box input {
            width: 100%;
            padding: 15px;
            padding-left: 30px; /* Để có khoảng trống cho biểu tượng kính lúp */
            border: 2px solid orange;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .search-icon {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            height: 16px;
            pointer-events: none; /* Để không gây ảnh hưởng khi người dùng click vào */
        }

        .second-content-operation {
            display: flex;
            gap: 13px;
        }

        .opera-button button {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 8px 10px;
            border-radius: 10px;
        }

        .opera-button button:hover {
            cursor: pointer;
        }

        .button1 {
            background-color: grey;
        }

        .button2 {
            background-color: pink;
        }

        .button3 {
            background-color: green;
        }

        .button4 {
            background-color: blue;
            color: #ffffff;
        }

        .button5 {
            background-color: orange;
            border: 2px solid orangered;
            color: orangered;
        }

        .button6 {
            background-color: transparent;
        }

        .second-table {
            width: 100%;
            margin-top: 1rem;
        }

        .second-table table {
            width: 100%;;
        }

        .second-table table thead tr th,
        .second-table table tbody tr td {
            text-align: center;
            border-bottom: 1px solid #ddd;
            padding: 10px;
        }

        .second-table table thead {
            background-color: #b4b4b4;
        }

        /* main-three-top */
        .main-three-top {
            width: 100%;
            margin-top: 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .total span {
            color: #b4b4b4;
        }

        .page ul {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 5px;
        }

        .page ul li {
            padding: 5px 10px;
            border: 1px solid rgba(0, 0, 0, 0.2);
            border-radius: 30%;
        }

        .page ul li:hover {
            cursor: pointer;
        }

        .page ul li:active {
            background-color: #f56800;
            color: #ffffff;
        }

        .page ul li:first-child {
            border: none;
        }

        .page ul li:last-child {
            border: none;
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
                        <a href="/view-user">
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
                            <li><a href="#"><span>Danh sách nhóm chương trình</span></a></li>
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
                <h1>Danh sách nhóm chương trình</h1>
                <div class="main-navigation">
                    <span>Trang chủ</span>
                    <span><svg width="12px" height="12px" viewBox="0 0 1024 1024" class="icon" version="1.1"
                               xmlns="http://www.w3.org/2000/svg">
                                <path d="M256 120.768L306.432 64 768 512l-461.568 448L256 903.232 659.072 512z"
                                      fill="#000000"/>
                            </svg>
                            Danh sách nhóm chương trình
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
                    <img src="data:image/png;base64,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"
                         alt="image account">
                </div>
            </div>
        </div>

        <div class="main-second-top">
            <div class="second-content-top">
                <div class="second-content-title">
                    <span>Quản lý nhóm chương trình</span>
                    <br>
                    <span>Tất cả nhóm chương trình</span>
                </div>

                <div class="second-content-operation">
                    <div class="search-box">
                        <input type="text" placeholder="Tìm kiếm theo tên nhóm chương trình">
                        <i class="search-icon fa-solid fa-magnifying-glass"></i>
                    </div>

                    <div class="opera-button">
                        <button class="button4">
                            <svg width="28px" height="28px" viewBox="0 0 24 24" fill="none"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path d="M4 12H20M12 4V20" stroke="#ffffff" stroke-width="2" stroke-linecap="round"
                                      stroke-linejoin="round"/>
                            </svg>
                            <a style="color: white" href="/view-createCategories">Thêm mới nhóm chương trình</a>
                        </button>
                    </div>

                    <div class="opera-button">
                        <button class="button6">
                            <svg width="28px" height="28px" viewBox="0 0 64 64" xmlns="http://www.w3.org/2000/svg"
                                 stroke-width="3" stroke="#000000" fill="none">
                                <path d="M46.31,56.71H17.69a.1.1,0,0,1-.1-.08L12.52,15.25c0-.06,0-.1.1-.1H51.38c.06,0,.11,0,.1.1L46.41,56.63A.1.1,0,0,1,46.31,56.71Z"
                                      stroke-linecap="round"/>
                                <path d="M46.34,7.29H17.66a.1.1,0,0,0-.09,0l-5,7.68a.09.09,0,0,0,.09.14H51.32a.09.09,0,0,0,.09-.14l-5-7.68A.1.1,0,0,0,46.34,7.29Z"
                                      stroke-linecap="round"/>
                                <path d="M29.94,41.56H22.45a1,1,0,0,1-.84-1.46l3.31-5.59" stroke-linecap="round"/>
                                <path d="M35.28,41.56h6.27a1,1,0,0,0,.84-1.46l-3.81-6.44" stroke-linecap="round"/>
                                <path d="M27,31l4.15-7a1,1,0,0,1,1.66,0l3.27,5.53" stroke-linecap="round"/>
                                <path d="M37.86,38.68l-2.78,2.81a.1.1,0,0,0,0,.14l2.78,3" stroke-linecap="round"/>
                                <path d="M26.21,38l-1.29-3.48s0,0-.06,0l-4.38.88" stroke-linecap="round"/>
                                <polyline points="32.28 28.86 36.1 29.48 37.52 25.82" stroke-linecap="round"/>
                            </svg>
                            <span>Xóa</span>
                        </button>
                    </div>
                </div>
            </div>

            <div class="second-table">
                <table>
                    <thead>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>Tên nhóm</th>
                        <th>Số lượng chương trình</th>
                        <th>Từ khoá liên quan</th>
                        <th>Ngày Tạo</th>
                        <th>Ngày Cập Nhật Gần Nhất</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listCategories}" var="categories">
                        <tr>
                            <td>
                            <td>${categories.categoriesName}</td>
                            <td>${categories.categoriesName}</td>
                            <td>${categories.categoriesTag}</td>
                            <td>${categories.createAt}</td>
                            <td>
                                <a href="/detail/${users.categoriesId}" class="deltail" >Chi tiết</a>
                                <a href="/delete/${users.categoriesId}" class="delete">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="main-three-top">
            <div class="total">
                <span>Hiển thị 1 đến 10 trong 3358 bản ghi</span>
            </div>

            <div class="page">
                <ul>
                    <li>Trước đó</li>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                    <li>...</li>
                    <li>336</li>
                    <li>Trang tiếp</li>
                </ul>
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