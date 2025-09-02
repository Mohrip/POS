package in.mohrip.POSSOFTWARE.service;

import in.mohrip.POSSOFTWARE.entity.CategoryEntity;
import in.mohrip.POSSOFTWARE.io.CategoryRequest;
import in.mohrip.POSSOFTWARE.io.CategoryResponse;
import in.mohrip.POSSOFTWARE.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service.*;
import in.mohrip.POSSOFTWARE.service.CategoryService;

import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService  {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse add(CategoryRequest request) {
        CategoryEntity newCategory = convertToEntity(request);
       newCategory= categoryRepository.save(newCategory);
      return convertToResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> read() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> convertToResponse(categoryEntity))
                .collect(Collectors.toList());
    }


    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
       return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
               .imageUrl(newCategory.getImageUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
       return  CategoryEntity.builder()
                 .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }
}
