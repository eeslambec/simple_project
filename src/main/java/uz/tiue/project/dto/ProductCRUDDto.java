package uz.tiue.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductCRUDDto {
    private String name;
    private String description;
    private Double price;
}
