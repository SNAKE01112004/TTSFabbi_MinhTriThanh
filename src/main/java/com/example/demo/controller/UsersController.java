package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UserService userService;

    @Autowired
    StaffCskhService staffCskhService;

    @Autowired
    StaffService staffService;

    @Autowired
    TeacherService teacherService;


    @GetMapping()
    private String view_Home(Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);

        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Users> usersPage = userService.getAllListUser(pageable);

        int totalElement = (int) usersPage.getTotalElements();
        int begin = currentPage * pageSize + 1;
        int end = Math.min((currentPage +1)*pageSize,totalElement);

        model.addAttribute("totalPage", usersPage.getTotalPages());
        model.addAttribute("begin", begin);
        model.addAttribute("number", currentPage);
        model.addAttribute("end", end);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("listUsers", usersPage.getContent());
        return "/Users/user";
    }

    @GetMapping("/search")
    private String searchUsers(@RequestParam("keyword") String keyword, Model model) {
        List<Users> usersList;
        if (keyword == null && keyword.isEmpty()) {
            usersList = userService.getAllUser();
            model.addAttribute("listUsers", usersList);
        } else {
            usersList = userService.searchByUsersCode(keyword);
            model.addAttribute("listUsers", usersList);
        }
        if (usersList.isEmpty()) {
            System.out.println("No data found for usersCode: " + keyword);
            model.addAttribute("emptyData", "Không có dữ liệu");
        } else {
            System.out.println("Found " + usersList.size() + " records for usersCode: " + keyword);
        }
        return "/Users/user";
    }

    @GetMapping("/view-create")
    private String addViewChucVu(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("listStaffCskh", staffCskhService.getAllStaffCskh());
        model.addAttribute("listStaff", staffService.getAllStaff());
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        return "/Users/createUser";
    }

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @PostMapping("/add")
    private String addChucVu(@Valid @ModelAttribute("users") Users users,
                             BindingResult result,
                             @RequestParam("file") MultipartFile file, Model model) {

        String chemin = null;
        if (!file.isEmpty()) {
            try {
                String orgName = file.getOriginalFilename();
                String name = orgName.substring(orgName.lastIndexOf("\\") + 1);
                // Đảm bảo thư mục uploads tồn tại
                Path uploadDir = Paths.get("src/main/resources/static/uploads");
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }
                chemin = "/uploads/" + name;
                Path filePath = uploadDir.resolve(name);
                file.transferTo(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        users.setUsersCode(generateMaUsers());
        users.setUsersAvatar(chemin);
        model.addAttribute("listUsers", userService.getAllUser());
        model.addAttribute("listStaffCskh", staffCskhService.getAllStaffCskh());
        model.addAttribute("listStaff", staffService.getAllStaff());
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        userService.addUser(users);
        return "redirect:/user";
    }

    @GetMapping("/detail/{usersId}")
    private String detail(@PathVariable("usersId") Integer usersId, Model model) {
        Users users = userService.getById(usersId);
        model.addAttribute("users", users);
        model.addAttribute("listStaffCskh", staffCskhService.getAllStaffCskh());
        model.addAttribute("listStaff", staffService.getAllStaff());
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        return "/Users/detailUser";
    }

    @GetMapping("/delete/{usersId}")
    private String delete(@PathVariable("usersId") Integer usersId) {
        Users users = userService.getById(usersId);
        userService.deleteUser(users);
        return "redirect:/user";
    }

    private String generateMaUsers() {
        int count = 0;
        int maxMa = maxMaUsers();
        count = maxMa + 1;
        String maMoi = String.format("MT%06d", count);
        return maMoi;
    }

    private int maxMaUsers() {
        int maxMa = 0;
        List<Users> list = userService.getAllUser();
        for (Users us : list) {
            int maHienTai = Integer.parseInt(us.getUsersCode().substring(2));
            if (maHienTai > maxMa) {
                maxMa = maHienTai;
            }
        }
        return maxMa;
    }
}
