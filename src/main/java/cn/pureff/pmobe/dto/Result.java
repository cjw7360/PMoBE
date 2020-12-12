package cn.pureff.pmobe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private T result;

    public static <T> Result<T> ok(T result) {
        return Result.of(result);
    }

    public static <T> Result<T> of(T result) {

        return new Result<>(result);
    }
}
