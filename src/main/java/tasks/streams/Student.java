package tasks.streams;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;
    private Gender gender;
    private float averageScore;
}
