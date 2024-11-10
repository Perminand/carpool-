package ru.perminov.carpool.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.perminov.carpool.dto.users.UserDto;
import ru.perminov.carpool.dto.users.UserDtoOut;
import ru.perminov.carpool.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/apps")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new-user")
    public UserDtoOut create(@Valid @RequestBody UserDto userDto) {
        log.info("Пришел POST запрос {}", userDto);
        return userService.create(userDto);
    }

    @GetMapping("/users")
    public List<UserDtoOut> getAll() {
        log.info("Пришел GET запрос на получения списка пользователей");
        return userService.getAll();
    }

}
