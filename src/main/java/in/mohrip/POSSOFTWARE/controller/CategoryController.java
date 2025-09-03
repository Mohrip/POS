package in.mohrip.POSSOFTWARE.controller;

import in.mohrip.POSSOFTWARE.io.CategoryRequest;
import in.mohrip.POSSOFTWARE.io.CategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import in.mohrip.POSSOFTWARE.service.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request) {
        return categoryService.add(request);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.read();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{categoryId}")
    public void remove(@PathVariable String categoryId) {
        categoryService.delete(categoryId);


    }
}




