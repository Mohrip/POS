package in.mohrip.POSSOFTWARE.service;

import in.mohrip.POSSOFTWARE.io.CategoryRequest;
import in.mohrip.POSSOFTWARE.io.CategoryResponse;


import java.util.List;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);

    List<CategoryResponse> read();
}
