package br.com.fiap.mymovie.movie;

import jakarta.validation.constraints.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message ="{movie.title.notblank}")
    private String title;

    private String gender;

    private LocalDate dateWatched;

    @NotNull(message = "{movie.rating.notnull}")
    @Min(value =1, message="{movie.rating.min}")
    @Max(value = 5, message="{movie.rating.max}")
    public int rating;

}
