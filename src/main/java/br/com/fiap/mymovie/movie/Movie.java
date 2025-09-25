package br.com.fiap.mymovie.movie;

import br.com.fiap.mymovie.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @ManyToOne
    private User user;

}
