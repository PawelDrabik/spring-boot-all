package app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(value = "Basic startup controller", description = "Registration menu is initialized")
public class MainController {

    @ApiOperation(value = "Opens a registration page", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully opened registration page"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/registration")
    public String index() {
        return "index";
    }
}
