package MicroservicioCasas.domain.model;

import MicroservicioCasas.domain.exceptions.DescriptionMaxSizeExceededException;
import MicroservicioCasas.domain.exceptions.NameMaxSizeExceededException;
import MicroservicioCasas.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class CategoryModel {
    private final Long id;
    private String name;
    private String description;


    public CategoryModel(Long id, String name, String description) {
        if (name.length() > 50) throw new NameMaxSizeExceededException();
        if (description.length() > 90) throw new DescriptionMaxSizeExceededException();
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 50) throw new NameMaxSizeExceededException();
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 90) throw new DescriptionMaxSizeExceededException();
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }
}
