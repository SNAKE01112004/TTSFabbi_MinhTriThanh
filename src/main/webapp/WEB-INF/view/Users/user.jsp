<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Minh Trí Thành</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Users/user.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

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
                            <li><a href="/categories"><span>Danh sách nhóm chương trình</span></a></li>
                            <li><a href="/courses"><span>Danh sách chương trình</span></a></li>
                            <li><a href="#"><span>Danh sách buổi phát trực tuyến</span></a></li>
                        </ul>
                    </li>
                    <li class="sidebar-content">
                        <a href="/rate">
                            <span class="icon"><i class="fa-solid fa-certificate"></i></span>
                            <span class="title">Đánh giá bài tập</span>
                        </a>
                    </li>
                    <li class="sidebar-content">
                        <a href="/transaction">
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
                        <a href="/event">
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
                <h1>Danh sách học viên</h1>
                <div class="main-navigation">
                    <span>Trang chủ</span>
                    <span>
                        <svg width="12px" height="12px" viewBox="0 0 1024 1024" class="icon" version="1.1"
                               xmlns="http://www.w3.org/2000/svg">
                                <path d="M256 120.768L306.432 64 768 512l-461.568 448L256 903.232 659.072 512z"
                                      fill="#000000"/>
                        </svg>
                    </span>
                    <span>Danh sách sinh viên</span>
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
                    <span>Quản lý học viên</span>
                    <br>
                    <span>Tất cả học viên</span>
                </div>
                <div class="second-content-operation">
                    <div class="search-box">
                        <form action="/user/search" method="get">
                            <div class="input-group">
                                <i class="search-icon fa-solid fa-magnifying-glass"></i>
                                <input type="search" name="keyword"
                                       placeholder="Tìm kiếm theo tên hoặc mã học viên, số điện thoại, email">
                            </div>
                        </form>
                    </div>
                    <div class="opera-button">
                        <button class="button1">
                            <svg width="28px" height="28px" viewBox="0 0 24 24" fill="none"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path
                                        d="M20.3142 3.68576L20.8446 3.15543L20.3142 3.68576ZM20.3142 11.8253L20.8446 12.3557L20.3142 11.8253ZM10.4547 10.057L9.92432 9.52663L9.92432 9.52663L10.4547 10.057ZM7.36124 13.1504L7.89157 13.6807H7.89157L7.36124 13.1504ZM10.8496 16.6388L10.3193 16.1084L10.3193 16.1084L10.8496 16.6388ZM13.9433 13.5451L13.4129 13.0148L13.9433 13.5451ZM7.00755 14.1587L6.26214 14.2415L6.26214 14.2415L7.00755 14.1587ZM7.20094 15.8992L6.45553 15.982L6.45553 15.982L7.20094 15.8992ZM8.10084 16.7991L8.01802 17.5445L8.01802 17.5445L8.10084 16.7991ZM9.84133 16.9924L9.92416 16.247H9.92416L9.84133 16.9924ZM7.43673 16.3898L7.96707 15.8594L7.96706 15.8594L7.43673 16.3898ZM7.61025 16.5633L7.07991 17.0936L7.07992 17.0936L7.61025 16.5633ZM10.6703 9.1926L9.94383 9.37914L9.94383 9.37914L10.6703 9.1926ZM14.8074 13.3297L14.6209 14.0562H14.6209L14.8074 13.3297ZM10.9532 13.6303C10.6587 13.339 10.1838 13.3416 9.89252 13.6361C9.60124 13.9306 9.60385 14.4055 9.89835 14.6967L10.9532 13.6303ZM15.5185 8.48151C15.1605 8.12353 15.1605 7.54313 15.5185 7.18515L14.4578 6.12449C13.5141 7.06826 13.5141 8.59841 14.4578 9.54217L15.5185 8.48151ZM16.8148 8.48151C16.4569 8.83949 15.8765 8.83949 15.5185 8.48151L14.4578 9.54217C15.4016 10.4859 16.9317 10.4859 17.8755 9.54217L16.8148 8.48151ZM16.8148 7.18515C17.1728 7.54313 17.1728 8.12353 16.8148 8.48151L17.8755 9.54217C18.8193 8.59841 18.8193 7.06826 17.8755 6.12449L16.8148 7.18515ZM17.8755 6.12449C16.9317 5.18072 15.4016 5.18072 14.4578 6.12449L15.5185 7.18515C15.8765 6.82717 16.4569 6.82717 16.8148 7.18515L17.8755 6.12449ZM19.7839 4.21609C21.7387 6.17088 21.7387 9.34021 19.7839 11.295L20.8446 12.3557C23.3851 9.81509 23.3851 5.696 20.8446 3.15543L19.7839 4.21609ZM20.8446 3.15543C18.304 0.614857 14.1849 0.614857 11.6443 3.15543L12.705 4.21609C14.6598 2.2613 17.8291 2.2613 19.7839 4.21609L20.8446 3.15543ZM9.92432 9.52663L6.83091 12.62L7.89157 13.6807L10.985 10.5873L9.92432 9.52663ZM11.38 17.1691L12.4136 16.1354L11.353 15.0748L10.3193 16.1084L11.38 17.1691ZM12.4136 16.1354L14.4736 14.0754L13.4129 13.0148L11.353 15.0748L12.4136 16.1354ZM6.26214 14.2415L6.45553 15.982L7.94635 15.8163L7.75296 14.0758L6.26214 14.2415ZM8.01802 17.5445L9.75851 17.7379L9.92416 16.247L8.18367 16.0536L8.01802 17.5445ZM6.9064 16.9201L7.07991 17.0936L8.14058 16.0329L7.96707 15.8594L6.9064 16.9201ZM8.18367 16.0536C8.16736 16.0518 8.15217 16.0445 8.14058 16.0329L7.07992 17.0936C7.33236 17.346 7.6632 17.505 8.01802 17.5445L8.18367 16.0536ZM6.45553 15.982C6.49495 16.3368 6.65396 16.6676 6.9064 16.9201L7.96706 15.8594C7.95547 15.8478 7.94816 15.8326 7.94635 15.8163L6.45553 15.982ZM10.3193 16.1084C10.2155 16.2122 10.0701 16.2633 9.92416 16.247L9.75851 17.7379C10.3573 17.8044 10.9539 17.5951 11.38 17.1691L10.3193 16.1084ZM6.83091 12.62C6.40488 13.0461 6.1956 13.6427 6.26214 14.2415L7.75296 14.0758C7.73675 13.9299 7.78775 13.7845 7.89157 13.6807L6.83091 12.62ZM11.3967 9.00605C10.9704 7.34603 11.4077 5.51341 12.705 4.21609L11.6443 3.15543C9.95676 4.84301 9.3911 7.22673 9.94383 9.37914L11.3967 9.00605ZM19.7839 11.295C18.4866 12.5923 16.654 13.0296 14.9939 12.6033L14.6209 14.0562C16.7733 14.6089 19.157 14.0432 20.8446 12.3557L19.7839 11.295ZM14.4736 14.0754C14.4807 14.0684 14.4935 14.0591 14.5182 14.0532C14.5444 14.047 14.5805 14.0458 14.6209 14.0562L14.9939 12.6033C14.4675 12.4681 13.8509 12.5768 13.4129 13.0148L14.4736 14.0754ZM10.985 10.5873C11.4227 10.1495 11.532 9.53285 11.3967 9.00605L9.94383 9.37914C9.95415 9.41931 9.95302 9.45541 9.94673 9.48175C9.94081 9.50657 9.93144 9.51951 9.92432 9.52663L10.985 10.5873ZM12.4107 15.0719L10.9532 13.6303L9.89835 14.6967L11.3559 16.1383L12.4107 15.0719Z"
                                        fill="#000000"/>
                                <path
                                        d="M2 11.9899C2 16.7087 2 19.0681 3.46594 20.5341C4.93188 22 7.29127 22 12.0101 22C16.7288 22 19.0882 22 20.5542 20.5341C21.6692 19.419 21.9361 17.787 22 14.993M9.00704 2C6.21298 2.06388 4.58099 2.33078 3.46594 3.44584C2.48914 4.42263 2.16321 5.79612 2.05446 8"
                                        stroke="#1C274C" stroke-width="1.5" stroke-linecap="round"/>
                            </svg>
                        </button>
                    </div>
                    <div class="opera-button">
                        <button class="button2">
                            <svg fill="#ffffff" height="28px" width="28px" version="1.1" id="Capa_1"
                                 xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                 viewBox="0 0 52 52" xml:space="preserve">
                                    <g>
                                        <path d="M24.439,3.5C29.172,3.524,33.661,5.116,37.34,8H31c-0.552,0-1,0.447-1,1s0.448,1,1,1h9c0.13,0,0.26-0.027,0.382-0.077
		                                c0.245-0.101,0.44-0.296,0.541-0.541C40.973,9.26,41,9.13,41,9V1c0-0.553-0.448-1-1-1s-1,0.447-1,1v5.745
		                                c-4.101-3.37-9.188-5.219-14.551-5.245c-0.04,0-0.079,0-0.118,0c-6.108,0-11.84,2.37-16.151,6.681
		                                c-8.511,8.511-8.922,22.308-0.935,31.408c0.198,0.226,0.474,0.341,0.752,0.341c0.234,0,0.469-0.082,0.659-0.248
		                                c0.415-0.364,0.456-0.996,0.092-1.411C1.454,29.959,1.826,17.363,9.594,9.595C13.552,5.637,18.818,3.506,24.439,3.5z"/>
                                        <path d="M44.748,12.403c-0.364-0.413-0.997-0.455-1.411-0.091c-0.415,0.364-0.456,0.996-0.092,1.411
		                                c7.3,8.312,6.931,20.91-0.84,28.682c-3.958,3.958-9.217,6.133-14.845,6.095c-4.733-0.024-9.222-1.616-12.901-4.5H21
                                        c0.552,0,1-0.447,1-1s-0.448-1-1-1h-9c-0.13,0-0.26,0.026-0.382,0.077c-0.245,0.101-0.44,0.296-0.541,0.541
		                                C11.026,42.74,11,42.87,11,43v8c0,0.553,0.448,1,1,1s1-0.447,1-1v-5.745c4.101,3.37,9.188,5.219,14.551,5.245
		                                c0.04,0,0.079,0,0.118,0c6.108,0,11.84-2.37,16.151-6.681C52.334,35.305,52.742,21.506,44.748,12.403z"/>
                                    </g>
                                </svg>
                        </button>
                    </div>

                    <div class="opera-button">
                        <button class="button3">
                            <svg fill="#ffffff" height="28px" width="28px" version="1.1" id="Capa_1"
                                 xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                 viewBox="0 0 60 60" xml:space="preserve">
                                    <path d="M14,31h32c6.065,0,11-4.935,11-11S52.065,9,46,9H16.414l7.293-7.293c0.391-0.391,0.391-1.023,0-1.414s-1.023-0.391-1.414,0
	                                    l-8.999,8.999c-0.093,0.093-0.166,0.203-0.217,0.326c-0.101,0.244-0.101,0.52,0,0.764c0.051,0.123,0.124,0.233,0.217,0.326
	                                    l8.999,8.999C22.488,19.902,22.744,20,23,20s0.512-0.098,0.707-0.293c0.391-0.391,0.391-1.023,0-1.414L16.414,11H46
	                                    c4.962,0,9,4.037,9,9s-4.038,9-9,9H14C7.935,29,3,33.935,3,40s4.935,11,11,11h29.586l-7.293,7.293c-0.391,0.391-0.391,1.023,0,1.414
	                                    C36.488,59.902,36.744,60,37,60s0.512-0.098,0.707-0.293l8.999-8.999c0.093-0.093,0.166-0.203,0.217-0.326
	                                    c0.101-0.244,0.101-0.52,0-0.764c-0.051-0.123-0.124-0.233-0.217-0.326l-8.999-8.999c-0.391-0.391-1.023-0.391-1.414,0
	                                    s-0.391,1.023,0,1.414L43.586,49H14c-4.962,0-9-4.037-9-9S9.038,31,14,31z"/>
                            </svg>
                        </button>
                    </div>

                    <div class="opera-button">
                        <button class="button4">
                            <svg width="28px" height="28px" viewBox="0 0 24 24" fill="none"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path d="M4 12H20M12 4V20" stroke="#ffffff" stroke-width="2" stroke-linecap="round"
                                      stroke-linejoin="round"/>
                            </svg>
                            <a style="color: white" href="/user/view-create">Thêm mới học viên</a>
                        </button>
                    </div>

                    <div class="opera-button">
                        <button class="button5">
                            <svg width="28px" height="28px" viewBox="0 0 24 24" fill="#ff4500"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" clip-rule="evenodd"
                                      d="M3 7C3 6.44772 3.44772 6 4 6H20C20.5523 6 21 6.44772 21 7C21 7.55228 20.5523 8 20 8H4C3.44772 8 3 7.55228 3 7ZM6 12C6 11.4477 6.44772 11 7 11H17C17.5523 11 18 11.4477 18 12C18 12.5523 17.5523 13 17 13H7C6.44772 13 6 12.5523 6 12ZM9 17C9 16.4477 9.44772 16 10 16H14C14.5523 16 15 16.4477 15 17C15 17.5523 14.5523 18 14 18H10C9.44772 18 9 17.5523 9 17Z"
                                      fill="##ff4500"/>
                            </svg>
                            <span>Lọc</span>
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
                            <th>Mã học viên</th>
                            <th>Học và tên</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Ngày sinh</th>
                            <th>Giới tính</th>
                            <th>Địa chỉ</th>
                            <th>Trạng thái</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <td>
                            <c:if test="${empty listUsers}">
                                <p>${emptyData}</p>
                            </c:if>
                        </td>
                        <c:forEach items="${listUsers}" var="users">
                            <tr>
                                <td></td>
                                <td>${users.usersCode}</td>
                                <td>${users.usersName}</td>
                                <td>${users.usersPhone}</td>
                                <td>${users.usersEmail}</td>
                                <td><fmt:formatDate value="${users.usersBirthday}" pattern="dd-MM-yyyy"/></td>
                                <td>${users.usersGender == 0 ? 'Nam':'Nữ'}</td>
                                <td>${users.usersAddress}</td>
                                <td>${users.usersStatus == true ? 'Đã Kích Hoạt' : 'Chưa Kích Hoạt'}</td>
                                <td>
                                    <a href="/user/detail/${users.usersId}" class="deltail">Chi tiết</a>
                                    <a href="/user/delete/${users.usersId}" class="delete">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
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