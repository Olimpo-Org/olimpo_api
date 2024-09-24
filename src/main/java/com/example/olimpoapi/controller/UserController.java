package com.example.olimpoapi.controller;

//import com.example.olimpoapi.model.postgresql;
//import com.example.olimpoapi.service.UserService;


//@RestController
//@RequestMapping("/v1/user")
//public class UserController {
//    private final UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody Login login) {
//            return ResponseEntity.ok().body(
//                    userService.login(login)
//            );
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity save(@RequestBody User user) {
//            return ResponseEntity.ok().body(
//                    userService.save(user)
//            );
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity getAll() {
//            return ResponseEntity.ok().body(
//                    userService.getAll()
//            );
//    }
//    @GetMapping("/get/{id}")
//    public ResponseEntity getById(@PathVariable String id) {
//            return ResponseEntity.ok().body(
//                    userService.getById(id)
//            );
//    }
//}
