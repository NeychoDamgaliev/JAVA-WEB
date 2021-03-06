package fdmc.domain.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Neycho Damgaliev on 2/17/2019.
 */
public class CatCreateBindingModel {
    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String gender;
    private BigDecimal price;
    private Date addedOn;
    private Boolean hasPassport;

    public CatCreateBindingModel() {
    }

    @NotNull
    @Length(min = 2, max = 10)
    public String getName() {
        return name;
    }

    @NotNull
    @Length(min = 5, max = 20)
    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    @NotNull
    @Min(value = 1)
    @Max(value = 31)
    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @NotNull
    @DecimalMin(value = "0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public Boolean getHasPassport() {
        return hasPassport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public void setHasPassport(Boolean hasPassport) {
        this.hasPassport = hasPassport;
    }
}
