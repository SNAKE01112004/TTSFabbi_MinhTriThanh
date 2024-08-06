package com.example.demo.controller;

import com.example.demo.entity.Chapters;
import com.example.demo.entity.Courses;
import com.example.demo.exception.CoursesStatus;
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
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ChapterService chapterService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    CoursesClassifyService coursesClassifyService;


    @GetMapping()
    private String view_Home(Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);

        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Courses> coursesPage = coursesService.getAllListCoursesByDeleted(pageable);

        int totalElement = (int) coursesPage.getTotalElements();
        int begin = currentPage * pageSize + 1;
        int end = Math.min((currentPage + 1) * pageSize, totalElement);

        model.addAttribute("totalPage", coursesPage.getTotalPages());
        model.addAttribute("begin", begin);
        model.addAttribute("number", currentPage);
        model.addAttribute("end", end);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("listCourses", coursesPage.getContent());
        return "/Courses/courses";
    }

    @PostMapping("/update-status/{coursesId}")
    private String updateStatus(@PathVariable("coursesId") Integer coursesId,
                                @RequestParam("status") int status, Model model) {

        Courses courses = coursesService.getById(coursesId);
        if (courses != null) {
            CoursesStatus coursesStatus = CoursesStatus.fromCode(status);
            courses.setCoursesStatus(coursesStatus.getCode());
            coursesService.updateCourses(courses);
        }
        return "redirect:/courses";
    }

    @PostMapping("/update-delete-flag/{coursesId}")
    private String updateDeletedFlag(@PathVariable("coursesId") Integer coursesId,
                                     @RequestParam("deletedFlag") Integer deletedFlag, Model model) {
        Courses courses = coursesService.getById(coursesId);
        if(courses != null){
            coursesService.updateDeletedFlag(coursesId,deletedFlag);
        }
        return "redirect:/courses";
    }

    @GetMapping("/view-create")
    public String viewAddCourses(Model model) {
        model.addAttribute("courses", new Courses());
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        model.addAttribute("listCoursesClassify", coursesClassifyService.getAllCoursesClassify());
        return "/Courses/createCourses";
    }

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @PostMapping("/add")
    public String addCourses(@Valid @ModelAttribute("courses") Courses courses,
                             BindingResult result,
                             @RequestParam("program-cost") String programCost,
                             @RequestParam("file") MultipartFile file,
                             @RequestParam("fileVd") MultipartFile fileVd,
                             Model model) {
        String imagePath = null;
        String videoPath = null;

        if (!file.isEmpty()) {
            try {
                String orgName = file.getOriginalFilename();
                String name = orgName.substring(orgName.lastIndexOf("\\") + 1);
                Path uploadDir = Paths.get("src/main/resources/static/uploads");
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }
                imagePath = "/uploads/" + name;
                Path filePath = uploadDir.resolve(name);
                file.transferTo(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!fileVd.isEmpty()) {
            try {
                String orgNameVd = fileVd.getOriginalFilename();
                String nameVd = orgNameVd.substring(orgNameVd.lastIndexOf("\\") + 1);
                Path uploadDirVd = Paths.get("src/main/resources/static/uploads/videos");
                if (!Files.exists(uploadDirVd)) {
                    Files.createDirectories(uploadDirVd);
                }
                videoPath = "/uploads/videos/" + nameVd;
                Path filePathVd = uploadDirVd.resolve(nameVd);
                fileVd.transferTo(filePathVd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        courses.setCoursesImage(imagePath);
        courses.setCoursesVideo(videoPath);

        if ("free".equals(programCost)) {
            courses.setEfectiveDurationMoney(BigDecimal.ZERO); // Set to 0 for free program
        }
        courses.setDeletedFlag(0);
        coursesService.addCourses(courses);
        return "redirect:/courses";
    }

    @GetMapping("/detail/{coursesId}")
    private String detail(@PathVariable("coursesId") Integer coursesId,
                          Model model) {
        Courses courses = coursesService.getById(coursesId);
        model.addAttribute("chapter", new Chapters());
        model.addAttribute("listChapter", chapterService.findByCoursesId(coursesId));
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        model.addAttribute("listCoursesClassify", coursesClassifyService.getAllCoursesClassify());

        return "redirect:/courses/detail/" + coursesId + "/chapter";
    }

    @GetMapping("/search")
    private String searchCourses(@RequestParam("keyword") String keyword, Model model) {
        List<Courses> coursesList;
        if (keyword == null && keyword.isEmpty()) {
            coursesList = coursesService.GetAllCourses();
            model.addAttribute("listCourses", coursesList);
        } else {
            coursesList = coursesService.searchByCoursesName(keyword);
            model.addAttribute("listCourses", coursesList);
        }
        if (coursesList.isEmpty()) {
            System.out.println("No data found for usersCode: " + keyword);
            model.addAttribute("emptyData", "Không có dữ liệu");
        } else {
            System.out.println("Found " + coursesList.size() + " records for usersCode: " + keyword);
        }
        return "/Courses/courses";
    }

    @GetMapping("/filter")
    public String filterCourses(@RequestParam("type") int type, Model model) {
        List<Courses> coursesList = coursesService.findCoursesByType(type);
        model.addAttribute("listCourses", coursesList);
        model.addAttribute("totalElement", coursesList.size());
        model.addAttribute("emptyData", coursesList.isEmpty() ? "Không có dữ liệu" : null);
        return "/Courses/courses";
    }

    @GetMapping("/delete/{coursesId}")
    private String delete(@PathVariable("coursesId") Integer coursesId) {
        Courses courses = coursesService.getById(coursesId);
        coursesService.deleteCourses(courses);
        return "redirect:/courses";
    }
}
