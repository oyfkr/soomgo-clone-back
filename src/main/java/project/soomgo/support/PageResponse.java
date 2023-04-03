package project.soomgo.support;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Getter
@NoArgsConstructor
public class PageResponse<T> {

    @ApiModelProperty(value = "현재 페이지 수", example = "2")
    private long page;
    @ApiModelProperty(value = "전체 페이지 수", example = "3")
    private long totalPages;
    @ApiModelProperty(value = "전체 데이터 수", example = "100")
    private long totalElements;
    @ApiModelProperty(value = "현재 데이터 개수", example = "5")
    private long size;
    @ApiModelProperty(value = "내용")
    private List<T> content;

    public static PageResponse of(Pageable pageable, long totalElements, List content){
        PageResponse instance = new PageResponse();

        instance.page = pageable.getPageNumber() + 1;
        instance.size = content.size();
        instance.totalElements = totalElements;
        instance.totalPages = (long) Math.ceil((double) totalElements/pageable.getPageSize());
        instance.content = content;

        return instance;
    }
}
