package com.sahil1.demo.controller;

import com.sahil1.demo.annotation.Permission;
import com.sahil1.demo.enums.LogicEnum;
import com.sahil1.demo.enums.PermissionsEnum;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Permission(permissions = {PermissionsEnum.AllowRead, PermissionsEnum.AllowWrite}, type = LogicEnum.All)
    @GetMapping("/{id}")
    public String getBook(@PathVariable int id, @RequestParam(value = "num") Optional<Integer> num) {
        System.out.println(num);
        return "hello";
    }
}
